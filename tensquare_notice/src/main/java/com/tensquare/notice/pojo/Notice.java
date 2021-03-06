package com.tensquare.notice.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Notice
 *
 * @Author : eden 2020-11-18 17:08
 */
@TableName("tb_notice")
@Data
public class Notice implements Serializable {

    /**
     * ID
     */
    @TableId(type = IdType.INPUT)
    private String id;

    /**
     * 接收消息的用户ID
     */
    private String receiverId;

    /**
     * 进行操作的用户ID
     */
    private String operatorId;

    /**
     * 进行操作的用户昵称
     */
    @TableField(exist = false)
    private String operatorName;

    /**
     * 操作类型（评论，点赞等）
     */
    private String action;

    /**
     * 对象类型（评论，点赞等）
     */
    private String targetType;

    /**
     * 对象名称或简介
     */
    @TableField(exist = false)
    private String targetName;

    /**
     * 对象ID
     */
    private String targetId;

    /**
     * 创建日期
     */
    private Date createtime;

    /**
     * 消息类型
     */
    private String type;

    /**
     * 消息状态（0 未读，1 已读）
     */
    private String state;
}
