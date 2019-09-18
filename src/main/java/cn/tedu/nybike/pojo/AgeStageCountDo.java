package cn.tedu.nybike.pojo;

import java.sql.Date;

public class AgeStageCountDo {
    private Integer birthYear;
    private Date  starttime;
    private Integer count;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public AgeStageCountDo(){}

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "AgeStageDo{" +
                "birthYear='" + birthYear + '\'' +
                ", starttime=" + starttime +
                ", count=" + count +
                '}';
    }
}
