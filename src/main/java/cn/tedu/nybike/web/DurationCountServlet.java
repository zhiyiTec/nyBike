package cn.tedu.nybike.web;

import cn.tedu.nybike.pojo.AgeStageCountVO;
import cn.tedu.nybike.pojo.DurationCountVo;
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
public class DurationCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TripService service = new TripService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ����service��ȡvo����
		DurationCountVo durationCountVo=service.getDurationCountVo();
		// ����fastJSON������voת���ַ���
		String jsonStr = JSON.toJSONString(durationCountVo);
		response.setContentType("application/json;charset=utf-8");
		// �����ݷ��ظ������
		response.getWriter().write(jsonStr);
	}
}