package cn.tedu.nybike.service.impl;

import cn.tedu.nybike.mapper.GetMapper;
import cn.tedu.nybike.mapper.HiveDao;
import cn.tedu.nybike.mapper.SaveMapper;
import cn.tedu.nybike.po.BikeStatusPo;
import cn.tedu.nybike.po.GenderCountPo;
import cn.tedu.nybike.po.vo.GCVO;
import cn.tedu.nybike.po.vo.GenderCountVo;
import cn.tedu.nybike.service.GetService;
import cn.tedu.nybike.service.SaveService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Service
public class GetServiceImpl implements GetService {

    HiveDao hiveDao=new HiveDao();
    public GenderCountVo getGenderCount() throws SQLException {

        GenderCountVo genderCountVo=new GenderCountVo();
        List<GenderCountPo> genderCountPoList=hiveDao.getGenderCount();

        List<GCVO> gcvoList=new LinkedList<GCVO>();
        for(GenderCountPo gcp:genderCountPoList){

            GCVO gcvo=new GCVO();
            if(gcp.getGender()==0) gcvo.setName("其他");
            if(gcp.getGender()==1) gcvo.setName("男");
            if(gcp.getGender()==2) gcvo.setName("女");

            gcvo.setValue(gcp.getNum());
            gcvoList.add(gcvo);
        }
        genderCountVo.setData(gcvoList);
        return genderCountVo;
    }
}
