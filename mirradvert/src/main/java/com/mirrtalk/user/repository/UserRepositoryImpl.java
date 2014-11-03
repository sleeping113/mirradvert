package com.mirrtalk.user.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mirrtalk.user.domain.User;

/** 
 * 用户持久化实现类
 * @author wangliming 
 * @date 2014-3-14 下午10:47:26
 * @version 1.0
 */
public class UserRepositoryImpl {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * jpql
	 * @return List<user>
	 */
	@SuppressWarnings("unchecked")
	public List<User> getUser(){
		Query query = em.createQuery("from User").setHint("org.hibernate.cacheable", true);
		List<User> users = query.getResultList();
		return users;
	}
	
	/**
	 * 原生sql
	 * @return List<User>
	 */
	@SuppressWarnings("unchecked")
	public List<User> getUserList(){
		Query query = em.createNativeQuery("select * from t_user");
		return query.getResultList();
	}
	
	/**
	 * 命名查询
	 * @return List<User>
	 */
	@SuppressWarnings("unchecked")
	public List<User> findAllUser(){
		Query query = em.createNamedQuery("findAllUser");
		return query.getResultList();
	}
	
	/**
	 * 命名查询
	 * @return List<User>
	 */
	@SuppressWarnings("unchecked")
	public List<User> userQuery(){
		Query query = em.createNamedQuery("ReturnUserList");
		return query.getResultList();
	}
}
