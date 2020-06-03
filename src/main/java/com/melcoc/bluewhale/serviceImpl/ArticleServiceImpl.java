package com.melcoc.bluewhale.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melcoc.bluewhale.dao.ArticleDao;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;


    @Override
    public List<Article> selectArticleAll() {
      QueryWrapper wrapper = new QueryWrapper<Article>();
        wrapper.eq("deleted",1);
        wrapper.orderByDesc("a_id");
        return articleDao.selectList(wrapper);
    }

    @Override
    public int insertArticle(Article article) {
        return articleDao.insertArticle(article);
    }



    @Override
    public int deletedArticle(Integer aId) {

        return articleDao.deleteById(aId);
    }

    @Override
    public List<Article> selectAll() {
        return articleDao.selectAll();
    }

    @Override
    public Article findByIdForUpdate(int aid) {

        return articleDao.findByIdForUpdate(aid);
    }

    @Override
    public int saveAndFlush(Article article) {
        return articleDao.saveAndFlush(article);
    }



}
