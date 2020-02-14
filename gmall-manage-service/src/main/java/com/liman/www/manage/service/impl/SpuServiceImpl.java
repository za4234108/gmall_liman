package com.liman.www.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liman.www.bean.PmsProductImage;
import com.liman.www.bean.PmsProductInfo;
import com.liman.www.bean.PmsProductSaleAttr;
import com.liman.www.bean.PmsProductSaleAttrValue;
import com.liman.www.manage.mapper.PmsProductImageMapper;
import com.liman.www.manage.mapper.PmsProductInfoMapper;
import com.liman.www.manage.mapper.PmsProductSaleAttrMapper;
import com.liman.www.manage.mapper.PmsProductSaleAttrValueMapper;
import com.liman.www.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SpuServiceImpl.java
 * @Description TODO
 * @createTime 2020年02月07日 00:43:00
 */
@Service
@Transactional
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;

    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Autowired
    PmsProductImageMapper pmsProductImageMapper;

    /**
     * 根据三级分类id得到所有的spu信息
     *
     * @param catalog3Id
     * @return
     */
    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        List<PmsProductInfo> pmsProductInfoList = pmsProductInfoMapper.selectByCatalog3Id(catalog3Id);
        return pmsProductInfoList;
    }

    /**
     * 增加spu信息,spu图片对象数据,spu销售属性
     *
     * @param pmsProductInfo
     */
    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {


        //增加spu基本信息
        pmsProductInfoMapper.insert(pmsProductInfo);
        String id = pmsProductInfo.getId();

        //增加spu图片对象数据
        List<PmsProductImage> pmsProductImageList = pmsProductInfo.getSpuImageList();
        pmsProductImageMapper.insert(pmsProductImageList, id);

        //增加spu销售属性
        List<PmsProductSaleAttr> pmsProductSaleAttrList = pmsProductInfo.getSpuSaleAttrList();
        List<List<PmsProductSaleAttrValue>> pmsProductSaleAttrValueList = new ArrayList<>();
        for (int i = 0; i < pmsProductSaleAttrList.size(); i++) {
            PmsProductSaleAttr pmsProductSaleAttr = pmsProductSaleAttrList.get(i);
            List<PmsProductSaleAttrValue> pmsProductSaleAttrValues = pmsProductSaleAttr.getSpuSaleAttrValueList();
            pmsProductSaleAttrValueList.add(pmsProductSaleAttrValues);
        }
        pmsProductSaleAttrMapper.insert(pmsProductSaleAttrList, id);
        pmsProductSaleAttrValueMapper.insert(pmsProductSaleAttrValueList, id);
    }

    /**
     * 添加sku操作时根据spuId得到事先添加好的销售属性和销售属性值
     *
     * @param spuId
     * @return
     */
    @Override
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {
        List<PmsProductSaleAttr> pmsProductSaleAttrList = pmsProductSaleAttrMapper.selectBySpuId(spuId);
        if (pmsProductSaleAttrList != null && pmsProductSaleAttrList.size() != 0) {
            List<PmsProductSaleAttrValue> pmsProductSaleAttrValueList = pmsProductSaleAttrValueMapper.selectBySaleAttrIdAndProductId(pmsProductSaleAttrList, spuId);
            for (int i = 0; i < pmsProductSaleAttrList.size(); i++) {
                PmsProductSaleAttr tempPmsProductSaleAttr = pmsProductSaleAttrList.get(i);
                String SaleAttr_SaleAttrId = tempPmsProductSaleAttr.getSaleAttrId();
                List<PmsProductSaleAttrValue> tempPmsProductSaleAttrValueList = new ArrayList<>();
                for (int j = 0; j < pmsProductSaleAttrValueList.size(); j++) {
                    PmsProductSaleAttrValue tempPmsProductSaleAttrValue = pmsProductSaleAttrValueList.get(j);
                    String SaleAttrValue_SaleAttrId = tempPmsProductSaleAttrValue.getSaleAttrId();
                    if (SaleAttr_SaleAttrId.equals(SaleAttrValue_SaleAttrId)) {
                        tempPmsProductSaleAttrValueList.add(tempPmsProductSaleAttrValue);
                    }
                }
                tempPmsProductSaleAttr.setSpuSaleAttrValueList(tempPmsProductSaleAttrValueList);
            }
        }

        return pmsProductSaleAttrList;
    }

    @Override
    public List<PmsProductImage> spuImageList(String spuId) {
        List<PmsProductImage> pmsProductImageList = pmsProductImageMapper.selectByProductId(spuId);
        return pmsProductImageList;
    }


}
