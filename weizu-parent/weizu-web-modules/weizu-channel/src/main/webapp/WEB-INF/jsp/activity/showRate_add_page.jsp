<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/view/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>折扣添加/编辑</title>
</head>
<body>
	<article class="page-container">
	<form action="" method="" class="form form-horizontal" id="showRateForm">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">通道范围：</label>
			<div class="formControls col-xs-8 col-sm-9">
			<span class="select-box inline">
				<select name="scopeCityCode" required class="select">
				<option value="">通道地区</option>
				<c:forEach items="${resultMap.scopeCityEnums }" var="scopeCityEnum">
					<option value="${scopeCityEnum.value }" <c:if test="${scopeCityEnum.value == resultMap.channelForShowPo.scopeCityCode }"> selected</c:if>>${scopeCityEnum.desc }</option>
				</c:forEach>
			</select>
			</span> 
			&nbsp;&nbsp;
			<span class="select-box inline">
				<select name="serviceType" required class="select">
				<option value="">业务类型</option>
				<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceType" varStatus="vs1">
					<option value="${serviceType.value }" <c:if test="${serviceType.value == resultMap.channelForShowPo.serviceType }"> selected</c:if>>${serviceType.desc }</option>
				</c:forEach>
			</select>
			</span> 
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">包体描述：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" style="width:300px" required class="input-text" name="productDesc" value="${resultMap.channelForShowPo.productDesc }" placeholder="包体描述">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">拿货价：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" style="width:100px" class="input-text" name="channelPriceStr" required maxlength="3" onkeyup='this.value=this.value.replace(/\D/gi,"")' value="${resultMap.channelForShowPo.channelPriceStr }" placeholder="拿货价">
				<span class="select-box inline">
					<select name="channelBill" id="channelBill" class="select">
							<c:forEach items="${resultMap.billTypeEnums }" var="billEnum" varStatus="vs">
								<option value="${billEnum.value }" <c:if test="${billEnum.value ==resultMap.channelForShowPo.channelBill }"> selected</c:if>>${billEnum.desc }</option>
							</c:forEach>
					</select>
					&nbsp;&nbsp;
				</span>
				<span class="select-box inline">
					<select name="limitPrice" id="limitPrice" class="select">
						<c:forEach items="${resultMap.limitPriceEnums }" var="limitPriceEnum" varStatus="vs">
							<option value="${limitPriceEnum.value }" <c:if test="${limitPriceEnum.value ==resultMap.channelForShowPo.limitPrice }"> selected</c:if>>${limitPriceEnum.desc }</option>
						</c:forEach>
					</select>
				</span>
					&nbsp;&nbsp;
				<span class="select-box inline">
					<select name=bussinessMan id="bussinessMan" required class="select">
						<option value="">商务</option>
						<c:forEach items="${resultMap.businessOneEnums }" var="businessOneEnum" varStatus="vs">
							<option value="${businessOneEnum.value }" <c:if test="${businessOneEnum.value ==resultMap.channelForShowPo.bussinessMan }"> selected</c:if>>${businessOneEnum.desc }</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>拿货渠道公司备注</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" style="width:300px" name="channelCompany" id="channelCompany" required  class="input-text" value="${resultMap.channelForShowPo.channelCompany }"  placeholder="拿货渠道公司备注">
			</div>
		</div>
		<!-- 配置信息 -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">带票折扣：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" style="width:200px" class="input-text" maxlength="3" onkeyup='this.value=this.value.replace(/\D/gi,"")' value="${resultMap.channelForShowPo.billRateStr }" name="billRateStr" id="billRateStr" placeholder="带票折扣">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">不带票折扣：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" style="width:200px" class="input-text" maxlength="3" onkeyup='this.value=this.value.replace(/\D/gi,"")' value="${resultMap.channelForShowPo.privateRateStr}" placeholder='不带票折扣' id="privateRateStr" name="privateRateStr">
			</div>
		</div>
		<input type="hidden" name="id" id="id" value="${resultMap.channelForShowPo.id }">
		
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit">&nbsp;&nbsp;&nbsp;<i class="Hui-iconfont">&#xe632;</i>保存&nbsp;&nbsp;&nbsp;</button>
				<button class="btn btn-primary radius" type="button" onClick="removeIframe()">&nbsp;&nbsp;&nbsp;取消&nbsp;&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
	</article>
</body>
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>  
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
$().ready(function() {
    $("#showRateForm").validate({
    	submitHandler : function(form) {
    		var channelBill = $('#channelBill').val();
    		var privateRateStr = $('#privateRateStr').val();
    		var billRateStr = $('#billRateStr').val();
    		if(channelBill == 1){
    			if($.trim(privateRateStr) != ''){
    				layer.alert('带票配置不带票', {
					    skin: 'layui-layer-lan'
					    ,closeBtn: 0
					    ,anim: 4 //动画类型
				    });
    			}
    		}else{//不带票
    			if($.trim(billRateStr) != ''){
    				layer.alert('不带票配置带票', {
					    skin: 'layui-layer-lan'
					    ,closeBtn: 0
					    ,anim: 4 //动画类型
				    });
    			}
    		}
    		//alert($.trim(billRate));
    		if($.trim(billRateStr) == '' && $.trim(privateRateStr) == ''){
    			layer.msg('折扣不能同时为空');
    			$('#billRate').focus();
    		}else{
	    		var id = $('#id').val();
	    		if(id == ''){//添加展示通道
	    			url = '/flowsys/showRate/showRate_add.do';
	    		}else{
	    			url = '/flowsys/showRate/showRate_edit.do';
	    		}
	    		$.ajax({
	    	        type: "post",
	    	        data: $('form').serialize(),//表单数据
	    	        url:url,
	    	        async : false,
	    	        success:function(d){
	    	        	//alert(d);
	    	            if(d == 'success'){
	    	                layer.msg('保存成功！');//保存成功提示
	    	                removeIframe();
	    	            }else{
	    	                layer.msg('保存异常!');
	    	            }
	    	        }
	    	    });
    		}
    	}
    });
})

</script>
</html>