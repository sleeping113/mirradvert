package com.mirrtalk.user.vo;

/**
 * 封装用户登录表单数据
 * 
 * @author wangliming
 * @date 2014-3-19 下午3:47:20
 * @version 1.0
 */
public class UserVo {

	/**
	 * 用户账号
	 */
	private String account;

	/**
	 * 用户密码
	 */
	private String password;

	/**
	 * 获取 account
	 * 
	 * @return account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * 设置 account
	 * 
	 * @param account
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * 获取 password
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置 password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
