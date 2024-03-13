package com.atguigu.service.impl;

import com.atguigu.mapper.ScheduleMapper;
import com.atguigu.pojo.Schedule;
import com.atguigu.service.ScheduleService;
import com.atguigu.utils.PageBean;
import com.atguigu.utils.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;
//    TODO:mybatis利用MapperScannerConfigurer扫描mapper，生成mapper代理类
    // TODO:代理类存放在root容器的子容器，因此需要@Autowired进行依赖注入

    @Override
    public R page(Integer pageSize, Integer currentPage) {
        // 分页
        PageHelper.startPage(currentPage, pageSize);

        // 查询
        List<Schedule> scheduleList = scheduleMapper.queryList();

        //分页数据装配
        PageInfo<Schedule> info = new PageInfo<>(scheduleList);

        //装配PageBean
        PageBean<Schedule> pageBean = new PageBean<>(currentPage, pageSize, info.getTotal(),info.getList());

        R ok = R.ok(pageBean);   //静态方法
        return ok;
    }

    @Override
    public R deleteSchedule(Integer id) {
        // 删除数据
        // DML返回值都是int rows
        int rows = scheduleMapper.deleteById(id);

        if (rows > 0) {
            // 删除成功
            // 装配数据
            R ok = R.ok(null);
            return ok;
        }
        return R.fail(null);

    }

    @Override
    public R addSchedule(Schedule schedule) {
        int rows = scheduleMapper.insert(schedule);
        if (rows > 0) {
            return R.ok(schedule);
        }
        return R.fail(null);
    }

    @Override
    public R updateSchedule(Schedule schedule) {
        // 判断id不能为空
        if (schedule.getId() == 0){
            return R.fail("id为空，无法修改");
        }

        int rows = scheduleMapper.updateById(schedule);
        if (rows > 0) {
            return R.ok(schedule);
        }
        return R.fail(null);
    }
}
