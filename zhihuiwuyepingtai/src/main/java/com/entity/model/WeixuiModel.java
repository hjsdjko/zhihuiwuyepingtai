package com.entity.model;

import com.entity.WeixuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 维修指派
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WeixuiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报修
     */
    private Integer baoxiuId;


    /**
     * 维修人员
     */
    private Integer yuangongId;


    /**
     * 指派时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 备注
     */
    private String weixuiText;


    /**
     * 创建时间
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
	 * 获取：报修
	 */
    public Integer getBaoxiuId() {
        return baoxiuId;
    }


    /**
	 * 设置：报修
	 */
    public void setBaoxiuId(Integer baoxiuId) {
        this.baoxiuId = baoxiuId;
    }
    /**
	 * 获取：维修人员
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 设置：维修人员
	 */
    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：指派时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：指派时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：备注
	 */
    public String getWeixuiText() {
        return weixuiText;
    }


    /**
	 * 设置：备注
	 */
    public void setWeixuiText(String weixuiText) {
        this.weixuiText = weixuiText;
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

    }
