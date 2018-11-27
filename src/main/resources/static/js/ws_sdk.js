/** 全局变量 */

/* 认证 方法 */

/**************** 发送消息 http接口 **************/
/* 发送 文本消息 */

/* 发送 图片消息 */


/**************** 接受 解析 添加消息 **************/
/* 接受文本消息 添加左边一条消息 （对方的）*/
/* 接受文本消息 添加右边一条消息（自己的） */


/* 监听新消息事件 */
/* 显示历史消息 */
/* 检查文件类型和大小 */

/**
 {
  "FromAccount": "from",
    "ToAccount": "to",
    "MsgRandom": 123123,
    "MsgTimeStamp": 179876666,
    "MsgBody": [{
  "MsgType": "TxtElem",
  "MsgContent": {
    "Data": "data",
    "Desc": "desc",
    "Ext": "ext",
    "Sound": "sound"
  }
}]
}
 */

// 解析 服务器消息
function parseMessage(Text) {
  var msg = JSON.parse(Text);

  // 发送者
  var FromAccount = msg.FromAccount;
  // 接受者
  var ToAccount = msg.ToAccount;

  // 消息体
  // 第一个节点是 消息数据
  // 第二个节点是 业务数据
  var boys = msg.MsgBody
  var msgNode = boys[0];
  var busNode = boys[1];
}


