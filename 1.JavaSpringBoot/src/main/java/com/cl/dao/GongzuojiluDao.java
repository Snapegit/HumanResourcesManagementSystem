package com.cl.dao;

import com.cl.entity.GongzuojiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GongzuojiluView;


/**
 * 工作记录
 * 
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
public interface GongzuojiluDao extends BaseMapper<GongzuojiluEntity> {
	
	List<GongzuojiluView> selectListView(@Param("ew") Wrapper<GongzuojiluEntity> wrapper);

	List<GongzuojiluView> selectListView(Pagination page,@Param("ew") Wrapper<GongzuojiluEntity> wrapper);
	
	GongzuojiluView selectView(@Param("ew") Wrapper<GongzuojiluEntity> wrapper);
	

}
