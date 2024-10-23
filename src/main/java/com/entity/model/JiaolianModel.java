package com.entity.model;

import com.entity.JiaolianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 教练
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiaolianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 教练编号
     */
    private String jiaolianUuidNumber;


    /**
     * 教练姓名
     */
    private String jiaolianName;


    /**
     * 教练手机号
     */
    private String jiaolianPhone;


    /**
     * 教练身份证号
     */
    private String jiaolianIdNumber;


    /**
     * 教练照片
     */
    private String jiaolianPhoto;


    /**
     * 擅长
     */
    private String jiaolianShanchang;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 教练邮箱
     */
    private String jiaolianEmail;


    /**
     * 账户状态
     */
    private Integer jinyongTypes;


    /**
     * 预约价格/天
     */
    private Double newMoney;


    /**
     * 教练介绍
     */
    private String shangjiaContent;


    /**
     * 所获荣誉
     */
    private String shangjiaRongyuContent;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：教练编号
	 */
    public String getJiaolianUuidNumber() {
        return jiaolianUuidNumber;
    }


    /**
	 * 设置：教练编号
	 */
    public void setJiaolianUuidNumber(String jiaolianUuidNumber) {
        this.jiaolianUuidNumber = jiaolianUuidNumber;
    }
    /**
	 * 获取：教练姓名
	 */
    public String getJiaolianName() {
        return jiaolianName;
    }


    /**
	 * 设置：教练姓名
	 */
    public void setJiaolianName(String jiaolianName) {
        this.jiaolianName = jiaolianName;
    }
    /**
	 * 获取：教练手机号
	 */
    public String getJiaolianPhone() {
        return jiaolianPhone;
    }


    /**
	 * 设置：教练手机号
	 */
    public void setJiaolianPhone(String jiaolianPhone) {
        this.jiaolianPhone = jiaolianPhone;
    }
    /**
	 * 获取：教练身份证号
	 */
    public String getJiaolianIdNumber() {
        return jiaolianIdNumber;
    }


    /**
	 * 设置：教练身份证号
	 */
    public void setJiaolianIdNumber(String jiaolianIdNumber) {
        this.jiaolianIdNumber = jiaolianIdNumber;
    }
    /**
	 * 获取：教练照片
	 */
    public String getJiaolianPhoto() {
        return jiaolianPhoto;
    }


    /**
	 * 设置：教练照片
	 */
    public void setJiaolianPhoto(String jiaolianPhoto) {
        this.jiaolianPhoto = jiaolianPhoto;
    }
    /**
	 * 获取：擅长
	 */
    public String getJiaolianShanchang() {
        return jiaolianShanchang;
    }


    /**
	 * 设置：擅长
	 */
    public void setJiaolianShanchang(String jiaolianShanchang) {
        this.jiaolianShanchang = jiaolianShanchang;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：教练邮箱
	 */
    public String getJiaolianEmail() {
        return jiaolianEmail;
    }


    /**
	 * 设置：教练邮箱
	 */
    public void setJiaolianEmail(String jiaolianEmail) {
        this.jiaolianEmail = jiaolianEmail;
    }
    /**
	 * 获取：账户状态
	 */
    public Integer getJinyongTypes() {
        return jinyongTypes;
    }


    /**
	 * 设置：账户状态
	 */
    public void setJinyongTypes(Integer jinyongTypes) {
        this.jinyongTypes = jinyongTypes;
    }
    /**
	 * 获取：预约价格/天
	 */
    public Double getNewMoney() {
        return newMoney;
    }


    /**
	 * 设置：预约价格/天
	 */
    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 获取：教练介绍
	 */
    public String getShangjiaContent() {
        return shangjiaContent;
    }


    /**
	 * 设置：教练介绍
	 */
    public void setShangjiaContent(String shangjiaContent) {
        this.shangjiaContent = shangjiaContent;
    }
    /**
	 * 获取：所获荣誉
	 */
    public String getShangjiaRongyuContent() {
        return shangjiaRongyuContent;
    }


    /**
	 * 设置：所获荣誉
	 */
    public void setShangjiaRongyuContent(String shangjiaRongyuContent) {
        this.shangjiaRongyuContent = shangjiaRongyuContent;
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
