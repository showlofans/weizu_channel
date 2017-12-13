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
<title>话费折扣编辑</title>
</head>
<body>
	<div class="page-container">
	<form action="" method="" class="form form-horizontal" id="cnelEditForm">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">商务类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<c:forEach items="${resultMap.billTypeEnums }" var="billEnum" varStatus="vs">
					<div class="radio-box">
						<input name="billType" onclick="conchange(${vs.index})" class="radioItem" type="radio" value="${billEnum.value }" <c:if test="${resultMap.telChannelParams.billType==billEnum.value }">checked</c:if>>
						${billEnum.desc }
						<input type="hidden" id="billType" value="${resultMap.telChannelParams.billType }" >
					</div>
				</c:forEach>
			</div>
		</div>
		
		<div class="row cl c-red">
			<label class="form-label col-xs-4 col-sm-3">属性</label>
			<div class="formControls col-xs-8 col-sm-9">
			<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceTypeEnum" varStatus="vs1">
				<c:if test="${resultMap.telChannelParams.serviceType == serviceTypeEnum.value }">
					<span>${serviceTypeEnum.desc }</span>
				</c:if>
			</c:forEach>
			<c:forEach items="${resultMap.operatorNameEnums }" var="operatorNameEnum" varStatus="vs1">
				<c:if test="${resultMap.telChannelParams.operatorName == operatorNameEnum.value }">
					<span>${operatorNameEnum.desc }</span>
				</c:if>
			</c:forEach>
			<c:forEach items="${resultMap.telchargeSpeedEnums }" var="telchargeSpeedEnum" varStatus="vs1">
				<c:if test="${resultMap.telChannelParams.chargeSpeed == telchargeSpeedEnum.value }">
					<span>${telchargeSpeedEnum.desc }</span>
				</c:if>
			</c:forEach>
			&nbsp;&nbsp;
			${resultMap.telChannelParams.province }
			&nbsp;&nbsp;
			${resultMap.telChannelParams.city }
			
			</div>
		</div>
		<input type="hidden" name="id" value="${resultMap.telChannelParams.id }">
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>话费折扣</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" style="width:200px" name="telchannelDiscount" class="input-text" value="${resultMap.telChannelParams.telchannelDiscount }" placeholder="">
			</div>
		</div>
		
		<!-- ifUpdateRate -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">同步更新下级折扣：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div class="radio-box">
					<input name="ifUpdateRate" class="radioItem" type="radio" value="0" checked>
					否
				</div>
				<div class="radio-box">
					<input name="ifUpdateRate" class="radioItem" type="radio" value="1" >
					是
				</div>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button class="btn btn-primary radius" onClick="removeIframe();">取消</button>
			</div>
		</div>
	</form>
	</div>
</body>
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>  
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
var checkIndex = -1; 
var radios = document.getElementsByName("billType");  
$().ready(function() {
		//alert(radios.length);
	//初始化选中的通道票务类型索引
	var billType = $('#billType').val();
    for(var i=0;i<radios.length;i++){  
    	//alert(radios[i].value);
        if(radios[i].value == billType){  
       	  checkIndex = i;  
        }  
    }  
    
    $("#cnelEditForm").validate({
    	submitHandler : function(form) {
    		var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
    		$.ajax({
    	        type: "post",
    	        data: $('form').serialize(),//表单数据
    	        url:'/flowsys/tel_channel/telchannel_edit.do',
    	        async : false,
    	        success:function(d){
    	        	//alert(d);
    	            if(d == 'success'){
    	                layer.msg('保存成功！');//保存成功提示
	    	            layer.close(index); ////执行关闭
    	            }else{
    	                layer.msg('保存异常!');
    	            }
    	        }
    	    });
    	}
    });
})

/**商务类型修改*/
function conchange(n){
	if(n != checkIndex){
		layer.confirm("确认修改商务类型吗",{
			btn:['确定','取消']
		},function(index){
			radios[n].checked = true;
			//nowChecked();//重新设置选中的checkIndex
			//checkIndex = $("input[name='billType']:checked").index();
			layer.close(index);
		},function(index){
			radios[checkIndex].checked = true;//选中原来选中的checkIndex
		});
		/*  if(conValue){
		}else{
		} */
	}
}
</script>
</html>