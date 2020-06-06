package com.smc.dao;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;

import com.smc.entity.UserInfo;


public interface UserDao extends JpaRepository<UserInfo,Long>{

	UserInfo findByUsername(String username);
	
	 @Modifying
	 @Transactional
	 @Query("update UserInfo u set u.confirmed = :confirmed where u.username=:username")
	 int saveUsersByUsernameAndConfirmed(@Param("username") String username, @Param("confirmed") String confirmed);
	
	 @Modifying
	 @Transactional
	 @Query("update UserInfo u set u.updatets = :updatets where u.username=:username")
	 int saveUsersByUsernameAndUpdatets(@Param("username") String username, @Param("updatets") Date updatets);
	
	 UserInfo findByUsernameAndPassword(String username, String password);



}
