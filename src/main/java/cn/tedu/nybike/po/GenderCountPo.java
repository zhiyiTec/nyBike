package cn.tedu.nybike.po;

import java.sql.Date;

public class GenderCountPo {
    private Date starttime;
    private Integer gender;
    private Integer num;

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
    public GenderCountPo(){}
    @Override
    public String toString() {
        return "GenderCountPo{" +
                "starttime=" + starttime +
                ", gender=" + gender +
                ", num=" + num +
                '}';
    }
}
