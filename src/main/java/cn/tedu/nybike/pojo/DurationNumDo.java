package cn.tedu.nybike.pojo;

public class DurationNumDo {
    private Integer type;//0:<15min;1:15——60min;2:>60min
    private Integer number;//对应的数量
    public DurationNumDo(){}

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "DurationNumDo{" +
                "type=" + type +
                ", number=" + number +
                '}';
    }
}
