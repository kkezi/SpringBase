package ch05_AOP;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import ch05_obj.MemberService;
import ch05_obj.MemberServiceImpl;
import ch05_obj.ReadArticleService;
import ch05_obj.ReadArticleServiceImpl;
import ch05_objScan.ArticleCacheAdvice;
import ch05_objScan.LoggingAdvice;
import ch05_objScan.UpdateMemberInfoTraceAdvice;



@Configuration
@EnableAspectJAutoProxy // @aspect 먹으려면 이게 있어야한다
public class Container3_anno {

	@Bean
	public LoggingAdvice loggingAdvice() {
		return new LoggingAdvice();
	}
	
	@Bean
	public ArticleCacheAdvice cacheAdvice() {
		return new ArticleCacheAdvice();
	}
	
	
	@Bean
	public UpdateMemberInfoTraceAdvice traceAdvice() {
		return new UpdateMemberInfoTraceAdvice();
	}
	
	@Bean
	public ReadArticleService readArticleService() {
		return new ReadArticleServiceImpl();
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl();
	}
	
	
	
	
	
	
} // end class
