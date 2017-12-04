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

<title>平台编辑</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
<article class="page-container">
	<%-- <h3>${pageTitle }</h3> --%>
	<form action="" method=""  class="form form-horizontal" id="platfrom">
		<input type="hidden" value="${resultMap.exchangePlatformPo.id }" name="id">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">平台类型：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<c:forEach items="${resultMap.pgServiceTypeEnums }" var="pgServiceTypeEnum" varStatus="vs">
					<div class="radio-box">
						<input name="epFor" class="radioItem" readonly="readonly" type="radio" id="epFor-${vs.index }" value="${pgServiceTypeEnum.value }" <c:if test="${pgServiceTypeEnum.value==resultMap.exchangePlatformPo.epFor }">checked</c:if>>
						<label for="epFor-${vs.index }">${pgServiceTypeEnum.desc }</label>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>平台名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${resultMap.exchangePlatformPo.epName }" placeholder="" id="epName" name="epName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>平台英文标识：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  value="${resultMap.exchangePlatformPo.epEngId }" onchange="checkEpEngId(this)"  placeholder="" id="epEngId" name="epEngId">
			</div>
		</div>
		<!-- id, ep_name, ep_purchase_ip, product_list_ip, pgdata_check_ip, ep_balance_ip, 
    ep_user_name, ep_user_pass, ep_balance, ep_apikey, ep_ip -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">流量订购地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" required  value="${resultMap.exchangePlatformPo.epPurchaseIp }" placeholder="" id="epPurchaseIp" name="epPurchaseIp">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">是否支持回调：</label>
			<div class="formControls col-xs-7 col-sm-9 skin-minimal">
				<div class="check-box">
					<c:choose>
						<c:when test="${resultMap.exchangePlatformPo.epCallBack == 1 }">
							<input name="epCallBack" class="callBack" checked="checked" type="checkbox" value="1" id="checkbox-1">
							<%-- <input type="text" class='input-text' required  value='${resultMap.exchangePlatformPo.epCallBackIp }' placeholder='' id='epCallBackIp' name='epCallBackIp'> --%>
						</c:when>
						<c:otherwise>
							<input name="epCallBack" class="callBack"  type="checkbox" value="1" id="checkbox-1">
						</c:otherwise>
					</c:choose>
					<label for="checkbox-1">&nbsp;</label>
				</div>
			</div>
		</div>
		<%-- <c:choose>
			<c:when test="${epCallBack == 1 }"> --%>
			<div class="row cl callBackIp" <c:if test="${resultMap.exchangePlatformPo.epCallBack != 1 }"> style="display:none;"</c:if>>
				<label class="form-label col-xs-4 col-sm-2">平台回调地址：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" required  value="${resultMap.exchangePlatformPo.epCallBackIp }" placeholder="输入自己的回调地址" id="epCallBackIp" name="epCallBackIp">
				</div>
			</div>
			<%-- </c:when>
		</c:choose> --%>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">产品列表地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" required value="${resultMap.exchangePlatformPo.productListIp }" placeholder="" id="productListIp" name="productListIp">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">订单状态查询地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text required" required  value="${resultMap.exchangePlatformPo.epOrderStateIp }" placeholder="" id="epOrderStateIp" name="epOrderStateIp">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">余额查询地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" required  value="${resultMap.exchangePlatformPo.epBalanceIp }" placeholder="" id="epBalanceIp" name="epBalanceIp">
			</div>
		</div>
		<%-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">订单状态地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" required  value="${resultMap.exchangePlatformPo.epOrderStateIp }" placeholder="" id="epOrderStateIp" name="epOrderStateIp">
			</div>
		</div> --%>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">账号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  value="${resultMap.exchangePlatformPo.epUserName }" required placeholder="${resultMap.exchangePlatformPo.epUserName }" id="epUserName" name="epUserName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  value="${resultMap.exchangePlatformPo.epUserPass }" required placeholder="${resultMap.exchangePlatformPo.epUserPass }" id="epUserPass" name="epUserPass">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">平台余额：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" readonly="readonly"  value="${resultMap.exchangePlatformPo.epBalance }" placeholder="" id="epBalance" name="epBalance">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">apikey：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  value="${resultMap.exchangePlatformPo.epApikey }" placeholder="" id="epApikey" name="epApikey">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">主页地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" required  value="${resultMap.exchangePlatformPo.epIp }" placeholder="" id="epIp" name="epIp">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">其他参数：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${resultMap.exchangePlatformPo.epOtherParams }" placeholder="" id="epOtherParams" name="epOtherParams">
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
<script type="text/javascript" src="/view/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
/**增加或者删除平台回调地址输入框*/
/* function toggleCallBack(vart){
	if(!$(vart).is(':checked')){
		alert('checked');
		$(vart).append('<input type="text" class='input-text' required  value='' placeholder='' id='epCallBackIp' name='epCallBackIp'>');
	}else{
		alert('unchecked');
		$(vart).next().remove();
	}
} */

$('.skin-minimal input').iCheck({
	checkboxClass: 'icheckbox-blue',
	radioClass: 'iradio-blue',
	increaseArea: '20%'
});
$('.callBack').on('ifClicked', function(event){  
		if(!$(this).is(':checked')){
			//alert(1);
			$('.callBackIp').show();
			//alert('checked');
			//$(this).append('<input type="text" class="input-text" required  value="" placeholder="" id="epCallBackIp" name="epCallBackIp"></input>');
		}else{
			//alert(2);
			$('.callBackIp').hide();
		}
	 // alert(event.type + ' callback');  
});

/**判断平台标识是否存在*/
function checkEpEngId(vart){
	var epEngId = $(vart).val();
	$.ajax({
        type:"post",
        url:"/flowsys/platform/check_ep_engId.do",
        data: {epEngId:epEngId},//表单数据
        async : false,
        success:function(d){
        	//layer.msg(d);
         	if(d == "exist"){
         		$("#epEngId").focus();
         		 layer.msg("英文标识已存在");
           }
        }
    });
}
$().ready(function() {
    $("#platfrom").validate({
    	submitHandler : function(form) {
    		if($("#epEngId").val() == ""){
    			layer.msg("英文标识为空！");
    			$("#epEngId").focus();
    		}else{
	    		$.ajax({
	                type:"post",
	                url:"/flowsys/platform/platform_edit.do",
	                data: $('form').serialize(),//表单数据
	                async : false,
	                success:function(d){
	                	//alert(d);
	                    if(d=="success"){
	                        layer.msg('保存成功！');//保存成功提示
	                        var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	                        parent.layer.close(index);
	                       /*  if($("h3").html().trim() != ""){//列表打开
	                    		parent.layer.close(index); // 执行关闭
	                        }else{
	                        	window.location.pathname = "/flowsys/platform/platform_list.do";
	                        } */
	                    }else if(d=="exist"){
	                    	 layer.msg('该英文标识已经存在！不能再次使用');
	                    	 $("#epEngId").focus();
	                    } else{
	                        layer.msg('保存异常!');
	                    }
	                }
	            });
    		}
    	}
    });
})

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>