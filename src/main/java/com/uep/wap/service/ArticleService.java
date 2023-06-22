package com.uep.wap.service;

import com.uep.wap.model.Article;
import com.uep.wap.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        return optionalArticle.orElse(null);
    }

    public Article createArticle(Article article, String username) {
        // Set the author based on the currently logged in user
        article.setAuthor(username);

        // Set the date_of_creation to the current date and time
        article.setDate(LocalDate.now().toString());

        return articleRepository.save(article);
    }


    public Article updateArticle(long id, Article updatedArticle) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (optionalArticle.isPresent()) {
            Article existingArticle = optionalArticle.get();
            existingArticle.setTitle(updatedArticle.getTitle());
            existingArticle.setContent(updatedArticle.getContent());
            // copy other fields from updatedArticle to existingArticle
            return articleRepository.save(existingArticle);
        } else {
            return null;
        }
    }

    public boolean deleteArticle(long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (optionalArticle.isPresent()) {
            articleRepository.delete(optionalArticle.get());
            return true;
        } else {
            return false;
        }
    }
}
