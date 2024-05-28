package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ExamquestionDao;
import com.entity.ExamquestionEntity;
import com.service.ExamquestionService;
import com.entity.vo.ExamquestionVO;
import com.entity.view.ExamquestionView;

@Service("examquestionService")
public class ExamquestionServiceImpl extends ServiceImpl<ExamquestionDao, ExamquestionEntity> implements ExamquestionService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ExamquestionEntity> page = this.selectPage(
                new Query<ExamquestionEntity>(params).getPage(),
                new EntityWrapper<ExamquestionEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ExamquestionEntity> wrapper) {
		  Page<ExamquestionView> page =new Query<ExamquestionView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ExamquestionVO> selectListVO(Wrapper<ExamquestionEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ExamquestionVO selectVO(Wrapper<ExamquestionEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ExamquestionView> selectListView(Wrapper<ExamquestionEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ExamquestionView selectView(Wrapper<ExamquestionEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
