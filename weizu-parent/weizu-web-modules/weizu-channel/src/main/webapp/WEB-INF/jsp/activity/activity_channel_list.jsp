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
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 平台通道管理 <span class="c-gray en">&gt;</span> 通道列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
	<form action="/flowsys/channel/channel_list.do" method="post" id="formD" name="dataListForm">
		<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
		通道名称：<input type="text" value="${resultMap.searchParam.channelName }" name="channelName" id="" placeholder=" 通道名称" style="width:250px" class="input-text">
		配置
		<span class="select-box inline">
			<select name="channelState" class="select" onchange="getChannelList(this)">
			<option value="">请选择</option>
			<c:forEach items="${resultMap.channelStateEnums }" var="cstate" varStatus="vs1">
				<option value="${cstate.value }" <c:if test="${cstate.value == resultMap.searchParam.channelState }"> selected</c:if>>${cstate.desc }</option>
			</c:forEach>
		</select>
		</span>
		
		通道省份：<input type="text" value="${resultMap.searchParam.scopeCityName }" name="scopeCityName" id="" placeholder=" 通道省份" style="width:250px" class="input-text">
		代理商名称：<input type="text" value="${resultMap.searchParam.agencyName }" name="agencyName" id="" placeholder=" 代理商名称" style="width:250px" class="input-text">
		
		<button type="reset"class="btn btn-success" value="重置">重置</button>
		<input value="查询" class="btn btn-success" type="submit"><!-- <i class="Hui-iconfont">&#xe665;</i> -->
		
		<input type="hidden" name="pageNo" value="${resultMap.pagination.pageNo }"> 
		</form>
	</div>
	<!-- <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" data-title="添加资讯" data-href="article-add.html" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加资讯</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div> -->
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<!-- <th width="80">流量包Id</th> -->
					<!-- <th width="80">ID</th> -->
					<th width="80">通道名称</th>
					<th width="80">通道类型</th>
					<th width="80">活动时间</th>
					<!-- <th width="80">交易单数</th>
					<th width="80">交易总额</th> -->
					<!-- <th width="120">支持城市</th> -->
					<th width="60">运营商类型</th>
					<th width="60">包体类型</th>
					<th width="60">通道折扣</th>
					<!-- <th width="75">通道余额</th>
					<th width="60">通道状态</th>
					<th width="60">通道使用状态</th> -->
					<th width="60">通道规格</th>
					
					<th width="120">操作</th>
				</tr>
			</thead>
			<tbody>
				<td>微族科技</td> 
				<td>不带票</td> 
				<td>2017-07-01 01:16:34</td> 
				<td>移动</td> 
				<td>全国</td> 
				<td>{"北京","0.65"}</td> 
				<td>100& 500&</td> 
				<td>
				<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="changeCState(this,'0')" href="javascript:;" title="暂停">
					<input type="hidden" value="${channel.id }" >
					<i class="Hui-iconfont">&#xe6e5;</i>
				</a> <!-- 暂停 -->
				<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="changeUseState(this,'0')" href="javascript:;" title="停用">
					<input type="hidden" value="${channel.id }" >
					<i class="Hui-iconfont">&#xe631;</i>
				</a> <!-- 暂停 -->
				<a style="text-decoration:none" class="ml-5" onClick="article_edit('资讯编辑','article-add.html','10001')" href="javascript:;" title="绑定代理商"><i class="Hui-iconfont">&#xe6df;</i></a> 
				<!-- <a style="text-decoration:none" class="ml-5" onClick="article_edit('资讯编辑','article-add.html','10001')" href="javascript:;" title="参与代理商"><i class="Hui-iconfont">&#xe6df;</i></a> --> 
				<a style="text-decoration:none" class="ml-5" href="/flowsys/rate/rate_join_channel_list.do" title="参与代理商"><i class="Hui-iconfont">&#xe6de;;</i></a> 
				</td> 
				<%-- <c:forEach items="${resultMap.pagination.records }" var="channel" varStatus="vs">
					<tr class="text-c">
						<td>${channel.id }</td> 
						<td>${channel.channelName }</td>
						<td>${channel.channelTotalUse }</td>
						<td>${channel.channelTotalAmount }</td>
						<!-- <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','article-zhang.html','10001')" title="查看">资讯标题</u></td> -->
						<td>
							<c:forEach items="${resultMap.operatorTypeEnums }" var="operatorType" varStatus="vs1">
							<c:if test="${channel.operatorType == operatorType.value }"> ${operatorType.desc }</c:if>
							</c:forEach>
						</td>
						<td>
							<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceTypeEnum" varStatus="vs1">
								<c:if test="${channel.serviceType == serviceTypeEnum.value }"> ${serviceTypeEnum.desc }</c:if>
							</c:forEach>
						</td>
						<td>"${channel.scopeCityName }" : "${channel.channelDiscount}"</td> 
						<td>${channel.channelBalance }</td> 
						
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
						<a style="text-decoration:none" class="ml-5" onClick="article_edit('资讯编辑','article-add.html','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> 
						<!-- <a style="text-decoration:none" class="ml-5" onClick="article_del(this,'10001')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a> -->
						</td>
					</tr>
				</c:forEach> --%>
			</tbody>
		</table>
		<%-- <mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="channellistId" /> --%>  
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

/*onchange通道状态*/
function getChannelList(vart){
	//alert($(vart).val());
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
/*资讯-删除*/
function article_del(obj,id){
	var tag = "";
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
					/* alert(data);
					if(data=="success")
					{
						location.reload();
					}else{
						layer.msg('更新通道失败!',{icon:1,time:1000});
					} */
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