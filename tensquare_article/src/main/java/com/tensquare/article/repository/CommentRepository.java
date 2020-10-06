package com.tensquare.article.repository;

import com.tensquare.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * CommentRepository
 *
 * @Author : eden 2020-10-06 16:10
 */
public interface CommentRepository extends MongoRepository<Comment, String> {
    /**
     * 根据文章ID查询评论集合
     * @param articleId 文章ID
     * @return 评论集合
     */
    List<Comment> findByArticleid(String articleId);
}
