package cn.tedu.nybike.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import cn.tedu.nybike.pojo.GenderAvgTimeVO;
import cn.tedu.nybike.service.TripService;

/**
 * Servlet implementation class GenderAvgTimeServlet
 */
public class GenderAvgTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TripService service = new TripService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 调用service获取vo对象
		GenderAvgTimeVO vo = service.findGenderAvgTime();
		// 调用fastJSON方法将vo转成字符串
		String jsonStr = JSON.toJSONString(vo);
		response.setContentType("application/json;charset=utf-8");
		// 将数据返回给浏览器
		response.getWriter().write(jsonStr);
	}

}
