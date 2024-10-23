package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.SaidaoYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 赛道预约
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("saidao_yuyue")
public class SaidaoYuyueView extends SaidaoYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 申请状态的值
	*/
	@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
	private String saidaoYuyueYesnoValue;

	//级联表 赛道
		/**
		* 赛道名称
		*/

		@ColumnInfo(comment="赛道名称",type="varchar(200)")
		private String saidaoName;
		/**
		* 赛道编号
		*/

		@ColumnInfo(comment="赛道编号",type="varchar(200)")
		private String saidaoUuidNumber;
		/**
		* 赛道缩略图
		*/

		@ColumnInfo(comment="赛道缩略图",type="varchar(200)")
		private String saidaoPhoto;
		/**
		* 赛道类型
		*/
		@ColumnInfo(comment="赛道类型",type="int(11)")
		private Integer saidaoTypes;
			/**
			* 赛道类型的值
			*/
			@ColumnInfo(comment="赛道类型的字典表值",type="varchar(200)")
			private String saidaoValue;
		/**
		* 赛道原价
		*/
		@ColumnInfo(comment="赛道原价",type="decimal(10,2)")
		private Double saidaoOldMoney;
		/**
		* 现价/天
		*/
		@ColumnInfo(comment="现价/天",type="decimal(10,2)")
		private Double saidaoNewMoney;
		/**
		* 赛道热度
		*/

		@ColumnInfo(comment="赛道热度",type="int(11)")
		private Integer saidaoClicknum;
		/**
		* 赛道介绍
		*/

		@ColumnInfo(comment="赛道介绍",type="longtext")
		private String saidaoContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer saidaoDelete;
	//级联表 用户
		/**
		* 用户编号
		*/

		@ColumnInfo(comment="用户编号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;



	public SaidaoYuyueView() {

	}

	public SaidaoYuyueView(SaidaoYuyueEntity saidaoYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, saidaoYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 申请状态的值
	*/
	public String getSaidaoYuyueYesnoValue() {
		return saidaoYuyueYesnoValue;
	}
	/**
	* 设置： 申请状态的值
	*/
	public void setSaidaoYuyueYesnoValue(String saidaoYuyueYesnoValue) {
		this.saidaoYuyueYesnoValue = saidaoYuyueYesnoValue;
	}


	//级联表的get和set 赛道

		/**
		* 获取： 赛道名称
		*/
		public String getSaidaoName() {
			return saidaoName;
		}
		/**
		* 设置： 赛道名称
		*/
		public void setSaidaoName(String saidaoName) {
			this.saidaoName = saidaoName;
		}

		/**
		* 获取： 赛道编号
		*/
		public String getSaidaoUuidNumber() {
			return saidaoUuidNumber;
		}
		/**
		* 设置： 赛道编号
		*/
		public void setSaidaoUuidNumber(String saidaoUuidNumber) {
			this.saidaoUuidNumber = saidaoUuidNumber;
		}

		/**
		* 获取： 赛道缩略图
		*/
		public String getSaidaoPhoto() {
			return saidaoPhoto;
		}
		/**
		* 设置： 赛道缩略图
		*/
		public void setSaidaoPhoto(String saidaoPhoto) {
			this.saidaoPhoto = saidaoPhoto;
		}
		/**
		* 获取： 赛道类型
		*/
		public Integer getSaidaoTypes() {
			return saidaoTypes;
		}
		/**
		* 设置： 赛道类型
		*/
		public void setSaidaoTypes(Integer saidaoTypes) {
			this.saidaoTypes = saidaoTypes;
		}


			/**
			* 获取： 赛道类型的值
			*/
			public String getSaidaoValue() {
				return saidaoValue;
			}
			/**
			* 设置： 赛道类型的值
			*/
			public void setSaidaoValue(String saidaoValue) {
				this.saidaoValue = saidaoValue;
			}

		/**
		* 获取： 赛道原价
		*/
		public Double getSaidaoOldMoney() {
			return saidaoOldMoney;
		}
		/**
		* 设置： 赛道原价
		*/
		public void setSaidaoOldMoney(Double saidaoOldMoney) {
			this.saidaoOldMoney = saidaoOldMoney;
		}

		/**
		* 获取： 现价/天
		*/
		public Double getSaidaoNewMoney() {
			return saidaoNewMoney;
		}
		/**
		* 设置： 现价/天
		*/
		public void setSaidaoNewMoney(Double saidaoNewMoney) {
			this.saidaoNewMoney = saidaoNewMoney;
		}

		/**
		* 获取： 赛道热度
		*/
		public Integer getSaidaoClicknum() {
			return saidaoClicknum;
		}
		/**
		* 设置： 赛道热度
		*/
		public void setSaidaoClicknum(Integer saidaoClicknum) {
			this.saidaoClicknum = saidaoClicknum;
		}

		/**
		* 获取： 赛道介绍
		*/
		public String getSaidaoContent() {
			return saidaoContent;
		}
		/**
		* 设置： 赛道介绍
		*/
		public void setSaidaoContent(String saidaoContent) {
			this.saidaoContent = saidaoContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getSaidaoDelete() {
			return saidaoDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setSaidaoDelete(Integer saidaoDelete) {
			this.saidaoDelete = saidaoDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户编号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 用户编号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}


	@Override
	public String toString() {
		return "SaidaoYuyueView{" +
			", saidaoYuyueYesnoValue=" + saidaoYuyueYesnoValue +
			", saidaoName=" + saidaoName +
			", saidaoUuidNumber=" + saidaoUuidNumber +
			", saidaoPhoto=" + saidaoPhoto +
			", saidaoOldMoney=" + saidaoOldMoney +
			", saidaoNewMoney=" + saidaoNewMoney +
			", saidaoClicknum=" + saidaoClicknum +
			", saidaoContent=" + saidaoContent +
			", saidaoDelete=" + saidaoDelete +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
