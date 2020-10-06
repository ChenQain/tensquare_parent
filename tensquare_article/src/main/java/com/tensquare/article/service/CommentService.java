package com.tensquare.article.service;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * CommentService
 *
 * @Author : eden 2020-10-06 16:13
 */
@Service
public class CommentService {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CommentRepository commentRepository;

    /**
     * 根据ID查询评论
     *
     * @param id 评论ID
     * @return 评论
     */
    public Comment findById(String id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        return commentOptional.orElse(null);
    }

    /**
     * 查询所有评论
     *
     * @return 评论集合
     */
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    /**
     * 保存评论
     *
     * @param comment 评论
     */
    public void save(Comment comment) {
        String id = idWorker.nextId() + "";
        comment.set_id(id);

        //初始化数据
        comment.setPublishdate(new Date());
        comment.setThumbup(0);
        commentRepository.save(comment);
    }

    /**
     * 修改评论
     *
     * @param comment 评论
     */
    public void update(Comment comment) {
        commentRepository.save(comment);
    }

    /**
     * 根据评论ID删除评论
     *
     * @param id 评论ID
     */
    public void deleteById(String id) {
        commentRepository.deleteById(id);
    }

    /**
     * 根据文章ID查询评论
     *
     * @param articleId 文章ID
     * @return 评论集合
     */
    public List<Comment> findByArticleId(String articleId) {
        return commentRepository.findByArticleid(articleId);


    }

    /**
     * 评论点赞
     *
     * @param id 评论ID
     */
    public void thumbup(String id) {
        //修改条件
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        //修改的数据
        Update update = new Update();
        //在原来的基础上加一
        update.inc("thumbup", 1);
        mongoTemplate.updateFirst(query, update, "comment");
    }
}
