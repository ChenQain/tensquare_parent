package com.tensquare.notice.client;

import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ArticleClient
 *
 * @Author : eden 2020-11-27 11:08
 */
@FeignClient(value = "tensquare-article")
public interface ArticleClient {
    /**
     * 根据ID查询文章
     *
     * @param articleId 文章id
     * @return 查询结果
     */
    @RequestMapping(value = "/article/{articleId}", method = RequestMethod.GET)
    Result findById(@PathVariable("articleId") String articleId);
}
