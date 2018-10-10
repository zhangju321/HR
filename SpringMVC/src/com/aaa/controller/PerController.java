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
@SessionAttributes(value={"list"})//����Model,Map,�е���ͬkeyֵ��Ӧ�����ݴ���session��

public class PerController {


@RequestMapping("/query")
  public String queryAll(){
	System.out.println("��ѯ");
	return "query";
}
	@RequestMapping("/queryAll")
public String queryAll(Map map){
	System.out.println("��ѯ����");
	map.put("message", "map��ʽ��װ����");
	return "query";
}
@RequestMapping(value="/query1",method=RequestMethod.GET)//method=RequestMethod.GET�����޶���������
public ModelAndView query1(){
	ModelAndView mView=new ModelAndView("query");//����ģ�ͺ���ͼ���� ������ͼ������
	mView.addObject("message", "hello");
	return mView;
}
@RequestMapping("/reg1")
public String reg1(String name,String sex,String birthday){
	System.out.println(name+"----"+sex+"----"+birthday);
	return "query";
}
@RequestMapping("/reg2")
public String reg2(@RequestParam(value="name",required=false,defaultValue="������") String name,
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
	list.add(new PerSon(1, "�ϴ�", "��", Date.valueOf("2018-9-18")));
	list.add(new PerSon(2, "�϶�", "��", Date.valueOf("2018-9-19")));
	list.add(new PerSon(3, "С��", "Ů", Date.valueOf("2018-9-20")));
	map.put("list", list);//�Ὣlist����session����ʹ��@sessionAttributesע��
	return "list";
}
@RequestMapping("/reg.action")
public String reg(PerSon p){
	System.out.println("¼��ɹ�:"+p);
	return "redirect:query.action";//��ת��ָ���Ŀ������еķ���
}

@ResponseBody//ת��Ϊjson���
@RequestMapping("/testJson1")
public PerSon testJson1(){
	return new PerSon(23, "����", "��", Date.valueOf("2018-9-18"));
}
@ResponseBody
@RequestMapping("/testJson2")
public List<PerSon> testJson2(){
	List<PerSon> list=new ArrayList<PerSon>();
	list.add(new PerSon(1, "����", "Ů", Date.valueOf("2018-9-21")));
	list.add(new PerSon(2, "�ݲ�", "��", Date.valueOf("2018-9-22")));
	list.add(new PerSon(3, "��Ҷ", "Ů", Date.valueOf("2018-9-23")));
	return list;
}
@ResponseBody
@RequestMapping("/testJson3")
public Map<String,Object> testJson3(){
	Map<String, Object> map=new HashMap<String, Object>();
	map.put("p1", new PerSon(1, "С��", "��", Date.valueOf("2001-1-1")));
	map.put("p2", new PerSon(2, "С��2", "��", Date.valueOf("2001-1-1")));
	return map;
}
/*@ModelAttribute//����ǰ�������еķ���ִ��ʱ����ִ�и÷������Զ�ִ�У�
public void testModelAttribute1(){
	System.out.println("ModelAttribute����ִ��...");
}*/
@ModelAttribute("/person1") //�൱��Model.addAttribute("person1",���صĶ���)
public PerSon testModelAttribute2(){
	return new PerSon(111,"����","��",Date.valueOf("1669-1-1"));
}
@RequestMapping("/test1.action")
//@ModelAttribute("key"):�����ڲ���ǰ�棬����ͼ��Model��ȡkey��Ӧ�����ݣ��󶨵�������
//@ModelAttribute("key"):���û���ҵ�keyֵ��Ӧ�����ݣ��Ὣ��������Model��
public String testModelAttribute2(@ModelAttribute("person2") PerSon p){
	p.setName("person2");
	System.out.println("��Model��ȡ����:person1:"+p);
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
@InitBinder//����ת��
public void init(WebDataBinder binder){
	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	//dateFormat.setLenient(false);//��������Canlendar�Ƿ���ɽ����ַ��������Ϊfalse�����ϸ������Ĭ��Ϊtrue�����ɽ���
//ע��Ĭ�ϱ༭��������ת������
	binder.registerCustomEditor(java.util.Date.class,new CustomDateEditor(dateFormat, false));//true:���������ֵ��false:����Ϊ��ֵ 
}
@RequestMapping("/test2")
public String test2(){
	return "forward:reg1";//һ��������ת������ʽ��ת
	//return "redirect:reg1.jsp";//ֱ����ת���ƶ�jspҳ�棬��������ͼ��Ⱦ
}
//ͬ��("/test2")
public void test3(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	request.getRequestDispatcher("·��").forward(request, response);
	response.sendRedirect("·��");
}
}
