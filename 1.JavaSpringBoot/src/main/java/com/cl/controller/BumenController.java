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

import com.cl.entity.BumenEntity;
import com.cl.entity.view.BumenView;

import com.cl.service.BumenService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 部门
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
@RestController
@RequestMapping("/bumen")
public class BumenController {
    @Autowired
    private BumenService bumenService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BumenEntity bumen,
		HttpServletRequest request){
        EntityWrapper<BumenEntity> ew = new EntityWrapper<BumenEntity>();

		PageUtils page = bumenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bumen), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BumenEntity bumen, 
		HttpServletRequest request){
        EntityWrapper<BumenEntity> ew = new EntityWrapper<BumenEntity>();

		PageUtils page = bumenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bumen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BumenEntity bumen){
       	EntityWrapper<BumenEntity> ew = new EntityWrapper<BumenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( bumen, "bumen")); 
        return R.ok().put("data", bumenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BumenEntity bumen){
        EntityWrapper< BumenEntity> ew = new EntityWrapper< BumenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( bumen, "bumen")); 
		BumenView bumenView =  bumenService.selectView(ew);
		return R.ok("查询部门成功").put("data", bumenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BumenEntity bumen = bumenService.selectById(id);
		bumen = bumenService.selectView(new EntityWrapper<BumenEntity>().eq("id", id));
        return R.ok().put("data", bumen);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BumenEntity bumen = bumenService.selectById(id);
		bumen = bumenService.selectView(new EntityWrapper<BumenEntity>().eq("id", id));
        return R.ok().put("data", bumen);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增部门")
    public R save(@RequestBody BumenEntity bumen, HttpServletRequest request){
    	bumen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bumen);
        bumenService.insert(bumen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增部门")
    @RequestMapping("/add")
    public R add(@RequestBody BumenEntity bumen, HttpServletRequest request){
    	bumen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bumen);
        bumenService.insert(bumen);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改部门")
    public R update(@RequestBody BumenEntity bumen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bumen);
        bumenService.updateById(bumen);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除部门")
    public R delete(@RequestBody Long[] ids){
        bumenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
