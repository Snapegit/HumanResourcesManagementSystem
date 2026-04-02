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
 * 薪酬标准
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
@TableName("xinchoubiaozhun")
public class XinchoubiaozhunEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XinchoubiaozhunEntity() {
		
	}
	
	public XinchoubiaozhunEntity(T t) {
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
	 * 标题
	 */
					
	private String biaoti;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 底薪
	 */
					
	private Double dixin;
	
	/**
	 * 绩效
	 */
					
	private Double jixiao;
	
	/**
	 * 奖金
	 */
					
	private Double jiangjin;
	
	/**
	 * 全勤奖
	 */
					
	private Double quanqinjiang;
	
	/**
	 * 五险一金
	 */
					
	private Double wuxianyijin;
	
	/**
	 * 扣款
	 */
					
	private Double koukuan;
	
	/**
	 * 备注
	 */
					
	private String beizhu;
	
	
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
	 * 设置：标题
	 */
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	/**
	 * 获取：标题
	 */
	public String getBiaoti() {
		return biaoti;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：底薪
	 */
	public void setDixin(Double dixin) {
		this.dixin = dixin;
	}
	/**
	 * 获取：底薪
	 */
	public Double getDixin() {
		return dixin;
	}
	/**
	 * 设置：绩效
	 */
	public void setJixiao(Double jixiao) {
		this.jixiao = jixiao;
	}
	/**
	 * 获取：绩效
	 */
	public Double getJixiao() {
		return jixiao;
	}
	/**
	 * 设置：奖金
	 */
	public void setJiangjin(Double jiangjin) {
		this.jiangjin = jiangjin;
	}
	/**
	 * 获取：奖金
	 */
	public Double getJiangjin() {
		return jiangjin;
	}
	/**
	 * 设置：全勤奖
	 */
	public void setQuanqinjiang(Double quanqinjiang) {
		this.quanqinjiang = quanqinjiang;
	}
	/**
	 * 获取：全勤奖
	 */
	public Double getQuanqinjiang() {
		return quanqinjiang;
	}
	/**
	 * 设置：五险一金
	 */
	public void setWuxianyijin(Double wuxianyijin) {
		this.wuxianyijin = wuxianyijin;
	}
	/**
	 * 获取：五险一金
	 */
	public Double getWuxianyijin() {
		return wuxianyijin;
	}
	/**
	 * 设置：扣款
	 */
	public void setKoukuan(Double koukuan) {
		this.koukuan = koukuan;
	}
	/**
	 * 获取：扣款
	 */
	public Double getKoukuan() {
		return koukuan;
	}
	/**
	 * 设置：备注
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}

}
