package ch05_obj;

public class WriteImpl {

	private ArticleDao articleDao; 
	// 2) 여기에서 이 ArticleDao는 타입은 ArticleDao(조상)이지만 실 주소는  class = "ch05_obj.OracleArticleDao" 에 의해 OracleArticleDao를 가리킨다 
	public WriteImpl(ArticleDao articleDao) {
		// 4) 만약 xml이 없었으면 ArticleDao articleDao = new OracleArticleDao()로 객체 생성해서 했을것 
		this.articleDao = articleDao;
	}
	
	public void write() {
		System.out.println("WriteImpl.write() 메서드 호출됨");
		articleDao.insert();// 3) 그래서 실 주소의 OracleArticleDao의 insert()가 실행된다 
		//1) xml에서 <bean id = "articleDao" class = "ch05_obj.OracleArticleDao"/> 이렇게 만들어서 여기에 생성자로 injection 했기 때문에 
	}
} //end class
