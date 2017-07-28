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
<title>通道列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 平台通道管理 <span class="c-gray en">&gt;</span> 通道列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
	<form action="/flowsys/channel/channel_list.do" method="post" id="formD" name="dataListForm">
		<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
		<%-- 通道状态
		<span class="select-box inline">
			<select name="channelState" class="select" onchange="getChannelList()">
			<option value="">请选择</option>
			<c:forEach items="${resultMap.channelStateEnums }" var="cstate" varStatus="vs1">
				<option value="${cstate.value }" <c:if test="${cstate.value == resultMap.searchParam.channelState }"> selected</c:if>>${cstate.desc }</option>
			</c:forEach>
		</select>
		</span> --%>
		业务类型：
		<span class="select-box inline">
			<select name="serviceType"  id="serviceType" class="select" onchange="getChannelList()">
			<option value="">请选择</option>
			<c:forEach items="${resultMap.serviceTypeEnums }" var="sTypeEnum" varStatus="vs1">
				<option value="${sTypeEnum.value }" <c:if test="${sTypeEnum.value == resultMap.searchParam.serviceType }"> selected</c:if>>${sTypeEnum.desc }</option>
			</c:forEach>
		</select>
		</span>
		
		费率省份：<input type="text" value="${resultMap.searchParam.scopeCityName }" name="scopeCityName" id="" placeholder=" 费率省份" style="width:250px" class="input-text">
		
		<!-- <input type="hidden" value="" name="channelId" id="channelId"> -->
		
		<button type="button"class="btn btn-success" onclick="javascript:location.replace(location.href);" value="重置">重置</button>
		<input value="查询" class="btn btn-success" type="submit"><!-- <i class="Hui-iconfont">&#xe665;</i> -->
		
		<input type="hidden" name="pageNo" value="${resultMap.pagination.pageNo }"> 
		</form>
	</div>
	<!-- <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" data-title="添加资讯" data-href="article-add.html" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加资讯</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div> -->
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th >地区</th>
					<th >业务类型</th>
					<th>运营商类型</th>
					<th>折扣</th>
					<th>费率类型</th>
					<th>设置折扣</th>
					<th>是否带票</th>
					<!-- <th>修改时间</th> -->
					<!-- <th>通道规格</th> -->
					
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="ratePo" varStatus="vs">
					<tr class="text-c">
						<td><input type="checkbox" value="" name=""></td>
						<td>
							<c:forEach items="${resultMap.scopeCityEnums }" var="scopeCityEnum" varStatus="vs1">
								<c:if test="${ratePo.scopeCityCode == scopeCityEnum.value }">
									<span>${scopeCityEnum.desc }</span>
								</c:if>
							</c:forEach>
						</td> 
						<td>
							<c:forEach items="${resultMap.operatorTypes }" var="operatorTypeEnum" varStatus="vs1">
								<c:if test="${ratePo.operatorType == operatorTypeEnum.value }">
									<span>${operatorTypeEnum.desc }</span>
								</c:if>
							</c:forEach>
						</td> 
						<td>
							<c:forEach items="${resultMap.serviceTypeEnums }" var="serTypeEnum" varStatus="vs1">
								<c:if test="${ratePo.serviceType == serTypeEnum.value }">
									<span>${serTypeEnum.desc }</span>
								</c:if>
							</c:forEach>
						</td> 
						<%-- <td><c:forEach items="${resultMap.serviceTypeEnums }" var="serTypeEnum" varStatus="vs1">
								<c:if test="${ratePo.serviceType == serTypeEnum.value }">
									<span>${serTypeEnum.desc }</span>
								</c:if>
							</c:forEach>
						</td>  --%>
						<td>${ratePo.activeDiscount }</td>
						<td style="display:none;">${ratePo.channelDiscountId }</td><!-- 通道折扣id -->
						<td><c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
								<c:if test="${ratePo.billType == billTypeEnum.value }">
									<span>${billTypeEnum.desc }</span>
								</c:if>
							</c:forEach>
						</td> 
						<td><input type="text" value="" name="activeDiscount" id="" placeholder=" 费率折扣" style="width:250px" class="input-text"></td>
						<td>
							<select name="billType"  id="billType" class="select" onchange="getChannelList()">
								<option value="">请选择</option>
								<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
									<option value="${billTypeEnum.value }" <c:if test="${billTypeEnum.value == resultMap.searchParam.billType }"> selected</c:if>>${billTypeEnum.desc }</option>
								</c:forEach>
							</select>
						</td>
						<td><button onclick="removeIframe()" class="btn btn-primary radius">添加</button></td>
						
						
						<!-- <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','article-zhang.html','10001')" title="查看">资讯标题</u></td> -->
						<%-- <td>
							<c:forEach items="${resultMap.operatorTypeEnums }" var="operatorType" varStatus="vs1">
							<c:if test="${channel.operatorType == operatorType.value }"> ${operatorType.desc }</c:if>
							</c:forEach>
						</td>
						<td>
							<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceTypeEnum" varStatus="vs1">
								<c:if test="${channel.serviceType == serviceTypeEnum.value }"> ${serviceTypeEnum.desc }</c:if>
							</c:forEach>
						</td>
						<td>"${channel.scopeCityName }" : "${channel.channelDiscount}"</td>  --%>
						
						
						<%-- <td class="td-status">
							<c:forEach items="${resultMap.channelStateEnums }" var="cState" varStatus="vs1">
								<c:if test="${channel.channelState == cState.value && channel.channelState==0  }"> <span class="label label-success radius">${cState.desc }</span></c:if>
								<c:if test="${channel.channelState == cState.value && channel.channelState==1  }"> <span class="label radius">${cState.desc }</span></c:if>
							</c:forEach>
						</td>
						<td class="td-status">
							<c:forEach items="${resultMap.channelUseStateEnums }" var="cUseState" varStatus="vs1">
								<c:if test="${channel.channelUseState == cUseState.value  && channel.channelUseState==0}"> <span class="label label-success radius">${cUseState.desc }</span></c:if>
								<c:if test="${channel.channelUseState == cUseState.value  && channel.channelUseState==1}"> <span class="label radius">${cUseState.desc }</span></c:if>
							</c:forEach>
						</td>
						<td>${channel.billType }</td>
						<td>${channel.pgSize }</td>
					<!-- 	<td class="td-status"><span class="label label-success radius">已发布</span></td> -->
						<td class="f-14 td-manage">
						<c:if test="${channel.channelState == 1 }"><!-- 暂停 -->
							<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="changeCState(this,'1')" href="javascript:;" title="运行">
								<input type="hidden" value="${channel.id }" >
								<i class="Hui-iconfont">&#xe6e6;</i>
							</a> 
						</c:if>
						<c:if test="${channel.channelState == 0 }"><!-- 运行 -->
							<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="changeCState(this,'0')" href="javascript:;" title="暂停">
								<input type="hidden" value="${channel.id }" >
								<i class="Hui-iconfont">&#xe6e5;</i>
							</a> 
						</c:if>
						<c:if test="${channel.channelUseState == 1 }"><!-- 已暂停 -->
							<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="changeUseState(this,'1')" href="javascript:;" title="启用">
								<input type="hidden" value="${channel.id }" >
								<i class="Hui-iconfont">&#xe615;</i>
							</a> 
						</c:if>
						<c:if test="${channel.channelUseState == 0 }"><!-- 已启用 -->
							<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="changeUseState(this,'0')" href="javascript:;" title="停用">
								<input type="hidden" value="${channel.id }" >
								<i class="Hui-iconfont">&#xe631;</i>
							</a> 
						</c:if>
						<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" class="ml-5" onClick="channel_stop('/flowsys/channel/channel_delete.do',${channel.id})" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a> 
						<!-- <a style="text-decoration:none" data-toggle="tooltip" data-placement="top" class="ml-5"  href="javascript:;" title="折扣编辑"><i class="Hui-iconfont">&#xe6df;</i></a> --> 
						<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" class="ml-5" data-href="javascript:;" onclick="channel_edit('/flowsys/rate/bind_rate_list.do',this)" data-title="费率列表"><i class="Hui-iconfont">&#xe6df;</i></a>
						<!-- <a style="text-decoration:none" class="ml-5" onClick="article_del(this,'10001')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a> /flowsys/rate/bind_rate_list.do?channelId= ${channel.id }-->
						</td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="channellistId" />  
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
