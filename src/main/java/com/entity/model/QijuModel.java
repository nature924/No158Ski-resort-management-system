package com.entity.model;

import com.entity.QijuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 滑雪器具
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QijuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 器具名称
     */
    private String qijuName;


    /**
     * 器具编号
     */
    private String qijuUuidNumber;


    /**
     * 器具照片
     */
    private String qijuPhoto;


    /**
     * 器具类型
     */
    private Integer qijuTypes;


    /**
     * 器具数量
     */
    private Integer qijuKucunNumber;


    /**
     * 器具原价
     */
    private Double qijuOldMoney;


    /**
     * 租赁价格/天
     */
    private Double qijuNewMoney;


    /**
     * 器具热度
     */
    private Integer qijuClicknum;


    /**
     * 器具介绍
     */
    private String qijuContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer qijuDelete;


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
