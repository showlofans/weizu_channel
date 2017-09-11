<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/view/favicon.ico" >
<link rel="Shortcut Icon" href="/view/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/view/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>账户信息</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
	<span class="c-gray en">&gt;</span>
	账户管理
	<span class="c-gray en">&gt;</span>
	账户信息
	<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
	<!-- <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=1575326411&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:1727661035:52" alt="点击这里给我发消息" title="点击这里给我发消息"/></a> -->
	<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=${loginContext.otherContact }&site=qq&menu=yes"><img border="0" src="/view/button_111.gif" alt="点击这里给我发消息" title="点击这里给我发消息"/></a>
</nav>
<div class="page-container">
	
		<div id="tab-system" class="HuiTab">
			<div class="tabBar cl">
			<c:if test="${chargeAccount1 != null }">
				<span>高配账户</span>
			</c:if>
				<span>一般账户</span>
			</div>
			<c:if test="${chargeAccount1 != null }">
			<form class="form form-horizontal" id="form-account1-edit">
				<div class="tabCon">
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-2">账户余额：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" readonly="readonly"  class="input-text" value="${chargeAccount1.accountBalance }" id="" name="">
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-2">汇款方式：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" name="remittanceWay" required id="" value="${chargeAccount1.remittanceWay }" class="input-text">
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-2">汇款账号：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input name="remittanceBankAccount" required value="${chargeAccount1.remittanceBankAccount }" type="text" class="input-text"  id=""  >
						</div>
					</div>
					<%-- <div class="row cl">
						<label class="form-label col-xs-4 col-sm-2">账户信用额：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text"  name="accountCredit" readonly="readonly" value="${chargeAccount.accountCredit }"  class="input-text" value="5" id="emailName">
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-2">
							<span class="c-red">*</span>
							css、js、images路径配置：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" id="website-static" placeholder="默认为空，为相对路径" value="" class="input-text">
						</div>
					</div> --%>
					
					<div class="row cl">
						<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
							<button onClick="account1_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
							<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
						</div>
					</div>
					<input type="hidden" id="billType" name="billType" value="${chargeAccount1.billType }" >
				</div>
			</form>
			</c:if>
			<form class="form form-horizontal" id="form-account-edit">
			<div class="tabCon">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">账户余额：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" readonly="readonly"  class="input-text" value="${chargeAccount.accountBalance }" id="" name="">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">汇款方式：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" name="remittanceWay" id="" required value="${chargeAccount.remittanceWay }" class="input-text">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">汇款账号：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input name="remittanceBankAccount" required value="${chargeAccount.remittanceBankAccount }" type="text" class="input-text"  id=""  >
					</div>
				</div>
				<%-- <div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">账户信用额：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text"  name="accountCredit" readonly="readonly" value="${chargeAccount.accountCredit }"  class="input-text" value="5" id="emailName">
					</div>
				</div> --%>
				<div class="row cl">
					<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
						<button onClick="account_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
						<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
					</div>
				</div>
				<input type="hidden" id="billType" name="billType" value="${chargeAccount.billType }" >
			</div>
			</form>
		</div>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>  
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script> 
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
$().ready(function() {
	$("#form-account1-edit").validate({
		submitHandler : function(form) {
			$.ajax({
		        type:"post",
		        url:"/flowsys/account/account_info_edit.do",
		        data: $('#form-account1-edit').serialize(),//表单数据
		        async : false,
		        success:function(d){
		            if(d=="success"){
		            	alert("保存成功");
		                layer.msg('保存成功！');//保存成功提示
		            }
		            if(d=="error"){
		                layer.msg('保存异常!');
		            }
		            /* var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
		            parent.layer.close(index); //执行关闭 */
		        }
		    }); 
		}
	});
	$("#form-account-edit").validate({
		submitHandler : function(form) {
			$.ajax({
		        type:"post",
		        url:"/flowsys/account/account_info_edit.do",
		        data: $('#form-account-edit').serialize(),//表单数据
		        async : false,
		        success:function(d){
		            if(d=="success"){
		                layer.msg('保存成功！');//保存成功提示
		            }
		            if(d=="error"){
		                layer.msg('保存异常!');
		            }
		           /*  var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
		            parent.layer.close(index); //执行关闭 */
		        }
		    }); 
		}
	});
	
})


$(function(){
	/* $('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	}); */
	$.Huitab("#tab-system .tabBar span","#tab-system .tabCon","current","click","0");
});
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>