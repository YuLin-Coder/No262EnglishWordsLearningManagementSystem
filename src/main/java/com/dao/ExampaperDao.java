package com.dao;

import com.entity.ExampaperEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ExampaperVO;
import com.entity.view.ExampaperView;


/**
 * 试卷表
 * 
 * @author 
 * @email 
 * @date 2021-01-30 13:20:35
 */
public interface ExampaperDao extends BaseMapper<ExampaperEntity> {
	
	List<ExampaperVO> selectListVO(@Param("ew") Wrapper<ExampaperEntity> wrapper);
	
	ExampaperVO selectVO(@Param("ew") Wrapper<ExampaperEntity> wrapper);
	
	List<ExampaperView> selectListView(@Param("ew") Wrapper<ExampaperEntity> wrapper);

	List<ExampaperView> selectListView(Pagination page,@Param("ew") Wrapper<ExampaperEntity> wrapper);
	
	ExampaperView selectView(@Param("ew") Wrapper<ExampaperEntity> wrapper);
	
}
