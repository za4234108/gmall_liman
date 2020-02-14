package com.liman.www.manage.mapper;

import com.liman.www.bean.PmsProductSaleAttr;
import com.liman.www.bean.PmsProductSaleAttrValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PmsProductSaleAttrValueMapper.java
 * @Description TODO
 * @createTime 2020年02月08日 15:12:00
 */
@Mapper
public interface PmsProductSaleAttrValueMapper {
    void insert(List<List<PmsProductSaleAttrValue>> pmsProductSaleAttrValueList, String id);

    List<PmsProductSaleAttrValue> selectBySaleAttrIdAndProductId(List<PmsProductSaleAttr> pmsProductSaleAttrList, String spuId);
}
