package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.RenshizhuanyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenshizhuanyuanView;


/**
 * 人事专员
 *
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
public interface RenshizhuanyuanService extends IService<RenshizhuanyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RenshizhuanyuanView> selectListView(Wrapper<RenshizhuanyuanEntity> wrapper);
   	
   	RenshizhuanyuanView selectView(@Param("ew") Wrapper<RenshizhuanyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RenshizhuanyuanEntity> wrapper);
   	

}

