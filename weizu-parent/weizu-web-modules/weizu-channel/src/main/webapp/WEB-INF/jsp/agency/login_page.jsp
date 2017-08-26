<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link href="/view/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="/view/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="/view/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>后台登录 - 维族通道系统</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body class="login_bj">
<div class="zhuce_body">
    <div class="zhuce_kong">
    	<div class="zctwo">
        	<div class="bj_bai">
            <h3>欢迎登陆 xiao</h3> 
       	  	  <form class="form form-horizontal" id="lgForm" action="/flowsys/agency/login.do" method="post">
                <input id="userName" value="${userName }" required name="userName"  autocomplete="off" type="text" placeholder="xiao" class="kuang_txt phone input-text size-L">
                <input id="" name="userPass" value="${userPass }" required autocomplete="off" type="text" placeholder="xiao" class="kuang_txt possword input-text size-L">
                <!-- <input name="" type="text" class="kuang_txt yanzm" placeholder="验证码"> -->
               <!--  <div>
                	<div class="hui_kuang"><img src="/view/static/h-ui.admin/images/zc_22.jpg" width="92" height="31"></div>
                	<div class="shuaxin"><a href="#"><img src="/view/static/h-ui.admin/images/zc_25.jpg" width="13" height="14"></a></div>
                </div> -->
               <!--  <div>
               		<input name="" type="checkbox" value=""><span>已阅读并同意<a href="#" target="_blank"><span class="lan">《XXXXX使用协议》</span></a></span>
                </div> -->
              		 <input class="btn_zhuce" type="submit" value="&nbsp;登陆&nbsp;">
              		 <a href="/flowsys/agency/register_page.do"><input class="btn_login" type="button" value="&nbsp;注册&nbsp;"></a>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- <input type="hidden" id="TenantId" name="TenantId" value="" /> -->
<!-- <div class="header"></div> -->
<%-- <div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" id="lgForm" action="goLogin.do" method="post">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i>账号</label>
        <div class="formControls col-xs-8">
          <input id="" required name="userName" autocomplete="off" type="text" placeholder="xiao" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i>密码</label>
        <div class="formControls col-xs-8">
          <input id="" name="userPass" required autocomplete="off" type="text" onfocus="this.type='password'" placeholder="xiao" class="input-text size-L">
          <br><span style="color:yellow">${msg }</span>
        </div>
      </div>
      <!-- <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input class="input-text size-L" type="text" placeholder="验证码" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width:150px;">
          <img src=""> <a id="kanbuq" href="javascript:;">看不清，换一张</a> </div>
      </div> -->
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <label for="online">
            <input type="checkbox" name="online" id="online" value="">
            使我保持登录状态</label>
            <a href="registerPage.do" class="btn btn-success radius size-L">注册</a>
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
          <!-- <input name="" type="button" class="btn btn-success radius size-L" value="&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;"> -->
        </div>
      </div>
    </form>
  </div>
</div> --%>
<div class="footer">Copyright 维族科技<!--  by <a href="http://www.mycodes.net/" target="_blank">源码之家</a> --></div>
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
/* 	$.validator.setDefaults({
	    submitHandler: function() {
	    	$("#lgForm").submit();
	    }
	}); */
	function checkName() {
		var userName = $("#userName").val().trim();
		/* $.ajax({
	        type:"get",
	        url:"getVerifyCode.do?verifySize=" + verifySize,
	        async : false,
	        success:function(d){
		        	//alert(d);
		        	 $("#verifyCode").show();
		        	$("#verifyCode").val(d);//将邀请码填进编辑框
		        	//$(".verifyDiv").hide(); 
	        }
	    }); */
	}
	$().ready(function() {
	    $("#lgForm").validate();
	});
</script>
</body>
</html>