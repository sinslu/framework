package com.xin.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xin.APP;
import com.xin.springboot.controller.model.HwCheckRecord;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by xsl on 2019/3/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = APP.class)
@Slf4j
public class RecordTestController {
    @Test
    public void list(){
        HwCheckRecord record=new HwCheckRecord();
        List<HwCheckRecord> recordList=record.selectList(new QueryWrapper<HwCheckRecord>().eq("device_id","00000000-117f-0f60-ffff-ffffb9afeaa5"));
        log.info(JSONObject.toJSONString(recordList));
    }
}
