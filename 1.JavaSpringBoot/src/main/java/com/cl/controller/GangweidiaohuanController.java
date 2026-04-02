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

import com.cl.entity.GangweidiaohuanEntity;
import com.cl.entity.view.GangweidiaohuanView;

import com.cl.service.GangweidiaohuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 岗位调换
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
@RestController
@RequestMapping("/gangweidiaohuan")
public class GangweidiaohuanController {
    @Autowired
    private GangweidiaohuanService gangweidiaohuanService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GangweidiaohuanEntity gangweidiaohuan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			gangweidiaohuan.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("renshizhuanyuan")) {
			gangweidiaohuan.setZhuanyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GangweidiaohuanEntity> ew = new EntityWrapper<GangweidiaohuanEntity>();

		PageUtils page = gangweidiaohuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangweidiaohuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GangweidiaohuanEntity gangweidiaohuan, 
		HttpServletRequest request){
        EntityWrapper<GangweidiaohuanEntity> ew = new EntityWrapper<GangweidiaohuanEntity>();

		PageUtils page = gangweidiaohuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangweidiaohuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GangweidiaohuanEntity gangweidiaohuan){
       	EntityWrapper<GangweidiaohuanEntity> ew = new EntityWrapper<GangweidiaohuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gangweidiaohuan, "gangweidiaohuan")); 
        return R.ok().put("data", gangweidiaohuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GangweidiaohuanEntity gangweidiaohuan){
        EntityWrapper< GangweidiaohuanEntity> ew = new EntityWrapper< GangweidiaohuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gangweidiaohuan, "gangweidiaohuan")); 
		GangweidiaohuanView gangweidiaohuanView =  gangweidiaohuanService.selectView(ew);
		return R.ok("查询岗位调换成功").put("data", gangweidiaohuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GangweidiaohuanEntity gangweidiaohuan = gangweidiaohuanService.selectById(id);
		gangweidiaohuan = gangweidiaohuanService.selectView(new EntityWrapper<GangweidiaohuanEntity>().eq("id", id));
        return R.ok().put("data", gangweidiaohuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GangweidiaohuanEntity gangweidiaohuan = gangweidiaohuanService.selectById(id);
		gangweidiaohuan = gangweidiaohuanService.selectView(new EntityWrapper<GangweidiaohuanEntity>().eq("id", id));
        return R.ok().put("data", gangweidiaohuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增岗位调换")
    public R save(@RequestBody GangweidiaohuanEntity gangweidiaohuan, HttpServletRequest request){
    	gangweidiaohuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gangweidiaohuan);
        gangweidiaohuanService.insert(gangweidiaohuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增岗位调换")
    @RequestMapping("/add")
    public R add(@RequestBody GangweidiaohuanEntity gangweidiaohuan, HttpServletRequest request){
    	gangweidiaohuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gangweidiaohuan);
        gangweidiaohuanService.insert(gangweidiaohuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改岗位调换")
    public R update(@RequestBody GangweidiaohuanEntity gangweidiaohuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gangweidiaohuan);
        gangweidiaohuanService.updateById(gangweidiaohuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除岗位调换")
    public R delete(@RequestBody Long[] ids){
        gangweidiaohuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
