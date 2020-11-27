package com.tensquare.notice.client;

import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * UserClient
 *
 * @Author : eden 2020-11-27 11:09
 */
@FeignClient(value = "tensquare_user")
public interface UserClient {
    /**
     * 根据ID查询用户
     *
     * @param id 用户id
     * @return 查询结果
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    Result findById(@PathVariable("id") String id);
}
