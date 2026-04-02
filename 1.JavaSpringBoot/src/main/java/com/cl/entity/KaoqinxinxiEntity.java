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
 * 考勤信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-02-06 22:04:01
 */
@TableName("kaoqinxinxi")
public class KaoqinxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KaoqinxinxiEntity() {
		
	}
	
	public KaoqinxinxiEntity(T t) {
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
	 * 出勤天数
	 */
					
	private Integer chuqintianshu;
	
	/**
	 * 请假天数
	 */
					
	private Integer qingjiatianshu;
	
	/**
	 * 迟到天数
	 */
					
	private Integer chidaotianshu;
	
	/**
	 * 早退次数
	 */
					
	private Integer zaotuicishu;
	
	/**
	 * 缺勤天数
	 */
					
	private Integer queqintianshu;
	
	/**
	 * 统计时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date tongjishijian;
	
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
	 * 设置：出勤天数
	 */
	public void setChuqintianshu(Integer chuqintianshu) {
		this.chuqintianshu = chuqintianshu;
	}
	/**
	 * 获取：出勤天数
	 */
	public Integer getChuqintianshu() {
		return chuqintianshu;
	}
	/**
	 * 设置：请假天数
	 */
	public void setQingjiatianshu(Integer qingjiatianshu) {
		this.qingjiatianshu = qingjiatianshu;
	}
	/**
	 * 获取：请假天数
	 */
	public Integer getQingjiatianshu() {
		return qingjiatianshu;
	}
	/**
	 * 设置：迟到天数
	 */
	public void setChidaotianshu(Integer chidaotianshu) {
		this.chidaotianshu = chidaotianshu;
	}
	/**
	 * 获取：迟到天数
	 */
	public Integer getChidaotianshu() {
		return chidaotianshu;
	}
	/**
	 * 设置：早退次数
	 */
	public void setZaotuicishu(Integer zaotuicishu) {
		this.zaotuicishu = zaotuicishu;
	}
	/**
	 * 获取：早退次数
	 */
	public Integer getZaotuicishu() {
		return zaotuicishu;
	}
	/**
	 * 设置：缺勤天数
	 */
	public void setQueqintianshu(Integer queqintianshu) {
		this.queqintianshu = queqintianshu;
	}
	/**
	 * 获取：缺勤天数
	 */
	public Integer getQueqintianshu() {
		return queqintianshu;
	}
	/**
	 * 设置：统计时间
	 */
	public void setTongjishijian(Date tongjishijian) {
		this.tongjishijian = tongjishijian;
	}
	/**
	 * 获取：统计时间
	 */
	public Date getTongjishijian() {
		return tongjishijian;
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
