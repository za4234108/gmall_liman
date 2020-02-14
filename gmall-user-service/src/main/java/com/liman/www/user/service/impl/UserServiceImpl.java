package com.liman.www.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liman.www.bean.UmsMember;
import com.liman.www.bean.UmsMemberReceiveAddress;
import com.liman.www.service.UserService;
import com.liman.www.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2020年01月10日 19:31:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UmsMember> getAllUmsMember() {
        List<UmsMember> umsMemberList = userMapper.getAllUmsMember();
        return umsMemberList;
    }

    @Override
    public List<UmsMemberReceiveAddress> getAllUmsMemberReceiveAddress(String memberid) {
        List<UmsMemberReceiveAddress> umsMemberReceiveAddressList = userMapper.getAllUmsMemberReceiveAddress(memberid);
        return umsMemberReceiveAddressList;
    }

    @Override
    public void deteleUmsMember(String memberid) {
        userMapper.deteleUmsMember(memberid);
    }
}
