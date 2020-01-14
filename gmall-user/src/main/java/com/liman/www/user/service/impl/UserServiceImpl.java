package com.liman.www.user.service.impl;

import com.liman.www.user.bean.UmsMember;
import com.liman.www.user.mapper.UserMapper;
import com.liman.www.user.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2020年01月10日 19:31:00
 */
@Service
public class UserServiceImpl implements UserSevice {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UmsMember> getAllUmsMember() {
        List<UmsMember> umsMemberList = userMapper.getAllUmsMember();
        return umsMemberList;
    }
}
