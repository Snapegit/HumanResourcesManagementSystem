package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.GongzixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GongzixinxiView;


/**
 * 工资信息
 *
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
public interface GongzixinxiService extends IService<GongzixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongzixinxiView> selectListView(Wrapper<GongzixinxiEntity> wrapper);
   	
   	GongzixinxiView selectView(@Param("ew") Wrapper<GongzixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongzixinxiEntity> wrapper);
   	

}

