package com.cl.entity.view;

import com.cl.entity.PeixunxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 培训信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
@TableName("peixunxinxi")
public class PeixunxinxiView  extends PeixunxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PeixunxinxiView(){
	}
 
 	public PeixunxinxiView(PeixunxinxiEntity peixunxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, peixunxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
