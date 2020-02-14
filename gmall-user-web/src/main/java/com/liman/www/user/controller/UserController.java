package com.liman.www.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liman.www.bean.UmsMember;
import com.liman.www.bean.UmsMemberReceiveAddress;
import com.liman.www.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2020年01月10日 19:30:00
 */
@Controller
@Transactional
public class UserController {

    @Reference
    private UserService userSevice;

    @RequestMapping("/getAllUmsMember")
    @ResponseBody
    public List<UmsMember> getAllUmsMember() {
        List<UmsMember> umsMemberList = userSevice.getAllUmsMember();
        return umsMemberList;
    }

    @RequestMapping("/deteleUmsMember")
    @ResponseBody
    public List<UmsMember> deteleUmsMember(String memberid) {
        userSevice.deteleUmsMember(memberid);
        List<UmsMember> umsMemberList = userSevice.getAllUmsMember();
        return umsMemberList;
    }


    @RequestMapping("/getAllUmsMemberReceiveAddress")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getAllUmsMemberReceiveAddress(String memberid) {
        List<UmsMemberReceiveAddress> umsMemberReceiveAddressList = userSevice.getAllUmsMemberReceiveAddress(memberid);
        return umsMemberReceiveAddressList;
    }
}
