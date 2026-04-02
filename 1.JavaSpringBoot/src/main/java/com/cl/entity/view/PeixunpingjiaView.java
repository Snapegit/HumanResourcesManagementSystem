package com.cl.entity.view;

import com.cl.entity.PeixunpingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 培训评价
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-02-06 22:04:00
 */
@TableName("peixunpingjia")
public class PeixunpingjiaView  extends PeixunpingjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PeixunpingjiaView(){
	}
 
 	public PeixunpingjiaView(PeixunpingjiaEntity peixunpingjiaEntity){
 	try {
			BeanUtils.copyProperties(this, peixunpingjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
