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
<title>资讯列表</title>
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
			<c:forEach items="${resultMap.pgTypeEnums }" var="pgType" varStatus="vs1">
				<option value="${pgType.value }" <c:if test="${pgType.value == resultMap.params.operatorType }"> selected</c:if>>${pgType.desc }</option>
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
					<th width="25"><input type="checkbox" name="" value=""></th>
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
						<td><input type="checkbox" value="" name=""></td>
						<%-- <td>${pg.pgId }</td> --%>
						<td>${pg.pgName }</td>
						<td><c:forEach items="${resultMap.serviceTypeEnums }" var="serviceType" varStatus="vs1">
						<c:if test="${pg.serviceType == serviceType.value }"> ${serviceType.desc }</c:if>
						</c:forEach>
						</td>
						<td>${pg.pgSize }</td>
						<!-- <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','article-zhang.html','10001')" title="查看">资讯标题</u></td> -->
						<td><c:forEach items="${resultMap.pgTypeEnums }" var="pgType" varStatus="vs1">
						<c:if test="${pg.operatorType == pgType.value }"> ${pgType.desc }</c:if>
						</c:forEach>
						</td>
						<td>${pg.operatorName }</td>
						<%-- <td>${pg.scopeCityName }</td> --%>
						<%-- <td>${pg.serviceType }</td> --%>
						<td>${pg.pgPrice }</td>
						<td class="td-status"><c:forEach items="${resultMap.pgInEnums }" var="pgIn" varStatus="vs1">
						<c:if test="${pg.pgInService == pgIn.value }"> ${pgIn.desc }</c:if>
						</c:forEach></td>
					<!-- 	<td class="td-status"><span class="label label-success radius">已发布</span></td> -->
						<td class="f-14 td-manage">
						<!-- <a style="text-decoration:none" onClick="article_stop(this,'10001')" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a> 
						<a style="text-decoration:none" class="ml-5" onClick="article_edit('资讯编辑','article-add.html','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> --> 
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
/* $(document).ready(function() {
	$('.table-sort').dataTable({
        "bServerSide": true,//这个用来指明是通过服务端来取数据
        "sAjaxSource": "testAoData",//这个是请求的地址
        'bPaginate':true, 
        "sPaginationType": "full_numbers", //分页风格，full_number会把所有页码显示出来（大概是，自己尝试）
        "bDestroy" : true,
        "bLengthChange": true, //改变每页显示数据数量
        "bAutoWidth": true,//自动宽度  
        
        "fnServerData": retrieveData // 获取数据的处理函数
	});
}); */

//3个参数的名字可以随便命名,但必须是3个参数,少一个都不行
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
}  
/**onchange提交表单*/
function submitForm(){
	$('form').submit();
}
/*资讯-添加*/
function article_add(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*包体-添加*/
function pg_add(title,url){
	//alert("sd");
	layer.open({
        type: 2,
        title: false,
        area: ['430px', '500px'],
        maxmin: false,
        closeBtn: 1,
        content: url+'?pageTitle=' + title,
         end: function () {
            location.reload();
        }
    });
}
/*资讯-编辑*/
function article_edit(title,url,id,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	//layer.full(index);
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

/*资讯-审核*/
function article_shenhe(obj,id){
	layer.confirm('审核文章？', {
		btn: ['通过','不通过','取消'], 
		shade: false,
		closeBtn: 0
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布', {icon:6,time:1000});
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
		$(obj).remove();
    	layer.msg('未通过', {icon:5,time:1000});
	});	
}
/*资讯-下架*/
function article_stop(obj,id){
	layer.confirm('确认要下架吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
		$(obj).remove();
		layer.msg('已下架!',{icon: 5,time:1000});
	});
}

/*资讯-发布*/
function article_start(obj,id){
	layer.confirm('确认要发布吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布!',{icon: 6,time:1000});
	});
}
/*资讯-申请上线*/
function article_shenqing(obj,id){
	$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
	$(obj).parents("tr").find(".td-manage").html("");
	layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
}

</script> 
</body>
</html>