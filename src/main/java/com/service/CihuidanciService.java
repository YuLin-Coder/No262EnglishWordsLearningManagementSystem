package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CihuidanciEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CihuidanciVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CihuidanciView;


/**
 * 词汇单词
 *
 * @author 
 * @email 
 * @date 2021-01-30 13:20:35
 */
public interface CihuidanciService extends IService<CihuidanciEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CihuidanciVO> selectListVO(Wrapper<CihuidanciEntity> wrapper);
   	
   	CihuidanciVO selectVO(@Param("ew") Wrapper<CihuidanciEntity> wrapper);
   	
   	List<CihuidanciView> selectListView(Wrapper<CihuidanciEntity> wrapper);
   	
   	CihuidanciView selectView(@Param("ew") Wrapper<CihuidanciEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CihuidanciEntity> wrapper);
   	
}

