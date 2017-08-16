package com.auth.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auth.admin.service.ProductService;
import com.auth.model.ProductModel;
import com.auth.model.UserModel;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/products")
	@ResponseBody
	public List<ProductModel> getUsers(int pagenow,int pagesize){
		
		return productService.getProducts(pagenow,pagesize);
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
	@RequestMapping(value="/productSave")
	@ResponseBody
	public String saveproduct(String name, String imageUrl, String beizhu){
		ProductModel user  = new ProductModel(name,imageUrl,beizhu);
		user = productService.saveOrUpdate(user);
		if(user == null){
			return "error";
		}
		return "ok";
	}
	
	
	@RequestMapping(value="/productUpdate")
	@ResponseBody
	public String updateproduct(int pkey,String name, String imageUrl, String beizhu){
		ProductModel user  = new ProductModel(pkey,name,imageUrl,beizhu);
		user = productService.saveOrUpdate(user);
		if(user == null){
			return "error";
		}
		return "ok";
	}
	
	@RequestMapping(value="/productDelete")
	@ResponseBody
	public String saveproduct(int pkey){
		boolean flag = productService.deleteProductBypkey(pkey);
		if(!flag){
			return "error";
		}
		return "ok";
	}
	
	@RequestMapping(value="/checkProduct")
	@ResponseBody
	public int getProductIDcheck(String productId){
		
		return productService.checkProductID(productId);
	}
}
