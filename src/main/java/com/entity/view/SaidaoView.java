package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.SaidaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 赛道
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("saidao")
public class SaidaoView extends SaidaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 赛道类型的值
	*/
	@ColumnInfo(comment="赛道类型的字典表值",type="varchar(200)")
	private String saidaoValue;
	/**
	* 是否上架的值
	*/
	@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
	private String shangxiaValue;




	public SaidaoView() {

	}

	public SaidaoView(SaidaoEntity saidaoEntity) {
		try {
			BeanUtils.copyProperties(this, saidaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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
	//当前表的
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




	@Override
	public String toString() {
		return "SaidaoView{" +
			", saidaoValue=" + saidaoValue +
			", shangxiaValue=" + shangxiaValue +
			"} " + super.toString();
	}
}
