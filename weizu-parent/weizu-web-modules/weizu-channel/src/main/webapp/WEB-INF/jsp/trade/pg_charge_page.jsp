<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<!--[if IE 8]><html class="ie8" lang="en"><![endif]-->
<!--[if IE 9]><html class="ie9" lang="en"><![endif]-->
<!--[if !IE]><!-->
<html lang="en">
 <!--<![endif]-->
 <head>
 	<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
	<META HTTP-EQUIV="Expires" CONTENT="0"> 
  <title>流量充值</title>
  <!--[if IE]><meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1" /><![endif]-->
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0,minimum-scale=1,maximum-scale=1" />
  <meta name="apple-mobile-web-app-capable" content="yes" />
  <meta name="apple-mobile-web-app-status-bar-style" content="black" />
  <meta content="" name="description" />
  <meta content="" name="author" />
	<link rel="stylesheet" type="text/css" href="/view/static/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/H-ui.admin.css" />
	<!-- DataTables CSS -->
	<link rel="stylesheet" type="text/css" href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/style.css" />
 </head>
 <body>
 <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 在线充值 <span class="c-gray en">&gt;</span> 流量充值 <span class="c-gray en">&gt;</span> 单号充值<!--  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a> --><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
<article class="page-container">
 	<form class="form form-horizontal" action="" method=""  id="form-charge">
 	<input type="hidden" name="channelId" id="channelId">
 	<input type="hidden" name="billType" id="billType">
 	<!-- <input type="hidden" name="pgId" id="pgId"> -->
 	<input type="hidden" name="productCode" id="productCode">
 	<input style="display: none;" type="text" value="${resultMap.pageMsg }" id="pageMsg">
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><!--<span class="c-red">*</span>-->手机号码：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" required="required" onchange="initForm()" onblur="ajaxPhone()" style="width:400px" value="" placeholder="" id="chargeTel" name="chargeTel">
			<span class="error"></span>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><!--<span class="c-red">*</span>-->归属地：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" required  style="width:400px" value="" placeholder="" id="chargeTelDetail" name="chargeTelDetail">
		</div>
	</div>
	<input id="rootAgencyId" value="${loginContext.rootAgencyId}" type="hidden" >
	<c:if test="${loginContext.rootAgencyId == 0 }">
		<div class="row cl" id="pg">
			<label class="form-label col-xs-4 col-sm-3"><!--<span class="c-red">*</span>-->测试平台：</label>
			<div class="formControls col-xs-8 col-sm-9">
			<!--  onfocus="ajaxPg()" -->
				<input type="text" id="epName" name="epName" class="input-text" required style="width:400px" autocomplete="off"  placeholder="请输入平台名称" >
			</div>
		</div>
	</c:if>
	<c:if test="${resultMap.channelTypeEnums != null && fn:length(resultMap.channelTypeEnums) > 0 }">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">通道类型：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<span class="select-box inline">
					<select name="channelType"  id="channelType" class="select" onchange="ifAjaxPg()" style="width:150px;">
					<!-- <option value="">请选择</option> -->
					<c:forEach items="${resultMap.channelTypeEnums }" var="channelTypeEnum" varStatus="vs2">
						<option value="${channelTypeEnum.value }">${channelTypeEnum.desc }</option>
					</c:forEach>
				</select>
				</span>
			</div>
		</div>
	</c:if>
	<c:if test="${resultMap.pgTypeEnums != null && fn:length(resultMap.pgTypeEnums) > 0 }">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">流量类型：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<span class="select-box inline">
					<select name="pgType"  id="pgType" class="select" onchange="ifAjaxPg()" style="width:150px;">
					<!-- <option value="">请选择</option> -->
					<c:forEach items="${resultMap.pgTypeEnums }" var="pgTypeEnum" varStatus="vs2">
						<option value="${pgTypeEnum.value }">${pgTypeEnum.desc }</option>
					</c:forEach>
				</select>
				</span>
			</div>
		</div>
	</c:if>
	<c:if test="${resultMap.pgValidityEnums != null && fn:length(resultMap.pgValidityEnums) > 0 }">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">有效期：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<span class="select-box inline">
					<select name="pgValidity"  id="pgValidity" class="select" style="width:150px;"  onchange="ifAjaxPg()">
					<!-- <option value="">请选择</option> -->
					<c:forEach items="${resultMap.pgValidityEnums }" var="pgValidityEnum" varStatus="vs2">
						<option value="${pgValidityEnum.value }">${pgValidityEnum.desc }</option>
					</c:forEach>
				</select>
				</span>
			</div>
		</div>
	</c:if>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><!--<span class="c-red">*</span>-->业务类型：</label>
		<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<span class="select-box inline">
					<select id="select-servce-type" name="serviceType" onchange="ifAjaxPg()" style="width:150px;" class="select">
						<option value="">请选择</option>
						<c:forEach items="${resultMap.serviceTypeEnum }" var="typeEnum" varStatus="vs1">
							<option value="${typeEnum.value }" <c:if test="${typeEnum.value == resultMap.params.serviceType }"> selected</c:if>>${typeEnum.desc }</option>
						</c:forEach>
					</select>
				</span>
					<!-- <span style="width: 300;" onclick="showNext(this)" title="提示信息"><i class="Hui-iconfont">&#xe6cd;</i></span>
					<span class="select-box inline" style="display:none;" >
					</span> -->
		</div>
	</div>
	
		
		
	<div class="row cl" id="pg">
		<label class="form-label col-xs-4 col-sm-3"><!--<span class="c-red">*</span>-->流量面值：</label>
		<div class="formControls col-xs-8 col-sm-9">
		<!--  onfocus="ajaxPg()" -->
			<input type="text" id="chargeValue" readonly name="chargeValue" class="input-text" required style="width:400px" autocomplete="off"  placeholder="请选择购买包体" >
		</div>
	</div>
	<div id="pgInsert" class="row cl">
		<!-- style="display:none;"  -->
	</div>
	<div id="cnelInsert" class="row cl">
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><!--<span class="c-red">*</span>-->采购金额：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input id="orderAmount" name="orderAmount" type="text" readonly class="input-text" required  style="width:400px" value="" placeholder="请选择购买包体">
			<c:choose>
				<c:when test="${loginContext.rootAgencyId == 0 }">
					<input id="cdisId" name="cdisId" type="hidden" value="">
				</c:when>
				<c:otherwise>
					<input id="rateId" name="rateId" type="hidden" value="">
				</c:otherwise>
			</c:choose>
			<br>折扣：<span id="rateDiscount" class="c-red">${resultMap.pageMsg }</span>(不带票)
		</div>
	</div>
	
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			<input class="btn btn-primary radius" type="button" onclick="removeIframe();" value="&nbsp;&nbsp;取消&nbsp;&nbsp;">
		</div>
	</div>
	<div class="row cl" id="pg">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>充值提示：</label>
		<div class="formControls col-xs-8 col-sm-9">
		<!--  onfocus="ajaxPg()" -->
			<textarea readonly="readonly" style="height:350px;  " name="" cols="30" rows="" class="textarea"  placeholder="属性介绍，
省内流量  （使用范围-本省——只限本省号码充值）
省漫游流量（使用范围-全国——只限本省号码充值）
全国流量  （使用范围-全国——全国号码均可充值）

温馨提示!
流量充值到账以查询官方为准。
充值结果可在，订单列表查看，
充值成功后（1-10分钟查询）
如长时间订单号显示结果（充值等待）-（结果显示失败）
可直接联系您的上游（在平台个人信息里面有您上游的QQ）

本司上班时间（9:00-00:00）
如不在上班时间出现问题，亲耐心等待。
我司承若如遇卡单24小时内返回结果。
给您带来不便敬请谅解！"></textarea>
		</div>
	</div>
	</form>
	
	<!-- <input id="pgSize" type="hidden"></input -->
</article>
 </body>
  <script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
  <script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
  <script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
  <script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
  <script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/messages_zh.js"></script>
 <script type="text/javascript">
/*  function showNext(vart){
	 if($(vart).next().is(':hidden')){
		 $(vart).next().show();
	 }else{
		 $(vart).next().hide();
	 }
 } */
 $().ready(function() {
	    $("#form-charge").validate({
	    	submitHandler : function(form) {
	    		if($('#pageMsg').val() != ''){
	    			 alert($('#pageMsg').val());
	    		 }else if($('#chargeValue').val() == ''){
	    			 alert('请重新选择包体获取包体原价');
	    		 }
	    		else if($('#productCode').val() != ''){
		    		$.ajax({
				        type:"post",
				        url:"/flowsys/chargePg/pg_charge.do",
				        data: $('form').serialize(),//表单数据
				        async : false,
				        success:function(d){
				        	if(d == 'success'){
					        	removeIframe();
				        	}else{
				        		alert(d + "充值失败");
				        		removeIframe();
				        	}
				           /* if(d=="success"){
				                layer.msg('提交成功！');//保存成功提示
				            }
				            if(d=="error"){
				                layer.msg('提交异常!');
				            } */
				        }
				    });
	    		 }
			}
	    });
});
 /**手机号改变时所有参数都要改变*/
 function initForm(){
	 $("#select-servce-type option:first").prop("selected", 'selected');
	 if($("#pgInsert").is(":visible")){
   		 $("#pgInsert").empty();
   		 $("#pgInsert").hide();
   	 }
	// $('#form-charge')[0].reset();
 }
 /**通过用户手机号获得基本信息*/
 	var tel;
 	var carrier;
    var getChargeTel=function(){
        //淘宝接口    
       $.ajax({
             type: "get",
             url: 'https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel='+tel,
             dataType: "jsonp",
             contentType: "application/x-www-form-urlencoded; charset=utf-8", 
             jsonp: "callback",
             success: function(data){
               // $('.error').css('display','none');
             	carrier = data.carrier;//广东移动
               var location = data.location;
               var  operators = data.catName,//中国移动
                province = data.province,
               
                    num = data.telString; 
               //alert(province);
             $('#chargeTelDetail').val(carrier);  
             },
         });
         //聚合接口
    	 /* $.ajax({
            type: "get",
            url: 'http://apis.juhe.cn/mobile/get?phone='+tel+'&key=59b0973a9e6d8642b987ac04c1eb2c07',
            contentType: "application/x-www-form-urlencoded; charset=utf-8", 
            dataType: 'jsonp',
            crossDomain: true,
            success: function(data){
              // $('.error').css('display','none');
              //alert(data);
              var provinceIn = data.result.province;//广东
              //alert(provinceIn);
              var city = data.result.city;
              var  company = data.result.company,//中国移动
              carrier = provinceIn + city + company.substring(company.length-2);
              //alert(province);
            $('#chargeTelDetail').val(carrier);  
            },
        }); */
    };
    /**radio选中事件*/
    function changeValue(vart){
    	if($(vart).is(':checked')){
    		$("#pgName").val($(vart).val());
    		//alert($(vart).privous().val());
    	}
    }
   
    var reg = /^(13|14|15|18|17)[0-9]{9}$/;//点击查询
    function ajaxPhone(){
    	 tel=$('input[name=chargeTel]').val();
         if(tel){
             if(reg.test(tel)){
            	 getChargeTel();
                 $('.error').hide();
             }else{
                 $('.error').html('手机号不合法 ').css('display','block');    
             }
         }
    }
    
    /* var ajax2=function(){
    	$.ajax({
            type: "get",
            async: false,
            url: '/flowsys/chargePg/pgList_forPurchase.do?operatorType='+ operators,
            dataType: "json",
            contentType: "application/x-www-form-urlencoded; charset=utf-8", 
            success: function(data){
          	  //alert(data.length);
          	  if($(".pgNameType") == undefined || $(".pgNameType").length <= 0){
              var appendData = "<label class='form-label col-xs-4 col-sm-3'><span class='c-red'>*</span>包体大小：</label><div class='formControls col-xs-8 col-sm-9 skin-minimal'>"; 
          	  for(var i=0; i < data.length; i++){
            	   var price = data[i].chargeValue;
            	   var name = data[i].pgName;
           				if(i == 0){//默认设置第一个为选中 
	           				appendData += "<div class='radio-box pgNameType'><input name='pgName' class='pgNameRadio' type='radio' id='pgName-"+(i+1)+"' onclick='changeRadio(this)' checked><label for='pgName-"+(i+1)+"'>"+name+"</label></div><input type='hidden' class='price' name='chargeValue' value='"+price+"'></input><br>";
	           				$("#chargeValue").val(data[0].chargeValue);
           				}else{
           					
           				appendData += "<div class='radio-box pgNameType'><input name='pgName' class='pgNameRadio' type='radio' id='pgName-"+(i+1)+"' onclick='changeRadio(this)'><label for='pgName-"+(i+1)+"'>"+name+"</label></div><input type='hidden' class='price' name='chargeValue' value='"+price+"'></input><br>";
           				}
              }
          	appendData += "</div>";
        	$("#pg").prepend(appendData);
        	
          	  }}
        })
    }; */
    var rootAgencyId = $('#rootAgencyId').val();
	//   alert(rootAgencyId);
    /*  function changeChannelRadio(vart){
    	 $.ajax({
             type: "post",
             url: '/flowsys/chargePg/pgList_forPurchase.do?operatorName='+ carrier + '&serviceType=' + serviceType,
             dataType: "json",
             async: false,
             contentType: "application/x-www-form-urlencoded; charset=utf-8", 
             success: function(data){
           	  //alert(data.pgList.length);
           		//$('#rateDiscount').html(data.ratePo.activeDiscount);
           		//$('#rateId').val(data.ratePo.id);
           	  if($(".pgNameType") == undefined || $(".pgNameType").length <= 0){
               var appendData = "<label class='form-label col-xs-4 col-sm-3'><span class='c-red'>*</span>包体大小：</label><div class='formControls col-xs-8 col-sm-9 skin-minimal'>"; 
               if(data.pgList.length > 0){
                   for(var i=0; i < data.pgList.length; i++){
                 	   var price = data.pgList[i].chargeValue;
                 	   var name = data.pgList[i].pgName;
                 	   var pgSize = data.pgList[i].pgSize;
                 	   var productCode = data.pgList[i].productCode;
                 	   var pgDiscountPrice = data.pgList[i].pgDiscountPrice;
                 	   var rteDis = data.pgList[i].rteDis;
                 	   var rteId = data.pgList[i].rteId;
                 	   var channelId = data.pgList[i].channelId;
                				/* if(i == 0){//默认设置第一个为选中 
     	           				appendData += "<div class='radio-box pgNameType'><input name='pgName' class='pgNameRadio' type='radio' id='pgName-"+(i+1)+"' onclick='changeRadio(this)' checked><label for='pgName-"+(i+1)+"'>"+name+"</label></div>"
     	           				+ "<input type='hidden' name='chargeValue' value='"+price+"'></input>"
     	           				+ "<input type='hidden'  name='pgSize' value='"+pgSize+"'></input><br>";
     	           				//$("#chargeValue").val(data[0].chargeValue);
     	           				$("#pgSize").val(data[0].pgSize);
     	           				$("#pgId").val(data[0].id);
                				}else{ 
                					appendData += "<div class='radio-box pgNameType'><input type='hidden' value='";
                					appendData += data.pgList[i].id;
                					appendData +="'></input><input class='pgNameRadio' type='radio' name='pgNameRadio' id='pgName-";
               						appendData += (i+1);
               						appendData += "' onclick='changeRadio(this)'><label for='pgName-";
           							appendData += (i+1);
           							appendData += "'>";
               						appendData += name;
               						appendData += "</label></div><input type='hidden' class='price' value='";
           							appendData += price;
           							appendData += "'></input>";
           							appendData +="<input type='hidden' value='";
       								appendData += pgSize;
       								appendData +="'></input><input type='hidden' value='";
   									appendData += productCode;
   									appendData += "'></input><input type='hidden'  value='";
									appendData += pgDiscountPrice;
									appendData += "'></input></input><input type='hidden' value='";
									appendData += rteDis ;
									appendData += "'></input><input type='hidden' value='";
									appendData += channelId;
									appendData += "'></input><input type='hidden' value='";
									appendData += rteId;
									appendData += "'></input><br>";;
                				 }
                   }
               }else{
             	  appendData += "没有配置该业务类型，或者号码不符合充值条件！！";
             	  $("#chargeValue").val("");//重置参数
             	  $("#orderAmount").val("");
             	  
           	  }
           	appendData += "</div>";
         	$("#pgInsert").prepend(appendData);
         	$("#pgInsert").show();
           	  }
           	  }
         }) 
     } */
	
	function changeRadio(vart,channelId){
	  // var psize = $(vart).parent().next().next().val();//包大小
	  //var channelId = $(vart).parent().next().next().next().val();//通道id
	  //alert(channelId);
	  // var pgDiscountPrice = $(vart).parent().next().next().next().next().val();
	   //var rateDis = $(vart).parent().next().next().next().next().next().val();
	  // var channelId = $(vart).parent().next().next().next().next().next().next().val();
	  // alert(channelId);
	   /* if(rootAgencyId == 0){
		   var cdisId = $(vart).parent().next().next().next().next().next().next().next().val();
		   $('#cdisId').val(cdisId);
		   alert(cdisId);
	   }else{
		   var rteId = $(vart).parent().next().next().next().next().next().next().next().val();
		   $('#rateId').val(rteId);
	   } */
	   //$('#rateDiscount').html(rateDis);
	   //alert(channelId);
	   var pgId = $(vart).val();
	   var pprice = $(vart).parent().next().val();
	   var serviceType = $("#select-servce-type").val();
       //$("#pgId").val(pgId);//包体id
       var carrier = $('#chargeTelDetail').val();
       
       $.ajax({
           type: "get",
           url: '/flowsys/chargePg/ajax_purchase_price.do?chargeValue=' + pprice + '&pgId='+pgId+ '&channelId='+channelId+ '&carrier='+carrier+ '&serviceType='+serviceType,
           async: false,
           dataType: "json",
           contentType: "application/x-www-form-urlencoded; charset=utf-8", 
           success: function(data){
        	  //$.each(data,function(i){  
        		//    var key = i;  
        		   // var value = data[i];  
        		  //  alert(key+":"+value);  
        		//}); 
         	 //$("#orderAmount").val(data);
        		//alert(data.msg);
        		var msg = data.msg;
        		//alert(msg);
        	if(msg == 5002){
        		alert('账户余额不足');
        		$("#orderAmount").val('');
        		$("#chargeValue").val('');
        	}else if('success' == msg){
	         	 $("#orderAmount").val(data.price);
	         	
	         	 $('#channelId').val(data.channelId);
	         	 //if(data.cdId != null && data.cdId !=""){
	         		 $('#cdisId').val(data.cdId);
	         	 //}else{
		         	 $('#rateId').val(data.rateDiscountId);
	         	 //}
	      	   //alert(productCode);
	      	   $("#productCode").val(data.productCode);
	      	   $("#chargeValue").val(pprice);//改变包体原价
	      	   //alert($(vart).prev().val());
         	 	$('#rateDiscount').html(data.rateDiscount);
         	 $("#billType").val(data.billType);
        	}
        	else if(msg != '' || msg != null){
        		$('#pageMsg').val(msg);
        		$('#rateDiscount').html(msg);
        	}
        	
        		
           }
       })
	   
	  
	   
	   //var serviceType = $("#select-servce-type").val();
	   //var carrier = $("#chargeTelDetail").val();
	   //$("#billType").val(0);
	   
	   
   }
   /*  $('.skin-minimal input').on('iCheck',{		//给单选框加特效
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	}); */
	/**改变业务类型Onchange方法*/
	function ifAjaxPg(){
		/* var priceT = $("#chargeValue").val();
		if(priceT != "" || priceT != null){//
			ajaxPg();//重新发送一次请求
		} */
		$("#chargeValue").val("");//重置参数
  	 	 $("#orderAmount").val("");
  	 	var sType1 = $("#select-servce-type").val();
  	 	if(sType1 != null && sType1 != ''){
	  		ajaxPg();
  	 	}
	}
	/**
	 * 乘法运算，避免数据相乘小数点后产生多位数和计算精度损失。
	 *
	 * @param num1被乘数 | num2乘数
	 */
	function numMulti(num1, num2) {
		 var baseNum = 0;
		 try {
		  baseNum += num1.toString().split(".")[1].length;
		 } catch (e) {
		 }
		 try {
		  baseNum += num2.toString().split(".")[1].length;
		 } catch (e) {
		 }
		 return Number(num1.toString().replace(".", "")) * Number(num2.toString().replace(".", "")) / Math.pow(10, baseNum);
	};
	/** 代理商折扣响应包体点击事件*/
	function getPrice(vart){
		var chargeValue = $(vart).parent().next().val();//包体价格
		var productCode = $(vart).parent().next().next().next().val();//包体编码
		var cdis = $('#rateDiscount').html();
		//var orderAmount = numMulti(chargeValue,cdis);
		//alert(orderAmount);
		var pgId =  $(vart).val();
		//$("#pgId").val(pgId);
		$("#productCode").val(productCode);
		$("#orderAmount").val(orderAmount);
		$("#chargeValue").val(chargeValue);
	};
	
	/** 通道异步获得充值包体列表*/
	function togglelePg(vart){
		var cnelId =  $(vart).prev().val();
		$('#channelId').val(cnelId);
		
		var cdiscount = $(vart).parent().next().next().val();//通道折扣
		$('#rateDiscount').html(cdiscount);//通道折扣
		
		var cdisId = $(vart).parent().next().next().next().next().val();//通道折扣id
		$('#cdisId').val(cdisId);//初始化通道折扣id
		
		// alert(cnelId);
		 var carrier = $("#chargeTelDetail").val();
    	 var serviceType = $("#select-servce-type").val();
    	 //var epName = $('#epName').val();
    	 $.ajax({
             type: "post",
             url: '/flowsys/chargePg/ajax_charge_pg.do?channelId='+ cnelId,
             dataType: "json",
             async: false,
             contentType: "application/x-www-form-urlencoded; charset=utf-8", 
             success: function(data){
           	  //alert(data.pgList.length);
           	  var dataRole1 = eval(data);
           	  //alert(dataRole1.length);
           	  //if($(".pgNameType") == undefined || $(".pgNameType").length <= 0){
               var appendData1 = "<label class='form-label col-xs-4 col-sm-3'>包体大小：</label><div class='formControls col-xs-8 col-sm-9 skin-minimal'>"; 
               if(dataRole1 != null && dataRole1.length > 0){
                   for(var i=0; i < dataRole1.length; i++){
                 	   var price = dataRole1[i].pgPrice;
                 	   var name = dataRole1[i].pgName;
                 	   //var serviceType = dataRole1[i].serviceType;
                 	   //alert(serviceType);
                 	   //alert(name);
                 	   var pgSize = dataRole1[i].pgSize;
                 	   var productCode = dataRole1[i].productCode;
                 	   //var cdis = dataRole1[i].cdis;
                 	  // var cdisId = dataRole1[i].cdisId;
                 	   //var pgDiscountPrice = dataRole1[i].pgDiscountPrice;
       					appendData1 += "<div class='radio-box pgNameType'><input class='pgNameRadio' name='pgId' type='radio' id='pgName-";
       					appendData1 += (i+1);
       					appendData1 += "' onclick='changeRadio(this,"+ cnelId +")' value='"
       					appendData1 += dataRole1[i].id;
       					appendData1 += "'><label for='pgName-";
       					appendData1 += (i+1);
       					appendData1 += "'>";
       					appendData1 += name;
       					appendData1 += "</label></div><input type='hidden' class='price' value='";
       					appendData1 += price;
       					appendData1 += "'></input>";
       					appendData1 += "<input type='hidden' value='";
       					appendData1 += pgSize;
       					appendData1 += "'></input><input type='hidden' value='";
       					appendData1 += productCode;
       					appendData1 += "'></input>";
       				 }
                   appendData1 += "</div>";
               }else{
             	  appendData1 += "没有配置该业务类型，或者号码不符合充值条件！！";
             	  $("#chargeValue").val("");//重置参数
             	  $("#orderAmount").val("");
		           	appendData1 += "</div>";
           	  }
               $("#pgInsert").empty();
         	$("#pgInsert").prepend(appendData1);
         	$("#pgInsert").show();
           	  //}
           	  }
         })
	}
	
    function ajaxPg(){
    	 tel=$('input[name=chargeTel]').val();
    	 //alert(serviceType);
         if(tel){
	    	 var carrier = $("#chargeTelDetail").val();
	    	 //alert(carrier);
	    	 var serviceType = $("#select-servce-type").val();
	    	 
             if(reg.test(tel)){
            	 //如果点击了有的话就先删除原来的业务
            	 //var serviceTypeTag = $("#pg").children().eq(2);//有第三个元素
            	 if($("#pgInsert").is(":visible")){
               		 $("#pgInsert").empty();
               		 $("#pgInsert").hide();
               	 }
            	 if($("#cnelInsert").is(":visible")){
               		 $("#cnelInsert").empty();
               		 $("#cnelInsert").hide();
               	 }
            	 /* else{
               		 alert("sorry");
               	 } */
            	//查询流量包
            	 	//ajax2();
       	if(rootAgencyId == 0){
    	  var url = '/flowsys/chargePg/ajax_charge_channel.do?carrier=';
       	}else{
    	  var url = '/flowsys/chargePg/pgList_forPurchase.do?carrier=';
       	}
    	  url += carrier;
    	  url += '&serviceType=';
    	  url += serviceType; 
    	  if($("#pgValidity").length >0){
	       	 var pgValidity = $("#pgValidity").val();
    		 url += '&pgValidity=';
    		 url += pgValidity;
    	  }
    	  if($("#pgType").length >0){
          	 var pgType = $("#pgType").val();
    		 url += '&pgType=';
    		 url += pgType;
    	  }
    	  if($("#channelType").length >0){
	    	 var channelType = $("#channelType").val();
    		 url += '&channelType=';
    		 url += channelType;
    	  }
    	  /* else{
    		  alert('13699562589');
    	  } */
       	   if(rootAgencyId == 0){
	       	  var epName = $('#epName').val();
       		  url += '&epName=';
	    	  url += epName;
	       	 // alert(epEngId);
	       	  $.ajax({
	                type: "post",
	                url: url,
	                dataType: "json",
	                async: false,
	                contentType: "application/x-www-form-urlencoded; charset=utf-8", 
	                success: function(data){
	                	var appendData = "<label class='form-label col-xs-4 col-sm-3'><span class='c-red'>*</span>通道：</label><div class='formControls col-xs-8 col-sm-9 skin-minimal'>";
	                	var dataRole = eval(data);
	                	//alert(dataRole.length);
	                	if(dataRole.length > 0){
		                      for(var i=0; i < dataRole.length; i++){
		                    	  var cnel_id = dataRole[i].id;
		                    	  var cdisId = dataRole[i].cdId;
		                    	  var cnel_name = dataRole[i].channelName;
		                    	  var ep_name = dataRole[i].epName;
		                    	  var ep_id = dataRole[i].epId;
		                    	  var cdiscount = dataRole[i].channelDiscount;
		                    	  appendData += "<div class='radio-box'><input type='hidden' value='"+cnel_id+"'></input><input class='cNameRadio' type='radio' name='cNameRadio' id='cname-"+(i+1)+"' onclick='togglelePg(this)'><label for='cname-"+(i+1)+"'>"
                 					+cnel_name+"</label></div><input type='hidden' class='price' value='"+ep_id+"'></input>"
                 					+"<input type='hidden' value='"+cdiscount+"'></input><input type='text' value='"+ep_name +"'></input><input type='hidden' value='"+cdisId+"'></input><br>";
                 					 /*appendData += "<label class='form-label col-xs-4 col-sm-3'><span class='c-red'>*</span>包体列表：</label><div class='formControls col-xs-8 col-sm-9 skin-minimal'>"
		                    	 //alert(dataRole[i].list.length);
		                    	  for(var j=0; j < dataRole[i].list.length; j++){
		                    		  var price = dataRole[i].list[j].chargeValue;
			                    	  var name = dataRole[i].list[j].pgName;
			                    	  var pgSize = dataRole[i].list[j].pgSize;
			                    	  var productCode = dataRole[i].list[j].productCode;
		                    		  appendData += "<div class='radio-box pgIdC'><input type='hidden' value='"+price+"'></input><input class='cNameRadio' type='radio' name='cNameRadio' id='cname-"+(i+1)+"' onclick='changeChannelRadio(this)'><label for='cname-"+(i+1)+"'>"
	                 					+name+"</label></div><input type='hidden' class='price' value='"+pgSize+"'></input>"
	                 					+"<input type='hidden' value='"+productCode+"'></input><input type='text' value='"+price +"'></input><br>";
		                    	  } */
		                    	  //appendData += "</div>";
		                      }
		                }
	                	appendData += "</div>";
		            	$("#cnelInsert").prepend(appendData);
		            	$("#cnelInsert").show();
	                }
	       	  })
       		  /*  $.ajax({
	                type: "post",
	                url: '/flowsys/chargePg/pgList_super_forPurchase.do?operatorName='+ carrier + '&serviceType=' + serviceType + '&epEngId=' + epEngId,
	                dataType: "json",
	                async: false,
	                contentType: "application/x-www-form-urlencoded; charset=utf-8", 
	                success: function(data){
	              	  //alert(data.pgList.length);
	              	  if($(".pgNameType") == undefined || $(".pgNameType").length <= 0){
	                  var appendData = "<label class='form-label col-xs-4 col-sm-3'><span class='c-red'>*</span>包体大小：</label><div class='formControls col-xs-8 col-sm-9 skin-minimal'>"; 
	                  if(data.pgList.length > 0){
	                      for(var i=0; i < data.pgList.length; i++){
	                    	   var price = data.pgList[i].chargeValue;
	                    	   var name = data.pgList[i].pgName;
	                    	   var pgSize = data.pgList[i].pgSize;
	                    	   var productCode = data.pgList[i].productCode;
	                    	   var cdis = data.pgList[i].cdis;
	                    	   var cnelName = data.pgList[i].cnelName;
	                    	   var cdisId = data.pgList[i].cdisId;
	                    	   var channelId = data.pgList[i].channelId;
	                    	   var pgDiscountPrice = data.pgList[i].pgDiscountPrice;
	                   					appendData += "<div class='radio-box pgNameType'><input type='hidden' value='"+data.pgList[i].id+"'></input><input class='pgNameRadio' type='radio' name='pgNameRadio' id='pgName-"+(i+1)+"' onclick='changeRadio(this)'><label for='pgName-"+(i+1)+"'>"
	                   					+name+"</label></div><input type='hidden' class='price' value='"+price+"'></input>"
	                   					+"<input type='hidden' value='"+pgSize+"'></input><input type='hidden' value='"+productCode+"'></input><input type='hidden'  value='"+pgDiscountPrice 
	                   					+"'></input></input><input type='hidden' value='"+cdis +"'></input><input type='hidden' value='"+channelId +"'></input><input type='hidden' value='"+cdisId +"'></input><input type='text' value='"+cnelName +"'></input><br>";;
	                   				// }
	                      }
	                  }else{
	                	  appendData += "没有配置该业务类型，或者号码不符合充值条件！！";
	                	  $("#chargeValue").val("");//重置参数
	                	  $("#orderAmount").val("");
	                	  
	              	  }
	              	appendData += "</div>";
	            	$("#pgInsert").prepend(appendData);
	            	$("#pgInsert").show();
	              	  }
	              	  }
	            })  */
	       	   }else{
		       		$.ajax({
		                type: "post",
		                url: url,
		                dataType: "json",
		                async: false,
		                contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		                success: function(data){
		              	  //alert(data.pgList.length);
		              		//$('#rateDiscount').html(data.ratePo.activeDiscount);
		              		//$('#rateId').val(data.ratePo.id);
		              		var dataRole = eval(data);
		              		//alert(dataRole.length);
		              	  if($(".pgNameType") == undefined || $(".pgNameType").length <= 0){
		                  var appendData = "<label class='form-label col-xs-4 col-sm-3'><span class='c-red'>*</span>选择包体：</label><div class='formControls col-xs-8 col-sm-9 skin-minimal'>"; 
		                  if(dataRole.length > 0){
		                      for(var i=0; i < dataRole.length; i++){
		                    	   var price = dataRole[i].pgPrice;
		                    	   var name = dataRole[i].pgName;
		                    	   var pgSize = dataRole[i].pgSize;
		                    	   var serviceType = dataRole[i].serviceType;
		                    	   //alert(serviceType);
		                    	   //var productCode = dataRole[i].productCode;
		                    	   //var pgDiscountPrice = dataRole[i].pgDiscountPrice;
		                    	   //var rteDis = dataRole[i].rteDis;
		                    	   //var rteId = dataRole[i].rteId;
		                    	   var channelId = dataRole[i].channelId;
		                   				/* if(i == 0){//默认设置第一个为选中 
		        	           				appendData += "<div class='radio-box pgNameType'><input name='pgName' class='pgNameRadio' type='radio' id='pgName-"+(i+1)+"' onclick='changeRadio(this)' checked><label for='pgName-"+(i+1)+"'>"+name+"</label></div>"
		        	           				+ "<input type='hidden' name='chargeValue' value='"+price+"'></input>"
		        	           				+ "<input type='hidden'  name='pgSize' value='"+pgSize+"'></input><br>";
		        	           				//$("#chargeValue").val(data[0].chargeValue);
		        	           				$("#pgSize").val(data[0].pgSize);
		        	           				$("#pgId").val(data[0].id);
		                   				}else{ */
		                   					appendData += "<div class='radio-box pgNameType'><input class='pgNameRadio' type='radio' name='pgId' value='"+dataRole[i].id+"' id='pgName-"+(i+1)+"' onclick='changeRadio(this,"+channelId+")'><label for='pgName-"+(i+1)+"'>"+name+"</label></div><input type='hidden' class='price' value='"+price+"'></input>"
		                   					+"<input type='hidden' value='"+pgSize+"'></input><input type='hidden' value='"+channelId+"'></input>"
		                   					/* <input type='hidden' value='"+productCode+"'></input><input type='hidden'  value='"+pgDiscountPrice +"'></input></input><input type='hidden' value='"+rteDis 
		                   					+"'></input><input type='hidden' value='"+channelId +"'></input><input type='hidden' value='"+rteId +"'></input><br>";; */
		                   				// }
		                      }
		                  }else{
		                	  appendData += "没有配置该业务类型，或者号码不符合充值条件！！";
		                	  $("#chargeValue").val("");//重置参数
		                	  $("#orderAmount").val("");
		              	  }
		              	appendData += "</div>";
		              	$("#pgInsert").empty();
		            	$("#pgInsert").prepend(appendData);
		            	$("#pgInsert").show();
		              	  }
		              	  }
		            }) 
       	   }
             }	 	
         }else{
        	 alert("false");
             //$('.error').html('手机号不合法 ').css('display','block');    
         }
     }
 </script>
</html>