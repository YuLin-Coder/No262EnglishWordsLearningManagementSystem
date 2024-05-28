package com.entity.model;

import com.entity.CihuidanciEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 词汇单词
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-01-30 13:20:35
 */
public class CihuidanciModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 释义
	 */
	
	private String shiyi;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 例句
	 */
	
	private String liju;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
				
	
	/**
	 * 设置：释义
	 */
	 
	public void setShiyi(String shiyi) {
		this.shiyi = shiyi;
	}
	
	/**
	 * 获取：释义
	 */
	public String getShiyi() {
		return shiyi;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：例句
	 */
	 
	public void setLiju(String liju) {
		this.liju = liju;
	}
	
	/**
	 * 获取：例句
	 */
	public String getLiju() {
		return liju;
	}
				
	
	/**
	 * 设置：赞
	 */
	 
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
			
}
