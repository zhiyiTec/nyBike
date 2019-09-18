package cn.tedu.nybike.pojo;

import java.util.List;

public class DurationCountVo {

    private static final long serialVersionUID = 1L;
    private List<GCItem> data;

    public DurationCountVo() {}

    public List<GCItem> getData() {
        return data;
    }

    public void setData(List<GCItem> data) {
        this.data = data;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "GenderCountVO [data=" + data + "]";
    }
}
