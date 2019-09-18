package cn.tedu.nybike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import cn.tedu.nybike.pojo.StationStatusDo;
import cn.tedu.utils.DBUtils;

public class StationDao {

	// ������
	public void batchSaveStatus(List<StationStatusDo> list){
		
		String sql="insert into tb_status values(null,?,?,?,?,?)";
		//��ȡ����
		//��ȡSQLִ����
		try(Connection conn=DBUtils.getConn();
				PreparedStatement ps=conn.prepareStatement(sql)){
			for (StationStatusDo ssd : list) {
				//�󶨲���
				ps.setInt(1, ssd.getStation_id());
				ps.setInt(2, ssd.getNum_bikes_available());
				ps.setInt(3, ssd.getNum_bikes_disabled());
				ps.setInt(4, ssd.getNum_docks_available());
				ps.setInt(5, ssd.getNum_docks_disabled());
				//��SQL��ӵ�����
				ps.addBatch();
			}
			//�ύ��
			ps.executeBatch();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
}
