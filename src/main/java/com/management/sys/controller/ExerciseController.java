package com.management.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.management.common.vo.Result;
import com.management.sys.entity.Exercise;
import com.management.sys.service.IExerciseService;
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
@RequestMapping("/sys/exercise")
public class ExerciseController {
    @Autowired
    IExerciseService exerciseService;

    /**
     *
     * 功能描述: ADD
     * @param: BodyFatPercentage
     * @return: String
     * @auther: Fei Guan
     */
    @PostMapping
    public Result<?> addExercise(@RequestBody Exercise exercise){
        exerciseService.save(exercise);
        return Result.success(exercise,"Add Success!");
    }

    /**
     *
     * 功能描述: update
     * @param:
     * @return:
     * @auther: Xiaoyang Yu
     */
    @PutMapping
    public Result<?> updateExercise(@RequestBody Exercise exercise){
        exerciseService.updateById(exercise);
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
    public Result<Exercise> getExerciseById(@PathVariable("id") Integer id){
        Exercise exercise = exerciseService.getById(id);
        return Result.success(exercise);
    }

    /**
     *
     * 功能描述: Search
     * @param:
     * @return:
     * @auther: Xiaoyang Yu
     */
    @GetMapping("/list")
    public Result<Map<String, Object>> getExerciseList(@RequestParam(value = "uid", required = false) Integer uid,
                                                                @RequestParam(value = "pageNo") Long pageNo,
                                                                @RequestParam(value = "pageSize") Long pageSize){
        //查询
        LambdaQueryWrapper<Exercise> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(uid > 0, Exercise::getUid, uid);
        //按ID排序
        wrapper.orderByDesc(Exercise::getId);

        Page<Exercise> page = new Page<>(pageNo, pageSize);

        exerciseService.page(page, wrapper);
        Map<String, Object> data = new HashMap<>();
        data.put("total", page.getTotal());
        data.put("rows", page.getRecords());
        return Result.success(data);
    }
}
