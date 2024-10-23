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
 * 赛道预约
 *
 * @author 
 * @email
 */
@TableName("saidao_yuyue")
public class SaidaoYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SaidaoYuyueEntity() {

	}

	public SaidaoYuyueEntity(T t) {
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
     * 申请编号
     */
    @ColumnInfo(comment="申请编号",type="varchar(200)")
    @TableField(value = "saidao_yuyue_uuid_number")

    private String saidaoYuyueUuidNumber;


    /**
     * 赛道
     */
    @ColumnInfo(comment="赛道",type="int(11)")
    @TableField(value = "saidao_id")

    private Integer saidaoId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 申请缘由
     */
    @ColumnInfo(comment="申请缘由",type="longtext")
    @TableField(value = "saidao_yuyue_text")

    private String saidaoYuyueText;


    /**
     * 预约日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="预约日期",type="date")
    @TableField(value = "saidao_yuyue_time")

    private Date saidaoYuyueTime;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "saidao_yuyue_yesno_types")

    private Integer saidaoYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "saidao_yuyue_yesno_text")

    private String saidaoYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "saidao_yuyue_shenhe_time")

    private Date saidaoYuyueShenheTime;


    /**
     * 创建时间  listShow
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
	 * 获取：申请编号
	 */
    public String getSaidaoYuyueUuidNumber() {
        return saidaoYuyueUuidNumber;
    }
    /**
	 * 设置：申请编号
	 */

    public void setSaidaoYuyueUuidNumber(String saidaoYuyueUuidNumber) {
        this.saidaoYuyueUuidNumber = saidaoYuyueUuidNumber;
    }
    /**
	 * 获取：赛道
	 */
    public Integer getSaidaoId() {
        return saidaoId;
    }
    /**
	 * 设置：赛道
	 */

    public void setSaidaoId(Integer saidaoId) {
        this.saidaoId = saidaoId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：申请缘由
	 */
    public String getSaidaoYuyueText() {
        return saidaoYuyueText;
    }
    /**
	 * 设置：申请缘由
	 */

    public void setSaidaoYuyueText(String saidaoYuyueText) {
        this.saidaoYuyueText = saidaoYuyueText;
    }
    /**
	 * 获取：预约日期
	 */
    public Date getSaidaoYuyueTime() {
        return saidaoYuyueTime;
    }
    /**
	 * 设置：预约日期
	 */

    public void setSaidaoYuyueTime(Date saidaoYuyueTime) {
        this.saidaoYuyueTime = saidaoYuyueTime;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getSaidaoYuyueYesnoTypes() {
        return saidaoYuyueYesnoTypes;
    }
    /**
	 * 设置：申请状态
	 */

    public void setSaidaoYuyueYesnoTypes(Integer saidaoYuyueYesnoTypes) {
        this.saidaoYuyueYesnoTypes = saidaoYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getSaidaoYuyueYesnoText() {
        return saidaoYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setSaidaoYuyueYesnoText(String saidaoYuyueYesnoText) {
        this.saidaoYuyueYesnoText = saidaoYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getSaidaoYuyueShenheTime() {
        return saidaoYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setSaidaoYuyueShenheTime(Date saidaoYuyueShenheTime) {
        this.saidaoYuyueShenheTime = saidaoYuyueShenheTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SaidaoYuyue{" +
            ", id=" + id +
            ", saidaoYuyueUuidNumber=" + saidaoYuyueUuidNumber +
            ", saidaoId=" + saidaoId +
            ", yonghuId=" + yonghuId +
            ", saidaoYuyueText=" + saidaoYuyueText +
            ", saidaoYuyueTime=" + DateUtil.convertString(saidaoYuyueTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", saidaoYuyueYesnoTypes=" + saidaoYuyueYesnoTypes +
            ", saidaoYuyueYesnoText=" + saidaoYuyueYesnoText +
            ", saidaoYuyueShenheTime=" + DateUtil.convertString(saidaoYuyueShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
