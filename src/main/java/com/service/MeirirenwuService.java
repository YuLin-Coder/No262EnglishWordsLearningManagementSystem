package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MeirirenwuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MeirirenwuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MeirirenwuView;


/**
 * 每日任务
 *
 * @author 
 * @email 
 * @date 2021-01-30 13:20:35
 */
public interface MeirirenwuService extends IService<MeirirenwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MeirirenwuVO> selectListVO(Wrapper<MeirirenwuEntity> wrapper);
   	
   	MeirirenwuVO selectVO(@Param("ew") Wrapper<MeirirenwuEntity> wrapper);
   	
   	List<MeirirenwuView> selectListView(Wrapper<MeirirenwuEntity> wrapper);
   	
   	MeirirenwuView selectView(@Param("ew") Wrapper<MeirirenwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MeirirenwuEntity> wrapper);
   	
}

