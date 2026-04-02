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

import com.cl.entity.YuangongEntity;
import com.cl.entity.view.YuangongView;

import com.cl.service.YuangongService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 员工
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
@RestController
@RequestMapping("/yuangong")
public class YuangongController {
    @Autowired
    private YuangongService yuangongService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		YuangongEntity u = yuangongService.selectOne(new EntityWrapper<YuangongEntity>().eq("yuangonggonghao", username));
        if(u==null || !u.getYuangongmima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"yuangong",  "员工" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody YuangongEntity yuangong){
    	//ValidatorUtils.validateEntity(yuangong);
    	YuangongEntity u = yuangongService.selectOne(new EntityWrapper<YuangongEntity>().eq("yuangonggonghao", yuangong.getYuangonggonghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		yuangong.setId(uId);
        yuangongService.insert(yuangong);
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
        YuangongEntity u = yuangongService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	YuangongEntity u = yuangongService.selectOne(new EntityWrapper<YuangongEntity>().eq("yuangonggonghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setYuangongmima("123456");
        yuangongService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuangongEntity yuangong,
		HttpServletRequest request){
        EntityWrapper<YuangongEntity> ew = new EntityWrapper<YuangongEntity>();

		PageUtils page = yuangongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuangongEntity yuangong, 
		HttpServletRequest request){
        EntityWrapper<YuangongEntity> ew = new EntityWrapper<YuangongEntity>();

		PageUtils page = yuangongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuangongEntity yuangong){
       	EntityWrapper<YuangongEntity> ew = new EntityWrapper<YuangongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuangong, "yuangong")); 
        return R.ok().put("data", yuangongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuangongEntity yuangong){
        EntityWrapper< YuangongEntity> ew = new EntityWrapper< YuangongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuangong, "yuangong")); 
		YuangongView yuangongView =  yuangongService.selectView(ew);
		return R.ok("查询员工成功").put("data", yuangongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuangongEntity yuangong = yuangongService.selectById(id);
		yuangong = yuangongService.selectView(new EntityWrapper<YuangongEntity>().eq("id", id));
        return R.ok().put("data", yuangong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuangongEntity yuangong = yuangongService.selectById(id);
		yuangong = yuangongService.selectView(new EntityWrapper<YuangongEntity>().eq("id", id));
        return R.ok().put("data", yuangong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增员工")
    public R save(@RequestBody YuangongEntity yuangong, HttpServletRequest request){
    	yuangong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuangong);
    	YuangongEntity u = yuangongService.selectOne(new EntityWrapper<YuangongEntity>().eq("yuangonggonghao", yuangong.getYuangonggonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		yuangong.setId(new Date().getTime());
        yuangongService.insert(yuangong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增员工")
    @RequestMapping("/add")
    public R add(@RequestBody YuangongEntity yuangong, HttpServletRequest request){
    	yuangong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuangong);
    	YuangongEntity u = yuangongService.selectOne(new EntityWrapper<YuangongEntity>().eq("yuangonggonghao", yuangong.getYuangonggonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		yuangong.setId(new Date().getTime());
        yuangongService.insert(yuangong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改员工")
    public R update(@RequestBody YuangongEntity yuangong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuangong);
        yuangongService.updateById(yuangong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除员工")
    public R delete(@RequestBody Long[] ids){
        yuangongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	




    @RequestMapping("/importExcel")
    @SysLog("导入员工")
    public R importExcel(@RequestParam("file") MultipartFile file){
        try {
            //获取输入流
            InputStream inputStream = file.getInputStream();
            //创建读取工作簿
            Workbook workbook = WorkbookFactory.create(inputStream);
            //获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获取总行
            int rows=sheet.getPhysicalNumberOfRows();
            if(rows>1){
                //获取单元格
                for (int i = 1; i < rows; i++) {
                    Row row = sheet.getRow(i);
                    YuangongEntity yuangongEntity =new YuangongEntity();
                    yuangongEntity.setId(new Date().getTime());
                    String yuangonggonghao = CommonUtil.getCellValue(row.getCell(0));
                    yuangongEntity.setYuangonggonghao(yuangonggonghao);
                    String yuangongmima = CommonUtil.getCellValue(row.getCell(1));
                    yuangongEntity.setYuangongmima(yuangongmima);
                    String yuangongxingming = CommonUtil.getCellValue(row.getCell(2));
                    yuangongEntity.setYuangongxingming(yuangongxingming);
                    String xingbie = CommonUtil.getCellValue(row.getCell(3));
                    yuangongEntity.setXingbie(xingbie);
                    String lianxidianhua = CommonUtil.getCellValue(row.getCell(4));
                    yuangongEntity.setLianxidianhua(lianxidianhua);
                    String shenfenzhenghao = CommonUtil.getCellValue(row.getCell(5));
                    yuangongEntity.setShenfenzhenghao(shenfenzhenghao);
                     
                    //想数据库中添加新对象
                    yuangongService.insert(yuangongEntity);//方法
                }
            }
            inputStream.close();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("导入成功");
    }




}
