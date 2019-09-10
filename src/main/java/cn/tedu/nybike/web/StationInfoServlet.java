package cn.tedu.nybike.web;

import cn.tedu.nybike.listener.SCListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StationInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc=getServletContext();//获取ServletContext对象
        SCListener.LOCK.readLock().lock();//加上读锁
        String info="";
        try {
           Object obj  =sc.getAttribute("info");//从sc中获取站点数据
            if(obj!=null){
                info=String.valueOf(obj);
            }
        }catch (Exception e){
            System.out.println("读数据异常");
        }finally {
            SCListener.LOCK.readLock().unlock();//解锁
        }
        resp.setContentType("application/json;charset=utf-8");//此处用于将返回的数据变成json格式
        resp.getWriter().write(info);//此处将数据返回给浏览器
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
