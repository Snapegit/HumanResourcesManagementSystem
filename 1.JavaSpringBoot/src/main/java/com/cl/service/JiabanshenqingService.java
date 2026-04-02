package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiabanshenqingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiabanshenqingView;


/**
 * 加班申请
 *
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
public interface JiabanshenqingService extends IService<JiabanshenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiabanshenqingView> selectListView(Wrapper<JiabanshenqingEntity> wrapper);
   	
   	JiabanshenqingView selectView(@Param("ew") Wrapper<JiabanshenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiabanshenqingEntity> wrapper);
   	

}

