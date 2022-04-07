package ch05_obj;

public interface ReadArticleService {

	public Article getArticleAndReadCnt(int id) throws ArticleNotFoundException;
}
