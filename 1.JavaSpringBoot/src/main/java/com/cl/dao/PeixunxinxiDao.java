package com.cl.dao;

import com.cl.entity.PeixunxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PeixunxinxiView;


/**
 * 培训信息
 * 
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
public interface PeixunxinxiDao extends BaseMapper<PeixunxinxiEntity> {
	
	List<PeixunxinxiView> selectListView(@Param("ew") Wrapper<PeixunxinxiEntity> wrapper);

	List<PeixunxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<PeixunxinxiEntity> wrapper);
	
	PeixunxinxiView selectView(@Param("ew") Wrapper<PeixunxinxiEntity> wrapper);
	

}
