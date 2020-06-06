package com.smc.service;


import java.util.Date;

import com.smc.entity.UserInfo;

public interface UserService {
   
	UserInfo getUserByUsername(String username);
	UserInfo saveUserInfo(UserInfo userInfo);
    int setConfirmedByUsername(String username, String confirmed);
    int setUpdatetsByUsername(String username, Date updatets);
    UserInfo getUserByUsernameAndPassword(String username, String password);
    
	}