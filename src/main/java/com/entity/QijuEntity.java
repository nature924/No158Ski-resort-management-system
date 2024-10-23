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
 * 滑雪器具
 *
 * @author 
 * @email
 */
@TableName("qiju")
public class QijuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QijuEntity() {

	}

	public QijuEntity(T t) {
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
     * 器具名称
     */
    @ColumnInfo(comment="器具名称",type="varchar(200)")
    @TableField(value = "qiju_name")

    private String qijuName;


    /**
     * 器具编号
     */
    @ColumnInfo(comment="器具编号",type="varchar(200)")
    @TableField(value = "qiju_uuid_number")

    private String qijuUuidNumber;


    /**
     * 器具照片
     */
    @ColumnInfo(comment="器具照片",type="varchar(200)")
    @TableField(value = "qiju_photo")

    private String qijuPhoto;


    /**
     * 器具类型
     */
    @ColumnInfo(comment="器具类型",type="int(11)")
    @TableField(value = "qiju_types")

    private Integer qijuTypes;


    /**
     * 器具数量
     */
    @ColumnInfo(comment="器具数量",type="int(11)")
    @TableField(value = "qiju_kucun_number")

    private Integer qijuKucunNumber;


    /**
     * 器具原价
     */
    @ColumnInfo(comment="器具原价",type="decimal(10,2)")
    @TableField(value = "qiju_old_money")

    private Double qijuOldMoney;


    /**
     * 租赁价格/天
     */
    @ColumnInfo(comment="租赁价格/天",type="decimal(10,2)")
    @TableField(value = "qiju_new_money")

    private Double qijuNewMoney;


    /**
     * 器具热度
     */
    @ColumnInfo(comment="器具热度",type="int(11)")
    @TableField(value = "qiju_clicknum")

    private Integer qijuClicknum;


    /**
     * 器具介绍
     */
    @ColumnInfo(comment="器具介绍",type="longtext")
    @TableField(value = "qiju_content")

    private String qijuContent;


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
    @TableField(value = "qiju_delete")

    private Integer qijuDelete;


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
	 * 获取：器具名称
	 */
    public String getQijuName() {
        return qijuName;
    }
    /**
	 * 设置：器具名称
	 */

    public void setQijuName(String qijuName) {
        this.qijuName = qijuName;
    }
    /**
	 * 获取：器具编号
	 */
    public String getQijuUuidNumber() {
        return qijuUuidNumber;
    }
    /**
	 * 设置：器具编号
	 */

    public void setQijuUuidNumber(String qijuUuidNumber) {
        this.qijuUuidNumber = qijuUuidNumber;
    }
    /**
	 * 获取：器具照片
	 */
    public String getQijuPhoto() {
        return qijuPhoto;
    }
    /**
	 * 设置：器具照片
	 */

    public void setQijuPhoto(String qijuPhoto) {
        this.qijuPhoto = qijuPhoto;
    }
    /**
	 * 获取：器具类型
	 */
    public Integer getQijuTypes() {
        return qijuTypes;
    }
    /**
	 * 设置：器具类型
	 */

    public void setQijuTypes(Integer qijuTypes) {
        this.qijuTypes = qijuTypes;
    }
    /**
	 * 获取：器具数量
	 */
    public Integer getQijuKucunNumber() {
        return qijuKucunNumber;
    }
    /**
	 * 设置：器具数量
	 */

    public void setQijuKucunNumber(Integer qijuKucunNumber) {
        this.qijuKucunNumber = qijuKucunNumber;
    }
    /**
	 * 获取：器具原价
	 */
    public Double getQijuOldMoney() {
        return qijuOldMoney;
    }
    /**
	 * 设置：器具原价
	 */

    public void setQijuOldMoney(Double qijuOldMoney) {
        this.qijuOldMoney = qijuOldMoney;
    }
    /**
	 * 获取：租赁价格/天
	 */
    public Double getQijuNewMoney() {
        return qijuNewMoney;
    }
    /**
	 * 设置：租赁价格/天
	 */

    public void setQijuNewMoney(Double qijuNewMoney) {
        this.qijuNewMoney = qijuNewMoney;
    }
    /**
	 * 获取：器具热度
	 */
    public Integer getQijuClicknum() {
        return qijuClicknum;
    }
    /**
	 * 设置：器具热度
	 */

    public void setQijuClicknum(Integer qijuClicknum) {
        this.qijuClicknum = qijuClicknum;
    }
    /**
	 * 获取：器具介绍
	 */
    public String getQijuContent() {
        return qijuContent;
    }
    /**
	 * 设置：器具介绍
	 */

    public void setQijuContent(String qijuContent) {
        this.qijuContent = qijuContent;
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
    public Integer getQijuDelete() {
        return qijuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setQijuDelete(Integer qijuDelete) {
        this.qijuDelete = qijuDelete;
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
        return "Qiju{" +
            ", id=" + id +
            ", qijuName=" + qijuName +
            ", qijuUuidNumber=" + qijuUuidNumber +
            ", qijuPhoto=" + qijuPhoto +
            ", qijuTypes=" + qijuTypes +
            ", qijuKucunNumber=" + qijuKucunNumber +
            ", qijuOldMoney=" + qijuOldMoney +
            ", qijuNewMoney=" + qijuNewMoney +
            ", qijuClicknum=" + qijuClicknum +
            ", qijuContent=" + qijuContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", qijuDelete=" + qijuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
