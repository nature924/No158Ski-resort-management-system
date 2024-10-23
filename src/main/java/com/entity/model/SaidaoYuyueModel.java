package com.entity.model;

import com.entity.SaidaoYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 赛道预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SaidaoYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 申请编号
     */
    private String saidaoYuyueUuidNumber;


    /**
     * 赛道
     */
    private Integer saidaoId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 申请缘由
     */
    private String saidaoYuyueText;


    /**
     * 预约日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date saidaoYuyueTime;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 申请状态
     */
    private Integer saidaoYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String saidaoYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date saidaoYuyueShenheTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
