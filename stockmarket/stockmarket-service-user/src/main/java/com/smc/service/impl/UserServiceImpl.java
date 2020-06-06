package com.smc.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smc.entity.UserInfo;
import com.smc.service.UserService;
import com.smc.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public UserInfo getUserByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	public UserInfo saveUserInfo(UserInfo userInfo) {
		return userDao.save(userInfo);
	};
	
	public int setConfirmedByUsername(String username, String confirmed) {
		return userDao.saveUsersByUsernameAndConfirmed(username, "1");
	};
	
	public int setUpdatetsByUsername(String username, Date updatets) {
		return userDao.saveUsersByUsernameAndUpdatets(username, updatets);
	};

	public UserInfo getUserByUsernameAndPassword(String username, String password) {
		return userDao.findByUsername(username);
	}
    
}