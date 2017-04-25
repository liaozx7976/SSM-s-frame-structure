package com.cntv.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.Request;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cntv.entity.User;
import com.cntv.service.serviceImpl.UserServiceImpl;

@Controller
public class UserController {
	@Resource
	private UserServiceImpl userService;
	@RequestMapping("test.do")
	public ModelAndView  testCon(HttpServletRequest request,Model model){
		System.out.println("hello");
		System.out.println(request.getParameter("id"));
		User u=userService.getUserById(new Integer(request.getParameter("id")));
		System.out.println(u.getUserName());
		ModelAndView mod=new ModelAndView();
		mod.setViewName("success");
		return mod;
	}
	/**
	 * @deprecated
	 * 根据前台封装的javaBean属性进行封装  这里是进行User对象的封装
	 * 测试后台是否能正常能拿到数据       
	 * @param user 获取前台穿过来的对象
	 * @param request
	 * @return
	 */
	@RequestMapping("submit.do")
	public String testBean(User user,HttpServletRequest request){
		System.out.println("========+"+user.getUserName()+"..."+user.getPassword());
		return "success";
		
	}
	public UserServiceImpl getUserService() {
		return userService;
	}
	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}
	
}
