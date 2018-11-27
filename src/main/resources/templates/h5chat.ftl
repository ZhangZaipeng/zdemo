<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<!-- 禁止页面缩放 -->
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>聊天界面H5</title>
<link rel="stylesheet" href="/static/css/mui.css" />
<link rel="stylesheet" href="/static/css/react.css" />
<link rel="stylesheet" href="/static/css/index.css" />
<link rel="stylesheet" href="/static/css/h5chat.css" />
</head>

<body>
	<textarea id="data" style="display: none;">${data}</textarea>
<!-- 	<header class="header">
		<a class="back" href="javascript:history.back()"></a>
		<h5 class="tit"></h5>
		<div class="right">资料</div>
	</header>  -->
	<div class="imMessageBox imMessageBoxH5" id="imMessageCenterBox">
	</div>
	<section class="footer">
		<section id="boxNav" class="inputBoxBar">	
			<input type="text" id="messageBodyh5" value=""/> 
			<img src="/static/images/photo.png" id="mediaIcon" alt="" />
			 <div class="uploadImg_wrapper" style="display: none"><input type="file" name="file" accept="image/*" id="cameraFile" onchange="uploadPic(this)" ></div>

			<input type="submit" id="sendMessage" class="sendMessage" value="发送">
		</section>
	</section>
	<footer class="promptBar" style="display: none">问诊已结束</footer>
</body>
<!--工具类-->
<script src="/static/js/jquery-min.js"></script>
<script src="/static/js/flexible.js"></script>
<script src="https://cdn.webrtc-experiment.com/MediaStreamRecorder.js"> </script>
<script src="/static/js/moment.min.js"></script>
<script src="/static/js/tool.js"></script>
</html>
