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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银行卡添加页面</title>
</head>
<body>
	<form action="" method="" class="form form-horizontal" id="form-article-add">
		<input type="hidden" value="${resultMap.bankPo.id}" name="id">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">银行卡类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text isEmpty" value="${resultMap.bankPo.remittanceWay }" placeholder="如：建设银行" id="remittanceWay" name="remittanceWay">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">汇款账号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text isEmpty" value="${resultMap.bankPo.remittanceBankAccount }" placeholder="" id="remittanceBankAccount" name="remittanceBankAccount">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">账户真实姓名</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				 <input type="text" class="input-text isEmpty" value="${resultMap.bankPo.accountName }" placeholder="" id="accountName" name="accountName">
		 	</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">对账余额：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text isEmpty" value="${resultMap.bankPo.referenceBalance }" placeholder="" id="referenceBalance" name="referenceBalance">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit" onclick="editBank()"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button class="btn btn-primary radius" onClick="cancelEdit()">取消</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>  
<script type="text/javascript">
$(document).ready(function() {
	/* $(".isEmpty").each(function(){
		var info = $(this).html();
		//alert(info == '');
		if (info == null || info == undefined || info == '') {
			$(this).html('没有填写');
			$(this).addClass('c-red');
		}
	}) */
})
function editBank(){
	$.ajax({
        type:"post",
        url:"/flowsys/bankAccount/edit_bank.do",
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
</script>
</html>