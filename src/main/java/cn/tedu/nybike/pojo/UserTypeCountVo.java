package cn.tedu.nybike.pojo;

import java.util.List;

public class UserTypeCountVo {
    private static final long serialVersionUID = 1L;
    private List<GCItem> data;

    public UserTypeCountVo() { }

    public List<GCItem> getData() {
        return data;
    }

    public void setData(List<GCItem> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GenderCountVO [data=" + data + "]";
    }
}
