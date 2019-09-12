package cn.tedu.nybike.listener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.tedu.nybike.service.SaveService;
import cn.tedu.nybike.util.HttpUtil;
import cn.tedu.nybike.util.SpringContextUtil;


public class SCListener implements  ServletContextListener{


    private SaveService saveService=null;
	private final String SSURL="https://gbfs.citibikenyc.com/gbfs/en/station_status.json";//stationSatus
	private final String SIURL="https://gbfs.citibikenyc.com/gbfs/en/station_information.json";//stationInfo
	public static boolean siginal=true;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	public static long queryInterval=60*1000;

	//静态常量所有字母都大写
	public final  static ReentrantReadWriteLock LOCK=new ReentrantReadWriteLock();//创建读写锁(此处应该加一个final，因为要保证用同一个锁)
	
	


	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("监听到sc被创建");
		//saveService = (SaveService) SpringContextUtil.getBean("saveService");    //获取bean
		//此处通过事件对象
		final ServletContext sc=sce.getServletContext();
		
		//此处创建一个子线程
		Thread t1=new Thread(new Runnable() {
			
			public void run() {
				while(siginal){
					String status=HttpUtil.get(SSURL,"GET");//获取stationStatus数据
                    //saveService.saveStatus(status);//此处将信息存储到数据库
					String info=HttpUtil.get(SIURL,"GET");//获取stationInfo数据
					LOCK.writeLock().lock();//添加写锁，以防在写入时有其进程读数据
					try {

						sc.setAttribute("status", status);
						sc.setAttribute("info", info);

						if(sc.getAttribute("status")!=null&&sc.getAttribute("info")!=null){
							System.out.println("sc在"+df.format(new Date())+"请求到info数据，请求到的数据正常");
						}else{
							System.out.println("sc在"+df.format(new Date())+"请求到info数据，请求到异常数据");
						}

					}catch (Exception e) {
						siginal=false;
					}finally {
						LOCK.writeLock().unlock();//此处进行解锁
					}

					try {
						Thread.sleep(queryInterval);
					} catch (InterruptedException e) {
						siginal=false;
						e.printStackTrace();
					}
				}
				// TODO Auto-generated method stub



			}
		});
		t1.start();
		
		
	}


	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("监听到sc被销毁");
	}


}
