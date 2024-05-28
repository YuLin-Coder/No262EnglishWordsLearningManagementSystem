package com.entity.vo;

import com.entity.ExamquestionEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 试题表
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-01-30 13:20:35
 */
public class ExamquestionVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 试卷名称
	 */
	
	private String papername;
		
	/**
	 * 试题名称
	 */
	
	private String questionname;
		
	/**
	 * 选项，json字符串
	 */
	
	private String options;
		
	/**
	 * 分值
	 */
	
	private Long score;
		
	/**
	 * 正确答案
	 */
	
	private String answer;
		
	/**
	 * 答案解析
	 */
	
	private String analysis;
		
	/**
	 * 试题类型，0：单选题 1：多选题 2：判断题 3：填空题（暂不考虑多项填空）
	 */
	
	private Long type;
		
	/**
	 * 试题排序，值越大排越前面
	 */
	
	private Long sequence;
				
	
	/**
	 * 设置：试卷名称
	 */
	 
	public void setPapername(String papername) {
		this.papername = papername;
	}
	
	/**
	 * 获取：试卷名称
	 */
	public String getPapername() {
		return papername;
	}
				
	
	/**
	 * 设置：试题名称
	 */
	 
	public void setQuestionname(String questionname) {
		this.questionname = questionname;
	}
	
	/**
	 * 获取：试题名称
	 */
	public String getQuestionname() {
		return questionname;
	}
				
	
	/**
	 * 设置：选项，json字符串
	 */
	 
	public void setOptions(String options) {
		this.options = options;
	}
	
	/**
	 * 获取：选项，json字符串
	 */
	public String getOptions() {
		return options;
	}
				
	
	/**
	 * 设置：分值
	 */
	 
	public void setScore(Long score) {
		this.score = score;
	}
	
	/**
	 * 获取：分值
	 */
	public Long getScore() {
		return score;
	}
				
	
	/**
	 * 设置：正确答案
	 */
	 
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	/**
	 * 获取：正确答案
	 */
	public String getAnswer() {
		return answer;
	}
				
	
	/**
	 * 设置：答案解析
	 */
	 
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	
	/**
	 * 获取：答案解析
	 */
	public String getAnalysis() {
		return analysis;
	}
				
	
	/**
	 * 设置：试题类型，0：单选题 1：多选题 2：判断题 3：填空题（暂不考虑多项填空）
	 */
	 
	public void setType(Long type) {
		this.type = type;
	}
	
	/**
	 * 获取：试题类型，0：单选题 1：多选题 2：判断题 3：填空题（暂不考虑多项填空）
	 */
	public Long getType() {
		return type;
	}
				
	
	/**
	 * 设置：试题排序，值越大排越前面
	 */
	 
	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}
	
	/**
	 * 获取：试题排序，值越大排越前面
	 */
	public Long getSequence() {
		return sequence;
	}
			
}
