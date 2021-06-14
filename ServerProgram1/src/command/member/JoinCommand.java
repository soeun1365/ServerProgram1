package command.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class JoinCommand implements MemberCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setName(name);
		
		int result = MemberDAO.getInstance().joinMember(dto);
		
		try {
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<script>");
				out.println("alert('가입되었습니다.')");
				out.println("<a href='login.jsp'>로그인</a>");
				out.println("</script>");
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
