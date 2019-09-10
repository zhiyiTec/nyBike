package cn.tedu.nybike.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
	
	/**
	 * 发送GET请求，并返回响应内容的方法
	 * @param urlStr 请求的url
	 * @return 响应数据
	 */
	public static String get(String urlStr,String requestMethod){
        String message="";
        try {
            URL url=new URL(urlStr);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(requestMethod);
            connection.setConnectTimeout(5*1000);
            connection.connect();
            InputStream inputStream=connection.getInputStream();
            byte[] data=new byte[1024*512];// 512kb缓存空间
            StringBuffer sb=new StringBuffer();
            int length=0;
            while ((length=inputStream.read(data))!=-1){
                String s=new String(data,0,length);
                sb.append(s);
            }
            message=sb.toString();
            inputStream.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

}
