package ch05_objScan;

import org.springframework.stereotype.Component;

import ch05_obj.Member;
import ch05_obj.MemberService;
import ch05_obj.UpdateInfo;

@Component("memberService")
public class MemberServiceImpl implements MemberService{

	public void regist(Member member) {
		System.out.println("MemberServiceImpl.regist() 메서드 실행");
	}
	
	public boolean update(String memberId, UpdateInfo info) {
		System.out.println("MemberServiceImpl.update() 메서드 실행");
		return false;
	}
	
	public boolean delete(String id, String str) {
		System.out.println("MemberServiceImpl.delete() 메서드 실행");
		return false;
	}
} // end class
