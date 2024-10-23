package com.dao;

import com.entity.QijuOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QijuOrderView;

/**
 * 器具订单 Dao 接口
 *
 * @author 
 */
public interface QijuOrderDao extends BaseMapper<QijuOrderEntity> {

   List<QijuOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
