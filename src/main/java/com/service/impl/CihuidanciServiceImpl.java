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


import com.dao.CihuidanciDao;
import com.entity.CihuidanciEntity;
import com.service.CihuidanciService;
import com.entity.vo.CihuidanciVO;
import com.entity.view.CihuidanciView;

@Service("cihuidanciService")
public class CihuidanciServiceImpl extends ServiceImpl<CihuidanciDao, CihuidanciEntity> implements CihuidanciService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CihuidanciEntity> page = this.selectPage(
                new Query<CihuidanciEntity>(params).getPage(),
                new EntityWrapper<CihuidanciEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CihuidanciEntity> wrapper) {
		  Page<CihuidanciView> page =new Query<CihuidanciView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CihuidanciVO> selectListVO(Wrapper<CihuidanciEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CihuidanciVO selectVO(Wrapper<CihuidanciEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CihuidanciView> selectListView(Wrapper<CihuidanciEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CihuidanciView selectView(Wrapper<CihuidanciEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
