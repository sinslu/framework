package com.xin.springboot.controller.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Created by xsl on 2019/3/6.
 */
@Data
@Accessors(chain = true)
@TableName("hw_check_record")
public class HwCheckRecord extends Model{
    @TableId
    private String id;
    private String userId;
    private String deviceId;
    private String picUrl;
    private Integer pageId;
    private Date createTime;
    private String status;
}
