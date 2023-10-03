package com.management.sys.mapper;

import com.management.sys.entity.BodyFatPercentage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.management.sys.entity.v_Recommend;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Xiaoyang
 * @since 2023-09-09
 */
public interface BodyFatPercentageMapper extends BaseMapper<BodyFatPercentage> {
    public List<v_Recommend> getBMPinfo(Integer uid);
    public List<v_Recommend> getDiet(Integer uid);
}
