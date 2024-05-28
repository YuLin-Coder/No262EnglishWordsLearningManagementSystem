package com.entity.model;

import com.entity.ExampaperEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 试卷表
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-01-30 13:20:35
 */
public class ExampaperModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 考试时长(分钟)
	 */
	
	private Integer time;
		
	/**
	 * 试卷状态
	 */
	
	private Integer status;
				
	
	/**
	 * 设置：考试时长(分钟)
	 */
	 
	public void setTime(Integer time) {
		this.time = time;
	}
	
	/**
	 * 获取：考试时长(分钟)
	 */
	public Integer getTime() {
		return time;
	}
				
	
	/**
	 * 设置：试卷状态
	 */
	 
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/**
	 * 获取：试卷状态
	 */
	public Integer getStatus() {
		return status;
	}
			
}
