package com.atguigu.mapper;

import com.atguigu.pojo.Schedule;
import com.atguigu.utils.R;

import java.util.List;

// 不用加入ioc容器，因为在MapperJavaConfig中设置了代理类：MapperScannerConfigurer会扫描此处，自动生成Mapper代理类
public interface ScheduleMapper {
    // 分页查询
    List<Schedule> queryList();

    // 删除
    int deleteById(Integer id);
//
    // 添加
    int insert(Schedule schedule);
//
    // 更新
    int updateById(Schedule schedule);
}
