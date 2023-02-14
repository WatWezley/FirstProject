package data.repositories;

import data.models.Article;

import java.util.List;

public interface ArticleRepository {

   Article save(Article article);

   Article findById(int ArticleId);

    long count();

    List<Article> findAll();

    void delete(int ArticleId);

    void delete(Article article);

    List<Article> deleteAll();

}
