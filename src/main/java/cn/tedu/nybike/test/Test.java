package cn.tedu.nybike.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import cn.tedu.nybike.dao.HiveDAO;
import cn.tedu.nybike.pojo.AgeStageCountDo;
import cn.tedu.nybike.pojo.AgeStageCountVO;
import cn.tedu.nybike.pojo.UserTypeCountVo;
import cn.tedu.nybike.service.TripService;
import cn.tedu.utils.HiveDBUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import cn.tedu.nybike.dao.StationDao;
import cn.tedu.nybike.pojo.StationStatusDo;
import cn.tedu.utils.HttpUtil;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		TripService tripService=new TripService();
		UserTypeCountVo ageStageCountVO =tripService.getUserTypeCount();

			System.out.println(ageStageCountVO.toString());


	}
}
