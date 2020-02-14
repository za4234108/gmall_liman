package com.liman.www.manage.mapper;

import com.liman.www.bean.PmsSkuInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PmsSkuInfoMapper.java
 * @Description TODO
 * @createTime 2020年02月14日 11:34:00
 */
@Mapper
public interface PmsSkuInfoMapper {
    void insert(PmsSkuInfo pmsSkuInfo);
}
