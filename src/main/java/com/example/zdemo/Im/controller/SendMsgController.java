package com.example.zdemo.Im.controller;

import com.example.zdemo.Im.domain.Message;
import com.example.zdemo.Im.domain.SendMsgBo;
import com.example.zdemo.Im.netty.transport.connection.ConnPool;
import com.example.zdemo.Im.util.common.IMUtil;
import com.example.zdemo.Im.util.model.msg.MsgBodys;
import com.example.zdemo.Im.util.model.msg.MsgElement;
import com.example.zdemo.Im.util.model.msg.SendMsgPayload;
import com.example.zdemo.Im.util.model.msg.content.IMsgContent;
import com.example.zdemo.Im.util.model.msg.content.TextMsgContent;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发送消息
 */
@RestController
public class SendMsgController {

  private Logger logger = LoggerFactory.getLogger(SendMsgController.class);

  /**
   * 发送聊天消息
   */
  @PostMapping("/sendMsg.json")
  public String sendMsg(@RequestBody SendMsgBo sendMsgBo) {

    // 参数检验
    String senderUserId = sendMsgBo.getSendUserId();
    String receiverUserId = sendMsgBo.getReceivUserId();
    String content = sendMsgBo.getContent();
    String msgType = sendMsgBo.getType();

    // 保存消息

    // 判断 是否在线

    // 组装 消息对象
    Message message = new Message();
    message.setSender(senderUserId);
    message.setReceiver(receiverUserId);
    message.setContent(content);
    message.setMsgType(msgType);

    // 转换发送对象
    TextWebSocketFrame text = messageConversionTextWebSocket(message);

    //  发送消息
    Channel receiverChannel = ConnPool.query(receiverUserId);
    Future future = receiverChannel.writeAndFlush(text);

    future.addListener(new ChannelFutureListener() {
      @Override
      public void operationComplete(ChannelFuture future) throws Exception {
        if (future.isSuccess()) {
          // 发送响应
          logger.info("个人消息(online) " + senderUserId + "-->" + receiverUserId + " 成功");
        } else { // 重发
          logger.info("个人消息(online) " + senderUserId + "-->" + receiverUserId + " 失败");
        }
      }
    });

    return "ok";
  }

  private TextWebSocketFrame messageConversionTextWebSocket(Message message) {

    if ("TextElem".equals(message.getMsgType())) {
      SendMsgPayload sendMsgPayload = SendMsgPayload.newBuilder()
          .setFromAccount(message.getSender().toString())
          .setToAccount(message.getReceiver().toString())
          .setMsgTimeStamp(System.currentTimeMillis() / 1000)
          .setMsgBodys(
              MsgBodys.newBuilder().setElement(
                  MsgElement.newBuilder()
                      .setMsgContent(
                          TextMsgContent.newBuilder()
                              .setText(message.getContent())
                              .build()).build()
              ).build()
          ).build();
      return new TextWebSocketFrame(sendMsgPayload.toString());
    }

    return new TextWebSocketFrame("");
  }
}
