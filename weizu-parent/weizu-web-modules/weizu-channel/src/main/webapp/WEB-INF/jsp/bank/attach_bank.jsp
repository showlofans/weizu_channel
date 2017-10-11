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

<title>给代理商账户设置银行卡 </title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
<article class="page-container">
	<h4>银行卡设置</h4>
	<form action="" method="" class="form form-horizontal" id="form-pg-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>代理商名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${resultMap.agencyName }
				<%-- <input type="text" class="input-text" value="${resultMap.agencyName }" placeholder="不填可用默认值"> --%>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">账户类型：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
					<c:if test="${billTypeEnum.value == resultMap.billType }">
						${billTypeEnum.desc }
					</c:if>
				</c:forEach>
			</div>
		</div>
		<table class="table table-border table-bordered table-bg">
		<c:forEach items="${resultMap.attachList}" var="bankPo" varStatus="vs1">
			<tr>
				<td>${bankPo.remittanceWay }</td>
				<td>${bankPo.remittanceBankAccount }</td>
				<td>${bankPo.accountName }</td>
				<td>
					<a style="text-decoration:none" class="ml-5" onClick="bank_del('/flowsys/bankAccount/del_bank.do',this,${bankPo.id})" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6e2;</i></a>
				</td>
			</tr>
			<%-- <div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>银行卡-${vs1.index+1 }</label>
				<div class="formControls col-xs-8 col-sm-9">
				</div>
			</div> --%>
		</c:forEach>
		</table>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>银行卡名称：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="id" class="select" id="id" onchange="setBankAccount(this[selectedIndex])">
					<option value="">银行卡</option>
					<c:forEach items="${resultMap.unattachList }" var="bankPo" varStatus="vs1">
						<option value="${bankPo.id }">${bankPo.remittanceWay }</option>
						<input value="${bankPo.remittanceBankAccount }"></input>
					</c:forEach>
				</select>
				</span> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">加款账号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" readonly="readonly" value="" placeholder="" id="remittanceBankAccount" name="remittanceBankAccount">
				<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" onClick="add_bank('/flowsys/bankAccount/attach_bank.do')" href="javascript:;" title="添加银行卡"><i class="Hui-iconfont">&#xe725;</i></a>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i>确认</button><!-- btn-secondary -->
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
<script type="text/javascript" src="/view/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="/view/lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="/view/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
//设置账号
function setBankAccount(vart){
	 var bankAccount = $(vart).next().val();
	 alert(bankAccount);
	 $('#remittanceBankAccount').val(bankAccount);
}
//删除绑定
function bank_del(url,vart,idt){
	layer.confirm('确认要删除银行卡绑定吗？',function(index){
		$.ajax({
			type: 'POST',
			url: url,
			data: {id:id},
			success: function(data){
				if(data=="success")
				{
					layer.msg('删除成功!',{icon:1,time:1000});
					location.reload();
				}else{
					layer.msg('删除失败!',{icon:2,time:1000});
				}
			},
			error:function(data) {
				console.log(data.msg);
			}
		});		
	});
}
//添加绑定
function add_bank(url){
	var id = $('#id').val();
	alert(id);
	$.ajax({
		type: 'POST',
		url: url,
		data: {id:id},
		success: function(data){
			if(data=="success")
			{
				layer.msg('添加成功!',{icon:1,time:1000});
				location.reload();
			}else{
				layer.msg('添加失败!',{icon:2,time:1000});
			}
		},
		error:function(data) {
			console.log(data.msg);
		}
	});	
}

$().ready(function() {
    $("#form-pg-add").validate({
    	rules:{
    		pgSize : {
    			remote:{//验证用户名是否存在
    				  type:"get",
    	               url:"/flowsys/operatorPg/pg_exist.do",             //servlet
    	               data:{
    	            	   pgSize :function(){return $("#pgSize").val().trim();},
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
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>