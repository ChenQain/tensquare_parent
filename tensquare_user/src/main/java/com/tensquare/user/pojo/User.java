package com.tensquare.user.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * User
 *
 * @Author : eden 2020-10-07 15:38
 */
@ApiModel("用户")
@TableName("tb_user")
@Data
public class User implements Serializable {

    @ApiModelProperty("ID")
    @TableId(type = IdType.INPUT)
    private String id;

    @ApiModelProperty("手机号码")
    private String mobile;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("出生年月日")
    private Date birthday;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("注册日期")
    private Date regdate;

    @ApiModelProperty("更新日期")
    private Date updatedate;

    @ApiModelProperty("最后登录日期")
    private Date lastdate;

    @ApiModelProperty("在线时长(分钟)")
    private Long online;

    @ApiModelProperty("兴趣")
    private String interest;

    @ApiModelProperty("个性")
    private String personality;

    @ApiModelProperty("粉丝数")
    private Integer fanscount;

    @ApiModelProperty("关注数")
    private Integer followcount;
}
