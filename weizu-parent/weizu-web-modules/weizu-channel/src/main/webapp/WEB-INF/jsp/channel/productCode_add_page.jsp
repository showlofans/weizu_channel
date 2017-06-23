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

<title>新增包体编码 - H-ui.admin 3.0</title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<h3>${resultMap.pageTitle }</h3>
	
	<form action="/flowsys/productCode/product_code_add.do" method="post" onsubmit="save()" class="form form-horizontal" id="product_form">
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">平台</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box inline">
					<select id="selectEpId" name="epId" class="select">
						<c:forEach items="${resultMap.epList }" var="ep" varStatus="vs1">
							<c:if test="${ep.id==product_add.epId }">
								<option value="${ep.epId }" selected="selected" >${ep.epName }</option>
							</c:if>
							<option value="${ep.epId }" >${ep.epName }</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">运营商类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<%-- <c:forEach items="${resultMap.pgTypeEnums }" var="pgType" varStatus="vs1">
					<div class="radio-box">
						<input value="${pgType.value }" onclick="ajaxGetPg()" name="operatorType" type="radio" id="pgType-${vst1.index+1 }"  <c:if test="${pgType.value == resultMap.operatorType }"> checked</c:if>>
						<label for="pgType-${vst1.index+1 }">${pgType.desc }</label>
					</div>
				</c:forEach> --%>
				 <span class="select-box inline">
					<select name="operatorType" id="operatorType" class="select"  onchange="ajaxGetPg()">
						<c:forEach items="${resultMap.pgTypeEnums }" var="pgType" varStatus="vs1">
							<option value="${pgType.value }"  <c:if test="${pgType.value == resultMap.operatorType }"> selected</c:if>>${pgType.desc }</option>
						</c:forEach>
					</select>
				</span> 
			</div>
		</div>
		<div class="row cl">
			 <label class="form-label col-xs-4 col-sm-3">业务类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				 <span class="select-box inline">
					<select name="serviceType" id="serviceType" class="select" onchange="ajaxGetPg()">
						<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceTypeEnum" varStatus="vs1">
							<c:if test="${serviceTypeEnum.value == product_add.operatorType }">
								<option value="${serviceTypeEnum.value }" selected="selected" >${serviceTypeEnum.desc }</option>
							</c:if>
							<option value="${serviceTypeEnum.value }" >${serviceTypeEnum.desc }</option>
						</c:forEach>
					</select>
				</span> 
			</div>
		</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">包体</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box inline">
					<select name="pgId" id="pgId" class="select"  onchange="changePg()"> <!-- -->
						<c:forEach items="${resultMap.pgList }" var="pg" varStatus="vs1">
							<option value="${pg.id }">${pg.pgName }</option>
							<span id="spanPgPrice" style="display:none;">${pg.pgPrice }</span><!-- 包体价格 -->
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">省份名称</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box inline">
					<select name="scopeCityCode" class="select">
						<c:forEach items="${resultMap.scopeCityEnums }" var="cityEnum" varStatus="vs1">
							<option value="${cityEnum.value }" selected="selected" >${cityEnum.desc }</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">包体编码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="productCode" name="productCode">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<!-- <button onClick="article_save();" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button>
				<button onClick="removeIframe();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button> -->
			</div>
		</div>
	<input id="pgPrice"  type="hidden" value="" name="pgPrice"></input>
	</form>
<!-- 	<input id="pgSize" type="hidden" value="" name="pgSize"></input> -->
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
    $("#product_form").validate({
    	rules:{
    		productCode : {
	    			remote:{//验证用户名是否存在
	    				  type:"post",
	    	               url:"/flowsys/productCode/product_code_exist.do",             //servlet
	    	               data:{
	    	            	  epId :function(){return $("#selectEpId").val().trim();},
	    	               	  productCode :function(){return $("#productCode").val().trim();}
	    					}
    				}
    		}
    	},
    	messages:{
    		productCode:{ remote:jQuery.format("该通道编码已存在！！ ")}
    	},
    	submitHandler: function(){
             save();
         }
    });
});

/**设置包体其他属性*/
function changePg(){
	var et = $("#pgId").get(0).selectedIndex;
	//alert(et);
	alert($("#pgId :hidden").html());
	var pgPrice = $("#pgId span:hidden").html();//:eq("+ et +")
	//alert(pgPrice);
	
	/* var palist = $("#pgList").val();
	var pgId = $("#pgId").val();
	alert(palist.length);
	for (var int = 0; int < palist.length; int++) {
		if(pglist[i].id == pgId){
			$("#pgPrice").val(pglist[i].pgPrice);
			
			break;
		}
	} */
}
/***表单提交*/
 function save(){
	//$("#rechargeAmount").focus();
	var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	$.ajax({
        type:"post",
        url:"/flowsys/productCode/product_code_add.do",
        data: $('#product_form').serialize(),//表单数据
        async : false,
        success:function(d){
            if(d=="success"){
                layer.msg('保存成功！');//保存成功提示
            parent.layer.close(index); //执行关闭
            }
            if(d=="error"){
                layer.msg('保存异常!');
            }
        }
    });
}
/**获得流量包列表*/
 function ajaxGetPg(){
	var stype = $("#serviceType").val();
	var otype = $("#operatorType").val();
	//alert(stype + "  " + otype);
	$.ajax({
        type:"post",
        url:"/flowsys/productCode/productCode_add_page/ajax_pg_list.do",
        data: {operatorType:otype,serviceType:stype},//表单数据
        dataType: "json",
        async : false,
        success:function(data){
        	//alert(data.length);
        	if(data.length > 0){
                $("#pgId").empty();//清空原有收据 
                var appendData;
        		for(var i=0; i < data.length; i++){
        			appendData += "<option value="+ data[i].id +">" + data[i].pgName +"</option>";
                }
            }else{
            	  appendData += "没有可选项 ！！";
            }
        	$("#pgId").prepend(appendData);
        }
    });
}

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