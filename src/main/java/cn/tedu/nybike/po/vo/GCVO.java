package cn.tedu.nybike.po.vo;

public class GCVO {
    private String name;//性别
    private Integer value;//数量

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    public GCVO(){}
    @Override
    public String toString() {
        return "GCVO{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
