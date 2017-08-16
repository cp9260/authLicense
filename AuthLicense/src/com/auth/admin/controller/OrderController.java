package com.auth.admin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auth.admin.service.OrderService;
import com.auth.model.OrderModel;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/orders")
	@ResponseBody
	public List<OrderModel> getOrders(int pagenow,int pagesize){
		
		return orderService.getOrders(pagenow,pagesize);
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
	@RequestMapping(value="/orderSave")
	@ResponseBody
	public String saveOrder(String userName, String productId, double price){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		OrderModel user  = new OrderModel(userName,productId,price);
		user.setOrderTime(format.format(new Date()));
		user = orderService.saveOrUpdate(user);
		if(user == null){
			return "error";
		}
		return "ok";
	}
	
	
	@RequestMapping(value="/orderUpdate")
	@ResponseBody
	public String updateOrder(int pkey, String userName, String productId,
			double price, int status, String orderTime){
		OrderModel user  = new OrderModel(pkey,userName,productId,price,status,orderTime);
		user = orderService.saveOrUpdate(user);
		if(user == null){
			return "error";
		}
		return "ok";
	}
	
	@RequestMapping(value="/orderDelete")
	@ResponseBody
	public String deleteOrder(int pkey){
		boolean flag = orderService.deleteOrderBypkey(pkey);
		if(!flag){
			return "error";
		}
		return "ok";
	}
}
