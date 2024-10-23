package com.dao;

import com.entity.QijuCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QijuCommentbackView;

/**
 * 器具评价 Dao 接口
 *
 * @author 
 */
public interface QijuCommentbackDao extends BaseMapper<QijuCommentbackEntity> {

   List<QijuCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
