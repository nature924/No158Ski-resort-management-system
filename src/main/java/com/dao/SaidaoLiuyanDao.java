package com.dao;

import com.entity.SaidaoLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SaidaoLiuyanView;

/**
 * 赛道留言 Dao 接口
 *
 * @author 
 */
public interface SaidaoLiuyanDao extends BaseMapper<SaidaoLiuyanEntity> {

   List<SaidaoLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
