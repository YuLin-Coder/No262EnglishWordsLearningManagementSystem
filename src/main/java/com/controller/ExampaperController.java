package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ExampaperEntity;
import com.entity.view.ExampaperView;

import com.service.ExampaperService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 试卷表
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-30 13:20:35
 */
@RestController
@RequestMapping("/exampaper")
public class ExampaperController {
    @Autowired
    private ExampaperService exampaperService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ExampaperEntity exampaper, HttpServletRequest request){

        EntityWrapper<ExampaperEntity> ew = new EntityWrapper<ExampaperEntity>();
		PageUtils page = exampaperService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, exampaper), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ExampaperEntity exampaper, HttpServletRequest request){
        EntityWrapper<ExampaperEntity> ew = new EntityWrapper<ExampaperEntity>();
		PageUtils page = exampaperService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, exampaper), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ExampaperEntity exampaper){
       	EntityWrapper<ExampaperEntity> ew = new EntityWrapper<ExampaperEntity>();
      	ew.allEq(MPUtil.allEQMapPre( exampaper, "exampaper")); 
        return R.ok().put("data", exampaperService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ExampaperEntity exampaper){
        EntityWrapper< ExampaperEntity> ew = new EntityWrapper< ExampaperEntity>();
 		ew.allEq(MPUtil.allEQMapPre( exampaper, "exampaper")); 
		ExampaperView exampaperView =  exampaperService.selectView(ew);
		return R.ok("查询试卷表成功").put("data", exampaperView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ExampaperEntity exampaper = exampaperService.selectById(id);
        return R.ok().put("data", exampaper);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ExampaperEntity exampaper = exampaperService.selectById(id);
        return R.ok().put("data", exampaper);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ExampaperEntity exampaper, HttpServletRequest request){
    	exampaper.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(exampaper);

        exampaperService.insert(exampaper);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ExampaperEntity exampaper, HttpServletRequest request){
    	exampaper.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(exampaper);

        exampaperService.insert(exampaper);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ExampaperEntity exampaper, HttpServletRequest request){
        //ValidatorUtils.validateEntity(exampaper);
        exampaperService.updateById(exampaper);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        exampaperService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ExampaperEntity> wrapper = new EntityWrapper<ExampaperEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = exampaperService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
