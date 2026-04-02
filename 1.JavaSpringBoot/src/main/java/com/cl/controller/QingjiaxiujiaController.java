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

import com.cl.entity.QingjiaxiujiaEntity;
import com.cl.entity.view.QingjiaxiujiaView;

import com.cl.service.QingjiaxiujiaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 请假休假
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
@RestController
@RequestMapping("/qingjiaxiujia")
public class QingjiaxiujiaController {
    @Autowired
    private QingjiaxiujiaService qingjiaxiujiaService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QingjiaxiujiaEntity qingjiaxiujia,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			qingjiaxiujia.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("renshizhuanyuan")) {
			qingjiaxiujia.setZhuanyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QingjiaxiujiaEntity> ew = new EntityWrapper<QingjiaxiujiaEntity>();

		PageUtils page = qingjiaxiujiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qingjiaxiujia), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QingjiaxiujiaEntity qingjiaxiujia, 
		HttpServletRequest request){
        EntityWrapper<QingjiaxiujiaEntity> ew = new EntityWrapper<QingjiaxiujiaEntity>();

		PageUtils page = qingjiaxiujiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qingjiaxiujia), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QingjiaxiujiaEntity qingjiaxiujia){
       	EntityWrapper<QingjiaxiujiaEntity> ew = new EntityWrapper<QingjiaxiujiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qingjiaxiujia, "qingjiaxiujia")); 
        return R.ok().put("data", qingjiaxiujiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QingjiaxiujiaEntity qingjiaxiujia){
        EntityWrapper< QingjiaxiujiaEntity> ew = new EntityWrapper< QingjiaxiujiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qingjiaxiujia, "qingjiaxiujia")); 
		QingjiaxiujiaView qingjiaxiujiaView =  qingjiaxiujiaService.selectView(ew);
		return R.ok("查询请假休假成功").put("data", qingjiaxiujiaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QingjiaxiujiaEntity qingjiaxiujia = qingjiaxiujiaService.selectById(id);
		qingjiaxiujia = qingjiaxiujiaService.selectView(new EntityWrapper<QingjiaxiujiaEntity>().eq("id", id));
        return R.ok().put("data", qingjiaxiujia);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QingjiaxiujiaEntity qingjiaxiujia = qingjiaxiujiaService.selectById(id);
		qingjiaxiujia = qingjiaxiujiaService.selectView(new EntityWrapper<QingjiaxiujiaEntity>().eq("id", id));
        return R.ok().put("data", qingjiaxiujia);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增请假休假")
    public R save(@RequestBody QingjiaxiujiaEntity qingjiaxiujia, HttpServletRequest request){
    	qingjiaxiujia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qingjiaxiujia);
        qingjiaxiujiaService.insert(qingjiaxiujia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增请假休假")
    @RequestMapping("/add")
    public R add(@RequestBody QingjiaxiujiaEntity qingjiaxiujia, HttpServletRequest request){
    	qingjiaxiujia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qingjiaxiujia);
        qingjiaxiujiaService.insert(qingjiaxiujia);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改请假休假")
    public R update(@RequestBody QingjiaxiujiaEntity qingjiaxiujia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qingjiaxiujia);
        qingjiaxiujiaService.updateById(qingjiaxiujia);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除请假休假")
    public R delete(@RequestBody Long[] ids){
        qingjiaxiujiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
