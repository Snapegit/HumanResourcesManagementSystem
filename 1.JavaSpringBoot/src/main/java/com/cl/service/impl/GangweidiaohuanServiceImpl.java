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


import com.cl.dao.GangweidiaohuanDao;
import com.cl.entity.GangweidiaohuanEntity;
import com.cl.service.GangweidiaohuanService;
import com.cl.entity.view.GangweidiaohuanView;

@Service("gangweidiaohuanService")
public class GangweidiaohuanServiceImpl extends ServiceImpl<GangweidiaohuanDao, GangweidiaohuanEntity> implements GangweidiaohuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GangweidiaohuanEntity> page = this.selectPage(
                new Query<GangweidiaohuanEntity>(params).getPage(),
                new EntityWrapper<GangweidiaohuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GangweidiaohuanEntity> wrapper) {
		  Page<GangweidiaohuanView> page =new Query<GangweidiaohuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<GangweidiaohuanView> selectListView(Wrapper<GangweidiaohuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GangweidiaohuanView selectView(Wrapper<GangweidiaohuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
