package cn.tedu.nybike.mapper;

import cn.tedu.nybike.po.BikeStatusPo;

public interface SaveMapper {
    //将 status的各种状态储存到数据库

     void  insertAdmin(BikeStatusPo bikeStatusPo);
}
