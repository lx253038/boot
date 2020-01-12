package com.mybatis.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mybatis.boot.model.FileBean;

/**
 * @Author LX
 * @Date 2020/1/12 13:44
 * @Description
 */
public interface FileBeanService extends IService<FileBean> {


    void saveFile(FileBean fileBean);

    void delFileById(String Id);
}
