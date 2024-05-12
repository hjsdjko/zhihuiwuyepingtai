package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WeixuiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 维修指派
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("weixui")
public class WeixuiView extends WeixuiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 报修
					 
		/**
		* 报修 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer baoxiuYonghuId;
		/**
		* 报修名称
		*/

		@ColumnInfo(comment="报修名称",type="varchar(200)")
		private String baoxiuName;
		/**
		* 报修图片
		*/

		@ColumnInfo(comment="报修图片",type="varchar(200)")
		private String baoxiuPhoto;
		/**
		* 报修类型
		*/
		@ColumnInfo(comment="报修类型",type="int(11)")
		private Integer baoxiuTypes;
			/**
			* 报修类型的值
			*/
			@ColumnInfo(comment="报修类型的字典表值",type="varchar(200)")
			private String baoxiuValue;
		/**
		* 报修状态
		*/
		@ColumnInfo(comment="报修状态",type="int(11)")
		private Integer baoxiuZhuangtaiTypes;
			/**
			* 报修状态的值
			*/
			@ColumnInfo(comment="报修状态的字典表值",type="varchar(200)")
			private String baoxiuZhuangtaiValue;
		/**
		* 报修详情
		*/

		@ColumnInfo(comment="报修详情",type="text")
		private String baoxiuContent;
	//级联表 员工
		/**
		* 员工姓名
		*/

		@ColumnInfo(comment="员工姓名",type="varchar(200)")
		private String yuangongName;
		/**
		* 员工手机号
		*/

		@ColumnInfo(comment="员工手机号",type="varchar(200)")
		private String yuangongPhone;
		/**
		* 员工身份证号
		*/

		@ColumnInfo(comment="员工身份证号",type="varchar(200)")
		private String yuangongIdNumber;
		/**
		* 员工照片
		*/

		@ColumnInfo(comment="员工照片",type="varchar(200)")
		private String yuangongPhoto;



	public WeixuiView() {

	}

	public WeixuiView(WeixuiEntity weixuiEntity) {
		try {
			BeanUtils.copyProperties(this, weixuiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 报修
		/**
		* 获取：报修 的 用户
		*/
		public Integer getBaoxiuYonghuId() {
			return baoxiuYonghuId;
		}
		/**
		* 设置：报修 的 用户
		*/
		public void setBaoxiuYonghuId(Integer baoxiuYonghuId) {
			this.baoxiuYonghuId = baoxiuYonghuId;
		}

		/**
		* 获取： 报修名称
		*/
		public String getBaoxiuName() {
			return baoxiuName;
		}
		/**
		* 设置： 报修名称
		*/
		public void setBaoxiuName(String baoxiuName) {
			this.baoxiuName = baoxiuName;
		}

		/**
		* 获取： 报修图片
		*/
		public String getBaoxiuPhoto() {
			return baoxiuPhoto;
		}
		/**
		* 设置： 报修图片
		*/
		public void setBaoxiuPhoto(String baoxiuPhoto) {
			this.baoxiuPhoto = baoxiuPhoto;
		}
		/**
		* 获取： 报修类型
		*/
		public Integer getBaoxiuTypes() {
			return baoxiuTypes;
		}
		/**
		* 设置： 报修类型
		*/
		public void setBaoxiuTypes(Integer baoxiuTypes) {
			this.baoxiuTypes = baoxiuTypes;
		}


			/**
			* 获取： 报修类型的值
			*/
			public String getBaoxiuValue() {
				return baoxiuValue;
			}
			/**
			* 设置： 报修类型的值
			*/
			public void setBaoxiuValue(String baoxiuValue) {
				this.baoxiuValue = baoxiuValue;
			}
		/**
		* 获取： 报修状态
		*/
		public Integer getBaoxiuZhuangtaiTypes() {
			return baoxiuZhuangtaiTypes;
		}
		/**
		* 设置： 报修状态
		*/
		public void setBaoxiuZhuangtaiTypes(Integer baoxiuZhuangtaiTypes) {
			this.baoxiuZhuangtaiTypes = baoxiuZhuangtaiTypes;
		}


			/**
			* 获取： 报修状态的值
			*/
			public String getBaoxiuZhuangtaiValue() {
				return baoxiuZhuangtaiValue;
			}
			/**
			* 设置： 报修状态的值
			*/
			public void setBaoxiuZhuangtaiValue(String baoxiuZhuangtaiValue) {
				this.baoxiuZhuangtaiValue = baoxiuZhuangtaiValue;
			}

		/**
		* 获取： 报修详情
		*/
		public String getBaoxiuContent() {
			return baoxiuContent;
		}
		/**
		* 设置： 报修详情
		*/
		public void setBaoxiuContent(String baoxiuContent) {
			this.baoxiuContent = baoxiuContent;
		}
	//级联表的get和set 员工

		/**
		* 获取： 员工姓名
		*/
		public String getYuangongName() {
			return yuangongName;
		}
		/**
		* 设置： 员工姓名
		*/
		public void setYuangongName(String yuangongName) {
			this.yuangongName = yuangongName;
		}

		/**
		* 获取： 员工手机号
		*/
		public String getYuangongPhone() {
			return yuangongPhone;
		}
		/**
		* 设置： 员工手机号
		*/
		public void setYuangongPhone(String yuangongPhone) {
			this.yuangongPhone = yuangongPhone;
		}

		/**
		* 获取： 员工身份证号
		*/
		public String getYuangongIdNumber() {
			return yuangongIdNumber;
		}
		/**
		* 设置： 员工身份证号
		*/
		public void setYuangongIdNumber(String yuangongIdNumber) {
			this.yuangongIdNumber = yuangongIdNumber;
		}

		/**
		* 获取： 员工照片
		*/
		public String getYuangongPhoto() {
			return yuangongPhoto;
		}
		/**
		* 设置： 员工照片
		*/
		public void setYuangongPhoto(String yuangongPhoto) {
			this.yuangongPhoto = yuangongPhoto;
		}


	@Override
	public String toString() {
		return "WeixuiView{" +
			", baoxiuName=" + baoxiuName +
			", baoxiuPhoto=" + baoxiuPhoto +
			", baoxiuContent=" + baoxiuContent +
			", yuangongName=" + yuangongName +
			", yuangongPhone=" + yuangongPhone +
			", yuangongIdNumber=" + yuangongIdNumber +
			", yuangongPhoto=" + yuangongPhoto +
			"} " + super.toString();
	}
}
