package com.cl.dao;

import com.cl.entity.JixiaobiaozhunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JixiaobiaozhunView;


/**
 * 绩效标准
 * 
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
public interface JixiaobiaozhunDao extends BaseMapper<JixiaobiaozhunEntity> {
	
	List<JixiaobiaozhunView> selectListView(@Param("ew") Wrapper<JixiaobiaozhunEntity> wrapper);

	List<JixiaobiaozhunView> selectListView(Pagination page,@Param("ew") Wrapper<JixiaobiaozhunEntity> wrapper);
	
	JixiaobiaozhunView selectView(@Param("ew") Wrapper<JixiaobiaozhunEntity> wrapper);
	

}
