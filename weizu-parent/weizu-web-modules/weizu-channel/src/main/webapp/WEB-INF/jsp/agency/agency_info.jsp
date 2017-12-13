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
<title>个人信息查看</title>
</head>
<body>
	<form action="" method="" class="form form-horizontal" id="form-article-add">
		<input type="hidden" value="${loginContext.id }" name="id">
		<!-- 不能修改要原样保留的数据 -->
		<input type="hidden" value="${loginContext.rootAgencyId }" name="rootAgencyId">
		<%-- <input type="hidden" value="${loginContext.rootAgencyId }" name="rootAgencyId"> --%>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>用户账户：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width:200px" value="${loginContext.userName }" placeholder="" id="userName" name="userName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">真实姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width:200px" value="${loginContext.userRealName }" placeholder="" id="userRealname" name="userRealName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>联系电话：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				 <input type="text" class="input-text" style="width:200px" value="${loginContext.agencyTel }" placeholder="" id="agencyTel" name="agencyTel">
		 	</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">电子邮箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width:200px" value="${loginContext.userEmail }" placeholder="" id="userEmail" name="userEmail">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">用户地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" style="width:200px" class="input-text"  value="${loginContext.agencyIp }" placeholder="" id="agencyIp" name="agencyIp">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">用户其他联系方式：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" style="width:200px" class="input-text"  value="${loginContext.otherContact }" placeholder="" id="otherContact" name="otherContact">
			</div>
		</div>
		
		<c:if test="${loginContext.agencyTag == 1 }">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">对接apikey：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" style="width:200px" class="input-text" readOnly  value="${loginContext.userApiKey }" placeholder="" id="userApiKey">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">回调地址：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" style="width:200px" class="input-text"  value="${loginContext.callBackIp }" placeholder="" id="callBackIp" name="callBackIp">
				</div>
			</div>
		</c:if>
		
		<div class="row cl">
			<span class="verifyCodeHidden" style="display:none">${loginContext.verifyCode }</span>
			<label class="form-label col-xs-4 col-sm-2">注册邀请码：<br></label>
			<div class="formControls col-xs-8 col-sm-9">
				<!-- 重新生成 -->
				<div class="verifyDiv"  style="display:none">
					生成<select id="verifySize" class="select"  style="width:50px">
					<c:forEach begin="4" end="10" var="verifySize">
						<option value="${verifySize }">${verifySize }</option>
					</c:forEach>
					</select>邀请码
					<!-- <input id="verifySize"  style="width:200px" maxlength="2" onkeyup='this.value=this.value.replace(/\D/gi,"")' class="input-text"  placeHolder="请输入要生成几位邀请码"> -->
					<!-- <span  data-toggle="tooltip" data-placement="right" title="选择生成几位数的邀请码"><i class="Hui-iconfont">&#xe6cd;</i></span> -->
					<a onclick="getVerifyCode(1)"><button class="btn btn-primary radius" >生成</button></a>
					<a onclick="getVerifyCode(2)"><button class="btn btn-primary radius" >ID生成</button></a>
				</div>
				<!-- 直接获取 -->
				<input type="text" style="width:200px" class="input-text" onkeyup="checkVerify()"  value="${loginContext.verifyCode }" placeholder="" id="verifyCode" name="verifyCode">
				<br>（编辑可重新生成）
				 <button id="copy-button" class="btn btn-primary" data-clipboard-text="Copy Me!" title="Click to copy me." data-clipboard-target="verifyCode">复制</button>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit" onclick="save()"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button class="btn btn-primary radius" onClick="removeIframe()">取消</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>  
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="/view/clipboard/ZeroClipboard.js"></script>  
<script type="text/javascript">
var client = new ZeroClipboard(document.getElementById("copy-button"));

client.on("ready", function(readyEvent) {
	client.on("aftercopy", function(event) {
		alert("已复制到剪贴板 " + event.data["text/plain"]);
	});
});
////看邀请码码是否改变
function checkVerify() {
	var isVer = confirm("需要重新生成邀请码？");
	if(isVer){
		$("#verifyCode").hide();
		$("#copy-button").hide();
		$(".verifyDiv").show(); 
	}
	else{
		$("#verifyCode").val($(".verifyCodeHidden").html().trim())
	}
}
//生成按钮，发送获得邀请码的ajax请求
function getVerifyCode(tagVer){
	if(tagVer == 1){
		var verifySize = $("#verifySize").val();
		if(verifySize < 4){
			alert("邀请码不能低于四位");
		}else{
			$.ajax({
		        type:"get",
		        url:"/flowsys/agency/get_verify_code.do?verifySize=" + verifySize,
		        async : false,
		        success:function(d){
			        	//alert(d);
			        	if(d != '初始化邀请码失败！'){
				        	 $("#verifyCode").show();
				        	$("#verifyCode").val(d);//将邀请码填进编辑框
				        	layer.msg("修改成功！");
			        	}
			        	//var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
			        	//parent.layer.close(index); ////执行关闭
			        	//$(".verifyDiv").hide(); 
		        }
		    });
		}
	}else if(tagVer == 2){
		$.ajax({
	        type:"get",
	        url:"/flowsys/agency/get_verify_code.do",
	        async : false,
	        success:function(d){
		        	//alert(d);
		        	if(d != '初始化邀请码失败！'){
			        	 $("#verifyCode").show();
			        	$("#verifyCode").val(d);//将邀请码填进编辑框
			        	layer.msg("修改成功！");
		        	}
		        	//var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
		        	//parent.layer.close(index); ////执行关闭
		        	//$(".verifyDiv").hide(); 
	        }
	    });
	}
}

///更新信息
function save(){
	var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	//alert(index);
	
	$.ajax({
        type: "post",
        data: $('form').serialize(),//表单数据
        url:"/flowsys/agency/agency_edit.do",
        async : false,
        success:function(d){
        	//alert(d);
            if(d == 'success'){
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