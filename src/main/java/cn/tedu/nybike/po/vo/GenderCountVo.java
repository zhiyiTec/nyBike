package cn.tedu.nybike.po.vo;

import java.util.List;

public class GenderCountVo {
    private List<GCVO> data;
    public GenderCountVo(){}
    public List<GCVO> getData() {
        return data;
    }

    public void setData(List<GCVO> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GenderCountVo{" +
                "data=" + data +
                '}';
    }
}
