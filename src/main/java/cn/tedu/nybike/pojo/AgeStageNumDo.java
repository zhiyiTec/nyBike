package cn.tedu.nybike.pojo;

public class AgeStageNumDo {
    private Integer age;
    // 0�����ꣻ1�����ꣻ2��׳�ꣻ3:������
    private Integer num;
    public AgeStageNumDo(){}
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "AgeStafeNum{" +
                "age=" + age +
                ", num=" + num +
                '}';
    }
}
