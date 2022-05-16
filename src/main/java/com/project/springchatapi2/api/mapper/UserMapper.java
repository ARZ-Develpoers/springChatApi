package com.project.springchatapi2.api.mapper;

import com.project.springchatapi2.domain.tUsr;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {

    public List<tUsr> getUsers(HashMap<String, Object> serviceParamMap);

    public tUsr getUserByUsrKey(int usrKey);

    public int addUser(tUsr tUsr);

    public int deleteUserByUsrKey(int usrKey);

    public int setUserByUsrKey(tUsr tUsr);
}
