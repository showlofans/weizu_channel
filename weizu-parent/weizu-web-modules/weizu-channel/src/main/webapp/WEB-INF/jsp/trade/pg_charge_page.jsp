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
<link href="/view/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="/view/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
 </head>
 <body>
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
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>业务类型：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<%-- <c:forEach items="${resultMap.serviceTypeEnum }" var="serviceType" varStatus="vs">
					<div class="radio-box">
						<input onclick="ajaxPg(this)" name=serviceType type="radio" value="${serviceType.value }" id="serviceType-${vs.index+1 }" checked>
						<label for="serviceType-${vs.index+1 }">${serviceType.desc }</label>
					</div> 				</c:forEach>
					--%>
					<span class="select-box inline">
						<select id="select-servce-type" name="serviceType" onchange="ifAjaxPg()" style="width:150px;" class="select">
							<option value="">请选择</option>
							<c:forEach items="${resultMap.serviceTypeEnum }" var="typeEnum" varStatus="vs1">
								<option value="${typeEnum.value }" <c:if test="${typeEnum.value == resultMap.params.serviceType }"> selected</c:if>>${typeEnum.desc }</option>
							</c:forEach>
						</select>
					</span>
				
				<!-- <div class="radio-box">
					<input type="radio" id="sex-2" name="sex">
					<label for="sex-2">女</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="sex-3" name="sex">
					<label for="sex-3">保密</label>
				</div> -->
			</div>
		</div>
	<div class="row cl" id="pg">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>流量面值：</label>
		<div class="formControls col-xs-8 col-sm-9">
		<!--  onfocus="ajaxPg()" -->
			<input type="text" id="pgPrice" readonly name="pgPrice" class="input-text" required style="width:400px" autocomplete="off"  placeholder="请选择购买包体" >
			<!-- <div>
				<span class="pgName"></span>
				<span style="display:none;" class="pgName"></span>
				<span style="display:none;" class="pgPrice"></span>
				<span style="display:none;"  class="pgName"></span>
			</div> -->
			<!-- <input type="password" class="input-text" autocomplete="off"  placeholder="确认新密码" id="password2" name="password2"> -->
		</div>
	</div>
	<div id="pgInsert" class="row cl">
		<!-- style="display:none;"  -->
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>采购金额：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input id="orderAmount" name="orderAmount" type="text" readonly class="input-text" required  style="width:400px" value="" placeholder="请选择购买包体">
			<input id="rateId" name="rateId" type="hidden" value="">
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
 /* function submitPur(){
	 var tel = $('input[name=chargeTel]').val();
	 var chargeTelDetail = $('#chargeTelDetail').val();
	 var orderAmount = $("#orderAmount").val();
 	 var channelId = $("#channelId").val();
 	 var pgId = $("#pgId").val();
	 var purchasePo = {
			 chargeTel : tel,
			 channelId : channelId,
			 pgId : pgId,
			 chargeTelDetail : chargeTelDetail,
			 orderAmount : orderAmount
         };//拼装成json格式
    alert(JSON.stringify(purchasePo));
	 $.ajax({
         type : "POST",
         url : "/flowsys/chargePg/pg_charge.do",
         data : JSON.stringify(purchasePo),
         contentType : 'application/json;charset=utf-8',
         dataType : 'json',
         /* success : function(data) {
               if (data.code == '0') {
                 window.location.href = "/iswust2hand/index.jsp";
                 alert("欢迎使用西科二手平台！");
             }else{
                 alert("密码错误，请确认后重新登录！");
             }  

         },

         error : function(data) {
             alert("出错：" + data.code);
         } 
     });
 } */
 
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
   function changeRadio(vart){
	   var pprice = $(vart).parent().next().val();
	   var psize = $(vart).parent().next().next().val();//包大小
	   var productCode = $(vart).parent().next().next().next().val();//包编码
	   //alert(productCode);
	   $("#productCode").val(productCode);
	   
	   $("#pgPrice").val(pprice);//改变价格
	   //alert($(vart).prev().val());
	   $("#pgId").val($(vart).prev().val());//包体id
	   
	   var serviceType = $("#select-servce-type").val();
	   var carrier = $("#chargeTelDetail").val();
	   
	   $.ajax({
           type: "get",
           url: '/flowsys/chargePg/ajax_purchase_price.do?pgSize=' + psize + '&pgPrice=' + pprice + '&serviceType='+serviceType+ '&carrier='+carrier,
           async: false,
           dataType: "json",
           contentType: "application/x-www-form-urlencoded; charset=utf-8", 
           success: function(data){
        	   /* $.each(data,function(i){  
        		    var key = i;  
        		    var value = data[i];  
        		    alert(key+":"+value);  
        		});  */
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
       })
	   
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
	
    function ajaxPg(){
    	 tel=$('input[name=chargeTel]').val();
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
            	 /* else{
               		 alert("sorry");
               	 } */
            	//查询流量包
            	 	//ajax2();
            	 	$.ajax({
                        type: "post",
                        url: '/flowsys/chargePg/pgList_forPurchase.do?operatorName='+ carrier + '&serviceType=' + serviceType,
                        dataType: "json",
                        async: false,
                        contentType: "application/x-www-form-urlencoded; charset=utf-8", 
                        success: function(data){
                      	  //alert(data.pgList.length);
                      		$('#rateDiscount').html(data.ratePo.activeDiscount);
                      		$('#rateId').val(data.ratePo.id);
                      	  if($(".pgNameType") == undefined || $(".pgNameType").length <= 0){
                          var appendData = "<label class='form-label col-xs-4 col-sm-3'><span class='c-red'>*</span>包体大小：</label><div class='formControls col-xs-8 col-sm-9 skin-minimal'>"; 
                          if(data.pgList.length > 0){
	                          for(var i=0; i < data.pgList.length; i++){
	                        	   var price = data.pgList[i].pgPrice;
	                        	   var name = data.pgList[i].pgName;
	                        	   var pgSize = data.pgList[i].pgSize;
	                        	   var productCode = data.pgList[i].productCode;
	                       				/* if(i == 0){//默认设置第一个为选中 
	            	           				appendData += "<div class='radio-box pgNameType'><input name='pgName' class='pgNameRadio' type='radio' id='pgName-"+(i+1)+"' onclick='changeRadio(this)' checked><label for='pgName-"+(i+1)+"'>"+name+"</label></div>"
	            	           				+ "<input type='hidden' name='pgPrice' value='"+price+"'></input>"
	            	           				+ "<input type='hidden'  name='pgSize' value='"+pgSize+"'></input><br>";
	            	           				//$("#pgPrice").val(data[0].pgPrice);
	            	           				$("#pgSize").val(data[0].pgSize);
	            	           				$("#pgId").val(data[0].id);
	                       				}else{ */
	                       					appendData += "<div class='radio-box pgNameType'><input type='hidden' value='"+data.pgList[i].id+"'></input><input class='pgNameRadio' type='radio' name='pgNameRadio' id='pgName-"+(i+1)+"' onclick='changeRadio(this)'><label for='pgName-"+(i+1)+"'>"+name+"</label></div><input type='hidden' class='price' value='"+price+"'></input>"
	                       					+"<input type='hidden' value='"+pgSize+"'></input><input type='hidden' value='"+productCode+"'></input><br>";;
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
             }else{
            	 alert("false");
                 //$('.error').html('手机号不合法 ').css('display','block');    
             }
         }
    }
 </script>
</html>