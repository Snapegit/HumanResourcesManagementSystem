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

import com.cl.entity.GongzuojiluEntity;
import com.cl.entity.view.GongzuojiluView;

import com.cl.service.GongzuojiluService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 工作记录
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
@RestController
@RequestMapping("/gongzuojilu")
public class GongzuojiluController {
    @Autowired
    private GongzuojiluService gongzuojiluService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongzuojiluEntity gongzuojilu,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date riqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date riqiend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			gongzuojilu.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GongzuojiluEntity> ew = new EntityWrapper<GongzuojiluEntity>();
                if(riqistart!=null) ew.ge("riqi", riqistart);
                if(riqiend!=null) ew.le("riqi", riqiend);

		PageUtils page = gongzuojiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzuojilu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongzuojiluEntity gongzuojilu, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date riqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date riqiend,
		HttpServletRequest request){
        EntityWrapper<GongzuojiluEntity> ew = new EntityWrapper<GongzuojiluEntity>();
                if(riqistart!=null) ew.ge("riqi", riqistart);
                if(riqiend!=null) ew.le("riqi", riqiend);

		PageUtils page = gongzuojiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzuojilu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongzuojiluEntity gongzuojilu){
       	EntityWrapper<GongzuojiluEntity> ew = new EntityWrapper<GongzuojiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongzuojilu, "gongzuojilu")); 
        return R.ok().put("data", gongzuojiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongzuojiluEntity gongzuojilu){
        EntityWrapper< GongzuojiluEntity> ew = new EntityWrapper< GongzuojiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongzuojilu, "gongzuojilu")); 
		GongzuojiluView gongzuojiluView =  gongzuojiluService.selectView(ew);
		return R.ok("查询工作记录成功").put("data", gongzuojiluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongzuojiluEntity gongzuojilu = gongzuojiluService.selectById(id);
		gongzuojilu = gongzuojiluService.selectView(new EntityWrapper<GongzuojiluEntity>().eq("id", id));
        return R.ok().put("data", gongzuojilu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongzuojiluEntity gongzuojilu = gongzuojiluService.selectById(id);
		gongzuojilu = gongzuojiluService.selectView(new EntityWrapper<GongzuojiluEntity>().eq("id", id));
        return R.ok().put("data", gongzuojilu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增工作记录")
    public R save(@RequestBody GongzuojiluEntity gongzuojilu, HttpServletRequest request){
    	gongzuojilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongzuojilu);
        gongzuojiluService.insert(gongzuojilu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增工作记录")
    @RequestMapping("/add")
    public R add(@RequestBody GongzuojiluEntity gongzuojilu, HttpServletRequest request){
    	gongzuojilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongzuojilu);
        gongzuojiluService.insert(gongzuojilu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改工作记录")
    public R update(@RequestBody GongzuojiluEntity gongzuojilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongzuojilu);
        gongzuojiluService.updateById(gongzuojilu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除工作记录")
    public R delete(@RequestBody Long[] ids){
        gongzuojiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
