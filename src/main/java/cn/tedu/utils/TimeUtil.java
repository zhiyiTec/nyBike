package cn.tedu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class TimeUtil {

	/**
     * 取北京时间
     * @return
     */
    public static String getBeijingTime(long timestamp,SimpleDateFormat sdf){
        return getFormatedDateString(8,timestamp,sdf);
    }
    
    /**
     * 取纽约时间
     * @return
     */
    public static String getNewyorkTime(long timestamp,SimpleDateFormat sdf){
        return getFormatedDateString(-5,timestamp,sdf);
    }
    
    /**
     * 此函数非原创，从网上搜索而来，timeZoneOffset原为int类型，为班加罗尔调整成float类型
     * timeZoneOffset表示时区，如中国一般使用东八区，因此timeZoneOffset就是8
     * @param timeZoneOffset
     * @return
     */
    public static String getFormatedDateString(float timeZoneOffset,long timestamp,SimpleDateFormat sdf){
        if (timeZoneOffset > 13 || timeZoneOffset < -12) {
            timeZoneOffset = 0;
        }
        
        int newTime=(int)(timeZoneOffset * 60 * 60 * 1000);
        TimeZone timeZone;
        String[] ids = TimeZone.getAvailableIDs(newTime);
        if (ids.length == 0) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = new SimpleTimeZone(newTime, ids[0]);
        }
    
        sdf.setTimeZone(timeZone);
        
        Date date=timestamp==0?new Date():new Date(timestamp);
        return sdf.format(date);
    }
    
	
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//long timestamp=1556686800000L;
		//long timestamp=1556773199000l;
		long timestamp=1556773193000l;
		System.out.println(getNewyorkTime(timestamp, sdf));
	}
	

}