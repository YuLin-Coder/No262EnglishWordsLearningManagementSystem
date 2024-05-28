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


import com.dao.ExampaperDao;
import com.entity.ExampaperEntity;
import com.service.ExampaperService;
import com.entity.vo.ExampaperVO;
import com.entity.view.ExampaperView;

@Service("exampaperService")
public class ExampaperServiceImpl extends ServiceImpl<ExampaperDao, ExampaperEntity> implements ExampaperService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ExampaperEntity> page = this.selectPage(
                new Query<ExampaperEntity>(params).getPage(),
                new EntityWrapper<ExampaperEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ExampaperEntity> wrapper) {
		  Page<ExampaperView> page =new Query<ExampaperView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ExampaperVO> selectListVO(Wrapper<ExampaperEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ExampaperVO selectVO(Wrapper<ExampaperEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ExampaperView> selectListView(Wrapper<ExampaperEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ExampaperView selectView(Wrapper<ExampaperEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
