package com.liman.www.manage.mapper;

import com.liman.www.bean.PmsBaseCatalog3;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PmsBaseCatalog3Mapper.java
 * @Description TODO
 * @createTime 2020年02月04日 09:29:00
 */
@Mapper

public interface PmsBaseCatalog3Mapper {
    List<PmsBaseCatalog3> selectByCatalog2Id(String catalog2Id);
}
