package com.dw.dict;

/**
 * 用户角色类型
 * 1 ,2 4, 8 ,16 ,32
 *
 * @author yangjunxiong
 * @date 2018/5/23 21:06
 */
public enum RoleEnum {

    /**
     * 系统管理员
     */
    ROLE_ADMIN(1, "管理员"),

    ROLE_DEPT(2, "部门");

    private final int    value;
    private final String descr;

    RoleEnum(int value, String descr) {
        this.value = value;
        this.descr = descr;
    }

    public static RoleEnum valueOf(int value) {
        for (RoleEnum type : RoleEnum.values()) {
            if (value == type.getValue()) {
                return type;
            }
        }
        throw new IllegalStateException("值【" + value + "】无法转");
    }

    public int getValue() {
        return value;
    }

    public String getDescr() {
        return descr;
    }
}
