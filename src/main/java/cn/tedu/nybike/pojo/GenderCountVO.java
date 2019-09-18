package cn.tedu.nybike.pojo;

import java.io.Serializable;
import java.util.List;

public class GenderCountVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<GCItem> data;

	public GenderCountVO() {
		super();
		// TODO Auto-generated constructor stub
	}

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
