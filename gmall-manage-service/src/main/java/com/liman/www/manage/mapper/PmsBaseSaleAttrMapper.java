package com.liman.www.manage.mapper;

import com.liman.www.bean.PmsBaseSaleAttr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PmsBaseSaleAttrMapper.java
 * @Description TODO
 * @createTime 2020年02月07日 19:26:00
 */
@Mapper
public interface PmsBaseSaleAttrMapper {
    List<PmsBaseSaleAttr> selectAll();
}
