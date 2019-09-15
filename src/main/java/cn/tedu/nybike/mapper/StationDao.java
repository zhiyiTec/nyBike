package cn.tedu.nybike.mapper;

import cn.tedu.nybike.po.BikeStatusDo;
import cn.tedu.nybike.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class StationDao {
    // 批处理
    public void batchSaveStatus(
            List<BikeStatusDo> list){
        String sql="insert into tb_status "
                + "values(null,?,?,?,?,?)";

        // 获取连接
        // 获取SQL执行器
        try{
            Connection conn=DBUtils.getConn();
            PreparedStatement ps=conn.prepareStatement(sql);
            // 遍历list集合
            for(BikeStatusDo ssDO:list){
                // 绑定参数
                ps.setInt(1, ssDO.getStation_id());
                ps.setInt(2, ssDO.getNum_bikes_available());
                ps.setInt(3, ssDO.getNum_bikes_disabled());
                ps.setInt(4, ssDO.getNum_docks_available());
                ps.setInt(5, ssDO.getNum_docks_disabled());
                // 将SQL添加到批中
                ps.addBatch();
            }
            // 提交批
            ps.executeBatch();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
