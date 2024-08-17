package com.energic.service;

import com.energic.pojo.Article;
import com.energic.pojo.PageBean;

public interface ArticleService {

    void add(final Article article);

    PageBean<Article> list(final Integer pageNum,
                           final Integer pageSize,
                           final Integer categoryId,
                           final String state);

    Article findById(final Integer id);

    void update(final Article article);

    void delete(Integer id);
}
