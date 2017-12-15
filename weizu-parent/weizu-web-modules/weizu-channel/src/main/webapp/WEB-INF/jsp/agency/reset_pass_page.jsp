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
<title>重置密码</title>
</head>
<body>
	<form action="" method="" class="form form-horizontal" id="form-article-add">
		<!-- 不能修改要原样保留的数据 -->
		<input type="hidden" name="tag" value="${resultMap.tag }" id="tag">
		<input type="hidden" name="agencyId" value="${resultMap.agencyId }" id="agencyId">
		<%-- <input type="hidden" value="${resultMap.agencyPo.rootAgencyId }" name="rootAgencyId"> --%>
		
		<c:if test="${resultMap.tag == '1' }"><!-- 给自己设置密码 -->
			<input type="hidden" value="${loginContext.userPass }" id="userPass">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">原密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" class="input-text isContainsSpecialChar" style="width:350px;" required value="" placeholder="" id="lastPass" name="lastPass">
				</div>
			</div>
		</c:if>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">新密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text isContainsSpecialChar"  style="width:350px;" required value="" placeholder="输入新密码" id="enterPass" name="enterPass">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button class="btn btn-primary radius" onClick="removeIframe()">取消</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>  
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
/* function cancelEdit(){
	var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	parent.layer.close(index); // 执行关闭 
} */
$().ready(function() {
	//alert($('#userPass').val());
    $("form").validate({
    	rules:{
    		enterPass:{
    			required: true,
	            minlength: 3
    		},
	    	lastPass: {
		             required: true,
		             minlength: 3,
		             equalTo: "#userPass" 
		            //自带判断当前文本框值与指定ID为password的文本框的值是否相同
	         }
    	},
    	 messages: {
    		 enterPass:{
     			required:  "请输入新密码",
 	            minlength: "密码不能小于3个字符"
     		},
    		 lastPass: {
	             required: "请输入新密码",
	             minlength: "密码不能小于3个字符",
	             equalTo: "原密码输入错误" 
	            //自带判断当前文本框值与指定ID为password的文本框的值是否相同
         	}
    	 },
    	submitHandler : function(form) {
    		if($('#userPass').val() != $("#enterPass").val()){
	    		$.ajax({
	                type:"post",
	                url:"/flowsys/agency/reset_pass.do",
	                data: $('form').serialize(),//表单数据
	                async : false,
	                success:function(d){
	                    if(d=="success"){
	                        layer.msg('保存成功！');//保存成功提示
	                        var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	                    		parent.layer.close(index); // 执行关闭
	                        	//window.location.pathname = "/flowsys/agency/reset_pass_page.do";
	                    }
	                    if(d=="error"){
	                        layer.msg('保存异常!');
	                    }
	                }
	            });
    		}else{
    			layer.msg('和原先密码相同，请重新设置密码');
    		}
    	}
    });
})
</script>
</html>