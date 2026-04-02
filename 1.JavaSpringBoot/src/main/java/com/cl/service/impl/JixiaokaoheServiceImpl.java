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


import com.cl.dao.JixiaokaoheDao;
import com.cl.entity.JixiaokaoheEntity;
import com.cl.service.JixiaokaoheService;
import com.cl.entity.view.JixiaokaoheView;

@Service("jixiaokaoheService")
public class JixiaokaoheServiceImpl extends ServiceImpl<JixiaokaoheDao, JixiaokaoheEntity> implements JixiaokaoheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JixiaokaoheEntity> page = this.selectPage(
                new Query<JixiaokaoheEntity>(params).getPage(),
                new EntityWrapper<JixiaokaoheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JixiaokaoheEntity> wrapper) {
		  Page<JixiaokaoheView> page =new Query<JixiaokaoheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JixiaokaoheView> selectListView(Wrapper<JixiaokaoheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JixiaokaoheView selectView(Wrapper<JixiaokaoheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
