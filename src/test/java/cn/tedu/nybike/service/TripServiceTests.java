package cn.tedu.nybike.service;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.tedu.nybike.pojo.GenderCountVO;

public class TripServiceTests {

	TripService ts = new TripService();

	@Test
	public void findGenderCount() {

		GenderCountVO vo = ts.findGenderCount();
		System.out.println(vo);
		String jsonStr = JSON.toJSONString(vo);
		System.out.println(jsonStr);
	}
}
