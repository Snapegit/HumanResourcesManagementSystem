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


import com.cl.dao.PeixunxinxiDao;
import com.cl.entity.PeixunxinxiEntity;
import com.cl.service.PeixunxinxiService;
import com.cl.entity.view.PeixunxinxiView;

@Service("peixunxinxiService")
public class PeixunxinxiServiceImpl extends ServiceImpl<PeixunxinxiDao, PeixunxinxiEntity> implements PeixunxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeixunxinxiEntity> page = this.selectPage(
                new Query<PeixunxinxiEntity>(params).getPage(),
                new EntityWrapper<PeixunxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeixunxinxiEntity> wrapper) {
		  Page<PeixunxinxiView> page =new Query<PeixunxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<PeixunxinxiView> selectListView(Wrapper<PeixunxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeixunxinxiView selectView(Wrapper<PeixunxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
