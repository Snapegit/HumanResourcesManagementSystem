package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XinchoubiaozhunEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XinchoubiaozhunView;


/**
 * 薪酬标准
 *
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
public interface XinchoubiaozhunService extends IService<XinchoubiaozhunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinchoubiaozhunView> selectListView(Wrapper<XinchoubiaozhunEntity> wrapper);
   	
   	XinchoubiaozhunView selectView(@Param("ew") Wrapper<XinchoubiaozhunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinchoubiaozhunEntity> wrapper);
   	

}

