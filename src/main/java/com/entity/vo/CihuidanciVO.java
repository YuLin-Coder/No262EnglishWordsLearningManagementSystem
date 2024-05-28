package com.entity.vo;

import com.entity.CihuidanciEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 词汇单词
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-01-30 13:20:35
 */
public class CihuidanciVO  implements Serializable {
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
