package com.dw.entity;
import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 监管对象，泛指系统中被监管的市场主体，不管是有资质，还是无资质，都应该被监管(SupervesionInfo)表实体类
 *
 * @author yzk
 * @since 2019-12-15 16:39:58
 */
@Data
@TableName("tf_supervesion_info")
public class SupervesionInfoEntity implements Serializable {
    private static final long serialVersionUID = 621574273910544242L;
    
    // ---> 数据库字段开始
    //@TableId(value = "id", type = IdType.ID_WORKER)//雪花id
    //监管对象ID
    private Integer supervisionId;
    
    //监管对象名称
    private String supervisionName;
    
    //监管者地址
    private String supervisionAddress;
    
    //联系人姓名
    private String link;
    
    //联系方式
    private String contact;
    
    //所属街道
    private String manageStreet;
    
    //监管类型，1企业，2教学点，3个人，4其它
    private Integer supervisionType;
    
    //来源，1系统，2历史，3教育网同步，等等有待扩充
    private Integer sourceType;
    
    //场景，该对象归属于哪个行业，教育培训，托育，民办等等
    private Integer senceType;
    
    //父级ID
    private Integer superId;
    
    //创建人
    private String createStaff;
    
    //创建日期
    private Date createDate;
    
    //修改日期
    private Date statusDate;
    
    //修改人
    private Integer statusStaff;
    
    //状态
    private String status;
    
    // ---> 数据库字段结束

    // ---> 业务字段开始
    //@TableField(exist = false)


    // ---> 业务字段结束
    
    // ---> getter setter
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}