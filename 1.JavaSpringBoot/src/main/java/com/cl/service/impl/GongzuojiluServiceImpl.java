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


import com.cl.dao.GongzuojiluDao;
import com.cl.entity.GongzuojiluEntity;
import com.cl.service.GongzuojiluService;
import com.cl.entity.view.GongzuojiluView;

@Service("gongzuojiluService")
public class GongzuojiluServiceImpl extends ServiceImpl<GongzuojiluDao, GongzuojiluEntity> implements GongzuojiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongzuojiluEntity> page = this.selectPage(
                new Query<GongzuojiluEntity>(params).getPage(),
                new EntityWrapper<GongzuojiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongzuojiluEntity> wrapper) {
		  Page<GongzuojiluView> page =new Query<GongzuojiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<GongzuojiluView> selectListView(Wrapper<GongzuojiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongzuojiluView selectView(Wrapper<GongzuojiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
