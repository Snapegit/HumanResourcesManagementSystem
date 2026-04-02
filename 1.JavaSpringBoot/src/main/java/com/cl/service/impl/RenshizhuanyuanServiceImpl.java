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


import com.cl.dao.RenshizhuanyuanDao;
import com.cl.entity.RenshizhuanyuanEntity;
import com.cl.service.RenshizhuanyuanService;
import com.cl.entity.view.RenshizhuanyuanView;

@Service("renshizhuanyuanService")
public class RenshizhuanyuanServiceImpl extends ServiceImpl<RenshizhuanyuanDao, RenshizhuanyuanEntity> implements RenshizhuanyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RenshizhuanyuanEntity> page = this.selectPage(
                new Query<RenshizhuanyuanEntity>(params).getPage(),
                new EntityWrapper<RenshizhuanyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RenshizhuanyuanEntity> wrapper) {
		  Page<RenshizhuanyuanView> page =new Query<RenshizhuanyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<RenshizhuanyuanView> selectListView(Wrapper<RenshizhuanyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RenshizhuanyuanView selectView(Wrapper<RenshizhuanyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
