package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.QijuCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 器具收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("qiju_collection")
public class QijuCollectionView extends QijuCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String qijuCollectionValue;

	//级联表 滑雪器具
		/**
		* 器具名称
		*/

		@ColumnInfo(comment="器具名称",type="varchar(200)")
		private String qijuName;
		/**
		* 器具编号
		*/

		@ColumnInfo(comment="器具编号",type="varchar(200)")
		private String qijuUuidNumber;
		/**
		* 器具照片
		*/

		@ColumnInfo(comment="器具照片",type="varchar(200)")
		private String qijuPhoto;
		/**
		* 器具类型
		*/
		@ColumnInfo(comment="器具类型",type="int(11)")
		private Integer qijuTypes;
			/**
			* 器具类型的值
			*/
			@ColumnInfo(comment="器具类型的字典表值",type="varchar(200)")
			private String qijuValue;
		/**
		* 器具数量
		*/

		@ColumnInfo(comment="器具数量",type="int(11)")
		private Integer qijuKucunNumber;
		/**
		* 器具原价
		*/
		@ColumnInfo(comment="器具原价",type="decimal(10,2)")
		private Double qijuOldMoney;
		/**
		* 租赁价格/天
		*/
		@ColumnInfo(comment="租赁价格/天",type="decimal(10,2)")
		private Double qijuNewMoney;
		/**
		* 器具热度
		*/

		@ColumnInfo(comment="器具热度",type="int(11)")
		private Integer qijuClicknum;
		/**
		* 器具介绍
		*/

		@ColumnInfo(comment="器具介绍",type="longtext")
		private String qijuContent;
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
		private Integer qijuDelete;
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



	public QijuCollectionView() {

	}

	public QijuCollectionView(QijuCollectionEntity qijuCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, qijuCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getQijuCollectionValue() {
		return qijuCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setQijuCollectionValue(String qijuCollectionValue) {
		this.qijuCollectionValue = qijuCollectionValue;
	}


	//级联表的get和set 滑雪器具

		/**
		* 获取： 器具名称
		*/
		public String getQijuName() {
			return qijuName;
		}
		/**
		* 设置： 器具名称
		*/
		public void setQijuName(String qijuName) {
			this.qijuName = qijuName;
		}

		/**
		* 获取： 器具编号
		*/
		public String getQijuUuidNumber() {
			return qijuUuidNumber;
		}
		/**
		* 设置： 器具编号
		*/
		public void setQijuUuidNumber(String qijuUuidNumber) {
			this.qijuUuidNumber = qijuUuidNumber;
		}

		/**
		* 获取： 器具照片
		*/
		public String getQijuPhoto() {
			return qijuPhoto;
		}
		/**
		* 设置： 器具照片
		*/
		public void setQijuPhoto(String qijuPhoto) {
			this.qijuPhoto = qijuPhoto;
		}
		/**
		* 获取： 器具类型
		*/
		public Integer getQijuTypes() {
			return qijuTypes;
		}
		/**
		* 设置： 器具类型
		*/
		public void setQijuTypes(Integer qijuTypes) {
			this.qijuTypes = qijuTypes;
		}


			/**
			* 获取： 器具类型的值
			*/
			public String getQijuValue() {
				return qijuValue;
			}
			/**
			* 设置： 器具类型的值
			*/
			public void setQijuValue(String qijuValue) {
				this.qijuValue = qijuValue;
			}

		/**
		* 获取： 器具数量
		*/
		public Integer getQijuKucunNumber() {
			return qijuKucunNumber;
		}
		/**
		* 设置： 器具数量
		*/
		public void setQijuKucunNumber(Integer qijuKucunNumber) {
			this.qijuKucunNumber = qijuKucunNumber;
		}

		/**
		* 获取： 器具原价
		*/
		public Double getQijuOldMoney() {
			return qijuOldMoney;
		}
		/**
		* 设置： 器具原价
		*/
		public void setQijuOldMoney(Double qijuOldMoney) {
			this.qijuOldMoney = qijuOldMoney;
		}

		/**
		* 获取： 租赁价格/天
		*/
		public Double getQijuNewMoney() {
			return qijuNewMoney;
		}
		/**
		* 设置： 租赁价格/天
		*/
		public void setQijuNewMoney(Double qijuNewMoney) {
			this.qijuNewMoney = qijuNewMoney;
		}

		/**
		* 获取： 器具热度
		*/
		public Integer getQijuClicknum() {
			return qijuClicknum;
		}
		/**
		* 设置： 器具热度
		*/
		public void setQijuClicknum(Integer qijuClicknum) {
			this.qijuClicknum = qijuClicknum;
		}

		/**
		* 获取： 器具介绍
		*/
		public String getQijuContent() {
			return qijuContent;
		}
		/**
		* 设置： 器具介绍
		*/
		public void setQijuContent(String qijuContent) {
			this.qijuContent = qijuContent;
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
		public Integer getQijuDelete() {
			return qijuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setQijuDelete(Integer qijuDelete) {
			this.qijuDelete = qijuDelete;
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
		return "QijuCollectionView{" +
			", qijuCollectionValue=" + qijuCollectionValue +
			", qijuName=" + qijuName +
			", qijuUuidNumber=" + qijuUuidNumber +
			", qijuPhoto=" + qijuPhoto +
			", qijuKucunNumber=" + qijuKucunNumber +
			", qijuOldMoney=" + qijuOldMoney +
			", qijuNewMoney=" + qijuNewMoney +
			", qijuClicknum=" + qijuClicknum +
			", qijuContent=" + qijuContent +
			", qijuDelete=" + qijuDelete +
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
