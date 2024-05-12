package com.entity.model;

import com.entity.CheweiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 车位订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CheweiOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单编号
     */
    private String cheweiOrderUuidNumber;


    /**
     * 车位
     */
    private Integer cheweiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 实付价格
     */
    private Double cheweiOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer cheweiOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：订单编号
	 */
    public String getCheweiOrderUuidNumber() {
        return cheweiOrderUuidNumber;
    }


    /**
	 * 设置：订单编号
	 */
    public void setCheweiOrderUuidNumber(String cheweiOrderUuidNumber) {
        this.cheweiOrderUuidNumber = cheweiOrderUuidNumber;
    }
    /**
	 * 获取：车位
	 */
    public Integer getCheweiId() {
        return cheweiId;
    }


    /**
	 * 设置：车位
	 */
    public void setCheweiId(Integer cheweiId) {
        this.cheweiId = cheweiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getCheweiOrderTruePrice() {
        return cheweiOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setCheweiOrderTruePrice(Double cheweiOrderTruePrice) {
        this.cheweiOrderTruePrice = cheweiOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getCheweiOrderTypes() {
        return cheweiOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setCheweiOrderTypes(Integer cheweiOrderTypes) {
        this.cheweiOrderTypes = cheweiOrderTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
