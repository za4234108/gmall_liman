package com.liman.www.service;

import com.liman.www.bean.PmsBaseAttrInfo;
import com.liman.www.bean.PmsBaseAttrValue;
import com.liman.www.bean.PmsBaseSaleAttr;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AttrService.java
 * @Description TODO
 * @createTime 2020年02月05日 11:13:00
 */
public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> baseSaleAttrList();
}
