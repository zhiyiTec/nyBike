package cn.tedu.nybike.mapper;

import cn.tedu.nybike.po.BikeStatusDo;
import cn.tedu.nybike.po.BikeStatusPo;

import java.util.List;

public interface GetMapper {
    //将 status的各种状态储存到数据库

     /**
      * 通过stationId获取所有的bikeStatus
      * @return
      */
     List<BikeStatusDo> getBikeStatusByStationId(Integer sid);
}
