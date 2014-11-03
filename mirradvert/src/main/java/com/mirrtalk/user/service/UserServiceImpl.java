package com.mirrtalk.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mirrtalk.user.domain.User;
import com.mirrtalk.user.repository.UserRepository;
import com.mirrtalk.user.repository.UserRepositoryImpl;

/** 
 * 用户服务层实现类
 * @author wangliming 
 * @date 2014-3-12 下午7:04:29
 * @version 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRepositoryImpl userRepositoryImpl;
	
	@Override
	public User findByAccount(String account) {
		return userRepository.findByAccount(account);
	}

	@Override
	public User findByAccountLike(String account) {
		return userRepository.findByAccountLike(account);
	}

	@Override
	public List<User> findByAccountIn(List<String> account) {
		return userRepository.findByAccountIn(account);
	}

	@Override
	public User findByAccountAndPassword(String account, String password) {
		return userRepository.findByAccountAndPassword(account, password);
	}

	@Override
	public List<User> findByAccount(String account, Pageable pageable) {
		return userRepository.findByAccount(account, pageable).getContent();
	}

	@Override
	public User findUserByQuery(String account) {
		return userRepository.findUserByQuery(account);
	}

	@Override
	public User findUserByParam(String account) {
		return userRepository.findUserByParam(account);
	}

	@Override
	public List<User> getUser() {
		return userRepositoryImpl.getUser();
	}

	@Override
	public List<User> getUserList() {
		return userRepositoryImpl.getUserList();
	}

	@Override
	public List<User> findAllUser() {
		return userRepositoryImpl.findAllUser();
	}

	@Override
	public List<User> userQuery() {
		return userRepositoryImpl.userQuery();
	}

	@Override
	public void saveUser(User user) throws RuntimeException {
		userRepository.save(user);
		throw new RuntimeException();
	}

}
