package com.cl.dao;

import com.cl.entity.PeixunpingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PeixunpingjiaView;


/**
 * 培训评价
 * 
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
public interface PeixunpingjiaDao extends BaseMapper<PeixunpingjiaEntity> {
	
	List<PeixunpingjiaView> selectListView(@Param("ew") Wrapper<PeixunpingjiaEntity> wrapper);

	List<PeixunpingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<PeixunpingjiaEntity> wrapper);
	
	PeixunpingjiaView selectView(@Param("ew") Wrapper<PeixunpingjiaEntity> wrapper);
	

}
