package com.management.sys.controller;

import com.management.common.vo.Result;
import com.management.sys.entity.BodyFatPercentage;
import com.management.sys.entity.Diet;
import com.management.sys.service.IBodyFatPercentageService;
import com.management.sys.service.IDietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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
}
