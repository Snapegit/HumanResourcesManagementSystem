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

import com.cl.entity.JixiaobiaozhunEntity;
import com.cl.entity.view.JixiaobiaozhunView;

import com.cl.service.JixiaobiaozhunService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 绩效标准
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
@RestController
@RequestMapping("/jixiaobiaozhun")
public class JixiaobiaozhunController {
    @Autowired
    private JixiaobiaozhunService jixiaobiaozhunService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JixiaobiaozhunEntity jixiaobiaozhun,
		HttpServletRequest request){
        EntityWrapper<JixiaobiaozhunEntity> ew = new EntityWrapper<JixiaobiaozhunEntity>();

		PageUtils page = jixiaobiaozhunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jixiaobiaozhun), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JixiaobiaozhunEntity jixiaobiaozhun, 
		HttpServletRequest request){
        EntityWrapper<JixiaobiaozhunEntity> ew = new EntityWrapper<JixiaobiaozhunEntity>();

		PageUtils page = jixiaobiaozhunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jixiaobiaozhun), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JixiaobiaozhunEntity jixiaobiaozhun){
       	EntityWrapper<JixiaobiaozhunEntity> ew = new EntityWrapper<JixiaobiaozhunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jixiaobiaozhun, "jixiaobiaozhun")); 
        return R.ok().put("data", jixiaobiaozhunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JixiaobiaozhunEntity jixiaobiaozhun){
        EntityWrapper< JixiaobiaozhunEntity> ew = new EntityWrapper< JixiaobiaozhunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jixiaobiaozhun, "jixiaobiaozhun")); 
		JixiaobiaozhunView jixiaobiaozhunView =  jixiaobiaozhunService.selectView(ew);
		return R.ok("查询绩效标准成功").put("data", jixiaobiaozhunView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JixiaobiaozhunEntity jixiaobiaozhun = jixiaobiaozhunService.selectById(id);
		jixiaobiaozhun = jixiaobiaozhunService.selectView(new EntityWrapper<JixiaobiaozhunEntity>().eq("id", id));
        return R.ok().put("data", jixiaobiaozhun);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JixiaobiaozhunEntity jixiaobiaozhun = jixiaobiaozhunService.selectById(id);
		jixiaobiaozhun = jixiaobiaozhunService.selectView(new EntityWrapper<JixiaobiaozhunEntity>().eq("id", id));
        return R.ok().put("data", jixiaobiaozhun);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增绩效标准")
    public R save(@RequestBody JixiaobiaozhunEntity jixiaobiaozhun, HttpServletRequest request){
    	jixiaobiaozhun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jixiaobiaozhun);
        jixiaobiaozhunService.insert(jixiaobiaozhun);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增绩效标准")
    @RequestMapping("/add")
    public R add(@RequestBody JixiaobiaozhunEntity jixiaobiaozhun, HttpServletRequest request){
    	jixiaobiaozhun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jixiaobiaozhun);
        jixiaobiaozhunService.insert(jixiaobiaozhun);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改绩效标准")
    public R update(@RequestBody JixiaobiaozhunEntity jixiaobiaozhun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jixiaobiaozhun);
        jixiaobiaozhunService.updateById(jixiaobiaozhun);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除绩效标准")
    public R delete(@RequestBody Long[] ids){
        jixiaobiaozhunService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
