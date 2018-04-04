<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/MyTaglib.tld" prefix="mytag"%>
<!DOCTYPE html>
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
<!-- <link rel="stylesheet" href="/view/mine/bootstrap-datetimepicker.css"> -->

<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>配置通道</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 代理商管理 <span class="c-gray en">&gt;</span> 配置通道 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:onSub();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
<div class="page-container">
	<!-- <a href="getRegisterPage.do">生成代理商注册页面</a> -->
	<%-- <div class="text-c">
		<form action="/flowsys/rate/rate_list.do" method="post" id="formD" name="dataListForm">
				<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
				费率名称:<input type="text" value="${resultMap.params.rateName }" name="rateName" id="" placeholder=" 费率名称" style="width:150px" class="input-text">
				移动省份:<input type="text" value="${resultMap.params.ratePrice0 }" name="ratePrice0" id="" placeholder=" 移动省份" style="width:150px" class="input-text">
				联通省份:<input type="text" value="${resultMap.params.ratePrice1 }" name="ratePrice1" id="" placeholder=" 联通省份" style="width:150px" class="input-text">
				电信省份:<input type="text" value="${resultMap.params.ratePrice2 }" name="ratePrice2" id="" placeholder=" 电信省份" style="width:150px" class="input-text">
				<button type="reset"class="btn btn-success" value="重置">重置</button>
				<button name="" id="" class="btn btn-success"  type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
				<input type="hidden" name="pageNo" value="${resultMap.pagination.pageNo }"> 
		</form>
	</div> --%>
	<div class="text-c" >
		<form action="/flowsys/rate/bind_channel_list.do" method="post" id="formD" name="dataListForm">
			<input type="hidden" name="pageNo" value="${resultMap.pagination.pageNo }"> 
			<input type="hidden" name="accountId" value="${resultMap.childAccountPo.id }"> 
			<input type="hidden" name="agencyName" value="${resultMap.childAccountPo.agencyName }"> 
			<input type="text" value="${resultMap.scopeCityName }" name="scopeCityName" id="scopeCityName" placeholder=" 通道地区" style="width:150px" class="input-text"></input>
			<button name="" id="" class="btn btn-success"  type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
			<button type="button"class="btn btn-primary" onclick="resetPlace()" value="重置">重置</button>
		</form>
	</div>
	<!-- <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" data-title="添加资讯" data-href="article-add.html" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加资讯</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div> -->
		<div class="mt-20">
			<!-- <sapn>通道名称：微族科技</sapn>
			<sapn>是否带票：不带票</sapn>
			<sapn>通道折扣：云南85</sapn> -->
			<sapn>代理商名称：${resultMap.childAccountPo.agencyName }</sapn><br>
			高级通道开通状态：<sapn>
			<c:choose>
				<c:when test="${isOpen == 1 }">开通</c:when>
				<c:otherwise>
					未开
				</c:otherwise>
			</c:choose></sapn><br>
			<!-- <sapn>通道折扣：云南85</sapn> -->
			<a style="text-decoration:none" class="btn btn-success" onclick="Hui_admin_tab(this)" data-href="/flowsys/rate/bind_channel_page.do" title="" data-title="添加通道">添加通道</a>
			
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th>通道名称</th>
					<th>通道折扣</th>
					<th>移动折率</th>
					<th>联通折率</th>
					<th>电信折率</th>
					<th>费率/通道类型</th>
					<th>绑定状态</th>
					<th>添加时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="activePo" varStatus="vs">
					<tr class="text-c">
						<td>${activePo.channelName }</td>
						<td>${activePo.channelDiscount }</td>
						<td  class="text-l">${activePo.discountPo.discount0 }</td>
						 <td class="text-l">${activePo.discountPo.discount1 }</td>
						<td class="text-l">${activePo.discountPo.discount2 }</td>
						<td>
							<c:choose>
								<c:when test="${activePo.billTypeRate == activePo.billTypeChannel}">
									<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
										<c:if test="${activePo.billTypeRate == billTypeEnum.value }"> ${billTypeEnum.desc }</c:if>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
										<c:if test="${activePo.billTypeRate == billTypeEnum.value }"> ${billTypeEnum.desc }</c:if>
									</c:forEach>/
									<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
										<c:if test="${activePo.billTypeChannel == billTypeEnum.value }"> ${billTypeEnum.desc }</c:if>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</td>
						
						<td><c:forEach items="${resultMap.bindStateEnums }" var="bindStateEnum" varStatus="vs1">
							<c:if test="${activePo.bindState == bindStateEnum.value }"> ${bindStateEnum.desc }</c:if>
							</c:forEach>
						</td>
						<td>${activePo.activeTimeStr }</td>
						
						<td class="td-manage">
						<a style="text-decoration:none" class="ml-5" onClick="bind_del(this,${activePo.id })" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
						<c:choose>
							<c:when test="${activePo.bindState == 0 }">
								<a style="text-decoration:none" data-toggle="tooltip" data-placement="top"  onClick="changeBState('/flowsys/rate/update_bind_state.do',${activePo.id },1)" href="javascript:;" title="解绑"><i class="Hui-iconfont">&#xe605;</i></a> 
							</c:when>
							<c:otherwise>
								<a style="text-decoration:none" data-toggle="tooltip" data-placement="top"  onClick="changeBState('/flowsys/rate/update_bind_state.do',${activePo.id },0)" href="javascript:;" title="绑定"><i class="Hui-iconfont">&#xe60e;</i></a> 
							</c:otherwise>
						</c:choose> 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<mytag:Pagination pagination="${resultMap.pagination}" queryForm="formD" divId="rateId" />
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

<!-- <script type="text/javascript" charset="utf8" src="/view/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> -->
<script type="text/javascript" src="/view/lib/laypage/1.2/laypage.js"></script>
<!-- 时间选择器 -->
<!--  <script src="/view/lib/moment.js"></script>
<script src="/view/lib/bootstrap-datetimepicker.min.js"></script>
<script src="/view/lib/bootstrap-datetimepicker.zh-CN.js"></script> -->
<script type="text/javascript">
function onSub(){
	location.reload();
}
//重置搜索地区
function resetPlace(){
	$('#scopeCityName').val('');
	$('form').submit();	
}
//更新绑定状态
function changeBState(url,activeId,bindS){
	var bindConfirm = "";
	var bindState = -1;
	if(bindS==1){
		bindConfirm = '解绑';
		bindState = 0;
	}else{
		bindConfirm = '绑定';
		bindState = 1;
	}
            //当点击‘确定’按钮的时候，获取弹出层返回的值
           // var res = window["layui-layer-iframe" + index].callbackdata();
            //打印返回的值，看是否有我们想返回的值。
            //console.log(res);
            //最后关闭弹出层
          layer.confirm('确认要清除绑定吗？',function(index){
        	  $.ajax({
  				type: 'POST',
  				url: url,
  				//dataType: 'json',
  				data: {activeId:activeId, bindState:bindS},
  				async: false,
  				success: function(data){
  					//alert(data);
  					if(data=="success")
  					{
  						location.reload();
  					}else{
  						layer.msg('更新绑定状态!',{icon:1,time:1000});
  					} 
  				},
  				error:function(data) {
  					console.log(data.msg);
  				},
  			});
          })
            
}
/**删除绑定**/
function bind_del(vart,id){
	var url = "/flowsys/rate/del_agency_active_rate.do";
	layer.confirm('确认要清除绑定吗？',function(index){
		$.ajax({
			type: 'POST',
			url: url,
			data: {id:id},
			success: function(data){
				if(data=="success")
				{
					layer.msg('下架绑定成功!',{icon:1,time:1000});
					location.reload();
				}else{
					layer.msg('下架平台失败!',{icon:1,time:1000});
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