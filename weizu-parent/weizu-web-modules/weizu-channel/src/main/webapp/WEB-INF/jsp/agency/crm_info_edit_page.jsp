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
<link rel="stylesheet" type="text/css" href="/view/iCheck/icheck.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息查看</title>
</head>
<body>
	<article class="page-container">
	<form class="form form-horizontal" id="form-crmInfo-edit">
		<c:choose>
			<c:when test="${resultMap.agencyForward ==1 }"><!-- 对上客户信息 -->
				<textarea id="crmForwardDesc" name="crmForwardDesc" style="height:500px;" cols="" value="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-1000" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="$.Huitextarealength(this,1000)">${resultMap.companyReferencePo.crmForwardDesc }</textarea>
			</c:when>
			<c:otherwise>
				<textarea id="crmBackwardDesc" name="crmBackwardDesc" cols="" style="height:500px" value="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-1000" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="$.Huitextarealength(this,1000)">${resultMap.companyReferencePo.crmBackwardDesc }</textarea>
			</c:otherwise>
		</c:choose>
		<input type="hidden" name="id" id="id" value="${resultMap.companyReferencePo.id }"/>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button onClick="cancelEdit();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
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
$(document).ready(function(){
//表单验证
	$("#form-crmInfo-edit").validate({
		submitHandler:function(form){
			var crmBackwardDesc = $('#crmBackwardDesc').val();
			//alert($.trim(crmBackwardDesc));
			var crmForwardDesc = $('#crmForwardDesc').val();
			//alert($.trim(crmForwardDesc));
			if($.trim(crmForwardDesc) == '' && $.trim(crmBackwardDesc) == ''){
				layer.msg('描述信息不能同时为空')
			}else{
				save();
			}
		}
	})
})
	

///提交表单信息
function save(){
	var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	$.ajax({
        type: "post",
        data: $('form').serialize(),//表单数据
        url:'/flowsys/crm/crm_edit.do',
        async : false,
        success:function(d){
        	//alert(d);
            if(d == 'success'){
                layer.msg('保存成功！');//保存成功提示
	            parent.layer.close(index); ////执行关闭
            }else{
                layer.msg('保存异常!');
            }
        }
    });
}
</script>
</html>