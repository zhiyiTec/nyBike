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
	
		// ����service��ȡvo����
		GenderAvgTimeVO vo = service.findGenderAvgTime();
		// ����fastJSON������voת���ַ���
		String jsonStr = JSON.toJSONString(vo);
		response.setContentType("application/json;charset=utf-8");
		// �����ݷ��ظ������
		response.getWriter().write(jsonStr);
	}

}
