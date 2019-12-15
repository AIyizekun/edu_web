/*
 * Copyright 2019 Wicrenet, Inc. All rights reserved.
 */
package com.dw.controller.common.verify;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 【根据action动作修改状态】
 *
 * @author YJX
 * Created on 2019/12/5 13:52
 */
public class StatusModel implements Verify {

    //平台类型
    private Integer    platformType;
    @NotBlank(message = "执行动作不能为空")
    private String     action;
    private Integer    value;
    @Size(min = 1, message = "ids不能为空")
    private List<Long> ids;

    public Integer getPlatformType() {
        return platformType;
    }

    public void setPlatformType(Integer platformType) {
        this.platformType = platformType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
