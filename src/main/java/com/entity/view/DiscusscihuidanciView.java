package com.entity.view;

import com.entity.DiscusscihuidanciEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 词汇单词评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-30 13:20:35
 */
@TableName("discusscihuidanci")
public class DiscusscihuidanciView  extends DiscusscihuidanciEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusscihuidanciView(){
	}
 
 	public DiscusscihuidanciView(DiscusscihuidanciEntity discusscihuidanciEntity){
 	try {
			BeanUtils.copyProperties(this, discusscihuidanciEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
