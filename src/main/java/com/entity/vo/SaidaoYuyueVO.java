package com.entity.vo;

import com.entity.SaidaoYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 赛道预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("saidao_yuyue")
public class SaidaoYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 申请编号
     */

    @TableField(value = "saidao_yuyue_uuid_number")
    private String saidaoYuyueUuidNumber;


    /**
     * 赛道
     */

    @TableField(value = "saidao_id")
    private Integer saidaoId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 申请缘由
     */

    @TableField(value = "saidao_yuyue_text")
    private String saidaoYuyueText;


    /**
     * 预约日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "saidao_yuyue_time")
    private Date saidaoYuyueTime;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 申请状态
     */

    @TableField(value = "saidao_yuyue_yesno_types")
    private Integer saidaoYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "saidao_yuyue_yesno_text")
    private String saidaoYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "saidao_yuyue_shenhe_time")
    private Date saidaoYuyueShenheTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：申请编号
	 */
    public String getSaidaoYuyueUuidNumber() {
        return saidaoYuyueUuidNumber;
    }


    /**
	 * 获取：申请编号
	 */

    public void setSaidaoYuyueUuidNumber(String saidaoYuyueUuidNumber) {
        this.saidaoYuyueUuidNumber = saidaoYuyueUuidNumber;
    }
    /**
	 * 设置：赛道
	 */
    public Integer getSaidaoId() {
        return saidaoId;
    }


    /**
	 * 获取：赛道
	 */

    public void setSaidaoId(Integer saidaoId) {
        this.saidaoId = saidaoId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：申请缘由
	 */
    public String getSaidaoYuyueText() {
        return saidaoYuyueText;
    }


    /**
	 * 获取：申请缘由
	 */

    public void setSaidaoYuyueText(String saidaoYuyueText) {
        this.saidaoYuyueText = saidaoYuyueText;
    }
    /**
	 * 设置：预约日期
	 */
    public Date getSaidaoYuyueTime() {
        return saidaoYuyueTime;
    }


    /**
	 * 获取：预约日期
	 */

    public void setSaidaoYuyueTime(Date saidaoYuyueTime) {
        this.saidaoYuyueTime = saidaoYuyueTime;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getSaidaoYuyueYesnoTypes() {
        return saidaoYuyueYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setSaidaoYuyueYesnoTypes(Integer saidaoYuyueYesnoTypes) {
        this.saidaoYuyueYesnoTypes = saidaoYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getSaidaoYuyueYesnoText() {
        return saidaoYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setSaidaoYuyueYesnoText(String saidaoYuyueYesnoText) {
        this.saidaoYuyueYesnoText = saidaoYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getSaidaoYuyueShenheTime() {
        return saidaoYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setSaidaoYuyueShenheTime(Date saidaoYuyueShenheTime) {
        this.saidaoYuyueShenheTime = saidaoYuyueShenheTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
