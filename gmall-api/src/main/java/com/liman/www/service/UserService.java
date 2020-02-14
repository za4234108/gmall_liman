package com.liman.www.service;

import com.liman.www.bean.UmsMember;
import com.liman.www.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2020年01月10日 19:30:00
 */
public interface UserService {

    List<UmsMember> getAllUmsMember();


    List<UmsMemberReceiveAddress> getAllUmsMemberReceiveAddress(String memberid);

    void deteleUmsMember(String memberid);
}
