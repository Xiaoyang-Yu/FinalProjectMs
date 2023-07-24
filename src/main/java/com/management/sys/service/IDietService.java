package com.management.sys.service;

import com.management.sys.entity.Diet;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Xiaoyang
 * @since 2023-04-28
 */
public interface IDietService extends IService<Diet> {
    void addDiet(Diet diet);
}
