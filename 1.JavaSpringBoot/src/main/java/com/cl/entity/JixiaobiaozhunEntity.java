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
 * 绩效标准
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
@TableName("jixiaobiaozhun")
public class JixiaobiaozhunEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JixiaobiaozhunEntity() {
		
	}
	
	public JixiaobiaozhunEntity(T t) {
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
	 * 标准名称
	 */
					
	private String biaozhunmingcheng;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 员工考勤
	 */
					
	private String yuangongkaoqin;
	
	/**
	 * 工作态度
	 */
					
	private String gongzuotaidu;
	
	/**
	 * 业务能力
	 */
					
	private String yewunengli;
	
	/**
	 * 工作绩效
	 */
					
	private String gongzuojixiao;
	
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
	 * 设置：标准名称
	 */
	public void setBiaozhunmingcheng(String biaozhunmingcheng) {
		this.biaozhunmingcheng = biaozhunmingcheng;
	}
	/**
	 * 获取：标准名称
	 */
	public String getBiaozhunmingcheng() {
		return biaozhunmingcheng;
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
	 * 设置：员工考勤
	 */
	public void setYuangongkaoqin(String yuangongkaoqin) {
		this.yuangongkaoqin = yuangongkaoqin;
	}
	/**
	 * 获取：员工考勤
	 */
	public String getYuangongkaoqin() {
		return yuangongkaoqin;
	}
	/**
	 * 设置：工作态度
	 */
	public void setGongzuotaidu(String gongzuotaidu) {
		this.gongzuotaidu = gongzuotaidu;
	}
	/**
	 * 获取：工作态度
	 */
	public String getGongzuotaidu() {
		return gongzuotaidu;
	}
	/**
	 * 设置：业务能力
	 */
	public void setYewunengli(String yewunengli) {
		this.yewunengli = yewunengli;
	}
	/**
	 * 获取：业务能力
	 */
	public String getYewunengli() {
		return yewunengli;
	}
	/**
	 * 设置：工作绩效
	 */
	public void setGongzuojixiao(String gongzuojixiao) {
		this.gongzuojixiao = gongzuojixiao;
	}
	/**
	 * 获取：工作绩效
	 */
	public String getGongzuojixiao() {
		return gongzuojixiao;
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
