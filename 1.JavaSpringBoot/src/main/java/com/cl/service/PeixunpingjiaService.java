package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.PeixunpingjiaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PeixunpingjiaView;


/**
 * 培训评价
 *
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
public interface PeixunpingjiaService extends IService<PeixunpingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PeixunpingjiaView> selectListView(Wrapper<PeixunpingjiaEntity> wrapper);
   	
   	PeixunpingjiaView selectView(@Param("ew") Wrapper<PeixunpingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PeixunpingjiaEntity> wrapper);
   	

}

