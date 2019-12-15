package com.dw.controller.converter;
    
    
import com.dw.entity.UserEntity;
import com.dw.controller.model.UserVo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * (User)VoToEntity类
 *
 * @author yangjunxiong
 * @since 2019-12-15 13:08:06
 */
@Mapper
//@Mapper(uses = {UserOrderVoConverter.class, OrderVoConverter.class})
public interface UserEntityVoConverter {

    UserEntityVoConverter MAPPER = Mappers.getMapper(UserEntityVoConverter.class);

//    @Mapping(source = "userOrderVo", target = "userOrder")
//    @Mapping(source = "userOrderVos", target = "userOrders")
//    @Mapping(source = "orderVos", target = "orders") 
//    @Mapping(source = "storeId",target = "store.id")
//    @Mapping(source = "storeName",target = "store.name")
    UserEntity toEntity(UserVo vo);

    @InheritInverseConfiguration
    UserVo toVo(UserEntity entity);//自定义Entity转Vo

//    @Mapping(source = "userOrders", target = "userOrderVos")
//    @Mapping(source = "orders", target = "orderVos")
//    @Mapping(source = "storeId",target = "storeId")
//    @Mapping(source = "createTime",target = "createTime")
    UserVo toVoPlus(UserEntity sysUser);//plus转Vo
}