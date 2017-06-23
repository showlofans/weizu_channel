<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/view/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/flowsys/agency/agency_edit.do" method="post" class="form form-horizontal" id="form-article-add">
		<input type="hidden" value="${loginContext.id }" name="id">
		<!-- 不能修改要原样保留的数据 -->
		<input type="hidden" value="${loginContext.rootAgencyId }" name="rootAgencyId">
		<%-- <input type="hidden" value="${loginContext.rootAgencyId }" name="rootAgencyId"> --%>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>用户账户：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${loginContext.userName }" placeholder="" id="userName" name="userName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">真实姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${loginContext.userRealName }" placeholder="" id="userRealname" name="userRealName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>联系电话：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				 <input type="text" class="input-text" value="${loginContext.agencyTel }" placeholder="" id="agencyTel" name="agencyTel">
		 	</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">电子邮箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${loginContext.userEmail }" placeholder="" id="userEmail" name="userEmail">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">用户地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" style="width:200px" class="input-text"  value="${loginContext.agencyIp }" placeholder="" id="agencyIp" name="agencyIp">
			</div>
		</div>
		
		<div class="row cl">
			<span class="verifyCodeHidden" style="display:none">${loginContext.verifyCode }</span>
			<label class="form-label col-xs-4 col-sm-2">注册邀请码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<!-- 重新生成 -->
				<div class="verifyDiv"  style="display:none">
					<input id="verifySize"  style="width:200px" maxlength="2" onkeyup='this.value=this.value.replace(/\D/gi,"")' class="input-text"  placeHolder="请输入要生成几位邀请码">
					<a onclick="getVerifyCode()"><button class="btn btn-primary radius" >生成</button></a>
				</div>
				<!-- 直接获取 -->
				<input type="text" style="width:200px" class="input-text" onkeyup="checkVerify()"  value="${loginContext.verifyCode }" placeholder="" id="verifyCode" name="verifyCode">
					
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>  
<script type="text/javascript">
////看邀请码码是否改变
function checkVerify(evt) {
	var isVer = confirm("需要重新生成验证码？");
	if(isVer){
		$("#verifyCode").hide();
		$(".verifyDiv").show(); 
	}
	else{
		$("#verifyCode").val($(".verifyCodeHidden").html().trim())
	}
}
//生成按钮，发送获得邀请码的ajax请求
function getVerifyCode(){
	var verifySize = $("#verifySize").val();
	$.ajax({
        type:"get",
        url:"/flowsys/agency/get_verify_code.do?verifySize=" + verifySize,
        async : false,
        success:function(d){
	        	//alert(d);
	        	 $("#verifyCode").show();
	        	$("#verifyCode").val(d);//将邀请码填进编辑框
	        	var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	        	parent.layer.close(index); ////执行关闭
	        	//$(".verifyDiv").hide(); 
        }
    });
}

///更新信息
function save(){
	var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	$.ajax({
        type:"post",
        url:"flowsys/agency/agency_edit.do",
        data: $('form').serialize(),//表单数据
        async : true,
        success:function(d){
        	alert(d);
            if(d>0){
                layer.msg('保存成功！');//保存成功提示
            }else{
                layer.msg('保存异常!');
            }
            parent.layer.close(index); ////执行关闭
        }
    });
}
</script>
</html>