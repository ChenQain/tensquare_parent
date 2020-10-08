package com.tensquare.user.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tensquare.user.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * UserDao
 *
 * @Author : eden 2020-10-07 15:53
 */
@Repository
public interface UserDao extends BaseMapper<User> {
}
