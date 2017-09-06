<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
 <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 在线充值 <span class="c-gray en">&gt;</span> 单号充值<!--  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a> --></nav>
 <article class="page-container">
 	<form class="form form-horizontal" action="/flowsys/chargePg/pg_charge.do" method="post"  id="form-charge">
 	<input type="hidden" name="channelId" id="channelId">
 	<input type="hidden" name="billType" id="billType">
 	<input type="hidden" name="pgId" id="pgId">
 	<input type="hidden" name="productCode" id="productCode">
 	<input style="display: none;" type="text" value="${resultMap.pageMsg }" id="pageMsg">
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机号码：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" required="required" onchange="initForm()" onblur="ajaxPhone()" style="width:400px" value="" placeholder="" id="chargeTel" name="chargeTel">
			<span class="error"></span>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>归属地：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" required  style="width:400px" value="" placeholder="" id="chargeTelDetail" name="chargeTelDetail">
		</div>
	</div>
	<input id="rootAgencyId" value="${loginContext.rootAgencyId}" type="hidden" >
	<c:if test="${loginContext.rootAgencyId == 0 }">
		<div class="row cl" id="pg">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>测试平台：</label>
			<div class="formControls col-xs-8 col-sm-9">
			<!--  onfocus="ajaxPg()" -->
				<input type="text" id="epEngId" name="epEngId" class="input-text" required style="width:400px" autocomplete="off"  placeholder="请输入英文标识" >
			</div>
		</div>
	</c:if>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>业务类型：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
					<span class="select-box inline">
						<select id="select-servce-type" name="serviceType" onchange="ifAjaxPg()" style="width:150px;" class="select">
							<option value="">请选择</option>
							<c:forEach items="${resultMap.serviceTypeEnum }" var="typeEnum" varStatus="vs1">
								<option value="${typeEnum.value }" <c:if test="${typeEnum.value == resultMap.params.serviceType }"> selected</c:if>>${typeEnum.desc }</option>
							</c:forEach>
						</select>
					</span>
			</div>
		</div>
		
	<div class="row cl" id="pg">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>流量面值：</label>
		<div class="formControls col-xs-8 col-sm-9">
		<!--  onfocus="ajaxPg()" -->
			<input type="text" id="pgPrice" readonly name="pgPrice" class="input-text" required style="width:400px" autocomplete="off"  placeholder="请选择购买包体" >
		</div>
	</div>
	<div id="pgInsert" class="row cl">
		<!-- style="display:none;"  -->
	</div>
	<div id="cnelInsert" class="row cl">
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>采购金额：</label>
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
			<br>折扣：<span id="rateDiscount" class="c-red"></span>
		</div>
	</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
	</form>
	
	<!-- <input id="pgSize" type="hidden"></input -->
</article>
 </body>
  <script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
  <script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
  <script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
  <script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/messages_zh.js"></script>
 <script type="text/javascript">
 $().ready(function() {
	 if($('#pageMsg').val() != ''){
		 alert($('#pageMsg').val());
	 }
	    $("#form-charge").validate({
	    	submitHandler : function(form) {
	    		form.submit();
	    		/* $.ajax({
			        type:"post",
			        url:"/flowsys/chargePg/pg_charge.do",
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
			    }); */ 
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
             url: 'http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel='+tel,
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
              //$('#chargeTelDetail').val(location);  
                
               /*  $('.num span').html(num);
                
                $('.province span').html(province);
                $('.operators span').html(operators);
                $('.carrier span').html(carrier); */
             },
         });
    };
    /**radio选中事件*/
    function changeValue(vart){
    	if($(vart).is(':checked')){
    		$("#pgName").val($(vart).val());
    		//alert($(vart).privous().val());
    	}
    }
   
    var reg = /^(13|15|18)[0-9]{9}$/;//点击查询
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
            	   var price = data[i].pgPrice;
            	   var name = data[i].pgName;
           				if(i == 0){//默认设置第一个为选中 
	           				appendData += "<div class='radio-box pgNameType'><input name='pgName' class='pgNameRadio' type='radio' id='pgName-"+(i+1)+"' onclick='changeRadio(this)' checked><label for='pgName-"+(i+1)+"'>"+name+"</label></div><input type='hidden' class='price' name='pgPrice' value='"+price+"'></input><br>";
	           				$("#pgPrice").val(data[0].pgPrice);
           				}else{
           					
           				appendData += "<div class='radio-box pgNameType'><input name='pgName' class='pgNameRadio' type='radio' id='pgName-"+(i+1)+"' onclick='changeRadio(this)'><label for='pgName-"+(i+1)+"'>"+name+"</label></div><input type='hidden' class='price' name='pgPrice' value='"+price+"'></input><br>";
           				}
              }
          	appendData += "</div>";
        	$("#pg").prepend(appendData);
        	
          	  }}
        })
    }; */
    var rootAgencyId = $('#rootAgencyId').val();
	//   alert(rootAgencyId);
     function changeChannelRadio(vart){
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
                 	   var price = data.pgList[i].pgPrice;
                 	   var name = data.pgList[i].pgName;
                 	   var pgSize = data.pgList[i].pgSize;
                 	   var productCode = data.pgList[i].productCode;
                 	   var pgDiscountPrice = data.pgList[i].pgDiscountPrice;
                 	   var rteDis = data.pgList[i].rteDis;
                 	   var rteId = data.pgList[i].rteId;
                 	   var channelId = data.pgList[i].channelId;
                				/* if(i == 0){//默认设置第一个为选中 
     	           				appendData += "<div class='radio-box pgNameType'><input name='pgName' class='pgNameRadio' type='radio' id='pgName-"+(i+1)+"' onclick='changeRadio(this)' checked><label for='pgName-"+(i+1)+"'>"+name+"</label></div>"
     	           				+ "<input type='hidden' name='pgPrice' value='"+price+"'></input>"
     	           				+ "<input type='hidden'  name='pgSize' value='"+pgSize+"'></input><br>";
     	           				//$("#pgPrice").val(data[0].pgPrice);
     	           				$("#pgSize").val(data[0].pgSize);
     	           				$("#pgId").val(data[0].id);
                				}else{ */
                					appendData += "<div class='radio-box pgNameType'><input type='hidden' value='"+data.pgList[i].id+"'></input><input class='pgNameRadio' type='radio' name='pgNameRadio' id='pgName-"+(i+1)+"' onclick='changeRadio(this)'><label for='pgName-"+(i+1)+"'>"+name+"</label></div><input type='hidden' class='price' value='"+price+"'></input>"
                					+"<input type='hidden' value='"+pgSize+"'></input><input type='hidden' value='"+productCode+"'></input><input type='hidden'  value='"+pgDiscountPrice +"'></input></input><input type='hidden' value='"+rteDis 
                					+"'></input><input type='hidden' value='"+channelId +"'></input><input type='hidden' value='"+rteId +"'></input><br>";;
                				// }
                   }
               }else{
             	  appendData += "没有配置该业务类型，或者号码不符合充值条件！！";
             	  $("#pgPrice").val("");//重置参数
             	  $("#orderAmount").val("");
             	  
           	  }
           	appendData += "</div>";
         	$("#pgInsert").prepend(appendData);
         	$("#pgInsert").show();
           	  }
           	  }
         }) 
     }
	
	function changeRadio(vart){
	   var pprice = $(vart).parent().next().val();
	   var psize = $(vart).parent().next().next().val();//包大小
	   var productCode = $(vart).parent().next().next().next().val();//包编码
	   var pgDiscountPrice = $(vart).parent().next().next().next().next().val();
	   var rateDis = $(vart).parent().next().next().next().next().next().val();
	   var channelId = $(vart).parent().next().next().next().next().next().next().val();
	  // alert(channelId);
	   if(rootAgencyId == 0){
		   var cdisId = $(vart).parent().next().next().next().next().next().next().next().val();
		   $('#cdisId').val(cdisId);
		   //alert(cdisId);
	   }else{
		   var rteId = $(vart).parent().next().next().next().next().next().next().next().val();
		   $('#rateId').val(rteId);
	   }
	   $('#rateDiscount').html(rateDis);
	   //alert(channelId);
	   $('#channelId').val(channelId);
	   //alert(productCode);
	   $("#productCode").val(productCode);
	   $("#orderAmount").val(pgDiscountPrice);
	   $("#pgPrice").val(pprice);//改变价格
	   //alert($(vart).prev().val());
	   $("#pgId").val($(vart).prev().val());//包体id
	   
	   var serviceType = $("#select-servce-type").val();
	   var carrier = $("#chargeTelDetail").val();
	   $("#billType").val(0);
	   /* $.ajax({
           type: "get",
           url: '/flowsys/chargePg/ajax_purchase_price.do?pgSize=' + psize + '&pgPrice=' + pprice + '&serviceType='+serviceType+ '&carrier='+carrier,
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
        	if(data.msg == 2){
        		alert('账户余额不足');
        	}else{
	         	 $("#orderAmount").val(data.price);
	         	 $("#channelId").val(data.channelId);
	         	// alert(data.rateDiscount);
        	}
         	 $('#rateDiscount').html(data.rateDiscount);
        		
         	 $("#billType").val(data.billType);
           }
       }) */
	   
   }
   /*  $('.skin-minimal input').on('iCheck',{		//给单选框加特效
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	}); */
	/**改变业务类型Onchange方法*/
	function ifAjaxPg(){
		/* var priceT = $("#pgPrice").val();
		if(priceT != "" || priceT != null){//
			ajaxPg();//重新发送一次请求
		} */
		$("#pgPrice").val("");//重置参数
  	 	 $("#orderAmount").val("");
  		ajaxPg();
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
	/**响应包体点击事件*/
	function getPrice(vart){
		var pgPrice = $(vart).parent().next().val();//包体价格
		var productCode = $(vart).parent().next().next().next().val();//包体编码
		var cdis = $('#rateDiscount').html();
		var orderAmount = numMulti(pgPrice,cdis);
		//alert(orderAmount);
		var pgId =  $(vart).prev().val();
		$("#pgId").val(pgId);
		$("#productCode").val(productCode);
		$("#orderAmount").val(orderAmount);
		$("#pgPrice").val(pgPrice);
	};
	
	/**异步获得充值包体列表*/
	function togglelePg(vart){
		
		
		var cnelId =  $(vart).prev().val();
		$('#channelId').val(cnelId);
		
		var cdiscount = $(vart).parent().next().next().val();//通道折扣
		$('#rateDiscount').html(cdiscount);//通道折扣
		
		// alert(cnelId);
		 var carrier = $("#chargeTelDetail").val();
    	 var serviceType = $("#select-servce-type").val();
    	 var epEngId = $('#epEngId').val();
    	 $.ajax({
             type: "post",
             url: '/flowsys/chargePg/ajax_charge_pg.do?carrier='+ carrier + '&serviceType=' + serviceType + '&epEngId=' + epEngId+ '&channelId=' + cnelId,
             dataType: "json",
             async: false,
             contentType: "application/x-www-form-urlencoded; charset=utf-8", 
             success: function(data){
           	  //alert(data.pgList.length);
           	  var dataRole1 = eval(data);
           	  //alert(dataRole1.length);
           	  if($(".pgNameType") == undefined || $(".pgNameType").length <= 0){
               var appendData1 = "<label class='form-label col-xs-4 col-sm-3'>包体大小：</label><div class='formControls col-xs-8 col-sm-9 skin-minimal'>"; 
               if(dataRole1.length > 0){
                   for(var i=0; i < dataRole1.length; i++){
                 	   var price = dataRole1[i].pgPrice;
                 	   var name = dataRole1[i].pgName;
                 	   //alert(name);
                 	   var pgSize = dataRole1[i].pgSize;
                 	   var productCode = dataRole1[i].productCode;
                 	   //var cdis = dataRole1[i].cdis;
                 	  // var cdisId = dataRole1[i].cdisId;
                 	   //var pgDiscountPrice = dataRole1[i].pgDiscountPrice;
       					appendData1 += "<div class='radio-box pgNameType'><input type='hidden' value='"+dataRole1[i].id+"'></input><input class='pgNameRadio' type='radio' name='pgNameRadio' id='pgName-"+(i+1)+"' onclick='getPrice(this)'><label for='pgName-"+(i+1)+"'>"
       					+name+"</label></div><input type='hidden' class='price' value='"+price+"'></input>"
       					+"<input type='hidden' value='"+pgSize+"'></input><input type='hidden' value='"+productCode+"'></input>";
       				 }
                   appendData1 += "</div>";
               }else{
             	  appendData1 += "没有配置该业务类型，或者号码不符合充值条件！！";
             	  $("#pgPrice").val("");//重置参数
             	  $("#orderAmount").val("");
             	  
           	  }
           	appendData1 += "</div>";
         	$("#pgInsert").prepend(appendData1);
         	$("#pgInsert").show();
           	  }
           	  }
         })
	}
	
    function ajaxPg(){
    	 tel=$('input[name=chargeTel]').val();
    	 var carrier = $("#chargeTelDetail").val();
    	 var serviceType = $("#select-servce-type").val();
    	 //alert(serviceType);
         if(tel){
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
	       	  var epEngId = $('#epEngId').val();
	       	
	       	 // alert(epEngId);
	       	  $.ajax({
	                type: "post",
	                url: '/flowsys/chargePg/ajax_charge_channel.do?carrier='+ carrier + '&serviceType=' + serviceType + '&epEngId=' + epEngId,
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
		                    	  var cnel_name = dataRole[i].channelName;
		                    	  var ep_name = dataRole[i].epName;
		                    	  var ep_id = dataRole[i].epId;
		                    	  var cdiscount = dataRole[i].channelDiscount;
		                    	  appendData += "<div class='radio-box'><input type='hidden' value='"+cnel_id+"'></input><input class='cNameRadio' type='radio' name='cNameRadio' id='cname-"+(i+1)+"' onclick='togglelePg(this)'><label for='cname-"+(i+1)+"'>"
                 					+cnel_name+"</label></div><input type='hidden' class='price' value='"+ep_id+"'></input>"
                 					+"<input type='hidden' value='"+cdiscount+"'></input><input type='text' value='"+ep_name +"'></input><br>";
                 					 /*appendData += "<label class='form-label col-xs-4 col-sm-3'><span class='c-red'>*</span>包体列表：</label><div class='formControls col-xs-8 col-sm-9 skin-minimal'>"
		                    	 //alert(dataRole[i].list.length);
		                    	  for(var j=0; j < dataRole[i].list.length; j++){
		                    		  var price = dataRole[i].list[j].pgPrice;
			                    	  var name = dataRole[i].list[j].pgName;
			                    	  var pgSize = dataRole[i].list[j].pgSize;
			                    	  var productCode = dataRole[i].list[j].productCode;
		                    		  appendData += "<div class='radio-box pgIdC'><input type='hidden' value='"+price+"'></input><input class='cNameRadio' type='radio' name='cNameRadio' id='cname-"+(i+1)+"' onclick='changeChannelRadio(this)'><label for='cname-"+(i+1)+"'>"
	                 					+name+"</label></div><input type='hidden' class='price' value='"+pgSize+"'></input>"
	                 					+"<input type='hidden' value='"+productCode+"'></input><input type='text' value='"+price +"'></input><br>";
		                    	  } */
		                    	  appendData += "</div>";
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
	                    	   var price = data.pgList[i].pgPrice;
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
	                	  $("#pgPrice").val("");//重置参数
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
		                url: '/flowsys/chargePg/pgList_forPurchase.do?operatorName='+ carrier + '&serviceType=' + serviceType,
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
		                  var appendData = "<label class='form-label col-xs-4 col-sm-3'><span class='c-red'>*</span>包体大小：</label><div class='formControls col-xs-8 col-sm-9 skin-minimal'>"; 
		                  if(dataRole.length > 0){
		                      for(var i=0; i < dataRole.length; i++){
		                    	   var price = dataRole[i].pgPrice;
		                    	   var name = dataRole[i].pgName;
		                    	   var pgSize = dataRole[i].pgSize;
		                    	   var productCode = dataRole[i].productCode;
		                    	   var pgDiscountPrice = dataRole[i].pgDiscountPrice;
		                    	   var rteDis = dataRole[i].rteDis;
		                    	   var rteId = dataRole[i].rteId;
		                    	   var channelId = dataRole[i].channelId;
		                   				/* if(i == 0){//默认设置第一个为选中 
		        	           				appendData += "<div class='radio-box pgNameType'><input name='pgName' class='pgNameRadio' type='radio' id='pgName-"+(i+1)+"' onclick='changeRadio(this)' checked><label for='pgName-"+(i+1)+"'>"+name+"</label></div>"
		        	           				+ "<input type='hidden' name='pgPrice' value='"+price+"'></input>"
		        	           				+ "<input type='hidden'  name='pgSize' value='"+pgSize+"'></input><br>";
		        	           				//$("#pgPrice").val(data[0].pgPrice);
		        	           				$("#pgSize").val(data[0].pgSize);
		        	           				$("#pgId").val(data[0].id);
		                   				}else{ */
		                   					appendData += "<div class='radio-box pgNameType'><input type='hidden' value='"+dataRole[i].id+"'></input><input class='pgNameRadio' type='radio' name='pgNameRadio' id='pgName-"+(i+1)+"' onclick='changeRadio(this)'><label for='pgName-"+(i+1)+"'>"+name+"</label></div><input type='hidden' class='price' value='"+price+"'></input>"
		                   					+"<input type='hidden' value='"+pgSize+"'></input><input type='hidden' value='"+productCode+"'></input><input type='hidden'  value='"+pgDiscountPrice +"'></input></input><input type='hidden' value='"+rteDis 
		                   					+"'></input><input type='hidden' value='"+channelId +"'></input><input type='hidden' value='"+rteId +"'></input><br>";;
		                   				// }
		                      }
		                  }else{
		                	  appendData += "没有配置该业务类型，或者号码不符合充值条件！！";
		                	  $("#pgPrice").val("");//重置参数
		                	  $("#orderAmount").val("");
		                	  
		              	  }
		              	appendData += "</div>";
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