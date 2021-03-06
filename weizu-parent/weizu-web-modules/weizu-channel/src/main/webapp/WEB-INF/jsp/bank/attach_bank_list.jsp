<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
	<META HTTP-EQUIV="Expires" CONTENT="0"> 
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/view/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/skin/default/skin.css" id="skin" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>H-ui.admin 3.0</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 代理商列表<span class="c-gray en">&gt;</span> 绑定银行卡 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
<div class="page-container">
	<!-- <p class="f-20 text-success">欢迎使用微族通道系统 <span class="f-14">Beta</span>版本</p> -->
	<!-- <p>登录次数：18 </p>
	<p>上次登录IP：222.35.131.79.1  上次登录时间：2014-6-14 11:19:55</p> -->
	<p>代理商名称：${resultMap.agencyName }</p>
	<p>账户类型：<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
					<c:if test="${billTypeEnum.value == resultMap.billType }">
						${billTypeEnum.desc }
					</c:if>
				</c:forEach>
				</p>
	 <c:if test="${not empty resultMap.attachList }">
	 <table class="table table-border table-bordered table-bg">
		<thead>
			<tr >
				<th colspan="5" scope="col"><span class="label label-primary radius">已绑定银行卡列表</span>
				</th>
			</tr>
			<tr class="text-c">
				<th>银行卡名称</th>
				<th>银行卡账号</th>
				<th>账户真实姓名</th>
				<th>属性</th>
				<!-- <th>绑定状态</th> -->
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${resultMap.attachList }" var="bank" varStatus="vst">
				<tr class="text-c">
					<td>${bank.remittanceWay }</td>
					<td>${bank.remittanceBankAccount }</td>
					<td>${bank.accountName }</td>
					<td>
						<c:choose>
							<c:when test="${bank.polarity == 0 }"><!-- 默认 -->
								默认
							</c:when>
							<c:otherwise>
								非默认
							</c:otherwise>
						</c:choose>
					</td>
					<td class="td-manage">
						<c:if test="${bank.polarity != 0 }">
							<a style="text-decoration:none" class="ml-5" onClick="bank_del('/flowsys/bankAccount/del_bank_bind.do',this,${bank.id})" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6e2;</i></a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
	<p></p>
	<p></p>
	 <table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th colspan="7" scope="col"><span class="label label-warning radius">可绑定银行卡列表</span>
				</th>
			</tr>
			<tr class="text-c">
				<th>银行卡名称</th>
				<th>银行卡账号</th>
				<th>账户真实姓名</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty resultMap.unattachList }">
					<c:forEach items="${resultMap.unattachList }" var="bank" varStatus="vst">
						<tr class="text-c">
							<td>${bank.remittanceWay }</td>
							<td>${bank.remittanceBankAccount }</td>
							<td>${bank.accountName }</td>
							<!-- <td>已绑定</td> -->
							<td class="td-manage">
								<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" onClick="add_bank('/flowsys/bankAccount/attach_bank.do',${bank.id})" href="javascript:;" title="添加银行卡"><i class="Hui-iconfont">&#xe725;</i></a>
								<%-- <c:if test="${bank.polarity != 0 }">
								</c:if> --%>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr class="text-c">
							<td colspan="4">没有可配置银行卡</td>
						</tr>
				</c:otherwise>
			</c:choose>
			
		</tbody>
	</table>
</div>
<footer class="footer mt-20">
	<div class="container">
		<p><!-- 感谢jQuery、layer、laypage、Validform、UEditor、My97DatePicker、iconfont、Datatables、WebUploaded、icheck、highcharts、bootstrap-Switch<br> -->
			Copyright &copy;2017-2018 南昌微族科技有限公司 All Rights Reserved.<br>
			<!-- 本后台系统由<a href="http://www.h-ui.net/" target="_blank" title="H-ui前端框架">H-ui前端框架</a>提供前端技术支持 -->
			</p>
	</div>
</footer>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<script>
//设置账号
function setBankAccount(vart){
	 var bankAccount = $(vart).next().val();
	 alert(bankAccount);
	 $('#remittanceBankAccount').val(bankAccount);
}
//删除绑定
function bank_del(url,vart,idt){
	layer.confirm('确认要删除银行卡绑定吗？',function(index){
		$.ajax({
			type: 'POST',
			url: url,
			data: {id:idt},
			success: function(data){
				if(data=="success")
				{
					layer.msg('删除成功!',{icon:1,time:1000});
					location.reload();
				}else{
					layer.msg('删除失败!',{icon:2,time:1000});
				}
			},
			error:function(data) {
				console.log(data.msg);
			}
		});		
	});
}
//添加绑定
function add_bank(url,id){
	//alert(id);
	$.ajax({
		type: 'POST',
		url: url,
		data: {id:id},
		success: function(data){
			if(data=="success")
			{
				layer.msg('添加成功!',{icon:1,time:1000});
				location.reload();
			}else if(data=="exist"){
				layer.msg('已添加!',{icon:3,time:1000});
			}
			else{
				layer.msg('添加失败!',{icon:2,time:1000});
			}
		},
		error:function(data) {
			console.log(data.msg);
		}
	});	
}

</script>
</body>
</html>