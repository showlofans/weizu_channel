<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/MyTaglib.tld" prefix="mytag"%>
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
<title>消费列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 代理商管理 <span class="c-gray en">&gt;</span>消费列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<form action="/flowsys/account/consume_list.do" method="post" id="formD" name="dataListForm">
		<div class="text-c">
		<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
			提交时间：
			<input type="text" style="width:150px" class="input-text" name="startTimeStr"  value="${resultMap.searchParams.startTimeStr }"  onfocus="var endTimeStr=$dp.$('endTimeStr');WdatePicker({onpicked:function(){endTimeStr.focus();},autoPickDate:true,startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss' })"/>
	            <em class="inputto">至</em>
	        <input style="width:150px" type="text"  class="input-text" name="endTimeStr" id="endTimeStr"   value="${resultMap.searchParams.endTimeStr }"  onfocus="WdatePicker({autoPickDate:true,startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
			代理商名称:<input type="text" value="${resultMap.searchParams.userName }" name="userName" id="" placeholder=" 代理商名称" style="width:150px" class="input-text">
			手机号:<input type="text" value="${resultMap.searchParams.chargeTel }" name="chargeTel" id="" placeholder=" 手机号" style="width:100px" class="input-text">
			交易类型:
			<span class="select-box inline">
			<select name="accountType" class="select" onchange="getConsume()" >
				<c:forEach items="${resultMap.accountTypeEnum }" var="accountTypeE" varStatus="vs1">
					<option value="${accountTypeE.value }" <c:if test="${resultMap.searchParams.accountType == accountTypeE.value }"> selected</c:if>>${accountTypeE.desc }</option>
				</c:forEach>
			</select>
			</span>
			<button type="reset"class="btn btn-success" value="重置">重置</button>
			<button class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 查询</button>
			<input type="hidden" name="pageNo" value="${resultMap.pagination.pageNo }"> 
		</div>
	</form>
	</div>
	<!-- <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" data-title="添加资讯" data-href="article-add.html" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加资讯</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div> -->
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<!-- <th width="80">流量包Id</th> -->
					
					<th width="150">订单号</th>
					<th width="80">代理名称</th>
					<th width="80">手机号</th>
					<th width="80">交易前余额</th>
					<th width="80">交易费用</th>
					<th width="80">余额</th>
					<th width="75">交易类型</th>
					<th width="75">通道类型</th>
					<th width="60">交易时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="consumeRec" varStatus="vs">
					<tr class="text-c">
						<%-- <td>${pg.pgId }</td> --%>
						<td>${consumeRec.orderId }</td><!--订单号 -->
						<td>${consumeRec.userName }</td><!-- 代理名称 -->
						<td>${consumeRec.chargeTel }</td><!--  -->
						<td>${consumeRec.chargeBefore }</td>
						<!-- <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','article-zhang.html','10001')" title="查看">资讯标题</u></td> -->
						<td>${consumeRec.rechargeAmount }</td>
						 <td>${consumeRec.chargeAfter }</td>
						<!-- 备注 -->
						<td><c:forEach items="${resultMap.accountTypeEnum }" var="accountType" varStatus="vs1">
						<c:if test="${consumeRec.accountType == accountType.value }"> ${accountType.desc }</c:if>
						</c:forEach></td>
						<td><c:forEach items="${resultMap.billTypeEnum }" var="billTypeE" varStatus="vs1">
						<c:if test="${consumeRec.billType == billTypeE.value }"> ${billTypeE.desc }</c:if>
						</c:forEach></td>
						<td>${consumeRec.remittanceTimeStr }</td>
						<%-- <fmt:formatDate value="${chargeRec.remittanceTime }" pattern="yyyy-MM-dd HH:mm:ss"/> ${chargeRec.remittanceTime }</td> --%>
						<%-- <td class="td-status"><c:forEach items="${resultMap.pgInEnums }" var="pgIn" varStatus="vs1">
						
						<c:if test="${pg.pgInService == pgIn.value }"> ${pgIn.desc }</c:if>
						</c:forEach></td> --%>
					<!-- 	<td class="td-status"><span class="label label-success radius">已发布</span></td> -->
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="recordId" />  
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
function getConsume(){
	$('form').submit();
}
/*资讯-删除*/
function article_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

</script> 
</body>
</html>