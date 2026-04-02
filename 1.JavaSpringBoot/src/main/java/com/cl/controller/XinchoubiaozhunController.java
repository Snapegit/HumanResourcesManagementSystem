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

import com.cl.entity.XinchoubiaozhunEntity;
import com.cl.entity.view.XinchoubiaozhunView;

import com.cl.service.XinchoubiaozhunService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 薪酬标准
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
@RestController
@RequestMapping("/xinchoubiaozhun")
public class XinchoubiaozhunController {
    @Autowired
    private XinchoubiaozhunService xinchoubiaozhunService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XinchoubiaozhunEntity xinchoubiaozhun,
                @RequestParam(required = false) Double dixinstart,
                @RequestParam(required = false) Double dixinend,
		HttpServletRequest request){
        EntityWrapper<XinchoubiaozhunEntity> ew = new EntityWrapper<XinchoubiaozhunEntity>();
                if(dixinstart!=null) ew.ge("dixin", dixinstart);
                if(dixinend!=null) ew.le("dixin", dixinend);

		PageUtils page = xinchoubiaozhunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinchoubiaozhun), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XinchoubiaozhunEntity xinchoubiaozhun, 
                @RequestParam(required = false) Double dixinstart,
                @RequestParam(required = false) Double dixinend,
		HttpServletRequest request){
        EntityWrapper<XinchoubiaozhunEntity> ew = new EntityWrapper<XinchoubiaozhunEntity>();
                if(dixinstart!=null) ew.ge("dixin", dixinstart);
                if(dixinend!=null) ew.le("dixin", dixinend);

		PageUtils page = xinchoubiaozhunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinchoubiaozhun), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XinchoubiaozhunEntity xinchoubiaozhun){
       	EntityWrapper<XinchoubiaozhunEntity> ew = new EntityWrapper<XinchoubiaozhunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xinchoubiaozhun, "xinchoubiaozhun")); 
        return R.ok().put("data", xinchoubiaozhunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XinchoubiaozhunEntity xinchoubiaozhun){
        EntityWrapper< XinchoubiaozhunEntity> ew = new EntityWrapper< XinchoubiaozhunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xinchoubiaozhun, "xinchoubiaozhun")); 
		XinchoubiaozhunView xinchoubiaozhunView =  xinchoubiaozhunService.selectView(ew);
		return R.ok("查询薪酬标准成功").put("data", xinchoubiaozhunView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XinchoubiaozhunEntity xinchoubiaozhun = xinchoubiaozhunService.selectById(id);
		xinchoubiaozhun = xinchoubiaozhunService.selectView(new EntityWrapper<XinchoubiaozhunEntity>().eq("id", id));
        return R.ok().put("data", xinchoubiaozhun);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XinchoubiaozhunEntity xinchoubiaozhun = xinchoubiaozhunService.selectById(id);
		xinchoubiaozhun = xinchoubiaozhunService.selectView(new EntityWrapper<XinchoubiaozhunEntity>().eq("id", id));
        return R.ok().put("data", xinchoubiaozhun);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增薪酬标准")
    public R save(@RequestBody XinchoubiaozhunEntity xinchoubiaozhun, HttpServletRequest request){
    	xinchoubiaozhun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinchoubiaozhun);
        xinchoubiaozhunService.insert(xinchoubiaozhun);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增薪酬标准")
    @RequestMapping("/add")
    public R add(@RequestBody XinchoubiaozhunEntity xinchoubiaozhun, HttpServletRequest request){
    	xinchoubiaozhun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinchoubiaozhun);
        xinchoubiaozhunService.insert(xinchoubiaozhun);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改薪酬标准")
    public R update(@RequestBody XinchoubiaozhunEntity xinchoubiaozhun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinchoubiaozhun);
        xinchoubiaozhunService.updateById(xinchoubiaozhun);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除薪酬标准")
    public R delete(@RequestBody Long[] ids){
        xinchoubiaozhunService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
