package com.management.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.management.common.vo.Result;
import com.management.sys.entity.Course;
import com.management.sys.service.ICourseService;
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
@RequestMapping("/sys/course")
public class CourseController {
    @Autowired
    ICourseService courseService;

    /**
     *
     * 功能描述: ADD
     * @param: Course
     * @return: String
     * @auther: Fei Guan
     */
    @PostMapping
    public Result<?> addDiet(@RequestBody Course diet){
        courseService.save(diet);
        return Result.success(diet,"Add Success!");
    }

    /**
     *
     * 功能描述: update
     * @param:
     * @return:
     * @auther: Xiaoyang Yu
     */
    @PutMapping
    public Result<?> updateDiet(@RequestBody Course diet){
        courseService.updateById(diet);
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
    public Result<Course> getDietById(@PathVariable("id") Integer id){
        Course diet = courseService.getById(id);
        return Result.success(diet);
    }

    /**
     *
     * 功能描述: Search
     * @param:
     * @return:
     * @auther: Xiaoyang Yu
     */
    @GetMapping("/list")
    public Result<Map<String, Object>> getDietList(@RequestParam(value = "uid", required = false) Integer uid,
                                                   @RequestParam(value = "pageNo") Long pageNo,
                                                   @RequestParam(value = "pageSize") Long pageSize){
        //查询
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(uid > 0, Course::getUid, uid);
        //按ID排序
        wrapper.orderByDesc(Course::getId);

        Page<Course> page = new Page<>(pageNo, pageSize);

        courseService.page(page, wrapper);
        Map<String, Object> data = new HashMap<>();
        data.put("total", page.getTotal());
        data.put("rows", page.getRecords());
        return Result.success(data);
    }
}
