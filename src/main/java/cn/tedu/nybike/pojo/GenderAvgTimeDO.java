package cn.tedu.nybike.pojo;

import java.io.Serializable;
import java.sql.Date;

public class GenderAvgTimeDO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date data;
	private int gender;
	private double avg_time;

	public GenderAvgTimeDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
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
		return "GenderAvgTimeDO [data=" + data + ", gender=" + gender + ", avg_time=" + avg_time + "]";
	}

}
