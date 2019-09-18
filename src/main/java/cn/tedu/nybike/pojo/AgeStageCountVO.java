package cn.tedu.nybike.pojo;

import java.io.Serializable;
import java.util.List;

public class AgeStageCountVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<GCItem> data;

	public AgeStageCountVO() {}

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
