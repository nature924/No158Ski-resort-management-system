package com.dao;

import com.entity.QijuCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QijuCollectionView;

/**
 * 器具收藏 Dao 接口
 *
 * @author 
 */
public interface QijuCollectionDao extends BaseMapper<QijuCollectionEntity> {

   List<QijuCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
