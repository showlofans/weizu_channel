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
	<form action="" method="" class="form form-horizontal" id="bindRateForm">
		<c:choose>
			<c:when test="${resultMap.fromTag== 'editChannel' }">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>通道名称：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" style="width:200px" name="channelName" readonly="readonly" class="input-text" value="${resultMap.cDPo.channelName }" placeholder="">
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>通道名称：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" style="width:200px" readonly="readonly" class="input-text" value="${resultMap.cDPo.channelName }" placeholder="">
					</div>
				</div>
			</c:otherwise>
		</c:choose>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>通道类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<c:forEach items="${resultMap.billTypeEnums }" var="billEnum" varStatus="vs">
					<c:if test="${resultMap.cDPo.billType==billEnum.value }">
						<input type="text" style="width:200px"  readonly="readonly" class="input-text" value="${billEnum.desc }" placeholder="">
					</c:if>
				</c:forEach>
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>属性</label>
			<div class="formControls col-xs-8 col-sm-9">
			<c:forEach items="${resultMap.stypeEnums }" var="sTypeEnum" varStatus="vs1">
				<c:if test="${resultMap.cDPo.serviceType == sTypeEnum.value }">
					<span>${sTypeEnum.desc }</span>
				</c:if>
			</c:forEach>
			<c:forEach items="${resultMap.otypeEnums }" var="oTypeEnum" varStatus="vs1">
				<c:if test="${resultMap.cDPo.operatorType == oTypeEnum.value }">
					<span>${oTypeEnum.desc }</span>
				</c:if>
			</c:forEach>
			<c:forEach items="${resultMap.scopeCityEnums }" var="scopeCityEnum" varStatus="vs1">
				<c:if test="${resultMap.cDPo.scopeCityCode == scopeCityEnum.value }">
					<span>${scopeCityEnum.desc }</span>
				</c:if>
			</c:forEach>
			</div>
		</div>
		<c:choose>
			<c:when test="${resultMap.fromTag== 'editChannel' }">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3">通道折扣：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" style="width:200px" id="channelDiscount" name="channelDiscount" class="input-text" readonly="readonly" value="${resultMap.cDPo.channelDiscount }" placeholder="">
					</div>
				</div>
				<input type="hidden" name="channelDiscountId" value="${resultMap.cDPo.id }">
			</c:when>
			<c:otherwise>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3">通道折扣：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" style="width:200px" class="input-text" readonly="readonly" value="${resultMap.cDPo.channelDiscount }" placeholder="">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3">设置折扣：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" style="width:200px" required class="input-text"  value="" placeholder='<c:if test='${empty resultMap.rateDiscount}'>按照上面格式填写</c:if>${resultMap.rateDiscount}' id="activeDiscount" name="activeDiscount">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3">折扣类型：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<c:forEach items="${resultMap.billTypeEnums }" var="billEnum" varStatus="vs">
							<div class="radio-box">
								<input name="billType" class="radioItem" <c:if test="${not empty rateDisocunt }">readonly</c:if> type="radio" value="${billEnum.value }" <c:if test="${resultMap.billType==billEnum.value }">checked</c:if>>
								${billEnum.desc }
							</div>
						</c:forEach>
					</div>
				</div>
				<c:choose>
					<c:when test="${resultMap.fromTag== 'add' }">
						<input type="hidden" name="channelDiscountId" value="${resultMap.cDPo.id }">
					</c:when>
					<c:when test="${resultMap.fromTag== 'edit' }">
						<input type="hidden" name="channelDiscountId" value="${resultMap.cDPo.id }">
					</c:when>
					<c:otherwise>
						<input type="hidden" name="id" value="${resultMap.cDPo.id }">
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
		<!-- 费率折扣id -->
		<c:if test="${not empty resultMap.rateDiscountId }">
			<input name="id" type="hidden" value="${resultMap.rateDiscountId }" id="rateDiscountId">
		</c:if>
		<input type="hidden" value="${resultMap.fromTag }" id="fromTag">
		<input type="hidden" name="channelId" value="${resultMap.cDPo.channelId }">
		
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button class="btn btn-primary radius" onClick="cancelEdit()">取消</button>
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
    $("#bindRateForm").validate({
    	submitHandler : function(form) {
    		var url = "/flowsys/rate/bind_rate_add.do";
    		var fromTag = $('#fromTag').val();
    		//alert($('#activeDiscount').attr("placeholder"));
    		//alert(fromTag)
    		if(fromTag == "edit"){
    			url = "/flowsys/rate/bind_rate_edit.do";
    		}else if(fromTag == "editChannel"){
    			url = "/flowsys/channel/edit_channel_discount.do"
    		}
    		var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
    		$.ajax({
    	        type: "post",
    	        data: $('form').serialize(),//表单数据
    	        url:url,
    	        async : false,
    	        success:function(d){
    	        	//alert(d);
    	            if(d == 'success'){
    	                layer.msg('保存成功！');//保存成功提示
	    	            parent.layer.close(index); ////执行关闭
    	            }else if(d == "exist"){
    	            	 layer.msg('该折扣已存在！');
    	            }else{
    	                layer.msg('保存异常!');
    	            }
    	        }
    	    });
    	}
    });
})
/* ///更新信息
function save(){
	var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	$.ajax({
        type: "post",
        data: $('form').serialize(),//表单数据
        url:"/flowsys/rate/bind_rate_add.do",
        async : false,
        success:function(d){
        	//alert(d);
            if(d == 'success'){
                layer.msg('保存成功！');//保存成功提示
            }else{
                layer.msg('保存异常!');
            }
            parent.layer.close(index); ////执行关闭
        }
    });
} */
</script>
</html>