package com.liman.www.manage.mapper;

import com.liman.www.bean.PmsProductInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PmsProductInfoMapper.java
 * @Description TODO
 * @createTime 2020年02月07日 00:44:00
 */
@Mapper
public interface PmsProductInfoMapper {

    List<PmsProductInfo> selectByCatalog3Id(String catalog3Id);

    void insert(PmsProductInfo pmsProductInfo);
}
