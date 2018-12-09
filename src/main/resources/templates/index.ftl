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
  <h1>QFT</h1>
  <br />
  X-Auth-Token: <input type="text" id='token1' />
  <#if isRunning >
    <button id='start' value="1" >暂停</button>
  <#else>
    <button id='start' value="2" >开始</button>
  </#if>
  <br/>

  <#--用户名： <input type="text" id="userNane" value="黄晓安"/>
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

  <br />-->
</form>
</body>
<script src="/static/jquery-min.js"></script>

<script type="text/javascript">
  $(document).ready(function () {

    $("#start").click(function () {
      var type = $("#start").attr("value");
      var token = $("#token1").val();

      $.ajax({
        type: "GET",
        url: "/start.json?type="+ type + "&token=" + token,

        dataType: "text",
        success: function(data){
          window.location.reload();
        }
      });

    });
  });
</script>
</html>
