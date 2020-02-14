package com.liman.www.service;

import com.liman.www.bean.PmsProductImage;
import com.liman.www.bean.PmsProductInfo;
import com.liman.www.bean.PmsProductSaleAttr;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SpuService.java
 * @Description TODO
 * @createTime 2020年02月07日 00:42:00
 */
public interface SpuService {
    List<PmsProductInfo> spuList(String catalog3Id);

    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    List<PmsProductImage> spuImageList(String spuId);
}
