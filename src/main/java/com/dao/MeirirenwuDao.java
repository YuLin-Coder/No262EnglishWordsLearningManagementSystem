package com.dao;

import com.entity.MeirirenwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MeirirenwuVO;
import com.entity.view.MeirirenwuView;


/**
 * 每日任务
 * 
 * @author 
 * @email 
 * @date 2021-01-30 13:20:35
 */
public interface MeirirenwuDao extends BaseMapper<MeirirenwuEntity> {
	
	List<MeirirenwuVO> selectListVO(@Param("ew") Wrapper<MeirirenwuEntity> wrapper);
	
	MeirirenwuVO selectVO(@Param("ew") Wrapper<MeirirenwuEntity> wrapper);
	
	List<MeirirenwuView> selectListView(@Param("ew") Wrapper<MeirirenwuEntity> wrapper);

	List<MeirirenwuView> selectListView(Pagination page,@Param("ew") Wrapper<MeirirenwuEntity> wrapper);
	
	MeirirenwuView selectView(@Param("ew") Wrapper<MeirirenwuEntity> wrapper);
	
}
