package com.aaa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaa.entity.PerSon;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/test1")
public class YibuController {
@RequestMapping("/reg1")
public void reg1(@RequestBody PerSon p,HttpServletResponse response) throws IOException{
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out=response.getWriter();
	//out.print("操作成功"+p);
	//转换json和java对象使用
	ObjectMapper mapper=new ObjectMapper();
	String json=mapper.writeValueAsString(p);
	out.print(json);
}

}
