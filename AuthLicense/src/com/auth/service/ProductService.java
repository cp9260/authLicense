package com.auth.service;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auth.model.ProductModel;

@Service("productService")
@Transactional
public class ProductService extends BaseService{
	
	public List<ProductModel> getProducts(int pagenow, int pagesize){
	    Query q = this.getSessionFactory().getCurrentSession().createQuery("FROM ProductModel");
	    q.setFirstResult((pagenow-1)*pagesize);
	    q.setMaxResults(pagesize);
		return q.list();
	}

	
	
	public ProductModel saveOrUpdate(ProductModel model){
		try{
			this.getHibernateTemplate().saveOrUpdate(model);
		}catch(Exception e){
			e.printStackTrace();
			return null; 
		}
		return model; 
	}


	

	public boolean deleteProductBypkey(int pkey) {
		try{
			this.getHibernateTemplate().delete(new ProductModel(pkey));
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
		
	}
}
