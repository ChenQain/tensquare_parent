package com.tensquare.article.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Eden
 */
@ApiModel("文章")
@TableName("tb_article")
@Data
public class Article implements Serializable {

    @ApiModelProperty("ID")
    @TableId(type = IdType.INPUT)
    private String id;

    @ApiModelProperty("专栏ID")
    private String columnid;

    @ApiModelProperty("用户ID")
    private String userid;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("文章正文")
    private String content;

    @ApiModelProperty("文章封面")
    private String image;

    @ApiModelProperty("修改日期")
    private Date createtime;

    @ApiModelProperty("ID")
    private Date updatetime;

    @ApiModelProperty("是否公开")
    private String ispublic;

    @ApiModelProperty("是否置顶")
    private String istop;

    @ApiModelProperty("浏览量")
    private Integer visits;

    @ApiModelProperty("点赞数")
    private Integer thumbup;

    @ApiModelProperty("评论数")
    private Integer comment;

    @ApiModelProperty("审核状态")
    private String state;

    @ApiModelProperty("所属频道")
    private String channelid;

    @ApiModelProperty("URL")
    private String url;

    @ApiModelProperty("类型")
    private String type;

}