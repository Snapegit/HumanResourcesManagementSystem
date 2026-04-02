package com.cl.dao;

import com.cl.entity.CanjiapeixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CanjiapeixunView;


/**
 * 参加培训
 * 
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
public interface CanjiapeixunDao extends BaseMapper<CanjiapeixunEntity> {
	
	List<CanjiapeixunView> selectListView(@Param("ew") Wrapper<CanjiapeixunEntity> wrapper);

	List<CanjiapeixunView> selectListView(Pagination page,@Param("ew") Wrapper<CanjiapeixunEntity> wrapper);
	
	CanjiapeixunView selectView(@Param("ew") Wrapper<CanjiapeixunEntity> wrapper);
	

}
