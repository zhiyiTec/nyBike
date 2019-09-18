package cn.tedu.nybike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import cn.tedu.nybike.pojo.StationStatusDo;
import cn.tedu.utils.DBUtils;

public class StationDao {

	// 批处理
	public void batchSaveStatus(List<StationStatusDo> list){
		
		String sql="insert into tb_status values(null,?,?,?,?,?)";
		//获取连接
		//获取SQL执行器
		try(Connection conn=DBUtils.getConn();
				PreparedStatement ps=conn.prepareStatement(sql)){
			for (StationStatusDo ssd : list) {
				//绑定参数
				ps.setInt(1, ssd.getStation_id());
				ps.setInt(2, ssd.getNum_bikes_available());
				ps.setInt(3, ssd.getNum_bikes_disabled());
				ps.setInt(4, ssd.getNum_docks_available());
				ps.setInt(5, ssd.getNum_docks_disabled());
				//将SQL添加到批中
				ps.addBatch();
			}
			//提交批
			ps.executeBatch();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
}
