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
 * 培训评价
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
@TableName("peixunpingjia")
public class PeixunpingjiaEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PeixunpingjiaEntity() {
		
	}
	
	public PeixunpingjiaEntity(T t) {
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
	 * 培训评价
	 */
					
	private String peixunpingjia;
	
	/**
	 * 员工工号
	 */
					
	private String yuangonggonghao;
	
	/**
	 * 员工姓名
	 */
					
	private String yuangongxingming;
	
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
	 * 设置：培训评价
	 */
	public void setPeixunpingjia(String peixunpingjia) {
		this.peixunpingjia = peixunpingjia;
	}
	/**
	 * 获取：培训评价
	 */
	public String getPeixunpingjia() {
		return peixunpingjia;
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
