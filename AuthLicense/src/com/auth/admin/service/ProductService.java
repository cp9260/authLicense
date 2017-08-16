package com.auth.admin.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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



	public int checkProductID(String productID) {
		try{
			
			Map<String, Object> map = jdbcTemplate.queryForMap("Select pkey from T_SYS_PRODUCT where pkey=?", productID);
			if(map != null){
				int temp = Integer.parseInt(map.get("pkey").toString());
				return temp;
			}
			
		}catch(Exception e){
			return -1;
		}
		return -1;
	}
	
	
}
