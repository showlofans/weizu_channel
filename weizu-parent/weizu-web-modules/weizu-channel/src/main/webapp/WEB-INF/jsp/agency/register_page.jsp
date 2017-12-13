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
 <link href="/view/static/h-ui.admin/css/register.css" rel="stylesheet" type="text/css" /> 
 <!-- <link href="/view/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" /> -->
<link href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>用户注册-微族通道系统</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<!-- <body class="login_bj"> -->
<body style="overflow:hidden;">
<div class="loginWraper">
  <div id="loginform" class="loginBox">
  <c:choose>
  	<c:when test="${not empty resultMap.msg}">
	  <h3 class="title c-red">${resultMap.msg }</h3> 
  	</c:when>
  	<c:otherwise>
  		<h3 class="title">欢迎注册</h3> 
  	</c:otherwise>
  </c:choose>
    <form class="form form-horizontal" id="regForm" action="/flowsys/agency/register.do" method="post">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe6cb;</i></label>
        <div class="formControls col-xs-8">
             <input id="verifyCode" name="verifyCode" value="${resultMap.reg.verifyCode }" required  autocomplete="off" type="text" placeholder="注册邀请码(最少四位)" class="input-text size-L">
             <!-- <input id="verifyCode" name="verifyCode" value="" type="hidden"> --><!--  onblur="testHas()" -->
             <%-- <c:if test="${not empty resultMap.msg}">
    	  	  		<span id="errorMsg" style="color:red;" >${resultMap.msg}</span>
    	  	  	</c:if> --%>
        </div>
      </div>
      <div class="row cl" >
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
        	<input id="userName" value="${loginMap.userName }" required name="userName"  autocomplete="off" type="text" placeholder="账户" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
        	<input id="userPass" name="userPass"  value="${resultMap.reg.userPass }" type="text" required class="input-text size-L" placeholder="密码" >
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe602;</i></label>
        <div class="formControls col-xs-8">
        	<input id="userRealName" value="${resultMap.reg.userRealName }" name="userRealName" required  autocomplete="off" type="text" placeholder="真实姓名" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe6c7;</i></label>
        <div class="formControls col-xs-8">
               <input id="agencyTel" name="agencyTel" value="${resultMap.reg.agencyTel }" required  autocomplete="off" type="text" placeholder="联系电话" class="input-text size-L">
        </div>
      </div>
      <%-- <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe67b;</i></label>
        <div class="formControls col-xs-8">
               <input id="otherContact" name="otherContact" value="${resultMap.reg.otherContact }"  autocomplete="off" type="text" placeholder="qq号,可不填" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe68a;</i></label>
        <div class="formControls col-xs-8">
                <input id="userEmail" name="userEmail" value="${resultMap.reg.userEmail }"  autocomplete="off" type="email" placeholder="电子邮箱,可不填" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe6f1;</i></label>
        <div class="formControls col-xs-8">
                <input id="agencyIp" name="agencyIp" value="${resultMap.reg.agencyIp }"  autocomplete="off" type="text"  placeholder="用户首页地址,可不填" class="input-text size-L">
        </div>
      </div> --%>
      
               
      <%-- <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input id="userPass" value="${loginMap.userPass }" required name="userPass"   autocomplete="off" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div> --%>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input id="goLogin" onclick="startLogin()" class="btn btn-default radius size-L" type="button" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input id="goRegist" class="btn btn-success radius size-L" type="submit" value="&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;">
          <!-- <input name="" type="submit" class="btn btn-default radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input id="goRegist" onclick="startLogin()" class="btn_login" type="button" value="&nbsp;登陆&nbsp;">
          <input name="" type="button" onclick="startRegister()"  class="btn btn-success radius size-L" value="&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;"> -->
         <!--  <br>Copyright 南昌微族 by 南昌微族 -->
        </div>
      </div>
    </form>
  </div>
  
</div>
<!-- <a href="http://www.mycodes.net/" target="_blank">源码之家</a> -->
 <%-- <div class="zhuce_body">
    <div class="zhuce_kong">
    	<div class="zc">
        	
        	<div class="bj_bai">
            <h3>欢迎注册</h3>
       	  	  <form class="form form-horizontal" id="regForm" action="/flowsys/agency/register.do" method="post">
       	  	  	<input id="userName" name="userName" value="${resultMap.reg.userName }" required type="text" autocomplete="off"  placeholder="账户" class="kuang_txt phone input-text size-L"">
                <input id="userPass" name="userPass"  value="${resultMap.reg.userPass }" type="text" class="kuang_txt possword input-text size-L"" placeholder="密码" >
                <input id="userRealName" value="${resultMap.reg.userRealName }" name="userRealName" required  autocomplete="off" type="text" placeholder=" 真实姓名" class="kuang_txt phone input-text size-L">
               <input id="agencyTel" name="agencyTel" value="${resultMap.reg.agencyTel }" required  autocomplete="off" type="text" placeholder="联系电话" class="kuang_txt phone input-text size-L">
               <input id="otherContact" name="otherContact" value="${resultMap.reg.otherContact }" required  autocomplete="off" type="text" placeholder="其他联系方式：qq号" class="kuang_txt phone input-text size-L">
                <input id="userEmail" name="userEmail" value="${resultMap.reg.userEmail }" required  autocomplete="off" type="email" placeholder="电子邮箱" class="kuang_txt emailt input-text size-L">
                <input id="agencyIp" name="agencyIp" value="${resultMap.reg.agencyIp }" required  autocomplete="off" type="text"  placeholder=" 用户地址" class="kuang_txt phone input-text size-L">
                <input id="verifyCode" name="verifyCode" value="${resultMap.reg.verifyCode }" required  autocomplete="off" type="text" placeholder="注册邀请码" class="kuang_txt	 yanzm input-text size-L"><c:if test="${not empty resultMap.msg}">
       	  	  		<span id="errorMsg" style="color:red;" >${resultMap.msg}</span>
       	  	  	</c:if>
                <!-- <input name="" type="text" class="kuang_txt yanzm" placeholder="验证码"> -->
               <!--  <div>
                	<div class="hui_kuang"><img src="/view/static/h-ui.admin/images/zc_22.jpg" width="92" height="31"></div>
                	<div class="shuaxin"><a href="#"><img src="/view/static/h-ui.admin/images/zc_25.jpg" width="13" height="14"></a></div>
                </div> -->
               <!--  <div>
               		<input name="" type="checkbox" value=""><span>已阅读并同意<a href="#" target="_blank"><span class="lan">《XXXXX使用协议》</span></a></span>
                </div> -->
              		 <input id="goRegist" class="btn_zhuce" type="submit" value="&nbsp;注册&nbsp;">
              		 <!-- <a href="/flowsys/agency/login_page.do"> -->
              		 <input id="goRegist" onclick="startLogin()" class="btn_login" type="button" value="&nbsp;登陆&nbsp;">
              		 <!-- </a> -->
                </form>
            </div>
        </div>
    </div>

</div> --%>
<!-- <div class="footer">Copyright 维族科技 by <a href="http://www.mycodes.net/" target="_blank">源码之家</a></div> -->
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
/**跳转登陆页面*/
function startLogin(){
	var userName = $('#userName').val();
	var userPass = $('#userPass').val();
	window.location.href = "/flowsys/agency/login_page.do?userName="+userName+"&userPass="+userPass;
}
//测试邀请码是否存在
function testHas(){
	var thisVal = $('#verifyCode').val();
	if(thisVal == '' || thisVal.length < 4){//邀请码长度
		$('#verifyCode').val('');
		alert('不合法的邀请码');
		//layer.msg('不为空');
	}
	
	//ajax请求设置正确的thisVal,
}
	$().ready(function() {
		//$('#verifyCode').focus();
	    $("#regForm").validate({
	    	rules:{
	    		verifyCode : {
	    			required:true
	    		},
	    		userName : {
		    			remote:{//验证用户名是否存在
		    				  type:"get",
		    	               url:"/flowsys/agency/register_check_name.do",             //servlet
		    	               data:{
		    	            	  userName :function(){return $("#userName").val().trim();}
		    			}
	    			}
	    		},
	    		verifyCode : {
	    			remote:{//验证用户名是否存在
	    				  type:"get",
	    	               url:"/flowsys/agency/register_check_code.do",             //servlet
	    	               data:{
	    	            	   verifyCode :function(){return $("#verifyCode").val().trim();}
			    			}
		    			}
		    		}
	    	},
	    	messages:{
	    		userName:{ remote:jQuery.format("用户名已经被注册")},
	    		verifyCode:{ remote:jQuery.format("邀请码不存在")}
	    	}
	    });
	});
</script>
</body>
</html>