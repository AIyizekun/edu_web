package com.dw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dw.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (User)表数据库访问层
 *
 * @author yangjunxiong
 * @since 2019-12-15 12:47:38
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}