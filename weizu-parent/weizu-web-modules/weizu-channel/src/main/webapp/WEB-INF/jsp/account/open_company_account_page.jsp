<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/view/favicon.ico" >
<link rel="Shortcut Icon" href="/view/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/view/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/style.css" />
<link href="/view/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title> - H-ui.admin 3.0</title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
<style>
        .first {
            width: 50%;
            float:left;
            height: 100px;
            border: 1px solid #3B6273;
        }
        .second {
            width: 50%;
            float:left;
            height: 100px;
            border: 1px solid #3B6273;
        }
    </style>
</head>

<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 账户管理 <span class="c-gray en">&gt;</span> 认证信息 <!-- <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a> --></nav>
<div class="page-container">
	<form action="/flowsys/account/open_company_account.do" id="openCompanyAccount" method="post" class="form form-horizontal" enctype=”multipart/form-data” id="form-article-add">
		<!-- <div id="uploader" class="wu-example">
		    用来存放文件信息
		    <div class="btns">
			    <div id="thelist" class="uploader-list"></div>
		        <div id="attach"></div>
		        <input type="button" value="上传" id="upload"/> 
		    </div>
		</div> -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>公司名称：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<input type="text" class="input-text" value="${resultMap.ccpo.companyName }" placeholder="公司名称" required id="" name="companyName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>公司地址：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<input type="text" class="input-text" value="${resultMap.ccpo.companyLocation }" placeholder="公司地址" id="" name="companyLocation">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>公司（负责人）联系电话：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<input type="text" class="input-text" value="${resultMap.ccpo.corporateTel }" placeholder="公司（负责人）联系电话" id="" name="corporateTel">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">是否具备增值税一般纳税人资格：</label>
			<div class="formControls col-xs-7 col-sm-9 skin-minimal">
				<div class="check-box">
					<input name="taxpayerIsQualification" <c:if test="${resultMap.ccpo.taxpayerIsQualification ==1 }"> checked </c:if> value="1" type="checkbox" id="checkbox-1">
					<label for="checkbox-1">&nbsp;</label>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>开户行名称：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<input type="text" class="input-text" value="${resultMap.ccpo.depositBankName }" placeholder="开户行名称" id="" name="depositBankName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>银行账号：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<input type="text" class="input-text" value="${resultMap.ccpo.bankAccount }" placeholder="银行账号" id="" name="bankAccount">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>税务登记证号：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<input type="text" class="input-text" value="${resultMap.ccpo.taxRegistrationCertificate }" placeholder="税务登记证号" id="" name="taxRegistrationCertificate">
			</div>
		</div>
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>开票内容信息服务费：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="" name="billingContent">
			</div>
		</div> -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>开票内容：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<input type="text" class="input-text" readonly="readonly" value="信息服务费" placeholder="信息服务费" id="" name="billingContent">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">企业现居地址：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<input type="text" class="input-text" value="${resultMap.ccpo.companyAddress }" placeholder="企业现居地址" id="" name="companyAddress">
			</div>
		</div>
		<!-- style=" width:25%" -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">发票收件人：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<input type="text" name="billRecipientsName" id="" placeholder="发票收件人" value="${resultMap.ccpo.billRecipientsName }" class="input-text">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">收件人电话：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<input type="text" name="billRecipientsTel" id="" placeholder="收件人电话" value="${resultMap.ccpo.billRecipientsTel }" class="input-text">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">收件地址：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<input type="text" name="billRecipientsAddress" id="" placeholder="收件地址" value="${resultMap.ccpo.billRecipientsAddress }" class="input-text">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-7 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<c:choose>
					<c:when test="${resultMap.ccpo.confirmState == 1 || resultMap.ccpo.confirmState == 2 }"><!-- 待审核和审核成功 -->
						<button onClick="article_save_submit();" class="btn btn-primary radius" disabled="disabled" onClick="javascript:alert('已经审核成功');" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存并提交审核</button>
						<button onClick="article_save();" class="btn btn-secondary radius"  disabled="disabled" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button>
					</c:when>
					<c:otherwise>
						<button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存并提交审核</button>
						<button onClick="article_save();" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button>
					</c:otherwise>
				</c:choose>
				
				<!-- <button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button> -->
			</div>
		</div>
		<input type="hidden" id="confirmState" name="confirmState" value="${resultMap.ccpo.confirmState }">
		<c:choose>
			<c:when test="${empty resultMap.ccpo }">
				<span class="c-red">待完善</span>
			</c:when>
			<c:otherwise>
				<c:forEach items="${resultMap.confirmStateEnums }" var="confirmStateE" varStatus="vst">
					<c:if test="${resultMap.ccpo.confirmState == confirmStateE.value }">
						<span class="c-green">${confirmStateE.desc }</span>
					</c:if>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</form>
		<%-- <form action="" method="" class="form form-horizontal">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">营业执照：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<div class="uploader-thum-container">
					<div id="fileList4" class="uploader-list"></div>
					<c:choose>
						<c:when test="${empty resultMap.ccpo.businessLicense }">
							<div id="businessLicense">选择图片</div>
						</c:when>
						<c:otherwise><!-- ${resultMap.ccpo.businessLicense } -->
							<input value="license" class="input-text upload-url" style="width:300px" type="text" readonly >
							<div id="businessLicense">选择图片</div>
							<!-- <button id="btn-star4" disabled="disabled" class="btn btn-default btn-uploadstar radius ml-10">开始上传</button>图片以：<span class="c-red">license</span>命名 -->
						</c:otherwise>
					</c:choose>
					<button id="btn-star4" class="btn btn-default btn-uploadstar radius ml-10">开始上传</button>图片以：<span class="c-red">license</span>命名
					<!-- <span class="btn-upload form-group">
					<input class="input-text upload-url" type="text" name="uploadfile-2" id="businessLicense" readonly style="width:200px">
					<a href="javascript:void();" class="btn btn-primary upload-btn"><i class="Hui-iconfont">&#xe642;</i> 上传</a>
					<input type="file" multiple name="businessLicense" class="input-file">
					</span>  -->
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">银行开户信息：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<div class="uploader-thum-container">
					<div id="fileList3" class="uploader-list"></div>
					<c:choose>
						<c:when test="${empty resultMap.ccpo.depositBankPhoto }">
							<div id="depositBankPhoto">选择图片</div>
						</c:when>
						<c:otherwise><!-- ${resultMap.ccpo.businessLicense } -->
							<input value="bank" class="input-text upload-url" style="width:300px" type="text" readonly >
							<div id="depositBankPhoto">选择图片</div>
							<!-- <button id="btn-star3" disabled="disabled" class="btn btn-default btn-uploadstar radius ml-10">开始上传</button>图片以：<span class="c-red">bank</span>命名 -->
						</c:otherwise>
					</c:choose>
					<button id="btn-star3" class="btn btn-default btn-uploadstar radius ml-10">开始上传</button>图片以：<span class="c-red">bank</span>命名
					<!-- <div id="fileList3" class="uploader-list"></div>
					<div id="depositBankPhoto">选择图片</div>
					<button id="btn-star3" class="btn btn-default btn-uploadstar radius ml-10">开始上传</button>图片以：<span class="c-red">bank</span>命名 -->
					<!-- <span class="btn-upload form-group">
					<input class="input-text upload-url" type="text" name="uploadfile-2" id="depositBankPhoto" readonly style="width:200px">
					<a href="javascript:void();"  id="btn-star3" class="btn btn-primary upload-btn"><i class="Hui-iconfont">&#xe642;</i> 上传</a>
					<input type="file" multiple name="depositBankPhoto" class="input-file">
					</span>  -->
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">法定人身份证(正面)：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<div class="uploader-thum-container">
					<!-- <div id="fileList" class="uploader-list"></div>
					<div id="corporateIdentityFront">选择图片</div>
					<button id="btn-star2" class="btn btn-default btn-uploadstar radius ml-10">开始上传</button> -->
					<div id="fileList2" class="uploader-list"></div>
					<c:choose>
						<c:when test="${empty resultMap.ccpo.corporateIdentityFront }">
							<div id="corporateIdentityFront">选择图片</div>
						</c:when>
						<c:otherwise><!-- ${resultMap.ccpo.corporateIdentityFront } -->
							<input value="idFront" class="input-text upload-url" style="width:300px" type="text" readonly >
							<div id="corporateIdentityFront">选择图片</div>
							<!-- <button id="btn-star2" disabled="disabled" class="btn btn-default btn-uploadstar radius ml-10">开始上传</button>图片以：<span class="c-red">idFront</span>命名 -->
						</c:otherwise>
					</c:choose>
					<button id="btn-star2" class="btn btn-default btn-uploadstar radius ml-10">开始上传</button>图片以：<span class="c-red">idFront</span>命名
					
				
					 <!-- <div id="corporateIdentityFront"></div>
					<span class="btn-upload form-group">
					<input class="input-text upload-url" type="text" name="uploadfile-2" readonly style="width:200px">
					<input type="file" multiple name="corporateIdentityFront" class="input-file">
					</span> 
					<i class="Hui-iconfont">&#xe642;<input type="button" class="btn btn-primary" value="上传" id="btn-star2"/></i> -->
					<!-- <a href="javascript:void();"  id="btn-star2" class="btn btn-primary"><i class="Hui-iconfont">&#xe642;</i> 上传</a> -->
				</div> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">法定人身份证(反面)：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<div class="uploader-thum-container">
					<div id="fileList1" class="uploader-list"></div>
					<c:choose>
						<c:when test="${empty resultMap.ccpo.corporateIdentityBack }">
							<div id="corporateIdentityBack">选择图片</div>
						</c:when>
						<c:otherwise><!-- ${resultMap.ccpo.corporateIdentityBack } -->
							<input value="idBack" class="input-text upload-url" style="width:300px" type="text" readonly >
							<div id="corporateIdentityBack">选择图片</div>
							<!-- <button id="btn-star1" disabled="disabled" class="btn btn-default btn-uploadstar radius ml-10">开始上传 </button>图片以：<span class="c-red">idBack</span>命名 -->
						</c:otherwise>
					</c:choose>
					<button id="btn-star1" class="btn btn-default btn-uploadstar radius ml-10">开始上传 </button>图片以：<span class="c-red">idBack</span>命名
					
					
					<!-- <span class="btn-upload form-group">
					<input class="input-text upload-url" type="text" name="uploadfile-2" id="corporateIdentityBack" readonly style="width:200px">
					<input type="file" multiple name="corporateIdentityBack" class="input-file">
					</span> 
					<a href="javascript:void();" id="btn-star1" class="btn btn-primary upload-btn" ><i class="Hui-iconfont">&#xe642;</i> 上传</a> -->
				</div>
			</div>
		</div>
	</form>  --%>
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">法定人身份证(反面)：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<div class="uploader-list-container">
					<div class="queueList">
						<div id="dndArea" class="placeholder">
							<div id="filePicker-2"></div>
							<p>或将照片拖到这里，单次最多可选300张</p>
						</div>
					</div>
					<div class="statusBar" style="display:none;">
						<div class="progress"> <span class="text">0%</span> <span class="percentage"></span> </div>
						<div class="info"></div>
						<div class="btns">
							<div id="filePicker2"></div>
							<div class="uploadBtn">开始上传</div>
						</div>
					</div>
				</div>
			</div>
		</div> -->
	<form action="/flowsys/account/open_company_account.do" class="form form-horizontal" method="post" id="business">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>商务负责人姓名：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<input type="text" class="input-text" value="${resultMap.ccpo.businessExecutiveName }" placeholder="商务负责人姓名" id="" name="businessExecutiveName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">商务联系电话：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<input type="text" class="input-text" value="${resultMap.ccpo.beTel }" placeholder="商务联系电话" id="" name="beTel">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">紧急联系人姓名：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<input type="text" class="input-text" value="${resultMap.ccpo.emergencyContact }" placeholder="紧急联系人姓名" id="" name="emergencyContact">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">紧急联系人电话：</label>
			<div class="formControls col-xs-7 col-sm-9">
				<input type="text" class="input-text" value="${resultMap.ccpo.ecTel }" placeholder="紧急联系人电话" id="" name="ecTel">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-7 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<!-- <button onClick="article_save();" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button> -->
				<button onClick="removeIframe();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
		<input type="hidden" id="confirmState" name="confirmState" value="${resultMap.ccpo.confirmState }">
		<%-- <c:choose>
			<c:when test="${empty ccpo }">
				<span class="c-red">待完善</span>
			</c:when>
			<c:otherwise>
				<c:forEach items="${resultMap.confirmStateEnums }" var="confirmStateE" varStatus="vst">
					<c:if test="${resultMap.ccpo.confirmState == confirmStateE.value }">
						${confirmStateE.desc }
					</c:if>
				</c:forEach>
			</c:otherwise>
		</c:choose> --%>
	</form>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<!-- <script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> -->
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="/view/lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="/view/lib/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript" src="/view/lib/ueditor/1.4.3/ueditor.all.min.js"> </script>
<script type="text/javascript" src="/view/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">

function article_save(){
	$('#confirmState').val(3);//待完善，草稿
	//$('form').submit();
}
function article_save_submit(){
	$('#confirmState').val(2);//待审核
	$('#openCompanyAccount').submit();
}
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	var arry = [ "license","bank","idFront","idBack"] ;
	var $list1 = $("#fileList1");
	var $list2 = $("#fileList2");
	var $list3 = $("#fileList3");
	var $list4 = $("#fileList4");
    var  uploader1 ;// 实例化   
    var  uploader2 ;// 实例化   
    var  uploader3 ;// 实例化   
    var  uploader4 ;// 实例化   
    uploader1 = WebUploader.create({ 
           auto:false, //是否自动上传
            pick: {
                id: '#corporateIdentityBack',
                name:"file",  //这个地方 name 没什么用，虽然打开调试器，input的名字确实改过来了。但是提交到后台取不到文件。如果想自定义file的name属性，还是要和fileVal 配合使用。
                label: '点击选择图片',
                multiple:false            //默认为true，true表示可以多选文件，HTML5的属性
            },
            swf: '/view/lib/webuploader/0.1.5/Uploader.swf',  //在这里必需要引入swf文件，webuploader初始化要用
            //fileVal:'multiFile',  //自定义file的name属性，我用的版本是0.1.5 ,打开客户端调试器发现生成的input 的name 没改过来。
                                             //名字还是默认的file,但不是没用哦。虽然客户端名字没改变，但是提交到到后台，是要用multiFile 这个对象来取文件的，用file 是取不到文件的
                                             // 建议作者有时间把这个地方改改啊，搞死人了。。
            server: "/flowsys/account/upload_img_file.do",
            duplicate:false,//是否可重复选择同一文件
            resize: false,
            formData: {
                "status":"file",
                "contentsDto.contentsId":"0000004730",
                "uploadNum":"0000004730",
                "existFlg":'false'
            },  
            compress: null,//图片不压缩
            chunked: true,  //分片处理
            chunkSize: 5 * 1024 * 1024, //每片5M
            chunkRetry:true,//如果失败，则不重试
            threads:1,//上传并发数。允许同时最大上传进程数。
            // runtimeOrder: 'flash',  
            // 禁掉全局的拖拽功能。这样不会出现图片拖进页面的时候，把图片打开。  
            disableGlobalDnd: true
        });  

      // 当有文件添加进来的时候
       uploader1.on( "fileQueued", function( file ) {
           console.log("fileQueued:");
           var fileName = file.name;
           var sub = fileName.substring(0,fileName.indexOf("."));
           //alert(sub);
           //var result= $.inArray(sub, arry);
           //alert(result);
           if('idBack' == sub){
	           $list1.append( "<div id='"+  file.id + "' class='item'>" +
	               "<h4 class='info'>" + file.name + "</h4>" +
	               "<p class='state'>等待上传...</p>" +
	           "</div>" );
           }else{
        	   $( "#"+file.id ).find("p.state").text("上传出错");
        	   uploader1.cancelFile(file);
               uploader1.removeFile(file,true);
               uploader1.reset();
               alert("请以idBack为文件名");
           }
       }); 

       //当所有文件上传结束时触发
       uploader1.on("uploadFinished",function(){
           console.log("uploadFinished:");
       })

        //当某个文件上传到服务端响应后，会派送此事件来询问服务端响应是否有效。
        uploader1.on("uploadAccept",function(object,ret){
            //服务器响应了
            //ret._raw  类似于 data
           // alert("上传成功");
           var data =JSON.parse(ret._raw);
            if(data.resultCode != "1" && data.resultCode != "3"){
                if(data.resultCode == "9"){
                    uploader1.reset();
                    alert("error");
                    return false;
                }
            }else{
                //E05017
                uploader1.reset();
                alert("error");
                return false;
            }
           })

       //当文件上传成功时触发。
         uploader1.on( "uploadSuccess", function( file ) {
        	 
           $( "#"+file.id ).find("p.state").text("已上传");
       });

       uploader1.on( "uploadError", function( file ) {
           $( "#"+file.id ).find("p.state").text("上传出错");
           uploader1.cancelFile(file);
           uploader1.removeFile(file,true);
           uploader1.reset();
       });
    uploader2 = WebUploader.create({ 
           auto:false, //是否自动上传
            pick: {
                id: '#corporateIdentityFront',
                name:"file",  //这个地方 name 没什么用，虽然打开调试器，input的名字确实改过来了。但是提交到后台取不到文件。如果想自定义file的name属性，还是要和fileVal 配合使用。
                label: '点击选择图片',
                multiple:false            //默认为true，true表示可以多选文件，HTML5的属性
            },
            swf: '/view/lib/webuploader/0.1.5/Uploader.swf',  //在这里必需要引入swf文件，webuploader初始化要用
            //fileVal:'multiFile',  //自定义file的name属性，我用的版本是0.1.5 ,打开客户端调试器发现生成的input 的name 没改过来。
                                             //名字还是默认的file,但不是没用哦。虽然客户端名字没改变，但是提交到到后台，是要用multiFile 这个对象来取文件的，用file 是取不到文件的
                                             // 建议作者有时间把这个地方改改啊，搞死人了。。
            server: "/flowsys/account/upload_img_file.do",
            duplicate:false,//是否可重复选择同一文件
            resize: false,
            formData: {
                "status":"file",
                "contentsDto.contentsId":"0000004730",
                "uploadNum":"0000004730",
                "existFlg":'false'
            },  
            compress: null,//图片不压缩
            chunked: true,  //分片处理
            chunkSize: 5 * 1024 * 1024, //每片5M
            chunkRetry:true,//如果失败，则不重试
            threads:1,//上传并发数。允许同时最大上传进程数。
            // runtimeOrder: 'flash',  
            // 禁掉全局的拖拽功能。这样不会出现图片拖进页面的时候，把图片打开。  
            disableGlobalDnd: true
        });  

      // 当有文件添加进来的时候
       uploader2.on( "fileQueued", function( file ) {
           console.log("fileQueued:");
           var fileName = file.name;
           var sub = fileName.substring(0,fileName.indexOf("."));
          // alert(sub);
           //var result= $.inArray(sub, arry);
          // alert(result);
           if(sub == 'idFront'){
	           $list2.append( "<div id='"+  file.id + "' class='item'>" +
	               "<h4 class='info'>" + file.name + "</h4>" +
	               "<p class='state'>等待上传...</p>" +
	           "</div>" );
           }else{
        	   $( "#"+file.id ).find("p.state").text("上传出错");
        	   uploader2.cancelFile(file);
               uploader2.removeFile(file,true);
               uploader2.reset();
               alert("请以idFront为文件名");
           }
       }); 

       //当所有文件上传结束时触发
       uploader2.on("uploadFinished",function(){
           console.log("uploadFinished:");
       })

        //当某个文件上传到服务端响应后，会派送此事件来询问服务端响应是否有效。
        uploader2.on("uploadAccept",function(object,ret){
            //服务器响应了
            //ret._raw  类似于 data
           // alert("上传成功");
           var data =JSON.parse(ret._raw);
            if(data.resultCode != "1" && data.resultCode != "3"){
                if(data.resultCode == "9"){
                    uploader2.reset();
                    alert("error");
                    return false;
                }
            }else{
                //E05017
                uploader2.reset();
                alert("error");
                return false;
            }
           })

       //当文件上传成功时触发。
         uploader2.on( "uploadSuccess", function( file ) {
        	 
           $( "#"+file.id ).find("p.state").text("已上传");
       });

       uploader2.on( "uploadError", function( file ) {
           $( "#"+file.id ).find("p.state").text("上传出错");
           uploader2.cancelFile(file);
           uploader2.removeFile(file,true);
           uploader2.reset();
       });
    uploader3 = WebUploader.create({ 
           auto:false, //是否自动上传
            pick: {
                id: '#depositBankPhoto',
                name:"file",  //这个地方 name 没什么用，虽然打开调试器，input的名字确实改过来了。但是提交到后台取不到文件。如果想自定义file的name属性，还是要和fileVal 配合使用。
                label: '点击选择图片',
                multiple:false            //默认为true，true表示可以多选文件，HTML5的属性
            },
            swf: '/view/lib/webuploader/0.1.5/Uploader.swf',  //在这里必需要引入swf文件，webuploader初始化要用
            //fileVal:'multiFile',  //自定义file的name属性，我用的版本是0.1.5 ,打开客户端调试器发现生成的input 的name 没改过来。
                                             //名字还是默认的file,但不是没用哦。虽然客户端名字没改变，但是提交到到后台，是要用multiFile 这个对象来取文件的，用file 是取不到文件的
                                             // 建议作者有时间把这个地方改改啊，搞死人了。。
            server: "/flowsys/account/upload_img_file.do",
            duplicate:false,//是否可重复选择同一文件
            resize: false,
            formData: {
                "status":"file",
                "contentsDto.contentsId":"0000004730",
                "uploadNum":"0000004730",
                "existFlg":'false'
            },  
            compress: null,//图片不压缩
            chunked: true,  //分片处理
            chunkSize: 5 * 1024 * 1024, //每片5M
            chunkRetry:true,//如果失败，则不重试
            threads:1,//上传并发数。允许同时最大上传进程数。
            // runtimeOrder: 'flash',  
            // 禁掉全局的拖拽功能。这样不会出现图片拖进页面的时候，把图片打开。  
            disableGlobalDnd: true
        });  

      // 当有文件添加进来的时候
       uploader3.on( "fileQueued", function( file ) {
           console.log("fileQueued:");
           var fileName = file.name;
           var sub = fileName.substring(0,fileName.indexOf("."));
           //alert(sub);
          // var result= $.inArray(sub, arry);
           //alert(result);
           if(sub == 'bank'){//result != -1
	           $list3.append( "<div id='"+  file.id + "' class='item'>" +
	               "<h4 class='info'>" + file.name + "</h4>" +
	               "<p class='state'>等待上传...</p>" +
	           "</div>" );
           }else{
        	   $( "#"+file.id ).find("p.state").text("上传出错");
        	   uploader3.cancelFile(file);
               uploader3.removeFile(file,true);
               uploader3.reset();
               alert("请以bank为文件名");
           }
       }); 

       //当所有文件上传结束时触发
       uploader3.on("uploadFinished",function(){
           console.log("uploadFinished:");
       })

        //当某个文件上传到服务端响应后，会派送此事件来询问服务端响应是否有效。
        uploader3.on("uploadAccept",function(object,ret){
            //服务器响应了
            //ret._raw  类似于 data
           // alert("上传成功");
           var data =JSON.parse(ret._raw);
            if(data.resultCode != "1" && data.resultCode != "3"){
                if(data.resultCode == "9"){
                    uploader3.reset();
                    alert("error");
                    return false;
                }
            }else{
                //E05017
                uploader3.reset();
                alert("error");
                return false;
            }
           })

       //当文件上传成功时触发。
         uploader3.on( "uploadSuccess", function( file ) {
        	 
           $( "#"+file.id ).find("p.state").text("已上传");
       });

       uploader3.on( "uploadError", function( file ) {
           $( "#"+file.id ).find("p.state").text("上传出错");
           uploader3.cancelFile(file);
           uploader3.removeFile(file,true);
           uploader3.reset();
       });
    uploader4 = WebUploader.create({ 
           auto:false, //是否自动上传
            pick: {
                id: '#businessLicense',
                name:"file",  //这个地方 name 没什么用，虽然打开调试器，input的名字确实改过来了。但是提交到后台取不到文件。如果想自定义file的name属性，还是要和fileVal 配合使用。
                label: '点击选择图片',
                multiple:false            //默认为true，true表示可以多选文件，HTML5的属性
            },
            swf: '/view/lib/webuploader/0.1.5/Uploader.swf',  //在这里必需要引入swf文件，webuploader初始化要用
            //fileVal:'multiFile',  //自定义file的name属性，我用的版本是0.1.5 ,打开客户端调试器发现生成的input 的name 没改过来。
                                             //名字还是默认的file,但不是没用哦。虽然客户端名字没改变，但是提交到到后台，是要用multiFile 这个对象来取文件的，用file 是取不到文件的
                                             // 建议作者有时间把这个地方改改啊，搞死人了。。
            server: "/flowsys/account/upload_img_file.do",
            duplicate:false,//是否可重复选择同一文件
            resize: false,
            formData: {
                "status":"file",
                "contentsDto.contentsId":"0000004730",
                "uploadNum":"0000004730",
                "existFlg":'false'
            },  
            compress: null,//图片不压缩
            chunked: true,  //分片处理
            chunkSize: 5 * 1024 * 1024, //每片5M
            chunkRetry:true,//如果失败，则不重试
            threads:1,//上传并发数。允许同时最大上传进程数。
            // runtimeOrder: 'flash',  
            // 禁掉全局的拖拽功能。这样不会出现图片拖进页面的时候，把图片打开。  
            disableGlobalDnd: true
        });  

      // 当有文件添加进来的时候
       uploader4.on( "fileQueued", function( file ) {
           console.log("fileQueued:");
           
           var fileName = file.name;
           var sub = fileName.substring(0,fileName.indexOf("."));
           //alert(sub);
           //var result= $.inArray(sub, arry);
           //alert(result);
           if('license' == sub){
	           $list4.append( "<div id='"+  file.id + "' class='item'>" +
	               "<h4 class='info'>" + file.name + "</h4>" +
	               "<p class='state'>等待上传...</p>" +
	           "</div>" );
           }else{
        	   $( "#"+file.id ).find("p.state").text("上传出错");
        	   uploader4.cancelFile(file);
               uploader4.removeFile(file,true);
               uploader4.reset();
               alert("请以license为结尾命名");
           }
       }); 

       //当所有文件上传结束时触发
       uploader4.on("uploadFinished",function(){
           console.log("uploadFinished:");
       })

        //当某个文件上传到服务端响应后，会派送此事件来询问服务端响应是否有效。
        uploader4.on("uploadAccept",function(object,ret){
            //服务器响应了
            //ret._raw  类似于 data
           // alert("上传成功");
           var data =JSON.parse(ret._raw);
          // alert(data.resultCode);
            if(data.resultCode != "1" && data.resultCode != "3"){
                if(data.resultCode == "9"){
                    uploader4.reset();
                    alert("error");
                    return false;
                }
            }else{
                //E05017
                uploader4.reset();
                alert("error");
                return false;
            }
           })

       //当文件上传成功时触发。
         uploader4.on( "uploadSuccess", function( file ) {
           $( "#"+file.id ).find("p.state").text("已上传");
       });

       uploader4.on( "uploadError", function( file ) {
           $( "#"+file.id ).find("p.state").text("上传出错");
           uploader4.cancelFile(file);
           uploader4.removeFile(file,true);
           uploader4.reset();
       });

       $("#btn-star1").on("click", function() {
           uploader1.upload();
       })
       $("#btn-star2").on("click", function() {
           uploader2.upload();
       })
       $("#btn-star3").on("click", function() {
           uploader3.upload();
       })
       $("#btn-star4").on("click", function() {
           uploader4.upload();
       })

  /*  $btn.on('click', function () {
        if (state === 'uploading') {
            uploader.stop();
        } else {
        	alert("1");
            uploader.upload();
        }
    }); */

});

(function( $ ){
    // 当domReady的时候开始初始化
    $(function() {
        var $wrap = $('.uploader-list-container'),

            // 图片容器
            $queue = $( '<ul class="filelist"></ul>' )
                .appendTo( $wrap.find( '.queueList' ) ),

            // 状态栏，包括进度和控制按钮
            $statusBar = $wrap.find( '.statusBar' ),

            // 文件总体选择信息。
            $info = $statusBar.find( '.info' ),

            // 上传按钮
            $upload = $wrap.find( '.uploadBtn' ),

            // 没选择文件之前的内容。
            $placeHolder = $wrap.find( '.placeholder' ),

            $progress = $statusBar.find( '.progress' ).hide(),

            // 添加的文件数量
            fileCount = 0,

            // 添加的文件总大小
            fileSize = 0,

            // 优化retina, 在retina下这个值是2
            ratio = window.devicePixelRatio || 1,

            // 缩略图大小
            thumbnailWidth = 110 * ratio,
            thumbnailHeight = 110 * ratio,

            // 可能有pedding, ready, uploading, confirm, done.
            state = 'pedding',

            // 所有文件的进度信息，key为file id
            percentages = {},
            // 判断浏览器是否支持图片的base64
            isSupportBase64 = ( function() {
                var data = new Image();
                var support = true;
                data.onload = data.onerror = function() {
                    if( this.width != 1 || this.height != 1 ) {
                        support = false;
                    }
                }
                data.src = "data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///ywAAAAAAQABAAACAUwAOw==";
                return support;
            } )(),

            // 检测是否已经安装flash，检测flash的版本
            flashVersion = ( function() {
                var version;

                try {
                    version = navigator.plugins[ 'Shockwave Flash' ];
                    version = version.description;
                } catch ( ex ) {
                    try {
                        version = new ActiveXObject('ShockwaveFlash.ShockwaveFlash')
                                .GetVariable('$version');
                    } catch ( ex2 ) {
                        version = '0.0';
                    }
                }
                version = version.match( /\d+/g );
                return parseFloat( version[ 0 ] + '.' + version[ 1 ], 10 );
            } )(),

            supportTransition = (function(){
                var s = document.createElement('p').style,
                    r = 'transition' in s ||
                            'WebkitTransition' in s ||
                            'MozTransition' in s ||
                            'msTransition' in s ||
                            'OTransition' in s;
                s = null;
                return r;
            })(),

            // WebUploader实例
            uploader;

        if ( !WebUploader.Uploader.support('flash') && WebUploader.browser.ie ) {

            // flash 安装了但是版本过低。
            if (flashVersion) {
                (function(container) {
                    window['expressinstallcallback'] = function( state ) {
                        switch(state) {
                            case 'Download.Cancelled':
                                alert('您取消了更新！')
                                break;

                            case 'Download.Failed':
                                alert('安装失败')
                                break;

                            default:
                                alert('安装已成功，请刷新！');
                                break;
                        }
                        delete window['expressinstallcallback'];
                    };

                    var swf = 'expressInstall.swf';
                    // insert flash object
                    var html = '<object type="application/' +
                            'x-shockwave-flash" data="' +  swf + '" ';

                    if (WebUploader.browser.ie) {
                        html += 'classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" ';
                    }

                    html += 'width="100%" height="100%" style="outline:0">'  +
                        '<param name="movie" value="' + swf + '" />' +
                        '<param name="wmode" value="transparent" />' +
                        '<param name="allowscriptaccess" value="always" />' +
                    '</object>';

                    container.html(html);

                })($wrap);

            // 压根就没有安转。
            } else {
                $wrap.html('<a href="http://www.adobe.com/go/getflashplayer" target="_blank" border="0"><img alt="get flash player" src="http://www.adobe.com/macromedia/style_guide/images/160x41_Get_Flash_Player.jpg" /></a>');
            }

            return;
        } else if (!WebUploader.Uploader.support()) {
            alert( 'Web Uploader 不支持您的浏览器！');
            return;
        }

        // 实例化
        uploader = WebUploader.create({
            pick: {
                id: '#filePicker-2',
                label: '点击选择图片'
            },
            formData: {
                uid: 123
            },
            dnd: '#dndArea',
            paste: '#uploader',
            swf: '/view/lib/webuploader/0.1.5/Uploader.swf',
            chunked: false,
            chunkSize: 512 * 1024,
            server: '/flowsys/account/open_company_account.do',
            // runtimeOrder: 'flash',

            // accept: {
            //     title: 'Images',
            //     extensions: 'gif,jpg,jpeg,bmp,png',
            //     mimeTypes: 'image/*'
            // },

            // 禁掉全局的拖拽功能。这样不会出现图片拖进页面的时候，把图片打开。
            disableGlobalDnd: true,
            fileNumLimit: 300,
            fileSizeLimit: 200 * 1024 * 1024,    // 200 M
            fileSingleSizeLimit: 50 * 1024 * 1024    // 50 M
        });

        // 拖拽时不接受 js, txt 文件。
        uploader.on( 'dndAccept', function( items ) {
            var denied = false,
                len = items.length,
                i = 0,
                // 修改js类型
                unAllowed = 'text/plain;application/javascript ';

            for ( ; i < len; i++ ) {
                // 如果在列表里面
                if ( ~unAllowed.indexOf( items[ i ].type ) ) {
                    denied = true;
                    break;
                }
            }

            return !denied;
        });

        uploader.on('dialogOpen', function() {
            console.log('here');
        });

        // uploader.on('filesQueued', function() {
        //     uploader.sort(function( a, b ) {
        //         if ( a.name < b.name )
        //           return -1;
        //         if ( a.name > b.name )
        //           return 1;
        //         return 0;
        //     });
        // });

        // 添加“添加文件”的按钮，
        uploader.addButton({
            id: '#filePicker2',
            label: '继续添加'
        });

        uploader.on('ready', function() {
            window.uploader = uploader;
        });

        // 当有文件添加进来时执行，负责view的创建
        function addFile( file ) {
            var $li = $( '<li id="' + file.id + '">' +
                    '<p class="title">' + file.name + '</p>' +
                    '<p class="imgWrap"></p>'+
                    '<p class="progress"><span></span></p>' +
                    '</li>' ),

                $btns = $('<div class="file-panel">' +
                    '<span class="cancel">删除</span>' +
                    '<span class="rotateRight">向右旋转</span>' +
                    '<span class="rotateLeft">向左旋转</span></div>').appendTo( $li ),
                $prgress = $li.find('p.progress span'),
                $wrap = $li.find( 'p.imgWrap' ),
                $info = $('<p class="error"></p>'),

                showError = function( code ) {
                    switch( code ) {
                        case 'exceed_size':
                            text = '文件大小超出';
                            break;

                        case 'interrupt':
                            text = '上传暂停';
                            break;

                        default:
                            text = '上传失败，请重试';
                            break;
                    }

                    $info.text( text ).appendTo( $li );
                };

            if ( file.getStatus() === 'invalid' ) {
                showError( file.statusText );
            } else {
                // @todo lazyload
                $wrap.text( '预览中' );
                uploader.makeThumb( file, function( error, src ) {
                    var img;

                    if ( error ) {
                        $wrap.text( '不能预览' );
                        return;
                    }

                    if( isSupportBase64 ) {
                        img = $('<img src="'+src+'">');
                        $wrap.empty().append( img );
                    } else {
                        $.ajax('/flowsys/account/open_company_account.do', {
                            method: 'POST',
                            data: src,
                            dataType:'json'
                        }).done(function( response ) {
                            if (response.result) {
                                img = $('<img src="'+response.result+'">');
                                $wrap.empty().append( img );
                            } else {
                                $wrap.text("预览出错");
                            }
                        });
                    }
                }, thumbnailWidth, thumbnailHeight );

                percentages[ file.id ] = [ file.size, 0 ];
                file.rotation = 0;
            }

            file.on('statuschange', function( cur, prev ) {
                if ( prev === 'progress' ) {
                    $prgress.hide().width(0);
                } else if ( prev === 'queued' ) {
                    $li.off( 'mouseenter mouseleave' );
                    $btns.remove();
                }

                // 成功
                if ( cur === 'error' || cur === 'invalid' ) {
                    console.log( file.statusText );
                    showError( file.statusText );
                    percentages[ file.id ][ 1 ] = 1;
                } else if ( cur === 'interrupt' ) {
                    showError( 'interrupt' );
                } else if ( cur === 'queued' ) {
                    percentages[ file.id ][ 1 ] = 0;
                } else if ( cur === 'progress' ) {
                    $info.remove();
                    $prgress.css('display', 'block');
                } else if ( cur === 'complete' ) {
                    $li.append( '<span class="success"></span>' );
                }

                $li.removeClass( 'state-' + prev ).addClass( 'state-' + cur );
            });

            $li.on( 'mouseenter', function() {
                $btns.stop().animate({height: 30});
            });

            $li.on( 'mouseleave', function() {
                $btns.stop().animate({height: 0});
            });

            $btns.on( 'click', 'span', function() {
                var index = $(this).index(),
                    deg;

                switch ( index ) {
                    case 0:
                        uploader.removeFile( file );
                        return;

                    case 1:
                        file.rotation += 90;
                        break;

                    case 2:
                        file.rotation -= 90;
                        break;
                }

                if ( supportTransition ) {
                    deg = 'rotate(' + file.rotation + 'deg)';
                    $wrap.css({
                        '-webkit-transform': deg,
                        '-mos-transform': deg,
                        '-o-transform': deg,
                        'transform': deg
                    });
                } else {
                    $wrap.css( 'filter', 'progid:DXImageTransform.Microsoft.BasicImage(rotation='+ (~~((file.rotation/90)%4 + 4)%4) +')');
                    // use jquery animate to rotation
                    // $({
                    //     rotation: rotation
                    // }).animate({
                    //     rotation: file.rotation
                    // }, {
                    //     easing: 'linear',
                    //     step: function( now ) {
                    //         now = now * Math.PI / 180;

                    //         var cos = Math.cos( now ),
                    //             sin = Math.sin( now );

                    //         $wrap.css( 'filter', "progid:DXImageTransform.Microsoft.Matrix(M11=" + cos + ",M12=" + (-sin) + ",M21=" + sin + ",M22=" + cos + ",SizingMethod='auto expand')");
                    //     }
                    // });
                }


            });

            $li.appendTo( $queue );
        }

        // 负责view的销毁
        function removeFile( file ) {
            var $li = $('#'+file.id);

            delete percentages[ file.id ];
            updateTotalProgress();
            $li.off().find('.file-panel').off().end().remove();
        }

        function updateTotalProgress() {
            var loaded = 0,
                total = 0,
                spans = $progress.children(),
                percent;

            $.each( percentages, function( k, v ) {
                total += v[ 0 ];
                loaded += v[ 0 ] * v[ 1 ];
            } );

            percent = total ? loaded / total : 0;


            spans.eq( 0 ).text( Math.round( percent * 100 ) + '%' );
            spans.eq( 1 ).css( 'width', Math.round( percent * 100 ) + '%' );
            updateStatus();
        }

        function updateStatus() {
            var text = '', stats;

            if ( state === 'ready' ) {
                text = '选中' + fileCount + '张图片，共' +
                        WebUploader.formatSize( fileSize ) + '。';
            } else if ( state === 'confirm' ) {
                stats = uploader.getStats();
                if ( stats.uploadFailNum ) {
                    text = '已成功上传' + stats.successNum+ '张照片至XX相册，'+
                        stats.uploadFailNum + '张照片上传失败，<a class="retry" href="#">重新上传</a>失败图片或<a class="ignore" href="#">忽略</a>'
                }

            } else {
                stats = uploader.getStats();
                text = '共' + fileCount + '张（' +
                        WebUploader.formatSize( fileSize )  +
                        '），已上传' + stats.successNum + '张';

                if ( stats.uploadFailNum ) {
                    text += '，失败' + stats.uploadFailNum + '张';
                }
            }

            $info.html( text );
        }

        function setState( val ) {
            var file, stats;

            if ( val === state ) {
                return;
            }

            $upload.removeClass( 'state-' + state );
            $upload.addClass( 'state-' + val );
            state = val;

            switch ( state ) {
                case 'pedding':
                    $placeHolder.removeClass( 'element-invisible' );
                    $queue.hide();
                    $statusBar.addClass( 'element-invisible' );
                    uploader.refresh();
                    break;

                case 'ready':
                    $placeHolder.addClass( 'element-invisible' );
                    $( '#filePicker2' ).removeClass( 'element-invisible');
                    $queue.show();
                    $statusBar.removeClass('element-invisible');
                    uploader.refresh();
                    break;

                case 'uploading':
                    $( '#filePicker2' ).addClass( 'element-invisible' );
                    $progress.show();
                    $upload.text( '暂停上传' );
                    break;

                case 'paused':
                    $progress.show();
                    $upload.text( '继续上传' );
                    break;

                case 'confirm':
                    $progress.hide();
                    $( '#filePicker2' ).removeClass( 'element-invisible' );
                    $upload.text( '开始上传' );

                    stats = uploader.getStats();
                    if ( stats.successNum && !stats.uploadFailNum ) {
                        setState( 'finish' );
                        return;
                    }
                    break;
                case 'finish':
                    stats = uploader.getStats();
                    if ( stats.successNum ) {
                        alert( '上传成功' );
                    } else {
                        // 没有成功的图片，重设
                        state = 'done';
                        location.reload();
                    }
                    break;
            }

            updateStatus();
        }

        uploader.onUploadProgress = function( file, percentage ) {
            var $li = $('#'+file.id),
                $percent = $li.find('.progress span');

            $percent.css( 'width', percentage * 100 + '%' );
            percentages[ file.id ][ 1 ] = percentage;
            updateTotalProgress();
        };

        uploader.onFileQueued = function( file ) {
            fileCount++;
            fileSize += file.size;

            if ( fileCount === 1 ) {
                $placeHolder.addClass( 'element-invisible' );
                $statusBar.show();
            }

            addFile( file );
            setState( 'ready' );
            updateTotalProgress();
        };

        uploader.onFileDequeued = function( file ) {
            fileCount--;
            fileSize -= file.size;

            if ( !fileCount ) {
                setState( 'pedding' );
            }

            removeFile( file );
            updateTotalProgress();

        };

        uploader.on( 'all', function( type ) {
            var stats;
            switch( type ) {
                case 'uploadFinished':
                    setState( 'confirm' );
                    break;

                case 'startUpload':
                    setState( 'uploading' );
                    break;

                case 'stopUpload':
                    setState( 'paused' );
                    break;

            }
        });

        uploader.onError = function( code ) {
            alert( 'Eroor: ' + code );
        };

        $upload.on('click', function() {
            if ( $(this).hasClass( 'disabled' ) ) {
                return false;
            }

            if ( state === 'ready' ) {
                uploader.upload();
            } else if ( state === 'paused' ) {
                uploader.upload();
            } else if ( state === 'uploading' ) {
                uploader.stop();
            }
        });

        $info.on( 'click', '.retry', function() {
            uploader.retry();
        } );

        $info.on( 'click', '.ignore', function() {
            alert( 'todo' );
        } );

        $upload.addClass( 'state-' + state );
        updateTotalProgress();
    });

})( jQuery );
$(function(){
	var ue = UE.getEditor('editor');
});
</script>
</body>
</html>