package com.sbs.java.ssg.service;

import java.util.List;

import com.sbs.java.ssg.container.Container;
import com.sbs.java.ssg.dao.ArticleDao;
import com.sbs.java.ssg.dto.Article;

public class ArticleService {
	private ArticleDao articleDao;
	
	public ArticleService() {
		this.articleDao = Container.articleDao;
	}
	
	public List<Article> getForPrintArticles(String searchKeyword) {
		return Container.articleDao.getArticles();
	}

	public int getArticleIndexById(int id) {
		return Container.articleDao.getArticleIndexById(id);
	}

	public Article getArticleById(int id) {
		return Container.articleDao.getArticleById(id);
	}

	public void remove(Article foundArticle) {
		articleDao.remove(foundArticle);
		
	}
}
