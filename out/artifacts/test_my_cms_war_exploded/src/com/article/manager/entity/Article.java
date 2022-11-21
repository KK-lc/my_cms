package com.article.manager.entity;

import java.util.Date;

public class Article {
    private String articleId;
    private String articleTitle;
    private String articleImgUrl;
    private String articleSummary;
    private String articleContent;
    private Date articlePublishtime;
    private String articleAuthor;
    private String articleSource;
    private Integer articleState;

    public Article(String articleId, String articleTitle, String articleImgUrl, String articleSummary, String articleContent, Date articlePublishtime, String articleAuthor, String articleSource, Integer articleState, ArticleType articleType, SystemUser systemUser) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleImgUrl = articleImgUrl;
        this.articleSummary = articleSummary;
        this.articleContent = articleContent;
        this.articlePublishtime = articlePublishtime;
        this.articleAuthor = articleAuthor;
        this.articleSource = articleSource;
        this.articleState = articleState;
        this.articleType = articleType;
        this.systemUser = systemUser;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleImgUrl='" + articleImgUrl + '\'' +
                ", articleSummary='" + articleSummary + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articlePublishtime=" + articlePublishtime +
                ", articleAuthor='" + articleAuthor + '\'' +
                ", articleSource='" + articleSource + '\'' +
                ", articleState=" + articleState +
                '}';
    }

    private Integer typeId;
    private Integer userId;
    private ArticleType articleType;
    private SystemUser systemUser;

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Article() {
    }


    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleImgUrl() {
        return articleImgUrl;
    }

    public void setArticleImgUrl(String articleImgUrl) {
        this.articleImgUrl = articleImgUrl;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getArticlePublishtime() {
        return articlePublishtime;
    }

    public void setArticlePublishtime(Date articlePublishtime) {
        this.articlePublishtime = articlePublishtime;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleSource() {
        return articleSource;
    }

    public void setArticleSource(String articleSource) {
        this.articleSource = articleSource;
    }

    public Integer getArticleState() {
        return articleState;
    }

    public void setArticleState(Integer articleState) {
        this.articleState = articleState;
    }

    public Article(String articleTitle){
        this.articleTitle = articleTitle;
    }

    public int printArticle(String words){
        System.out.println("print..........." + words);
        return 12;
    }

}
