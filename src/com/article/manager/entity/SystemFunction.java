package com.article.manager.entity;

public class SystemFunction {
    private String functionId;
    private String functionName;
    private String functionUrl;
    private String functionPid;
    private Integer functionState;

    public SystemFunction() {
    }

    public SystemFunction(String functionId, String functionName, String functionUrl, String functionPid, Integer functionState) {
        this.functionId = functionId;
        this.functionName = functionName;
        this.functionUrl = functionUrl;
        this.functionPid = functionPid;
        this.functionState = functionState;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionUrl() {
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl;
    }

    public String getFunctionPid() {
        return functionPid;
    }

    public void setFunctionPid(String functionPid) {
        this.functionPid = functionPid;
    }

    public Integer getFunctionState() {
        return functionState;
    }

    public void setFunctionState(Integer functionState) {
        this.functionState = functionState;
    }
}
