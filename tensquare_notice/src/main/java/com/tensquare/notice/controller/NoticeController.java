package com.tensquare.notice.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.notice.pojo.Notice;
import com.tensquare.notice.pojo.NoticeFresh;
import com.tensquare.notice.service.NoticeService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * NoticeController
 *
 * @Author : eden 2020-11-18 19:03
 */
@RestController
@RequestMapping("notice")
@CrossOrigin
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    /**
     * 根据id查询消息通知
     *
     * @param id 消息id
     * @return 查询结果
     */
    @GetMapping("{id}")
    public Result selectById(@PathVariable String id) {
        Notice notice = noticeService.selectById(id);
        return new Result(true, StatusCode.OK, "查询成功", notice);
    }

    /**
     * 根据条件分页查询消息通知
     *
     * @param notice 条件
     * @param page   页码
     * @param size   每页条数
     * @return 查询结果
     */
    @PostMapping("search/{page}/{size}")
    public Result selectByList(@RequestBody Notice notice,
                               @PathVariable Integer page,
                               @PathVariable Integer size) {
        Page<Notice> pageData = noticeService.selectByPage(notice, page, size);

        PageResult<Notice> pageResult = new PageResult<>(
                pageData.getTotal(), pageData.getRecords()
        );

        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }

    /**
     * 新增通知
     *
     * @param notice 通知
     * @return 新增结果
     */
    @PostMapping
    public Result save(@RequestBody Notice notice) {
        noticeService.save(notice);
        return new Result(true, StatusCode.OK, "新增成功");
    }

    /**
     * 修改通知
     *
     * @param notice 通知
     * @return 修改结果
     */
    @PutMapping
    public Result updateById(@RequestBody Notice notice) {
        noticeService.updateById(notice);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 根据用户id查询该用户的待推送消息（新消息）
     *
     * @param userId 用户id
     * @param page   页码
     * @param size   每页条数
     * @return 查询结果
     */
    @GetMapping("fresh/{userId}/{page}/{size}")
    public Result freshPage(@PathVariable String userId,
                            @PathVariable Integer page,
                            @PathVariable Integer size) {
        Page<NoticeFresh> pageData = noticeService.freshPage(userId, page, size);

        PageResult<NoticeFresh> pageResult = new PageResult<>(
                pageData.getTotal(), pageData.getRecords()
        );

        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }

    /**
     * 删除待推送消息（新消息）
     *
     * @param noticeFresh
     * @return
     */
    @RequestMapping(value = "fresh", method = RequestMethod.DELETE)
    public Result freshDelete(@RequestBody NoticeFresh noticeFresh) {
        noticeService.freshDelete(noticeFresh);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
