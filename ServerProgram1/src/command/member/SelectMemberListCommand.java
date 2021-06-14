package command.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class SelectMemberListCommand implements MemberCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO dto = new MemberDTO();
		List<MemberDTO> list = MemberDAO.getInstance().selectMemberList();
		
		request.setAttribute("list", list);

		ModelAndView mav = new ModelAndView("list.jsp", false); 
		System.out.println("이동했다.");
		return mav;
	}

}
