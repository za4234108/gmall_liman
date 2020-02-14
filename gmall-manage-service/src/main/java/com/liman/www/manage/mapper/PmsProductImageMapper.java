package com.liman.www.manage.mapper;

import com.liman.www.bean.PmsProductImage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PmsProductImageMapper.java
 * @Description TODO
 * @createTime 2020年02月08日 15:11:00
 */
@Mapper
public interface PmsProductImageMapper {
    void insert(List<PmsProductImage> pmsProductImageList, String id);

    List<PmsProductImage> selectByProductId(String spuId);
}
