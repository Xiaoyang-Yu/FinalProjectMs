package com.management.sys.service.impl;

import com.management.sys.entity.BodyFatPercentage;
import com.management.sys.entity.v_Recommend;
import com.management.sys.mapper.BodyFatPercentageMapper;
import com.management.sys.service.IBodyFatPercentageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Xiaoyang
 * @since 2023-09-09
 */
@Service
public class BodyFatPercentageServiceImpl extends ServiceImpl<BodyFatPercentageMapper, BodyFatPercentage> implements IBodyFatPercentageService {
    public List<v_Recommend> getBFP(Integer uid){
    Map<String, Object> data = new HashMap<>();
    List<v_Recommend> bmiList= this.baseMapper.getBMPinfo(uid);
    return bmiList;
    }
    public List<v_Recommend> getDiet(Integer uid){
        Map<String, Object> data = new HashMap<>();
        List<v_Recommend> bmiList= this.baseMapper.getDiet(uid);
        return bmiList;
    }

}
