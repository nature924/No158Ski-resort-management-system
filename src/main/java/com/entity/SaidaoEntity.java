package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 赛道
 *
 * @author 
 * @email
 */
@TableName("saidao")
public class SaidaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SaidaoEntity() {

	}

	public SaidaoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 赛道名称
     */
    @ColumnInfo(comment="赛道名称",type="varchar(200)")
    @TableField(value = "saidao_name")

    private String saidaoName;


    /**
     * 赛道编号
     */
    @ColumnInfo(comment="赛道编号",type="varchar(200)")
    @TableField(value = "saidao_uuid_number")

    private String saidaoUuidNumber;


    /**
     * 赛道缩略图
     */
    @ColumnInfo(comment="赛道缩略图",type="varchar(200)")
    @TableField(value = "saidao_photo")

    private String saidaoPhoto;


    /**
     * 赛道类型
     */
    @ColumnInfo(comment="赛道类型",type="int(11)")
    @TableField(value = "saidao_types")

    private Integer saidaoTypes;


    /**
     * 赛道原价
     */
    @ColumnInfo(comment="赛道原价",type="decimal(10,2)")
    @TableField(value = "saidao_old_money")

    private Double saidaoOldMoney;


    /**
     * 现价/天
     */
    @ColumnInfo(comment="现价/天",type="decimal(10,2)")
    @TableField(value = "saidao_new_money")

    private Double saidaoNewMoney;


    /**
     * 赛道热度
     */
    @ColumnInfo(comment="赛道热度",type="int(11)")
    @TableField(value = "saidao_clicknum")

    private Integer saidaoClicknum;


    /**
     * 赛道介绍
     */
    @ColumnInfo(comment="赛道介绍",type="longtext")
    @TableField(value = "saidao_content")

    private String saidaoContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "saidao_delete")

    private Integer saidaoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：赛道名称
	 */
    public String getSaidaoName() {
        return saidaoName;
    }
    /**
	 * 设置：赛道名称
	 */

    public void setSaidaoName(String saidaoName) {
        this.saidaoName = saidaoName;
    }
    /**
	 * 获取：赛道编号
	 */
    public String getSaidaoUuidNumber() {
        return saidaoUuidNumber;
    }
    /**
	 * 设置：赛道编号
	 */

    public void setSaidaoUuidNumber(String saidaoUuidNumber) {
        this.saidaoUuidNumber = saidaoUuidNumber;
    }
    /**
	 * 获取：赛道缩略图
	 */
    public String getSaidaoPhoto() {
        return saidaoPhoto;
    }
    /**
	 * 设置：赛道缩略图
	 */

    public void setSaidaoPhoto(String saidaoPhoto) {
        this.saidaoPhoto = saidaoPhoto;
    }
    /**
	 * 获取：赛道类型
	 */
    public Integer getSaidaoTypes() {
        return saidaoTypes;
    }
    /**
	 * 设置：赛道类型
	 */

    public void setSaidaoTypes(Integer saidaoTypes) {
        this.saidaoTypes = saidaoTypes;
    }
    /**
	 * 获取：赛道原价
	 */
    public Double getSaidaoOldMoney() {
        return saidaoOldMoney;
    }
    /**
	 * 设置：赛道原价
	 */

    public void setSaidaoOldMoney(Double saidaoOldMoney) {
        this.saidaoOldMoney = saidaoOldMoney;
    }
    /**
	 * 获取：现价/天
	 */
    public Double getSaidaoNewMoney() {
        return saidaoNewMoney;
    }
    /**
	 * 设置：现价/天
	 */

    public void setSaidaoNewMoney(Double saidaoNewMoney) {
        this.saidaoNewMoney = saidaoNewMoney;
    }
    /**
	 * 获取：赛道热度
	 */
    public Integer getSaidaoClicknum() {
        return saidaoClicknum;
    }
    /**
	 * 设置：赛道热度
	 */

    public void setSaidaoClicknum(Integer saidaoClicknum) {
        this.saidaoClicknum = saidaoClicknum;
    }
    /**
	 * 获取：赛道介绍
	 */
    public String getSaidaoContent() {
        return saidaoContent;
    }
    /**
	 * 设置：赛道介绍
	 */

    public void setSaidaoContent(String saidaoContent) {
        this.saidaoContent = saidaoContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getSaidaoDelete() {
        return saidaoDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setSaidaoDelete(Integer saidaoDelete) {
        this.saidaoDelete = saidaoDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Saidao{" +
            ", id=" + id +
            ", saidaoName=" + saidaoName +
            ", saidaoUuidNumber=" + saidaoUuidNumber +
            ", saidaoPhoto=" + saidaoPhoto +
            ", saidaoTypes=" + saidaoTypes +
            ", saidaoOldMoney=" + saidaoOldMoney +
            ", saidaoNewMoney=" + saidaoNewMoney +
            ", saidaoClicknum=" + saidaoClicknum +
            ", saidaoContent=" + saidaoContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", saidaoDelete=" + saidaoDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
