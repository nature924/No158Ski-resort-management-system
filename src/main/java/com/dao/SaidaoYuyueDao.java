package com.dao;

import com.entity.SaidaoYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SaidaoYuyueView;

/**
 * 赛道预约 Dao 接口
 *
 * @author 
 */
public interface SaidaoYuyueDao extends BaseMapper<SaidaoYuyueEntity> {

   List<SaidaoYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
