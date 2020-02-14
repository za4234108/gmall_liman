package com.liman.www.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liman.www.bean.PmsBaseAttrInfo;
import com.liman.www.bean.PmsBaseAttrValue;
import com.liman.www.bean.PmsBaseSaleAttr;
import com.liman.www.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AttrController.java
 * @Description TODO
 * @createTime 2020年02月05日 11:11:00
 */
@Controller
@CrossOrigin
@Transactional
public class AttrController {

    @Reference
    AttrService attrService;

    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        List<PmsBaseAttrInfo> pmsBaseAttrInfoList = attrService.attrInfoList(catalog3Id);
        return pmsBaseAttrInfoList;
    }


    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        String success = attrService.saveAttrInfo(pmsBaseAttrInfo);
        return success;
    }

    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        List<PmsBaseAttrValue> pmsBaseAttrValueList = attrService.getAttrValueList(attrId);
        return pmsBaseAttrValueList;
    }

    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        List<PmsBaseSaleAttr> pmsBaseSaleAttrList = attrService.baseSaleAttrList();
        return pmsBaseSaleAttrList;
    }


}
