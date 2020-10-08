package com.tensquare.user.test;

import entity.Result;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

/**
 * UserControllerTest
 *
 * @Author : eden 2020-10-07 19:18
 */
public class UserControllerTest {

    RestTemplate restTemplate = new RestTemplate();

    String localPath = "http://127.0.0.1:9008/user";

    @Test
    public void testSelectById() {
        String url = localPath + "/1";
        Result response = restTemplate.getForEntity(url, Result.class).getBody();
        System.out.println(response);
    }
}
