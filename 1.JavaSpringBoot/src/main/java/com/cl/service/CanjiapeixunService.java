package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CanjiapeixunEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CanjiapeixunView;


/**
 * 参加培训
 *
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
public interface CanjiapeixunService extends IService<CanjiapeixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CanjiapeixunView> selectListView(Wrapper<CanjiapeixunEntity> wrapper);
   	
   	CanjiapeixunView selectView(@Param("ew") Wrapper<CanjiapeixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CanjiapeixunEntity> wrapper);
   	

}

