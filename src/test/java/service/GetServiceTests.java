package service;

import cn.tedu.nybike.mapper.HiveDao;
import cn.tedu.nybike.po.GenderCountPo;
import cn.tedu.nybike.po.vo.GenderCountVo;
import cn.tedu.nybike.service.GetService;
import cn.tedu.nybike.service.impl.GetServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:conf/mybatis-config.xml" })
public class GetServiceTests {
    GetServiceImpl getService=new GetServiceImpl();
    @Test
    public void getGenderCount() throws SQLException {
        GenderCountVo genderCountVo=getService.getGenderCount();
        System.out.println(genderCountVo.toString());
        //此处将转化为json
        String json= JSON.toJSONString(genderCountVo);
        System.out.println(json);
    }
}
