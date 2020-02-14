package com.liman.www.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liman.www.bean.PmsSkuInfo;
import com.liman.www.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SkuController.java
 * @Description TODO
 * @createTime 2020年02月13日 21:53:00
 */
@Controller
@CrossOrigin
@Transactional
public class SkuController {
    @Reference
    SkuService skuService;


    @RequestMapping("saveSkuInfo")
    @ResponseBody
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo) {

        skuService.saveSkuInfo(pmsSkuInfo);

        return "success";
    }
}
