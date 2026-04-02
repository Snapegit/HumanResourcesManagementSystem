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
 * 培训信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
@TableName("peixunxinxi")
public class PeixunxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PeixunxinxiEntity() {
		
	}
	
	public PeixunxinxiEntity(T t) {
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
	 * 培训主题
	 */
					
	private String peixunzhuti;
	
	/**
	 * 培训时间
	 */
					
	private String peixunshijian;
	
	/**
	 * 培训地址
	 */
					
	private String peixundizhi;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 培训计划
	 */
					
	private String peixunjihua;
	
	/**
	 * 培训材料
	 */
					
	private String peixuncailiao;
	
	/**
	 * 培训内容
	 */
					
	private String peixunneirong;
	
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
	 * 设置：培训主题
	 */
	public void setPeixunzhuti(String peixunzhuti) {
		this.peixunzhuti = peixunzhuti;
	}
	/**
	 * 获取：培训主题
	 */
	public String getPeixunzhuti() {
		return peixunzhuti;
	}
	/**
	 * 设置：培训时间
	 */
	public void setPeixunshijian(String peixunshijian) {
		this.peixunshijian = peixunshijian;
	}
	/**
	 * 获取：培训时间
	 */
	public String getPeixunshijian() {
		return peixunshijian;
	}
	/**
	 * 设置：培训地址
	 */
	public void setPeixundizhi(String peixundizhi) {
		this.peixundizhi = peixundizhi;
	}
	/**
	 * 获取：培训地址
	 */
	public String getPeixundizhi() {
		return peixundizhi;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：培训计划
	 */
	public void setPeixunjihua(String peixunjihua) {
		this.peixunjihua = peixunjihua;
	}
	/**
	 * 获取：培训计划
	 */
	public String getPeixunjihua() {
		return peixunjihua;
	}
	/**
	 * 设置：培训材料
	 */
	public void setPeixuncailiao(String peixuncailiao) {
		this.peixuncailiao = peixuncailiao;
	}
	/**
	 * 获取：培训材料
	 */
	public String getPeixuncailiao() {
		return peixuncailiao;
	}
	/**
	 * 设置：培训内容
	 */
	public void setPeixunneirong(String peixunneirong) {
		this.peixunneirong = peixunneirong;
	}
	/**
	 * 获取：培训内容
	 */
	public String getPeixunneirong() {
		return peixunneirong;
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
