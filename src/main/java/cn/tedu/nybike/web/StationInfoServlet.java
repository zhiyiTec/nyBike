package cn.tedu.nybike.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.nybike.listener.SCListener;

public class StationInfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc=getServletContext();//��ȡServletContext����
		SCListener.LOCK.readLock().lock();//���϶���
		String info="";
		try {
			Object obj  =sc.getAttribute("info");//��sc�л�ȡվ������
			if(obj!=null){
				info=String.valueOf(obj);
			}
		}catch (Exception e){
			System.out.println("�������쳣");
		}finally {
			SCListener.LOCK.readLock().unlock();//����
		}
		resp.setContentType("application/json;charset=utf-8");//�˴����ڽ����ص����ݱ��json��ʽ
		resp.getWriter().write(info);//�˴������ݷ��ظ������
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
