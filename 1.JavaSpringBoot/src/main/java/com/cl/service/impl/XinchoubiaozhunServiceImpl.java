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


import com.cl.dao.XinchoubiaozhunDao;
import com.cl.entity.XinchoubiaozhunEntity;
import com.cl.service.XinchoubiaozhunService;
import com.cl.entity.view.XinchoubiaozhunView;

@Service("xinchoubiaozhunService")
public class XinchoubiaozhunServiceImpl extends ServiceImpl<XinchoubiaozhunDao, XinchoubiaozhunEntity> implements XinchoubiaozhunService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinchoubiaozhunEntity> page = this.selectPage(
                new Query<XinchoubiaozhunEntity>(params).getPage(),
                new EntityWrapper<XinchoubiaozhunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinchoubiaozhunEntity> wrapper) {
		  Page<XinchoubiaozhunView> page =new Query<XinchoubiaozhunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XinchoubiaozhunView> selectListView(Wrapper<XinchoubiaozhunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinchoubiaozhunView selectView(Wrapper<XinchoubiaozhunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
