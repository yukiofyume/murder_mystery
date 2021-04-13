package com.lwh.murder.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lwh.murder.model.MurderModel;
import com.lwh.murder.model.MurderModelVo;
import com.lwh.murder.model.Result;
import com.lwh.murder.service.MurderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lwh
 * @date 2021/4/12 19:55
 */
@Api(tags = "剧本杀管理系统")
@RestController
@CrossOrigin
@RequestMapping("admin/murder")
public class MurderController {

    // 注入service
    @Autowired
    private MurderService murderService;

    // 1.查询所有客户信息
    @ApiOperation("获得所有用户剧本杀信息")
    @GetMapping("findAll")
    public Result findAllMurder() {
        // 调用service方法
        List<MurderModel> list = murderService.list();
        return Result.ok(list);
    }

    // 2.逻辑删除客户信息
    @ApiOperation("根据编号删除客户信息")
    @DeleteMapping("{id}")
    public Result removeMurder(@PathVariable Long id) {
        boolean flag = murderService.removeById(id);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    // 3.条件查询带分页
    @ApiOperation("分页查询")
    @PostMapping("findPageMurder/{current}/{limit}")
    public Result findPageMurder(@PathVariable long current,
                                            @PathVariable long limit,
                                            @RequestBody(required = false) MurderModelVo murderModelVo) {
        // 创建page对象，传递当前页，每页记录数
        Page<MurderModel> page = new Page<>(current, limit);
        QueryWrapper<MurderModel> wrapper = new QueryWrapper<>();
        String userName = murderModelVo.getUserName();
        String userId = murderModelVo.getUserId();
        if (!StringUtils.isEmpty(userName)) {
            wrapper.like("user_name", murderModelVo.getUserName());
        }
        if (!StringUtils.isEmpty(userId)) {
            wrapper.eq("user_id", murderModelVo.getUserId());
        }
        Page<MurderModel> murderModelPage = murderService.page(page, wrapper);
        return Result.ok(murderModelPage);
    }


    // 4.添加客户信息
    @ApiOperation("添加客户信息")
    @PostMapping("saveMurder")
    public Result saveMurder(@RequestBody MurderModel murderModel) {
        boolean save = murderService.save(murderModel);
        if (save) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    // 5.根据id查询客户信息
    @ApiOperation("根据编号查询客户信息")
    @GetMapping("getMurder/{id}")
    public Result getMurder(@PathVariable Long id) {
        MurderModel murderModel = murderService.getById(id);
        return Result.ok(murderModel);
    }


    //6.修改客户信息
    @ApiOperation("修改客户信息")
    @PostMapping("updateMurder")
    public Result updateMurder(@RequestBody MurderModel murderModel) {
        boolean flag = murderService.updateById(murderModel);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }


    //7.批量删除客户信息
    @ApiOperation("批量删除客户信息")
    @DeleteMapping("batchRemove")
    public Result batchRemoveMurder(@RequestBody List<Long> idList) {
        murderService.removeByIds(idList);
        return Result.ok();
    }
}

