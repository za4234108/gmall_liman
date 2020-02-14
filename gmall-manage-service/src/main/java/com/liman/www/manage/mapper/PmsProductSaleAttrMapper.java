package com.liman.www.manage.mapper;

import com.liman.www.bean.PmsProductSaleAttr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PmsProductSaleAttrMapper.java
 * @Description TODO
 * @createTime 2020年02月08日 15:11:00
 */
@Mapper
public interface PmsProductSaleAttrMapper {
    void insert(List<PmsProductSaleAttr> pmsProductSaleAttrList, String id);

    List<PmsProductSaleAttr> selectBySpuId(String spuId);
}
