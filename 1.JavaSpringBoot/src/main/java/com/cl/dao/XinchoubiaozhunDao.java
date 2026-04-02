package com.cl.dao;

import com.cl.entity.XinchoubiaozhunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XinchoubiaozhunView;


/**
 * 薪酬标准
 * 
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
public interface XinchoubiaozhunDao extends BaseMapper<XinchoubiaozhunEntity> {
	
	List<XinchoubiaozhunView> selectListView(@Param("ew") Wrapper<XinchoubiaozhunEntity> wrapper);

	List<XinchoubiaozhunView> selectListView(Pagination page,@Param("ew") Wrapper<XinchoubiaozhunEntity> wrapper);
	
	XinchoubiaozhunView selectView(@Param("ew") Wrapper<XinchoubiaozhunEntity> wrapper);
	

}
