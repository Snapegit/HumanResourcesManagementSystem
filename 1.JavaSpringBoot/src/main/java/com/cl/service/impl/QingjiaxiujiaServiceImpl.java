package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.QingjiaxiujiaDao;
import com.cl.entity.QingjiaxiujiaEntity;
import com.cl.service.QingjiaxiujiaService;
import com.cl.entity.view.QingjiaxiujiaView;

@Service("qingjiaxiujiaService")
public class QingjiaxiujiaServiceImpl extends ServiceImpl<QingjiaxiujiaDao, QingjiaxiujiaEntity> implements QingjiaxiujiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QingjiaxiujiaEntity> page = this.selectPage(
                new Query<QingjiaxiujiaEntity>(params).getPage(),
                new EntityWrapper<QingjiaxiujiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QingjiaxiujiaEntity> wrapper) {
		  Page<QingjiaxiujiaView> page =new Query<QingjiaxiujiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<QingjiaxiujiaView> selectListView(Wrapper<QingjiaxiujiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QingjiaxiujiaView selectView(Wrapper<QingjiaxiujiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
