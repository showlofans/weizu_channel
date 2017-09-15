<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/H-ui.admin.css" />
<!-- <link href="/view/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />  -->
<link href="/view/static/h-ui.admin/css/login.css" rel="stylesheet" type="text/css" />
<link href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<style type="text/css">
	 /* body{ text-align:center}  */
/* .sorry{ margin:0 auto; width:600px; height:300px; vertical-align: middle; border:1px solid #F00}  */

/* .sorry{
width:600px;
height:220px;
background:url(../images/bj_zhuce.jpg) no-repeat top center;
color:#fff;
font-size:40px;
font-family:"Comic Sans MS", cursive;
text-align:center;
line-height:220px;
} */
</style>
<title>后台登录 - 维族通道系统</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
	<div class="loginWraper">
  <div id="loginform" class="loginBox">
  <h3 class="title">欢迎登陆</h3> 
    <form class="form form-horizontal" id="lgForm" action="/flowsys/agency/login.do" method="post">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
        	<input id="userName" value="${loginMap.userName }" required name="userName"  style="width:350px;"  autocomplete="off" type="text" placeholder="账户" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input id="userPass" value="${loginMap.userPass }" required name="userPass"  style="width:350px;"  autocomplete="off" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input name="" type="submit" class="btn btn-default radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="button" onclick="startRegister()"  class="btn btn-success radius size-L" value="&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">Copyright 你的公司名称 by 南昌微族<!-- <a href="http://www.mycodes.net/" target="_blank">源码之家</a> --></div>
	<%-- <div class="aa">
	<div class="sorry">
	<h3>欢迎登陆</h3> 
	<form class="form form-horizontal" id="lgForm" action="/flowsys/agency/login.do" method="post">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">用户名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input id="userName" value="${loginMap.userName }" required name="userName"  style="width:350px;"  autocomplete="off" type="text" placeholder="用户名" class="input-text">
				<!-- <input type="text" class="input-text"  style="width:350px;" required value="" placeholder="输入新密码" id="enterPass" name="enterPass"> -->
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input id="userPass" value="${loginMap.userPass }" required name="userPass"  style="width:350px;"  autocomplete="off" type="text" placeholder="用户名" class="input-text">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<!-- <button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button> -->
				 <input class="btn btn-primary radius" type="submit" value="&nbsp;登陆&nbsp;">
				 <input class="btn btn-primary radius" onclick="startRegister()" type="button" value="&nbsp;注册&nbsp;">
			</div>
		</div>
	</form>
	</div>
	<div class="footer">Copyright 维族科技<!--  by <a href="http://www.mycodes.net/" target="_blank">源码之家</a> --></div>
	</div> --%>
<%-- <body class="login_bj">
<div class="zhuce_body">
    <div class="zhuce_kong">
    	<div class="zctwo">
        	<div class="bj_bai">
            <h3>欢迎登陆</h3> 
            <c:if test="${not empty loginMap.msg}">
       	  	  		<br><span id="errorMsg" style="color:red;">${loginMap.msg}</span>
       	  	  	</c:if>
       	  	  <form class="form form-horizontal" id="lgForm" action="/flowsys/agency/login.do" method="post">
                <input id="userName" value="${loginMap.userName }" required name="userName"  autocomplete="off" type="text" placeholder="用户名" class="kuang_txt phone input-text size-L">
                <input id="userPass" name="userPass" value="${loginMap.userPass }" required autocomplete="off" type="text" placeholder="密码" class="kuang_txt possword input-text size-L">
              		 <input class="btn_zhuce" type="submit" value="&nbsp;登陆&nbsp;">
              		 <!-- <a href="/flowsys/agency/register_page.do"> -->
              		 <input class="btn_login" onclick="startRegister()" type="button" value="&nbsp;注册&nbsp;">
              		 <!-- </a> -->
                </form>
            </div>
        </div>
    </div>
</div> --%>

<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
function startRegister(){
	var userName = $('#userName').val();
	var userPass = $('#userPass').val();
	window.location.href = "/flowsys/agency/register_page.do?userName="+userName+"&userPass="+userPass;
}
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
	    $("#lgForm").validate({
	    	/* $.ajax({
	               type:"post",
	               url:"/flowsys/rate/bind_channel.do",
	               data: $('form').serialize(),//表单数据
	               async : false,
	               success:function(d){
	            	   //alert(d);
	                   if(d=="success"){
	                        layer.msg('保存成功！');//保存成功提示
	                       removeIframe();
	                   }
	                   if(d=="error"){
	                       layer.msg('保存异常!');
	                   }
	                   if(d=="hasScope"){
	                	  layer.msg('保存异常,已经添加过该地区折扣了!');
	                	 //removeIframe();
	                   }
	               },
 			 "error":function(msg){
		        	alert(msg);
		         } 
	    });*/
	});})
</script>
</body>
</html>