package cn.tedu.nybike.service.impl;

import cn.tedu.nybike.mapper.GetMapper;
import cn.tedu.nybike.mapper.SaveMapper;
import cn.tedu.nybike.po.BikeStatusPo;
import cn.tedu.nybike.service.GetService;
import cn.tedu.nybike.service.SaveService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetServiceImpl implements GetService {
    @Autowired
    private GetMapper getMapper;

}
