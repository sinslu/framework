package com.xin.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xin.springboot.controller.model.HwCheckRecord;
import com.xin.springboot.controller.service.HwCheckRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xsl on 2019/3/27.
 */
@RestController
@RequestMapping("test")
public class SpringBootController {
    @Autowired
    private  HwCheckRecordService hwCheckRecordService;

    @RequestMapping("home")
    public List<HwCheckRecord> home(){
        QueryWrapper queryWrapper=new QueryWrapper<HwCheckRecord>();
        queryWrapper.le("device_id","00000000-117f-0f60-ffff-ffffb9afeaa5");
        List<HwCheckRecord> recordList=hwCheckRecordService.list(queryWrapper);
        System.out.println(JSONObject.toJSONString(recordList.get(0)));
        return recordList;
    }
    @RequestMapping("list")
    public String list(){
        HwCheckRecord hwCheckRecord=new HwCheckRecord();
        QueryWrapper queryWrapper=new QueryWrapper<HwCheckRecord>();
        queryWrapper.le("device_id","00000000-117f-0f60-ffff-ffffb9afeaa5");
        List<HwCheckRecord> recordList=hwCheckRecord.selectList(queryWrapper);
        return JSONObject.toJSONString(recordList);
    }
}
