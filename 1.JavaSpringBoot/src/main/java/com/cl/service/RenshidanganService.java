package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.RenshidanganEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenshidanganView;


/**
 * 人事档案
 *
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
public interface RenshidanganService extends IService<RenshidanganEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RenshidanganView> selectListView(Wrapper<RenshidanganEntity> wrapper);
   	
   	RenshidanganView selectView(@Param("ew") Wrapper<RenshidanganEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RenshidanganEntity> wrapper);
   	

}

