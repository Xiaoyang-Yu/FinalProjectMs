package com.management.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.management.common.vo.Result;
import com.management.sys.entity.Prompt;
import com.management.sys.service.IPromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Xiaoyang
 * @since 2023-09-09
 */
@RestController
@RequestMapping("/sys/prompt")
public class PromptController {
    @Autowired
    IPromptService promptService;

    /**
     *
     * 功能描述: ADD
     * @param: BodyFatPercentage
     * @return: String
     * @auther: Fei Guan
     */
    @PostMapping
    public Result<?> addPrompt(@RequestBody Prompt prompt){
        promptService.save(prompt);
        return Result.success(prompt,"Add Success!");
    }

    /**
     *
     * 功能描述: update
     * @param:
     * @return:
     * @auther: Xiaoyang Yu
     */
    @PutMapping
    public Result<?> updatePrompt(@RequestBody Prompt prompt){
        promptService.updateById(prompt);
        return Result.success("Update Success!");
    }

    /**
     *
     * 功能描述: get user information by id
     * @param:
     * @return:
     * @auther: Xiaoyang Yu
     */
    @GetMapping("/{id}")
    public Result<Prompt> getPromptById(@PathVariable("id") Integer id){
        Prompt prompt = promptService.getById(id);
        return Result.success(prompt);
    }

    /**
     *
     * 功能描述: Search
     * @param:
     * @return:
     * @auther: Xiaoyang Yu
     */
    @GetMapping("/list")
    public Result<Map<String, Object>> getPromptList(@RequestParam(value = "uid", required = false) Integer uid,
                                                     @RequestParam(value = "pageNo") Long pageNo,
                                                     @RequestParam(value = "pageSize") Long pageSize){
        //查询
        LambdaQueryWrapper<Prompt> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(uid > 0, Prompt::getUid, uid);
        //按ID排序
        wrapper.orderByDesc(Prompt::getId);

        Page<Prompt> page = new Page<>(pageNo, pageSize);

        promptService.page(page, wrapper);
        Map<String, Object> data = new HashMap<>();
        data.put("total", page.getTotal());
        data.put("rows", page.getRecords());
        return Result.success(data);
    }

}
