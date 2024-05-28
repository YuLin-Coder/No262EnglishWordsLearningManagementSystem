package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusscihuidanciEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusscihuidanciVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusscihuidanciView;


/**
 * 词汇单词评论表
 *
 * @author 
 * @email 
 * @date 2021-01-30 13:20:35
 */
public interface DiscusscihuidanciService extends IService<DiscusscihuidanciEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusscihuidanciVO> selectListVO(Wrapper<DiscusscihuidanciEntity> wrapper);
   	
   	DiscusscihuidanciVO selectVO(@Param("ew") Wrapper<DiscusscihuidanciEntity> wrapper);
   	
   	List<DiscusscihuidanciView> selectListView(Wrapper<DiscusscihuidanciEntity> wrapper);
   	
   	DiscusscihuidanciView selectView(@Param("ew") Wrapper<DiscusscihuidanciEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusscihuidanciEntity> wrapper);
   	
}

