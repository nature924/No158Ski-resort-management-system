package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiaolianYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 教练预约
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiaolian_yuyue")
public class JiaolianYuyueView extends JiaolianYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 预约状态的值
	*/
	@ColumnInfo(comment="预约状态的字典表值",type="varchar(200)")
	private String jiaolianYuyueYesnoValue;

	//级联表 教练
		/**
		* 教练编号
		*/

		@ColumnInfo(comment="教练编号",type="varchar(200)")
		private String jiaolianUuidNumber;
		/**
		* 教练姓名
		*/

		@ColumnInfo(comment="教练姓名",type="varchar(200)")
		private String jiaolianName;
		/**
		* 教练手机号
		*/

		@ColumnInfo(comment="教练手机号",type="varchar(200)")
		private String jiaolianPhone;
		/**
		* 教练身份证号
		*/

		@ColumnInfo(comment="教练身份证号",type="varchar(200)")
		private String jiaolianIdNumber;
		/**
		* 教练照片
		*/

		@ColumnInfo(comment="教练照片",type="varchar(200)")
		private String jiaolianPhoto;
		/**
		* 擅长
		*/

		@ColumnInfo(comment="擅长",type="varchar(200)")
		private String jiaolianShanchang;
		/**
		* 教练邮箱
		*/

		@ColumnInfo(comment="教练邮箱",type="varchar(200)")
		private String jiaolianEmail;
		/**
		* 预约价格/天
		*/
		@ColumnInfo(comment="预约价格/天",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 教练介绍
		*/

		@ColumnInfo(comment="教练介绍",type="longtext")
		private String shangjiaContent;
		/**
		* 所获荣誉
		*/

		@ColumnInfo(comment="所获荣誉",type="longtext")
		private String shangjiaRongyuContent;
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

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer jinyongTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String jinyongValue;


	public JiaolianYuyueView() {

	}

	public JiaolianYuyueView(JiaolianYuyueEntity jiaolianYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, jiaolianYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 预约状态的值
	*/
	public String getJiaolianYuyueYesnoValue() {
		return jiaolianYuyueYesnoValue;
	}
	/**
	* 设置： 预约状态的值
	*/
	public void setJiaolianYuyueYesnoValue(String jiaolianYuyueYesnoValue) {
		this.jiaolianYuyueYesnoValue = jiaolianYuyueYesnoValue;
	}


	//级联表的get和set 教练

		/**
		* 获取： 教练编号
		*/
		public String getJiaolianUuidNumber() {
			return jiaolianUuidNumber;
		}
		/**
		* 设置： 教练编号
		*/
		public void setJiaolianUuidNumber(String jiaolianUuidNumber) {
			this.jiaolianUuidNumber = jiaolianUuidNumber;
		}

		/**
		* 获取： 教练姓名
		*/
		public String getJiaolianName() {
			return jiaolianName;
		}
		/**
		* 设置： 教练姓名
		*/
		public void setJiaolianName(String jiaolianName) {
			this.jiaolianName = jiaolianName;
		}

		/**
		* 获取： 教练手机号
		*/
		public String getJiaolianPhone() {
			return jiaolianPhone;
		}
		/**
		* 设置： 教练手机号
		*/
		public void setJiaolianPhone(String jiaolianPhone) {
			this.jiaolianPhone = jiaolianPhone;
		}

		/**
		* 获取： 教练身份证号
		*/
		public String getJiaolianIdNumber() {
			return jiaolianIdNumber;
		}
		/**
		* 设置： 教练身份证号
		*/
		public void setJiaolianIdNumber(String jiaolianIdNumber) {
			this.jiaolianIdNumber = jiaolianIdNumber;
		}

		/**
		* 获取： 教练照片
		*/
		public String getJiaolianPhoto() {
			return jiaolianPhoto;
		}
		/**
		* 设置： 教练照片
		*/
		public void setJiaolianPhoto(String jiaolianPhoto) {
			this.jiaolianPhoto = jiaolianPhoto;
		}

		/**
		* 获取： 擅长
		*/
		public String getJiaolianShanchang() {
			return jiaolianShanchang;
		}
		/**
		* 设置： 擅长
		*/
		public void setJiaolianShanchang(String jiaolianShanchang) {
			this.jiaolianShanchang = jiaolianShanchang;
		}

		/**
		* 获取： 教练邮箱
		*/
		public String getJiaolianEmail() {
			return jiaolianEmail;
		}
		/**
		* 设置： 教练邮箱
		*/
		public void setJiaolianEmail(String jiaolianEmail) {
			this.jiaolianEmail = jiaolianEmail;
		}

		/**
		* 获取： 教练介绍
		*/
		public String getShangjiaContent() {
			return shangjiaContent;
		}
		/**
		* 设置： 教练介绍
		*/
		public void setShangjiaContent(String shangjiaContent) {
			this.shangjiaContent = shangjiaContent;
		}

		/**
		* 获取： 所获荣誉
		*/
		public String getShangjiaRongyuContent() {
			return shangjiaRongyuContent;
		}
		/**
		* 设置： 所获荣誉
		*/
		public void setShangjiaRongyuContent(String shangjiaRongyuContent) {
			this.shangjiaRongyuContent = shangjiaRongyuContent;
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

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getJinyongTypes() {
			return jinyongTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
			}
				public String getJinyongValue() {
				return jinyongValue;
				}
				public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
				}

	@Override
	public String toString() {
		return "JiaolianYuyueView{" +
			", jiaolianYuyueYesnoValue=" + jiaolianYuyueYesnoValue +
			", jiaolianUuidNumber=" + jiaolianUuidNumber +
			", jiaolianName=" + jiaolianName +
			", jiaolianPhone=" + jiaolianPhone +
			", jiaolianIdNumber=" + jiaolianIdNumber +
			", jiaolianPhoto=" + jiaolianPhoto +
			", jiaolianShanchang=" + jiaolianShanchang +
			", jiaolianEmail=" + jiaolianEmail +
			", newMoney=" + newMoney +
			", shangjiaContent=" + shangjiaContent +
			", shangjiaRongyuContent=" + shangjiaRongyuContent +
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
