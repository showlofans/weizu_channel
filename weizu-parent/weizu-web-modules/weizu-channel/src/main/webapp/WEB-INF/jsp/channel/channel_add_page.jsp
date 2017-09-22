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
<link rel="stylesheet" type="text/css" href="/view/iCheck/icheck.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>添加通道</title>
<style type="text/css">
	.demo{padding: 1em 0;}
	a:hover,a:focus{
		outline: none;
		text-decoration: none;
	}
	.tab .nav-tabs{
		border: 1px solid #1fc1dd;
	}
	.tab .nav-tabs li{
		margin: 0;
	}
	.tab .nav-tabs li a{
		font-size: 14px;
		color: #999898;
		background: #fff;
		margin: 0;
		padding: 20px 25px;
		border-radius: 0;
		border: none;
		border-right: 1px solid #ddd;
		text-transform: uppercase;
		position: relative;
	}
	.tab .nav-tabs li a:hover{
		border-top: none;
		border-bottom: none;
		border-right-color: #ddd;
	}
	.tab .nav-tabs li.active a,
	.tab .nav-tabs li.active a:hover{
		color: #fff;
		border: none;
		background: #1fc1dd;
		border-right: 1px solid #ddd;
	}
	.tab .nav-tabs li.active a:before{
		content: "";
		width: 58%;
		height: 4px;
		background: #fff;
		position: absolute;
		top: 0;
		left: 0;
		right: 0;
		margin: 0 auto;
	}
	.tab .nav-tabs li.active a:after{
		content: "";
		border-top: 10px solid #1fc1dd;
		border-left: 10px solid transparent;
		border-right: 10px solid transparent;
		position: absolute;
		bottom: -10px;
		left: 43%;
	}
	.tab .tab-content{
		font-size: 13px;
		color: #999898;
		line-height: 25px;
		background: #fff;
		padding: 20px;
		border: 1px solid #1fc1dd;
		border-top: none;
	}
	.tab .tab-content h3{
		font-size: 24px;
		color: #999898;
		margin-top: 0;
	}
	@media only screen and (max-width: 480px){
		.tab .nav-tabs li{
			width: 100%;
			text-align: center;
		}
		.tab .nav-tabs li.active a,
		.tab .nav-tabs li.active a:after,
		.tab .nav-tabs li.active a:hover{
			border: none;
		}
	}
</style>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
<article class="page-container">
	<form action="" method="" class="form form-horizontal" id="form-channel-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>平台搜索：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" onKeyUp="ajaxGet()" value="" required="required" placeholder="英文请用空格键结束" id="channel_search" name="epName">
			</div>
		</div>
		<!-- 平台ID -->
		<input type="hidden" class="input-text" value="" placeholder="" id="epId" name="epId">
		<!-- <input type="hidden" class="input-text" value="" placeholder="" id="ep_id"> -->
		<!-- 批量添加的折扣 -->
		<div id="channel_discount_list" style="display:none">
		</div>
		<div class="row cl" style="display:none" id="ep_info">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>平台密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"value=""  placeholder="" readonly id="ep_pass" name="ep_pass">
			</div>
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>平台用户名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" readonly placeholder="" id="ep_name" name="ep_name">
			</div>
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>接口地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" readonly value="" placeholder="" id="epPurchaseIp" name="epPurchaseIp">
			</div>
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>模板名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" readonly value="" placeholder="" id="epName" name="epName">
			</div>
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>apikey：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" readonly value="" placeholder="" id="epApikey" name="epApikey">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">通道名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" required="required" value="${resultMap.channelName }" placeholder="例如：wzkj江西移动省内" id="channelName" name="channelName">
			</div>
		</div>
		<input type="hidden" id="billTypeId" value="${resultMap.billType }">
		<div class="row cl mt-20 skin-minimal">
			<label class="form-label col-xs-4 col-sm-3">通道类型：</label>
			<!-- billTypes -->
			<div class="formControls col-xs-8 col-sm-9">
				<c:forEach items="${resultMap.billTypes }" var="billEnum" varStatus="vs">
					<c:choose>
						<c:when test="${vs.index == 0 }">
							<div class="radio-box">
								<input name="billType" id="billType-${vs.index }" class="radioItem" type="radio" value="${billEnum.value }" checked>
								<label for="billType-${vs.index }">${billEnum.desc }</label> 
							</div>
						</c:when>
						<c:otherwise>
							<div class="radio-box">
								<input name="billType" id="billType-${vs.index }" class="radioItem" <c:if test="${chargeAccount1 == null }">disabled</c:if> type="radio" value="${billEnum.value }">
								<label for="billType-${vs.index }">${billEnum.desc }</label> 
							</div>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>运营商类型：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<c:forEach items="${resultMap.operatorTypes }" var="operatorEnum" varStatus="vs">
					<div class="radio-box">
						<input name="operatorType" class="radioItem" type="radio" id="operatorType-${vs.index }" value="${operatorEnum.value }" <c:if test="${vs.index==0 }">checked</c:if> >
						<label for="operatorType-${vs.index }">${operatorEnum.desc }</label>
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
						<label for="serviceType-${vs.index }">${serviceEnum.desc }</label>
						<%-- <label for="operatorType-${vs.index }"></label> --%>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>地区折扣：</label><br>
			<div class="formControls col-xs-8 col-sm-9">
			<table>
				<c:forEach items="${resultMap.scopeCityEnums }" var="scopeCityEnum" varStatus="vs">
					<c:if test="${vs.index % 4==0 }"><tr></c:if>
						<td> 
							<div class="check-box">
								<input class="cbox" onClick="checkBoxes(this)" type="checkbox" id="scopeCityCode-${vs.index }" value="${scopeCityEnum.value }">
								${scopeCityEnum.desc }
								<%-- <label for="scopeCityCode-${vs.index }"></label> --%> 
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
			<label class="form-label col-xs-4 col-sm-3">通道规格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${resultMap.pgSizeStr }" required="required" placeholder="${resultMap.pgSizeStr }" id="pgSize" name="pgSize">
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
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="/view/iCheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
})
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
/* $(".radioItem").change(  
 function() { 
	 var operatorType = $("input[name='operatorType']:checked").val();
	 var serviceType = $("input[name='serviceType']:checked").val();
	 var epId = $('#epId').val();
	 if(!$('#ep_info').is(':visible')){
		 alert('还没有选定平台');
		 $('#epName').focus();
	 }else{
		 //alert(operatorType);
		 $.ajax( {    
		        "type": "post",     
		        "contentType": "application/x-www-form-urlencoded; charset=utf-8",    
		        "url": "/flowsys/channel/change_channel_pgSize.do?operatorType="+ operatorType+"&serviceType=" + serviceType+"&epId=" + epId,
		        "success": function(d){
		            $("#pgSize").val(d);	//写入pgSize
		        }
	 	 });
	 }
}); */
$(document).ready(function(){
	$("#form-channel-add").validate({
    	submitHandler : function(form) {
    		if(changeName()){
    			 $.ajax({
 	               type:"post",
 	               url:"/flowsys/channel/channel_add.do",
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
 	               },
    			 "error":function(msg){
 		        	alert(msg);
 		         }
 	           });
    		}
    	}
    });
})
/**表单提交前的验证*/
function changeName(){
	var i = 0;
	if(!$('#ep_info').is(':visible')){
		alert("没有选定平台")	;
		$('#channel_search').focus();
		return false;
	}
	$(".disscount").each(function(){
		//alert($(this).val() == "");
		if($(this).is(':visible') && $(this).val() != ""){ 
	    	$('#channel_discount_list').empty();
    		$('<input />', {
    	        name: 'discountList['+ i +'].channelDiscount',
    	        id: 'channelDiscount-'+ i,
    	        type: 'hidden',
    	        value: $(this).val()
    	        /* click: function() {
    	            alert("点我了~~");
    	          } */
    	      }).appendTo($('#channel_discount_list'));
    		$('<input />', {
    	        name: 'discountList['+ i +'].scopeCityCode',
    	        type: 'hidden',
    	        value: $(this).prev().val()
    	      }).appendTo($('#channel_discount_list'));
    		i++;
    		//alert('discountList['+ i +'].scopeCityName');
    	}else{
    		$(this).focus();
    	}
	})
	if(i > 0){
		//alert(i);
		return true;
	}else{
		alert("没有配置地区折扣")	;
		return false;
	}
}

/**checkBox的点击事件*/
function checkBoxes(vart){
	if($(vart).next().is(':hidden')){
		$(vart).next().show();
		var operatorType = $("input[name='operatorType']:checked").val();
		var scopeCityCode = $(vart).val();
		//alert(scopeCityCode);
		 var serviceType = $("input[name='serviceType']:checked").val();
		if(serviceType == 0 && scopeCityCode != '32'){
			layer.msg('全国只能配置全国地区');
		}else{
			$(vart).next().val('');//置空编辑的折扣
		}
		 var epId = $('#epId').val();
		 if(!$('#ep_info').is(':visible')){
			 alert('还没有选定平台');
			 $('#epName').focus();
		 }else{
			 //alert(operatorType);
			 $.ajax( {    
			        "type": "post",     
			        "contentType": "application/x-www-form-urlencoded; charset=utf-8",    
			        "url": "/flowsys/channel/change_channel_pgSize.do?operatorType="+ operatorType+"&serviceType=" + serviceType+"&scopeCityCode=" + scopeCityCode+"&epId=" + epId,
			        "success": function(d){
			            $("#pgSize").val(d);	//写入pgSize
			        }
		 	 });
		 }
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
	        	$("#epId").val(resp.id);
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