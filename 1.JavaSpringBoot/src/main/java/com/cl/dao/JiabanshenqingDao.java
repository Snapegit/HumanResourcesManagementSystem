package com.cl.dao;

import com.cl.entity.JiabanshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiabanshenqingView;


/**
 * 加班申请
 * 
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
public interface JiabanshenqingDao extends BaseMapper<JiabanshenqingEntity> {
	
	List<JiabanshenqingView> selectListView(@Param("ew") Wrapper<JiabanshenqingEntity> wrapper);

	List<JiabanshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<JiabanshenqingEntity> wrapper);
	
	JiabanshenqingView selectView(@Param("ew") Wrapper<JiabanshenqingEntity> wrapper);
	

}
