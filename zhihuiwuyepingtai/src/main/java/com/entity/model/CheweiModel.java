package com.entity.model;

import com.entity.CheweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 车位
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CheweiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 车位名称
     */
    private String cheweiName;


    /**
     * 车位编号
     */
    private String cheweiUuidNumber;


    /**
     * 车位照片
     */
    private String cheweiPhoto;


    /**
     * 车位地点
     */
    private String cheweiAddress;


    /**
     * 车位类型
     */
    private Integer cheweiTypes;


    /**
     * 车位状态
     */
    private Integer cheweiZhuangtaiTypes;


    /**
     * 金额/小时
     */
    private Double cheweiNewMoney;


    /**
     * 车位介绍
     */
    private String cheweiContent;


    /**
     * 逻辑删除
     */
    private Integer cheweiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
