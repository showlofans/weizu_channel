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
		<input type="hidden" value="${resultMap.agencyPo.id }" name="id">
		<!-- 不能修改要原样保留的数据 -->
		<input type="hidden" value="${resultMap.agencyPo.rootAgencyId }" name="rootAgencyId">
		<%-- <input type="hidden" value="${resultMap.agencyPo.rootAgencyId }" name="rootAgencyId"> --%>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">用户账户：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<%-- <input type="text" readonly="readonly" class="input-text" value="${resultMap.agencyPo.userName }" placeholder="" id="userName" name="userName"> --%>
				<span class="isEmpty">${resultMap.agencyPo.userName }</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">真实姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<%-- <input type="text" readonly="readonly" class="input-text" value="${resultMap.agencyPo.userRealName }" placeholder="" id="userRealname" name="userRealname"> --%>
				<span class="isEmpty">${resultMap.agencyPo.userRealName }</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">联系电话：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				 <%-- <input type="text" readonly="readonly" class="input-text" value="${resultMap.agencyPo.agencyTel }" placeholder="" id="agencyTel" name="agencyTel"> --%>
				 <span class="isEmpty">${resultMap.agencyPo.agencyTel }</span>
		 	</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">电子邮箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<%-- <input type="text" readonly="readonly" class="input-text" value="${resultMap.agencyPo.userEmail }" placeholder="" id="userEmail" name="userEmail"> --%>
				<span class="isEmpty">${resultMap.agencyPo.userEmail }</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">用户地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<%-- <input type="text" readonly="readonly" style="width:200px" class="input-text"  value="${resultMap.agencyPo.agencyIp }" placeholder="" id="agencyIp" name="agencyIp"> --%>
				<span class="isEmpty">${resultMap.agencyPo.agencyIp }</span>
			</div>
		</div>
		<c:if test="${not empty resultMap.agencyPo.userApiKey}"><!-- 对私账户会为空 -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">对接apikey：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<%-- <input type="text" readonly="readonly" style="width:200px" class="input-text"  value="${resultMap.agencyPo.agencyIp }" placeholder="" id="agencyIp" name="agencyIp"> --%>
				${resultMap.agencyPo.userApiKey }
			</div>
		</div>
		</c:if>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">用户QQ：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<%-- <input type="text" readonly="readonly" style="width:200px" class="input-text"  value="${resultMap.agencyPo.agencyIp }" placeholder="" id="agencyIp" name="agencyIp"> --%>
				<span class="isEmpty">${resultMap.agencyPo.otherContact }</span>
			</div>
		</div>
		<!-- 回调地址编辑 -->
		<c:if test="${resultMap.agencyPo.agencyTag == 1 && empty resultMap.agencyPo.callBackIp}">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">用户回调地址：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" style="width:200px" class="input-text" placeholder="" id="callBackIp" name="callBackIp"> <!-- callBackIp -->
				</div>
			</div>
		</c:if>
		<!-- 用户其他备注信息  -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">用户备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" style="width:200px" class="input-text" value="${resultMap.agencyPo.agencyMark }" placeholder="" id="agencyMark" name="agencyMark"> <!-- callBackIp -->
			</div>
		</div>
		
		
		<%-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">用户信用：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" style="width:200px" class="input-text"  value="${resultMap.agencyPo.accountCredit }" placeholder="" id="accountCredit" name="accountCredit">元
			</div>
		</div> --%>
		<%-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>不带票费率：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="rateId" class="select">
					<option value="">请选择</option>
					<c:forEach items="${resultMap.rateList }" var="rate" varStatus="vs1">
						<option value="${rate.id }" <c:if test='${rate.id==resultMap.agencyPo.rateId }'>selected</c:if>>${rate.rateName }</option>
					</c:forEach>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>带票费率：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="rateId" class="select">
					<option value="">请选择</option>
					<c:forEach items="${resultMap.billRateList }" var="billRate" varStatus="vs1">
						<option value="${billRate.id }" <c:if test='${billRate.id==resultMap.agencyPo.billRateId }'>selected</c:if>>${billRate.rateName }</option>
					</c:forEach>
				</select>
				</span> </div>
		</div> --%>
		 <div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit" onclick="save()"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button class="btn btn-primary radius" onClick="cancelEdit()">取消</button>
			</div>
		</div> 
	</form>
</body>

<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>  
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javascript">
/* function setInfo(){
	$(".isEmpty").each(function(){
		var info = $(this).html();
		if(info == ' '){
			$(this).html('没有填写');
		}
	})
} */
$(document).ready(function() {
	$(".isEmpty").each(function(){
		var info = $(this).html();
		//alert(info == '');
		if (info == null || info == undefined || info == '') {
			$(this).html('没有填写');
			$(this).addClass('c-red');
		}
	})
})
///更新信息
function save(){
	var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	$.ajax({
        type:"post",
        url:"/flowsys/agency/child_agency_edit.do",
        data: $('form').serialize(),//表单数据
        async : false,
        success:function(d){
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