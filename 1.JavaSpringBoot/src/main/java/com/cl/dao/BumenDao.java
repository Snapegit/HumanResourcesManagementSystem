package com.cl.dao;

import com.cl.entity.BumenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BumenView;


/**
 * 部门
 * 
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
public interface BumenDao extends BaseMapper<BumenEntity> {
	
	List<BumenView> selectListView(@Param("ew") Wrapper<BumenEntity> wrapper);

	List<BumenView> selectListView(Pagination page,@Param("ew") Wrapper<BumenEntity> wrapper);
	
	BumenView selectView(@Param("ew") Wrapper<BumenEntity> wrapper);
	

}
