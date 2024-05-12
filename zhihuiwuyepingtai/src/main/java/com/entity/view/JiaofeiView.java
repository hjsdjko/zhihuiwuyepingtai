package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiaofeiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 缴费
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiaofei")
public class JiaofeiView extends JiaofeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 缴费类型的值
	*/
	@ColumnInfo(comment="缴费类型的字典表值",type="varchar(200)")
	private String jiaofeiValue;
	/**
	* 是否缴费的值
	*/
	@ColumnInfo(comment="是否缴费的字典表值",type="varchar(200)")
	private String jiaofeiShifouValue;

	//级联表 房屋
					 
		/**
		* 房屋 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer fangwuYonghuId;
		/**
		* 房屋名称
		*/

		@ColumnInfo(comment="房屋名称",type="varchar(200)")
		private String fangwuName;
		/**
		* 房屋地址
		*/

		@ColumnInfo(comment="房屋地址",type="varchar(200)")
		private String fangwuAddress;
		/**
		* 房屋照片
		*/

		@ColumnInfo(comment="房屋照片",type="varchar(200)")
		private String fangwuPhoto;
		/**
		* 房屋类型
		*/
		@ColumnInfo(comment="房屋类型",type="int(11)")
		private Integer fangwuTypes;
			/**
			* 房屋类型的值
			*/
			@ColumnInfo(comment="房屋类型的字典表值",type="varchar(200)")
			private String fangwuValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer fangwuDelete;
		/**
		* 房屋详情
		*/

		@ColumnInfo(comment="房屋详情",type="text")
		private String fangwuContent;



	public JiaofeiView() {

	}

	public JiaofeiView(JiaofeiEntity jiaofeiEntity) {
		try {
			BeanUtils.copyProperties(this, jiaofeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 缴费类型的值
	*/
	public String getJiaofeiValue() {
		return jiaofeiValue;
	}
	/**
	* 设置： 缴费类型的值
	*/
	public void setJiaofeiValue(String jiaofeiValue) {
		this.jiaofeiValue = jiaofeiValue;
	}
	//当前表的
	/**
	* 获取： 是否缴费的值
	*/
	public String getJiaofeiShifouValue() {
		return jiaofeiShifouValue;
	}
	/**
	* 设置： 是否缴费的值
	*/
	public void setJiaofeiShifouValue(String jiaofeiShifouValue) {
		this.jiaofeiShifouValue = jiaofeiShifouValue;
	}


	//级联表的get和set 房屋
		/**
		* 获取：房屋 的 用户
		*/
		public Integer getFangwuYonghuId() {
			return fangwuYonghuId;
		}
		/**
		* 设置：房屋 的 用户
		*/
		public void setFangwuYonghuId(Integer fangwuYonghuId) {
			this.fangwuYonghuId = fangwuYonghuId;
		}

		/**
		* 获取： 房屋名称
		*/
		public String getFangwuName() {
			return fangwuName;
		}
		/**
		* 设置： 房屋名称
		*/
		public void setFangwuName(String fangwuName) {
			this.fangwuName = fangwuName;
		}

		/**
		* 获取： 房屋地址
		*/
		public String getFangwuAddress() {
			return fangwuAddress;
		}
		/**
		* 设置： 房屋地址
		*/
		public void setFangwuAddress(String fangwuAddress) {
			this.fangwuAddress = fangwuAddress;
		}

		/**
		* 获取： 房屋照片
		*/
		public String getFangwuPhoto() {
			return fangwuPhoto;
		}
		/**
		* 设置： 房屋照片
		*/
		public void setFangwuPhoto(String fangwuPhoto) {
			this.fangwuPhoto = fangwuPhoto;
		}
		/**
		* 获取： 房屋类型
		*/
		public Integer getFangwuTypes() {
			return fangwuTypes;
		}
		/**
		* 设置： 房屋类型
		*/
		public void setFangwuTypes(Integer fangwuTypes) {
			this.fangwuTypes = fangwuTypes;
		}


			/**
			* 获取： 房屋类型的值
			*/
			public String getFangwuValue() {
				return fangwuValue;
			}
			/**
			* 设置： 房屋类型的值
			*/
			public void setFangwuValue(String fangwuValue) {
				this.fangwuValue = fangwuValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getFangwuDelete() {
			return fangwuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setFangwuDelete(Integer fangwuDelete) {
			this.fangwuDelete = fangwuDelete;
		}

		/**
		* 获取： 房屋详情
		*/
		public String getFangwuContent() {
			return fangwuContent;
		}
		/**
		* 设置： 房屋详情
		*/
		public void setFangwuContent(String fangwuContent) {
			this.fangwuContent = fangwuContent;
		}


	@Override
	public String toString() {
		return "JiaofeiView{" +
			", jiaofeiValue=" + jiaofeiValue +
			", jiaofeiShifouValue=" + jiaofeiShifouValue +
			", fangwuName=" + fangwuName +
			", fangwuAddress=" + fangwuAddress +
			", fangwuPhoto=" + fangwuPhoto +
			", fangwuDelete=" + fangwuDelete +
			", fangwuContent=" + fangwuContent +
			"} " + super.toString();
	}
}
