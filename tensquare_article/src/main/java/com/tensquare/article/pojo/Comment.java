package com.tensquare.article.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * 专栏文章评论
 *
 * @Author : eden 2020-10-06 16:05
 */
@ApiModel("专栏文章评论")
@Data
public class Comment implements Serializable {
    @Id
    @ApiModelProperty("ID")
    private String _id;
    @ApiModelProperty("文章ID")
    private String articleid;
    @ApiModelProperty("评论内容")
    private String content;
    @ApiModelProperty("评论人ID")
    private String userid;
    @ApiModelProperty("评论ID")
    private String parentid;
    @ApiModelProperty("评论日期")
    private Date publishdate;
    @ApiModelProperty("点赞数")
    private Integer thumbup;
}
