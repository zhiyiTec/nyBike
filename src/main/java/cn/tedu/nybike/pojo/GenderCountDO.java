package cn.tedu.nybike.pojo;

import java.io.Serializable;
import java.sql.Date;


public class GenderCountDO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date startDate;
	private Integer gender;
	private Integer num;
	public GenderCountDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "GenderCountDO [startDate=" + startDate + ", gender=" + gender + ", num=" + num + "]";
	}

}
