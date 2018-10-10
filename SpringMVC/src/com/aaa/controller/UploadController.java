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
		//����Ŀ���ļ�Ҫ��ŵ�Ŀ¼�ľ���·��
		String path=request.getServletContext().getRealPath("/resources/upload");
		//��ȡԭʼ���ļ���
		String fileName=file.getOriginalFilename();
		//����Ŀ���ļ�����
		File targetFile=new File(path,fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			file.transferTo(targetFile);//�ļ��ϴ�
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
