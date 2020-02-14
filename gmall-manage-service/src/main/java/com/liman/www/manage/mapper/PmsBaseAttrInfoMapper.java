package com.liman.www.manage.mapper;

import com.liman.www.bean.PmsBaseAttrInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PmsBaseAttrInfoMapper.java
 * @Description TODO
 * @createTime 2020年02月05日 11:20:00
 */
@Mapper
public interface PmsBaseAttrInfoMapper {
    List<PmsBaseAttrInfo> selectByCatalog3Id(String catalog3Id);

    void insert(PmsBaseAttrInfo pmsBaseAttrInfo);

    void updateById(PmsBaseAttrInfo pmsBaseAttrInfo);
}
