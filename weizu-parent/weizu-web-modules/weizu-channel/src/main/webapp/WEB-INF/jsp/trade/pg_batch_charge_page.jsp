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
  <title>流量批量充值</title>
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
  <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 在线充值 <span class="c-gray en">&gt;</span>流量充值 <span class="c-gray en">&gt;</span> 批量充值<!--  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a> --></nav>
 <div class="page-container">
 <form class="form form-horizontal" name="form-import" action="?"  id="form-import" enctype="multipart/form-data">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">号码文本：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<span class="btn-upload">
			  <a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 选择文件</a>
			  <input value="" class="input-text upload-url" style="width:300px" type="text" readonly >
			  <input type="file" multiple name="uploadFile" class="input-file">
			</span>
			<button type="button" id="saveButton" class="btn btn-primary radius" onclick="saveTelList()"> 导入号码</button>
		</div>
		<!-- <button type="button" onclick="history.go(-1);" class="btn"><i class="fa fa-undo"></i> 取消返回</button> -->
	</div>
</form>
 	<form class="form form-horizontal" name="form-charge" action="?" id="form-batch-charge">
 	<input type="hidden" name="channelId" id="channelId">
 	<input type="hidden" name="billType" id="billType">
 	<input type="hidden" name="pgId" id="pgId">
 	<input type="hidden" id="pgSinglePrice"><!-- 包体原价单价 -->
 	<input type="hidden" name="totalNum" id="totalNum">
 	<input type="hidden" name="carrier" id="carrier">
 	<input type="hidden" name="serviceType" id="serviceType">
 	<input type="hidden" value="${loginContext.rootAgencyId }" id="rootAgencyId">
 	<c:choose>
		<c:when test="${loginContext.rootAgencyId == 0 }">
			<input id="cdisId" name="cdisId" type="hidden" value="">
		</c:when>
		<c:otherwise>
			<input id="rateId" name="rateId" type="hidden" value="">
		</c:otherwise>
	</c:choose>
 	<div class="row cl" id="pg">
		<label class="form-label col-xs-4 col-sm-3">手机号：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<textarea id="telList" rows="5" cols="10" style="width:500px;" class="textarea" name="chargeTelArray"  ></textarea>
			<br><span id="msgDesc" style="display:none;" class="c-success"></span>
		</div>
	</div>
 	<div class="row cl" id="serviceScope" style="display:none;">
		<label class="form-label col-xs-4 col-sm-3">业务：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" id="businessType" readonly class="input-text" required style="width:400px" autocomplete="off"  placeholder="" >
		</div>
	</div>
	<div id="cnelInsert" class="row cl">
	</div>
 	<!-- <div class="row cl" id="pg">
		<span id="msgDesc" style="display:none;" class="c-success"></span>
	</div> -->
	
	<%-- <div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">归属地：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" required  style="width:400px" value="" placeholder="" id="chargeTelDetail" name="chargeTelDetail">
		</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">业务类型：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<c:forEach items="${resultMap.serviceTypeEnum }" var="serviceType" varStatus="vs">
					<div class="radio-box">
						<input onclick="ajaxPg(this)" name=serviceType type="radio" value="${serviceType.value }" id="serviceType-${vs.index+1 }" checked>
						<label for="serviceType-${vs.index+1 }">${serviceType.desc }</label>
					</div> 				</c:forEach>
					
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
		</div> --%>
		<%-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">业务类型：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<span class="select-box inline">
						<select id="select-servce-type" name="serviceType" onchange="ifAjaxPg()" style="width:150px;" class="select">
							<option value="">请选择</option>
							<c:forEach items="${resultMap.serviceTypeEnums }" var="typeEnum" varStatus="vs1">
								<option value="${typeEnum.value }" >${typeEnum.desc }</option>
							</c:forEach>
						</select>
					</span>
			</div>
		</div> --%>
	<div class="row cl" id="pg">
		<label class="form-label col-xs-4 col-sm-3">流量面值：</label>
		<div class="formControls col-xs-8 col-sm-9">
		<!--  onfocus="ajaxPg()" -->
			<input type="text" id="pgPrice" readonly name="chargeValue" class="input-text" required style="width:400px" autocomplete="off"  placeholder="" >
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
		<label class="form-label col-xs-4 col-sm-3">采购金额：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input id="orderAmount" name="orderAmount" type="text" readonly class="input-text" required  style="width:400px" value="" placeholder="">
			<br>折扣：<span id="rateDiscount" class="c-red">${resultMap.pageMsg }</span>
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
			<textarea readonly="readonly" style="height:250px;  " name="" cols="30" rows="" class="textarea"  placeholder="导入介绍，
批量条件：同一个地区，同一个业务类型，同样的包体大小;
文本命名方式：归属地_业务类型_包体大小（江西移动_省漫游_10）
文件格式：.txt文本。
文本内容：每个号码一行（每行号码都会单独检测号码的合法性，所以必须这样）
"></textarea>
		</div>
	</div>
	</form>
	
	<!-- <input id="pgSize" type="hidden"></input -->
</div>
 </body>
  <script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
  <script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
  <script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>
  <script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
  <script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
  <script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/messages_zh.js"></script>
 <script type="text/javascript">
/*  $(function(){
 uploader1 = WebUploader.create({ 
     auto:false, //是否自动上传
      pick: {
          id: '#corporateIdentityBack',
          name:"file",  //这个地方 name 没什么用，虽然打开调试器，input的名字确实改过来了。但是提交到后台取不到文件。如果想自定义file的name属性，还是要和fileVal 配合使用。
          label: '点击选择图片',
          multiple:false            //默认为true，true表示可以多选文件，HTML5的属性
      },
      swf: '/view/lib/webuploader/0.1.5/Uploader.swf',  //在这里必需要引入swf文件，webuploader初始化要用
      //fileVal:'multiFile',  //自定义file的name属性，我用的版本是0.1.5 ,打开客户端调试器发现生成的input 的name 没改过来。
                                       //名字还是默认的file,但不是没用哦。虽然客户端名字没改变，但是提交到到后台，是要用multiFile 这个对象来取文件的，用file 是取不到文件的
                                       // 建议作者有时间把这个地方改改啊，搞死人了。。
      server: "/flowsys/account/upload_img_file.do",
      duplicate:false,//是否可重复选择同一文件
      resize: false,
      formData: {
          "status":"file",
          "contentsDto.contentsId":"0000004730",
          "uploadNum":"0000004730",
          "existFlg":'false'
      },  
      compress: null,//图片不压缩
      chunked: true,  //分片处理
      chunkSize: 5 * 1024 * 1024, //每片5M
      chunkRetry:true,//如果失败，则不重试
      threads:1,//上传并发数。允许同时最大上传进程数。
      // runtimeOrder: 'flash',  
      // 禁掉全局的拖拽功能。这样不会出现图片拖进页面的时候，把图片打开。  
      disableGlobalDnd: true
  });  
 
 }) */
 $().ready(function() {
	 $("#form-batch-charge").validate({
		 submitHandler : function(form) {
			 	layer.msg($.trim($('#telList').val()));
	    		if($.trim($('#telList').val()) == ''){
	    			 alert($('#pageMsg').val());
	    		 }else {
		    		$.ajax({
				        type:"post",
				        url:"/flowsys/chargePg/pg_batch_charge.do",
				        data: $('form').serialize(),//表单数据
				        async : false,
				        success:function(d){
				        	if(d == 'success'){
					        	removeIframe();
				        	}else{
				        		alert(d + "充值失败");
				        		//removeIframe();
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
 /**超管选择通道*/
 function chooseChannel(cnelId,cdisId,cdis,vart){
	//layer.msg(cnelId+","+cdisId+";"+cdis);
	//var cnel = $(vart).prev().val();
	//layer.msg(cnel);
	$('#channelId').val(cnelId);
	$('#rateDiscount').html(cdis);//通道折扣
	$('#cdisId').val(cdisId); //初始化通道折扣id
	var orderPrice = parseFloat($('#pgSinglePrice').val() * $('#totalNum').val());
	var orderAmount = orderPrice * cdis;
	//layer.msg(orderAmount);
	$('#orderAmount').val(orderAmount);
	$('#pgPrice').val(orderPrice);
}
 
 function saveTelList(){
	
	//alert($('#telList').val());
	 //$('#telList').val('100');
	// $('#saveButton').set('disabled', 'false');
	 //alert("1");
	$.ajax({
         url : "/flowsys/chargePg/tel_batch_import_txt.do",
         type : "POST",
         cache: true, 
         data : new FormData($('#form-import')[0]),
         processData: false,
         contentType : false,
         dataType:"json",
         success : function(data) {
        	 //alert(data);
        	//$('#telList').val(data);
        	if("success" == data.msg){
	        	$('#telList').val(data.telData);
		        var msgDesc = data.msgDesc;
		        $('#businessType').val(data.carrier+data.serviceTypeDesc+data.pgSize + 'M(原价：'+data.pgData.pgPrice+'元)');
		        $('#serviceScope').show();
		        //msgDesc += '<br>包体大小：'+data.pgSize;
		        //msgDesc += '<br>范围：'+data.carrier+data.serviceTypeDesc;
		        //msgDesc += '<br>总价值：'+data.pgPrice;
		        //msgDesc += '<br>折扣：'+data.ratePo.activeDiscount;
		       // msgDesc += '<br>总成本（扣款）：'+data.orderAmount;
	        	$('#msgDesc').html(msgDesc);
	        	$('#totalNum').val(data.totalNum);
	        	$('#pgSinglePrice').val(data.pgData.pgPrice);
	        	$('#pgId').val(data.pgData.id);
	        	$('#serviceType').val(data.serviceType);
	        	$('#carrier').val(data.carrier);
	        	var rootAgencyId = $('#rootAgencyId').val();
	        	//layer.msg(rootAgencyId);
	        	if(rootAgencyId == '0'){
	               	var dataRole = eval(data.chargeList);
	               	//alert(dataRole.length);
	               	if(dataRole.length > 0){
		        		var appendData = "<label class='form-label col-xs-4 col-sm-3'>通道：</label><div class='formControls col-xs-8 col-sm-9 skin-minimal'>";
	                      for(var i=0; i < dataRole.length; i++){
	                    	  var cnel_id = dataRole[i].id;
	                    	  var cdisId = dataRole[i].cdId;
	                    	  var cnel_name = dataRole[i].channelName;
	                    	  var ep_name = dataRole[i].epName;
	                    	  var ep_id = dataRole[i].epId;
	                    	  var cdiscount = dataRole[i].channelDiscount;
	                    	  appendData += "<div class='radio-box'><input type='hidden' value='"+cnel_id+"'></input><input class='cNameRadio' type='radio' name='cNameRadio' id='cname-"+(i+1)+"' onclick='chooseChannel("+cnel_id+","+cdisId+","+cdiscount+",this)'><label for='cname-"+(i+1)+"'>"
	            					+cnel_name+"</label></div>";
	                      }
	                	appendData += "</div>";
		            	$("#cnelInsert").prepend(appendData);
		            	$("#cnelInsert").show();
	                }
	        	}else{
	        		$('#rateDiscount').html(data.ratePo.activeDiscount);
	        		$('#rateId').val(data.ratePo.id);
		        	$('#orderAmount').val(data.orderAmount);
		        	$('#pgPrice').val(data.pgPrice);
	        	}
	        	
        	}else{
        		$('#businessType').val('');
		        $('#serviceScope').hide();
        		$('#orderAmount').val('');
	        	$('#pgPrice').val('');
	        	$('#rateDiscount').html('');
	        	
        		layer.msg(data.msg);
        		$('#msgDesc').html(data.msg);
        	}
        	$('#msgDesc').show();
        	// alert($('#telList').html());
        	// $('#telList').html(data);
            //alert(data);  
         },

         error : function(data) {
             alert("出错：" + data.code);
         } 
     });
	// $('#form-import').submit();
 }
 
 
 </script>
</html>