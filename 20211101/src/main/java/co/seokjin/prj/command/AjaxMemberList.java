package co.seokjin.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.seokjin.prj.comm.Command;
import co.seokjin.prj.member.service.MemberService;
import co.seokjin.prj.member.serviceImpl.MemberServiceImpl;

public class AjaxMemberList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// Json type Data
		MemberService memberDao = new MemberServiceImpl();
//		Gson gson = new Gson();
//		List<MemberVO> list = new ArrayList<MemberVO>();
//		list = memberDao.selectMemberList();
//		System.out.println(gson.toJson(list));
		ObjectMapper objectMapper = new ObjectMapper(); // jackson 라이브러리
		String members = null;
		try {
			members = objectMapper.writeValueAsString(memberDao.selectMemberList());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
//		members = "{ \"data\" : " + members + "}";
		System.out.println(members);
		return "ajax:" + members;
	}
}
