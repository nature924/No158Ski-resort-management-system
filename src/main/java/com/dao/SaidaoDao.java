package com.dao;

import com.entity.SaidaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SaidaoView;

/**
 * 赛道 Dao 接口
 *
 * @author 
 */
public interface SaidaoDao extends BaseMapper<SaidaoEntity> {

   List<SaidaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
