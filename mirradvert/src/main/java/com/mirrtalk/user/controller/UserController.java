package com.mirrtalk.user.controller;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mirrtalk.user.domain.User;
import com.mirrtalk.user.service.UserService;
import com.mirrtalk.user.vo.UserVo;

/** 
 * 用户控制层类
 * @author wangliming 
 * @date 2014-3-12 下午7:10:08
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/initForm")
	public ModelAndView initForm(){
		ModelAndView mav = new ModelAndView("login");
		UserVo user = new UserVo();
		mav.addObject("user", user);
		return mav;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public String login(@ModelAttribute("user") UserVo userVo){
		if(("admin").equals(userVo.getAccount()) && ("admin").equals(userVo.getPassword())){
			return "success";
		}else{
			return "fail";
		}
	}
	
	@RequestMapping(value = "/findUser")
	@ResponseBody
	public User findByAccount(){
		logger.info("query user information-----------------------------------");
		User user = userService.findByAccount("zhouhc");
		logger.info("user information:" + JSONObject.fromObject(user).toString());
		logger.info("close the query interface---------------------------------");
		return user;
	}
	
	@RequestMapping(value = "/findByAccountLike")
	@ResponseBody
	public User findByAccountLike(){
		logger.info("query user informatioin-----------------------------------");
		User user = userService.findByAccountLike("%花%");
		logger.info("user information:" + JSONObject.fromObject(user).toString());
		logger.info("close the query interface---------------------------------");
		return user;
	}
	
	@RequestMapping(value = "/findByAccountIn")
	@ResponseBody
	public List<User> findByAccountIn(){
		logger.info("query user information------------------------------------");
		List<String> accounts = new ArrayList<String>(); 
		accounts.add("zhouhc");
		accounts.add("叶花仙");
		List<User> users = userService.findByAccountIn(accounts);
		logger.info("user informatio:" + JSONArray.fromObject(users).toString());
		logger.info("close the query interface---------------------------------");
		return users;
	}
	
	@RequestMapping(value = "/findByAccountAndPassword")
	@ResponseBody
	public User findByAccountAndPassword(){
		logger.info("query user information------------------------------------");
		User user = userService.findByAccountAndPassword("zhouhc", "123456");
		logger.info("user information:" + JSONObject.fromObject(user).toString());
		logger.info("close the query interface---------------------------------");
		return user;
	}
	
	@RequestMapping(value = "/findByAccountAndPage")
	@ResponseBody
	public List<User> findByAccountAndPage(){
		Pageable pageable = new PageRequest(0, 1);
		List<User> users = userService.findByAccount("zhouhc", pageable);
		return users;
	}
	
	@RequestMapping(value = "/findUserByQuery")
	@ResponseBody
	public User findUserByQuery(){
		User user = userService.findUserByQuery("zhouhc");
		return user;
	}
	
	@RequestMapping(value ="/findUserByparam")
	@ResponseBody
	public User findUserByparam(){
		return userService.findUserByParam("zhouhc");
	}
	
	@RequestMapping(value = "/getUser")
	@ResponseBody
	public List<User> getUser(){
		return userService.getUser();
	}
	
	@RequestMapping(value ="/getUserList")
	@ResponseBody
	public List<User> getUserList(){
		return userService.getUserList();
	}
	
	@RequestMapping(value = "/findAllUser")
	@ResponseBody
	public List<User> findAllUser(){
		return userService.findAllUser();
	}
	
	@RequestMapping(value = "/userQuery")
	@ResponseBody
	public List<User> userQuery(){
		return userService.userQuery();
	}
	
	@RequestMapping(value = "/saveUser")
	public void saveUser(User user){
		user.setAccount("IT攻城狮");
		user.setPassword("123456");
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			logger.info(e.toString());
		}
	}
}
