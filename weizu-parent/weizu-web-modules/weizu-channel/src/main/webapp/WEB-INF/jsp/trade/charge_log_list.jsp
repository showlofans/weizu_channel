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
<title>充值列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 订单管理 <span class="c-gray en">&gt;</span> 冲单日志 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
<div class="page-container">
	<form class="form form-horizontal" action="/flowsys/chargeLog/charge_log_list.do" method="post" id="formD" name="dataListForm">
		<div class="text-c">
		<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
			<div class="row cl formControls">订单号:<input type="text"  value="${resultMap.searchParams.orderId }" name="orderId" id="" placeholder=" 订单号" style="width:200px" class="input-text">
			提单参数:<input type="text"  value="${resultMap.searchParams.logInContent }" name="logInContent" id="logInContent" placeholder=" 对下：代理商名称 /商务订单号；对上：产品编码/平台名称" style="width:350px" class="input-text">
			提单结果:<input type="text"  value="${resultMap.searchParams.logOutContent }" name="logOutContent" id="" placeholder="对下：tipCode;对上：jsonStr" style="width:250px" class="input-text">
			</div>
			<div class="row cl formControls" style="margin-top: 30dp">
			<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>手机号:<input type="text"  value="${resultMap.searchParams.chargeTel }" name="chargeTel" id="" placeholder=" 手机号" style="width:150px" class="input-text">
			<span class="select-box inline">
				<select name="chargeDirection" class="select">
				<option value="">提单方向</option>
				<c:forEach items="${resultMap.agencyForwardEnums }" var="agencyForwardEnum" varStatus="vs2">
					<option value="${agencyForwardEnum.value }" <c:if test="${agencyForwardEnum.value == resultMap.searchParams.chargeDirection }"> selected</c:if>>${agencyForwardEnum.desc }</option>
				</c:forEach>
			</select>
			</span> 
			<span class="select-box inline">
				<select name="isException" class="select">
				<option value="">订单号生成情况</option>
				<c:forEach items="${resultMap.isExceptionEnums }" var="isExceptionEnum" varStatus="vs2">
					<option value="${isExceptionEnum.value }" <c:if test="${isExceptionEnum.value == resultMap.isException }"> selected</c:if>>${isExceptionEnum.desc }</option>
				</c:forEach>
			</select>
			</span> 
			交易时间：
			<input type="text" style="width:150px" class="input-text" name="startTimeStr"  value="${resultMap.searchParams.startTimeStr }"  onfocus="var endTimeStr=$dp.$('endTimeStr');WdatePicker({onpicked:function(){endTimeStr.focus();formSub();},autoPickDate:true,startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss' })"/>
	            <em class="inputto">至</em>
	        <input style="width:150px" type="text"  class="input-text" name="endTimeStr" id="endTimeStr"   value="${resultMap.searchParams.endTimeStr }"  onfocus="WdatePicker({onpicked:function(){formSub();},autoPickDate:true,startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
			<button type="button"class="btn btn-success" onclick="javascript:location.replace(location.href);" value="重置">重置</button>
			<button class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 查询</button>
			<input type="hidden" name="pageNoLong" value="${resultMap.pagination.pageNoLong }">
			<input type="hidden" id="totalRecordLong" value="${resultMap.pagination.totalRecordLong }">
			</div> 
		</div>
	</form>
	</div>
	 <!-- <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> </span> </div> -->
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<!-- <th width="80">流量包Id</th> -->
					<!-- <th width="80">记录Id</th> -->
					<th width="100">平台订单号</th>
					<th width="60">手机号</th>
					<th width="120">提单参数</th>
					<th width="80">提单结果</th>
					<th width="50">充值状态码</th>
					<th width="80">提单Ip描述</th>
					<th width="60">提单时间</th>
					<th width="40">提单方向</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="chargeLog" varStatus="vs">
					<tr class="text-c">
						<%-- <td>${pg.pgId }</td> --%>
						<%-- <td>${chargeLog.id }</td> --%>
						<td>
							<c:choose>
								<c:when test="${empty chargeLog.orderId }">
									未生成订单号
								</c:when>
								<c:otherwise>
									${chargeLog.orderId }
								</c:otherwise>
							</c:choose>
						</td><!-- 代理名称 -->
						<td>${chargeLog.chargeTel }</td>
						<td>
						<c:choose>
							<c:when test="${fn:contains(chargeLog.logInContent, resultMap.searchParams.logInContent)}">
								<%--fn:substring(zip, 6, -1) fn:indexOf(name, "-")
								 ${fn:substring(chargeLog.logInContent, 0, fn:indexOf(chargeLog.logInContent, resultMap.searchParam.logInContent))} --%>
								${fn:substringBefore(chargeLog.logInContent, resultMap.searchParams.logInContent)}
								<mark>${resultMap.searchParams.logInContent }</mark>
								${fn:substringAfter(chargeLog.logInContent, resultMap.searchParams.logInContent)}
							</c:when>
							<c:otherwise>
								${chargeLog.logInContent }
							</c:otherwise>
						</c:choose>
						</td>
						 <td>
							 <c:choose>
								<c:when test="${fn:contains(chargeLog.logOutContent, resultMap.searchParams.logOutContent)}">
									<%--fn:substring(zip, 6, -1) fn:indexOf(name, "-")
									 ${fn:substring(chargeLog.logInContent, 0, fn:indexOf(chargeLog.logInContent, resultMap.searchParam.logInContent))} --%>
									${fn:substringBefore(chargeLog.logOutContent, resultMap.searchParams.logOutContent)}
									<mark>${resultMap.searchParams.logOutContent }</mark>
									${fn:substringAfter(chargeLog.logOutContent, resultMap.searchParams.logOutContent)}
								</c:when>
								<c:otherwise>
									${chargeLog.logOutContent }
								</c:otherwise>
							</c:choose>
						 </td>
						 <td>
						 	<c:set var="condition" value="0" scope="page"></c:set><!-- 跳出循环遍历不再判断的标志 -->
						 	<c:forEach items="${resultMap.orderResultEnums }" var="orderResultEnum" varStatus="vst">
						 	<c:forEach items="${resultMap.chargeStatusEnums }" var="chargeStatusEnum" varStatus="vs">
							 	<c:choose>
							 		<c:when test="${condition != 1 && orderResultEnum.code == chargeLog.chargeStatus   }">
							 			<span data-toggle="tooltip" data-placement="top" title="${orderResultEnum.msg }">${chargeLog.chargeStatus }</span>
							 			<c:set var="condition" value="1"></c:set>
							 		</c:when>
							 		<c:when test="${condition != 1 && chargeStatusEnum.value == chargeLog.chargeStatus}">
							 			<span data-toggle="tooltip" data-placement="top" title="${chargeStatusEnum.desc }">${chargeLog.chargeStatus }</span>
							 			<c:set var="condition" value="1"></c:set>
							 		</c:when>
							 		<c:when test="${condition != 1 &&  -1 == chargeLog.chargeStatus}"><!-- 0 -->
							 			<span data-toggle="tooltip" data-placement="top" title="其它错误">${chargeLog.chargeStatus }</span>
							 			<c:set var="condition" value="1"></c:set>
							 		</c:when>
							 	</c:choose>
						 	</c:forEach>
						 	</c:forEach>
						 </td>
						<!-- <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','article-zhang.html','10001')" title="查看">资讯标题</u></td> -->
						<td>${chargeLog.chargeDesc }</td>
						<!-- 备注 -->
						<td>${chargeLog.chargeTimeStr }</td>
						<td><c:forEach items="${resultMap.agencyForwardEnums }" var="agencyForwardEnum" varStatus="vs1">
						<c:if test="${chargeLog.chargeDirection == agencyForwardEnum.value }"> ${agencyForwardEnum.desc }</c:if>
						</c:forEach></td>
						<%-- <fmt:formatDate value="${chargeLog.remittanceTime }" pattern="yyyy-MM-dd HH:mm:ss"/> ${chargeLog.remittanceTime }</td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="recordId" />
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
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/view/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<!-- jQuery -->
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>
<script type="text/javascript">
function formSub(){
	$('form').submit();
}
$(document).ready(function() {
	$('.select').change(function(){
		//$('form').submit();
		$('form').submit();
	})
	/* $('.purchaseFor').change(function(){//特殊需求
		$("input[name='pageNoLong']").val('');
		$('#arriveStartTimeStr').val(null);
		$('form').submit();
	}) */
}); 
/*资讯-删除*/
function datadel(){
	var totalRecordLong = $('#totalRecordLong').val();
	var msg = '确认要删除这'+totalRecordLong+'条传单日志数据吗？';
	layer.confirm(msg,function(index){
		$.ajax({
			type:"post",
             url:"/flowsys/chargeLog/del_charge_log.do",
             data: $('form').serialize(),//表单数据
             async : false,
			success: function(data){
				if(data == 'success'){
					//layer.msg('已删除!',{icon:1,time:1000});
					location.reload();
				}else{
					layer.msg('删除失败!',{icon:2,time:1000});
				}
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