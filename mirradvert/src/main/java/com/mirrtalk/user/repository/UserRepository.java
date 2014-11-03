package com.mirrtalk.user.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import com.mirrtalk.user.domain.User;

/**
 * 用户持久化接口
 * 
 * @author wangliming
 * @date 2014-3-12 下午5:58:48
 * @version 1.0
 */
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * 根据账号查询用户
	 * 
	 * @param account
	 * @return User
	 */
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	User findByAccount(String account);

	/**
	 * 根据账号模糊查询
	 * 
	 * @param account
	 * @return User
	 */
	User findByAccountLike(String account);

	/**
	 * 指定范围内查询数据列表
	 * 
	 * @param account
	 * @return List<User>
	 */
	List<User> findByAccountIn(List<String> account);

	/**
	 * 根据账号和密码查询用户信息
	 * 
	 * @param accout
	 * @param password
	 * @return User
	 */
	User findByAccountAndPassword(String account, String password);

	/**
	 * 根据账号分页查询
	 * 
	 * @param account
	 * @param pageable
	 * @return Page<User>
	 */
	Page<User> findByAccount(String account, Pageable pageable);

	/**
	 * 根据自定义语句查询
	 * 
	 * @param account
	 * @return User
	 */
	@Query("from User where account = ?1")
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	User findUserByQuery(String account);

	/**
	 * 根据指定别名查询
	 * 
	 * @param account
	 * @return User
	 */
	@Query("from User u where u.account = :acc")
	User findUserByParam(@Param("acc") String account);
}
