package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.PeixunxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PeixunxinxiView;


/**
 * 培训信息
 *
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
public interface PeixunxinxiService extends IService<PeixunxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PeixunxinxiView> selectListView(Wrapper<PeixunxinxiEntity> wrapper);
   	
   	PeixunxinxiView selectView(@Param("ew") Wrapper<PeixunxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PeixunxinxiEntity> wrapper);
   	

}

