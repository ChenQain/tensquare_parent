package com.tensquare.notice.pojo;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * NoticeFresh
 *
 * @Author : eden 2020-11-18 17:08
 */
@TableName("tb_notice_fresh")
@Data
public class NoticeFresh {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 消息ID
     */
    private String noticeId;
}