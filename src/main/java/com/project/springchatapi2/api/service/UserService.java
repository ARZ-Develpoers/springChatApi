package com.project.springchatapi2.api.service;

import com.project.springchatapi2.api.mapper.UserMapper;
import com.project.springchatapi2.domain.tUsr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public int addUser(tUsr tusr){
        return userMapper.addUser(tusr);
    }

    public List<tUsr> getUsers(HashMap<String, Object> serviceParamMap) throws Exception{
        return userMapper.getUsers(serviceParamMap);
    }

    public tUsr getUserByUseKey(int usrKey){
        return userMapper.getUserByUsrKey(usrKey);
    }

    public int deleteUserByUsrKey(int usrKey){
        return userMapper.deleteUserByUsrKey(usrKey);
    }

    public int setUser(tUsr tUsr){
        return userMapper.setUserBy(tUsr);
    }
}
