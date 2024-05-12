package com.entity.vo;

import com.entity.CheweiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 车位
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chewei")
public class CheweiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 车位名称
     */

    @TableField(value = "chewei_name")
    private String cheweiName;


    /**
     * 车位编号
     */

    @TableField(value = "chewei_uuid_number")
    private String cheweiUuidNumber;


    /**
     * 车位照片
     */

    @TableField(value = "chewei_photo")
    private String cheweiPhoto;


    /**
     * 车位地点
     */

    @TableField(value = "chewei_address")
    private String cheweiAddress;


    /**
     * 车位类型
     */

    @TableField(value = "chewei_types")
    private Integer cheweiTypes;


    /**
     * 车位状态
     */

    @TableField(value = "chewei_zhuangtai_types")
    private Integer cheweiZhuangtaiTypes;


    /**
     * 金额/小时
     */

    @TableField(value = "chewei_new_money")
    private Double cheweiNewMoney;


    /**
     * 车位介绍
     */

    @TableField(value = "chewei_content")
    private String cheweiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "chewei_delete")
    private Integer cheweiDelete;


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
	 * 设置：车位名称
	 */
    public String getCheweiName() {
        return cheweiName;
    }


    /**
	 * 获取：车位名称
	 */

    public void setCheweiName(String cheweiName) {
        this.cheweiName = cheweiName;
    }
    /**
	 * 设置：车位编号
	 */
    public String getCheweiUuidNumber() {
        return cheweiUuidNumber;
    }


    /**
	 * 获取：车位编号
	 */

    public void setCheweiUuidNumber(String cheweiUuidNumber) {
        this.cheweiUuidNumber = cheweiUuidNumber;
    }
    /**
	 * 设置：车位照片
	 */
    public String getCheweiPhoto() {
        return cheweiPhoto;
    }


    /**
	 * 获取：车位照片
	 */

    public void setCheweiPhoto(String cheweiPhoto) {
        this.cheweiPhoto = cheweiPhoto;
    }
    /**
	 * 设置：车位地点
	 */
    public String getCheweiAddress() {
        return cheweiAddress;
    }


    /**
	 * 获取：车位地点
	 */

    public void setCheweiAddress(String cheweiAddress) {
        this.cheweiAddress = cheweiAddress;
    }
    /**
	 * 设置：车位类型
	 */
    public Integer getCheweiTypes() {
        return cheweiTypes;
    }


    /**
	 * 获取：车位类型
	 */

    public void setCheweiTypes(Integer cheweiTypes) {
        this.cheweiTypes = cheweiTypes;
    }
    /**
	 * 设置：车位状态
	 */
    public Integer getCheweiZhuangtaiTypes() {
        return cheweiZhuangtaiTypes;
    }


    /**
	 * 获取：车位状态
	 */

    public void setCheweiZhuangtaiTypes(Integer cheweiZhuangtaiTypes) {
        this.cheweiZhuangtaiTypes = cheweiZhuangtaiTypes;
    }
    /**
	 * 设置：金额/小时
	 */
    public Double getCheweiNewMoney() {
        return cheweiNewMoney;
    }


    /**
	 * 获取：金额/小时
	 */

    public void setCheweiNewMoney(Double cheweiNewMoney) {
        this.cheweiNewMoney = cheweiNewMoney;
    }
    /**
	 * 设置：车位介绍
	 */
    public String getCheweiContent() {
        return cheweiContent;
    }


    /**
	 * 获取：车位介绍
	 */

    public void setCheweiContent(String cheweiContent) {
        this.cheweiContent = cheweiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getCheweiDelete() {
        return cheweiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setCheweiDelete(Integer cheweiDelete) {
        this.cheweiDelete = cheweiDelete;
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
