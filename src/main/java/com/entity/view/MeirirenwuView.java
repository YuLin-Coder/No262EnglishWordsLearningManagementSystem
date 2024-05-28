package com.entity.view;

import com.entity.MeirirenwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 每日任务
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-30 13:20:35
 */
@TableName("meirirenwu")
public class MeirirenwuView  extends MeirirenwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MeirirenwuView(){
	}
 
 	public MeirirenwuView(MeirirenwuEntity meirirenwuEntity){
 	try {
			BeanUtils.copyProperties(this, meirirenwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
