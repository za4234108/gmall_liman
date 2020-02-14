package com.liman.www.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liman.www.bean.PmsBaseCatalog1;
import com.liman.www.bean.PmsBaseCatalog2;
import com.liman.www.bean.PmsBaseCatalog3;
import com.liman.www.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CatalogController.java
 * @Description TODO
 * @createTime 2020年02月03日 11:28:00
 */
@Controller
@Transactional
@CrossOrigin
public class CatalogController {

    @Reference
    CatalogService service;


    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1() {
        List<PmsBaseCatalog1> pmsBaseCatalog1List = service.getCatalog1();
        return pmsBaseCatalog1List;
    }

    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        List<PmsBaseCatalog2> pmsBaseCatalog2List = service.getCatalog2(catalog1Id);
        return pmsBaseCatalog2List;
    }

    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        List<PmsBaseCatalog3> pmsBaseCatalog3List = service.getCatalog3(catalog2Id);
        return pmsBaseCatalog3List;
    }
}
