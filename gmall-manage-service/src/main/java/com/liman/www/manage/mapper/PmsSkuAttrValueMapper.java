package com.liman.www.manage.mapper;

import com.liman.www.bean.PmsSkuAttrValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PmsSkuAttrValueMapper.java
 * @Description TODO
 * @createTime 2020年02月14日 11:34:00
 */
@Mapper
public interface PmsSkuAttrValueMapper {
    void insert(List<PmsSkuAttrValue> pmsSkuAttrValueList, String skuId);
}
