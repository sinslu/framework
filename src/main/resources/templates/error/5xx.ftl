<#assign css="http://ued.t.huijiaoyun.com/tianyu_edu_dev" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="full-screen" content="true">
    <meta name="screen-orientation" content="portrait">
    <meta name="x5-fullscreen" content="true">
    <meta charset="UTF-8">
    <title>鱼渔课堂</title>
    <link rel="stylesheet" href="${css}/touch/yy_classroom/css/base.css">
    <link rel="stylesheet" href="${css}/touch/yy_classroom/css/main.css">
    <link rel="stylesheet" href="${css}/touch/yy_classroom/css/pk_new.css">
    <script type='text/javascript' src='${css}/touch/yy_classroom/js/jquery-1.11.1.min.js' charset='utf-8'></script>
    <script>
        $.config = {
            autoInit: true //no recommend
        }
    </script>
    <script type='text/javascript' src='${css}/touch/yy_classroom/js/base.js' charset='utf-8'></script>
    <script src="${css}/touch/yy_classroom/js/i18n/cn.min.js"></script>
    <script src="${css}/touch/yy_classroom/js/touch.js"></script>
</head>
<body>
<!-- page 容器 -->
<div class="page page-gs default1" id="page">
    <header class="bar bar-nav " id="teacher">
        <a class="icon icon-left pull-left" onclick="back()"></a>
        <h1 class="title">鱼渔课堂</h1>
    </header>
    <!-- 这里是页面内容区 -->
    <div class="content">
        <div class="gs_badsysBox">
            <h2>正在排队，请稍后喔！</h2>
            <p>抱歉，由于访问人数太多导致服务器压力山大，请您耐心排队等待!</p>
            <img src="${css}/touch/yy_classroom/img/new/no_cont.png" alt="">
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    function back() {
        window.history.go(-1);
    }
    setTimeout(function(){
        window.history.go(-1);
    },5000);
</script>
</html>
