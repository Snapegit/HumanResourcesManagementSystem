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

import com.cl.entity.RenshizhuanyuanEntity;
import com.cl.entity.view.RenshizhuanyuanView;

import com.cl.service.RenshizhuanyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 人事专员
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
@RestController
@RequestMapping("/renshizhuanyuan")
public class RenshizhuanyuanController {
    @Autowired
    private RenshizhuanyuanService renshizhuanyuanService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		RenshizhuanyuanEntity u = renshizhuanyuanService.selectOne(new EntityWrapper<RenshizhuanyuanEntity>().eq("zhuanyuanzhanghao", username));
        if(u==null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
        if(!"是".equals(u.getSfsh())) return R.error("账号已锁定，请联系管理员审核。");
		String token = tokenService.generateToken(u.getId(), username,"renshizhuanyuan",  "管理员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody RenshizhuanyuanEntity renshizhuanyuan){
    	//ValidatorUtils.validateEntity(renshizhuanyuan);
    	RenshizhuanyuanEntity u = renshizhuanyuanService.selectOne(new EntityWrapper<RenshizhuanyuanEntity>().eq("zhuanyuanzhanghao", renshizhuanyuan.getZhuanyuanzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		renshizhuanyuan.setId(uId);
        renshizhuanyuanService.insert(renshizhuanyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        RenshizhuanyuanEntity u = renshizhuanyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	RenshizhuanyuanEntity u = renshizhuanyuanService.selectOne(new EntityWrapper<RenshizhuanyuanEntity>().eq("zhuanyuanzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        renshizhuanyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RenshizhuanyuanEntity renshizhuanyuan,
		HttpServletRequest request){
        EntityWrapper<RenshizhuanyuanEntity> ew = new EntityWrapper<RenshizhuanyuanEntity>();

		PageUtils page = renshizhuanyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renshizhuanyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RenshizhuanyuanEntity renshizhuanyuan, 
		HttpServletRequest request){
        EntityWrapper<RenshizhuanyuanEntity> ew = new EntityWrapper<RenshizhuanyuanEntity>();

		PageUtils page = renshizhuanyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renshizhuanyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RenshizhuanyuanEntity renshizhuanyuan){
       	EntityWrapper<RenshizhuanyuanEntity> ew = new EntityWrapper<RenshizhuanyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( renshizhuanyuan, "renshizhuanyuan")); 
        return R.ok().put("data", renshizhuanyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RenshizhuanyuanEntity renshizhuanyuan){
        EntityWrapper< RenshizhuanyuanEntity> ew = new EntityWrapper< RenshizhuanyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( renshizhuanyuan, "renshizhuanyuan")); 
		RenshizhuanyuanView renshizhuanyuanView =  renshizhuanyuanService.selectView(ew);
		return R.ok("查询人事专员成功").put("data", renshizhuanyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RenshizhuanyuanEntity renshizhuanyuan = renshizhuanyuanService.selectById(id);
		renshizhuanyuan = renshizhuanyuanService.selectView(new EntityWrapper<RenshizhuanyuanEntity>().eq("id", id));
        return R.ok().put("data", renshizhuanyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RenshizhuanyuanEntity renshizhuanyuan = renshizhuanyuanService.selectById(id);
		renshizhuanyuan = renshizhuanyuanService.selectView(new EntityWrapper<RenshizhuanyuanEntity>().eq("id", id));
        return R.ok().put("data", renshizhuanyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增人事专员")
    public R save(@RequestBody RenshizhuanyuanEntity renshizhuanyuan, HttpServletRequest request){
    	renshizhuanyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(renshizhuanyuan);
    	RenshizhuanyuanEntity u = renshizhuanyuanService.selectOne(new EntityWrapper<RenshizhuanyuanEntity>().eq("zhuanyuanzhanghao", renshizhuanyuan.getZhuanyuanzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		renshizhuanyuan.setId(new Date().getTime());
        renshizhuanyuanService.insert(renshizhuanyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增人事专员")
    @RequestMapping("/add")
    public R add(@RequestBody RenshizhuanyuanEntity renshizhuanyuan, HttpServletRequest request){
    	renshizhuanyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(renshizhuanyuan);
    	RenshizhuanyuanEntity u = renshizhuanyuanService.selectOne(new EntityWrapper<RenshizhuanyuanEntity>().eq("zhuanyuanzhanghao", renshizhuanyuan.getZhuanyuanzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		renshizhuanyuan.setId(new Date().getTime());
        renshizhuanyuanService.insert(renshizhuanyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改人事专员")
    public R update(@RequestBody RenshizhuanyuanEntity renshizhuanyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(renshizhuanyuan);
        renshizhuanyuanService.updateById(renshizhuanyuan);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核人事专员")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<RenshizhuanyuanEntity> list = new ArrayList<RenshizhuanyuanEntity>();
        for(Long id : ids) {
            RenshizhuanyuanEntity renshizhuanyuan = renshizhuanyuanService.selectById(id);
            renshizhuanyuan.setSfsh(sfsh);
            renshizhuanyuan.setShhf(shhf);
            list.add(renshizhuanyuan);
        }
        renshizhuanyuanService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除人事专员")
    public R delete(@RequestBody Long[] ids){
        renshizhuanyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
