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
<title>平台列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 平台通道管理 <span class="c-gray en">&gt;</span>平台管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
<div class="page-container">
	<div class="text-c">
	<form action="/flowsys/platform/platform_list.do" method="post" id="formD" name="dataListForm">
		<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
		平台名称：<input type="text" value="${resultMap.searchParam.epName }" name="epName" id="" placeholder=" 平台名称" style="width:250px" class="input-text">
		<span class="select-box inline">
			<select name="epFor" class="select" onchange="formSub()">
				<option value="">平台类型</option>
				<c:forEach items="${resultMap.pgServiceTypeEnums }" var="pgServiceTypeEnum" varStatus="vs1">
					<option value="${pgServiceTypeEnum.value }" <c:if test="${pgServiceTypeEnum.value == resultMap.searchParam.epFor }"> selected</c:if>>${pgServiceTypeEnum.desc }</option>
				</c:forEach>
			</select>
		</span>
		<button type="button"class="btn btn-success" onclick="javascript:location.replace(location.href);" value="重置">重置</button>
		<a style="text-decoration:none" class="btn btn-success" onClick="platform_add('平台信息添加','/flowsys/platform/platform_add_page.do')" href="javascript:;" title="添加"><i class="Hui-iconfont">&#xe600;</i> 添加</a>
		<input value="搜平台" class="btn btn-success" type="submit" onclick="formSub()"><!-- <i class="Hui-iconfont">&#xe665;</i> -->
		<span><a href="javascript:;" onclick="updateBalance()" class="btn btn-primary radius">刷新余额</a></span>
		<input type="hidden" name="pageNo" value="${resultMap.pagination.pageNo }"> 
		</form>
	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<!-- <th width="80">流量包Id</th> -->
					<th width="80">平台名称</th>
					<th width="80">平台英文标识</th>
					<th width="80">平台类型</th>
					<th width="80">编码类型</th>
					<!-- <th width="80">产品列表地址</th>
					<th width="120">支持城市</th>
					<th width="60">订单状态地址</th>
					<th width="60">余额查询地址</th> -->
					<th width="75">账号</th>
					<!-- <th width="60">密码</th> -->
					<!-- <th width="60">平台余额</th> -->
					<th width="60">apikey</th>
					<!-- <th width="60">平台官网地址</th> -->
					<th width="60">最后更新</th>
					<th width="60">回调支持</th>
					<th width="60">操作</th>
					<th width="80">产品订购地址</th>
					<th width="80">平台其他参数</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="platform" varStatus="vs">
					<tr class="text-c <c:if test='${platform.epBalance >0 }'>success</c:if>"><!-- danger -->
						<td class="f-14 td-manage">
							<span data-toggle="tooltip" data-placement="top" style="text-decoration: none;" title="${platform.epBalance }">${platform.epName }
							</span>
						</td>
						<td class="f-14 td-manage">${platform.epEngId }</td>
						<td class="f-14">
							<c:forEach items="${resultMap.pgServiceTypeEnums }" var="pgServiceTypeEnum" varStatus="vs1">
								<c:if test="${pgServiceTypeEnum.value == platform.epFor }">
									${pgServiceTypeEnum.desc }
								</c:if>
							</c:forEach>
						</td>
						<td class="f-14">
							<c:forEach items="${resultMap.epEncodeTypeEnums }" var="epEncodeTypeEnum" varStatus="vs1">
								<c:if test="${epEncodeTypeEnum.value == platform.epEncodeType }">
									${epEncodeTypeEnum.desc }
								</c:if>
							</c:forEach>
						</td>
						<%-- <td><div class="f-12 c-999">
						<span data-toggle="tooltip" data-placement="top" title="${platform.productListIp }">${fn:substring(platform.productListIp,0,10)}</span>
						<a href="${platform.productListIp }">${platform.productListIp }</a>
						</div></td>
						<td><div class="f-12 c-999">
						<span data-toggle="tooltip" data-placement="top" title="${platform.epOrderStateIp }">${fn:substring(platform.epOrderStateIp,0,10)}</span>
						</div></td>
						<td><div class="f-12 c-999">
						<span data-toggle="tooltip" data-placement="top" title="${platform.epBalanceIp }">${fn:substring(platform.epBalanceIp,0,10)}</span>
						<a href="${platform.epBalanceIp }">${platform.epBalanceIp }</a>
						</div></td> --%>
						<td class="f-14 td-manage">
							<span data-toggle="tooltip" data-placement="top" title="${platform.epUserPass }">
							${platform.epUserName }
							</span>
						</td>
						<%-- <td class="f-14 td-manage">${platform.epUserPass }</td> --%>
						<td class="f-14 td-manage"><div class="f-12 c-999">
						<span data-toggle="popover" data-placement="top" title="${platform.epApikey }">${fn:substring(platform.epApikey,0,10)}</span>
						</div></td>
						<%-- <td><div class="f-12 c-999">
						<a title="${platform.epIp }" href="${platform.epIp }" target="_blank">${fn:substring(platform.epIp,0,10)}</a><!--  onclick="Hui_admin_tab(this)" -->
						</div></td>  --%>
						<td class="f-14 td-manage">${platform.lastAccessStr }</td>
						<td class="f-14 td-manage">
							<c:forEach items="${resultMap.callBackEnums }" varStatus="vs" var="cbEnum">
								<c:if test="${cbEnum.value == platform.epCallBack }">
									${cbEnum.desc }
								</c:if>
							</c:forEach>
						</td>
						<td class="f-14 td-manage success"> 
							<%-- <a style="text-decoration:none" onClick="platform_del('/flowsys/platform/platform_del.do','${platform.id}','${platform.epName }')" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a> --%> 
							<a style="text-decoration:none" class="ml-5" onClick="platform_edit('平台信息编辑','/flowsys/platform/platform_edit_page.do?epId=${platform.id}','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <!-- <a style="text-decoration:none" class="ml-5" onClick="platform_del(this,'10001')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a> --></td>
						<td><div class="f-12 c-999">
						<span data-toggle="popover"  data-placement="top" style="text-decoration: none;" title="${platform.epIp }"><a title="${platform.epIp }" href="${platform.epIp }" target="_blank">${platform.epPurchaseIp }</a></span>
						</div></td>
						<td>
							<span data-toggle="popover" data-placement="top" title="${platform.epOtherParams }">${fn:substring(platform.epOtherParams,0,10)}}</span>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="platformlistId" />  
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
/*平台-添加*/
function platform_add(title,url){
	//alert("sd");
	var index = layer.open({
        type: 2,
        title: title,
        //area: ['650px', '560px'],
        //closeBtn: 1,
        content: url+'?pageTitle=' + title,
         end: function () {
            location.reload();
        }
    });
	layer.full(index);
}
/* function formSub(){
	$('form').submit();
}
 */
/*平台-编辑*/
function platform_edit(title,url,id,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url,
		//area: ['650px', '560px'],
		end: function () {
            location.reload();
		}
	});
	layer.full(index);
}
/*平台-下架*/
function platform_del(url,epId,epName){
	layer.confirm('确认要清除'+epName+'平台吗？',function(index){
		$.ajax({
			type: 'POST',
			url: url,
			data: {epId:epId},
			success: function(data){
				if(data=="success")
				{
					layer.msg('下架平台成功!',{icon:1,time:1000});
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
/**刷新平台余额*/
function updateBalance(){
	$.ajax({
		type: 'POST',
		url: "/flowsys/platform/platform_balance.do",
		//data: {epId:epId},
		success: function(data){
			layer.alert(data, {
			    skin: 'layui-layer-lan'
			    ,closeBtn: 0
			    ,anim: 4 //动画类型
		    });
		},
		error:function(data) {
			console.log(data.msg);
		}
	});	
}
</script> 
</body>
</html>