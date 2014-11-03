package com.mirrtalk.user.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.mirrtalk.user.domain.User;

/** 
 * 用户服务层接口
 * @author wangliming 
 * @date 2014-3-12 下午7:01:07
 * @version 1.0
 */
public interface UserService {

	/**
	 * 根据账号查询用户
	 * @param account
	 * @return User
	 */
	User findByAccount(String account);
	
	/**
	 * 根据账号模糊查询
	 * @param account
	 * @return User
	 */
	User findByAccountLike(String account);
	
	/**
	 * 指定范围内查询数据列表
	 * @param account
	 * @return List<User>
	 */
	List<User> findByAccountIn(List<String> account);
	
	/**
	 * 根据账号和密码查询用户信息
	 * @param account
	 * @param password
	 * @return User
	 */
	User findByAccountAndPassword(String account, String password);
	
	/**
	 * 根据账号分页查询数据
	 * @param account
	 * @param pageable
	 * @return List<User>
	 */
	List<User> findByAccount(String account, Pageable pageable);
	
	/**
	 * 根据自定义语句查询
	 * @param account
	 * @return User
	 */
	User findUserByQuery(String account);
	
	/**
	 * 根据指定别名查询
	 * @param account
	 * @return User
	 */
	User findUserByParam(String account);
	
	/**
	 * 自定义查询用户信息
	 * @return List<User>
	 */
	List<User> getUser();
	
	/**
	 * 原生sql查询
	 * @return List<User>
	 */
	List<User> getUserList();
	
	/**
	 * 命名查询
	 * @return List<User>
	 */
	List<User> findAllUser();
	
	/**
	 * 命名查询
	 * @return List<User>
	 */
	List<User> userQuery();
	
	/**
	 * 保存用户数据
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	@Transactional
	void saveUser(User user) throws RuntimeException;
}
