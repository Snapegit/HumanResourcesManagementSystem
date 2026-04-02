package com.cl.dao;

import com.cl.entity.GangweidiaohuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GangweidiaohuanView;


/**
 * 岗位调换
 * 
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
public interface GangweidiaohuanDao extends BaseMapper<GangweidiaohuanEntity> {
	
	List<GangweidiaohuanView> selectListView(@Param("ew") Wrapper<GangweidiaohuanEntity> wrapper);

	List<GangweidiaohuanView> selectListView(Pagination page,@Param("ew") Wrapper<GangweidiaohuanEntity> wrapper);
	
	GangweidiaohuanView selectView(@Param("ew") Wrapper<GangweidiaohuanEntity> wrapper);
	

}
