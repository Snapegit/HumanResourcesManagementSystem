package com.cl.dao;

import com.cl.entity.RenshidanganEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenshidanganView;


/**
 * 人事档案
 * 
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
public interface RenshidanganDao extends BaseMapper<RenshidanganEntity> {
	
	List<RenshidanganView> selectListView(@Param("ew") Wrapper<RenshidanganEntity> wrapper);

	List<RenshidanganView> selectListView(Pagination page,@Param("ew") Wrapper<RenshidanganEntity> wrapper);
	
	RenshidanganView selectView(@Param("ew") Wrapper<RenshidanganEntity> wrapper);
	

}
