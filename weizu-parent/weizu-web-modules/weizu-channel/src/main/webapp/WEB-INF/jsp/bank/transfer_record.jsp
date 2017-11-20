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
<title>银行卡转账记录</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 银行卡管理  <span class="c-gray en">&gt;</span> 转账记录 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<!-- <a href="getRegisterPage.do">生成代理商注册页面</a> -->
	<div class="text-c">
		<form action="/flowsys/bankAccount/transfer_record.do" method="post" id="formD" name="dataListForm">
				<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
				<%-- 代理商名称:<input type="text"  value="${resultMap.params.userName }" name="userName" id="" placeholder=" 代理商名称" style="width:250px" class="input-text"> --%>
				<!-- <input type="text" style="width:150px" class="input-text" name="start_datetime"  value="2017-05-26 00:00:00"  onClick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
	                  	<em class="inputto">至</em>
	            <input style="width:150px" type="text" class="input-text" name="end_datetime"   value="2017-05-26 23:59:59"  onClick="WdatePicker({startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> -->
				转账类型：<span class="select-box inline">
							<select name="direction"  id="direction" class="select" onchange="formSub()">
								<c:forEach items="${resultMap.inOrOutEnums }" var="inOrOutEnum" varStatus="vs1">
									<option value="${inOrOutEnum.value }" <c:if test="${inOrOutEnum.value == resultMap.direction }"> selected</c:if>>${inOrOutEnum.desc }</option>
								</c:forEach>
							</select>
						</span>
				银行卡：<span class="c-success">${resultMap.bankPo.remittanceWay }</span>
				账号：<span class="c-success">${resultMap.bankPo.remittanceBankAccount }</span>
				<!-- <button name="" id="" class="btn btn-success"  type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button> -->
				<input type="hidden" name="pageNoLong" value="${resultMap.pagination.pageNoLong }"> 
				<input type="hidden" name="bankId" value="${resultMap.bankPo.id }"> 
		</form>
	</div>
	<!-- <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" data-title="添加资讯" data-href="article-add.html" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加资讯</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div> -->
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<!-- <th width="25"><input type="checkbox" name="" value=""></th> -->
					<c:choose>
						<c:when test="${resultMap.direction == 0 }"><!-- 转入显示转出银行卡信息 -->
							<th width="80">转入银行卡</th>
							<th width="80">转入账号</th>
							<th width="60">转账金额</th>
							<th width="60">入账金额</th>
							<th width="80">操作</th>
						</c:when>
						<c:otherwise>
							<th width="80">转出银行卡</th>
							<th width="80">转出账号</th>
							<th width="60">转账金额</th>
							<th width="60">入账金额</th>
						</c:otherwise>
					</c:choose>
					<th width="60">汇款确认状态</th>
					<th width="75">汇款代理商</th>
					<th width="75">提交申请时间</th>
					<th width="75">真实汇款时间</th>
					<th width="75">汇款确认时间</th>
					<!-- <th width="120">操作</th> -->
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="transfer" varStatus="vs">
					<tr class="text-c font-red">
						<td style="display:none">${transfer.id }</td>
						<c:choose>
						<c:when test="${resultMap.direction == 0 }"><!-- 转入显示转出银行卡信息 -->
							<th width="80">${transfer.fromRemittanceWay }</th>
							<th >${transfer.fromRemittanceBankAccount }</th>
							<td>${transfer.commitAmount }</td>
							<td>${transfer.transferAmount }</td>
								<c:choose>
									<c:when test="${transfer.confirmState == 2 }">
										<th width="80" class="td-manage">
											<a style="text-decoration:none" class="c-primary " onClick="transfer_shenhe(this,${transfer.id},${transfer.confirmState })" href="javascript:;" title="审核">审核</a>
										</th>
									</c:when>
									<c:when test="${transfer.confirmState == 1 }"><!-- 审核成功 -->
										<th width="80" class="td-manage">
											已审核
											<%-- <a style="text-decoration:none" class="c-primary" onClick="transfer_shenhe(this,${transfer.id}, ${transfer.confirmState })" href="javascript:;" title="审核">重新审核</a> --%>
										</th>
									</c:when>
									<c:otherwise>
										<th width="80" class="td-manage">
											已审核
											<%-- <a style="text-decoration:none" class="c-primary" onClick="transfer_shenhe(this,${transfer.id}, ${transfer.confirmState })" href="javascript:;" title="审核">重新审核</a> --%>
										</th>
									</c:otherwise>
								</c:choose>
						</c:when>
						<c:otherwise>
							<th width="80">${transfer.toRemittanceWay }</th>
							<th width="80">${transfer.toRemittanceBankAccount }</th>
							<td>${transfer.commitAmount }</td>
							<td>${transfer.transferAmount }</td>
						</c:otherwise>
					</c:choose>
					<td class="td-status">
					<c:choose>
						<c:when test="${transfer.confirmState == 2 }">
							<c:forEach items="${resultMap.confirmStateTransferEnums }" var="confirmStateEnum" varStatus="vs1">
								<c:if test="${transfer.confirmState == confirmStateEnum.value }"> <span class="label label-default radius">${confirmStateEnum.desc }</span></c:if>
							</c:forEach>
						</c:when>
						<c:when test="${transfer.confirmState == 1 }"><!-- 审核成功 -->
							<c:forEach items="${resultMap.confirmStateTransferEnums }" var="confirmStateEnum" varStatus="vs1">
								<c:if test="${transfer.confirmState == confirmStateEnum.value }"> <span class="label label-success radius">${confirmStateEnum.desc }</span></c:if>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach items="${resultMap.confirmStateTransferEnums }" var="confirmStateEnum" varStatus="vs1">
								<c:if test="${transfer.confirmState == confirmStateEnum.value }"> <span class="label label-danger radius">${confirmStateEnum.desc }</span></c:if>
							</c:forEach>
						</c:otherwise>
					</c:choose>
					</td>
						<%-- <td class="td-status">
							<c:forEach items="${resultMap.confirmStateTransferEnums }" var="confirmStateEnum" varStatus="vs1">
							<c:if test="${transfer.confirmState == confirmStateEnum.value }"> <span class="label label-success radius">${confirmStateEnum.desc }</span></c:if>
							</c:forEach>
						</td> --%>
						<td>${transfer.fromAgencyName }</td>
						<!-- <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','article-zhang.html','10001')" title="查看">资讯标题</u></td> -->
						<td>${transfer.commitTimeStr }</td>
						<td>${transfer.realTimeStr }</td>
						<td>${transfer.confirmTimeStr }</td>
						<%-- <td class="td-manage">
							<a data-toggle="tooltip" data-placement="top" style="text-decoration:none;cursor:pointer" onClick="editRate(this)" href="javascript:;" title="查看APIKey"><i class="Hui-iconfont">&#xe60c;</i></a>
							<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" onClick="resetPass('${agency.id}')" href="javascript:;" title="重置密码"><i class="Hui-iconfont">&#xe63f;</i></a>
							<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" class="ml-5" onClick="account_charge('账户充值',${agency.accountId })" href="javascript:;" title="账户充值"><i class="Hui-iconfont">&#xe726;</i></a> 
							<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" class="ml-5" data-title="设置银行卡" data-href="/flowsys/bankAccount/attach_bank_page.do?accountId=${agency.accountId }" onClick="Hui_admin_tab(this)"><i class="Hui-iconfont">&#xe725;</i></a> 
							<a title="/flowsys/rate/rate_add_page.do?rateId=${agency.rateId }&agencyId=${agency.id}" data-href="/flowsys/rate/rate_add_page.do?rateId=${agency.rateId }&agencyId=${agency.id}" data-title="费率添加" onclick="Hui_admin_tab(this)"><i class="Hui-iconfont">&#xe6df;</i></a>
							<c:choose>
								<c:when test="${loginContext.rootAgencyId == 0 }">
									<a data-toggle="tooltip" data-placement="top" style="text-decoration:none"  title="配置通道" data-href="/flowsys/rate/bind_channel_list.do?accountId=${agency.accountId }&agencyName=${agency.userName}&billTypeRate=${agency.billType}" data-title="配置通道" onclick="Hui_admin_tab(this)"><i class="Hui-iconfont">&#xe604;</i></a>
								</c:when>
								<c:otherwise>
									<a data-toggle="tooltip" data-placement="top" style="text-decoration:none"  title="配置折扣" data-href="/flowsys/rate/my_rate_list.do?accountId=${agency.accountId }&agencyName=${agency.userName}" data-title="配置折扣" onclick="Hui_admin_tab(this)"><i class="Hui-iconfont">&#xe604;</i></a>
								</c:otherwise>
							</c:choose>
							
						</td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="agencyId" />  
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<!-- jQuery -->

<!-- <script type="text/javascript" src="/view/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" charset="utf8" src="/view/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> -->
<script type="text/javascript" src="/view/lib/laypage/1.2/laypage.js"></script>
<!-- 时间选择器 -->
<!--  <script src="/view/lib/moment.js"></script>
<script src="/view/lib/bootstrap-datetimepicker.min.js"></script>
<script src="/view/lib/bootstrap-datetimepicker.zh-CN.js"></script> -->
<script type="text/javascript">
/**修改状态*/
/* function confirmState(id,confirmState,iconst){
	$.ajax({
		type: 'POST',
		url: '/flowsys/bankAccount/transfer_confirm_page.do',
		data: {id:id,confirmState:confirmState},
		success: function(data){
			if(data=="success")
			{
				if(iconst == 6){
					layer.msg('审核通过成功', {icon:1,time:1000});
				}else if(icons == 5){
					layer.msg('审核未通过成功', {icon:6,time:1000});
				}
				//layer.msg('删除成功!',{icon:1,time:1000});
				location.reload();
			}else{
				if(iconst == 6){
					layer.msg('审核通过失败', {icon:2,time:1000});
				}else if(icons == 5){
					layer.msg('审核未通过失败', {icon:5,time:1000});
				}
				//layer.msg('删除失败!',{icon:2,time:1000});
			}
		},
		error:function(data) {
			console.log(data.msg);
		}
	});	
} */
/*转账-审核*/
function transfer_shenhe(obj,id,confirmState){
	layer.confirm('审核转账？', {
		btn: ['通过','不通过','取消'], 
		shade: false,
		closeBtn: 0
	},
	function(){
		if(confirmState != 1){//和原来的状态不一样
			$.ajax({
				type: 'POST',
				url: '/flowsys/bankAccount/transfer_confirm.do',
				data: {id:id,confirmState:1},
				success: function(data){
					if(data=="success")
					{
						layer.msg('审核通过成功', {icon:6,time:1000});
						location.reload();
					}else{
						layer.msg('审核通过失败', {icon:5,time:1000});
					}
				},
				error:function(data) {
					console.log(data.msg);
				}
			});	
			//confirmState(id,1,6);
			/* $(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="transfer_shenhe(this,id,1)" href="javascript:;" title="重新审核">重新审核</a>');
			$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">完成转账</span>');
			$(obj).remove(); */
		}
		
	},
	function(){
		if(confirmState != 0){//和原来的状态不一样
		/* $(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="transfer_shenhe(this,id,0)" href="javascript:;" title="重新审核">重新审核</a>');
			$(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">转账未通过</span>');
			$(obj).remove(); */
			//confirmState(id,0,5);
			$.ajax({
				type: 'POST',
				url: '/flowsys/bankAccount/transfer_confirm.do',
				data: {id:id,confirmState:0},
				success: function(data){
					if(data=="success")
					{
						layer.msg('审核未通过成功', {icon:6,time:1000});
						location.reload();
					}else{
						layer.msg('审核未通过失败', {icon:5,time:1000});
					}
				},
				error:function(data) {
					console.log(data.msg);
				}
			});	
    	}
	});	
}

/*onchange通道状态*/
function formSub(){
	//alert($(vart).val());
	$('form').submit();
}
</script> 
</body>
</html>