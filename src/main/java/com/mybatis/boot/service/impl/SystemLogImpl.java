package com.mybatis.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.boot.mapper.SystemLogMapper;
import com.mybatis.boot.model.SystemLog;
import com.mybatis.boot.service.SystemLogService;
import org.springframework.stereotype.Service;

/**
 * @Author LX
 * @Date 2019/12/12 14:34
 * @Description TODO
 */
@Service
public class SystemLogImpl extends ServiceImpl<SystemLogMapper, SystemLog> implements SystemLogService {
}
