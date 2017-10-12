<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
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

<title>转账审核页面</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="charge-form">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>代理商名称</label>
			<div class="formControls col-xs-8 col-sm-9 c-red"> ${resultMap.accountPo.agencyName } </div>
		</div> 
		<c:choose>
			<c:when test="${resultMap.accountPo.billType == 0 }">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>账户余额</label>
					<c:choose>
						<c:when test="${resultMap.accountPo.accountBalance > 0 }">
							<div class="formControls col-xs-8 col-sm-9"> ${resultMap.accountPo.accountBalance } </div>
						</c:when>
						<c:otherwise>
							<div class="formControls col-xs-8 col-sm-9 c-red"> ${resultMap.accountPo.accountBalance } </div>
						</c:otherwise>
					</c:choose>
				</div> 
			</c:when>
			<c:otherwise>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>高配账户余额</label>
					<c:choose>
						<c:when test="${resultMap.accountPo.accountBalance > 0 }">
							<div class="formControls col-xs-8 col-sm-9"> ${resultMap.accountPo.accountBalance } </div>
						</c:when>
						<c:otherwise>
							<div class="formControls col-xs-8 col-sm-9 c-red"> ${resultMap.accountPo.accountBalance } </div>
						</c:otherwise>
					</c:choose>
				</div>
			</c:otherwise>
		</c:choose>
		<!-- 信用额度 -->
		<%-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>信用额度</label>
			<c:choose>
				<c:when test="${resultMap.chargeAccount.accountCredit > 0 }">
					<div class="formControls col-xs-8 col-sm-9"> ${resultMap.chargeAccount.accountCredit } </div>
				</c:when>
				<c:otherwise>
					<div class="formControls col-xs-8 col-sm-9 c-red"> ${resultMap.chargeAccount.accountCredit } </div>
				</c:otherwise>
			</c:choose>
		</div>  --%>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">充值额：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" required="required" style="width:100px;" autocomplete="off" placeholder="请输入double值" name="rechargeAmount" id="rechargeAmount">元
				<c:choose>
					<c:when test="${resultMap.accountPo.billType == 0 }">
						<span style="display:none;" id="accountBalance">${resultMap.accountPo.accountBalance }</span>
					</c:when>
					<c:otherwise>
						<span style="display:none;" id="accountBalance">${resultMap.accountPo.accountBalance }</span>
					</c:otherwise>
				</c:choose>
				<input type="hidden" name="accountType" value="0"> <!-- 设置为充值 -->
				<%-- <input type="hidden" name="agencyId" value="${resultMap.accountPo.agencyId }"> <!-- 代理商id --> --%>
				<input type="hidden" id="contextRootId" value="${loginContext.rootAgencyId }"> <!-- 代理商id -->
				<%-- ${resultMap.error_msg } --%>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">账户类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<c:forEach items="${resultMap.billTypeEnum }" var="billTypeE" varStatus="vs">
					<c:if test="${resultMap.accountPo.billType == billTypeE.value }">
						<input type="text" class="input-text" readonly="readonly" value="${billTypeE.desc }" style="width:100px;"  id="billTypeDesc">
						<input type="hidden" name="billType" value="${billTypeE.value }">
					</c:if>
				</c:forEach>
			</div>
		</div>
		<input type="hidden" value="${resultMap.accountPo.id }" name="accountId"><!-- 充值账户id -->
		<!-- <div class="row cl">
			充值凭证：<br>
			<span class="btn-upload form-group">
				<input class="input-text upload-url" type="text" name="uploadfile-2" id="uploadfile-2" readonly style="width:200px">
				<a href="javascript:void();" class="btn btn-primary upload-btn"><i class="Hui-iconfont">&#xe642;</i> 上传logo</a>
				<input type="file" multiple name="file-2" class="input-file">
			</span>
		</div> -->
		
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">附件：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="btn-upload form-group">
				<input class="input-text upload-url" type="text" name="uploadfile-2" id="uploadfile-2" readonly style="width:200px">
				<a href="javascript:void();" class="btn btn-primary upload-btn"><i class="Hui-iconfont">&#xe642;</i> 上传logo</a>
				<input type="file" multiple name="file-2" class="input-file">
			</span> 
			 </div>
		</div> -->
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" onclick="save()" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>

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
	$("#charge-form").validate({
		submitHandler : function(form) {
			var rechargeAmount = parseFloat($('#rechargeAmount').val());
			var accountAmount = parseFloat($('#accountBalance').html());
			var contextRootId = $('#contextRootId').val();
			//alert(contextRootId);
			//alert(rechargeAmount);
			//alert(accountAmount);
			if(rechargeAmount > accountAmount && contextRootId != 0){
				layer.msg('余额不足，请重新输入充值额！');
				$('#rechargeAmount').val('');
				$('#rechargeAmount').focus();
			}else{
				$.ajax({
			        type:"post",
			        url:"/flowsys/account/add_charge.do",
			        data: $('form').serialize(),//表单数据
			        async : false,
			        success:function(d){
			            if(d=="success"){
			                layer.msg('保存成功！');//保存成功提示
			            }
			            if(d=="error"){
			                layer.msg('保存异常!');
			            }
			            var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
			            parent.layer.close(index); //执行关闭
			        }
			    }); 
			}
				
		}
	});
	
})
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>