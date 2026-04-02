package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BumenEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BumenView;


/**
 * 部门
 *
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
public interface BumenService extends IService<BumenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BumenView> selectListView(Wrapper<BumenEntity> wrapper);
   	
   	BumenView selectView(@Param("ew") Wrapper<BumenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BumenEntity> wrapper);
   	

}

