package com.dao;

import com.entity.CheweiOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CheweiOrderView;

/**
 * 车位订单 Dao 接口
 *
 * @author 
 */
public interface CheweiOrderDao extends BaseMapper<CheweiOrderEntity> {

   List<CheweiOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
