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


