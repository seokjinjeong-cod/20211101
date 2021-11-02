package co.seokjin.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seokjin.prj.comm.Command;
import co.seokjin.prj.member.service.MemberService;
import co.seokjin.prj.member.service.MemberVO;
import co.seokjin.prj.member.serviceImpl.MemberServiceImpl;

public class RegisterMember implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setName(request.getParameter("name"));
		vo.setPassword(request.getParameter("password"));
		vo.setAddress(request.getParameter("address"));
		vo.setTel(request.getParameter("tel"));
		vo.setAuthor(request.getParameter("author"));
		
		int n = memberDao.insertMember(vo);
		
		String viewPage = null;
		
		if(n != 1) {
			viewPage = "memberLoginForm.do";
		} else {
			request.setAttribute("message", "회원가입이 정상적으로 처리되지 못했습니다.");
			viewPage = "member/memberError";
		}
		return viewPage;
	}

}
