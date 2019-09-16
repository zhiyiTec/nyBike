package cn.tedu.nybike.web;

import cn.tedu.nybike.listener.SCListener;
import cn.tedu.nybike.po.vo.GenderCountVo;
import cn.tedu.nybike.service.GetService;
import cn.tedu.nybike.service.impl.GetServiceImpl;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class GenderCountServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
   GetServiceImpl getService=new GetServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc=getServletContext();//获取ServletContext对象
        String info="";
        try {
            GenderCountVo genderCountVo = getService.getGenderCount();
            //此处将对象转化为json
            info= JSON.toJSONString(genderCountVo);
            resp.setContentType("application/json;charset=utf-8");//此处用于将返回的数据变成json格式
            resp.getWriter().write(info);//此处将数据返回给浏览器
            logger.info("信息已经 存入request中，传入的信息为:"+info);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
