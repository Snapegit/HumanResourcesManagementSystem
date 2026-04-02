package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;
import com.cl.annotation.SysLog;

import com.cl.entity.PeixunxinxiEntity;
import com.cl.entity.view.PeixunxinxiView;

import com.cl.service.PeixunxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 培训信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
@RestController
@RequestMapping("/peixunxinxi")
public class PeixunxinxiController {
    @Autowired
    private PeixunxinxiService peixunxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PeixunxinxiEntity peixunxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("renshizhuanyuan")) {
			peixunxinxi.setZhuanyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PeixunxinxiEntity> ew = new EntityWrapper<PeixunxinxiEntity>();

		PageUtils page = peixunxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peixunxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PeixunxinxiEntity peixunxinxi, 
		HttpServletRequest request){
        EntityWrapper<PeixunxinxiEntity> ew = new EntityWrapper<PeixunxinxiEntity>();

		PageUtils page = peixunxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peixunxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PeixunxinxiEntity peixunxinxi){
       	EntityWrapper<PeixunxinxiEntity> ew = new EntityWrapper<PeixunxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( peixunxinxi, "peixunxinxi")); 
        return R.ok().put("data", peixunxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PeixunxinxiEntity peixunxinxi){
        EntityWrapper< PeixunxinxiEntity> ew = new EntityWrapper< PeixunxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( peixunxinxi, "peixunxinxi")); 
		PeixunxinxiView peixunxinxiView =  peixunxinxiService.selectView(ew);
		return R.ok("查询培训信息成功").put("data", peixunxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PeixunxinxiEntity peixunxinxi = peixunxinxiService.selectById(id);
		peixunxinxi = peixunxinxiService.selectView(new EntityWrapper<PeixunxinxiEntity>().eq("id", id));
        return R.ok().put("data", peixunxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PeixunxinxiEntity peixunxinxi = peixunxinxiService.selectById(id);
		peixunxinxi = peixunxinxiService.selectView(new EntityWrapper<PeixunxinxiEntity>().eq("id", id));
        return R.ok().put("data", peixunxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增培训信息")
    public R save(@RequestBody PeixunxinxiEntity peixunxinxi, HttpServletRequest request){
    	peixunxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(peixunxinxi);
        peixunxinxiService.insert(peixunxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增培训信息")
    @RequestMapping("/add")
    public R add(@RequestBody PeixunxinxiEntity peixunxinxi, HttpServletRequest request){
    	peixunxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(peixunxinxi);
        peixunxinxiService.insert(peixunxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改培训信息")
    public R update(@RequestBody PeixunxinxiEntity peixunxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(peixunxinxi);
        peixunxinxiService.updateById(peixunxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除培训信息")
    public R delete(@RequestBody Long[] ids){
        peixunxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
