package cn.tedu.nybike.pojo;

import java.sql.Date;

public class DurationCountDo {
    private Date startime;
    private Integer time;
    private Integer num;
    public  DurationCountDo(){}

    public Date getStartime() {
        return startime;
    }

    public void setStartime(Date startime) {
        this.startime = startime;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "DurationCountDo{" +
                "startime=" + startime +
                ", time=" + time +
                ", num=" + num +
                '}';
    }
}
