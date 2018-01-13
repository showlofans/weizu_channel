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

<title>新增流量包 - 流量包体管理 </title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
<article class="page-container">
	<%-- <h4>${resultMap.pageTitle }</h4> --%>
	<form action="" method="" class="form form-horizontal" id="form-pg-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">标准包名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="不填可用默认值" id="pgName" name="pgName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">运营商类型：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="operatorType" class="select" id="operatorType" onchange="btnChange(this[selectedIndex].value);">
					<option value="">运营商类型</option>
					<c:forEach items="${resultMap.operatoerTypeEnums }" var="operatoerType" varStatus="vs1">
						<option value="${operatoerType.value }">${operatoerType.desc }</option>
					</c:forEach>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>运营商名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" readonly="readonly" placeholder="" id="operatorName" name="operatorName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">业务类型：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select id="serviceType" name="serviceType" class="select">
					<option value="">业务类型</option>
					<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceType" varStatus="vs1">
						<option value="${serviceType.value }">${serviceType.desc }</option>
					</c:forEach>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>流量包有效期：</label>
				<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
					<select id="pgValidity" name="pgValidity" class="select">
						<!-- <option value="">流量包有效期</option> -->
						<c:forEach items="${resultMap.pgValidityEnums }" var="pgValidity" varStatus="vs1">
							<option value="${pgValidity.value }">${pgValidity.desc }</option>
						</c:forEach>
					</select>
					</span> </div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>流通方式：</label>
				<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
					<select name="circulateWay" class="select" id="circulateWay">
						<!-- <option value="">流量类型</option> -->
						<c:forEach items="${resultMap.channelTypeEnums }" var="channelType" varStatus="vs1">
							<option value="${channelType.value }">${channelType.desc }</option>
						</c:forEach>
					</select>
					</span> </div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>流量类型：</label>
				<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
					<select name="pgType" class="select" id="pgType">
						<!-- <option value="">流量类型</option> -->
						<c:forEach items="${resultMap.pgTypeEnums }" var="pgType" varStatus="vs1">
							<option value="${pgType.value }">${pgType.desc }</option>
						</c:forEach>
					</select>
					</span> </div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">流量大小：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" required="required" maxlength="6" onkeyup='this.value=this.value.replace(/\D/gi,"")' style="width:100px" value="" placeholder="" id="pgSize" name="pgSize">M
				</div>
			</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">原价：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" style="width:100px" required="required" class="input-text" maxlength="3" onkeyup='this.value=this.value.replace(/\D/gi,"")'  value="" placeholder="" id="pgPrice" name="pgPrice">元
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>是否启用：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box inline">
				<select  name="pgInService" class="select">
					<%-- <c:forEach items="${resultMap.pgInServiceEnums }" var="pgInService" varStatus="vs1">
						<option value="${pgInService.value }">${pgInService.desc }</option>
					</c:forEach> --%>
						<option value="1">开通</option>
				</select>
				</span> 
				</div>
		</div>
		<div id="province"></div>
		
		<div class="row cl va-b">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button><!-- btn-secondary -->
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
/**获得城市列表*/
/* function getCities(){
	$.ajax({
        type:"post",
        url:"/flowsys/operatorPg/pg_add.do",
        data: $('form').serialize(),//表单数据
        async : false,
        success:function(d){
            
        	if(d=="success"){
                layer.msg('保存成功！');//保存成功提示
            }
            if(d=="error"){
                layer.msg('保存异常!');
            }
            var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
            parent.layer.close(index); //执行关闭
        }
    });
} */

$().ready(function() {
    $("#form-pg-add").validate({
    	rules:{
    		operatorType:{
    			required:true,
    		},
    		serviceType:{
    			required:true,
    		},
    		/* pgType:{
    			required:true,
    		}, 
    		pgValidity:{
    			required:true,
    		},*/
    		pgSize : {
    			required:true,
    			remote:{//验证用户名是否存在
    				  type:"get",
    	               url:"/flowsys/operatorPg/pg_exist.do",             //servlet
    	               data:{
    	            	   pgSize :function(){return $("#pgSize").val().trim();},
    	            	   pgType :function(){return $("#pgType").val().trim();},
    	            	   circulateWay :function(){return $("#circulateWay").val().trim();},
    	            	   pgValidity :function(){return $("#pgValidity").val().trim();},
    	            	   serviceType :function(){return $("#serviceType").val().trim();},
    	            	   operatorType :function(){return $("#operatorType").val().trim();}
	    			}
    			}
    		}
    	},
    	messages:{
    		pgSize:{ remote:jQuery.format("该包体已添加")}
    	},
    	
    	submitHandler : function(form) {
    		$.ajax({
		        type:"post",
		        url:"/flowsys/operatorPg/pg_add.do",
		        data: $('form').serialize(),//表单数据
		        async : false,
		        success:function(d){
		            if(d=="success"){
		                layer.msg('保存成功！');//保存成功提示
		            }
		            if(d=="error"){
		                layer.msg('保存异常!');
		            }
		            var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
		            parent.layer.close(index); //执行关闭
		        }
		    }); 
		}
    });
});
/**根据运营商类型设置运营商名字*/
function btnChange(values){
	var operatorName = "";
	//alert(values);
	if(values == 0){
		operatorName = "中国移动";
	}else if(values == 1){
		operatorName = "中国联通";
	}else{
		operatorName = "中国电信";
	}
	$("#operatorName").val(operatorName);
}

/* $(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});*/
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>