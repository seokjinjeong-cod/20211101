package co.seokjin.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.seokjin.prj.comm.Command;
import co.seokjin.prj.member.service.MemberService;
import co.seokjin.prj.member.service.MemberVO;
import co.seokjin.prj.member.serviceImpl.MemberServiceImpl;

public class MemberLogin implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		System.out.println(vo.getId());
		System.out.println(vo.getPassword());
		vo = memberDao.selectMember(vo);
		String viewPage = null;
		if(vo != null) {
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			session.setAttribute("author", vo.getAuthor());
			viewPage = "home.do";
		} else {
			viewPage = "memberLoginForm.do";
		}
		return viewPage;
	}
}
