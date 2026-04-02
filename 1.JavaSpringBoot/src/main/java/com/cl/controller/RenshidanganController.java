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

import com.cl.entity.RenshidanganEntity;
import com.cl.entity.view.RenshidanganView;

import com.cl.service.RenshidanganService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 人事档案
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
@RestController
@RequestMapping("/renshidangan")
public class RenshidanganController {
    @Autowired
    private RenshidanganService renshidanganService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RenshidanganEntity renshidangan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			renshidangan.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<RenshidanganEntity> ew = new EntityWrapper<RenshidanganEntity>();

		PageUtils page = renshidanganService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renshidangan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RenshidanganEntity renshidangan, 
		HttpServletRequest request){
        EntityWrapper<RenshidanganEntity> ew = new EntityWrapper<RenshidanganEntity>();

		PageUtils page = renshidanganService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renshidangan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RenshidanganEntity renshidangan){
       	EntityWrapper<RenshidanganEntity> ew = new EntityWrapper<RenshidanganEntity>();
      	ew.allEq(MPUtil.allEQMapPre( renshidangan, "renshidangan")); 
        return R.ok().put("data", renshidanganService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RenshidanganEntity renshidangan){
        EntityWrapper< RenshidanganEntity> ew = new EntityWrapper< RenshidanganEntity>();
 		ew.allEq(MPUtil.allEQMapPre( renshidangan, "renshidangan")); 
		RenshidanganView renshidanganView =  renshidanganService.selectView(ew);
		return R.ok("查询人事档案成功").put("data", renshidanganView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RenshidanganEntity renshidangan = renshidanganService.selectById(id);
		renshidangan = renshidanganService.selectView(new EntityWrapper<RenshidanganEntity>().eq("id", id));
        return R.ok().put("data", renshidangan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RenshidanganEntity renshidangan = renshidanganService.selectById(id);
		renshidangan = renshidanganService.selectView(new EntityWrapper<RenshidanganEntity>().eq("id", id));
        return R.ok().put("data", renshidangan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增人事档案")
    public R save(@RequestBody RenshidanganEntity renshidangan, HttpServletRequest request){
    	renshidangan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(renshidangan);
        renshidanganService.insert(renshidangan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增人事档案")
    @RequestMapping("/add")
    public R add(@RequestBody RenshidanganEntity renshidangan, HttpServletRequest request){
    	renshidangan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(renshidangan);
        renshidanganService.insert(renshidangan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改人事档案")
    public R update(@RequestBody RenshidanganEntity renshidangan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(renshidangan);
        renshidanganService.updateById(renshidangan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除人事档案")
    public R delete(@RequestBody Long[] ids){
        renshidanganService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
