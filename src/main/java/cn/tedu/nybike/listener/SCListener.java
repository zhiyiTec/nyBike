package cn.tedu.nybike.listener;

import java.util.Date;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.tedu.utils.HttpUtil;

public class SCListener implements ServletContextListener {

	public static boolean loopFlag = true;
	public static long queryInterval = 60 * 1000;
	String infoUrl = "https://gbfs.citibikenyc.com/gbfs/en/station_information.json";
	String statusUrl = "https://gbfs.citibikenyc.com/gbfs/en/station_status.json";
	public static final ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock();
	public static final String SC_INFO = "info";
	public static final String SC_STATUS = "status";

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		// 通过事件对象，获取ServletContext对象
		final ServletContext sc = sce.getServletContext();
		// System.out.println("监听到SC被创建");

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				while (loopFlag) {
					String info = HttpUtil.get(infoUrl);
					String status = HttpUtil.get(statusUrl);
					LOCK.writeLock().lock();
					// System.out.println(info);
					try {
						sc.setAttribute(SC_INFO, info);
						sc.setAttribute(SC_STATUS, status);
					} finally {
						// TODO: handle finally clause
						LOCK.writeLock().unlock();
					}
					//System.out.println("SC请求到info和status数据：" + new Date());
					try {
						Thread.sleep(queryInterval);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		t1.start();
	}
}
