package com.auth.admin.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auth.model.UserModel;

@Service("userInfoService")
@Transactional
public class UserInfoService extends BaseService{
	
	public List<UserModel> getUserInfos(int pagenow, int pagesize){
	    Query q = this.getSessionFactory().getCurrentSession().createQuery("FROM UserModel");
	    q.setFirstResult((pagenow-1)*pagesize);
	    q.setMaxResults(pagesize);
		return q.list();
	}

	
	public int checkUser(String userName,String Password,int status){
		try{
			
			Map<String, Object> map = jdbcTemplate.queryForMap("Select pkey from T_USER_INFOS where userName=? and password=? and status = ?", userName,Password,status);
			if(map != null){
				int temp = Integer.parseInt(map.get("pkey").toString());
				return temp;
			}
			
		}catch(Exception e){
			return -1;
		}
		return -1;
	}
	
	public UserModel checkUserForModel(String userName,String Password,int status){
		UserModel user = null;
		int id  = checkUser(userName, Password,status);
		if(id!=-1){
			user = this.getHibernateTemplate().get(UserModel.class, id);
		}
		return user;
	}
	
	public UserModel saveOrUpdate(UserModel user){
		try{
			this.getHibernateTemplate().saveOrUpdate(user);
		}catch(Exception e){
			e.printStackTrace();
			return null; 
		}
		return user; 
	}


	public int getUserCount(String name) {
		String table = "";
		if(name.equals("user")){
			table = "T_USER_INFOS";
		}else if (name.equals("product")){
			table = "T_SYS_PRODUCT";
		}else if (name.equals("license")){
			table = "T_SYS_AUTH";
		}else if (name.equals("order")){
			table = "T_AUTH_ORDER";
		}
		String sql = "select count(1) as count from "+ table;
		try{
			Map<String, Object> count = jdbcTemplate.queryForMap(sql);
			int num = Integer.parseInt(count.get("count").toString());
			return num;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}


	public boolean deleteUserBypkey(int pkey) {
		try{
			this.getHibernateTemplate().delete(new UserModel(pkey));
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
		
	}


	public int checkUserName(String name) {
		
		try{
			
			Map<String, Object> map = jdbcTemplate.queryForMap("Select pkey from T_USER_INFOS where userName=?", name);
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
