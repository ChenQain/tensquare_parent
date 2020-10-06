package com.tensquare.article;

import com.tensquare.article.pojo.Comment;
import entity.Result;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * CommentControllerTest
 *
 * @Author : eden 2020-10-06 18:31
 */

public class CommentControllerTest {

    RestTemplate restTemplate = new RestTemplate();

    String localPath = "http://127.0.0.1:9004/comment";

    @Test
    public void testFindById() {
        String url = localPath + "/1";
        Result response = restTemplate.getForEntity(url, Result.class).getBody();
        System.out.println(response);
    }

    @Test
    public void testFindAll() {
        String url = localPath;
        Result response = restTemplate.getForEntity(url, Result.class).getBody();
        System.out.println(response);
    }

    @Test
    public void testSave() {
        String url = localPath;

        //设置请求体
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("articleid", "1");
        requestMap.put("content", "测试新增评论");
        requestMap.put("userid", "1");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestMap, httpHeaders);

        Result response = restTemplate.postForEntity(url, requestEntity, Result.class).getBody();

        System.out.println(response);
    }

    @Test
    public void testUpdate() {
        String url = localPath + "/1313436550742282240";

        Comment comment = new Comment();
        comment.setArticleid("2");
        comment.setContent("测试修改内容");

        restTemplate.put(url, comment);
    }

    @Test
    public void testDeleteById() {
        String url = localPath + "/1313436550742282240";
        restTemplate.delete(url);
    }

    @Test
    public void testFindByArticleId() {
        String url = localPath + "/article/1";
        Result response = restTemplate.getForEntity(url, Result.class).getBody();
        System.out.println(response);
    }

    @Test
    public void testThumbup() {
        String url = localPath + "/thumbup/1";
        restTemplate.put(url, null);
    }
}
