package com.liman.www.manage.mapper;

import com.liman.www.bean.PmsBaseAttrInfo;
import com.liman.www.bean.PmsBaseAttrValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PmsBaseAttrValueMapper.java
 * @Description TODO
 * @createTime 2020年02月05日 11:20:00
 */
@Mapper
public interface PmsBaseAttrValueMapper {
    void insertByAttrId(List<PmsBaseAttrValue> attrValueList, String attrInfoId);

    List<PmsBaseAttrValue> selectByAttrId(String attrId);

    void deleteByAttrId(String id);

    List<PmsBaseAttrValue> select(List<PmsBaseAttrInfo> pmsBaseAttrInfoList);
}
