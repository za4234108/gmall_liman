package com.liman.www.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liman.www.bean.PmsBaseAttrInfo;
import com.liman.www.bean.PmsBaseAttrValue;
import com.liman.www.bean.PmsBaseSaleAttr;
import com.liman.www.manage.mapper.PmsBaseAttrInfoMapper;
import com.liman.www.manage.mapper.PmsBaseAttrValueMapper;
import com.liman.www.manage.mapper.PmsBaseSaleAttrMapper;
import com.liman.www.service.AttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AttrServiceImpl.java
 * @Description TODO
 * @createTime 2020年02月05日 11:16:00
 */
@Service
@Transactional
public class AttrServiceImpl implements AttrService {
    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;

    /**
     * 根据三级分类的id查询平台属性和平台属性值
     *
     * @param catalog3Id
     * @return
     */
    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        List<PmsBaseAttrInfo> pmsBaseAttrInfoList = pmsBaseAttrInfoMapper.selectByCatalog3Id(catalog3Id);
        List<PmsBaseAttrValue> pmsBaseAttrValueList = pmsBaseAttrValueMapper.select(pmsBaseAttrInfoList);
        for (int i = 0; i < pmsBaseAttrInfoList.size(); i++) {
            String id = pmsBaseAttrInfoList.get(i).getId();
            List<PmsBaseAttrValue> earchPmsBaseAttrValueList = new ArrayList<>();
            for (int j = 0; j < pmsBaseAttrValueList.size(); j++) {
                PmsBaseAttrValue earchPmsBaseAttrValue = pmsBaseAttrValueList.get(j);
                String attrId = earchPmsBaseAttrValue.getAttrId();
                if (id.equals(attrId)) {
                    earchPmsBaseAttrValueList.add(earchPmsBaseAttrValue);
                }
            }
            pmsBaseAttrInfoList.get(i).setAttrValueList(earchPmsBaseAttrValueList);
        }
        return pmsBaseAttrInfoList;
    }

    /**
     * 根据前台封装过得pmsBaseAttrInfo对象对平台属性表和平台属性值表进行添加和修改操作
     *
     * @param pmsBaseAttrInfo
     * @return
     */
    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        String id = pmsBaseAttrInfo.getId();
        if (StringUtils.isBlank(id)) {
            pmsBaseAttrInfoMapper.insert(pmsBaseAttrInfo);
            String attrInfoId = pmsBaseAttrInfo.getId();
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            pmsBaseAttrValueMapper.insertByAttrId(attrValueList, attrInfoId);
        } else {
            pmsBaseAttrInfoMapper.updateById(pmsBaseAttrInfo);
            pmsBaseAttrValueMapper.deleteByAttrId(id);
            List<PmsBaseAttrValue> pmsBaseAttrValueList = pmsBaseAttrInfo.getAttrValueList();
            pmsBaseAttrValueMapper.insertByAttrId(pmsBaseAttrValueList, id);
        }

        return "success";
    }

    /**
     * 根据平台属性id查询对应的平台属性值
     *
     * @param attrId
     * @return
     */
    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        List<PmsBaseAttrValue> pmsBaseAttrValueList = pmsBaseAttrValueMapper.selectByAttrId(attrId);
        return pmsBaseAttrValueList;
    }

    /**
     * 查询平台提供的销售属性
     *
     * @return
     */
    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        List<PmsBaseSaleAttr> pmsBaseSaleAttrList = pmsBaseSaleAttrMapper.selectAll();
        return pmsBaseSaleAttrList;
    }
}
