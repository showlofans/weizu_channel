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

<title>新增话费编码 </title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
<article class="page-container">
	<form action="" method="" class="form form-horizontal" id="product_form">
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">平台</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box ">
					<select id="selectEpId" name="epId" class="select" onchange="changeEpName()">
						<%-- <c:choose>
							<c:when test="${empty resultMap.epList }">
								<option value="">无相关平台无法配置</option>
							</c:when>
						</c:choose> --%>
						<c:forEach items="${resultMap.epList }" var="ep" varStatus="vs1">
							<option value="${ep.id }" <c:if test="${ep.id == resultMap.epId }"> selected</c:if> >${ep.epName }</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<input type="hidden" id="epName" name="epName" value="${ep.epName }"></input>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">运营商类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				  <!--  运营商类型： -->
				 <span class="select-box">
					<select name="operatorName" class="select" required="required" >
						<option value="">运营商类型</option>
						<c:forEach items="${resultMap.operatoerNameEnums }" var="operatorNameEnum" varStatus="vs1">
							<option value="${operatorNameEnum.value }" <c:if test="${operatorNameEnum.value == resultMap.params.operatorName }"> selected</c:if>>${operatorNameEnum.desc }</option>
						</c:forEach>
					</select>
				</span> 
			</div>
		</div>
		<div class="row cl">
			 <label class="form-label col-xs-4 col-sm-3">业务类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				 <span class="select-box">
					<select name="serviceType" id="serviceType" class="select" required onchange="setVis(this)">
						<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceTypeEnum" varStatus="vs1">
							<option value="${serviceTypeEnum.value }" <c:if test="${serviceTypeEnum.value == resultMap.oneCodePo.serviceType }">selected="selected"</c:if> >${serviceTypeEnum.desc }</option>
						</c:forEach>
					</select>
				</span> 
			</div>
		</div>
		<div class="row cl" id="cityDiv">
			<label class="form-label col-xs-4 col-sm-3">话费城市:</label>
			<div class="formControls col-xs-8 col-sm-9">
				<!--  地区省份： -->
				 <span class="select-box inline">
					<select class="select" id="province" name="provinceid"  onchange="province_change(this.value);" >
						<option value="">省份</option>
						<c:forEach items="${resultMap.provinces }" var="province" varStatus="vs1">
							<option value="${province.provinceid }" >${province.province }</option><!-- <c:if test="${serviceTypeEnum.value == resultMap.params.serviceType }"> selected</c:if> -->
						</c:forEach>
					</select>
				</span> 
				 <!--  地区城市： -->
				 <span class="select-box inline" id="citySpan">
					<select class="select" id="city" name="cityid">
						<option value="">城市</option>
					</select>
				</span> 
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>充值速度：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select id="chargeSpeed" name="chargeSpeed" class="select" required >
					<c:forEach items="${resultMap.telchargeSpeedEnums }" var="telchargeSpeedEnum" varStatus="vs1">
						<option <c:if test="${product.chargeSpeed == telchargeSpeedEnum.value }">selected</c:if> value="${telchargeSpeedEnum.value }">${telchargeSpeedEnum.desc }</option>
					</c:forEach>
				</select>
				</span> </div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">限制描述：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="" id="limitDescription" name="limitDescription">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">话费价值：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input class="input-text" required id="chargeValue" style="width:200px" name="chargeValue" type="text" maxlength="4" onkeyup='this.value=this.value.replace(/\D/gi,"")' placeholder="">元</input>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">产品编码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" required placeholder="" id="telCode" name="telCode">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button class="btn btn-primary radius" onClick="cancelEdit()">取消</button>
			</div>
		</div>
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
/**业务类型变化确定城市显示**/
function setVis(vart){
	var serviceType = $(vart).val();
	//alert(serviceType);
	if(serviceType == 0){//全国
		$('#cityDiv').hide();
	}else if(serviceType == 1){//省内
		$('#cityDiv').show();
		$('#citySpan').hide();
	}else{//市内2 if(serviceType != '')
		$('#cityDiv').show();
		$('#citySpan').show();
	}
}

/**省份变化*/
function province_change(v){
	var serviceType = $('#serviceType').val();
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
/**修改平台名称*/
function changeEpName(){
	var epName = $('#selectEpId option:selected').text();
	//layer.msg(epName);
	$('#epName').val(epName);
}
//保证非空
$().ready(function() {
    $("#product_form").validate({
    	submitHandler: function(){
    		var serviceType = $('#serviceType').val();
    		if(serviceType == 1 && $('#province').val() == '' ){//省份为空
	            layer.msg('请选择省份');
	            $('#province').focus();
    		}else if(serviceType == 2 && $('#city').val() == ''){
    			layer.msg('请选择城市');
	            $('#city').focus();
    		}else{
	    		save();
    		}
        }
    });
});

/***表单提交*/
 function save(){
	//$("#rechargeAmount").focus();
	$.ajax({
        type:"post",
        url:"/flowsys/tel_product/telproduct_add.do",
        data: $('form').serialize(),//表单数据
        async : false,
        success:function(d){
            if(d=="success"){
                layer.msg('保存成功！');//保存成功提示
				var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	            parent.layer.close(index); //执行关闭
            }else if(d=="exist"){
                layer.msg('编码已存在!');
            }
            else if(d=="error"){
                layer.msg('保存异常!');
            }
        }
    });
}
/**获得流量包列表*/
 /* function ajaxGetPg(){
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
} */
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>