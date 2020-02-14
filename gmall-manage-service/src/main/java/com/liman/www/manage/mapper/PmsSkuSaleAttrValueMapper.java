package com.liman.www.manage.mapper;

import com.liman.www.bean.PmsSkuSaleAttrValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PmsSkuSaleAttrValueMapper.java
 * @Description TODO
 * @createTime 2020年02月14日 11:35:00
 */
@Mapper
public interface PmsSkuSaleAttrValueMapper {
    void insert(List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValueList, String skuId);
}
