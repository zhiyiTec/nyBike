package cn.tedu.nybike.dao;

import java.util.List;

import org.junit.Test;

import cn.tedu.nybike.pojo.GenderCountDO;

public class HiveDAOTests {

	HiveDAO dao=new HiveDAO();
	@Test
	public void listGenderCount(){
		
		List<GenderCountDO> list=dao.listGenderCount();
		for(GenderCountDO gc : list){
			System.out.println(gc);
		}
	}
}
