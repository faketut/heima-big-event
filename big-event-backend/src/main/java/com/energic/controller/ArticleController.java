package com.energic.controller;

import com.energic.pojo.Article;
import com.energic.pojo.PageBean;
import com.energic.service.ArticleService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.energic.pojo.Result;

@RestController
@RequestMapping("/article")
@Validated
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @PostMapping
    public Result<String> add(@RequestBody @Validated(Article.Add.class) Article article) {
        articleService.add(article);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> list(final Integer pageNum,
                                          final Integer pageSize,
                                          @RequestParam(required = false) final Integer categoryId,
                                          @RequestParam(required = false) final String state) {
        final PageBean<Article> articleList = articleService.list(pageNum, pageSize, categoryId, state);
        return Result.success(articleList);
    }

    @GetMapping("/detail")
    public Result<Article> detail(@NotNull final Integer id) {
        final Article article = articleService.findById(id);
        return Result.success(article);
    }


    @PutMapping
    public Result<String> update(@RequestBody @Validated(Article.Update.class) Article article) {
        articleService.update(article);
        return Result.success();
    }

    @DeleteMapping
    public Result<String> delete(@NotNull final Integer id) {
        articleService.delete(id);
        return Result.success();
    }
}
