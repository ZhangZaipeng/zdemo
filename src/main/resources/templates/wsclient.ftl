<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>Web sockets test</title>
    <style type="text/css">
        .container {
            font-family: "Courier New";
            width: 680px;
            height: 300px;
            overflow: auto;
            border: 1px solid black;
        }
        .LockOff {
            display: none;
            visibility: hidden;
        }
        .LockOn {
            display: block;
            visibility: visible;
            position: absolute;
            z-index: 999;
            top: 0px;
            left: 0px;
            width: 1024%;
            height: 768%;
            background-color: #ccc;
            text-align: center;
            padding-top: 20%;
            filter: alpha(opacity=75);
            opacity: 0.75;
        }
    </style>

</head>
<body>
    <div id="skm_LockPane" class="LockOff"></div>
    <form id="form1" runat="server">
      <h1>Web Socket 聊天室</h1>
      <br />

      <div> 按下连接按钮，会通过WebSocket发起一个到聊天浏览器的连接。</div>

      服务器地址: <input type="text" id="Connection" />
      <button id='ToggleConnection' type="button" onclick='ToggleConnectionClicked();'>连接</button>
      <br/>
      用户名： <input type="text" id="userNane" value="黄晓安"/>
      <br/>
      用户名ID： <input type="text" id="sendUserId" value="101"/>
      <br/>
      发送人Id： <input type="text" id="receivUserId" value="102"/>
      <br/>

      <br />

      <div id='LogContainer' class='container'>

      </div>
      <br />

      <div id='SendDataContainer'>
        <input type="text" id="DataToSend" size="88" />
        <button id='SendData' type="button">发送</button>
      </div>

      <br />
    </form>
</body>
<script src="/static/js/jquery-min.js" type="text/javascript"></script>

<script type="text/javascript">
  var ws;
  var SocketCreated = false;
  var isUserloggedout = false;

  function lockOn(str) {
    var lock = document.getElementById('skm_LockPane');
    if (lock)
      lock.className = 'LockOn';
    lock.innerHTML = str;
  }

  function lockOff() {
    var lock = document.getElementById('skm_LockPane');
    lock.className = 'LockOff';
  }

  // 连接函数
  function ToggleConnectionClicked() {
    if (SocketCreated && (ws.readyState == 0 || ws.readyState == 1)) {
      lockOn("离开聊天室...");
      SocketCreated = false;
      isUserloggedout = true;
      ws.close();
    } else {
      lockOn("进入聊天室...");
      Log("准备连接到聊天服务器 ...");
      try {
        if ("WebSocket" in window) {
          ws = new WebSocket("ws://" + document.getElementById("Connection").value);
        }
        else if("MozWebSocket" in window) {
          ws = new MozWebSocket("ws://" + document.getElementById("Connection").value);
        }

        SocketCreated = true;
        isUserloggedout = false;
      } catch (ex) {
        Log(ex, "ERROR");
        return;
      }

      document.getElementById("ToggleConnection").innerHTML = "断开";
      ws.onopen = WSonOpen;
      ws.onmessage = WSonMessage;
      ws.onclose = WSonClose;
      ws.onerror = WSonError;
    }
  };


  function WSonOpen() {
    lockOff();
    Log("连接已经建立。", "OK");
    $("#SendDataContainer").show();
    // 首次 需要发送 认证操作
    var auth = new Object();
    auth.userId = $("#sendUserId").val();
    auth.sig = "hahaha";

    ws.send(JSON.stringify(auth));
    // ws.send("login:" + document.getElementById("txtName").value);
  };

  /**
   * ws 接受到回调
   */
  function WSonMessage(event) {
    parseMessage(event.data);
  };

  function WSonClose() {
    lockOff();
    if (isUserloggedout)
      Log("【"+document.getElementById("txtName").value+"】离开了聊天室！");
    document.getElementById("ToggleConnection").innerHTML = "连接";
    $("#SendDataContainer").hide();
  };

  function WSonError() {
    lockOff();
    Log("远程连接中断。", "ERROR");
  };


  // 解析 服务器消息
  function parseMessage(Text) {

  }

  function Log(Text, MessageType) {

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


    if (MessageType == "OK") { Text = "<span style='color: green;'>" + Text + "</span>";}
    if (MessageType == "ERROR") { Text = "<span style='color: red;'>" + Text + "</span>";}

    document.getElementById("LogContainer").innerHTML =
        document.getElementById("LogContainer").innerHTML + Text + "<br />";

    var LogContainer = document.getElementById("LogContainer");

    LogContainer.scrollTop = LogContainer.scrollHeight;
  };

  $(document).ready(function () {

    $("#SendDataContainer").hide();
    var WebSocketsExist = true;
    try {
      var dummy = new WebSocket("ws://localhost:8989/test");
    } catch (ex) {
      try {
        webSocket = new MozWebSocket("ws://localhost:8989/test");
      } catch(ex) {
        WebSocketsExist = false;
      }
    }

    if (WebSocketsExist) {
      Log("您的浏览器支持WebSocket. 您可以尝试连接到聊天服务器!", "OK");
      document.getElementById("Connection").value = "127.0.0.1:18999/ws";
    } else {
      Log("您的浏览器不支持WebSocket。请选择其他的浏览器再尝试连接服务器。", "ERROR");
      document.getElementById("ToggleConnection").disabled = true;
    }

    $("#DataToSend").keypress(function(evt) {
      if (evt.keyCode == 13) {
        $("#SendData").click();
        evt.preventDefault();
      }
    });

    // 发送消息 调用http 接口
    $("#SendData").click(function () {
      var data = $("#DataToSend").val().trim();

      if (data != "") {
        $.ajax({
          type: "POST",
          url: "/sendMsg.json",
          data: JSON.stringify({
            sendUserId: parseInt($("#sendUserId").val()) ,
            receivUserId: parseInt($("#receivUserId").val()) ,
            content: data
          }) ,
          contentType: "application/json; charset=utf-8",
          dataType: "text",
          success: function(data){
            alert(data);
            $("#DataToSend").val("");
          }
        });

      }

    });


  });
</script>
</html>

