package cn.tedu.nybike.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.nybike.listener.SCListener;
import com.alibaba.fastjson.JSON;

public class StationStatusServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc=getServletContext();//��ȡServletContext����
		SCListener.LOCK.readLock().lock();//���϶���
		String status="";
		try {
			Object obj  =sc.getAttribute("status");//��sc�л�ȡվ������
			if(obj!=null){
				status=obj.toString();
			}
		}catch (Exception e){
			System.out.println("�������쳣");
		}finally {
			SCListener.LOCK.readLock().unlock();//����
		}
		resp.setContentType("application/json;charset=utf-8");//�˴����ڽ����ص����ݱ��json��ʽ
		resp.getWriter().write(status);//�˴������ݷ��ظ������
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
