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


import com.cl.dao.JixiaobiaozhunDao;
import com.cl.entity.JixiaobiaozhunEntity;
import com.cl.service.JixiaobiaozhunService;
import com.cl.entity.view.JixiaobiaozhunView;

@Service("jixiaobiaozhunService")
public class JixiaobiaozhunServiceImpl extends ServiceImpl<JixiaobiaozhunDao, JixiaobiaozhunEntity> implements JixiaobiaozhunService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JixiaobiaozhunEntity> page = this.selectPage(
                new Query<JixiaobiaozhunEntity>(params).getPage(),
                new EntityWrapper<JixiaobiaozhunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JixiaobiaozhunEntity> wrapper) {
		  Page<JixiaobiaozhunView> page =new Query<JixiaobiaozhunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JixiaobiaozhunView> selectListView(Wrapper<JixiaobiaozhunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JixiaobiaozhunView selectView(Wrapper<JixiaobiaozhunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
