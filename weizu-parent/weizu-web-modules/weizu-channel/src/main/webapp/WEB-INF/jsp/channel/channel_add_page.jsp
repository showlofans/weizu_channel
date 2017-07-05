<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/view/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/H-ui.admin.css" />
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>添加通道</title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form action="/flowsys/channel/channel_add.do" method="post" class="form form-horizontal" id="form-member-add" onsubmit="return changeName()">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">通道名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${resultMap.channelName }" placeholder="例如：wzkj江西移动省内" id="channelName" name="channelName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">通道规格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${resultMap.pgSizeStr }" placeholder="${resultMap.pgSizeStr }" id="pgSize" name="pgSize">
			</div>
		</div>
		<input type="hidden" id="billTypeId" value="${resultMap.billType }">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">通道类型：</label>
			<!-- billTypes -->
			<div class="formControls col-xs-8 col-sm-9">
				<c:forEach items="${resultMap.billTypes }" var="billEnum" varStatus="vs">
					<c:choose>
						<c:when test="${vs.index == 0 }">
							<div class="radio-box">
								<input name="billType" class="radioItem" type="radio" value="${billEnum.value }" checked>
								${billEnum.desc }
							</div>
						</c:when>
						<c:otherwise>
							<div class="radio-box">
								<input name="billType" class="radioItem" <c:if test="${chargeAccount1 == null }">disabled</c:if> type="radio" value="${billEnum.value }">
								${billEnum.desc }
							</div>
						</c:otherwise>
					</c:choose>
					<%-- <div class="radio-box">
						<input name="billType" class="radioItem" type="radio" disabled value="${billEnum.value }" <c:if test="${vs.index==0 }">checked</c:if>>
						${billEnum.desc }
						<label for="operatorType-${vs.index }"></label>
					</div> --%>
				</c:forEach>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>运营商类型：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<c:forEach items="${resultMap.operatorTypes }" var="operatorEnum" varStatus="vs">
					<div class="radio-box">
						<input name="operatorType" class="radioItem" type="radio" id="operatorType-${vs.index }" value="${operatorEnum.value }" <c:if test="${vs.index==0 }">checked</c:if> >
						${operatorEnum.desc }
						<%-- <label for="operatorType-${vs.index }"></label> --%>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>流量类型：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<c:forEach items="${resultMap.serviceTypes }" var="serviceEnum" varStatus="vs">
					<div class="radio-box">
						<input name="serviceType" class="radioItem" type="radio" id="serviceType-${vs.index }" value="${serviceEnum.value }" <c:if test="${vs.index==0 }">checked</c:if>>
						${serviceEnum.desc }
						<%-- <label for="operatorType-${vs.index }"></label> --%>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>地区折扣：</label><br>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
			<table>
				<c:forEach items="${resultMap.scopeCityEnums }" var="scopeCityEnum" varStatus="vs">
					<c:if test="${vs.index % 4==0 }"><tr></c:if>
						<td> 
							<div class="radio-box">
								<input class="cbox" onClick="checkBoxes(this)" type="checkbox" id="scopeCityCode-${vs.index }" value="${scopeCityEnum.value }">
								${scopeCityEnum.desc }
								<%-- <label for="operatorType-${vs.index }"></label> --%>
								<!-- 输入两位折扣数字 -->
								<input class="disscount" style="display: none; width:50px;" type="text" maxlength="3" onkeyup='this.value=this.value.replace(/\D/gi,"")' placeholder="1.00">
							</div>
						</td>
					<c:if test="${(vs.index+1) % 4==0 }"></tr></c:if>
					<!-- <div class="formControls col-xs-3 col-sm-3">
						<input type="text" placeholder="1.00" name="channelDiscount" id="channelDiscount">
					</div> -->
				</c:forEach>
			</table>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>平台搜索：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" onKeyUp="ajaxGet()" value="" required="required" placeholder="英文请用空格键结束" id="channel_search" name="epName">
			</div>
		</div>
		<!-- 平台ID -->
		<input type="hidden" class="input-text" value="" placeholder="" id="ep_id" name="epId">
		<div class="row cl" style="display:none" id="ep_info">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>平台密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"value="" placeholder="" id="ep_pass" name="ep_pass">
			</div>
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>平台用户名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="ep_name" name="ep_name">
			</div>
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>接口地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="epPurchaseIp" name="epPurchaseIp">
			</div>
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>模板名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="epName" name="epName">
			</div>
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>apikey：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="epApikey" name="epApikey">
			</div>
		</div>
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="@" name="email" id="email">
			</div>
		</div> -->
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">附件：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="btn-upload form-group">
				<input class="input-text upload-url" type="text" name="uploadfile" id="uploadfile" readonly nullmsg="请添加附件！" style="width:200px">
				<a href="javascript:void();" class="btn btn-primary radius upload-btn"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
				<input type="file" multiple name="file-2" class="input-file">
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">所在城市：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" size="1" name="city">
					<option value="" selected>请选择城市</option>
					<option value="1">北京</option>
					<option value="2">上海</option>
					<option value="3">广州</option>
				</select>
				</span> </div>
		</div> -->
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="beizhu" cols="" rows="" class="textarea"  placeholder="说点什么.最少输入10个字符" onKeyUp="$.Huitextarealength(this,100)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
			</div>
		</div> -->
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>
</body>
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript">
/* 设置
function getMsg(){
	var billType = $("#billTypeId").val();
	//alert(billType);//会没有值
	if(billType != 1){
		alert("请先开通对公账户");
		$("input[name='billType']:eq(0)").attr("checked",true); 
		$("input[name='billType']:eq(1)").attr("disabled",'disabled'); 
	}
} */
/**根据运营商改变通道规格 */
$(".radioItem").change(  
 function() { 
	 var operatorType = $("input[name='operatorType']:checked").val();
	 var serviceType = $("input[name='serviceType']:checked").val();
	 //alert(operatorType);
	 $.ajax( {    
	        "type": "post",     
	        "contentType": "application/x-www-form-urlencoded; charset=utf-8",    
	        "url": "/flowsys/channel/change_channel_pgSize.do?operatorType="+ operatorType+"&serviceType=" + serviceType,
	        "success": function(d){
	            $("#pgSize").val(d);	//写入pgSize
	        }
 	 });
});
$(document).ready(function(){
	
	
	/* if($("input[type='checkbox']").is(':checked')){
		$("input[type='checkbox']").next().hide();
	} */
	/*  $(".cbox").each(function(){
	    	//alert($(this).prop("checked"));
	    	 // alert($(this).attr("checked"));
	    	 $(this).next().hide();
	})  */
	//alert("checked");
	/*  $("[type='checkbox']").each(function(){
	     
		   
	     if($(this).attr("checked"))
	   {
	    alert("checked");
	   } */
})
/**表单提交前的验证*/
function changeName(){
	var i = 0;
	$(".disscount").each(function(){
    	if($(this).is(':visible')){ 
    		$('<input />', {
    	        name: 'discountList['+ i +'].channelDiscount',
    	        id: 'channelDiscount-'+ i,
    	        type: 'hidden',
    	        value: $(this).val()
    	        /* click: function() {
    	            alert("点我了~~");
    	          } */
    	      }).appendTo($('#ep_id'));
    		$('<input />', {
    	        name: 'discountList['+ i +'].scopeCityCode',
    	        type: 'hidden',
    	        value: $(this).prev().val()
    	      }).appendTo($('#ep_id'));
    		i++;
    		//alert('discountList['+ i +'].scopeCityName');
    	}
	})
	if(i > 0){
		//alert(i);
		return true;
	}else{
		alert("没有配置地区折扣")	;
		return false;
	}
	/* $(".disscount").each(function(){
		var i = 0;	
		alert(i);
    	if($(this).is(':visible')){
    		$(this).prev.attr("name", "discountList["+i+"].scopeCityName" );
    		$(this).prop.attr("name", "discountList["+i+"].channelDiscount" );
    		i++;
		}
	}) */
}

/**checkBox的点击事件*/
function checkBoxes(vart){
	if($(vart).next().is(':hidden')){
		$(vart).next().show();
	}else{
		$(vart).next().hide();
	}
} 

/*监听平台 输入框的键盘事件 **/
function ajaxGet(evt) {
	var k = evt || window.event;
	
	//alert(k.keyCode);
	var epName = $("#channel_search").val().replace(/(^\s+)|(\s+$)/g, "");//去除空格
	/**监听回车键和空格键*/
	if( (k.keyCode == 32 && epName.length != 0) || (k.keyCode == 8 && epName.length != 0)){
		
	//alert(epName);
		$.ajax( {    
	        "type": "get",     
	        "contentType": "application/x-www-form-urlencoded; charset=utf-8",    
	        "url": "/flowsys/channel/search_platform.do?epName="+epName,     
	        "dataType": "json",    
	        "success": function(resp) {  
	        	if(resp == null){
	        		$("#ep_info").hide();
	        	}
	        	$("#ep_info").show();
	        	$("#ep_name").val(resp.epUserName);
	        	$("#ep_pass").val(resp.epUserPass);
	        	$("#epApikey").val(resp.epApikey);
	        	$("#epPurchaseIp").val(resp.epPurchaseIp);
	        	$("#epName").val(resp.epName);
	        	$("#ep_id").val(resp.id);
	        	//alert(resp.id);
	        },
	        "error":function(msg){
	        	//alert(msg);
	        }
	    }); 
	}else{
    	$("#ep_info").hide();
	}
}
</script>
</html>