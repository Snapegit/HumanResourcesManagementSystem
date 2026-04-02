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
 * 绩效考核
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
@TableName("jixiaokaohe")
public class JixiaokaoheEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JixiaokaoheEntity() {
		
	}
	
	public JixiaokaoheEntity(T t) {
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
	 * 部门
	 */
					
	private String bumen;
	
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
	 * 评价等级
	 */
					
	private String pingjiadengji;
	
	/**
	 * 备注
	 */
					
	private String beizhu;
	
	/**
	 * 考核时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date kaoheshijian;
	
	/**
	 * 专员账号
	 */
					
	private String zhuanyuanzhanghao;
	
	
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
	 * 设置：部门
	 */
	public void setBumen(String bumen) {
		this.bumen = bumen;
	}
	/**
	 * 获取：部门
	 */
	public String getBumen() {
		return bumen;
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
	 * 设置：评价等级
	 */
	public void setPingjiadengji(String pingjiadengji) {
		this.pingjiadengji = pingjiadengji;
	}
	/**
	 * 获取：评价等级
	 */
	public String getPingjiadengji() {
		return pingjiadengji;
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
	/**
	 * 设置：考核时间
	 */
	public void setKaoheshijian(Date kaoheshijian) {
		this.kaoheshijian = kaoheshijian;
	}
	/**
	 * 获取：考核时间
	 */
	public Date getKaoheshijian() {
		return kaoheshijian;
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

}
