package com.tensquare.notice.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tensquare.notice.pojo.Notice;
import org.springframework.stereotype.Repository;

/**
 * NoticeDao
 *
 * @Author : eden 2020-11-18 18:58
 */
@Repository
public interface NoticeDao extends BaseMapper<Notice> {
}
