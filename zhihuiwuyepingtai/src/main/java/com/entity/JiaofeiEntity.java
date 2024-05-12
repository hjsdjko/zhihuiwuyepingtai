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
 * 缴费
 *
 * @author 
 * @email
 */
@TableName("jiaofei")
public class JiaofeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaofeiEntity() {

	}

	public JiaofeiEntity(T t) {
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
     * 房源
     */
    @ColumnInfo(comment="房源",type="int(11)")
    @TableField(value = "fangwu_id")

    private Integer fangwuId;


    /**
     * 缴费名称
     */
    @ColumnInfo(comment="缴费名称",type="varchar(200)")
    @TableField(value = "jiaofei_name")

    private String jiaofeiName;


    /**
     * 缴费月份
     */
    @ColumnInfo(comment="缴费月份",type="varchar(200)")
    @TableField(value = "jiaofei_yuefen")

    private String jiaofeiYuefen;


    /**
     * 缴费类型
     */
    @ColumnInfo(comment="缴费类型",type="int(11)")
    @TableField(value = "jiaofei_types")

    private Integer jiaofeiTypes;


    /**
     * 缴费金额
     */
    @ColumnInfo(comment="缴费金额",type="decimal(10,2)")
    @TableField(value = "new_money")

    private Double newMoney;


    /**
     * 缴费详情
     */
    @ColumnInfo(comment="缴费详情",type="text")
    @TableField(value = "jiaofei_content")

    private String jiaofeiContent;


    /**
     * 是否缴费
     */
    @ColumnInfo(comment="是否缴费",type="int(11)")
    @TableField(value = "jiaofei_shifou_types")

    private Integer jiaofeiShifouTypes;


    /**
     * 缴费发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="缴费发布时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间   listShow
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
	 * 获取：房源
	 */
    public Integer getFangwuId() {
        return fangwuId;
    }
    /**
	 * 设置：房源
	 */

    public void setFangwuId(Integer fangwuId) {
        this.fangwuId = fangwuId;
    }
    /**
	 * 获取：缴费名称
	 */
    public String getJiaofeiName() {
        return jiaofeiName;
    }
    /**
	 * 设置：缴费名称
	 */

    public void setJiaofeiName(String jiaofeiName) {
        this.jiaofeiName = jiaofeiName;
    }
    /**
	 * 获取：缴费月份
	 */
    public String getJiaofeiYuefen() {
        return jiaofeiYuefen;
    }
    /**
	 * 设置：缴费月份
	 */

    public void setJiaofeiYuefen(String jiaofeiYuefen) {
        this.jiaofeiYuefen = jiaofeiYuefen;
    }
    /**
	 * 获取：缴费类型
	 */
    public Integer getJiaofeiTypes() {
        return jiaofeiTypes;
    }
    /**
	 * 设置：缴费类型
	 */

    public void setJiaofeiTypes(Integer jiaofeiTypes) {
        this.jiaofeiTypes = jiaofeiTypes;
    }
    /**
	 * 获取：缴费金额
	 */
    public Double getNewMoney() {
        return newMoney;
    }
    /**
	 * 设置：缴费金额
	 */

    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 获取：缴费详情
	 */
    public String getJiaofeiContent() {
        return jiaofeiContent;
    }
    /**
	 * 设置：缴费详情
	 */

    public void setJiaofeiContent(String jiaofeiContent) {
        this.jiaofeiContent = jiaofeiContent;
    }
    /**
	 * 获取：是否缴费
	 */
    public Integer getJiaofeiShifouTypes() {
        return jiaofeiShifouTypes;
    }
    /**
	 * 设置：是否缴费
	 */

    public void setJiaofeiShifouTypes(Integer jiaofeiShifouTypes) {
        this.jiaofeiShifouTypes = jiaofeiShifouTypes;
    }
    /**
	 * 获取：缴费发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：缴费发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiaofei{" +
            ", id=" + id +
            ", fangwuId=" + fangwuId +
            ", jiaofeiName=" + jiaofeiName +
            ", jiaofeiYuefen=" + jiaofeiYuefen +
            ", jiaofeiTypes=" + jiaofeiTypes +
            ", newMoney=" + newMoney +
            ", jiaofeiContent=" + jiaofeiContent +
            ", jiaofeiShifouTypes=" + jiaofeiShifouTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
