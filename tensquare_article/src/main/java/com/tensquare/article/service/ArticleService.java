package com.tensquare.article.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Page<Article> findByPage(Map<String, Object> map, Integer page, Integer size) {
        //设置查询条件
        EntityWrapper<Article> wrapper = new EntityWrapper<>();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            // if (map.get(key) != null) {
            //     wrapper.eq(key, map.get(key));
            // }

            //第一个参数是否把后面的条件加入到查询条件中
            //和上面的if判断的写法是一样的效果，实现动态sql
            wrapper.eq(map.get(key) != null, key, map.get(key));
        }

        //设置分页参数
        Page<Article> pageData = new Page<>(page, size);

        //执行查询
        //第一个是分页参数，第二个是查询条件
        List<Article> list = articleDao.selectPage(pageData, wrapper);

        pageData.setRecords(list);

        //返回
        return pageData;
    }
}