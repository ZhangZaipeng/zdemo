package com.example.zdemo.Im.util.model.vo;

/**
 * IM消息实体类
 * Created by Huangzhigang on 2016/7/9.
 */
public class IMRecord {

	/*主键ID*/
    private Integer id;
    /*消息ID*/
    private String msgId;
    /*消息发送者*/
    private String msgSender;
    /*消息接收者*/
    private String msgReceiver;
    /*消息发起/接收时间*/
    private String msgCreateTime;
    /*创建时间*/
    private String createTime;
    /*消息内容ID*/
    private String msgContId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgSender() {
        return msgSender;
    }

    public void setMsgSender(String msgSender) {
        this.msgSender = msgSender;
    }

    public String getMsgReceiver() {
        return msgReceiver;
    }

    public void setMsgReceiver(String msgReceiver) {
        this.msgReceiver = msgReceiver;
    }

    public String getMsgCreateTime() {
        return msgCreateTime;
    }

    public void setMsgCreateTime(String msgCreateTime) {
        this.msgCreateTime = msgCreateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgContId() {
        return msgContId;
    }

    public void setMsgContId(String msgContId) {
        this.msgContId = msgContId;
    }

}
