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
	<form class="form form-horizontal" action="/flowsys/channel/channel_list.do" method="post" id="formD" name="dataListForm">
		<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
		<div class="row cl formControls">
			通道名称：<input type="text" value="${resultMap.searchParam.channelName }" name="channelName" id="" placeholder=" 通道名称" style="width:100px" class="input-text">
			平台名称：<input type="text" value="${resultMap.searchParam.epName }" name="epName" id="" placeholder=" 平台名称" style="width:100px" class="input-text">
			
			
			
			通道省份：<input type="text" value="${resultMap.searchParam.scopeCityName }" name="scopeCityName" id="" placeholder=" 通道省份" style="width:100px" class="input-text">
			
			通道类型
			<span class="select-box inline">
				<select name="channelType" class="select" onchange="getChannelList()">
				<option value="">请选择</option>
				<c:forEach items="${resultMap.channelTypeEnums }" var="channelTypeEnum" varStatus="vs1">
					<option value="${channelTypeEnum.value }" <c:if test="${channelTypeEnum.value == resultMap.searchParam.channelType }"> selected</c:if>>${channelTypeEnum.desc }</option>
				</c:forEach>
			</select>
			</span>
		</div>
		
		<div class="row cl" style="margin-top: 30dp">
			通道状态
			<span class="select-box inline">
				<select name="channelState" class="select" onchange="getChannelList()">
				<option value="">请选择</option>
				<c:forEach items="${resultMap.channelStateEnums }" var="cstate" varStatus="vs1">
					<option value="${cstate.value }" <c:if test="${cstate.value == resultMap.searchParam.channelState }"> selected</c:if>>${cstate.desc }</option>
				</c:forEach>
			</select>
			</span>
			业务类型：
			<span class="select-box inline">
				<select name="serviceType"  id="serviceType" class="select" onchange="getChannelList()">
				<option value="">请选择</option>
				<c:forEach items="${resultMap.serviceTypeEnums }" var="sTypeEnum" varStatus="vs1">
					<option value="${sTypeEnum.value }" <c:if test="${sTypeEnum.value == resultMap.searchParam.serviceType }"> selected</c:if>>${sTypeEnum.desc }</option>
				</c:forEach>
			</select>
			</span>
			流量类型：
			<span class="select-box inline">
				<select name="pgType"  id="pgType" class="select" onchange="getChannelList()">
				<option value="">请选择</option>
				<c:forEach items="${resultMap.pgTypeEnums }" var="pgTypeEnum" varStatus="vs2">
					<option value="${pgTypeEnum.value }" <c:if test="${pgTypeEnum.value == resultMap.searchParam.pgType }"> selected</c:if>>${pgTypeEnum.desc }</option>
				</c:forEach>
			</select>
			</span>
			有效期：
			<span class="select-box inline">
				<select name="pgValidity"  id="pgValidity" class="select" onchange="getChannelList()">
				<option value="">请选择</option>
				<c:forEach items="${resultMap.pgValidityEnums }" var="pgValidityEnum" varStatus="vs2">
					<option value="${pgValidityEnum.value }" <c:if test="${pgValidityEnum.value == resultMap.searchParam.pgValidity }"> selected</c:if>>${pgValidityEnum.desc }</option>
				</c:forEach>
			</select>
			</span>
			
			<!-- <input type="hidden" value="" name="channelId" id="channelId"> -->
			
			<button type="button"class="btn btn-success" onclick="javascript:location.replace(location.href);" value="重置">重置</button>
			<input value="查询" class="btn btn-success" type="submit"><!-- <i class="Hui-iconfont">&#xe665;</i> -->
		</div>
		<input type="hidden" name="pageNo" value="${resultMap.pagination.pageNo }"> 
		</form>
	</div>
	<!-- <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" data-title="添加资讯" data-href="article-add.html" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加资讯</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div> -->
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<!-- <th width="80">流量包Id</th> -->
					 <th >ID</th>
					<th >平台名称</th>
					<th >通道名称</th>
					<!-- <th >业务类型</th> -->
					<!-- <th >交易单数</th>
					<th >交易总额</th> -->
					<!-- <th width="120">支持城市</th> -->
					<!-- <th width="60">运营商类型</th> -->
					<!-- <th width="60">包体类型</th> -->
					<th>移动</th>
					<th>联通</th>
					<th>电信</th>
					<!-- <th>通道余额</th>
					<th>通道利润</th> -->
					<th>通道状态</th>
					<th>通道使用状态</th>
					<!-- <th>通道类型</th> -->
					<!-- <th>修改时间</th> -->
					<th>通道规格</th>
					<!-- <th>通道更新时间</th> -->
					
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="channel" varStatus="vs">
					<tr class="text-c">
						<td>${channel.id }</td>
						<td>${channel.epName }</td>
						<td><span data-toggle="tooltip" data-placement="top" title="${channel.pgSize }">${channel.channelName }</span></td>
						<%-- <td><c:forEach items="${resultMap.serviceTypeEnums }" var="serTypeEnum" varStatus="vs1">
								<c:if test="${channel.serviceType == serTypeEnum.value }">
									<span>${serTypeEnum.desc }</span>
									<span class="serType" style="display:none">${serTypeEnum.value }</span>
								</c:if>
							</c:forEach>
						</td>  --%>
						<td style="display:none;">${channel.serviceType }</td>
						<td style="display:none;">${channel.operatorType }</td>
						<%-- <td>${channel.channelTotalUse }</td>
						<td>${channel.channelTotalAmount }</td> --%>
						<td>
							<c:choose>
								<c:when test="${fn:length(channel.discountPo.discount0) > 2 }">
									<c:choose>
										<c:when test="${channel.billType == 0 }">
											<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
												<c:if test="${billTypeEnum.value == 0 }">
													<span data-toggle="tooltip"  class="c-red" data-placement="right" title="${billTypeEnum.desc }">
													${channel.discountPo.discount0 }</span>
												</c:if>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
											<c:if test="${billTypeEnum.value == 1 }">
												<span data-toggle="tooltip" class="c-green" data-placement="right" title="${billTypeEnum.desc }">
												${channel.discountPo.discount0 }</span>
											</c:if>
											</c:forEach>
										</c:otherwise>
									</c:choose>
										<%-- <c:if test="${channel.billType == billTypeEnum.value }">
											<span data-toggle="tooltip" data-placement="right" title="${billTypeEnum.desc }">
											${channel.discountPo.discount0 }</span>
										</c:if> --%>
									<%-- <c:forEach items="${resultMap.serviceTypeEnums }" var="serTypeEnum" varStatus="vs1">
										<c:if test="${channel.serviceType == serTypeEnum.value }">
											<span data-toggle="tooltip" data-placement="right" title="${serTypeEnum.desc }">
												${channel.discountPo.discount0 }
											</span>
										</c:if>
									</c:forEach> --%>
								</c:when>
								<c:otherwise>
									${channel.discountPo.discount0 }
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${fn:length(channel.discountPo.discount1) > 2 }">
									<%-- <c:forEach items="${resultMap.serviceTypeEnums }" var="serTypeEnum" varStatus="vs1">
										<c:if test="${channel.serviceType == serTypeEnum.value }">
											<span data-toggle="tooltip" data-placement="right" title="${serTypeEnum.desc }">
												${channel.discountPo.discount1 }
											</span>
										</c:if>
									</c:forEach> --%>
									<%-- <c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
										<c:if test="${channel.billType == billTypeEnum.value }">
											<span data-toggle="tooltip" data-placement="right" title="${billTypeEnum.desc }">
											${channel.discountPo.discount1 }</span>
										</c:if>
									</c:forEach> --%>
									<c:choose>
										<c:when test="${channel.billType == 0 }">
											<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
												<c:if test="${billTypeEnum.value == 0 }">
													<span data-toggle="tooltip"  class="c-red" data-placement="right" title="${billTypeEnum.desc }">
													${channel.discountPo.discount1 }</span>
												</c:if>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
											<c:if test="${billTypeEnum.value == 1 }">
												<span data-toggle="tooltip" class="c-green" data-placement="right" title="${billTypeEnum.desc }">
												${channel.discountPo.discount1 }</span>
											</c:if>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									${channel.discountPo.discount1 }
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${fn:length(channel.discountPo.discount2) > 2 }">
									<%-- <c:forEach items="${resultMap.serviceTypeEnums }" var="serTypeEnum" varStatus="vs1">
										<c:if test="${channel.serviceType == serTypeEnum.value }">
											<span data-toggle="tooltip" data-placement="right" title="${serTypeEnum.desc }">
												${channel.discountPo.discount2 }
											</span>
										</c:if>
									</c:forEach> --%>
									<%-- <c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
										<c:if test="${channel.billType == billTypeEnum.value }">
											<span data-toggle="tooltip" data-placement="right" title="${billTypeEnum.desc }">
											${channel.discountPo.discount2 }</span>
										</c:if>
									</c:forEach> --%>
									<c:choose>
										<c:when test="${channel.billType == 0 }">
											<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
												<c:if test="${billTypeEnum.value == 0 }">
													<span data-toggle="tooltip"  class="c-red" data-placement="right" title="${billTypeEnum.desc }">
													${channel.discountPo.discount2 }</span>
												</c:if>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
											<c:if test="${billTypeEnum.value == 1 }">
												<span data-toggle="tooltip" class="c-green" data-placement="right" title="${billTypeEnum.desc }">
												${channel.discountPo.discount2 }</span>
											</c:if>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									${channel.discountPo.discount2 }
								</c:otherwise>
							</c:choose>
						</td>
						<td class="td-status">
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
						<%-- <td><c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
								<c:if test="${channel.billType == billTypeEnum.value }">
									<span>${billTypeEnum.desc }</span>
								</c:if>
							</c:forEach>
						</td> --%>
						<td>
							<c:forEach items="${resultMap.serviceTypeEnums }" var="serTypeEnum" varStatus="vs1">
								<c:forEach items="${resultMap.pgTypeEnums }" var="pgTypeEnum" varStatus="vs2">
									<c:forEach items="${resultMap.pgValidityEnums }" var="pgValidityEnum" varStatus="vs3">
										<c:forEach items="${resultMap.channelTypeEnums }" var="channelTypeEnum" varStatus="vs4">
											<c:if test="${channel.serviceType == serTypeEnum.value && channel.pgType == pgTypeEnum.value && channel.pgValidity == pgValidityEnum.value && channel.channelType == channelTypeEnum.value }">
												<span data-toggle="tooltip" data-placement="top" title="${serTypeEnum.desc } ${pgTypeEnum.desc } ${pgValidityEnum.desc } ${channelTypeEnum.desc }">
													<c:forEach items="${channel.pgList }"  var="pgData" varStatus="vst">
														${pgData.pgSize }&
													</c:forEach>
													<%-- ${channel.pgSize } --%>
												</span>
											</c:if>
										</c:forEach>
									</c:forEach>
								</c:forEach>
							</c:forEach>
						</td>
						<%-- <td>${channel.lastAccessStr }</td> --%>
					<!-- 	<td class="td-status"><span class="label label-success radius">已发布</span></td> -->
						<td class="f-14 td-manage">
						<c:choose>
						<c:when test="${channel.channelState == 1 }"><!-- 暂停 -->
							<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="changeCState(this,'1')" href="javascript:;" title="运行">
								<input type="hidden" value="${channel.id }" >
								<i class="Hui-iconfont">&#xe6e6;</i>
							</a> 
						</c:when>
						<c:when test="${channel.channelState == 0 }"><!-- 运行 -->
							<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="changeCState(this,'0')" href="javascript:;" title="暂停">
								<input type="hidden" value="${channel.id }" >
								<i class="Hui-iconfont">&#xe6e5;</i>
							</a> 
						</c:when>
						</c:choose>
						<c:choose>
						<c:when test="${channel.channelUseState == 1 }"><!-- 已暂停 -->
							<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="changeUseState(this,'1')" href="javascript:;" title="启用">
								<input type="hidden" value="${channel.id }" >
								<i class="Hui-iconfont">&#xe615;</i>
							</a> 
						</c:when>
						<c:when test="${channel.channelUseState == 0 }"><!-- 已启用 -->
							<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="changeUseState(this,'0')" href="javascript:;" title="停用">
								<input type="hidden" value="${channel.id }" >
								<i class="Hui-iconfont">&#xe631;</i>
							</a> 
						</c:when>
						</c:choose>
						<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" class="ml-5" onClick="channel_stop('/flowsys/channel/channel_delete.do',${channel.id})" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a> 
						<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" class="ml-5" data-href="javascript:;" onclick="getRateList('/flowsys/rate/bind_rate_list.do',this)" data-title="折扣信息"><i class="Hui-iconfont">&#xe725;</i></a>
						<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" class="ml-5" data-href="javascript:;" onclick="editChannel('/flowsys/channel/channel_edit_page.do?channelId=${channel.id}','编辑通道')" data-title="编辑通道"><i class="Hui-iconfont">&#xe6df;</i></a>
						</td>
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
<script type="text/javascript">
/**获得费率列表**/
function getRateList(url,objt){
	var channelId = $(objt).parent().parent().children(":first").html();
	var serviceType = $(objt).parent().parent().children(":eq(3)").html();
	var operatorType = $(objt).parent().parent().children(":eq(4)").html();
	//alert(serviceType);
	//alert(operatorType);
	//alert(channelId);
	$("#channelId").val(channelId);
	 $(objt).attr('data-href',url+'?'+'channelId='+Number(channelId)+'&serviceType='+ serviceType+'&operatorType='+ operatorType); //+$('form').serialize()
		Hui_admin_tab(objt);
}
/**编辑通道页面*/
function editChannel(url,title){
	layer.open({
        type: 2,
        title: title,
        area: ['530px', '510px'],
        maxmin: false,
        closeBtn: 1,
        content: url,
         end: function () {
            location.reload();
        }
    });
	//$(objt).attr('data-href',url); //+$('form').serialize()
	//Hui_admin_tab(objt);
}
/*onchange通道状态*/
function getChannelList(){
	//alert($(vart).val());
	$('form').submit();
}

/*通道状态-修改*/
function changeCState(obj,state){
	var id = $(obj).children().eq(0).val();
	var tag = "";
	
	if(state == "1"){
		layer.confirm('确认要运行该通道吗？',function(index){
			$.ajax({
				type: 'POST',
				url: '/flowsys/channel/channel_state_update.do',
				dataType: 'json',
				data: {id:id, channelState:state},
				async: false,
				success: function(data){
					tag = data;
				},
				error:function(data) {
					console.log(data.msg);
				},
			});		
			if(tag == "success"){
				layer.msg('删除成功', {icon:5,time:1000});
			}
			layer.close(index);
			location.reload();
		});
	}else{
		layer.confirm('确认要暂停该通道吗？',function(index){
			$.ajax({
				type: 'POST',
				async: false,
				url: '/flowsys/channel/channel_state_update.do',
				dataType: 'json',
				data: {id:id, channelState:state},
				success: function(data){
					tag = data;
					alert(data);
					if(data=="success")
					{
						location.reload();
					}else{
						layer.msg('更新通道失败!',{icon:1,time:1000});
					}
				},
				error:function(data) {
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
}
/*通道使用状态-修改*/
function changeUseState(obj,useState){
	var id = $(obj).children().eq(0).val();
	//alert(id);
	if(useState == "1"){
		layer.confirm('确认要启用该通道吗？',function(index){
			$.ajax({
				type: 'POST',
				async: false,
				url: '/flowsys/channel/channel_use_state_update.do',
				dataType: 'json',
				data: {id:id, channelUseState:useState},
				success: function(data){
					alert(data);
					if(data=="success")
					{
						location.reload();
					}else{
						layer.msg('更新通道失败!',{icon:1,time:1000});
					}
				},
				error:function(data) {
					console.log(data.msg);
				},
			});	
			layer.close(index);
			location.reload();
		});
	}else{
		layer.confirm('确认要停用该通道吗？',function(index){
			$.ajax({
				type: 'POST',
				async: false,
				url: '/flowsys/channel/channel_use_state_update.do',
				dataType: 'json',
				data: {id:id, channelUseState:useState},
				success: function(data){
					alert(data);
					if(data=="success")
					{
						location.reload();
					}else{
						layer.msg('更新通道失败!',{icon:1,time:1000});
					}
				},
				error:function(data) {
					console.log(data.msg);
				},
			});	
			layer.close(index);
			location.reload();
		});
	}
}

/*通道-下架*/
function channel_stop(url,channelId){
	layer.confirm('确认要下架吗？',function(index){
		$.ajax({
			type: 'POST',
			url: url,
			data: {channelId:channelId},
			success: function(data){
				if(data=="success")
				{
					layer.msg('下架通道成功!',{icon:1,time:1000});
					location.reload();
				}else{
					layer.msg('下架通道失败!',{icon:1,time:1000});
				}
			},
			error:function(data) {
				console.log(data.msg);
			}
		});		
	});
}
</script> 
</body>
</html>