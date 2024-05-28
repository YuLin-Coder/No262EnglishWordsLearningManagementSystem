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


import com.dao.MeirirenwuDao;
import com.entity.MeirirenwuEntity;
import com.service.MeirirenwuService;
import com.entity.vo.MeirirenwuVO;
import com.entity.view.MeirirenwuView;

@Service("meirirenwuService")
public class MeirirenwuServiceImpl extends ServiceImpl<MeirirenwuDao, MeirirenwuEntity> implements MeirirenwuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MeirirenwuEntity> page = this.selectPage(
                new Query<MeirirenwuEntity>(params).getPage(),
                new EntityWrapper<MeirirenwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MeirirenwuEntity> wrapper) {
		  Page<MeirirenwuView> page =new Query<MeirirenwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<MeirirenwuVO> selectListVO(Wrapper<MeirirenwuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MeirirenwuVO selectVO(Wrapper<MeirirenwuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MeirirenwuView> selectListView(Wrapper<MeirirenwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MeirirenwuView selectView(Wrapper<MeirirenwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
