package cn.tedu.nybike.service.impl;

import cn.tedu.nybike.mapper.SaveMapper;
import cn.tedu.nybike.po.BikeStatusPo;
import cn.tedu.nybike.service.SaveService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveServiceImpl implements SaveService {
    @Autowired
    private SaveMapper saveMapper;
    public void saveStatus(String statusInfo) {
        JSONObject obj = JSON.parseObject(statusInfo);
        JSONObject data = obj.getJSONObject("data");
        JSONArray stations = data.getJSONArray("stations");
        for (int i = 0; i < stations.size(); i++) {
            JSONObject job = stations.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
            BikeStatusPo bikeStatusPo = new BikeStatusPo();// 得到 每个对象中的属性值

            bikeStatusPo.setSid(( job.getInteger("station_id")));
            bikeStatusPo.setNba((Integer) job.get("num_bikes_available"));
            bikeStatusPo.setNbd((Integer) job.get("num_bikes_disabled"));
            bikeStatusPo.setNda((Integer) job.get("num_docks_available"));
            bikeStatusPo.setNdd((Integer) job.get("num_docks_disabled"));
            saveMapper.insertAdmin(bikeStatusPo);
        }
    }
}
