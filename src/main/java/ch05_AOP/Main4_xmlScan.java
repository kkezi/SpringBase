package ch05_AOP;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch05_obj.ArticleNotFoundException;
import ch05_obj.Member;
import ch05_obj.MemberService;
import ch05_obj.ReadArticleService;
import ch05_obj.UpdateInfo;

public class Main4_xmlScan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:ch05_AOP/Container4.xml");
	
		ReadArticleService service = ctx.getBean("readArticleService",ReadArticleService.class);
		// 										id로 빈을 갖고오지만 타입은 조상 인터페이스로 가져오고 실 주소는 자손 객체 (bean에 등록된 class에 의해서)
		
		try {
			service.getArticleAndReadCnt(1);
			service.getArticleAndReadCnt(1);
			service.getArticleAndReadCnt(0);
		} catch (ArticleNotFoundException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		}
		
		System.out.println("====updateMemberInfoTrace Aspect 연습");
		MemberService memberService = ctx.getBean("memberService",MemberService.class);
		memberService.regist(new Member());
		memberService.update("hong", new UpdateInfo());
		memberService.delete("hong2", "test");
		
		
		
		System.out.println("ok");
		ctx.close();
		
		
		
		

	}

}
