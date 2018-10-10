package com.aaa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.aaa.entity.PerSon;

@Controller
@RequestMapping("/person")
@SessionAttributes(value={"list"})//查找Model,Map,中的相同key值对应的数据存入session中

public class PerController {


@RequestMapping("/query")
  public String queryAll(){
	System.out.println("查询");
	return "query";
}
	@RequestMapping("/queryAll")
public String queryAll(Map map){
	System.out.println("查询方法");
	map.put("message", "map形式封装数据");
	return "query";
}
@RequestMapping(value="/query1",method=RequestMethod.GET)//method=RequestMethod.GET用于限定请求类型
public ModelAndView query1(){
	ModelAndView mView=new ModelAndView("query");//船舰模型和试图对象 设置视图的名称
	mView.addObject("message", "hello");
	return mView;
}
@RequestMapping("/reg1")
public String reg1(String name,String sex,String birthday){
	System.out.println(name+"----"+sex+"----"+birthday);
	return "query";
}
@RequestMapping("/reg2")
public String reg2(@RequestParam(value="name",required=false,defaultValue="无名氏") String name,
		@RequestParam("sex")String sex,
        @RequestParam("birthday")String birthday){
	System.out.println(name+"----"+sex+"----"+birthday);
	return "query";
}
@RequestMapping("/reg3")
public String reg3(PerSon p,Map map){
	System.out.println(p);
	p.setId(1);
	map.put("p", p);
	return "query";
	
}
@RequestMapping("/reg4")
public String reg4(HttpServletRequest request){
	String nmae=request.getParameter("name");
	String sex=request.getParameter("sex");
	return "query";
}
@RequestMapping("/reg5")
public String list(Map map,HttpSession session){
	List<PerSon> list=new ArrayList<PerSon>();
	list.add(new PerSon(1, "老大", "男", Date.valueOf("2018-9-18")));
	list.add(new PerSon(2, "老二", "男", Date.valueOf("2018-9-19")));
	list.add(new PerSon(3, "小三", "女", Date.valueOf("2018-9-20")));
	map.put("list", list);//会将list存入session或者使用@sessionAttributes注解
	return "list";
}
@RequestMapping("/reg.action")
public String reg(PerSon p){
	System.out.println("录入成功:"+p);
	return "redirect:query.action";//跳转到指定的控制器中的方法
}

@ResponseBody//转换为json输出
@RequestMapping("/testJson1")
public PerSon testJson1(){
	return new PerSon(23, "老四", "男", Date.valueOf("2018-9-18"));
}
@ResponseBody
@RequestMapping("/testJson2")
public List<PerSon> testJson2(){
	List<PerSon> list=new ArrayList<PerSon>();
	list.add(new PerSon(1, "花花", "女", Date.valueOf("2018-9-21")));
	list.add(new PerSon(2, "草草", "男", Date.valueOf("2018-9-22")));
	list.add(new PerSon(3, "树叶", "女", Date.valueOf("2018-9-23")));
	return list;
}
@ResponseBody
@RequestMapping("/testJson3")
public Map<String,Object> testJson3(){
	Map<String, Object> map=new HashMap<String, Object>();
	map.put("p1", new PerSon(1, "小明", "男", Date.valueOf("2001-1-1")));
	map.put("p2", new PerSon(2, "小明2", "男", Date.valueOf("2001-1-1")));
	return map;
}
/*@ModelAttribute//当当前控制器中的方法执行时，先执行该方法（自动执行）
public void testModelAttribute1(){
	System.out.println("ModelAttribute方法执行...");
}*/
@ModelAttribute("/person1") //相当于Model.addAttribute("person1",返回的对象)
public PerSon testModelAttribute2(){
	return new PerSon(111,"新人","男",Date.valueOf("1669-1-1"));
}
@RequestMapping("/test1.action")
//@ModelAttribute("key"):作用于参数前面，先试图从Model读取key对应的数据，绑定到参数上
//@ModelAttribute("key"):如果没有找到key值对应的数据，会将参数存入Model中
public String testModelAttribute2(@ModelAttribute("person2") PerSon p){
	p.setName("person2");
	System.out.println("从Model中取数据:person1:"+p);
	return "list";
}
@RequestMapping("/recivJson1")
public void recivJson1(@RequestBody PerSon p,HttpServletResponse response) throws IOException{
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out= response.getWriter();
	out.print("1111:"+p);
}

@RequestMapping("/recivJson2")
public void recivJson2(PerSon p,HttpServletResponse response) throws IOException{
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out= response.getWriter();
	out.print("2222:"+p);
}
@InitBinder//类型转换
public void init(WebDataBinder binder){
	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	//dateFormat.setLenient(false);//用于设置Canlendar是否宽松解析字符串，如果为false，则严格解析；默认为true，宽松解析
//注册默认编辑器（类型转换器）
	binder.registerCustomEditor(java.util.Date.class,new CustomDateEditor(dateFormat, false));//true:允许输入空值，false:不能为空值 
}
@RequestMapping("/test2")
public String test2(){
	return "forward:reg1";//一服务器端转发的形式跳转
	//return "redirect:reg1.jsp";//直接跳转到制定jsp页面，不经过试图渲染
}
//同上("/test2")
public void test3(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	request.getRequestDispatcher("路径").forward(request, response);
	response.sendRedirect("路径");
}
}
