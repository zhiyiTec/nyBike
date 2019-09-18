package cn.tedu.nybike.pojo;

import java.io.Serializable;

public class GCItem implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name; // 性别
	private Integer value; // 数量

	public GCItem() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "GCItem [name=" + name + ", value=" + value + "]";
	}

}
