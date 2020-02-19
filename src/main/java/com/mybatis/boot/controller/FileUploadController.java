package com.mybatis.boot.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.mybatis.boot.model.FileBean;
import com.mybatis.boot.service.FileBeanService;
import com.mybatis.boot.util.FastDfsUtils;
import com.mybatis.boot.vo.LayuiResult;
import com.mybatis.boot.vo.LayuiTableResult;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author LX
 * @Date 2020/1/10 18:13
 * @Description
 */
@Controller
@RequestMapping("/fileService")
public class FileUploadController {

    private final FastFileStorageClient fastFileStorageClient;
    private final FastDfsUtils fastDfsUtils;

    private final FileBeanService fileBeanService;

    public FileUploadController(FastFileStorageClient fastFileStorageClient, FastDfsUtils fastDfsUtils, FileBeanService fileBeanService) {
        this.fastFileStorageClient = fastFileStorageClient;
        this.fastDfsUtils = fastDfsUtils;
        this.fileBeanService = fileBeanService;
    }

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("name", "lisi");
        return "file/index";
    }

    @GetMapping("/listFile")
    public String listFile(Model model) {
        return "file/listAll";
    }

    @PostMapping("/listFileJson")
    @ResponseBody
    public LayuiTableResult listFileJson(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(fileBeanService.list(new LambdaQueryWrapper<FileBean>().orderByDesc(FileBean::getUploadTime)));
        return new LayuiTableResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @PostMapping(value = "/delById/{id}")
    @ResponseBody
    public LayuiResult delById(@PathVariable(value = "id") String id) {

        fileBeanService.delFileById(id);
        return new LayuiResult(0, "删除成功！", null);
    }

    /**
     * 文件上传
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    @ResponseBody
    public LayuiResult test(@RequestParam MultipartFile file) throws IOException {
        // 设置文件信息
        Set<MetaData> mataData = new HashSet<>();
        mataData.add(new MetaData("author", "lx"));
        mataData.add(new MetaData("description", "xxx文件，嘿嘿嘿"));

        // 上传   （文件上传可不填文件信息，填入null即可）
        StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), mataData);
        String fileUrl = fastDfsUtils.getResAccessUrl(storePath);
        System.out.println(fileUrl);
        FileBean fileBean = new FileBean();
        fileBean.setName(file.getOriginalFilename());
        fileBean.setUrl(fileUrl);
        fileBean.setSize(file.getSize() / 1024);
        fileBean.setType(file.getContentType());
        fileBean.setUploadTime(new Date());
        fileBeanService.saveFile(fileBean);
        return new LayuiResult(0, StringUtils.isEmpty(fileUrl) ? "上传失败" : "上传成功", fileUrl);
    }

    /**
     * 文件下载
     *
     * @param fileUrl  当前对象文件名称
     * @param response HttpServletResponse 内置对象
     * @throws IOException
     */
    @RequestMapping("/downloadFile")
    public void downloadFile(String fileUrl, String fileName, HttpServletResponse response) throws IOException {
        byte[] bytes = fastDfsUtils.downLoadFile(fileUrl);
        String[] split = fileUrl.split("/");
        // 这里只是为了整合fastdfs，所以写死了文件格式。需要在上传的时候保存文件名。下载的时候使用对应的格式
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        response.setCharacterEncoding("UTF-8");
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
