package com.tensquare.article.client;

import com.tensquare.article.pojo.Notice;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * NoticeClient
 *
 * @Author : eden 2021-01-07 20:39
 */
@FeignClient
public interface NoticeClient {

    /**
     * 添加消息
     *
     * @param notice 消息
     * @return
     */
    @PostMapping("notice")
    public Result add(@RequestBody Notice notice);

}
