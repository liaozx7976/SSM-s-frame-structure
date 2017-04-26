package com.cntv.service.serviceImpl;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.cntv.dao.IUserDao;
import com.cntv.entity.User;
import com.cntv.service.IUserService;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
@Service
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}
   public static void main(String[] args) {
	   ApplicationContext ca= new ClassPathXmlApplicationContext("spring-mybatis.xml");
	   UserServiceImpl u=(UserServiceImpl) ca.getBean("userServiceImpl");
	  User ue= u.getUserById(1);
	   System.out.println("用户名:"+ue.getUserName());
	   System.out.println("用户密码:"+ue.getPassword());
	  
}
public IUserDao getUserDao() {
	return userDao;
}
public void setUserDao(IUserDao userDao) {
	this.userDao = userDao;
}
   
}
