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

<title>添加话费通道</title>
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
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 平台通道管理 <span class="c-gray en">&gt;</span> 话费通道添加<a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
<article class="page-container">
	<form action="" method="" class="form form-horizontal" id="form-channel-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><!-- <span class="c-red">*</span> -->平台搜索：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" onKeyUp="ajaxGetEp()" value="" required="required" placeholder="用空格键完成平台输入" id="channel_search" name="epName">
			</div>
		</div>
		<!-- 平台ID -->
		<input type="hidden" class="input-text" value="" placeholder="" id="epId" name="epId">
		<input type="hidden" class="input-text" value="${resultMap.epFor }" id="epFor">
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
		<%-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">通道名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" required="required" value="${resultMap.channelName }" placeholder="例如：wzkj江西移动省内" id="channelName" name="channelName">
			</div>
		</div> --%>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><!-- <span class="c-red">*</span> -->运营商名称：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<c:forEach items="${resultMap.operatorNameEnums }" var="operatorEnum" varStatus="vs">
					<div class="radio-box">
						<input name="operatorName" class="radioItem" onclick="typeChange()" type="radio" id="operatorType-${vs.index }" value="${operatorEnum.value }" <c:if test="${vs.index==0 }">checked</c:if> >
						<label for="operatorType-${vs.index }">${operatorEnum.desc }</label>
						<%-- <label for="operatorType-${vs.index }"></label> --%>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><!-- <span class="c-red">*</span> -->业务类型：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceEnum" varStatus="vs">
					<div class="radio-box">
						<input name="serviceType" class="radioItem"  onclick="setVis(this)" type="radio" id="serviceType-${vs.index }" value="${serviceEnum.value }" <c:if test="${vs.index==0 }">checked</c:if>>
						<label for="serviceType-${vs.index }">${serviceEnum.desc }</label>
						<%-- <label for="operatorType-${vs.index }"></label> --%>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><!-- <span class="c-red">*</span> -->充值类型：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<c:forEach items="${resultMap.telchargeSpeedEnums }"  var="telchargeSpeedEnum" varStatus="vs">
					<div class="radio-box">
						<input name="telchargeSpeed" class="radioItem" onclick="typeChange()" type="radio" id="telchargeSpeed-${vs.index }" value="${telchargeSpeedEnum.value }" <c:if test="${vs.index==0 }">checked</c:if>>
						<label for="telchargeSpeed-${vs.index }">${telchargeSpeedEnum.desc }</label>
						<%-- <label for="operatorType-${vs.index }"></label> --%>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="row cl"  id="cityDiv">
			<label class="form-label col-xs-4 col-sm-3">话费地区：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<!--  地区省份： -->
				 <span class="select-box inline" id="provinceSpan">
					<select class="select" id="province" onchange="province_change(this.value);">
						<option value="">省份</option>
						<c:forEach items="${resultMap.provinces }" var="province" varStatus="vs1">
							<option value="${province.provinceid }" >${province.province }</option><!-- <c:if test="${serviceTypeEnum.value == resultMap.params.serviceType }"> selected</c:if> -->
						</c:forEach>
					</select>
				</span> 
				 <!--  地区城市： -->
				 <span class="select-box inline"  id="citySpan">
					<select class="select" required="required" id="city" onchange="getChargeTelEnum()"><!-- submitForm() -->
						<option value="">城市</option>
					</select>
				</span> 
				<input class="btn btn-primary radius" onclick="getChargeTelEnum()" type="button" value="&nbsp;&nbsp;获得产品&nbsp;&nbsp;">
			</div>
		</div>
		<div class="row cl" id="telchannelInsert">
			
		</div> 
		<input type="hidden" id="billTypeId" value="${resultMap.billType }">
		<div class="row cl mt-20 skin-minimal">
			<label class="form-label col-xs-4 col-sm-3">商务类型：</label>
			<!-- billTypes -->
			<div class="formControls col-xs-8 col-sm-9">
				<c:forEach items="${resultMap.billTypeEnums }" var="billEnum" varStatus="vs">
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
			<label class="form-label col-xs-4 col-sm-3">通道使用状态：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<c:forEach items="${resultMap.channelUseStateEnums }" var="channelUseStateEnum" varStatus="vs">
					<div class="radio-box">
					 	<input name="telchannelUseState" class="radioItem" type="radio" id="channelUseState-${vs.index }" value="${channelUseStateEnum.value }" <c:if test="${vs.index==0 }">checked</c:if>>
						<label for="channelUseState-${vs.index }">${channelUseStateEnum.desc }</label>
						<%-- <label for="operatorType-${vs.index }"></label> --%>
					</div>
				</c:forEach>
			</div>
		</div>
		 <div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3 mb-30">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">&nbsp;&nbsp;
				<button class="btn btn-primary radius" onClick="removeIframe()">取消</button>
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
/**业务类型变化确定城市显示**/
function setVis(vart){
	typeChange();//清空通道编码列表
	var serviceType = $(vart).val();
	//alert(serviceType);
	if(serviceType == 0){//全国
		$('#provinceSpan').hide();
		$('#citySpan').hide();
	}else if(serviceType == 1){//省内
		$('#provinceSpan').show();
		$('#citySpan').hide();
	}else{//市内2 if(serviceType != '')
		$('#provinceSpan').show();
		$('#citySpan').show();
	}
}
/**清空编码列表信息*/
function typeChange(){
	$("#telchannelInsert").empty();
}

$(function(){
	$('.skin-minimal input').iCheck({
		radioClass: 'iradio-blue',
		checkboxClass: 'icheckbox_square-blue',
		increaseArea: '20%'
	});
})
/**省份变化*/
function province_change(v){
	var serviceType = $('input[name=serviceType]:checked').val();
	//alert(serviceType);
	if(serviceType == 2){//市内
		var ss;
	    var city = document.getElementById("city");
		city.innerHTML = "";
		$.getJSON("/view/mine/data/cityData.json",function(data){
		    ss=data;
		    //var html="<option value='-1'>==请选择==</option>";
		    for(var i=0;i<ss.length;i++){
		    	if(v==ss[i].provinceid){
	                var citys=ss[i].cities;
	                for(var j=0;j<citys.length;j++){
	                	city.add(new Option(citys[j].city,citys[j].cityid));
	                }
	            }
		    }
		});
	}
}
/**异步获得可配置产品列表 */
function getChargeTelEnum(){
	var chargeSpeed = $('input[name=telchargeSpeed]:checked').val();
	var epId = $('#epId').val();
	var cityid = $('#city').val();
	var provinceid = $('#province').val();
	var operatorName = $('input[name=operatorName]:checked').val();
	var serviceType = $('input[name=serviceType]:checked').val();
	//alert(serviceType);
	if(serviceType == 1 && $('#province').val() == '' ){//省份为空
        layer.msg('省份不能为空');
        $('#province').focus();
	}else if(serviceType == 2 && cityid == ''){
		layer.msg('城市不能为空');
        $('#city').focus();
	}else if(epId == ''){
		layer.msg("平台不能为空!!");
		$('#epId').focus();
	}
	else{
		//alert($('#province').val());
		//alert(chargeSpeed);
		$.ajax({
	         type:"post",
	         url:"/flowsys/tel_product/ajax_get_code.do",
	         data: {chargeSpeed:chargeSpeed,operatorName:operatorName,cityid:cityid,provinceid:provinceid,serviceType:serviceType,epId:epId},//表单数据
	         async : false,
	         success:function(data){
	        	 var dataRole1 = eval(data);
	          	  // alert(dataRole1.length);
	             var appendData1 = "<label class='form-label col-xs-4 col-sm-3'>设置通道折扣：</label><div class='formControls col-xs-8 col-sm-9 skin-minimal'>"; 
	              if(dataRole1 != null && dataRole1.length > 0){
	            	  for(var i=0; i < dataRole1.length; i++){
	            		  //编码id，编码价值，是否包涵任意价格，编码
	                	   var chargeValue = dataRole1[i].chargeValue;
	                	   var id = dataRole1[i].id;
	                	   var telCode = dataRole1[i].telCode;
	      					appendData1 += "<div class='check-box f-16'><input type='hidden' name='telProducId' value='";
	      					appendData1 += id;
	      					appendData1 += "'></input>";
	      					/**&nbsp;&nbsp;<input class='cbox' type='checkbox'  id='pgName-";
	      					appendData1 += (i+1);
	      					appendData1 += "' onclick=''><label for='pgName-";//checkBoxes(this,"+ id +")
	      					appendData1 += (i+1);
	      					appendData1 += "'>**/
	      					appendData1 += chargeValue;
	      					//&nbsp;&nbsp;<input class="disscount input-text" style=" width:150px;" type="text"  placeholder="产品编码">
      						//&nbsp;&nbsp;<input class="disscount input-text" style=" width:100px;" type="text" maxlength="3" onkeyup='this.value=this.value.replace(/\D/gi,"")' placeholder="折扣"></label>
	      					appendData1 += "元 &nbsp;&nbsp;<input type='text' type='text' class='input-text telDis' placeholder='折扣' maxlength='3' onkeyup='this.value=this.value.replace(/\D/gi,'')' style='width:100px;'></input>";
	      					appendData1 += "&nbsp;&nbsp;<input type='text' class='input-text' readonly value='编码："
	      					appendData1 +=  telCode
	      					appendData1 += "'  style='width:150px;' ></input></div><br>";
	      				 }
	                  appendData1 += "</div>";
	              }else{
	            	  appendData1 += "未添加该地区类型编码！！";//无法配置该地区产品
			           	appendData1 += "</div>";
	          	  }
	              $("#telchannelInsert").empty();
	        	$("#telchannelInsert").prepend(appendData1);
	        	$("#telchannelInsert").show(); 
	         },
			 "error":function(msg){
	      		alert(msg);
	       		}
	     });
	}
}
$(document).ready(function(){
	
	/* var serviceType = $('input[name=serviceType]:checked').val();
	var provinceid = $('#province').val();
	//alert(serviceType);
	if(serviceType == 2){//市内
		var ss;
	    var city = document.getElementById("city");
		city.innerHTML = "";
		$.getJSON("/view/mine/data/cityData.json",function(data){
		    ss=data;
		    //var html="<option value='-1'>==请选择==</option>";
		    for(var i=0;i<ss.length;i++){
		    	if(provinceid==ss[i].provinceid){
	                var citys=ss[i].cities;
	                for(var j=0;j<citys.length;j++){
	                	city.add(new Option(citys[j].city,citys[j].cityid));
	                }
	            }
		    }
		});
	} */
	$("#form-channel-add").validate({
    	submitHandler : function(form) {
		  	var ids = "";
		  	var discounts = "";
	       var tres = 0;
    		$(".telDis").each(function(){ //遍历table里的全部checkbox
    		       // allcheckbox += $(this).next().html() + ","; //获取所有checkbox的值
    		        //alert($(this).is(':checked'));
    		       //if($(this).is(':checked')) //如果被选中
    		       if($(this).val() != ''){ //如果不为空
    		       		//var discount = $(this).val();
    		        	ids += $(this).prev().val() + ","; //获取被选中的值
    		        	discounts += $(this).val() + ","; //获取被选中的值
    		        	tres++;
   		       		}else{
   		       			layer.msg('请输入折扣');
   		       			$(this).focus();
   		       		}
    		        	//alert(accountIds);
    		    });
    		if(!$('#ep_info').is(':visible')){
    			layer.msg('没有选定平台');
    			$('#channel_search').focus();
    		}
    		else if(tres > 0){
	    		var billType = $('input[name=billType]:checked').val();
	    		var telchannelUseState = $('input[name=telchannelUseState]:checked').val();
    			 $.ajax({
 	               type:"post",
 	               url:"/flowsys/tel_channel/telchannel_add.do",
 	               data: {ids:ids,discounts:discounts,billType:billType,telchannelUseState:telchannelUseState},//表单数据
 	               async : false,
 	               success:function(d){
 	            	   //alert(d);
 	                   if(d=="success"){
 	                        layer.msg('保存成功！');//保存成功提示
 	                       removeIframe();
 	                   }
 	                   if(d=="error"){
 	                       layer.msg('保存异常!查看是否已添加过该类型在使用状态的通道');
 	                   }
 	               },
    			 "error":function(msg){
 		        	alert(msg);
 		         }
 	           });
    		}else{
    			layer.msg('没有选定话费!!');
    		}
    	}
    });
})

/**checkBox的点击事件*/
/* function checkBoxes(vart){
	if($(vart).next().is(':hidden')){
		$(vart).next().show();
		 if(!$('#ep_info').is(':visible')){
			 alert('还没有选定平台');
			 $('#epName').focus();
		 }else{
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
			 var pgType = $("input[name='pgType']:checked").val();
			 var pgValidity = $("input[name='pgValidity']:checked").val();
			 
			 //alert(operatorType);
			 $.ajax( {    
			        "type": "post",     
			        "contentType": "application/x-www-form-urlencoded; charset=utf-8",    
			        "url": "/flowsys/channel/change_channel_pgSize.do?operatorType="+ operatorType+"&serviceType=" + serviceType+"&pgType=" + pgType+"&pgValidity=" + pgValidity+"&scopeCityCode=" + scopeCityCode+"&epId=" + epId,
			        "success": function(d){
			            $("#pgSize").val(d);	//写入pgSize
			        }
		 	 });
		 }
	}else{
		$(vart).next().hide();
	}
}  */

/*监听平台 输入框的键盘事件 **/
function ajaxGetEp(evt) {
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
	        	if(resp == null ){
	        		$("#ep_info").hide();
	        	}else if($('#epFor').val() != resp.epFor){
	        		layer.msg('该平台不包含话费业务!')
	        	}else{
		        	$("#ep_info").show();
		        	$("#ep_name").val(resp.epUserName);
		        	$("#ep_pass").val(resp.epUserPass);
		        	$("#epApikey").val(resp.epApikey);
		        	$("#epPurchaseIp").val(resp.epPurchaseIp);
		        	$("#epName").val(resp.epName);
		        	$("#epId").val(resp.id);
	        	}
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