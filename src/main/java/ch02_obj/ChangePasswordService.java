package ch02_obj;

public class ChangePasswordService {
	MemberDao memberDao;
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
		
	}
	
	public void changePassword(String email, String oldPw, String newPw) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException(); //커스텀 익셉션을 사용할 때에는 익셉션을 만들고 런타임 익셉션을 상속받으면 된다 -----그러면 위로 throw를 안 던져도 된다 	
		}
		member.changePassword(oldPw, newPw);
		memberDao.update(member);
		
	}
	
	
	public MemberDao getDao() {
		return memberDao;
	}
	
	
} //end class
