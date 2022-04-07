package ch05_obj;

public class Article {

	private int id;
	//private ReadArticleDao dao;
	public Article() {}
	public Article(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public ReadArticleDao getDao() {
//		return dao;
//	}
//	public void setDao(ReadArticleDao dao) {
//		this.dao = dao;
//	}
	
	
//	public void increaseReadCount() {
//		dao.updateReadCount(id,1);
//	}
	
	@Override
	public String toString() {
		return id + ": article";
	}
	
} //end class
