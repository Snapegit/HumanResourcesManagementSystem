package com.cl.dao;

import com.cl.entity.GongzixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GongzixinxiView;


/**
 * 工资信息
 * 
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
public interface GongzixinxiDao extends BaseMapper<GongzixinxiEntity> {
	
	List<GongzixinxiView> selectListView(@Param("ew") Wrapper<GongzixinxiEntity> wrapper);

	List<GongzixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<GongzixinxiEntity> wrapper);
	
	GongzixinxiView selectView(@Param("ew") Wrapper<GongzixinxiEntity> wrapper);
	

}
