package com.entity.model;

import com.entity.QijuOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 器具订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QijuOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单编号
     */
    private String qijuOrderUuidNumber;


    /**
     * 器具
     */
    private Integer qijuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 租赁数量
     */
    private Integer buyNumber;


    /**
     * 租赁时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qijuOrderTime;


    /**
     * 实付价格
     */
    private Double qijuOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer qijuOrderTypes;


    /**
     * 支付类型
     */
    private Integer qijuOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：订单编号
	 */
    public String getQijuOrderUuidNumber() {
        return qijuOrderUuidNumber;
    }


    /**
	 * 设置：订单编号
	 */
    public void setQijuOrderUuidNumber(String qijuOrderUuidNumber) {
        this.qijuOrderUuidNumber = qijuOrderUuidNumber;
    }
    /**
	 * 获取：器具
	 */
    public Integer getQijuId() {
        return qijuId;
    }


    /**
	 * 设置：器具
	 */
    public void setQijuId(Integer qijuId) {
        this.qijuId = qijuId;
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
	 * 获取：租赁数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 设置：租赁数量
	 */
    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：租赁时间
	 */
    public Date getQijuOrderTime() {
        return qijuOrderTime;
    }


    /**
	 * 设置：租赁时间
	 */
    public void setQijuOrderTime(Date qijuOrderTime) {
        this.qijuOrderTime = qijuOrderTime;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getQijuOrderTruePrice() {
        return qijuOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setQijuOrderTruePrice(Double qijuOrderTruePrice) {
        this.qijuOrderTruePrice = qijuOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getQijuOrderTypes() {
        return qijuOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setQijuOrderTypes(Integer qijuOrderTypes) {
        this.qijuOrderTypes = qijuOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getQijuOrderPaymentTypes() {
        return qijuOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setQijuOrderPaymentTypes(Integer qijuOrderPaymentTypes) {
        this.qijuOrderPaymentTypes = qijuOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
