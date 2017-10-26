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
<title>流量包列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 流量包管理 <span class="c-gray en">&gt;</span> 流量包列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<form action="/flowsys/operatorPg/operatorPg_list.do" method="post" id="formD" name="dataListForm">
	<div class="text-c">
		<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
	  运营商类型：
	 <span class="select-box inline">
		<select name="operatorType" class="select"  onchange="submitForm()">
			<option value="">运营商类型</option>
			<c:forEach items="${resultMap.operatoerTypeEnums }" var="operatorTypeEnum" varStatus="vs1">
				<option value="${operatorTypeEnum.value }" <c:if test="${operatorTypeEnum.value == resultMap.params.operatorType }"> selected</c:if>>${operatorTypeEnum.desc }</option>
			</c:forEach>
		</select>
	</span> 
	  流量类型：
	 <span class="select-box inline">
		<select name="serviceType" class="select" onchange="submitForm()">
			<option value="">流量类型</option>
			<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceTypeEnum" varStatus="vs1">
				<option value="${serviceTypeEnum.value }" <c:if test="${serviceTypeEnum.value == resultMap.params.serviceType }"> selected</c:if>>${serviceTypeEnum.desc }</option>
			</c:forEach>
		</select>
	</span> 
		包状态
		<span class="select-box inline">
			<select name="pgInService" class="select"  onchange="submitForm()">
			<option value="">请选择</option>
			<c:forEach items="${resultMap.pgInEnums }" var="pgIn" varStatus="vs1">
				<option value="${pgIn.value }" <c:if test="${pgIn.value == resultMap.params.pgInService }"> selected</c:if>>${pgIn.desc }</option>
			</c:forEach>
		</select>
		</span>
		原价：<input type="text" value="${resultMap.params.pgPrice }" name="pgPrice" id="" placeholder=" 原价" style="width:80px" class="input-text">元
		<!-- 支持城市：<input type="text" name="scopeCityName" id="" placeholder=" 支持城市" style="width:250px" class="input-text"> -->
		<!-- 日期范围：
		<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}' })" id="logmin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d' })" id="logmax" class="input-text Wdate" style="width:120px;"> -->
		流量大小:<input type="text" value="${resultMap.params.pgSize }" name="pgSize" id="" placeholder="大小" style="width:50px" class="input-text">M
		<button type="button" class="btn btn-success" onclick="javascript:location.replace(location.href);" value="重置">重置</button>
		<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜流量</button>
		<a style="text-decoration:none" class="btn btn-success" onClick="pg_add('包体添加','/flowsys/operatorPg/pg_add_page.do')" href="javascript:;" title="添加"><i class="Hui-iconfont">&#xe600;</i>添加</a>
		<!-- <button class="btn btn-success" onClick="pg_add('包体添加','pg_add_page.do')" value="添加流量包体">添加</button> -->
		<input type="hidden" name="pageNo" value="${pagination.pageNo }"> 
		</form>
	</div>
	<!-- <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" data-title="添加资讯" data-href="article-add.html" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加资讯</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div> -->
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<!-- <th width="25"><input type="checkbox" name="" value=""></th> -->
					<!-- <th width="80">流量包Id</th> -->
					<th width="200">流量包名称</th>
					<th width="80">流量类型</th>
					<th width="80">流量大小</th>
					<th width="80">运营商类型</th>
					<th width="80">运营商名称</th>
					<!-- <th width="120">支持城市</th> -->
					<th width="75">原价</th>
					<th width="60">使用状态</th>
					<th width="120">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="pg" varStatus="vs">
					<tr class="text-c">
						<!-- <td><input type="checkbox" value="" name=""></td> -->
						<%-- <td>${pg.pgId }</td> --%>
						<td>${pg.pgName }</td>
						<td><c:forEach items="${resultMap.serviceTypeEnums }" var="serviceType" varStatus="vs1">
						<c:if test="${pg.serviceType == serviceType.value }"> ${serviceType.desc }</c:if>
						</c:forEach>
						</td>
						<td>${pg.pgSize }M</td>
						<td><c:forEach items="${resultMap.operatoerTypeEnums }" var="operatorType" varStatus="vs1">
						<c:if test="${pg.operatorType == operatorType.value }"> ${operatorType.desc }</c:if>
						</c:forEach>
						</td>
						<td>${pg.operatorName }</td>
						<td>${pg.pgPrice }</td>
						<td class="td-status"><c:forEach items="${resultMap.pgInEnums }" var="pgIn" varStatus="vs1">
						<c:if test="${pg.pgInService == pgIn.value }"> ${pgIn.desc }</c:if>
						</c:forEach></td>
						<td class="f-14 td-manage">
						<a style="text-decoration:none" class="ml-5" onClick="pg_del(this,${pg.id})" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="pagaId" />  
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/view/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="/view/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/view/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
/**onchange提交表单*/
function submitForm(){
	$('form').submit();
}
/*包体-添加*/
function pg_add(title,url){
	//alert("sd");
	layer.open({
        type: 2,
        title: false,
        area: ['430px', '600px'],
        maxmin: false,
        closeBtn: 1,
        content: url+'?pageTitle=' + title,
         end: function () {
            location.reload();
        }
    });
}
/*包体-删除*/
function pg_del(obj,id){
	layer.confirm("确认要删除该包体吗？",function(index){
		//alert(index);
		var tag = "";
		$.ajax({
			type: "post",
			url: "/flowsys/operatorPg/pg_delete.do?pgId="+ id,
			dataType: "json",
			async: false,
			success: function(data){	
				tag = data;
			},
			error:function(data) {
				tag = data;
				console.log(data.msg);
			},
		});	
		if(tag == "success"){
			layer.msg('删除成功', {icon:5,time:1000});
		}
		layer.close(index);
		location.reload();
	});
}
/* //3个参数的名字可以随便命名,但必须是3个参数,少一个都不行
function retrieveData( sSource111,aoData, fnCallback111) {
	alert(aoData[0].name);  
    // alert(JSON.stringify(aoData));  
    $.ajax( {    
        "type": "get",     
        "contentType": "application/json",    
        "url": sSource111,     
        "dataType": "json",    
        "data": { aoData: JSON.stringify(aoData) }, // 以json格式传递  
        "success": function(resp) {    
        	fnCallback111(resp.aaData); 
        },
        "error":function(msg){
        	alert(msg);
        }
    }); 
}   */
</script> 
</body>
</html>