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

import com.cl.entity.GongzixinxiEntity;
import com.cl.entity.view.GongzixinxiView;

import com.cl.service.GongzixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 工资信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
@RestController
@RequestMapping("/gongzixinxi")
public class GongzixinxiController {
    @Autowired
    private GongzixinxiService gongzixinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongzixinxiEntity gongzixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			gongzixinxi.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GongzixinxiEntity> ew = new EntityWrapper<GongzixinxiEntity>();

		PageUtils page = gongzixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongzixinxiEntity gongzixinxi, 
		HttpServletRequest request){
        EntityWrapper<GongzixinxiEntity> ew = new EntityWrapper<GongzixinxiEntity>();

		PageUtils page = gongzixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongzixinxiEntity gongzixinxi){
       	EntityWrapper<GongzixinxiEntity> ew = new EntityWrapper<GongzixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongzixinxi, "gongzixinxi")); 
        return R.ok().put("data", gongzixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongzixinxiEntity gongzixinxi){
        EntityWrapper< GongzixinxiEntity> ew = new EntityWrapper< GongzixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongzixinxi, "gongzixinxi")); 
		GongzixinxiView gongzixinxiView =  gongzixinxiService.selectView(ew);
		return R.ok("查询工资信息成功").put("data", gongzixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongzixinxiEntity gongzixinxi = gongzixinxiService.selectById(id);
		gongzixinxi = gongzixinxiService.selectView(new EntityWrapper<GongzixinxiEntity>().eq("id", id));
        return R.ok().put("data", gongzixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongzixinxiEntity gongzixinxi = gongzixinxiService.selectById(id);
		gongzixinxi = gongzixinxiService.selectView(new EntityWrapper<GongzixinxiEntity>().eq("id", id));
        return R.ok().put("data", gongzixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增工资信息")
    public R save(@RequestBody GongzixinxiEntity gongzixinxi, HttpServletRequest request){
    	gongzixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongzixinxi);
        gongzixinxiService.insert(gongzixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增工资信息")
    @RequestMapping("/add")
    public R add(@RequestBody GongzixinxiEntity gongzixinxi, HttpServletRequest request){
    	gongzixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongzixinxi);
        gongzixinxiService.insert(gongzixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改工资信息")
    public R update(@RequestBody GongzixinxiEntity gongzixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongzixinxi);
        gongzixinxiService.updateById(gongzixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除工资信息")
    public R delete(@RequestBody Long[] ids){
        gongzixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
