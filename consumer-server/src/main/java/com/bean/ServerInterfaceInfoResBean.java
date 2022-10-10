package com.bean;


import java.util.Date;

/**
 * @author 微服务底座平台
 * @version 2.0.0
 * @title: ServerInterfaceInfoResBean
 * @projectName: sungrid-basicwork
 * @description: 服务信息接口实体bean
 * @date: 2022-07-01 16:58
 **/

public class ServerInterfaceInfoResBean {
    //接口编号
    private String intId;
    //所属生态
    private String belLogy;
    //所属应用
    private String belApp;
    //所属服务
    private String belSer;

    //状态
    private Integer status;

    private String belNode;

    //注册服务编号
    private String belReg;
    //节点编号
    private String nodeId;

    private String intName;

    private String intPath;

    private String reqType;

    private String reqPara;

    private String resType;

    private String reqExp;

    private String  resCode;

    private String resExp;

    private Date createTime;

    private Date updateTime;

    private String version;

    private String ReType;

    public String getIntId() {
        return intId;
    }

    public void setIntId(String intId) {
        this.intId = intId;
    }

    public String getBelLogy() {
        return belLogy;
    }

    public void setBelLogy(String belLogy) {
        this.belLogy = belLogy;
    }

    public String getBelApp() {
        return belApp;
    }

    public void setBelApp(String belApp) {
        this.belApp = belApp;
    }

    public String getBelSer() {
        return belSer;
    }

    public void setBelSer(String belSer) {
        this.belSer = belSer;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBelNode() {
        return belNode;
    }

    public void setBelNode(String belNode) {
        this.belNode = belNode;
    }

    public String getBelReg() {
        return belReg;
    }

    public void setBelReg(String belReg) {
        this.belReg = belReg;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getIntName() {
        return intName;
    }

    public void setIntName(String intName) {
        this.intName = intName;
    }

    public String getIntPath() {
        return intPath;
    }

    public void setIntPath(String intPath) {
        this.intPath = intPath;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public String getReqPara() {
        return reqPara;
    }

    public void setReqPara(String reqPara) {
        this.reqPara = reqPara;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public String getReqExp() {
        return reqExp;
    }

    public void setReqExp(String reqExp) {
        this.reqExp = reqExp;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResExp() {
        return resExp;
    }

    public void setResExp(String resExp) {
        this.resExp = resExp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReType() {
        return ReType;
    }

    public void setReType(String reType) {
        ReType = reType;
    }
}
