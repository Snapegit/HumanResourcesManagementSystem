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


import com.cl.dao.BumenDao;
import com.cl.entity.BumenEntity;
import com.cl.service.BumenService;
import com.cl.entity.view.BumenView;

@Service("bumenService")
public class BumenServiceImpl extends ServiceImpl<BumenDao, BumenEntity> implements BumenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BumenEntity> page = this.selectPage(
                new Query<BumenEntity>(params).getPage(),
                new EntityWrapper<BumenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BumenEntity> wrapper) {
		  Page<BumenView> page =new Query<BumenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<BumenView> selectListView(Wrapper<BumenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BumenView selectView(Wrapper<BumenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
