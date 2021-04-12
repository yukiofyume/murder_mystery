package com.lwh.murder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lwh.murder.mapper.MurderMapper;
import com.lwh.murder.model.MurderModel;
import com.lwh.murder.service.MurderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lwh
 * @date 2021/4/12 19:52
 */
@Service
public class MurderServiceImpl
        extends ServiceImpl<MurderMapper, MurderModel>
        implements MurderService {
    @Autowired
    private MurderMapper murderMapper;
}
