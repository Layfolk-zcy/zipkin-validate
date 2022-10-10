package com.bean;


import java.util.Date;

/**
 * @author 微服务底座平台
 * @version 2.0.0
 * @title: ServerNod
 * @projectName: sungrid-coreopscen
 * @description: TODO 服务节点信息表对应实体
 * @date: 2022-06-13 09:53
 **/

public class ServerNodePoJo {

    // 节点编号
    private String nodeId;
    // 节点名称
    private String nodeName;
    // 节点状态(0-停止 1-运行)
    private Integer status;
    // 节点ip地址
    private String nodeIp;
    // 节点端口号
    private String nodePort;
    // 节点类型(0-应用 1-开源 2-其他)
    private Integer nodeType;
    /*节点版本*/
    private String nodeVersion;
    // 部署方式(0-jar部署 1-docker部署)
    private Integer depType;
    // 节点进程或镜像编号
    private String nodePid;
    // 所属生态
    private String belLogy;
    // 所属应用
    private String belApp;
    // 所属服务
    private String belSer;
    // 所属模板
    private String belTmp;
    // 所属服务器
    private String belMach;
    // 所属注册服务
    private String belReg;

    // jar 包部署信息
    private  String jarInfo;

    // docker 镜像部署信息
    private  String dockerInfo;

    // 创建时间
    private Date createTime;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNodeIp() {
        return nodeIp;
    }

    public void setNodeIp(String nodeIp) {
        this.nodeIp = nodeIp;
    }

    public String getNodePort() {
        return nodePort;
    }

    public void setNodePort(String nodePort) {
        this.nodePort = nodePort;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeVersion() {
        return nodeVersion;
    }

    public void setNodeVersion(String nodeVersion) {
        this.nodeVersion = nodeVersion;
    }

    public Integer getDepType() {
        return depType;
    }

    public void setDepType(Integer depType) {
        this.depType = depType;
    }

    public String getNodePid() {
        return nodePid;
    }

    public void setNodePid(String nodePid) {
        this.nodePid = nodePid;
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

    public String getBelTmp() {
        return belTmp;
    }

    public void setBelTmp(String belTmp) {
        this.belTmp = belTmp;
    }

    public String getBelMach() {
        return belMach;
    }

    public void setBelMach(String belMach) {
        this.belMach = belMach;
    }

    public String getBelReg() {
        return belReg;
    }

    public void setBelReg(String belReg) {
        this.belReg = belReg;
    }

    public String getJarInfo() {
        return jarInfo;
    }

    public void setJarInfo(String jarInfo) {
        this.jarInfo = jarInfo;
    }

    public String getDockerInfo() {
        return dockerInfo;
    }

    public void setDockerInfo(String dockerInfo) {
        this.dockerInfo = dockerInfo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
