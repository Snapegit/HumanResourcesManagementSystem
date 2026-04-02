package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 岗位调换
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
@TableName("gangweidiaohuan")
public class GangweidiaohuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GangweidiaohuanEntity() {
		
	}
	
	public GangweidiaohuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 员工工号
	 */
					
	private String yuangonggonghao;
	
	/**
	 * 员工姓名
	 */
					
	private String yuangongxingming;
	
	/**
	 * 原职位
	 */
					
	private String zhiwei;
	
	/**
	 * 调换职位
	 */
					
	private String diaohuanzhiwei;
	
	/**
	 * 申请时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date shenqingshijian;
	
	/**
	 * 申请原因
	 */
					
	private String shenqingyuanyin;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
	/**
	 * 专员账号
	 */
					
	private String zhuanyuanzhanghao;
	
	/**
	 * 专员名称
	 */
					
	private String zhuanyuanmingcheng;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：员工工号
	 */
	public void setYuangonggonghao(String yuangonggonghao) {
		this.yuangonggonghao = yuangonggonghao;
	}
	/**
	 * 获取：员工工号
	 */
	public String getYuangonggonghao() {
		return yuangonggonghao;
	}
	/**
	 * 设置：员工姓名
	 */
	public void setYuangongxingming(String yuangongxingming) {
		this.yuangongxingming = yuangongxingming;
	}
	/**
	 * 获取：员工姓名
	 */
	public String getYuangongxingming() {
		return yuangongxingming;
	}
	/**
	 * 设置：原职位
	 */
	public void setZhiwei(String zhiwei) {
		this.zhiwei = zhiwei;
	}
	/**
	 * 获取：原职位
	 */
	public String getZhiwei() {
		return zhiwei;
	}
	/**
	 * 设置：调换职位
	 */
	public void setDiaohuanzhiwei(String diaohuanzhiwei) {
		this.diaohuanzhiwei = diaohuanzhiwei;
	}
	/**
	 * 获取：调换职位
	 */
	public String getDiaohuanzhiwei() {
		return diaohuanzhiwei;
	}
	/**
	 * 设置：申请时间
	 */
	public void setShenqingshijian(Date shenqingshijian) {
		this.shenqingshijian = shenqingshijian;
	}
	/**
	 * 获取：申请时间
	 */
	public Date getShenqingshijian() {
		return shenqingshijian;
	}
	/**
	 * 设置：申请原因
	 */
	public void setShenqingyuanyin(String shenqingyuanyin) {
		this.shenqingyuanyin = shenqingyuanyin;
	}
	/**
	 * 获取：申请原因
	 */
	public String getShenqingyuanyin() {
		return shenqingyuanyin;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}
	/**
	 * 设置：专员账号
	 */
	public void setZhuanyuanzhanghao(String zhuanyuanzhanghao) {
		this.zhuanyuanzhanghao = zhuanyuanzhanghao;
	}
	/**
	 * 获取：专员账号
	 */
	public String getZhuanyuanzhanghao() {
		return zhuanyuanzhanghao;
	}
	/**
	 * 设置：专员名称
	 */
	public void setZhuanyuanmingcheng(String zhuanyuanmingcheng) {
		this.zhuanyuanmingcheng = zhuanyuanmingcheng;
	}
	/**
	 * 获取：专员名称
	 */
	public String getZhuanyuanmingcheng() {
		return zhuanyuanmingcheng;
	}

}
