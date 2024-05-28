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

import com.entity.ExamrecordEntity;
import com.entity.view.ExamrecordView;

import com.service.ExamrecordService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 考试记录表
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-30 13:20:35
 */
@RestController
@RequestMapping("/examrecord")
public class ExamrecordController {
    @Autowired
    private ExamrecordService examrecordService;
    

   	    /**
     * 考试记录接口
     */
    @RequestMapping("/groupby")
    public R page2(@RequestParam Map<String, Object> params,ExamrecordEntity examrecord, HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		examrecord.setUserid((Long)request.getSession().getAttribute("userId"));
    	}

        EntityWrapper<ExamrecordEntity> ew = new EntityWrapper<ExamrecordEntity>();
		PageUtils page = examrecordService.queryPageGroupBy(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, examrecord), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ExamrecordEntity examrecord, HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		examrecord.setUserid((Long)request.getSession().getAttribute("userId"));
    	}

        EntityWrapper<ExamrecordEntity> ew = new EntityWrapper<ExamrecordEntity>();
		PageUtils page = examrecordService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, examrecord), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ExamrecordEntity examrecord, HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		examrecord.setUserid((Long)request.getSession().getAttribute("userId"));
    	}

        EntityWrapper<ExamrecordEntity> ew = new EntityWrapper<ExamrecordEntity>();
		PageUtils page = examrecordService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, examrecord), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ExamrecordEntity examrecord){
       	EntityWrapper<ExamrecordEntity> ew = new EntityWrapper<ExamrecordEntity>();
      	ew.allEq(MPUtil.allEQMapPre( examrecord, "examrecord")); 
        return R.ok().put("data", examrecordService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ExamrecordEntity examrecord){
        EntityWrapper< ExamrecordEntity> ew = new EntityWrapper< ExamrecordEntity>();
 		ew.allEq(MPUtil.allEQMapPre( examrecord, "examrecord")); 
		ExamrecordView examrecordView =  examrecordService.selectView(ew);
		return R.ok("查询考试记录表成功").put("data", examrecordView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ExamrecordEntity examrecord = examrecordService.selectById(id);
        return R.ok().put("data", examrecord);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ExamrecordEntity examrecord = examrecordService.selectById(id);
        return R.ok().put("data", examrecord);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ExamrecordEntity examrecord, HttpServletRequest request){
    	examrecord.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(examrecord);
    	examrecord.setUserid((Long)request.getSession().getAttribute("userId"));

        examrecordService.insert(examrecord);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ExamrecordEntity examrecord, HttpServletRequest request){
    	examrecord.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(examrecord);
    	examrecord.setUserid((Long)request.getSession().getAttribute("userId"));

        examrecordService.insert(examrecord);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ExamrecordEntity examrecord, HttpServletRequest request){
        //ValidatorUtils.validateEntity(examrecord);
        examrecordService.updateById(examrecord);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        examrecordService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ExamrecordEntity> wrapper = new EntityWrapper<ExamrecordEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}
		if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wrapper.eq("userid", (Long)request.getSession().getAttribute("userId"));
    	}


		int count = examrecordService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	

    /**
     * 当重新考试时，删除考生的某个试卷的所有考试记录
     */
    @RequestMapping("/deleteRecords")
    public R deleteRecords(@RequestParam Long userid,@RequestParam Long paperid){
    	examrecordService.delete(new EntityWrapper<ExamrecordEntity>().eq("paperid", paperid).eq("userid", userid));
        return R.ok();
    }

}
