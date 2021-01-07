package com.tensquare.article.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ArticleService
 *
 * @Author : eden 2020-09-30 16:17
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询所有
     *
     * @return 文章集合
     */
    public List<Article> findAll() {
        return articleDao.selectList(null);
    }

    /**
     * 根据文章ID查询文章
     *
     * @param id 文章ID
     * @return 文章
     */
    public Article findById(String id) {
        return articleDao.selectById(id);
    }

    /**
     * 添加文章
     *
     * @param article 文章
     */
    public void add(Article article) {
        article.setId(idWorker.nextId() + "");
        articleDao.insert(article);
    }

    /**
     * 修改文章
     *
     * @param article 文章
     */
    public void update(Article article) {
        articleDao.updateById(article);
    }

    /**
     * 删除文章
     *
     * @param id 文章ID
     */
    public void delete(String id) {
        articleDao.deleteById(id);
    }

    /**
     * 文章分页条件查询
     *
     * @param map  查询条件
     * @param page 页码
     * @param size 每页数量
     * @return 文章分页集合
     */
    public Page search(Map map, int page, int size) {
        EntityWrapper wrapper = new EntityWrapper<Article>();
        Set<String> fieldSet = map.keySet();
        for (String field : fieldSet) {
            wrapper.eq(null != map.get(field), field, map.get(field));
        }

        Page page1 = new Page(page, size);
        List list = articleDao.selectPage(page1, wrapper);
        page1.setRecords(list);
        return page1;
    }

    /**
     * 订阅或者取消订阅文章作者
     *
     * @param userId    用户id
     * @param articleId 文章id
     * @return Boolean true-订阅 false-取消订阅
     */
    public Boolean subscribe(String userId, String articleId) {
        String authorId = articleDao.selectById(articleId).getUserid();

        String userKey = "article_subscribe_" + userId;
        String authorKey = "article_subscribe_" + userId;

        Boolean flag = redisTemplate.boundSetOps(userKey).isMember(authorId);
        if (flag) {
            redisTemplate.boundSetOps(userKey).remove(authorId);
            redisTemplate.boundSetOps(userKey).remove(authorId);
        } else {
            redisTemplate.boundSetOps(userKey).add(authorId);
            redisTemplate.boundSetOps(userKey).add(authorId);
        }
        return !flag;
    }
}