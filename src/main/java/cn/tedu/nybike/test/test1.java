package cn.tedu.nybike.test;

import cn.tedu.nybike.po.BikeStatusDo;
import cn.tedu.nybike.mapper.StationDao;
import cn.tedu.nybike.util.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

public class test1 {

        public static void main(String[] args) {
        String SSURL="https://gbfs.citibikenyc.com/gbfs/en/station_status.json";//stationSatus
        String status= HttpUtil.get(SSURL,"GET");//获取stationStatus数据
        JSONObject obj=JSON.parseObject(status);
        JSONObject data=obj.getJSONObject("data");
        JSONArray stations=data.getJSONArray("stations");
        List<BikeStatusDo> list=JSON.parseObject(stations.toString(),new TypeReference<List<BikeStatusDo>>(){});
            StationDao dao=new StationDao();
            dao.batchSaveStatus(list);
//                StationDao dao=new StationDao();
//                dao.batchSaveStatus(list);
//        for(BikeStatusDo bi:list){
//            System.out.println(bi.toString());
//        }
//        for(int i=0;i<stations.size();i++){
//            JSONObject job = stations.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
//            BikeStatusPo bikeStatusPo = new BikeStatusPo();// 得到 每个对象中的属性值
//
//            bikeStatusPo.setSid(( job.getInteger("station_id")));
//            bikeStatusPo.setNba((Integer) job.get("num_bikes_available"));
//            bikeStatusPo.setNbd((Integer) job.get("num_bikes_disabled"));
//            bikeStatusPo.setNda((Integer) job.get("num_docks_available"));
//            bikeStatusPo.setNdd((Integer) job.get("num_docks_disabled"));
//
//        }

    }

}
