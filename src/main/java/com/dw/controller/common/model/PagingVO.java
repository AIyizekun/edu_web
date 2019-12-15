package com.dw.controller.common.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * @author yangjunxiong
 * @date 2019/6/18 9:53
 */
public class PagingVO  {

    @NotNull(message = "页号为空")
    @Min(value = 1, message = "页号最小为1")
    private Integer page = 1;     //当前页号

    @NotNull(message = "页面大小为空")
    @Min(value = 2, message = "页面大小最小为2")
    @Max(value = 300, message = "页面大小最大为300")
    private Integer limit = 10;   //页面大小

    private long count;             //数量总数

    private Collection<?> data;

    public PagingVO() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Collection<?> getData() {
        return data;
    }

    public void setData(Collection<?> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
