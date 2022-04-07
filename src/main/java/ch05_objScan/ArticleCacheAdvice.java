package ch05_objScan;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import ch05_obj.Article;

@Component
@Aspect
@Order(3)
public class ArticleCacheAdvice {

	final String method = "execution(public * *..ReadArticleServiceImpl.*(..))";
	
	
	private Map<Integer, Article> cache = new HashMap<Integer, Article>();
	//cache(1,Article(1)객체) 저장되어있음
	
	
	
	
	@Around(method)
	public Article cache(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("[ACA] cache before 실행");
		//jonPoint.getArgs() : 핵심 알고리즘의 매개변수 목록
		//id : 1
		Integer id = (Integer)joinPoint.getArgs()[0];
		Article article = cache.get(id);
		if(article != null) {//기존에 Article 객체가 저장되어 있는지 확인
			System.out.println("[ACA] cache에서 Article[" + id +"] 가져옴");
			return article;
		}
		Article ret = (Article)joinPoint.proceed();//핵심메서드를 실행
		//ret : Article(1)객체. 핵심 알고리즘이 리턴객체
		System.out.println("[ACA] cache after 실행");
		if (ret != null) {
			cache.put(id, ret);
			System.out.println("[ACA] cache에 Article[" + id + "] 객체를 추가함");
		}
		return ret;
	}
	
} //end class
