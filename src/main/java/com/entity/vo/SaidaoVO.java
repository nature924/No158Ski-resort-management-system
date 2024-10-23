package com.entity.vo;

import com.entity.SaidaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 赛道
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("saidao")
public class SaidaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 赛道名称
     */

    @TableField(value = "saidao_name")
    private String saidaoName;


    /**
     * 赛道编号
     */

    @TableField(value = "saidao_uuid_number")
    private String saidaoUuidNumber;


    /**
     * 赛道缩略图
     */

    @TableField(value = "saidao_photo")
    private String saidaoPhoto;


    /**
     * 赛道类型
     */

    @TableField(value = "saidao_types")
    private Integer saidaoTypes;


    /**
     * 赛道原价
     */

    @TableField(value = "saidao_old_money")
    private Double saidaoOldMoney;


    /**
     * 现价/天
     */

    @TableField(value = "saidao_new_money")
    private Double saidaoNewMoney;


    /**
     * 赛道热度
     */

    @TableField(value = "saidao_clicknum")
    private Integer saidaoClicknum;


    /**
     * 赛道介绍
     */

    @TableField(value = "saidao_content")
    private String saidaoContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "saidao_delete")
    private Integer saidaoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：赛道名称
	 */
    public String getSaidaoName() {
        return saidaoName;
    }


    /**
	 * 获取：赛道名称
	 */

    public void setSaidaoName(String saidaoName) {
        this.saidaoName = saidaoName;
    }
    /**
	 * 设置：赛道编号
	 */
    public String getSaidaoUuidNumber() {
        return saidaoUuidNumber;
    }


    /**
	 * 获取：赛道编号
	 */

    public void setSaidaoUuidNumber(String saidaoUuidNumber) {
        this.saidaoUuidNumber = saidaoUuidNumber;
    }
    /**
	 * 设置：赛道缩略图
	 */
    public String getSaidaoPhoto() {
        return saidaoPhoto;
    }


    /**
	 * 获取：赛道缩略图
	 */

    public void setSaidaoPhoto(String saidaoPhoto) {
        this.saidaoPhoto = saidaoPhoto;
    }
    /**
	 * 设置：赛道类型
	 */
    public Integer getSaidaoTypes() {
        return saidaoTypes;
    }


    /**
	 * 获取：赛道类型
	 */

    public void setSaidaoTypes(Integer saidaoTypes) {
        this.saidaoTypes = saidaoTypes;
    }
    /**
	 * 设置：赛道原价
	 */
    public Double getSaidaoOldMoney() {
        return saidaoOldMoney;
    }


    /**
	 * 获取：赛道原价
	 */

    public void setSaidaoOldMoney(Double saidaoOldMoney) {
        this.saidaoOldMoney = saidaoOldMoney;
    }
    /**
	 * 设置：现价/天
	 */
    public Double getSaidaoNewMoney() {
        return saidaoNewMoney;
    }


    /**
	 * 获取：现价/天
	 */

    public void setSaidaoNewMoney(Double saidaoNewMoney) {
        this.saidaoNewMoney = saidaoNewMoney;
    }
    /**
	 * 设置：赛道热度
	 */
    public Integer getSaidaoClicknum() {
        return saidaoClicknum;
    }


    /**
	 * 获取：赛道热度
	 */

    public void setSaidaoClicknum(Integer saidaoClicknum) {
        this.saidaoClicknum = saidaoClicknum;
    }
    /**
	 * 设置：赛道介绍
	 */
    public String getSaidaoContent() {
        return saidaoContent;
    }


    /**
	 * 获取：赛道介绍
	 */

    public void setSaidaoContent(String saidaoContent) {
        this.saidaoContent = saidaoContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getSaidaoDelete() {
        return saidaoDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setSaidaoDelete(Integer saidaoDelete) {
        this.saidaoDelete = saidaoDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
