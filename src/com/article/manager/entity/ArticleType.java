package com.article.manager.entity;

public class ArticleType {
    private String typeId;
    //文章名字
    private String typeName;
    //文章类型
    private String typeDesc;
    //可用不可用
    private Integer typeState;
    //文章分类
    private Integer typeSort;

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

    public ArticleType() {
    }

    public ArticleType(String typeId, String typeName, String typeDesc, Integer typeState, Integer typeSort) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.typeDesc = typeDesc;
        this.typeState = typeState;
        this.typeSort = typeSort;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public Integer getTypeState() {
        return typeState;
    }

    public void setTypeState(Integer typeState) {
        this.typeState = typeState;
    }

    public Integer getTypeSort() {
        return typeSort;
    }

    public void setTypeSort(Integer typeSort) {
        this.typeSort = typeSort;
    }
}
