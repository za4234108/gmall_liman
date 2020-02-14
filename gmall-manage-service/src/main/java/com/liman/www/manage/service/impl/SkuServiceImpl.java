package com.liman.www.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liman.www.bean.PmsSkuAttrValue;
import com.liman.www.bean.PmsSkuImage;
import com.liman.www.bean.PmsSkuInfo;
import com.liman.www.bean.PmsSkuSaleAttrValue;
import com.liman.www.manage.mapper.PmsSkuAttrValueMapper;
import com.liman.www.manage.mapper.PmsSkuImageMapper;
import com.liman.www.manage.mapper.PmsSkuInfoMapper;
import com.liman.www.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.liman.www.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SkuServiceImpl.java
 * @Description TODO
 * @createTime 2020年02月14日 11:31:00
 */
@Service
@Transactional
public class SkuServiceImpl implements SkuService {

    @Autowired
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Autowired
    PmsSkuImageMapper pmsSkuImageMapper;

    @Autowired
    PmsSkuInfoMapper pmsSkuInfoMapper;

    @Autowired
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {
        pmsSkuInfo.setProductId(pmsSkuInfo.getSpuId());
        if (pmsSkuInfo.getSkuDefaultImg() == null || pmsSkuInfo.getSkuDefaultImg() == "") {
            pmsSkuInfo.setSkuDefaultImg(pmsSkuInfo.getSkuImageList().get(0).getImgUrl());
            pmsSkuInfo.getSkuImageList().get(0).setIsDefault("1");
        }
        //增加sku基本信息
        pmsSkuInfoMapper.insert(pmsSkuInfo);
        String skuId = pmsSkuInfo.getId();

        //增加sku平台属性值
        List<PmsSkuAttrValue> pmsSkuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        pmsSkuAttrValueMapper.insert(pmsSkuAttrValueList, skuId);

        //增加sku销售属性值
        List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        if (pmsSkuAttrValueList != null && pmsSkuAttrValueList.size() != 0) {
            pmsSkuSaleAttrValueMapper.insert(pmsSkuSaleAttrValueList, skuId);
        }


        //增加sku图片对象数据
        List<PmsSkuImage> pmsSkuImageList = pmsSkuInfo.getSkuImageList();
        pmsSkuImageMapper.insert(pmsSkuImageList, skuId);


    }
}
