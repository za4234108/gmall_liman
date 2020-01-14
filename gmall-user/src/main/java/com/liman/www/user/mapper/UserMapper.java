package com.liman.www.user.mapper;

import com.liman.www.user.bean.UmsMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2020年01月10日 19:31:00
 */
@Mapper
public interface UserMapper {
    List<UmsMember> getAllUmsMember();

}
