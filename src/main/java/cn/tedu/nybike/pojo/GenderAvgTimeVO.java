package cn.tedu.nybike.pojo;

import java.io.Serializable;
import java.util.List;

public class GenderAvgTimeVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<GATItem> data;

	public GenderAvgTimeVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<GATItem> getData() {
		return data;
	}

	public void setData(List<GATItem> data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "GenderAvgTimeVO [data=" + data + "]";
	}

}
