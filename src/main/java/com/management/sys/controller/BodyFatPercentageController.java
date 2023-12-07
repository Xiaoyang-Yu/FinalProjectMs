package com.management.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.management.API.Recommend;
import com.management.API.RecommendNew;
import com.management.common.vo.Result;
import com.management.sys.entity.*;
import com.management.sys.service.IBodyFatPercentageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    @GetMapping("/recommendList")
    public Result<Map<String, Object>> getBMPinfo(@RequestParam(value = "username") String username){
        Map<String, Object> data = new HashMap<>();

        List<v_Recommend> vRecommendList = bodyfatpercentageService.getBFP(0);
            List<Person> users = new ArrayList<>();
            for (v_Recommend vRecommend : vRecommendList) {
                List<Attributes> attributes = new ArrayList<>();
                attributes.add(new Attributes("height", vRecommend.getHeight()));
                attributes.add(new Attributes("weight", vRecommend.getWeight()));
                attributes.add(new Attributes("bfp", vRecommend.getBfp()));
                attributes.add(new Attributes("bmi", vRecommend.getBmi()));
                attributes.add(new Attributes("age", vRecommend.getAge()));
                attributes.add(new Attributes("sex", vRecommend.getSex()));
                attributes.add(new Attributes("workType", vRecommend.getWorkType()));
                attributes.add(new Attributes("isVegetarian", vRecommend.getIsVegetarian()));
                attributes.add(new Attributes("allergens", vRecommend.getAllergens()));
                attributes.add(new Attributes("disease", vRecommend.getDisease()));
                attributes.add(new Attributes("goalType", vRecommend.getGoalType()));
                attributes.add(new Attributes("score", vRecommend.getScore()));

                Person p = new Person();
                p.username = vRecommend.getUsername();
                p.AttriList = attributes;
                p.Recipe=vRecommend.getRecipe();
                users.add(p);
            }
            Recommend recommend = new Recommend();
            Person person = recommend.recommend(username, users);
            data.put("recommendList", person.Recipe);
        return Result.success(data);
    }

    @GetMapping("/recommendListNew")
    public Result<Map<String, Object>> getBMPinfoNew(@RequestParam(value = "username") String username){
        Map<String, Object> data = new HashMap<>();

        List<v_Recommend> vRecommendList = bodyfatpercentageService.getBFP(0);
        List<Person> users = new ArrayList<>();
        UserSet userSet = new UserSet();
        for (v_Recommend vRecommend : vRecommendList) {
            userSet.put(vRecommend.getUsername()).set("height", vRecommend.getHeight()).create();
            userSet.put(vRecommend.getUsername()).set("weight", vRecommend.getHeight()).create();
            userSet.put(vRecommend.getUsername()).set("bfp", vRecommend.getHeight()).create();
            userSet.put(vRecommend.getUsername()).set("bmi", vRecommend.getHeight()).create();
            userSet.put(vRecommend.getUsername()).set("age", vRecommend.getHeight()).create();
            userSet.put(vRecommend.getUsername()).set("sex", vRecommend.getHeight()).create();
            userSet.put(vRecommend.getUsername()).set("workType", vRecommend.getHeight()).create();
            userSet.put(vRecommend.getUsername()).set("isVegetarian", vRecommend.getHeight()).create();
            userSet.put(vRecommend.getUsername()).set("disease", vRecommend.getHeight()).create();
            userSet.put(vRecommend.getUsername()).set("goalType", vRecommend.getHeight()).create();
            userSet.put(vRecommend.getUsername()).set("allergens", vRecommend.getHeight()).create();

//            userSet.put(vRecommend.getUsername()).set("height"+vRecommend.getHeight(), vRecommend.getHeight());
//            userSet.put(vRecommend.getUsername()).set("weight"+vRecommend.getHeight(), vRecommend.getHeight());
//            userSet.put(vRecommend.getUsername()).set("bfp"+vRecommend.getHeight(), vRecommend.getHeight());
//            userSet.put(vRecommend.getUsername()).set("bmi"+vRecommend.getHeight(), vRecommend.getHeight());
//            userSet.put(vRecommend.getUsername()).set("age"+vRecommend.getHeight(), vRecommend.getHeight());
//            userSet.put(vRecommend.getUsername()).set("sex"+vRecommend.getHeight(), vRecommend.getHeight());
//            userSet.put(vRecommend.getUsername()).set("workType"+vRecommend.getHeight(), vRecommend.getHeight());
//            userSet.put(vRecommend.getUsername()).set("isVegetarian"+vRecommend.getHeight(), vRecommend.getHeight());
//            userSet.put(vRecommend.getUsername()).set("disease"+vRecommend.getHeight(), vRecommend.getHeight());
//            userSet.put(vRecommend.getUsername()).set("goalType"+vRecommend.getHeight(), vRecommend.getHeight());
//            userSet.put(vRecommend.getUsername()).set("allergens"+vRecommend.getHeight(), vRecommend.getHeight());
//            Person p = new Person();
//            p.username = vRecommend.getUsername();
//            p.AttriList = attributes;
//            p.Recipe=vRecommend.getRecipe();
//            users.add(p);
        }
        RecommendNew recommend = new RecommendNew();
        List<UserSet.Set> recommendList = recommend.recommend(username,userSet);

        data.put("recommendList", recommendList);
        return Result.success(data);
    }
    @GetMapping("/dietList")
    public Result<Map<String, Object>> getDiet(@RequestParam(value = "uid") Integer uid){
        Map<String, Object> data = new HashMap<>();
        List<v_Recommend> vRecommendList = bodyfatpercentageService.getDiet(uid);
        v_Recommend vRecommend = vRecommendList.get(0);
        data.put("dietList", vRecommend.getRecipe());
        data.put("id",vRecommend.getId());
        data.put("pid",vRecommend.getPid());
        return Result.success(data);
    }
}
