package com.xin.springboot.controller.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xin.springboot.controller.dao.HwCheckRecordDao;
import com.xin.springboot.controller.model.HwCheckRecord;
import com.xin.springboot.controller.service.HwCheckRecordService;
import org.springframework.stereotype.Service;

/**
 * Created by xsl on 2019/3/29.
 */
@Service
public class HwCheckRecordServiceImpl extends ServiceImpl<HwCheckRecordDao,HwCheckRecord> implements HwCheckRecordService {
}
