package service;

import java.util.List;

import dao.MemberDAO;
import vo.MemberInfo;

public class MemberService {
	private MemberDAO mdao = new MemberDAO();
	
	public List<MemberInfo> getMemberInfoList(){
	return mdao.selectMemberInfoList();
	
}
}