package com.atguigu.controller;

import com.alibaba.druid.sql.visitor.functions.Bin;
import com.atguigu.pojo.Schedule;
import com.atguigu.service.ScheduleService;
import com.atguigu.utils.R;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin      //允许前端程序的node服务器（端口号：5173）访问我，浏览器你别拦截他！
@RestController
@RequestMapping("schedule")  // @Controller + @ResponseBody
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;     // 子容器调父容器的组件，用@AutoWired

    //分页查询
    @GetMapping("{pageSize}/{currentPage}")
    public R page(@PathVariable Integer pageSize, @PathVariable Integer currentPage){
        R r = scheduleService.page(pageSize, currentPage);
        return r;
    }

    // 删除任务
    // TODO:什么时候用DeleteMapping??
    @DeleteMapping("{id}")
    public R deleteSchedule(@PathVariable Integer id){
        R r = scheduleService.deleteSchedule(id);
        return r;
    }

    //添加任务
    // TODO pojo中加了@NotNull之后一定要在controller层的参数上加@Validated
    @PostMapping
    public R addSchedule(@Validated @RequestBody Schedule schedule, BindingResult result){
        if (result.hasErrors()){
            return R.fail("参数为空，不能保存");
        }
        R r = scheduleService.addSchedule(schedule);
        return r;
    }

    //更新任务
    @PutMapping
    public R updateSchedule(@RequestBody Schedule schedule, BindingResult result) {
        if (result.hasErrors()){
            return R.fail("参数为空，不能修改");
        }
        R r = scheduleService.updateSchedule(schedule);
        return r;
    }
}
