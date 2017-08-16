package com.auth.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auth.admin.service.UserInfoService;
import com.auth.model.UserModel;

@Controller
public class LoginController {
	
	@Autowired
	private UserInfoService userInfoService; 
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/users")
	@ResponseBody
	public List<UserModel> getUsers(int pagenow,int pagesize){
		
		return userInfoService.getUserInfos(pagenow,pagesize);
		
	}
	
	@RequestMapping(value="/count")
	@ResponseBody
	public int getUsersCount(String name){
		
		return userInfoService.getUserCount(name);
	}
	
	@RequestMapping(value="/checkUser")
	@ResponseBody
	public int getUserscheck(String name){
		
		return userInfoService.checkUserName(name);
	}
	
	@RequestMapping(value="/login")
	public String login(String userName,String password,HttpServletRequest request){
		UserModel user  = userInfoService.checkUserForModel(userName, password,0);
		if(user == null){
			return "default.html";
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//跳转页面
		}
		return "index.html";
	}
	
	@RequestMapping(value="/loginAdmin")
	public String loginAdmin(String userName,String password,HttpServletRequest request){
		UserModel user  = userInfoService.checkUserForModel(userName, password,1);
		if(user == null){
			return "adminlogin.jsp";
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//跳转页面
			
		}
		return "adminindex.html";
	}
	
	@RequestMapping(value="/usersave")
	public String saveUser(String userName,String password,String mobile,String email){
		UserModel user  = new UserModel(userName,password,mobile,email);
		user = userInfoService.saveOrUpdate(user);
		if(user == null){
			return "register.jsp";
		}
		return "login.jsp";
	}

	@RequestMapping(value="/userAdminsave")
	@ResponseBody
	public String saveUserByAdmin(String userName,String password,String mobile,String email){
		UserModel user  = new UserModel(userName,password,mobile,email);
		user = userInfoService.saveOrUpdate(user);
		if(user == null){
			return "error";
		}
		return "ok";
	}
	
	@RequestMapping(value="/userAdminUpdate")
	@ResponseBody
	public String saveUserByAdmin(int pkey,String userName,String password,String mobile,String email,int status){
		UserModel user  = new UserModel(pkey,userName,password,mobile,email,status);
		user = userInfoService.saveOrUpdate(user);
		if(user == null){
			return "error";
		}
		return "ok";
	}
	
	@RequestMapping(value="/userAdminDelete")
	@ResponseBody
	public String saveUserByAdmin(int pkey){
		boolean flag = userInfoService.deleteUserBypkey(pkey);
		if(!flag){
			return "error";
		}
		return "ok";
	}
}
