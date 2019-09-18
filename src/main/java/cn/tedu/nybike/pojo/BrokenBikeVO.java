package cn.tedu.nybike.pojo;

import java.io.Serializable;
import java.util.List;

public class BrokenBikeVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<BBItem> data;

	public BrokenBikeVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<BBItem> getData() {
		return data;
	}

	public void setData(List<BBItem> data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BrokenBikeVO [data=" + data + "]";
	}

}
