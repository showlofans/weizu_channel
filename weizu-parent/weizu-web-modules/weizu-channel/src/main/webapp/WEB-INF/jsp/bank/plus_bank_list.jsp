<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/view/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/view/iCheck/icheck.css" />
<link rel="stylesheet" href="/view/mine/bootstrap-datetimepicker.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>加款申请页面页面</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页   <span class="c-gray en">&gt;</span> 账户管理 <span class="c-gray en">&gt;</span> 申请加款 <div class="titleMore"><span class="c-gray en">&gt;</span> 请求充值</div> <!-- <span class="c-gray en">&gt;</span> 银行卡<span class="c-gray en">&gt;</span> 卡充值  --><a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" >请求充值<i class="Hui-iconfont">&#xe6a6;</i></a></nav>
	<div class="page-container">
	<table class="table c"><!-- table-border table-bordered table-bg -->
		<thead >
			<tr  >
				<th class="text-r myBankInfo" scope="col" width="300px">
					系统账户信息：
				</th>
				<td class="c-danger"><c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
						<c:if test="${billTypeEnum.value == resultMap.myBank.billType }">
							${billTypeEnum.desc } : ${resultMap.myBank.accountBalance }
						</c:if>
					</c:forEach></td>
			</tr>
		</thead>
		<tbody>
			<%-- <tr>
				<th class="text-r" width="80">系统账户信息：</th>
				<td>${resultMap.myBank.remittanceWay }</td>
			</tr> --%>
			<tr>
				<th class="text-r myBankInfo">银行卡类型：</th>
				<td>${resultMap.myBank.remittanceWay }</td>
			</tr>
			<tr>
				<th class="text-r myBankInfo">汇款账号：</th>
				<td>${resultMap.myBank.remittanceBankAccount }</td>
			</tr>
			<tr>
				<th class="text-r myBankInfo">账户真实姓名：</th>
				<td>${resultMap.myBank.accountName }</td>
			</tr>
			<tr>
				<th class="text-r myBankInfo">对账余额：</th>
				<td>${resultMap.myBank.referenceBalance }
					<input type="hidden" id="referenceBalance" value="${resultMap.myBank.referenceBalance }">
					<input type="hidden" id="fromBankId" value="${resultMap.myBank.id }">
				</td>
				
			</tr>
		</tbody>
	</table>
	
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr >
				<th colspan="6" scope="col">请选择打款账户
					<!-- <span class="text-r">
						<a style="text-decoration:none" class="btn radio btn-primary" onClick="bank_add('银行卡添加','/flowsys/bankAccount/add_bank_page.do',1)" href="javascript:;" title="添加银行卡"><i class="Hui-iconfont">&#xe600;</i>添加银行卡</a>
					</span> -->
				</th>
			</tr>
			<tr class="text-c">
				<th>银行卡名称</th>
				<th>银行卡账号</th>
				<th>账户真实姓名</th>
				<th>加款金额</th>
				<th>真实加款时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody class="text-c">
			<c:choose>
				<c:when test="${not empty resultMap.plusBankList }">
					<c:forEach items="${resultMap.plusBankList }" var="bank" varStatus="vst">
						<tr>
						<td width="100">${bank.remittanceWay }</td>
						<td width="400">${bank.remittanceBankAccount }</td>
						<td width="100">${bank.accountName }</td>
						<td width="150">
							<%-- <input type="hidden" value="${bank.id }"><!--  id="toBankId" -->
							<input type="hidden"  value="${bank.agencyId }"><!-- id="toAgencyId" --> --%>
							<input type="text" value="" class="input-text commitAmount"  placeholder=" 转账金额" maxlength="6" style="" width="120"></td>
						<td width="200">
							<input style="width:180" type="text" class="input-text Wdate realTime" value=""  onfocus="WdatePicker({isShowClear:false,dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
						</td>
						<td width="100">
							<!-- <div class="radio-box skin-minimal"> -->
								<%-- <input class="radioItem" name="id"  <c:if test="${vs.index==0 }">checked</c:if> type="radio"  value="${bank.id }" ><!-- <c:if test="${vs.index==0 }">checked</c:if> --> --%>
							<!-- </div> -->
								<a style="text-decoration:none" class="btn radio btn-primary" onClick="transferA('/flowsys/bankAccount/transfer_bank.do',${bank.id },${bank.agencyId },this)" href="javascript:;" title="申请加款">申请加款</a>
						</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<td colspan="6" class="text-c">未配置充值银行卡，请联系你的邀请注册方<br>
						<c:choose>
							<c:when test="${loginContext.rootAgencyId == 0 }">
							</c:when>
							<c:when test="${ secondAgency && fn:indexOf(qq, '&') > 0 }"><!-- 二级代理商可以用分割的方式获得上级root用户的所有联系方式 -->
								<%-- <c:set var="qqIndex">${fn:indexOf(qq, '&') }</c:set> --%>
								<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=${fn:substringBefore(qq, '&') }&site=qq&menu=yes"><img border="0" src="/view/button_111.gif" alt="点击这里给我发消息" title="点击这里给我发消息"/></a>
								<!-- 企业官方需要用链接（无法用qq号进行链接） -->
								<a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=91db89981f7ede321d77ecf9c0b02fe61afeed063fec740bb3b5023dc34f0300"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="南昌微族科技有限公司" title="南昌微族科技有限公司"></a>
								<%-- <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=${fn:substringBefore(qq, '&') }&site=qq&menu=yes"><img border="0" src="/view/button_111.gif" alt="点击这里给我发消息" title="点击这里给我发消息"/></a> --%>
								<%-- <a target="_blank" href="${fn:substringAfter(qq, '&') }"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="南昌微族科技有限公司" title="南昌微族科技有限公司"/></a> --%>
								<%-- <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=${fn:substringAfter(qq, '&') }&site=qq&menu=yes"><img border="0" src="/view/button_111.gif" alt="点击这里给我发消息" title="点击这里给我发消息"/></a> --%>
								<%-- <c:forEach items="${fn:split(qq,'&')}" var="oct" begin="0" 
								  end="${fn:length(fn:split(arr,'&'))}" varStatus="stat">
								</c:forEach> --%>
							</c:when>
							<c:otherwise>
								<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=${qq }&site=qq&menu=yes"><img border="0" src="/view/button_111.gif" alt="点击这里给我发消息" title="点击这里给我发消息"/></a>
							</c:otherwise>
						</c:choose>
					</td>
				</c:otherwise>
			</c:choose>
			
		</tbody>
		</table>
		
</div>
	<%-- <form action="" method="" class="form form-horizontal" id="form-article-add">
		<input type="hidden" value="${resultMap.myBank.id}" name="id">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">银行卡类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text isEmpty" value="${resultMap.myBank.remittanceWay }" placeholder="如：建设银行" id="remittanceWay" name="remittanceWay">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">汇款账号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text isEmpty" value="${resultMap.myBank.remittanceBankAccount }" placeholder="" id="remittanceBankAccount" name="remittanceBankAccount">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">账户真实姓名</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				 <input type="text" class="input-text isEmpty" value="${resultMap.myBank.accountName }" placeholder="" id="accountName" name="accountName">
		 	</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">对账余额：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text isEmpty" value="${resultMap.myBank.referenceBalance }" placeholder="" id="referenceBalance" name="referenceBalance">
			</div>
		</div>
		<!-- <div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit" onclick="editBank()"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button class="btn btn-primary radius" onClick="cancelEdit()">取消</button>
			</div>
		</div> -->
	</form> --%>
</body>
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
<!-- <script type="text/javascript" src="/view/iCheck/jquery.icheck.min.js"></script> -->
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>  
<script type="text/javascript" src="/view/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript">
function transferA(url,toBankId,toAgencyId,vart){
	var fromBankId = $('#fromBankId').val();
	var realTimeObj = $(vart).parents('td').prev().children('.realTime');
	var realTimeStr = $(realTimeObj).val();
	var commitAmountObj = $(vart).parents('td').prev().prev().children('.commitAmount');
	var commitAmount = $(commitAmountObj).val();
	
	var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
	var referenceBalance = $('#referenceBalance').val();
	//alert(referenceBalance + ":" + commitAmount);
	
	//alert(realTimeStr+":"+commitAmount);
	if(commitAmount == ''){
		layer.msg('请输入转账金额！');
		$(commitAmountObj).focus();
	}else if(!reg.test(commitAmount)){
		layer.msg('请输入正确的数字！');
		$(commitAmountObj).val('');
		$(commitAmountObj).focus();
	}else if(parseFloat(commitAmount) > parseFloat(referenceBalance)){
		layer.msg('转账金额不能大于对账金额！');
		$(commitAmountObj).val('');
		$(commitAmountObj).focus();
	}
	else if(realTimeStr == ''){
		layer.msg('请选择真实转账时间！');
		$(realTimeObj).focus();
	}else{
		$.ajax({
	        type:"post",
	        url:url,
	        data: {fromBankId:fromBankId,toBankId:toBankId,toAgencyId:toAgencyId, realTimeStr:realTimeStr, commitAmount:commitAmount},//表单数据
	        async : false,
	        success:function(d){
	            if(d=="success"){
	            	layer.confirm("转账请求提交成功，待审核",function(index){
	            		removeIframe();
	            	});
	            }
	            if(d=="error"){
	                layer.msg('转账异常!');
	            }
	        }
	    });
	}
}

$(document).ready(function() {
	/* $('.skin-minimal input').iCheck({
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	}); */
	/* $(".isEmpty").each(function(){
		var info = $(this).html();
		//alert(info == '');
		if (info == null || info == undefined || info == '') {
			$(this).html('没有填写');
			$(this).addClass('c-red');
		}
	}) */
})
/* function editBank(){
	$.ajax({
        type:"post",
        url:"/flowsys/bankAccount/edit_bank.do",
        data: $('form').serialize(),//表单数据
        async : false,
        success:function(d){
            if(d=="success"){
                layer.msg('保存成功！');//保存成功提示
				var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	            parent.layer.close(index); //执行关闭
            }
            if(d=="error"){
                layer.msg('保存异常!');
            }
        }
    });
} */
</script>
</html>