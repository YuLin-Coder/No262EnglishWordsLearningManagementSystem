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

import com.entity.CihuidanciEntity;
import com.entity.view.CihuidanciView;

import com.service.CihuidanciService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 词汇单词
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-30 13:20:35
 */
@RestController
@RequestMapping("/cihuidanci")
public class CihuidanciController {
    @Autowired
    private CihuidanciService cihuidanciService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CihuidanciEntity cihuidanci, HttpServletRequest request){

        EntityWrapper<CihuidanciEntity> ew = new EntityWrapper<CihuidanciEntity>();
		PageUtils page = cihuidanciService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cihuidanci), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CihuidanciEntity cihuidanci, HttpServletRequest request){
        EntityWrapper<CihuidanciEntity> ew = new EntityWrapper<CihuidanciEntity>();
		PageUtils page = cihuidanciService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cihuidanci), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CihuidanciEntity cihuidanci){
       	EntityWrapper<CihuidanciEntity> ew = new EntityWrapper<CihuidanciEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cihuidanci, "cihuidanci")); 
        return R.ok().put("data", cihuidanciService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CihuidanciEntity cihuidanci){
        EntityWrapper< CihuidanciEntity> ew = new EntityWrapper< CihuidanciEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cihuidanci, "cihuidanci")); 
		CihuidanciView cihuidanciView =  cihuidanciService.selectView(ew);
		return R.ok("查询词汇单词成功").put("data", cihuidanciView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CihuidanciEntity cihuidanci = cihuidanciService.selectById(id);
        return R.ok().put("data", cihuidanci);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CihuidanciEntity cihuidanci = cihuidanciService.selectById(id);
        return R.ok().put("data", cihuidanci);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        CihuidanciEntity cihuidanci = cihuidanciService.selectById(id);
        if(type.equals("1")) {
        	cihuidanci.setThumbsupnum(cihuidanci.getThumbsupnum()+1);
        } else {
        	cihuidanci.setCrazilynum(cihuidanci.getCrazilynum()+1);
        }
        cihuidanciService.updateById(cihuidanci);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CihuidanciEntity cihuidanci, HttpServletRequest request){
    	cihuidanci.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cihuidanci);

        cihuidanciService.insert(cihuidanci);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CihuidanciEntity cihuidanci, HttpServletRequest request){
    	cihuidanci.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cihuidanci);

        cihuidanciService.insert(cihuidanci);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CihuidanciEntity cihuidanci, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cihuidanci);
        cihuidanciService.updateById(cihuidanci);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cihuidanciService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<CihuidanciEntity> wrapper = new EntityWrapper<CihuidanciEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = cihuidanciService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
