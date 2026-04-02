package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JixiaobiaozhunEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JixiaobiaozhunView;


/**
 * 绩效标准
 *
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
public interface JixiaobiaozhunService extends IService<JixiaobiaozhunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JixiaobiaozhunView> selectListView(Wrapper<JixiaobiaozhunEntity> wrapper);
   	
   	JixiaobiaozhunView selectView(@Param("ew") Wrapper<JixiaobiaozhunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JixiaobiaozhunEntity> wrapper);
   	

}

