package com.liman.www.user.controller;

import com.liman.www.user.bean.UmsMember;
import com.liman.www.user.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserSevice userSevice;

    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMemberList = userSevice.getAllUmsMember();
        return umsMemberList;
    }


}
