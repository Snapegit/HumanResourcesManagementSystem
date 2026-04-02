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


import com.cl.dao.GongzixinxiDao;
import com.cl.entity.GongzixinxiEntity;
import com.cl.service.GongzixinxiService;
import com.cl.entity.view.GongzixinxiView;

@Service("gongzixinxiService")
public class GongzixinxiServiceImpl extends ServiceImpl<GongzixinxiDao, GongzixinxiEntity> implements GongzixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongzixinxiEntity> page = this.selectPage(
                new Query<GongzixinxiEntity>(params).getPage(),
                new EntityWrapper<GongzixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongzixinxiEntity> wrapper) {
		  Page<GongzixinxiView> page =new Query<GongzixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<GongzixinxiView> selectListView(Wrapper<GongzixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongzixinxiView selectView(Wrapper<GongzixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
