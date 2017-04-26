package com.cntv.base.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;

import com.cntv.entity.User;

import net.sf.json.JSONObject;
@Controller
public class BaseController<T> {
 
	/**
	 * 输出Object -> JSON
	 * @param o
	 * @throws Exception
	 */
	protected void printObject(Object o,HttpServletResponse rep) throws Exception{
		HttpServletResponse response=null;
		JSONObject object = JSONObject.fromObject(o);
		rep.getWriter().print(object.toString());
		System.out.println(object);
	}
	
	
	
	
	/**
	 * @deprecated 
	 * 这个方法是快速获取response对象
	 * @param response
	 * @return response
	 */
	public HttpServletResponse getResp() {
		HttpServletResponse response = null;
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		return response;
	}

	public static void main(String[] args) throws Exception {
		BaseController con=new BaseController();
		User u=new  User();
		u.setAge(1);
		u.setAge(12);
		;
		System.out.println(getResponse());
	}
	public static HttpServletResponse getResponse() {
		return ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();
		}
}
