package com.auth.admin.service;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auth.model.OrderModel;
import com.auth.model.ProductModel;

@Service("orderService")
@Transactional
public class OrderService extends BaseService{
	
	public List<OrderModel> getOrders(int pagenow, int pagesize){
	    Query q = this.getSessionFactory().getCurrentSession().createQuery("FROM OrderModel");
	    q.setFirstResult((pagenow-1)*pagesize);
	    q.setMaxResults(pagesize);
		return q.list();
	}

	
	
	public OrderModel saveOrUpdate(OrderModel model){
		try{
			this.getHibernateTemplate().saveOrUpdate(model);
		}catch(Exception e){
			e.printStackTrace();
			return null; 
		}
		return model; 
	}


	

	public boolean deleteOrderBypkey(int pkey) {
		try{
			this.getHibernateTemplate().delete(new OrderModel(pkey));
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
		
	}
}
