package cn.tedu.nybike.mapper;

import cn.tedu.nybike.po.GenderCountPo;
import cn.tedu.nybike.util.HiveDBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HiveDao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //添加一个方法，从hive中查询tb_grnder_count

    /**
     * 获取所有GenderCount
     * @return GenderCountPo的list集合或空集合
     * @throws SQLException
     */
    public List<GenderCountPo> getGenderCount() throws SQLException {
        List<GenderCountPo> list=new ArrayList();
        String sql="select * from tb_gender_count";
        Connection con=null;
        ResultSet rs=null;
        try{
             con= HiveDBUtil.getHiveConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             rs = ps.executeQuery();

            while(rs.next()) {
                GenderCountPo genderCountPo=new GenderCountPo();
                genderCountPo.setStarttime(rs.getDate("starttime"));
                genderCountPo.setGender(rs.getInt("gender"));
                genderCountPo.setNum(rs.getInt("num"));
                list.add(genderCountPo);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            logger.error("查询信息异常");
        }finally {

            rs.close();
            con.close();
            logger.info("JDBC关闭成功");
        }





        return list;
    }

}
