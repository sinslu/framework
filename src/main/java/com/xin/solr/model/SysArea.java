package com.xin.solr.model;


import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

@Data
public class SysArea implements java.io.Serializable{

    private static final long serialVersionUID = 2511039551838985307L;
    @Field
    private String id;
    @Field
    private String areaCode;
    @Field
    private String areaName;
    @Field
    private String pId;
}
