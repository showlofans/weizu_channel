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
</div>
<div class="footer">Copyright 维族科技<!--  by <a href="http://www.mycodes.net/" target="_blank">源码之家</a> --></div>
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