package com.management.sys.service;

import com.management.sys.entity.BodyFatPercentage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.management.sys.entity.v_Recommend;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Xiaoyang
 * @since 2023-09-09
 */
public interface IBodyFatPercentageService extends IService<BodyFatPercentage> {
    List<v_Recommend> getBFP(Integer uid);

    }
