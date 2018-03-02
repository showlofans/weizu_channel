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
<body onl>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 代理商管理 <span class="c-gray en">&gt;</span>消费列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
<div class="page-container">
	<form class="form form-horizontal" action="/flowsys/account/consume_list.do" method="post" id="formD" name="dataListForm">
		<div class="text-c">
		<div class="row cl formControls">
		<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
			显示模式:
			<span class="select-box inline">
			<select name="showModel" class="select" onchange="getConsume()" >
				<c:forEach items="${resultMap.agencyLevelEnums }" var="agencyLevelEnum" varStatus="vs1">
					<option value="${agencyLevelEnum.value }" <c:if test="${resultMap.searchParams.showModel == agencyLevelEnum.value }"> selected</c:if>>${agencyLevelEnum.desc }</option>
				</c:forEach>
			</select>
			</span>
			<%-- <c:if test="${loginContext.rootAgencyId == 0 }">
			</c:if> --%>
			消费类型:
			<span class="select-box inline">
			<select name="chargeFor" class="select" onchange="getConsume()" >
				<c:forEach items="${resultMap.pgServiceTypeEnums }" var="pgServiceTypeEnum" varStatus="vs1">
					<option value="${pgServiceTypeEnum.value }" <c:if test="${resultMap.searchParams.chargeFor == pgServiceTypeEnum.value }"> selected</c:if>>${pgServiceTypeEnum.desc }</option>
				</c:forEach>
			</select>
			</span>
			代理商名称:<input type="text" value="${resultMap.searchParams.userName }" name="userName" id="" placeholder=" 代理商名称" style="width:150px" class="input-text">
			订单号:<input type="text" value="${resultMap.searchParams.purchaseId }" name="purchaseId" id="" placeholder=" 订单号" style="width:150px" class="input-text">
			手机号:<input type="text" value="${resultMap.searchParams.chargeTel }" name="chargeTel" id="" placeholder=" 手机号" style="width:100px" class="input-text">
			<!-- 交易类型: -->
			<span class="select-box inline">
			<select name="accountType" class="select" onchange="getConsume()" >
				<option value="">交易类型</option>
				<c:forEach items="${resultMap.accountTypeEnums }" var="accountTypeE" varStatus="vs1">
					<option value="${accountTypeE.value }" <c:if test="${resultMap.searchParams.accountType == accountTypeE.value }"> selected</c:if>>${accountTypeE.desc }</option>
				</c:forEach>
			</select>
			</span>
			<span class="select-box inline">
			<select name="billType" class="select" onchange="getConsume()" >
				<option value="">账户类型</option>
				<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
					<option value="${billTypeEnum.value }" <c:if test="${resultMap.searchParams.billType == billTypeEnum.value }"> selected</c:if>>${billTypeEnum.desc }</option>
				</c:forEach>
			</select>
			</span>
		</div>
		<div class="row cl" style="margin-top: 30dp">
			提交时间：
			<input type="text" style="width:150px" class="input-text" name="startTimeStr"  value="${resultMap.searchParams.startTimeStr }"  onfocus="var endTimeStr=$dp.$('endTimeStr');WdatePicker({onpicked:function(){endTimeStr.focus();getConsume()},autoPickDate:true,startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss' })"/>
	            <em class="inputto">至</em>
	        <input style="width:150px" type="text"  class="input-text" name="endTimeStr" id="endTimeStr"   value="${resultMap.searchParams.endTimeStr }"  onfocus="WdatePicker({onpicked:function(){getConsume()},autoPickDate:true,startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
			&nbsp;&nbsp;<button class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 查询</button>
			&nbsp;&nbsp;<button type="button"class="btn btn-primary" onclick="javascript:location.replace(location.href);" value="重置">重置</button>
			&nbsp;&nbsp;<button class="btn btn-success" onclick="grouWaypSearch()" type="button"><i class="Hui-iconfont">&#xe665;</i> 统计查询</button>
			<a href="/flowsys/account/export_consume_list.do?chargeTel=${resultMap.searchParams.chargeTel }&userName=${resultMap.searchParams.userName }&purchaseId=${resultMap.searchParams.purchaseId }&showModel=${resultMap.searchParams.showModel }
					&accountType=${resultMap.searchParams.accountType }
					&billType=${resultMap.searchParams.billType }
					&startTimeStr=${resultMap.searchParams.startTimeStr }
					&endTimeStr=${resultMap.searchParams.endTimeStr }
					&chargeFor=${resultMap.searchParams.chargeFor }">【导出列表】
			</a>
		</div>
			<input type="hidden" name="pageNo" value="${resultMap.pagination.pageNo }"> 
			<input type="hidden" id="groupWay" name="groupWay" value=""> 
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
					<%-- <c:choose>
						<c:when test="${loginContext.rootAgencyId == 0 }">
							<th width="75">通道类型</th>
						</c:when>
						<c:otherwise>
							<th width="75">扣款类型</th>
						</c:otherwise>
					</c:choose> --%>
					<th width="60">交易时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="consumeRec" varStatus="vs">
					<tr class="text-c">
						<%-- <td>${pg.pgId }</td> --%>
						<td>
						<c:choose>
							<c:when test="${consumeRec.accountType == 1 }">
								<span class="c-red"  data-toggle="tooltip"  data-placement="top" title="扣款订单">${consumeRec.purchaseId }</span>
							</c:when>
							<c:otherwise>
								<span class="c-blue" data-toggle="tooltip"  data-placement="top" title="补款订单">${consumeRec.purchaseId }</span>
							</c:otherwise>
						</c:choose>
						</td><!--订单号 -->
						<%-- <td <c:if test='${consumeRec.accountType == 1 }'>class='c-red'</c:if> >
							${consumeRec.purchaseId }
						</td> --%>
						<td>
							<c:choose>
								<c:when test="${consumeRec.billType == 0 }">
									<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
										<c:if test="${billTypeEnum.value == 0 }">
											<span class="c-red" data-toggle="tooltip"  data-placement="right" title="${billTypeEnum.desc }"  >
											${consumeRec.userName }</span>
										</c:if>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
									<c:if test="${billTypeEnum.value == 1 }">
										<span class="c-green" data-toggle="tooltip"  data-placement="right" title="${billTypeEnum.desc }"><!--   -->
										${consumeRec.userName }</span>
									</c:if>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</td><!-- 代理名称 -->
						<td>${consumeRec.chargeTel }</td><!--  -->
						<td>${consumeRec.chargeBefore }</td>
						<!-- <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','article-zhang.html','10001')" title="查看">资讯标题</u></td> -->
						<td>${consumeRec.rechargeAmount }</td>
						 <td>${consumeRec.chargeAfter }</td>
						<!-- 备注 -->
						<td><c:forEach items="${resultMap.accountTypeEnums }" var="accountType" varStatus="vs1">
						<c:if test="${consumeRec.accountType == accountType.value }"> ${accountType.desc }</c:if>
						</c:forEach></td>
						<%-- <td><c:forEach items="${resultMap.billTypeEnums }" var="billTypeE" varStatus="vs1">
						<c:if test="${consumeRec.billType == billTypeE.value }"> ${billTypeE.desc }</c:if>
						</c:forEach></td> --%>
						<td>${consumeRec.remittanceTimeStr }</td>
						<%-- <fmt:formatDate value="${chargeRec.remittanceTime }" pattern="yyyy-MM-dd HH:mm:ss"/> ${chargeRec.remittanceTime }</td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="recordId" />
		<c:if test="${resultMap.searchParams.showModel == 1 && not empty resultMap.groupAgencyList }">
				<div class="pd-10 tags">
				<ul id="Huifold1" class="Huifold">
				  <li class="item">
				    <h4>代理商订单消费保守统计<b>-</b></h4>
				   	<ul id="Huifold11" class="Huifold">
				   		<c:forEach items="${resultMap.groupAgencyList }" var="groupAgency" varStatus="vs">
				   			 <li class="item">
				   			<h4>
				   			${groupAgency.agencyName }(
				   				<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
									<c:if test="${billTypeEnum.value == groupAgency.billType }">
										<span class="c-red" >
										${billTypeEnum.desc }</span>
									</c:if>
								</c:forEach>)
							<span r>实际扣款笔数：${groupAgency.numb } </span>
							<span r>实际扣款金额：${groupAgency.totalAmount } </span>
							<span r>有效订单率：${groupAgency.realOrderPer }% </span>
				   			<b>+</b></h4>
				   			<div class="info"> 
						   		<%-- 实际扣款笔数：${groupAgency.numb }<br>
						   		实际扣款金额：${groupAgency.totalAmount }<br> --%>
						   		总扣费次数：${groupAgency.decreaseNumb }<br>
						   		总扣款金额：${groupAgency.decreaseAmount }<br>
						   		总补款笔数：${groupAgency.replenishmentNumb }<br>
						   		总补款金额：${groupAgency.replenishmentAmount }<br>
						   		<%-- <c:forEach items="${resultMap.accountTypeEnums }" var="accountType" varStatus="vs1">
								<c:if test="${groupAgency.accountType == accountType.value }"> ${accountType.desc }金额 :${groupAgency.totalAmount }</c:if>
								</c:forEach> --%>
						   		<%-- <c:if test="${groupAgency.accountType == 1 }">
									扣款金额 :${groupAgency.totalAmount }
						   		</c:if>
						   		<c:if test="${groupAgency.accountType == 2 }">
									补款金额 :${groupAgency.totalAmount }
						   		</c:if> --%>
								<%-- 交易金额 :${groupAgency.totalAmount } --%>
						    </div>
						    </li>
						 	<%-- <c:choose>
								<c:when test="${groupAgency.billType == 0 }">
									<span class="c-red" data-toggle="tooltip"  data-placement="top" title="${groupAgency.numb }笔,${groupAgency.totalAmount }元" ><!--  -->
									${groupAgency.agencyName }</span>
								</c:when>
								<c:otherwise>
									<span class="c-green" data-toggle="tooltip"  data-placement="top" title="${groupAgency.numb }笔${groupAgency.totalAmount }元" ><!--  data-toggle="tooltip"  data-placement="right" title="${billTypeEnum.desc }" -->
										${groupAgency.agencyName }</span>
								</c:otherwise>
							</c:choose> --%>
						 </c:forEach>
				   	</ul>
				    <!-- <div class="info"> 
				   		 内容<br>很多内容 
				    
				    </div> -->
				  </li>
				</ul>
				</div>
				<%-- <div class="codeView">
					<ul>
						 <c:forEach items="${resultMap.groupAgencyList }" var="groupAgency" varStatus="vs">
							<li> 
								<c:choose>
									<c:when test="${groupAgency.billType == 0 }">
										<span class="c-red" data-toggle="tooltip"  data-placement="right" title="${groupAgency.totalAmount }元<br>${groupAgency.numb }笔" ><!--  -->
										${groupAgency.agencyName }</span>
									</c:when>
									<c:otherwise>
										<span class="c-green" data-toggle="tooltip"  data-placement="right" title="${groupAgency.totalAmount }元<br>${groupAgency.numb }笔" ><!--  data-toggle="tooltip"  data-placement="right" title="${billTypeEnum.desc }" -->
											${groupAgency.agencyName }</span>
									</c:otherwise>
								</c:choose>
							</li>
						</c:forEach>
					</ul>
				</div> --%>
			</c:if>
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
<!-- <script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/view/lib/laypage/1.2/laypage.js"></script> -->
<!-- <script type="text/javascript" charset="utf8" src="/view/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> -->
<script type="text/javascript">
function getConsume(){
	$('form').submit();
}
/**统计查询*/
function grouWaypSearch(){
	$('#groupWay').val('yes');
	$('form').submit();
}
$(function(){
	$.Huifold("#Huifold1 .item h4","#Huifold1 .item info","fast",1,"click"); /*5个参数顺序不可打乱，分别是：相应区,隐藏显示的内容,速度,类型,事件click*/
	//$.Huifold("#Huifold2 .item h4","#Huifold2 .item .info","fast",3,"mouseover"); /*5个参数顺序不可打乱，分别是：相应区,隐藏显示的内容,速度,类型,事件click*/
});
/*资讯-删除*/
/* function article_del(obj,id){
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
} */

</script> 
</body>
</html>