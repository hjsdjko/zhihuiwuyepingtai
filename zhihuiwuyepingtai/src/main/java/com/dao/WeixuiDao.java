package com.dao;

import com.entity.WeixuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WeixuiView;

/**
 * 维修指派 Dao 接口
 *
 * @author 
 */
public interface WeixuiDao extends BaseMapper<WeixuiEntity> {

   List<WeixuiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
