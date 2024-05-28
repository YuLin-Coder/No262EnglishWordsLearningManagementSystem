package com.entity.view;

import com.entity.ExampaperEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 试卷表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-30 13:20:35
 */
@TableName("exampaper")
public class ExampaperView  extends ExampaperEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ExampaperView(){
	}
 
 	public ExampaperView(ExampaperEntity exampaperEntity){
 	try {
			BeanUtils.copyProperties(this, exampaperEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
