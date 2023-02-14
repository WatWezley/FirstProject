package data.repositories;

import data.models.Article;
import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArticleRepositoriesImplTest {

    private ArticleRepositoriesImpl articleRepositories;

    private Article article;

    @BeforeEach
    void setUp() {
        articleRepositories = new ArticleRepositoriesImpl();
        article = new Article();
        article.getDateCreated();
        article.setBody("Lord i  thank you for sunshine, thank you for rain");
        article.setTitle("IT¨S A BEAUTIFUL DAY");
        article.setUserId(2);

    }

    @Test
    public void saveAfterCreation() {
        articleRepositories.save(article);
        assertEquals(1, articleRepositories.count());
    }

    @Test
    public void saveOneArticle_idOfArticleIsOneTest() {
        Article savedArticle = articleRepositories.save(article);
        assertEquals(1, savedArticle.getArticleId());
    }

    @Test
    public void saveTwoArticlesWithSameId_countIsOneTest() {
        Article savedArticle = articleRepositories.save(article);
        assertEquals(1, articleRepositories.count());
        savedArticle.setTitle("Code running mad");
        articleRepositories.save(savedArticle);
        assertEquals(1, articleRepositories.count());
    }

    @Test
    public void saveOneUser_findByUserIdTest() {
        Article savedUser = articleRepositories.save(article);
        assertEquals(1, savedUser.getArticleId());
        Article foundUser = articleRepositories.findById(1);
        assertEquals(foundUser, savedUser);
    }

    @Test
    public void saveOneUser_deleteOneUser_CountIsZeroTest() {
        Article savedArticle = articleRepositories.save(article);
        assertEquals(1, articleRepositories.count());
        articleRepositories.delete(1);
        assertEquals(0, articleRepositories.count());
    }

    @Test
    public void saveTwoArticle_deleteOneArticle_byArticle() {
        Article savedArticle = articleRepositories.save(article);
        assertEquals(1, articleRepositories.count());
        article = new Article();
        article.getDateCreated();
        article.setBody("thank you pain, thank you for gain");
        article.setTitle("IT¨S A BEAUTIFUL DAY2");
        article.setUserId(2);
        Article savedArticle2 = articleRepositories.save(article);
        assertEquals(2, articleRepositories.count());
        articleRepositories.delete(savedArticle);
        assertEquals(1, articleRepositories.count());
    }

    @Test
    public void saveTwoArticle_findAllArticle() {
        Article savedArticle = articleRepositories.save(article);
        article = new Article();
        article.getDateCreated();
        article.setBody("thank you pain, thank you for gain");
        article.setTitle("IT¨S A BEAUTIFUL DAY2");
        article.setUserId(2);
        Article savedArticle2 = articleRepositories.save(article);
        assertEquals(2, savedArticle2.getArticleId());
        List<Article> articles2 = List.of(new Article[]{savedArticle, savedArticle2});
        assertEquals(articles2, articleRepositories.findAll());
        assertEquals(2, articleRepositories.count());
    }


        @Test
        public void saveTwoUser_deleteAllUser_CountIsZeroTest () {
            Article savedArticle = articleRepositories.save(article);
            assertEquals(1, articleRepositories.count());
            article = new Article();
            article.getDateCreated();
            article.setBody("thank you pain, thank you for gain");
            article.setTitle("IT¨S A BEAUTIFUL DAY2");
            article.setUserId(2);
            Article savedArticle2 = articleRepositories.save(article);
            assertEquals(2, savedArticle2.getArticleId());
            assertEquals(2, savedArticle2.getArticleId());
            Article foundArticle = articleRepositories.findById(2);
            assertEquals(savedArticle2, foundArticle);
            assertEquals(2, articleRepositories.count());
            articleRepositories.deleteAll();
            assertEquals(0, articleRepositories.count());
        }
    }
