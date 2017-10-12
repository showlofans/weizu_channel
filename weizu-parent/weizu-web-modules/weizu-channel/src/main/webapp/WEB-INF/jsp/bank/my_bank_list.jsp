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
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 银行卡管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<!-- <p class="f-20 text-success">欢迎使用微族通道系统 <span class="f-14">Beta</span>版本</p> -->
	<!-- <p>登录次数：18 </p>
	<p>上次登录IP：222.35.131.79.1  上次登录时间：2014-6-14 11:19:55</p> -->
	 <c:if test="${not empty chargeAccount1 }">
	 <table class="table table-border table-bordered table-bg">
		<thead>
			<tr >
				<th colspan="5" scope="col">对公账户余额：${chargeAccount1.accountBalance } 
					<c:if test="${not empty resultMap.bankList}">
					<span class="text-r">
						<a style="text-decoration:none" class="btn radio btn-primary" onClick="bank_add('银行卡添加','/flowsys/bankAccount/add_bank_page.do',1)" href="javascript:;" title="添加银行卡"><i class="Hui-iconfont">&#xe600;</i>添加银行卡</a>
					</span>
					</c:if>
				</th>
			</tr>
			<tr class="text-c">
				<th>银行卡名称</th>
				<th>银行卡账号</th>
				<th>账户真实姓名</th>
				<th>对账余额</th>
				<!-- <th>绑定状态</th> -->
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty resultMap.bankList}">
					<c:forEach items="${resultMap.bankList }" var="bank" varStatus="vst">
						<tr class="text-c">
							<td>${bank.id }</td>
							<td>${bank.remittanceBankAccount }</td>
							<td>${bank.accountName }</td>
							<td>
								<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" data-href="/flowsys/bankAccount/transfer_record.do?bankId=${bank.id }" data-title="转账记录" href="javascript:void(0)" onclick="Hui_admin_tab(this)">
									${bank.referenceBalance }
								</a>
							</td>
							<!-- <td>已绑定</td> -->
							<td class="td-manage">
								<a data-toggle="tooltip" data-placement="top" style="text-decoration:none;cursor:pointer" onClick="bank_edit('编辑银行卡','/flowsys/bankAccount/edit_bank_page.do', ${bank.id })" href="javascript:;" title="编辑银行卡"><i class="Hui-iconfont">&#xe6df;</i></a>
								<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" class="ml-5" onClick="bank_del('/flowsys/bankAccount/del_bank.do',${bank.id }, '${bank.remittanceWay }')" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>
								<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" data-href="/flowsys/bankAccount/plus_bank_list.do?id=${bank.id }&accountId=${chargeAccount1.id}" data-title="卡充值" href="javascript:void(0)" onclick="Hui_admin_tab(this)"><i class="Hui-iconfont">&#xe604;</i></a>
								<%-- <a data-toggle="tooltip" data-placement="top" style="text-decoration:none" onClick="transfer('${agency.id}')" href="javascript:;" title="卡充值"><i class="Hui-iconfont">&#xe604;</i></a> --%>
								<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" onClick="bindAgency('${agency.id}')" href="javascript:;" title="绑定代理商"><i class="Hui-iconfont">&#xe725;</i></a>
								<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" class="ml-5" onClick="account_charge('账户充值',${agency.accountId })" href="javascript:;" title="设为默认"><i class="Hui-iconfont">&#xe60e;</i></a> 
							</td>
						</tr>
					</c:forEach>
					<%-- <tr class="text-c">
						<td>招商银行</td>
						<td>365565226566565456546</td>
						<td>小钱</td>
						<td>3000.00</td>
						<!-- <td>已绑定</td> -->
						<td class="td-manage">
							<a data-toggle="tooltip" data-placement="top" style="text-decoration:none;cursor:pointer" onClick="editRate(this)" href="javascript:;" title="编辑银行卡"><i class="Hui-iconfont">&#xe6df;</i></a>
							<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" class="ml-5" onClick="channel_stop('/flowsys/channel/channel_delete.do',${channel.id})" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>
							<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" onClick="resetPass('${agency.id}')" href="javascript:;" title="绑定代理商"><i class="Hui-iconfont">&#xe604;</i></a>
							<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" class="ml-5" onClick="account_charge('账户充值',${agency.accountId })" href="javascript:;" title="设为默认"><i class="Hui-iconfont">&#xe60e;</i></a> 
						</td>
					</tr> --%>
				</c:when>
				<c:otherwise>
				<tr class="text-c">
					<td colspan="5">
						<a style="text-decoration:none" class="btn radio btn-primary" onClick="bank_add('银行卡添加','/flowsys/bankAccount/add_bank_page.do',1)" href="javascript:;" title="添加银行卡"><i class="Hui-iconfont">&#xe600;</i>添加银行卡</a>
					</td>
				</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	</c:if>
	<p></p>
	<p></p>
	 <table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th colspan="7" scope="col">对私账户余额：${chargeAccount.accountBalance }
					<c:if test="${not empty resultMap.bankList0}">
					<span class="text-r">
						<a style="text-decoration:none" class="btn radio btn-primary" onClick="bank_add('银行卡添加','/flowsys/bankAccount/add_bank_page.do',0)" href="javascript:;" title="添加银行卡"><i class="Hui-iconfont">&#xe600;</i>添加银行卡</a>
					</span>
					</c:if>
				</th>
			</tr>
			<tr class="text-c">
				<th>银行卡名称</th>
				<th>银行卡账号</th>
				<th>账户真实姓名</th>
				<th>对账余额</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty resultMap.bankList0}">
					<c:forEach items="${resultMap.bankList0 }" var="bank" varStatus="vst">
						<tr class="text-c">
							<td>${bank.remittanceWay }</td>
							<td>${bank.remittanceBankAccount }</td>
							<td>${bank.accountName }</td>
							<td>
								<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" data-href="/flowsys/bankAccount/transfer_record.do?bankId=${bank.id }" data-title="转账记录" href="javascript:void(0)" onclick="Hui_admin_tab(this)">
									${bank.referenceBalance }
								</a>
							</td>
							<!-- <td>已绑定</td> -->
							<td class="td-manage">
								<a data-toggle="tooltip" data-placement="top" style="text-decoration:none;cursor:pointer" onClick="bank_edit('编辑银行卡','/flowsys/bankAccount/edit_bank_page.do', ${bank.id })" href="javascript:;" title="编辑银行卡"><i class="Hui-iconfont">&#xe6df;</i></a>
								<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" class="ml-5" onClick="bank_del('/flowsys/bankAccount/del_bank.do',${bank.id }, '${bank.remittanceWay }')" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>
								<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" data-href="/flowsys/bankAccount/plus_bank_list.do?id=${bank.id }&accountId=${chargeAccount.id}" data-title="卡充值" href="javascript:void(0)" onclick="Hui_admin_tab(this)"><i class="Hui-iconfont">&#xe604;</i></a>
								<%-- <a data-toggle="tooltip" data-placement="top" style="text-decoration:none" onClick="transfer('${agency.id}')" href="javascript:;" title="卡充值"><i class="Hui-iconfont">&#xe604;</i></a> --%>
								<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" onClick="bindAgency('${agency.id}')" href="javascript:;" title="绑定代理商"><i class="Hui-iconfont">&#xe725;</i></a>
								<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" class="ml-5" onClick="account_charge('账户充值',${agency.accountId })" href="javascript:;" title="设为默认"><i class="Hui-iconfont">&#xe60e;</i></a> 
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
				<tr class="text-c">
					<td colspan="5">
						<a style="text-decoration:none" class="btn radio btn-primary" onClick="bank_add('银行卡添加','/flowsys/bankAccount/add_bank_page.do',0)" href="javascript:;" title="添加银行卡"><i class="Hui-iconfont">&#xe600;</i>添加银行卡</a>
					</td>
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
/*银行卡-删除*/
function bank_del(url,id,bankName){
	layer.confirm('确认要删除'+bankName+'银行卡吗？',function(index){
		$.ajax({
			type: 'POST',
			url: url,
			data: {id:id},
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
/*银行卡-编辑*/
function bank_edit(title,url,id,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url + '?id=' + id,
		area: ['650px', '560px'],
		end: function () {
            location.reload();
		}
	});
	//layer.full(index);
}
/*银行卡-添加*/
function bank_add(title,url,billType){
	//alert("sd");
	layer.open({
        type: 2,
        title: title,
        area: ['650px', '560px'],
        maxmin: false,
        closeBtn: 1,
        content: url+'?billType=' + billType,
         end: function () {
            location.reload();
        }
    });
}

</script>
</body>
</html>