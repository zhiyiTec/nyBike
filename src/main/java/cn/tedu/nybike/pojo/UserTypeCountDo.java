package cn.tedu.nybike.pojo;

public class UserTypeCountDo {
    private String type;
    private Integer num;
    public UserTypeCountDo(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "UserTypeCount{" +
                "type='" + type + '\'' +
                ", num=" + num +
                '}';
    }
}
