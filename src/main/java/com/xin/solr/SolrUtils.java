package com.xin.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.common.params.SolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xsl on 2019/8/21.
 */
@Component
public class SolrUtils {
    @Autowired
    private SolrClient solrClient;
    public void query()throws Exception{
        SolrQuery query=new SolrQuery();
        query.setQuery("pId:0");
        solrClient.query(query);
    }
}
