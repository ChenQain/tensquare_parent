package com.tensquare.article.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel("文章")
@TableName("tb_article")
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColumnid() {
        return columnid;
    }

    public void setColumnid(String columnid) {
        this.columnid = columnid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getIspublic() {
        return ispublic;
    }

    public void setIspublic(String ispublic) {
        this.ispublic = ispublic;
    }

    public String getIstop() {
        return istop;
    }

    public void setIstop(String istop) {
        this.istop = istop;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public Integer getThumbup() {
        return thumbup;
    }

    public void setThumbup(Integer thumbup) {
        this.thumbup = thumbup;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", columnid='" + columnid + '\'' +
                ", userid='" + userid + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", ispublic='" + ispublic + '\'' +
                ", istop='" + istop + '\'' +
                ", visits=" + visits +
                ", thumbup=" + thumbup +
                ", comment=" + comment +
                ", state='" + state + '\'' +
                ", channelid='" + channelid + '\'' +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}