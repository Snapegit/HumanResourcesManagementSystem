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

import com.cl.entity.CanjiapeixunEntity;
import com.cl.entity.view.CanjiapeixunView;

import com.cl.service.CanjiapeixunService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 参加培训
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
@RestController
@RequestMapping("/canjiapeixun")
public class CanjiapeixunController {
    @Autowired
    private CanjiapeixunService canjiapeixunService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CanjiapeixunEntity canjiapeixun,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			canjiapeixun.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("renshizhuanyuan")) {
			canjiapeixun.setZhuanyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<CanjiapeixunEntity> ew = new EntityWrapper<CanjiapeixunEntity>();

		PageUtils page = canjiapeixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, canjiapeixun), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CanjiapeixunEntity canjiapeixun, 
		HttpServletRequest request){
        EntityWrapper<CanjiapeixunEntity> ew = new EntityWrapper<CanjiapeixunEntity>();

		PageUtils page = canjiapeixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, canjiapeixun), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CanjiapeixunEntity canjiapeixun){
       	EntityWrapper<CanjiapeixunEntity> ew = new EntityWrapper<CanjiapeixunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( canjiapeixun, "canjiapeixun")); 
        return R.ok().put("data", canjiapeixunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CanjiapeixunEntity canjiapeixun){
        EntityWrapper< CanjiapeixunEntity> ew = new EntityWrapper< CanjiapeixunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( canjiapeixun, "canjiapeixun")); 
		CanjiapeixunView canjiapeixunView =  canjiapeixunService.selectView(ew);
		return R.ok("查询参加培训成功").put("data", canjiapeixunView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CanjiapeixunEntity canjiapeixun = canjiapeixunService.selectById(id);
		canjiapeixun = canjiapeixunService.selectView(new EntityWrapper<CanjiapeixunEntity>().eq("id", id));
        return R.ok().put("data", canjiapeixun);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CanjiapeixunEntity canjiapeixun = canjiapeixunService.selectById(id);
		canjiapeixun = canjiapeixunService.selectView(new EntityWrapper<CanjiapeixunEntity>().eq("id", id));
        return R.ok().put("data", canjiapeixun);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增参加培训")
    public R save(@RequestBody CanjiapeixunEntity canjiapeixun, HttpServletRequest request){
    	canjiapeixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(canjiapeixun);
        canjiapeixunService.insert(canjiapeixun);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增参加培训")
    @RequestMapping("/add")
    public R add(@RequestBody CanjiapeixunEntity canjiapeixun, HttpServletRequest request){
    	canjiapeixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(canjiapeixun);
        canjiapeixunService.insert(canjiapeixun);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改参加培训")
    public R update(@RequestBody CanjiapeixunEntity canjiapeixun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(canjiapeixun);
        canjiapeixunService.updateById(canjiapeixun);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除参加培训")
    public R delete(@RequestBody Long[] ids){
        canjiapeixunService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
