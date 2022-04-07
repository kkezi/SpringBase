package ch05_obj;

public class ReadArticleServiceImpl implements ReadArticleService {

	public Article getArticleAndReadCnt(int id) throws ArticleNotFoundException {
		System.out.println("핵심서비스 ---getArticleAndReadCnt("+ id +") 호출됨--->조인포인트");
		if(id ==0 ) {
			throw new ArticleNotFoundException("id는 0이 안됨");
		}
		return new Article(id);
	}
}// end class
