package dao;

import cn.tedu.nybike.mapper.HiveDao;
import cn.tedu.nybike.po.GenderCountPo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:conf/mybatis-config.xml" })
public class HiveDaoTests {
    HiveDao hiveDao=new HiveDao();
    @Test
    public void getGenderCount() throws SQLException {
        List<GenderCountPo> list=hiveDao.getGenderCount();
       for(GenderCountPo genderCountPo:list){
           System.out.println(genderCountPo.toString());
       }
    }
}
