package com.xin.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xin.APP;
import com.xin.solr.model.SysArea;
import com.xin.springboot.controller.model.HwCheckRecord;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.util.NamedList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by xsl on 2019/3/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = APP.class)
@Slf4j
public class RecordTestController {
    @Autowired
    private SolrClient solrClient;

    @Test
    public void query()throws Exception{
        SolrQuery query=new SolrQuery();
        query.setQuery("pId:0");
        QueryResponse response=solrClient.query("sys_area",query);
        SolrDocumentList documentList=response.getResults();
        System.out.println(documentList);
        List<SysArea> areaList=response.getBeans(SysArea.class);
        System.out.println(JSONObject.toJSONString(areaList));
    }
    @Test
    public void list(){
        HwCheckRecord record=new HwCheckRecord();
        List<HwCheckRecord> recordList=record.selectList(new QueryWrapper<HwCheckRecord>().eq("device_id","00000000-117f-0f60-ffff-ffffb9afeaa5"));
        log.info(JSONObject.toJSONString(recordList));
    }
}
