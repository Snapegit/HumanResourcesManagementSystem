package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.GongzuojiluEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GongzuojiluView;


/**
 * 工作记录
 *
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
public interface GongzuojiluService extends IService<GongzuojiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongzuojiluView> selectListView(Wrapper<GongzuojiluEntity> wrapper);
   	
   	GongzuojiluView selectView(@Param("ew") Wrapper<GongzuojiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongzuojiluEntity> wrapper);
   	

}

