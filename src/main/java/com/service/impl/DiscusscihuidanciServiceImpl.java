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


import com.dao.DiscusscihuidanciDao;
import com.entity.DiscusscihuidanciEntity;
import com.service.DiscusscihuidanciService;
import com.entity.vo.DiscusscihuidanciVO;
import com.entity.view.DiscusscihuidanciView;

@Service("discusscihuidanciService")
public class DiscusscihuidanciServiceImpl extends ServiceImpl<DiscusscihuidanciDao, DiscusscihuidanciEntity> implements DiscusscihuidanciService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusscihuidanciEntity> page = this.selectPage(
                new Query<DiscusscihuidanciEntity>(params).getPage(),
                new EntityWrapper<DiscusscihuidanciEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusscihuidanciEntity> wrapper) {
		  Page<DiscusscihuidanciView> page =new Query<DiscusscihuidanciView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusscihuidanciVO> selectListVO(Wrapper<DiscusscihuidanciEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusscihuidanciVO selectVO(Wrapper<DiscusscihuidanciEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusscihuidanciView> selectListView(Wrapper<DiscusscihuidanciEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusscihuidanciView selectView(Wrapper<DiscusscihuidanciEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
