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
<title>个人信息查看</title>
</head>
<body>
	<article class="page-container">
	<form class="form form-horizontal" id="form-crm-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>公司名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" required value="${resultMap.companyReferencePo.crmName }" placeholder="" id="crmName" name="crmName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">群名备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" required value="${resultMap.companyReferencePo.crmGroupMark }" placeholder="" id="crmGroupMark" name="crmGroupMark">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">上游描述：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="crmForwardDesc" id="crmForwardDesc"  style="height:300px" cols="" rows="" class="textarea" placeholder="说点什么...最少输入10个字符" datatype="*10-1000" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="$.Huitextarealength(this,1000)">${resultMap.companyReferencePo.crmForwardDesc }</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/1000</p>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">下游描述：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea style="height:300px" id="crmBackwardDesc" name="crmBackwardDesc" cols="" value="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-1000" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="$.Huitextarealength(this,1000)">${resultMap.companyReferencePo.crmBackwardDesc }</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/1000</p>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">是否已对接系统：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<div class="check-box">
					<input type="checkbox" id="crmPlatformTag" name="crmPlatformTag" <c:if test='${resultMap.companyReferencePo.crmPlatformTag== 1 }'>checked</c:if> value="1">
					已对接<label for="checkbox-pinglun">&nbsp;</label>
				</div>
			</div>
		</div>
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">文章内容：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<script id="editor" type="text/plain" style="width:100%;height:400px;"></script> 
			</div>
		</div> -->
		<input type="hidden" name="id" id="id" value="${resultMap.companyReferencePo.id }"/>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button onClick="removeIframe();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
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
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
//表单验证
	$("#form-crm-add").validate({
		submitHandler:function(form){
			var crmBackwardDesc = $('#crmBackwardDesc').val();
			//alert($.trim(crmBackwardDesc));
			var crmForwardDesc = $('#crmForwardDesc').val();
			//alert($.trim(crmForwardDesc));
			if($.trim(crmForwardDesc) == '' && $.trim(crmBackwardDesc) == ''){
				$('#crmForwardDesc').focus();
				layer.msg('两个描述不能同时为空')
			}else{
				save();
			}
		}
	})
})
	

///提交表单信息
function save(){
	//var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	//alert(index);
	var url = '/flowsys/crm/crm_add.do';
	var id = $('#id').val();
	if(id != ''){
		url = '/flowsys/crm/crm_edit.do';
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
            }else{
                layer.msg('保存异常!');
            }
           // parent.layer.close(index); ////执行关闭
           removeIframe();
        }
    });
}
</script>
</html>