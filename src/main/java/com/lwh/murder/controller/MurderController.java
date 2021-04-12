package com.lwh.murder.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lwh.murder.model.MurderModel;
import com.lwh.murder.service.MurderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * @author lwh
 * @date 2021/4/12 19:55
 */
@Api(tags = "剧本杀管理系统")
@RestController
@RequestMapping("admin/murder")
public class MurderController {

    // 注入service
    @Autowired
    private MurderService murderService;

    // 1.查询所有客户信息
    @ApiOperation("获得所有用户剧本杀信息")
    @GetMapping("findAll")
    public List<MurderModel> findAllMurder() {
        // 调用service方法
        List<MurderModel> list = murderService.list();
        return list;
    }

    // 2.逻辑删除客户信息
    @ApiOperation("逻辑删除客户信息")
    @DeleteMapping("{id}")
    public boolean removeMurder(@PathVariable Long id) {
        boolean flag = murderService.removeById(id);
        if (flag) {
            return true;
        } else {
            return false;
        }
    }

//    // 3.条件查询带分页
//    @ApiOperation("分页查询医院信息")
//    @PostMapping("findPageHospSet/{current}/{limit}")
//    public Result findPageHospSet(@PathVariable long current,
//                                  @PathVariable long limit,
//                                  @RequestBody(required = false)
//                                          HospitalSetQueryVo hospitalSetQueryVo) {
//        // 创建 page 对象，传递当前页，每页记录数
//        Page<HospitalSet> page = new Page<>(current, limit);
//
//        // 构建条件
//        QueryWrapper<HospitalSet> wrapper = new QueryWrapper<>();
//        String hosname = hospitalSetQueryVo.getHosname();
//        String hoscode = hospitalSetQueryVo.getHoscode();
//        if (!StringUtils.isEmpty(hosname)) {
//            wrapper.like("hosname", hospitalSetQueryVo.getHosname());
//        }
//        if (!StringUtils.isEmpty(hoscode)) {
//            wrapper.eq("hoscode", hospitalSetQueryVo.getHoscode());
//        }
//
//        // 4.调用方法实现分页查询
//        Page<HospitalSet> pageHospitalSet = hospitalSetService.page(page, wrapper);
//        return Result.ok(pageHospitalSet);
//    }

    // 4.添加客户信息
    @ApiOperation("添加客户信息")
    @PostMapping("saveMurder")
    public boolean saveMurder(@RequestBody MurderModel murderModel) {
        boolean save = murderService.save(murderModel);
        if (save) {
            return true;
        } else {
            return false;
        }
    }

    // 5.根据id查询客户信息
    @ApiOperation("根据id查询客户信息")
    @GetMapping("getMurder/{id}")
    public MurderModel getMurder(@PathVariable Long id) {
        MurderModel murderModel = murderService.getById(id);
        return murderModel;
    }


    //6.修改客户信息
    @ApiOperation("修改客户信息")
    @PostMapping("updateMurder")
    public boolean updateMurder(@RequestBody MurderModel murderModel) {
        boolean flag = murderService.updateById(murderModel);
        if (flag) {
            return true;
        } else {
            return false;
        }
    }


    //7.批量删除客户信息
    @ApiOperation("批量删除客户信息")
    @DeleteMapping("batchRemove")
    public boolean batchRemoveMurder(@RequestBody List<Long> idList){
        murderService.removeByIds(idList);
        return true;
    }
}

