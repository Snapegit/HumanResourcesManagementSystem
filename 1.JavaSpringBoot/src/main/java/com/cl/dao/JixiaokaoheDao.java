package com.cl.dao;

import com.cl.entity.JixiaokaoheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JixiaokaoheView;


/**
 * 绩效考核
 * 
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
public interface JixiaokaoheDao extends BaseMapper<JixiaokaoheEntity> {
	
	List<JixiaokaoheView> selectListView(@Param("ew") Wrapper<JixiaokaoheEntity> wrapper);

	List<JixiaokaoheView> selectListView(Pagination page,@Param("ew") Wrapper<JixiaokaoheEntity> wrapper);
	
	JixiaokaoheView selectView(@Param("ew") Wrapper<JixiaokaoheEntity> wrapper);
	

}
