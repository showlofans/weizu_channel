<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE >
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
<script type="text/javascript" src="/view/lib/html5shiv.js"></script>
<script type="text/javascript" src="/view/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/view/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="/view/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>新增包体编码 </title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
<article class="page-container">
	<h3>${resultMap.pageTitle }</h3>
	
	<form action="" method="" class="form form-horizontal" id="product_form">
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">平台</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box ">
					<select id="selectEpId" name="epId" style onchange="ajaxGetPg()"  class="select">
						<c:forEach items="${resultMap.epList }" var="ep" varStatus="vs1">
							<option value="${ep.id }" >${ep.epName }</option>
							<%-- <c:choose>
								<c:when test="${ep.epId==resultMap.epId }">
									<option value="${ep.epId }" selected="selected" >${ep.epName }</option>
								</c:when>
								<c:otherwise>
									<option value="${ep.epId }" >${ep.epName }</option>
								</c:otherwise>
							</c:choose> --%>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">运营商类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				 <span class="select-box ">
					<select name="operatorType" id="operatorType" class="select"  onchange="ajaxGetPg()">
						<c:forEach items="${resultMap.operatorTypeEnums }" var="operaterType" varStatus="vs1">
							<option value="${operaterType.value }"  <c:if test="${operaterType.value == resultMap.oneCodePo.operatorType }"> selected</c:if>>${operaterType.desc }</option>
						</c:forEach>
					</select>
				</span> 
			</div>
		</div>
		<div class="row cl">
			 <label class="form-label col-xs-4 col-sm-3">业务类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				 <span class="select-box">
					<select name="serviceType" id="serviceType" class="select" onchange="ajaxGetPg()">
						<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceTypeEnum" varStatus="vs1">
							<option value="${serviceTypeEnum.value }" <c:if test="${serviceTypeEnum.value == resultMap.oneCodePo.serviceType }">selected="selected"</c:if> >${serviceTypeEnum.desc }</option>
						</c:forEach>
					</select>
				</span> 
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">省份名称</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
					<select id="scopeCityCode" name="scopeCityCode" class="select" onchange="ajaxGetPg()">
						<c:forEach items="${resultMap.scopeCityEnums }" var="cityEnum" varStatus="vs1">
							<option value="${cityEnum.value }" <c:if test="${cityEnum.value == resultMap.oneCodePo.scopeCityCode }">selected="selected"</c:if> >${cityEnum.desc }</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">包体编码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" required="required" value="" placeholder="" id="productCode" name="productCode">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>流量包有效期：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select id="pgValidity" name="pgValidity" class="select" onchange="ajaxGetPg()">
					<!-- <option value="">流量包有效期</option> -->
					<c:forEach items="${resultMap.pgValidityEnums }" var="pgValidity" varStatus="vs1">
						<option <c:if test="${pgValidity.value == resultMap.oneCodePo.pgValidity }">selected="selected"</c:if> value="${pgValidity.value }">${pgValidity.desc }</option>
					</c:forEach>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>流量流通方式：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<span class="select-box">
				<select name="circulateWay" id="circulateWay" class="select"  onchange="ajaxGetPg()">
					<!-- <option value="">流量流通方式</option> -->
					<c:forEach items="${resultMap.channelTypeEnums }" var="channelTypeEnum" varStatus="vs1">
						<option value="${channelTypeEnum.value }" <c:if test="${channelTypeEnum.value == resultMap.oneCodePo.circulateWay }"> selected</c:if>>${channelTypeEnum.desc }</option>
					</c:forEach>
				</select></span>  
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>流量类型：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="pgType" class="select" id="pgType" onchange="ajaxGetPg()">
					<!-- <option value="">流量类型</option> -->
					<c:forEach items="${resultMap.pgTypeEnums }" var="pgType" varStatus="vs1">
						<option value="${pgType.value }" <c:if test="${pgType.value == resultMap.oneCodePo.pgType }"> selected</c:if>>${pgType.desc }</option>
					</c:forEach>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">包体</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
					<select name="pgId" id="pgId" class="select"  onchange="changePg()"> <!-- -->
						<option value="">包体大小</option>
						<c:forEach items="${resultMap.pgList }" var="pg" varStatus="vs1">
							<option value="${pg.id }">${pg.pgName }</option>
							<span style="display:none;">${pg.pgSize }</span><!-- 包体价格 -->
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button class="btn btn-primary radius" onClick="cancelEdit()">取消</button>
			</div>
		</div>
	<input id="pgSize" type="hidden" value="" name="pgSize"></input>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script> 
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">

$().ready(function() {
    $("#product_form").validate({
    	rules:{
    		pgId:{
    			required:true
    		},
    		productCode : {
    				required:true,
	    			remote:{//验证通编码是否存在
	    				  type:"post",
	    	               url:"/flowsys/productCode/product_code_exist.do",             //servlet
	    	               data:{
	    	            	  epId :function(){return $("#selectEpId").val().trim();},
	    	            	  operatorType :function(){return $("#operatorType").val().trim();},
	    	            	  serviceType :function(){return $("#serviceType").val().trim();},
	    	            	  scopeCityCode :function(){return $("#scopeCityCode").val().trim();},
	    	            	  pgType :function(){return $("#pgType").val().trim();},
	    	            	  pgValidity :function(){return $("#pgValidity").val().trim();},
	    	               	  productCode :function(){return $("#productCode").val().trim();}
	    					}
    				}
    		}
    	},
    	submitHandler: function(){
            save();
        },
    	messages:{
    		productCode:{ remote:jQuery.format("该通道编码已存在！！ "),required:"必填"}
    	}
    });
});

/**设置包体其他属性*/
function changePg(){
	var et = $("#pgId").get(0).selectedIndex;
	//alert($(et).next().html());
	//alert(et);
	//alert($("#pgId :hidden").html());
	var pgSize = $(et).next().html();//:eq("+ et +")
	//alert(pgSize);
	$('#pgSize').val(pgSize);
	//alert(pgPrice);
	
	/* var palist = $("#pgList").val();
	var pgId = $("#pgId").val();
	alert(palist.length);
	for (var int = 0; int < palist.length; int++) {
		if(pglist[i].id == pgId){
			$("#pgPrice").val(pglist[i].pgPrice);
			
			break;
		}
	} */
}
/***表单提交*/
 function save(){
	//$("#rechargeAmount").focus();
	$.ajax({
        type:"post",
        url:"/flowsys/productCode/product_code_add.do",
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
}
/**获得流量包列表*/
 function ajaxGetPg(){
	var stype = $("#serviceType").val();
	var otype = $("#operatorType").val();
	var pgType = $("#pgType").val();
	var pgValidity = $("#pgValidity").val();
	var circulateWay = $("#circulateWay").val();
	var epId = $('#selectEpId').val();
	var scopeCityCode = $('#scopeCityCode').val();
	//alert(stype + "  " + otype);
	$.ajax({
        type:"post",
        url:"/flowsys/productCode/productCode_add_page/ajax_pg_list.do",
        data: {operatorType:otype,serviceType:stype,epId:epId,scopeCityCode:scopeCityCode,pgType:pgType,pgValidity:pgValidity,circulateWay:circulateWay},//表单数据
        dataType: "json",
        async : false,
        success:function(data){
        	//alert(data.length);
            $("#pgId").empty();//清空原有收据 
            var appendData = "<option value=''>包体列表 </option>";
        	if(data.length > 0){
                $('#productCode').removeAttr('readonly');
        		for(var i=0; i < data.length; i++){
        			appendData += "<option value="+ data[i].id +">" + data[i].pgName +"</option>";
                }
            }else{
            	$('#productCode').val();
            	 $('#productCode').attr('readonly', true);
            	 appendData += "<option value=''>没有可选项 ！！</option>";
            }
        	$("#pgId").prepend(appendData);
        }
    });
}
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>