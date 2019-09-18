package cn.tedu.nybike.pojo;

import java.io.Serializable;
import java.sql.Date;

public class BBItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date data;
	private int bikeid;
	private String station_name;

	public BBItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getBikeid() {
		return bikeid;
	}

	public void setBikeid(int bikeid) {
		this.bikeid = bikeid;
	}

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BBItem [data=" + data + ", bikeid=" + bikeid + ", station_name=" + station_name + "]";
	}

}
