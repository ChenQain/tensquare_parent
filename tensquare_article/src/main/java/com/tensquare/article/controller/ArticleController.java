package com.tensquare.article.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 文章
 *
 * @Author : eden 2020-09-30 16:17
 */
@Api(tags = "文章管理")
@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation("查询所有文章")
    @GetMapping
    public Result findAll() {
        List<Article> list = articleService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @ApiOperation("查询文章")
    @GetMapping("/{id}")
    public Result findById(@PathVariable String id) {
        Article article = articleService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功", article);
    }

    @ApiOperation("添加文章")
    @PostMapping
    public Result add(@RequestBody Article article) {
        articleService.add(article);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @ApiOperation("修改文章")
    @PutMapping("{/id}")
    public Result update(@PathVariable String id, @RequestBody Article article) {
        article.setId(id);
        articleService.update(article);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @ApiOperation("删除文章")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        articleService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @ApiOperation("文章分页条件查询")
    @PostMapping(value = "search/{page}/{size}")
    public Result search(@RequestBody Map map, @PathVariable int page, @PathVariable int size) {
        Page page1 = articleService.search(map, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult(page1.getTotal(), page1.getRecords()));
    }

    @ApiOperation("异常")
    @GetMapping(value = "/exception")
    public Result exception() throws Exception {
        throw new Exception("测试统一异常处理");
    }

    /**
     * 订阅或者取消订阅文章作者
     *
     * @param map userId-用户id articleId 文章id
     * @return Boolean true-订阅 false-取消订阅
     */
    @PostMapping("/subscribe")
    public Result subscribe(@RequestBody Map map) {
        //根据文章id，订阅文章作者，返回订阅状态，true表示订阅成功，false表示取消订阅成功
        Boolean flag = articleService.subscribe(map.get("userId").toString(), map.get("articleId").toString());
        if (flag) {
            return new Result(true, StatusCode.OK, "订阅成功");
        } else {
            return new Result(true, StatusCode.OK, "订阅取消");
        }
    }

    @PutMapping("/thumbup/{articleId}")
    public Result thumbup(@PathVariable String articleId) {
        // 模拟用户id
        String userId = "4";
        String key = "thumbup_article_" + userId + "_" + articleId;

        // 查询用户点赞信息，根据用户id及文章id
        Object flag = redisTemplate.opsForValue().get(key);

        // 判断查询到的结果是否为空
        if (flag == null) {
            // 如果为空，表示用户没有被点过赞，可以点赞
            articleService.thumbup(articleId, userId);
            // 点赞成功，保存点赞信息
            redisTemplate.opsForValue().set(key, 1);

            return new Result(true, StatusCode.OK, "点赞成功");
        }
        return new Result(true, StatusCode.OK, "不能重复点赞");
    }

}
