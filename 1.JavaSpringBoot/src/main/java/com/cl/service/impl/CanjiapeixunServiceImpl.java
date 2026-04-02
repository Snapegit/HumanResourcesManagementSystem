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


import com.cl.dao.CanjiapeixunDao;
import com.cl.entity.CanjiapeixunEntity;
import com.cl.service.CanjiapeixunService;
import com.cl.entity.view.CanjiapeixunView;

@Service("canjiapeixunService")
public class CanjiapeixunServiceImpl extends ServiceImpl<CanjiapeixunDao, CanjiapeixunEntity> implements CanjiapeixunService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CanjiapeixunEntity> page = this.selectPage(
                new Query<CanjiapeixunEntity>(params).getPage(),
                new EntityWrapper<CanjiapeixunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CanjiapeixunEntity> wrapper) {
		  Page<CanjiapeixunView> page =new Query<CanjiapeixunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<CanjiapeixunView> selectListView(Wrapper<CanjiapeixunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CanjiapeixunView selectView(Wrapper<CanjiapeixunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
