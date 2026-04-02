package com.cl.dao;

import com.cl.entity.RenshizhuanyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenshizhuanyuanView;


/**
 * 人事专员
 * 
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
public interface RenshizhuanyuanDao extends BaseMapper<RenshizhuanyuanEntity> {
	
	List<RenshizhuanyuanView> selectListView(@Param("ew") Wrapper<RenshizhuanyuanEntity> wrapper);

	List<RenshizhuanyuanView> selectListView(Pagination page,@Param("ew") Wrapper<RenshizhuanyuanEntity> wrapper);
	
	RenshizhuanyuanView selectView(@Param("ew") Wrapper<RenshizhuanyuanEntity> wrapper);
	

}
