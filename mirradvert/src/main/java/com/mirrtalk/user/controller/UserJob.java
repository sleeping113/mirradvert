package com.mirrtalk.user.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.mirrtalk.user.domain.User;
import com.mirrtalk.user.service.UserService;

/**
 * user 定时调度
 * @author wangliming
 * @date 2014-4-14 下午10:51:37
 * @version 1.0
 */
public class UserJob {

	private Logger logger = Logger.getLogger(UserJob.class);
	
	@Autowired
	private UserService userService;
	
	public void findAllUser(){
		List<User> user = userService.findAllUser();
		logger.info(user.toString());
	}
}
