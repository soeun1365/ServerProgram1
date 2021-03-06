package command.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class DeleteCommand implements MemberCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		MemberDTO loginDTO = (MemberDTO)session.getAttribute("loginDTO");


		int result = MemberDAO.getInstance().deleteMember(loginDTO.getNo());

		try {
			PrintWriter out = response.getWriter();
			if (result > 0) {
				session.invalidate();
				out.println("<script>");
				out.println("alert('탈퇴되었습니다.')");
				out.println("<a href = '/ServerProgram1/join.do'>회원가입</a>");
				out.println("</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
