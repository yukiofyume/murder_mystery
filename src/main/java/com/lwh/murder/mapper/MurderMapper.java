package com.lwh.murder.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwh.murder.model.MurderModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author lwh
 * @date 2021/4/12 19:33
 */
@Repository
public interface MurderMapper extends BaseMapper<MurderModel> {
}
