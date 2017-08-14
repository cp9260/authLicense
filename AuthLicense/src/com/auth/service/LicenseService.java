package com.auth.service;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auth.model.AuthModel;
import com.auth.model.ProductModel;

@Service("licenseService")
@Transactional
public class LicenseService extends BaseService{
	
	public List<AuthModel> getProducts(int pagenow, int pagesize){
	    Query q = this.getSessionFactory().getCurrentSession().createQuery("FROM AuthModel");
	    q.setFirstResult((pagenow-1)*pagesize);
	    q.setMaxResults(pagesize);
		return q.list();
	}

	
	
	public AuthModel saveOrUpdate(AuthModel model){
		try{
			this.getHibernateTemplate().saveOrUpdate(model);
		}catch(Exception e){
			e.printStackTrace();
			return null; 
		}
		return model; 
	}


	

	public boolean deleteLicenseBypkey(int pkey) {
		try{
			this.getHibernateTemplate().delete(new AuthModel(pkey));
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
		
	}
}
