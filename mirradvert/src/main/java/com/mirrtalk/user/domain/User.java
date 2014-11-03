package com.mirrtalk.user.domain;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 用户实体bean
 * 
 * @author wangliming
 * @date 2014-3-12 下午5:51:41
 * @version 1.0
 */
@SuppressWarnings("serial")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY,region="baseCache")
@Cacheable(true)
@Entity
@Table(name = "t_user")
@NamedQueries({ @NamedQuery(name = "findAllUser", query = "from User") })
@NamedNativeQueries({ @NamedNativeQuery(name = "ReturnUserList", query = "select * from t_user", resultSetMapping = "ReturnUserList") })
@SqlResultSetMappings({ @SqlResultSetMapping(name = "ReturnUserList", entities = { @EntityResult(entityClass = User.class) }) })
public class User implements Serializable {

	/**
	 * 用户id
	 */
	private Integer id;

	/**
	 * 用户账号
	 */
	private String account;

	/**
	 * 用户密码
	 */
	private String password;

	/**
	 * 获取用户id
	 * 
	 * @return id
	 */
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	/**
	 * 设置用户id
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取用户账号
	 * 
	 * @return account
	 */
	@Column(length = 25, nullable = false, unique = true)
	public String getAccount() {
		return account;
	}

	/**
	 * 设置用户账号
	 * 
	 * @param account
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * 获取用户密码
	 * 
	 * @return password
	 */
	@Column(length = 25, nullable = false)
	public String getPassword() {
		return password;
	}

	/**
	 * 设置用户密码
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
