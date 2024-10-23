package com.entity.model;

import com.entity.SaidaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 赛道
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SaidaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 赛道名称
     */
    private String saidaoName;


    /**
     * 赛道编号
     */
    private String saidaoUuidNumber;


    /**
     * 赛道缩略图
     */
    private String saidaoPhoto;


    /**
     * 赛道类型
     */
    private Integer saidaoTypes;


    /**
     * 赛道原价
     */
    private Double saidaoOldMoney;


    /**
     * 现价/天
     */
    private Double saidaoNewMoney;


    /**
     * 赛道热度
     */
    private Integer saidaoClicknum;


    /**
     * 赛道介绍
     */
    private String saidaoContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer saidaoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
