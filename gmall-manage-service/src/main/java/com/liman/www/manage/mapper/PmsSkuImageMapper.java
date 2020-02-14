package com.liman.www.manage.mapper;

import com.liman.www.bean.PmsSkuImage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PmsSkuImageMapper.java
 * @Description TODO
 * @createTime 2020年02月14日 11:34:00
 */
@Mapper
public interface PmsSkuImageMapper {
    void insert(List<PmsSkuImage> pmsSkuImageList, String skuId);
}
