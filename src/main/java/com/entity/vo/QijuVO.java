package com.entity.vo;

import com.entity.QijuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 滑雪器具
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("qiju")
public class QijuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 器具名称
     */

    @TableField(value = "qiju_name")
    private String qijuName;


    /**
     * 器具编号
     */

    @TableField(value = "qiju_uuid_number")
    private String qijuUuidNumber;


    /**
     * 器具照片
     */

    @TableField(value = "qiju_photo")
    private String qijuPhoto;


    /**
     * 器具类型
     */

    @TableField(value = "qiju_types")
    private Integer qijuTypes;


    /**
     * 器具数量
     */

    @TableField(value = "qiju_kucun_number")
    private Integer qijuKucunNumber;


    /**
     * 器具原价
     */

    @TableField(value = "qiju_old_money")
    private Double qijuOldMoney;


    /**
     * 租赁价格/天
     */

    @TableField(value = "qiju_new_money")
    private Double qijuNewMoney;


    /**
     * 器具热度
     */

    @TableField(value = "qiju_clicknum")
    private Integer qijuClicknum;


    /**
     * 器具介绍
     */

    @TableField(value = "qiju_content")
    private String qijuContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "qiju_delete")
    private Integer qijuDelete;


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
	 * 设置：器具名称
	 */
    public String getQijuName() {
        return qijuName;
    }


    /**
	 * 获取：器具名称
	 */

    public void setQijuName(String qijuName) {
        this.qijuName = qijuName;
    }
    /**
	 * 设置：器具编号
	 */
    public String getQijuUuidNumber() {
        return qijuUuidNumber;
    }


    /**
	 * 获取：器具编号
	 */

    public void setQijuUuidNumber(String qijuUuidNumber) {
        this.qijuUuidNumber = qijuUuidNumber;
    }
    /**
	 * 设置：器具照片
	 */
    public String getQijuPhoto() {
        return qijuPhoto;
    }


    /**
	 * 获取：器具照片
	 */

    public void setQijuPhoto(String qijuPhoto) {
        this.qijuPhoto = qijuPhoto;
    }
    /**
	 * 设置：器具类型
	 */
    public Integer getQijuTypes() {
        return qijuTypes;
    }


    /**
	 * 获取：器具类型
	 */

    public void setQijuTypes(Integer qijuTypes) {
        this.qijuTypes = qijuTypes;
    }
    /**
	 * 设置：器具数量
	 */
    public Integer getQijuKucunNumber() {
        return qijuKucunNumber;
    }


    /**
	 * 获取：器具数量
	 */

    public void setQijuKucunNumber(Integer qijuKucunNumber) {
        this.qijuKucunNumber = qijuKucunNumber;
    }
    /**
	 * 设置：器具原价
	 */
    public Double getQijuOldMoney() {
        return qijuOldMoney;
    }


    /**
	 * 获取：器具原价
	 */

    public void setQijuOldMoney(Double qijuOldMoney) {
        this.qijuOldMoney = qijuOldMoney;
    }
    /**
	 * 设置：租赁价格/天
	 */
    public Double getQijuNewMoney() {
        return qijuNewMoney;
    }


    /**
	 * 获取：租赁价格/天
	 */

    public void setQijuNewMoney(Double qijuNewMoney) {
        this.qijuNewMoney = qijuNewMoney;
    }
    /**
	 * 设置：器具热度
	 */
    public Integer getQijuClicknum() {
        return qijuClicknum;
    }


    /**
	 * 获取：器具热度
	 */

    public void setQijuClicknum(Integer qijuClicknum) {
        this.qijuClicknum = qijuClicknum;
    }
    /**
	 * 设置：器具介绍
	 */
    public String getQijuContent() {
        return qijuContent;
    }


    /**
	 * 获取：器具介绍
	 */

    public void setQijuContent(String qijuContent) {
        this.qijuContent = qijuContent;
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
    public Integer getQijuDelete() {
        return qijuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setQijuDelete(Integer qijuDelete) {
        this.qijuDelete = qijuDelete;
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
