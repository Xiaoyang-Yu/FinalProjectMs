package com.management.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.management.API.GptAPI;
import com.management.common.vo.Result;
import com.management.sys.entity.Diet;
import com.management.sys.entity.User;
import com.management.sys.service.IDietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Xiaoyang
 * @since 2023-04-28
 */
@RestController
@RequestMapping("/sys/diet")
public class DietController {
    @Autowired
    IDietService dietService;
    /**
     *
     * 功能描述: Search
     * @param:
     * @return:
     * @auther: Xiaoyang Yu
     */
    @GetMapping("/list")
    public Result<Map<String, Object>> getDietList(@RequestParam(value = "userId", required = false) String userId,
                                                   @RequestParam(value = "pageNo") Long pageNo,
                                                   @RequestParam(value = "pageSize") Long pageSize){
        //查询
        LambdaQueryWrapper<Diet> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.hasLength(userId), Diet::getUserId, userId);
        //按ID排序
        wrapper.orderByDesc(Diet::getDietId);

        Page<Diet> page = new Page<>(pageNo, pageSize);

        dietService.page(page, wrapper);
        Map<String, Object> data = new HashMap<>();
        data.put("total", page.getTotal());
        data.put("rows", page.getRecords());
        return Result.success(data);
    }

    /**
     *
     * 功能描述: ADD
     * @param: Diet
     * @return: String
     * @auther: Fei Guan
     */
    @PostMapping
    public Result<?> addDiet(@RequestBody Diet diet){
        dietService.save(diet);
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
    public Result<?> updateDiet(@RequestBody Diet diet){
        dietService.updateById(diet);
        return Result.success("Update Success!");
    }
    /**
     *
     * 功能描述:  delete
     * @param:
     * @return:
     * @auther: Xiaoyang Yu
     */
    @DeleteMapping("/{id}")
    public Result<User> deleteDiet(@PathVariable("id") Integer dietId){
        dietService.removeById(dietId);
        return Result.success("Deleted");
    }
    /**
     *
     * 功能描述: get role information by id
     * @param:
     * @return:
     * @auther: Xiaoyang Yu
     */
    @GetMapping("/{id}")
    public Result<Diet> getDietById(@PathVariable("id") Integer dietId){
        Diet diet = dietService.getById(dietId);
        return Result.success(diet);
    }

    @GetMapping("/gptAPI")
    public Result<?> gptAPI(@RequestParam(value = "prompt") String prompt) throws Exception {
        GptAPI ga = new GptAPI();
        prompt += "in each meal,detailed information has breakfast,lunch,dinner,names of food,food units,protein grams,carbohydrates grams,fat grams,fiber grams,sodium grams,and calories.output must lower case [{meal:breakfast,details:[{name:'egg',fat='6g'}]...}]";
        String re = ga.GptResult(prompt);
        return Result.success(re,prompt);
    }
}
