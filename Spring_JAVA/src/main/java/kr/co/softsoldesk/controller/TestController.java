package kr.co.softsoldesk.controller;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.softsoldesk.beans.DataBean1;

@Controller
public class TestController {
	
	//application 타입으로 주입
	@Autowired
	ServletContext application;
	/*
	//#1 HttpServletRequest사용하여 application 주입
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		//application영역 확보하여 저장
		ServletContext application=request.getServletContext();
		application.setAttribute("data1", "JAVA");
		
		
		return "test1";
	}

	
	@GetMapping("/result1")
	public String result11(HttpServletRequest request) {
		
		ServletContext application=request.getServletContext();
		String data1=(String)application.getAttribute("data1");
		
		System.out.println("data1 : "+data1);
		
		return "result1";
	}
	
	
	//#2 @Autowired 사용
	@GetMapping("/test1")
	public String test1() {
		
		application.setAttribute("data1", "Soldesk");
		
		
		return "test1";
	}
	
	@GetMapping("/result1")
	public String result1() {
		
		String data1=(String)application.getAttribute("data1");
		System.out.println("data1 : "+data1);
		
		return "result1";
	}
	
	 * */
	//DataBean1
	@GetMapping("/test1")
	public String test1() {
		DataBean1 bean1=new DataBean1();
		bean1.setData1("data1");
		bean1.setData2("data2");
		application.setAttribute("bean1", bean1);
		
		
		return "test1";
	}
	
	@GetMapping("/result1")
	public String result1() {
		
		DataBean1 bean1=(DataBean1)application.getAttribute("bean1");
		System.out.println("bean1.data1 : "+bean1.getData1());
		System.out.println("bean1.data1 : "+bean1.getData2());
		
		
		return "result1";
	}
	
}