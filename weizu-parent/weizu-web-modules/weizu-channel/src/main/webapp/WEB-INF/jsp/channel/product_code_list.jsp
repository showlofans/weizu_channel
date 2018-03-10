<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/MyTaglib.tld" prefix="mytag"%>
<!DOCTYPE >
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/view/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/H-ui.admin.css" />
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css" href="/view/mine/paging.css" />

<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>流量编码列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 平台通道管理 <span class="c-gray en">&gt;</span> 流量编码管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
<div class="page-container">
	<div class="text-c">
	<form class="form form-horizontal" action="/flowsys/productCode/product_code_list.do" method="post" id="formD" name="dataListForm">
		<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
		<div class="row cl formControls">
		平台名称：<input type="text" value="${resultMap.searchParam.epName }" name="epName" id="epName" placeholder=" 平台名称" style="width:150px" class="input-text">&nbsp;&nbsp;
		<span class="select-box inline">
				<select name="operatorType" onchange="formSub()" class="select">
				<option value="">运营商</option>
				<c:forEach items="${resultMap.operatorTypeEnums }" var="otypeEnum" varStatus="vs2">
					<option value="${otypeEnum.value }" <c:if test="${otypeEnum.value == resultMap.searchParam.operatorType }"> selected</c:if>>${otypeEnum.desc }</option>
				</c:forEach>
			</select>
			</span> 
			&nbsp;&nbsp;
		<%-- 包体编码名称：<input type="text" value="${resultMap.searchParam.productName }" name="productName" id="" placeholder="包体编码名称" style="width:250px" class="input-text">&nbsp;&nbsp; --%>
		<%-- 包体编码名称：<input type="text" value="${resultMap.searchParam.productName }" name="productName" id="" placeholder="包体编码名称" style="width:250px" class="input-text">&nbsp;&nbsp; --%>
		<span class="select-box inline">
			<select name="scopeCityCode" onchange="formSub()" class="select">
			<option value="">编码地区</option>
			<c:forEach items="${resultMap.scopeCityEnums }" var="scopeCityEnum">
				<option value="${scopeCityEnum.value }" <c:if test="${scopeCityEnum.value == resultMap.searchParam.scopeCityCode }"> selected</c:if>>${scopeCityEnum.desc }</option>
			</c:forEach>
		</select>
		</span> 
		&nbsp;&nbsp;
		<span class="select-box inline">
			<select name="serviceType" onchange="formSub()" class="select">
			<option value="">业务类型</option>
			<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceType" varStatus="vs1">
				<option value="${serviceType.value }" <c:if test="${serviceType.value == resultMap.searchParam.serviceType }"> selected</c:if>>${serviceType.desc }</option>
			</c:forEach>
		</select>
		</span> 
		<%-- &nbsp;&nbsp;
		产品编码：<input type="text" value="${resultMap.searchParam.productCode }" name="productCode" id="" placeholder=" 产品编码" style="width:150px" class="input-text">&nbsp;&nbsp; --%>
		<%-- 对接平台：
		<span class="select-box inline">
			<select id="epId" name="epId" class="select" onchange="formSub()">
			<c:forEach items="${resultMap.epList }" var="ep" varStatus="vs2">
				<option value="${ep.epId }" <c:if test="${ep.epId == resultMap.searchParam.epId }"> selected</c:if>>${ep.epName }</option>
			</c:forEach>
		</select>
		</span>  --%>
		</div>
		
		<div class="row cl" style="margin-top: 30dp">
			<span class="select-box inline">
				<select name="pgValidity" class="select"  onchange="formSub()">
					<option value="">包体有效期</option>
					<c:forEach items="${resultMap.pgValidityEnums }" var="pgValidityEnum" varStatus="vs1">
						<option value="${pgValidityEnum.value }" <c:if test="${pgValidityEnum.value == resultMap.searchParam.pgValidity }"> selected</c:if>>${pgValidityEnum.desc }</option>
					</c:forEach>
				</select>
			</span> 
			&nbsp;&nbsp;
			 <!--  流量流通方式： -->
			 <span class="select-box inline">
				<select name="circulateWay" class="select"  onchange="formSub()">
					<option value="">流量流通方式</option>
					<c:forEach items="${resultMap.channelTypeEnums }" var="channelTypeEnum" varStatus="vs1">
						<option value="${channelTypeEnum.value }" <c:if test="${channelTypeEnum.value == resultMap.searchParam.circulateWay }"> selected</c:if>>${channelTypeEnum.desc }</option>
					</c:forEach>
				</select>
			</span> 
			&nbsp;&nbsp;
			<!-- 包状态 -->
			<span class="select-box inline">
				<select name="pgType" class="select"  onchange="formSub()">
				<option value="">流量类型</option>
				<c:forEach items="${resultMap.pgTypeEnums }" var="pgTypeEnum" varStatus="vs1">
					<option value="${pgTypeEnum.value }" <c:if test="${pgTypeEnum.value == resultMap.searchParam.pgType }"> selected</c:if>>${pgTypeEnum.desc }</option>
				</c:forEach>
			</select>
			</span>
			&nbsp;&nbsp;
			
			<button type="button" class="btn btn-success" onclick="javascript:location.replace(location.href);" value="重置">重置</button>
			<a style="text-decoration:none" class="btn btn-success" onClick="pCode_add('产品编码添加','/flowsys/productCode/productCode_add_page.do')" href="javascript:;" title="添加"><i class="Hui-iconfont">&#xe600;</i>添加</a>
			<input value="查询" class="btn btn-success" type="submit"><!-- <i class="Hui-iconfont">&#xe665;</i> -->
			<input type="hidden" name="pageNo" value="${resultMap.pagination.pageNo }"> 
		</div>
		</form>
	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<!-- <th width="80">流量包Id</th> -->
					<th width="30">ID</th>
					<th width="80">平台名称</th>
					<th width="80">产品编码</th>
					<th width="80">包大小(M)</th>
					<!-- <th width="120">支持城市</th> -->
					
					<th width="100">地区</th>
					<th width="60">价格(元)</th>
					<th width="60">业务类型</th>
					<th width="60">运营商类型</th>
					<!-- <th width="100">包体编码名称</th> -->
					
					<th width="30">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="product" varStatus="vs">
					<tr class="text-c">
						<td>${product.id }</td> 
						<td>${product.epName }</td>
						<td class="c-blue">${product.productCode }</td>
						<td>${product.pgSize }</td>
						<!-- <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','article-zhang.html','10001')" title="查看">资讯标题</u></td> -->
						<td>
						<c:forEach items="${resultMap.scopeCityEnums }" var="scopeCityEnum">
							<c:if test="${scopeCityEnum.value== product.scopeCityCode}">
								<span data-toggle="tooltip" data-placement="right" title="${product.scopeCityCode }">${scopeCityEnum.desc }</span>
							</c:if>
						</c:forEach>
						</td>
						<td>${product.pgPrice }</td> 
						<td>
							<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceType" varStatus="vs1">
							<c:if test="${product.serviceType == serviceType.value }"> ${serviceType.desc }</c:if>
							</c:forEach>
						</td>
						
						
						<td>
							<c:forEach items="${resultMap.operatorTypeEnums }" var="operatorType" varStatus="vs1">
							<c:if test="${product.operatorType == operatorType.value }"> ${operatorType.desc }</c:if>
							</c:forEach>
						</td>
						<%-- <td>${product.productName }</td> --%>
						 
						<%-- 
						<td>
							<c:forEach items="${resultMap.productStateEnums }" var="cState" varStatus="vs1">
							<c:if test="${product.productState == cState.value }"> ${cState.desc }</c:if>
							</c:forEach>
						</td> --%>
						<td class="f-14 td-manage">
						<a style="text-decoration:none" class="ml-5" onClick="produce_del('/flowsys/productCode/productcode_delete.do',${product.id })" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="channellistId" />  
	</div>
	<footer class="footer mt-20">
		<div class="container">
			<p><!-- 感谢jQuery、layer、laypage、Validform、UEditor、My97DatePicker、iconfont、Datatables、WebUploaded、icheck、highcharts、bootstrap-Switch<br> -->
				Copyright &copy;2017-2018 南昌微族科技有限公司 All Rights Reserved.<br>
				<!-- 本后台系统由<a href="http://www.h-ui.net/" target="_blank" title="H-ui前端框架">H-ui前端框架</a>提供前端技术支持 -->
				</p>
		</div>
	</footer>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<!-- jQuery -->
<script type="text/javascript" src="/view/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
/*编码-删除*/
function produce_del(url,codeId){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: url,
			data: {codeId:codeId},
			//dataType: 'json',
			success: function(data){
				if(data=="success")
				{
					layer.msg('删除编码成功!',{icon:1,time:1000});
					location.reload();
				}else{
					layer.msg('删除编码失败!',{icon:1,time:1000});
				}
			},
			error:function(data) {
				console.log(data.msg);
			}
		});		
	});
}

/*提交表单**/
/* function submitForm(){
	$("input[name='pageNo']").val('');
	$('form').submit();
} */

/*产品编码-添加*/
function pCode_add(title,url){
	//alert("sd");
	//var epId = $('#epId').val();//选中的平台
	var epName = $('#epName').val();//选中的平台
	//alert(epId);
	layer.open({
        type: 2,
        title: false,
        area: ['500px', '600px'],
        maxmin: false,
        closeBtn: 1,
        content: url+'?pageTitle=' + title + '&epName='+ epName,
         end: function () {
            location.reload();
        }
    });
}
</script> 
</body>
</html>