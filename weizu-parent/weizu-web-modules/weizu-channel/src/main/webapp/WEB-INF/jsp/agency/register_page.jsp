<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>用户注册 - 维族通道系统</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body class="login_bj">

<div class="zhuce_body">
    <div class="zhuce_kong">
    	<div class="zc">
        	<div class="bj_bai">
            <h3>欢迎注册</h3>
       	  	  <form class="form form-horizontal" id="regForm" action="/flowsys/agency/register.do" method="post">
       	  	  	<input id="userName" name="userName" required type="text" autocomplete="off"  placeholder="账户" class="kuang_txt phone input-text size-L"">
       	  	  	<c:if test="${not empty resultMap.msg}">
       	  	  		<br><span id="errorMsg" style="color:red;">${resultMap.msg}</span>
       	  	  	</c:if>
                <input name="userPass"  value="${resultMap.reg.userPass }" type="text" class="kuang_txt possword input-text size-L"" placeholder="密码" >
                <input id="userRealName" value="${resultMap.reg.userRealName }" name="userRealName" required  autocomplete="off" type="text" placeholder=" 真实姓名" class="kuang_txt phone input-text size-L">
               <input id="agencyTel" name="agencyTel" value="${resultMap.reg.agencyTel }" required  autocomplete="off" type="text" placeholder="联系电话" class="kuang_txt phone input-text size-L">
               <input id="otherContact" name="otherContact" value="${resultMap.reg.otherContact }" required  autocomplete="off" type="text" placeholder="其他联系方式：qq号" class="kuang_txt phone input-text size-L">
                <input id="userEmail" name="userEmail" value="${resultMap.reg.userEmail }" required  autocomplete="off" type="email" placeholder="电子邮箱" class="kuang_txt emailt input-text size-L">
                <input id="agencyIp" name="agencyIp" value="${resultMap.reg.agencyIp }" required  autocomplete="off" type="text"  placeholder=" 用户地址" class="kuang_txt emailt input-text size-L">
                <input id="verifyCode" name="verifyCode" value="${resultMap.reg.verifyCode }" required  autocomplete="off" type="text" placeholder="注册邀请码" class="kuang_txt	 yanzm input-text size-L">
                
                <!-- <input name="" type="text" class="kuang_txt yanzm" placeholder="验证码"> -->
               <!--  <div>
                	<div class="hui_kuang"><img src="/view/static/h-ui.admin/images/zc_22.jpg" width="92" height="31"></div>
                	<div class="shuaxin"><a href="#"><img src="/view/static/h-ui.admin/images/zc_25.jpg" width="13" height="14"></a></div>
                </div> -->
               <!--  <div>
               		<input name="" type="checkbox" value=""><span>已阅读并同意<a href="#" target="_blank"><span class="lan">《XXXXX使用协议》</span></a></span>
                </div> -->
              		 <input id="goRegist" class="btn_zhuce" type="submit" value="&nbsp;注册&nbsp;">
              		 <a href="/flowsys/agency/login_page.do"><input id="goRegist" class="btn_login" type="button" value="&nbsp;登陆&nbsp;"></a>
                </form>
            </div>
        </div>
    </div>

</div>
<!-- <input type="hidden" id="TenantId" name="TenantId" value="" /> -->
<!-- <div class="header"></div> -->
<%-- <div class="loginWraper">
  <div id="registerform" class="loginBox">
    <form class="form form-horizontal" id="regForm" action="register.do" method="post">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i>账户</label>
        <div class="formControls col-xs-8">
          <input id="userName" name="userName" required type="text" autocomplete="off"  placeholder="账户" class="input-text size-L">
        </div>
      </div>
      <!-- 用户密码 -->
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i>密码</label>
        <div class="formControls col-xs-8">
          <input id="userPass" name="userPass" required  autocomplete="off" style="width:300px;" type="text" onfocus="this.type='password'"placeholder="密码" class="input-text size-L">
        </div>
      </div>
      <!-- 真实姓名 -->
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i> 真实姓名</label>
        <div class="formControls col-xs-8">
          <input id="userRealname" name="userRealname" required  autocomplete="off" style="width:300px;" type="text"placeholder=" 真实姓名" class="input-text size-L">
        </div>
      </div>
      <!-- 联系电话 -->
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i>联系电话</label>
        <div class="formControls col-xs-8">
          <input id="agencyTel" name="agencyTel" required  autocomplete="off" style="width:300px;" type="text"placeholder="联系电话" class="input-text size-L">
        </div>
      </div>
      <!-- 电子邮箱 -->
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i>电子邮箱</label>
        <div class="formControls col-xs-8">
          <input id="userEmail" name="userEmail" required  autocomplete="off" style="width:300px;" type="text"placeholder="电子邮箱" class="input-text size-L">
        </div>
      </div>
      <!-- 用户地址-->
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i> 用户地址</label>
        <div class="formControls col-xs-8">
          <input id="agencyIp" name="agencyIp" required  autocomplete="off" style="width:300px;" type="text"placeholder=" 用户地址" class="input-text size-L">
        </div>
      </div>
      <!-- 注册邀请码-->
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i>注册邀请码</label>
        <div class="formControls col-xs-8">
          <input id="verifyCode" name="verifyCode" required  autocomplete="off" style="width:300px;" type="text"placeholder="注册邀请码" class="input-text size-L">
        </div>
      </div>
      <input type="hidden" name="rootAgencyId" value="#{rootAgencyId }">
      <!-- <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input class="input-text size-L" type="text" placeholder="验证码" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width:150px;">
          <img src=""> <a id="kanbuq" href="javascript:;">看不清，换一张</a> </div>
      </div> -->
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
       		<a href="loginPage.do" class="btn btn-success radius size-L"> 登陆</a>
          	<input id="goRegist" class="btn btn-success radius size-L" type="submit" value="&nbsp;注册&nbsp;">
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
	/* $.validator.setDefaults({
	    submitHandler: function() {
	      $("#regForm").submit();
	    }
	}); */
/* function formVali(){
		alert($("#errorMsg").is(":visible"));
	return $("#errorMsg").is(":visible");
} */
	$().ready(function() {
	    $("#regForm").validate({
	    	rules:{
	    		userName : {
		    			remote:{//验证用户名是否存在
		    				  type:"get",
		    	               url:"/flowsys/agency/register_check_name.do",             //servlet
		    	               data:{
		    	            	  userName :function(){return $("#userName").val().trim();}
		    			}
	    			}
	    		}
	    	},
	    	messages:{
	    		userName:{ remote:jQuery.format("用户名已经被注册")}
	    	}
	    });
	});
</script>
</body>
</html>