package cn.tedu.nybike.web;

import cn.tedu.nybike.pojo.AgeStageCountVO;
import cn.tedu.nybike.pojo.GenderCountVO;
import cn.tedu.nybike.service.TripService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class GenderCountServlet
 */
public class AgeStageCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TripService service = new TripService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ����service��ȡvo����
		AgeStageCountVO ageStageCountVO=service.getAgeStage();
		// ����fastJSON������voת���ַ���
		String jsonStr = JSON.toJSONString(ageStageCountVO);
		response.setContentType("application/json;charset=utf-8");
		// �����ݷ��ظ������
		response.getWriter().write(jsonStr);
	}
}
