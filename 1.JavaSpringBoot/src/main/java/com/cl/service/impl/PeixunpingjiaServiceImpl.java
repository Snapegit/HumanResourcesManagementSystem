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


import com.cl.dao.PeixunpingjiaDao;
import com.cl.entity.PeixunpingjiaEntity;
import com.cl.service.PeixunpingjiaService;
import com.cl.entity.view.PeixunpingjiaView;

@Service("peixunpingjiaService")
public class PeixunpingjiaServiceImpl extends ServiceImpl<PeixunpingjiaDao, PeixunpingjiaEntity> implements PeixunpingjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeixunpingjiaEntity> page = this.selectPage(
                new Query<PeixunpingjiaEntity>(params).getPage(),
                new EntityWrapper<PeixunpingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeixunpingjiaEntity> wrapper) {
		  Page<PeixunpingjiaView> page =new Query<PeixunpingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<PeixunpingjiaView> selectListView(Wrapper<PeixunpingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeixunpingjiaView selectView(Wrapper<PeixunpingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
