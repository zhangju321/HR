package com.aaa.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller

public class UploadController {
	@RequestMapping("/upload")
	public String upload(@RequestParam("file1")MultipartFile file,HttpServletRequest request,Map map){
		//设置目标文件要存放的目录的绝对路径
		String path=request.getServletContext().getRealPath("/resources/upload");
		//获取原始的文件名
		String fileName=file.getOriginalFilename();
		//创建目标文件对象
		File targetFile=new File(path,fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			file.transferTo(targetFile);//文件上传
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("path", request.getContextPath()+"resources/upload"+fileName);
		return "list";
		
	}
}
