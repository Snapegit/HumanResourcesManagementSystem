package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.QingjiaxiujiaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QingjiaxiujiaView;


/**
 * 请假休假
 *
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
public interface QingjiaxiujiaService extends IService<QingjiaxiujiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QingjiaxiujiaView> selectListView(Wrapper<QingjiaxiujiaEntity> wrapper);
   	
   	QingjiaxiujiaView selectView(@Param("ew") Wrapper<QingjiaxiujiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QingjiaxiujiaEntity> wrapper);
   	

}

