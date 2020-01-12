package com.mybatis.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.boot.mapper.FileBeanMapper;
import com.mybatis.boot.model.FileBean;
import com.mybatis.boot.service.FileBeanService;
import com.mybatis.boot.util.FastDfsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

/**
 * @Author LX
 * @Date 2020/1/12 13:44
 * @Description
 */
@Service
@CacheConfig(cacheNames = "fileBean")
public class FileBeanServiceImpl extends ServiceImpl<FileBeanMapper, FileBean> implements FileBeanService {
    @Autowired
    FileBeanMapper fileBeanMapper;


    @Autowired
    FastDfsUtils fastDfsUtils;


    @Override
    @CacheEvict(allEntries = true)
    public void saveFile(FileBean fileBean) {
        fileBeanMapper.insert(fileBean);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void delFileById(String id) {
        FileBean fileBean = fileBeanMapper.selectById(id);
        fastDfsUtils.deleteFile(fileBean.getUrl());
        fileBeanMapper.deleteById(id);
    }

}
