package com.entity.vo;

import com.entity.CheweiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 车位订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chewei_order")
public class CheweiOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "chewei_order_uuid_number")
    private String cheweiOrderUuidNumber;


    /**
     * 车位
     */

    @TableField(value = "chewei_id")
    private Integer cheweiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 实付价格
     */

    @TableField(value = "chewei_order_true_price")
    private Double cheweiOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "chewei_order_types")
    private Integer cheweiOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：订单编号
	 */
    public String getCheweiOrderUuidNumber() {
        return cheweiOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setCheweiOrderUuidNumber(String cheweiOrderUuidNumber) {
        this.cheweiOrderUuidNumber = cheweiOrderUuidNumber;
    }
    /**
	 * 设置：车位
	 */
    public Integer getCheweiId() {
        return cheweiId;
    }


    /**
	 * 获取：车位
	 */

    public void setCheweiId(Integer cheweiId) {
        this.cheweiId = cheweiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getCheweiOrderTruePrice() {
        return cheweiOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setCheweiOrderTruePrice(Double cheweiOrderTruePrice) {
        this.cheweiOrderTruePrice = cheweiOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getCheweiOrderTypes() {
        return cheweiOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setCheweiOrderTypes(Integer cheweiOrderTypes) {
        this.cheweiOrderTypes = cheweiOrderTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
