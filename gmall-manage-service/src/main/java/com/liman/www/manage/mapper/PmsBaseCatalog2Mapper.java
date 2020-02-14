package com.liman.www.manage.mapper;

import com.liman.www.bean.PmsBaseCatalog2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PmsBaseCatalog2Mapper.java
 * @Description TODO
 * @createTime 2020年02月04日 09:29:00
 */
@Mapper

public interface PmsBaseCatalog2Mapper {
    List<PmsBaseCatalog2> selectByCatalog1Id(String catalog1Id);
}
