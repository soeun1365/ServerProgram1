package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.member.MemberCommand;
import common.ModelAndView;

@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 기본 처리(요청과 응답)
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			String[] arr = request.getRequestURI().split("/");
			String cmd = arr[arr.length - 1];
				
				
			MemberCommand command = MemberCommandMapper.getInstance().getCommand(cmd);
			ModelAndView mav = null;
			if (command != null) {
				mav = command.execute(request, response);
			}

			if (mav == null) {
				return;
			}

			if (mav.isRedirect()) {
				response.sendRedirect(mav.getView());
			} else {
				request.getRequestDispatcher(mav.getView()).forward(request, response);
			}
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
}