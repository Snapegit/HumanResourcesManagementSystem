package com.cl.dao;

import com.cl.entity.QingjiaxiujiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QingjiaxiujiaView;


/**
 * 请假休假
 * 
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
public interface QingjiaxiujiaDao extends BaseMapper<QingjiaxiujiaEntity> {
	
	List<QingjiaxiujiaView> selectListView(@Param("ew") Wrapper<QingjiaxiujiaEntity> wrapper);

	List<QingjiaxiujiaView> selectListView(Pagination page,@Param("ew") Wrapper<QingjiaxiujiaEntity> wrapper);
	
	QingjiaxiujiaView selectView(@Param("ew") Wrapper<QingjiaxiujiaEntity> wrapper);
	

}
