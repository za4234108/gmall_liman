package com.liman.www.manage.mapper;

import com.liman.www.bean.PmsBaseCatalog1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PmsBaseCatalog1Mapper.java
 * @Description TODO
 * @createTime 2020年02月04日 09:29:00
 */
@Mapper
public interface PmsBaseCatalog1Mapper {
    List<PmsBaseCatalog1> selectAll();
}
