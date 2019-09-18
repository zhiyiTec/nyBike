package cn.tedu.nybike.pojo;

public class AgeStageNumDo {
    private Integer age;
    // 0：少年；1：青年；2：壮年；3:中老年
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
