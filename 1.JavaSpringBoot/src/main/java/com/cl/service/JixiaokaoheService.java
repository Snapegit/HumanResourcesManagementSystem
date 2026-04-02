package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JixiaokaoheEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JixiaokaoheView;


/**
 * 绩效考核
 *
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
public interface JixiaokaoheService extends IService<JixiaokaoheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JixiaokaoheView> selectListView(Wrapper<JixiaokaoheEntity> wrapper);
   	
   	JixiaokaoheView selectView(@Param("ew") Wrapper<JixiaokaoheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JixiaokaoheEntity> wrapper);
   	

}

