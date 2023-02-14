package data.repositories;

import data.models.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepositoriesImpl implements ArticleRepository{

    private  int count;

    private List<Article> articles = new ArrayList<>();
    @Override
    public Article save(Article article) {
        boolean articleIsNotSaved = article.getArticleId() == 0;
        if(articleIsNotSaved){
            article.setArticleId(generateArticleId());
            articles.add(article);
            count++;}
        return article;
    }

    private int generateArticleId() {
        return count+1;
    }

    @Override
    public Article findById(int ArticleId) {
        for (Article article : articles) {
            if(article.getArticleId() == ArticleId) return article;  }
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<Article> findAll() {
           return articles;
    }

    @Override
    public void delete(int ArticleId) {
        for (Article article : articles) {
            if(article.getArticleId() == ArticleId) {
                articles.remove(article);
                count--;
                break;}}
    }

    @Override
    public void delete(Article article) {
        for (Article article2 : articles) {
            if(article2 == article ){
                articles.remove(article);
                count--;
                break;}}

    }

    @Override
    public List<Article> deleteAll() {
        articles = new ArrayList<>();
        count = 0;
        return articles;
    }
}
