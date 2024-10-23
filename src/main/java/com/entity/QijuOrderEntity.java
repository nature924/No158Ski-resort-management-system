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
 * 器具订单
 *
 * @author 
 * @email
 */
@TableName("qiju_order")
public class QijuOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QijuOrderEntity() {

	}

	public QijuOrderEntity(T t) {
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
     * 订单编号
     */
    @ColumnInfo(comment="订单编号",type="varchar(200)")
    @TableField(value = "qiju_order_uuid_number")

    private String qijuOrderUuidNumber;


    /**
     * 器具
     */
    @ColumnInfo(comment="器具",type="int(11)")
    @TableField(value = "qiju_id")

    private Integer qijuId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 租赁数量
     */
    @ColumnInfo(comment="租赁数量",type="int(11)")
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 租赁时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="租赁时间",type="timestamp")
    @TableField(value = "qiju_order_time")

    private Date qijuOrderTime;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "qiju_order_true_price")

    private Double qijuOrderTruePrice;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "qiju_order_types")

    private Integer qijuOrderTypes;


    /**
     * 支付类型
     */
    @ColumnInfo(comment="支付类型",type="int(11)")
    @TableField(value = "qiju_order_payment_types")

    private Integer qijuOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
        return "QijuOrder{" +
            ", id=" + id +
            ", qijuOrderUuidNumber=" + qijuOrderUuidNumber +
            ", qijuId=" + qijuId +
            ", yonghuId=" + yonghuId +
            ", buyNumber=" + buyNumber +
            ", qijuOrderTime=" + DateUtil.convertString(qijuOrderTime,"yyyy-MM-dd") +
            ", qijuOrderTruePrice=" + qijuOrderTruePrice +
            ", qijuOrderTypes=" + qijuOrderTypes +
            ", qijuOrderPaymentTypes=" + qijuOrderPaymentTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
