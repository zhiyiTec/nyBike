package cn.tedu.nybike.pojo;

import java.io.Serializable;
import java.sql.Date;

public class GATItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date data;
	private String gender;
	private double avg_time;
	public GATItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getAvg_time() {
		return avg_time;
	}
	public void setAvg_time(double avg_time) {
		this.avg_time = avg_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "GATItem [data=" + data + ", gender=" + gender + ", avg_time=" + avg_time + "]";
	}

}
