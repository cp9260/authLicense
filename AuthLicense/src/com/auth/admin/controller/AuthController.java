package com.auth.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auth.admin.service.LicenseService;
import com.auth.model.AuthModel;
import com.auth.model.ProductModel;

@Controller
public class AuthController {
	
	@Autowired
	private LicenseService licenseService;
	
	@RequestMapping(value="/licenses")
	@ResponseBody
	public List<AuthModel> getLicenses(int pagenow,int pagesize){
		
		return licenseService.getProducts(pagenow,pagesize);
	}

//	@RequestMapping(value="/productSave")
//	@ResponseBody
//	public String saveUserByAdmin(String userName,String password,String mobile,String email){
//		UserModel user  = new UserModel(userName,password,mobile,email);
//		user = userInfoService.saveOrUpdate(user);
//		if(user == null){
//			return "error";
//		}
//		return "ok";
//	}
	@RequestMapping(value="/licenseSave")
	@ResponseBody
	public String saveLicense(String userName, String ip, String domain,
			String licenseKey, String productId){
		AuthModel user  = new AuthModel(userName,ip,domain,licenseKey,productId);
		user = licenseService.saveOrUpdate(user);
		if(user == null){
			return "error";
		}
		return "ok";
	}
	
	
	@RequestMapping(value="/licenseUpdate")
	@ResponseBody
	public String updateproduct(int pkey, String userName, String ip, String domain,
			String licenseKey, int status, String productId){
		AuthModel user  = new AuthModel(pkey,userName,ip,domain,licenseKey,status,productId);
		user = licenseService.saveOrUpdate(user);
		if(user == null){
			return "error";
		}
		return "ok";
	}
	
	@RequestMapping(value="/licenseDelete")
	@ResponseBody
	public String saveproduct(int pkey){
		boolean flag = licenseService.deleteLicenseBypkey(pkey);
		if(!flag){
			return "error";
		}
		return "ok";
	}
}
