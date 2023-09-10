package com.management.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.management.common.vo.Result;
import com.management.sys.entity.BodyFatPercentage;
import com.management.sys.service.IBodyFatPercentageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Xiaoyang
 * @since 2023-09-08
 */
@RestController
@RequestMapping("/sys/bodyFatPercentage")
public class BodyFatPercentageController {
    @Autowired
    IBodyFatPercentageService bodyfatpercentageService;


    /**
     *
     * 功能描述: ADD
     * @param: BodyFatPercentage
     * @return: String
     * @auther: Fei Guan
     */
    @PostMapping
    public Result<?> addBodyFatPercentage(@RequestBody BodyFatPercentage bodyfatpercentage){
        bodyfatpercentageService.save(bodyfatpercentage);
        return Result.success(bodyfatpercentage,"Add Success!");
    }

    /**
     *
     * 功能描述: update
     * @param:
     * @return:
     * @auther: Xiaoyang Yu
     */
    @PutMapping
    public Result<?> updateBodyFatPercentage(@RequestBody BodyFatPercentage bodyfatpercentage){
        bodyfatpercentageService.updateById(bodyfatpercentage);
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
    public Result<BodyFatPercentage> getBodyFatPercentageById(@PathVariable("id") Integer id){
        BodyFatPercentage bodyfatpercentage = bodyfatpercentageService.getById(id);
        return Result.success(bodyfatpercentage);
    }

    /**
     *
     * 功能描述: Search
     * @param:
     * @return:
     * @auther: Xiaoyang Yu
     */
    @GetMapping("/list")
    public Result<Map<String, Object>> getBodyFatPercentageList(@RequestParam(value = "uid", required = false) Integer uid,
                                                   @RequestParam(value = "pageNo") Long pageNo,
                                                   @RequestParam(value = "pageSize") Long pageSize){
        //查询
        LambdaQueryWrapper<BodyFatPercentage> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(uid > 0, BodyFatPercentage::getUid, uid);
        //按ID排序
        wrapper.orderByDesc(BodyFatPercentage::getId);

        Page<BodyFatPercentage> page = new Page<>(pageNo, pageSize);

        bodyfatpercentageService.page(page, wrapper);
        Map<String, Object> data = new HashMap<>();
        data.put("total", page.getTotal());
        data.put("rows", page.getRecords());
        return Result.success(data);
    }
}
