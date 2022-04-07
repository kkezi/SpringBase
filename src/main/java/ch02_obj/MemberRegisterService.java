package ch02_obj;


import java.util.Date;

public class MemberRegisterService {

	MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberdao) {
		System.out.println("컨테이너 만들고 읽기 전에  서비스 컨스트럭쳐 먼저 실행");
		this.memberDao = memberdao;
	}
	
	//이메일 중복처리 
	public void regist(RegisterRequest req) throws AlreadyMemberException {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new AlreadyMemberException("email 중복 " +req.getEmail());
		} 
		Member newMember = new Member(null,
				req.getEmail(),
				req.getPassword(),
				req.getName(),
				new Date());
		memberDao.insert(newMember);
		regist();
	}
	

	public void regist() {
		System.out.println(memberDao.selectAll());
	}
	
	
	
	
}
