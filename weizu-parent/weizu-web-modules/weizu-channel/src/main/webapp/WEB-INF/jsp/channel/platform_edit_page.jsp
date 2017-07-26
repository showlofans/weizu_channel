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

<title> H-ui.admin 3.0</title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<h3>${pageTitle }</h3>
	<form action="" method=""  class="form form-horizontal" id="platfrom">
		<input type="hidden" value="${exchangePlatformPo.id }" name="id">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>平台名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${exchangePlatformPo.epName }" placeholder="" id="epName" name="epName">
			</div>
		</div>
		<!-- id, ep_name, ep_purchase_ip, product_list_ip, pgdata_check_ip, ep_balance_ip, 
    ep_user_name, ep_user_pass, ep_balance, ep_apikey, ep_ip -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">流量订购地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" required  value="${exchangePlatformPo.epPurchaseIp }" placeholder="" id="epPurchaseIp" name="epPurchaseIp">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">产品列表地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" required value="${exchangePlatformPo.productListIp }" placeholder="" id="productListIp" name="productListIp">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">流量查询地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text required" required  value="${exchangePlatformPo.pgdataCheckIp }" placeholder="" id="pgdataCheckIp" name="pgdataCheckIp">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">余额查询地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" required  value="${exchangePlatformPo.epBalanceIp }" placeholder="" id="epBalanceIp" name="epBalanceIp">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">账号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  value="${exchangePlatformPo.epUserName }" required placeholder="${exchangePlatformPo.epUserName }" id="epUserName" name="epUserName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  value="${exchangePlatformPo.epUserPass }" required placeholder="${exchangePlatformPo.epUserPass }" id="epUserPass" name="epUserPass">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">平台余额：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" readonly="readonly"  value="${exchangePlatformPo.epBalance }" placeholder="" id="epBalance" name="epBalance">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">apikey：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  value="${exchangePlatformPo.epApikey }" placeholder="" id="epApikey" name="epApikey">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">主页地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" required  value="${exchangePlatformPo.epIp }" placeholder="" id="epIp" name="epIp">
			</div>
		</div>
		
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<!-- <button onClick="article_save();" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button>
				<button onClick="removeIframe();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button> -->
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
<script type="text/javascript" src="/view/lib/ueditor/1.4.3/ueditor.config.js"></script> 
<script type="text/javascript" src="/view/lib/ueditor/1.4.3/ueditor.all.min.js"> </script> 
<script type="text/javascript" src="/view/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
$().ready(function() {
    $("#platfrom").validate({
    	submitHandler : function(form) {
    		$.ajax({
                type:"post",
                url:"/flowsys/platform/platform_edit.do",
                data: $('form').serialize(),//表单数据
                async : false,
                success:function(d){
                    if(d=="success"){
                        layer.msg('保存成功！');//保存成功提示
                        var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
                        parent.layer.close(index);
                       /*  if($("h3").html().trim() != ""){//列表打开
                    		parent.layer.close(index); // 执行关闭
                        }else{
                        	window.location.pathname = "/flowsys/platform/platform_list.do";
                        } */
                    }
                    if(d=="error"){
                        layer.msg('保存异常!');
                    }
                }
            });
    	}
    });
})

 /* function save(){
	//$("#rechargeAmount").focus();
	var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	$.ajax({
        type:"post",
        url:"/flowsys/platform/platform_add.do",
        data: $('form').serialize(),//表单数据
        async : false,
        success:function(d){
            if(d=="success"){
                layer.msg('保存成功！');//保存成功提示
                if($("h3").html().trim() != ""){//列表打开
            		parent.layer.close(index); // 执行关闭
                }else{
                	window.location.pathname = "/flowsys/platform/platform_list.do";
                	return false;
                }
            }
            if(d=="error"){
                layer.msg('保存异常!');
            }
            if(d=="errorEp"){
                layer.msg('保存异常,已经添加过该平台了!');
            }
        }
    });
	return false;
} */

/*  $(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});*/
	
	//表单验证
	/* $("#form-article-add").validate({
		rules:{
			pgName:{
				required:true,
			},
			pgSize:{
				required:true,
			},
			operatorName:{
				required:true,
			},
			operatorType:{
				required:true,
			},
			pgPrice:{
				required:true,
			},
			
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit();
			//var index = parent.layer.getFrameIndex(window.name);
			//parent.$('.btn-refresh').click();
			//parent.layer.close(index);
		}
	}); 
	
	$list = $("#fileList"),
	$btn = $("#btn-star"),
	state = "pending",
	uploader;

	var uploader = WebUploader.create({
		auto: true,
		swf: '/view/lib/webuploader/0.1.5/Uploader.swf',
	
		// 文件接收服务端。
		server: 'fileupload.php',
	
		// 选择文件的按钮。可选。
		// 内部根据当前运行是创建，可能是input元素，也可能是flash.
		pick: '#filePicker',
	
		// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		resize: false,
		// 只允许选择图片文件。
		accept: {
			title: 'Images',
			extensions: 'gif,jpg,jpeg,bmp,png',
			mimeTypes: 'image/*'
		}
	});
	uploader.on( 'fileQueued', function( file ) {
		var $li = $(
			'<div id="' + file.id + '" class="item">' +
				'<div class="pic-box"><img></div>'+
				'<div class="info">' + file.name + '</div>' +
				'<p class="state">等待上传.</p>'+
			'</div>'
		),
		$img = $li.find('img');
		$list.append( $li );
	
		// 创建缩略图
		// 如果为非图片文件，可以不用调用此方法。
		// thumbnailWidth x thumbnailHeight 为 100 x 100
		uploader.makeThumb( file, function( error, src ) {
			if ( error ) {
				$img.replaceWith('<span>不能预览</span>');
				return;
			}
	
			$img.attr( 'src', src );
		}, thumbnailWidth, thumbnailHeight );
	});
	// 文件上传过程中创建进度条实时显示。
	uploader.on( 'uploadProgress', function( file, percentage ) {
		var $li = $( '#'+file.id ),
			$percent = $li.find('.progress-box .sr-only');
	
		// 避免重复创建
		if ( !$percent.length ) {
			$percent = $('<div class="progress-box"><span class="progress-bar radius"><span class="sr-only" style="width:0%"></span></span></div>').appendTo( $li ).find('.sr-only');
		}
		$li.find(".state").text("上传中");
		$percent.css( 'width', percentage * 100 + '%' );
	});
	
	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file ) {
		$( '#'+file.id ).addClass('upload-state-success').find(".state").text("已上传");
	});
	
	// 文件上传失败，显示上传出错。
	uploader.on( 'uploadError', function( file ) {
		$( '#'+file.id ).addClass('upload-state-error').find(".state").text("上传出错");
	});
	
	// 完成上传完了，成功或者失败，先删除进度条。
	uploader.on( 'uploadComplete', function( file ) {
		$( '#'+file.id ).find('.progress-box').fadeOut();
	});
	uploader.on('all', function (type) {
        if (type === 'startUpload') {
            state = 'uploading';
        } else if (type === 'stopUpload') {
            state = 'paused';
        } else if (type === 'uploadFinished') {
            state = 'done';
        }

        if (state === 'uploading') {
            $btn.text('暂停上传');
        } else {
            $btn.text('开始上传');
        }
    });

    $btn.on('click', function () {
        if (state === 'uploading') {
            uploader.stop();
        } else {
            uploader.upload();
        }
    });
	
	var ue = UE.getEditor('editor');
	
}); */
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>