package com.atguigu.service;

import com.atguigu.pojo.Schedule;
import com.atguigu.utils.R;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface ScheduleService {
    // 分页查询
    R page(Integer pageSize, Integer currentPage);

    // 删除任务
    R deleteSchedule(Integer id);

    // 添加任务
    R addSchedule(Schedule schedule);

    // 更新任务
    R updateSchedule(Schedule schedule);
}
