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
  <title>话费充值</title>
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
 <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 在线充值 <span class="c-gray en">&gt;</span> 话费充值 <span class="c-gray en">&gt;</span> 单号充值<!--  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a> --><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
<article class="page-container">
 	<form class="form form-horizontal" action="" method=""  id="form-charge">
 	<input type="hidden" name="billType" id="billType">
 	
 	<input type="hidden" name="telProductId" id="telProductId">
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
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><!--<span class="c-red">*</span>-->业务类型：</label>
		<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<span class="select-box inline">
					<select id="select-servce-type" name="serviceType" onchange="ifAjaxPg()"  style="width:150px;" class="select"><!-- onchange="ifAjaxPg()" -->
						<option value="">请选择</option>
						<c:forEach items="${resultMap.huaServiceTypeEnum }" var="typeEnum" varStatus="vs1">
							<option value="${typeEnum.value }" <c:if test="${typeEnum.value == resultMap.params.serviceType }"> selected</c:if>>${typeEnum.desc }</option>
						</c:forEach>
					</select>
				</span>
					<!-- <span style="width: 300;" onclick="showNext(this)" title="提示信息"><i class="Hui-iconfont">&#xe6cd;</i></span>
					<span class="select-box inline" style="display:none;" >
					</span> -->
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">充值速度：</label>
		<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<span class="select-box inline">
					<select id="chargeSpeed" onchange="ifAjaxPg()" style="width:150px;" class="select">
						<!-- <option value="">请选择</option> -->
						<c:forEach items="${resultMap.telchargeSpeedEnums }" var="typeEnum" varStatus="vs1">
							<option value="${typeEnum.value }" <c:if test="${typeEnum.value == resultMap.params.chargeSpeed }"> selected</c:if>>${typeEnum.desc }</option>
						</c:forEach>
					</select>
				</span>
		</div>
	</div>
	<div class="row cl" id="rateForDiv" style="display:none">
		<label class="form-label col-xs-4 col-sm-3">折扣类型：</label>
		<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<span class="select-box inline">
					<select onchange="ifAjaxPg()" id="rateFor" style="width:150px;" class="select">
						<!-- <option value="">请选择</option> -->
						<c:forEach items="${resultMap.telChannelTagEnums }" var="telChannelTagEnum" varStatus="vs1">
							<option value="${telChannelTagEnum.value }" <c:if test="${telChannelTagEnum.value == resultMap.params.rateFor }"> selected</c:if>>${telChannelTagEnum.desc }</option>
						</c:forEach>
					</select>
				</span>
		</div>
	</div>
	
		
		
	<div class="row cl" id="pg">
		<label class="form-label col-xs-4 col-sm-3"><!--<span class="c-red">*</span>-->话费面值：</label>
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
					<input id="telchannelId" name="telchannelId" type="hidden" value="">
				</c:when>
				<c:otherwise>
					<input id="telRateId" name="telRateId" type="hidden" value="">
				</c:otherwise>
			</c:choose>
			<br>折扣：<span id="rateDiscount" class="c-red"></span>
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
			<textarea readonly="readonly" style="height:350px;  " name="" cols="30" rows="" class="textarea"  placeholder="介绍属性介绍，
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
	 if($('#pageMsg').val() != ''){
		 alert($('#pageMsg').val());
	 }
	    $("#form-charge").validate({
	    	submitHandler : function(form) {
	    		$.ajax({
			        type:"post",
			        url:"/flowsys/chargeTel/tel_charge.do",
			        data: $('form').serialize(),//表单数据
			        async : false,
			        success:function(d){
			        	if(d == '订单提交成功'){
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
       /* $.ajax({
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
             },
         });*/
         //聚合接口
    	 $.ajax({
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
    
    var rootAgencyId = $('#rootAgencyId').val();
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
		var telRateId = $(vart).prev().val();
	   var chargeValue = $(vart).val();
	   var discount = $(vart).parent().next().val();		//折扣
	   var telCode = $(vart).parent().next().next().val();	//编码】
	   var telchannelId = $(vart).parent().next().next().next().val();	//话费通道id
	   var telProductId = $(vart).parent().next().next().next().next().val();	//话费通道id
	   $('#rateDiscount').html(discount);
	   $('#telRateId').val(telRateId);
	   $('#telchannelId').val(telchannelId);
	   
		var orderAmount = numMulti(chargeValue,discount);
		//alert(orderAmount);
		$("#telCode").val(telCode);
		$("#orderAmount").val(orderAmount);
		$("#chargeValue").val(chargeValue);
		$("#telProductId").val(telProductId);
	};
    
   /*  function changeRadio(vart){
	   var telRateId = $(vart).prev().val();
	   var chargeValue = $(vart).val();
	   var discount = $(vart).parent().next().val();		//折扣
	   var telCode = $(vart).parent().next().next().val();	//编码
	   var telchannelId = $(vart).parent().next().next().next().val();	//话费通道id
	   
	   var serviceType = $("#select-servce-type").val();
       //$("#pgId").val(pgId);//包体id
       var carrier = $('#chargeTelDetail').val();
       	if(data.msg == 5002){
       		alert('账户余额不足');
       		$("#orderAmount").val('');
       		$("#").val('');
       	}else{
         	 $("#orderAmount").val(data.price);
         	
         	 $('#channelId').val(data.channelId);
         	 //if(data.cdId != null && data.cdId !=""){
         		 $('#telDdisId').val(data.cdId);
         	 //}else{
	         	 $('#telRateId').val(data.rateDiscountId);
         	 //}
      	   //alert(productCode);
      	   $("#productCode").val(data.productCode);
      	   $("#").val(pprice);//改变包体原价
      	   //alert($(vart).prev().val());
      	   
       	}
       	 $('#rateDiscount').html(data.rateDiscount);
      		
       	 $("#billType").val(data.billType);
	   
	  
	   
	   //var serviceType = $("#select-servce-type").val();
	   //var carrier = $("#chargeTelDetail").val();
	   //$("#billType").val(0);
	   
	   
   } */
   /*  $('.skin-minimal input').on('iCheck',{		//给单选框加特效
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	}); */
	/**改变业务类型Onchange方法*/
	function ifAjaxPg(){
		/* var priceT = $("#").val();
		if(priceT != "" || priceT != null){//
			ajaxPg();//重新发送一次请求
		} */
		//
		$("#chargeValue").val("");//重置参数
		 $("#orderAmount").val("");
		 $("#rateDiscount").html("");
		 /*  $("#orderAmount").val(""); */
  	 	var sType1 = $("#select-servce-type").val();
  	 	//异步获得价格折扣的时候
  	 	if(sType1 != null && sType1 != ''){
	  		//alert("1");
	  		var chargeTelDetail = $('#chargeTelDetail').val();//新疆乌鲁木齐联通
  		    var itag2 = 0;
			var provinceid = 0;
	  		var cityid = 0;
	  		if(chargeTelDetail != ''){
	  			$.getJSON("/view/mine/data/cityData.json",function(data){
		  		    ss=data;
		  		    //var html="<option value='-1'>==请选择==</option>";
		  		    var sb = '';
		  		    for(var i=0;i<ss.length;i++){
		  		    	var provinceName = ss[i].province;
		  		    	provinceName = provinceName.substring(0,2);
		  		    	//alert(provinceName);
		  		    	sb += provinceName;
		  		    	if(chargeTelDetail.indexOf(provinceName) != -1){
		  	                var citys=ss[i].cities;
		  	              provinceid = ss[i].provinceid;
		  	              	$('#provinceid').val(ss[i].provinceid);//为提单做准备
		  	              //alert(ss[i].province);
		  	              	itag2 = itag2 + 1;
		  	              	//alert(itag2);
		  	                for(var j=0;j<citys.length;j++){
		  	                	var cityName = citys[j].city;
		  	                	cityName = cityName.substring(0,cityName.length-1);
		  	                	sb += cityName;
		  	                	if(chargeTelDetail.indexOf(cityName) != -1){
		  	                		//有市级名称
		  	                		$('#cityid').val(citys[j].cityid);//为提单做准备
		  	                		cityid = citys[j].cityid;
		  	                		//alert(citys[j].cityid);
		  	                		
		  	                		//$('#provinceid').val(citys[j].provinceid);
		  	                	}else{//只有省级名称：设置只能选省内话费或者市内话费
		  	                		
		  	                		//$('#provinceid').val(citys[j].provinceid);
		  	                	}
		  	                	
		  	                	/* city.add(new Option(citys[j].city,citys[j].cityid));
		  	                	if(cityid == citys[j].cityid){
		  		   					city.options[j].selected=true;
		  	   					} */
		  	                }
		  		    	}
		  		    }
		  		    	//alert(itag2);
		  		    if(itag2 > 0){//得到了省份名称
		  		    	var chargeSpeed = $('#chargeSpeed').val();
		  		  		var url = '/flowsys/chargeTel/ajax_charge_telpc.do?provinceid=' + provinceid;
		  		  		url += '&cityid=';
		  		  		url += cityid;
		  		  		url += '&serviceType=';
		  		  		url += sType1;
		  		  		url += '&chargeSpeed=';
		  		  		url += chargeSpeed;
		  		  		//alert(itag2);
		  		  	if($('#rateForDiv').is(':visible')){
			  		  	url += '&rateFor=';
		  		  		url += $('#rateFor').val();
		  			}
		  		  		if(itag2 != 0){//省份合法，开始发送请求
		  		  			//alert(url);
		  		  			$.ajax({
		  		                type: "post",
		  		                url: url,
		  		                dataType: "json",
		  		                async: false,
		  		                contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		  		                success: function(data){
		  		                	var dataList = data.getRateList;
		  		                	var appendData1 = "<label class='form-label col-xs-4 col-sm-3'>话费价值：</label><div class='formControls col-xs-8 col-sm-9 skin-minimal'>"; 
		  		                    if(dataList != null && dataList.length > 0){
		  		                    	if(data.dataUser == 'yes'){
		  		                    		$('#rateForDiv').show();
		  		                    	}else{
		  		                    		$('#rateForDiv').hide();
		  		                    	}
		  		                    	
		  		                        for(var i=0; i < dataList.length; i++){
		  		                      	   var chargeValue = dataList[i].chargeValue;
		  		                      	   var discount = dataList[i].activeDiscount;
		  		                      	   var telCode = dataList[i].telCode;
		  		                      	   var telchannelId = dataList[i].telchannelId;
		  		                      	   var telProductId = dataList[i].telProductId;
		  	            					appendData1 += "<div class='radio-box pgNameType'><input type='hidden' value='";
		  	            					appendData1 += dataList[i].id;
		  	            					appendData1 += "'></input><input class='chargeValueRadio' type='radio' value='"+ chargeValue +"' name='chargeValueRadio' id='chargeValue-";
		  	            					appendData1 += (i+1);
		  	            					appendData1 += "' onclick='getPrice(this)'><label for='chargeValue-";
		  	            					appendData1 += (i+1);
		  	            					appendData1 += "'>";
		  	            					appendData1 += chargeValue;
		  	            					appendData1 += "元</label></div><input type='hidden' class='discount' value='";
		  	            					appendData1 += discount;
		  	            					appendData1 += "'></input>";
		  	            					appendData1 += "<input type='hidden' value='";
		  	            					appendData1 += telCode;
		  	            					appendData1 += "'></input>";
		  	            					appendData1 += "<input type='hidden' value='";
		  	            					appendData1 += telchannelId;
		  	            					appendData1 += "'></input>";
		  	            					appendData1 += "<input type='hidden' value='";
		  	            					appendData1 += telProductId;
		  	            					appendData1 += "'></input>";
		  	            				 }
		  		                        appendData1 += "</div>";
		  		                    }else{
		  		                  	  appendData1 += "没有配置该业务类型，或者号码不符合充值条件！！";
		  		                  	  $("#chargeValue").val("");//重置参数
		  		                  	$('#rateDiscount').html('');
		  		                  	  $("#orderAmount").val("");
		  		     		           	appendData1 += "</div>";
		  		                	  }
		  		                    $("#pgInsert").empty();
		  		              	$("#pgInsert").prepend(appendData1);
		  		              	$("#pgInsert").show();
		  		                }
		  		       	  })
		  		  		}
		  		    }else{
		  		    	alert('该地区不在服务范围');
		  		    }
		  		});
	  		}
  	 		//ajaxPg();
  	 	}
	}
 </script>
</html>