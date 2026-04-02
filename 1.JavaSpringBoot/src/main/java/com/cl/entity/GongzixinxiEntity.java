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
 * 工资信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
@TableName("gongzixinxi")
public class GongzixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GongzixinxiEntity() {
		
	}
	
	public GongzixinxiEntity(T t) {
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
	 * 年月份
	 */
					
	private String nianyuefen;
	
	/**
	 * 员工工号
	 */
					
	private String yuangonggonghao;
	
	/**
	 * 员工姓名
	 */
					
	private String yuangongxingming;
	
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
	 * 实发工资
	 */
					
	private Double shifagongzi;
	
	/**
	 * 工资备注
	 */
					
	private String gongzibeizhu;
	
	
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
	 * 设置：年月份
	 */
	public void setNianyuefen(String nianyuefen) {
		this.nianyuefen = nianyuefen;
	}
	/**
	 * 获取：年月份
	 */
	public String getNianyuefen() {
		return nianyuefen;
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
	 * 设置：实发工资
	 */
	public void setShifagongzi(Double shifagongzi) {
		this.shifagongzi = shifagongzi;
	}
	/**
	 * 获取：实发工资
	 */
	public Double getShifagongzi() {
		return shifagongzi;
	}
	/**
	 * 设置：工资备注
	 */
	public void setGongzibeizhu(String gongzibeizhu) {
		this.gongzibeizhu = gongzibeizhu;
	}
	/**
	 * 获取：工资备注
	 */
	public String getGongzibeizhu() {
		return gongzibeizhu;
	}

}
