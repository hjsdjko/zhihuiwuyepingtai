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
 * 车位
 *
 * @author 
 * @email
 */
@TableName("chewei")
public class CheweiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CheweiEntity() {

	}

	public CheweiEntity(T t) {
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
     * 车位名称
     */
    @ColumnInfo(comment="车位名称",type="varchar(200)")
    @TableField(value = "chewei_name")

    private String cheweiName;


    /**
     * 车位编号
     */
    @ColumnInfo(comment="车位编号",type="varchar(200)")
    @TableField(value = "chewei_uuid_number")

    private String cheweiUuidNumber;


    /**
     * 车位照片
     */
    @ColumnInfo(comment="车位照片",type="varchar(200)")
    @TableField(value = "chewei_photo")

    private String cheweiPhoto;


    /**
     * 车位地点
     */
    @ColumnInfo(comment="车位地点",type="varchar(200)")
    @TableField(value = "chewei_address")

    private String cheweiAddress;


    /**
     * 车位类型
     */
    @ColumnInfo(comment="车位类型",type="int(11)")
    @TableField(value = "chewei_types")

    private Integer cheweiTypes;


    /**
     * 车位状态
     */
    @ColumnInfo(comment="车位状态",type="int(11)")
    @TableField(value = "chewei_zhuangtai_types")

    private Integer cheweiZhuangtaiTypes;


    /**
     * 金额/小时
     */
    @ColumnInfo(comment="金额/小时",type="decimal(10,2)")
    @TableField(value = "chewei_new_money")

    private Double cheweiNewMoney;


    /**
     * 车位介绍
     */
    @ColumnInfo(comment="车位介绍",type="longtext")
    @TableField(value = "chewei_content")

    private String cheweiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "chewei_delete")

    private Integer cheweiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：车位名称
	 */
    public String getCheweiName() {
        return cheweiName;
    }
    /**
	 * 设置：车位名称
	 */

    public void setCheweiName(String cheweiName) {
        this.cheweiName = cheweiName;
    }
    /**
	 * 获取：车位编号
	 */
    public String getCheweiUuidNumber() {
        return cheweiUuidNumber;
    }
    /**
	 * 设置：车位编号
	 */

    public void setCheweiUuidNumber(String cheweiUuidNumber) {
        this.cheweiUuidNumber = cheweiUuidNumber;
    }
    /**
	 * 获取：车位照片
	 */
    public String getCheweiPhoto() {
        return cheweiPhoto;
    }
    /**
	 * 设置：车位照片
	 */

    public void setCheweiPhoto(String cheweiPhoto) {
        this.cheweiPhoto = cheweiPhoto;
    }
    /**
	 * 获取：车位地点
	 */
    public String getCheweiAddress() {
        return cheweiAddress;
    }
    /**
	 * 设置：车位地点
	 */

    public void setCheweiAddress(String cheweiAddress) {
        this.cheweiAddress = cheweiAddress;
    }
    /**
	 * 获取：车位类型
	 */
    public Integer getCheweiTypes() {
        return cheweiTypes;
    }
    /**
	 * 设置：车位类型
	 */

    public void setCheweiTypes(Integer cheweiTypes) {
        this.cheweiTypes = cheweiTypes;
    }
    /**
	 * 获取：车位状态
	 */
    public Integer getCheweiZhuangtaiTypes() {
        return cheweiZhuangtaiTypes;
    }
    /**
	 * 设置：车位状态
	 */

    public void setCheweiZhuangtaiTypes(Integer cheweiZhuangtaiTypes) {
        this.cheweiZhuangtaiTypes = cheweiZhuangtaiTypes;
    }
    /**
	 * 获取：金额/小时
	 */
    public Double getCheweiNewMoney() {
        return cheweiNewMoney;
    }
    /**
	 * 设置：金额/小时
	 */

    public void setCheweiNewMoney(Double cheweiNewMoney) {
        this.cheweiNewMoney = cheweiNewMoney;
    }
    /**
	 * 获取：车位介绍
	 */
    public String getCheweiContent() {
        return cheweiContent;
    }
    /**
	 * 设置：车位介绍
	 */

    public void setCheweiContent(String cheweiContent) {
        this.cheweiContent = cheweiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getCheweiDelete() {
        return cheweiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setCheweiDelete(Integer cheweiDelete) {
        this.cheweiDelete = cheweiDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Chewei{" +
            ", id=" + id +
            ", cheweiName=" + cheweiName +
            ", cheweiUuidNumber=" + cheweiUuidNumber +
            ", cheweiPhoto=" + cheweiPhoto +
            ", cheweiAddress=" + cheweiAddress +
            ", cheweiTypes=" + cheweiTypes +
            ", cheweiZhuangtaiTypes=" + cheweiZhuangtaiTypes +
            ", cheweiNewMoney=" + cheweiNewMoney +
            ", cheweiContent=" + cheweiContent +
            ", cheweiDelete=" + cheweiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
