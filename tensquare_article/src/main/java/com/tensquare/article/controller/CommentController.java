package com.tensquare.article.controller;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.service.CommentService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CommentController
 *
 * @Author : eden 2020-10-06 16:18
 */
@Api("文章评论")
@RestController
@RequestMapping("comment")
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation("根据id查询评论")
    @GetMapping("{id}")
    public Result findById(@PathVariable String id) {
        Comment comment = commentService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功", comment);
    }

    @ApiOperation("查询所有")
    @GetMapping
    public Result findAll() {
        List<Comment> list = commentService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @ApiOperation("新增")
    @PostMapping
    public Result save(@RequestBody Comment comment) {
        commentService.save(comment);
        return new Result(true, StatusCode.OK, "新增成功");
    }

    @ApiOperation("修改")
    @PutMapping("{id}")
    public Result update(@PathVariable String id, @RequestBody Comment comment) {
        comment.set_id(id);
        commentService.update(comment);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @ApiOperation("删除")
    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable String id) {
        commentService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @ApiOperation("根据文章ID查询评论")
    @GetMapping("article/{articleId}")
    public Result findByArticleId(@PathVariable String articleId) {
        List<Comment> comments = commentService.findByArticleId(articleId);
        return new Result(true, StatusCode.OK, "查询成功", comments);
    }

    @ApiOperation("评论点赞")
    @PutMapping("thumbup/{id}")
    public Result thumbup(@PathVariable String id) {

        //模拟获取到了用户id
        String userid = "123";

        //在redis中查询用户是否已经点赞
        Object result = redisTemplate.opsForValue().get("thumbup_" + userid + "_" + id);

        //如果点赞不能重复点赞
        if (result != null) {
            return new Result(false, StatusCode.REMOTE_ERROR, "不能重复点赞");
        }

        //如果没有点赞，可以进行点赞操作
        commentService.thumbup(id);

        //保存点赞记录
        redisTemplate.opsForValue().set("thumbup_" + userid + "_" + id, 1);

        return new Result(true, StatusCode.OK, "点赞成功");
    }
}
