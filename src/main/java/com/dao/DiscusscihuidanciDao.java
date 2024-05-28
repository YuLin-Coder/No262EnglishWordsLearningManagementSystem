package com.dao;

import com.entity.DiscusscihuidanciEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusscihuidanciVO;
import com.entity.view.DiscusscihuidanciView;


/**
 * 词汇单词评论表
 * 
 * @author 
 * @email 
 * @date 2021-01-30 13:20:35
 */
public interface DiscusscihuidanciDao extends BaseMapper<DiscusscihuidanciEntity> {
	
	List<DiscusscihuidanciVO> selectListVO(@Param("ew") Wrapper<DiscusscihuidanciEntity> wrapper);
	
	DiscusscihuidanciVO selectVO(@Param("ew") Wrapper<DiscusscihuidanciEntity> wrapper);
	
	List<DiscusscihuidanciView> selectListView(@Param("ew") Wrapper<DiscusscihuidanciEntity> wrapper);

	List<DiscusscihuidanciView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusscihuidanciEntity> wrapper);
	
	DiscusscihuidanciView selectView(@Param("ew") Wrapper<DiscusscihuidanciEntity> wrapper);
	
}
