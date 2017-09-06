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
<title>Insert title here</title>
</head>
<body>
	<article class="page-container">
	<form action="" method="" class="form form-horizontal" id="bindRateForm">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>通道名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" style="width:200px"  readonly="readonly" class="input-text" value="${resultMap.cDPo.channelName }" placeholder="">
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
		<input type="hidden" name="channelDiscountId" value="${resultMap.rateDiscountId }">
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">通道折扣：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" style="width:200px" class="input-text" readonly="readonly" value="${resultMap.cDPo.channelDiscount }" placeholder="">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">设置折扣：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" style="width:200px" readonly="readonly" class="input-text"  value="${resultMap.activeDiscount }" id="activeDiscount" name="">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
			</div>
		</div>
	</form>
	</article>
</body>
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>  
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
$().ready(function() {
    $("#bindRateForm").validate({
    	submitHandler : function(form) {
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