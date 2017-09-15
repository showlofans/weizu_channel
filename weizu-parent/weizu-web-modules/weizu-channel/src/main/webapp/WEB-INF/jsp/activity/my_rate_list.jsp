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
<title>配置折扣</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 代理商管理 <span class="c-gray en">&gt;</span> 配置折扣 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
	<form action="/flowsys/rate/my_rate_list.do" method="post" id="formD" name="dataListForm">
		代理商名称： <input type="text" value="${childAgencyName}" name="agencyName" readonly="readonly" id="agencyName" placeholder=" " style="width:80px" class="input-text">
		<input value="刷新" class="btn btn-success" type="submit"><!-- <i class="Hui-iconfont">&#xe665;</i> -->
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
					<th>运营商类型</th>
					<th >业务类型</th>
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
						<td class="c-blue">${ratePo.activeDiscount }</td>
						<td style="display:none;" class="channelDiscountId">${ratePo.channelDiscountId }</td><!-- 通道折扣id -->
						<td style="display:none;" class="id">${ratePo.id }</td><!-- 通道折扣id -->
						<td style="display:none;" class="agencyId">${ratePo.agencyId }</td><!-- 通道折扣id -->
						<td><c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
								<c:if test="${ratePo.billType == billTypeEnum.value }">
									<span>${billTypeEnum.desc }</span>
								</c:if>
							</c:forEach>
						</td> 
						<c:choose>
							<c:when test="${empty ratePo.discountList }">
								<td><input type="text" value="" class="activeDiscount input-text" name="activeDiscount" id="" placeholder=" 费率折扣" style="width:80px"></td>
								<td>
									<select name="billType"  class="billType select" onchange="getBillType(this)">
										<!-- <option value="">请选择</option> -->
										<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
											<option value="${billTypeEnum.value }" >${billTypeEnum.desc }</option>
										</c:forEach>
									</select>
								</td>
							</c:when>
							<c:otherwise>
								<td><input type="text" value="${ratePo.discountList[0].activeDiscount }" class="activeDiscount input-text" name="activeDiscount" id="" placeholder=" 费率折扣" style="width:80px"></td>
								<td><!-- <span class="select-box inline"> -->
									<select class="select-box inline billType select" onchange="getBillType(this)">
										<!-- <option value="">请选择</option> -->
											<!-- 选中列表第一个费率 -->
										<c:forEach items="${ratePo.discountList }" var="disPo" varStatus="vs1">
											<c:if test="${disPo.billType == 1 }">
												<option value="${disPo.id }">
													${disPo.billTypeDesc }-${disPo.activeDiscount }
												</option>
												<c:set var="bill_co" value="1"></c:set>
											</c:if>
											<c:choose>
												<c:when test="${disPo.billType == 0 }">
													<option value="${disPo.id }">
														${disPo.billTypeDesc }-${disPo.activeDiscount }
													</option>
													<c:set var="bill_indi" value="1"></c:set>
												</c:when>
											</c:choose>
										</c:forEach>
										<!-- 补足其他没有设置折扣的 -->
										<c:if test="${empty bill_co }"><!-- 带票为空 -->
											<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
												<c:if test="${1 == billTypeEnum.value }">
													<option value="${billTypeEnum.value }" >${billTypeEnum.desc }</option>
												</c:if>
											</c:forEach>
										</c:if>
										<c:if test="${empty bill_indi }">
											<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
												<c:if test="${0 == billTypeEnum.value }">
													<option value="${billTypeEnum.value }" >${billTypeEnum.desc }</option>
												</c:if>
											</c:forEach>
										</c:if>
												<%-- ${disPo.billType }-${disPo.billTypeDesc }-${disPo.activeDiscount } --%>
									</select>
									<!-- </span> -->
								</td>
							</c:otherwise>
						</c:choose>
						<td><button onclick="addUp(this)" class="btn btn-primary radius">设置</button></td>
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
function getBillType(vart){
	var optionIn = $(vart).find('option:selected').text().trim();
	//alert(optionIn.indexOf('-'));
	
	if(optionIn.indexOf('-') == -1){
		$(vart).parents('td').prev().children('input').val('');//设置折扣
	}else{
		var arr = optionIn.split('-');
		$(vart).parents('td').prev().children('input').val(arr[1]);//设置折扣
		//var billType = arr[0];
		var activeId = $(vart).find('option:selected').val();		//获得上级费率id
		//alert(activeId);
	}
	//alert(arr[1]);
}
/* $().ready(function() {
	
}) */
//添加或者修改代理商的折扣
function addUp(vart){//vart是提交按钮
	var optionIn = $(vart).parents('td').prev().children('.billType').find('option:selected').text().trim();
	var billType = -1;
	//var billType = arr[0];
	//var billType =  $(vart).parents('td').prev().children('.billType').find('option:selected').val();
	var cDiscountId = $(vart).parents('tr').children('.channelDiscountId').html().trim();//通道折扣Id
	var agencyId = $('#childAgencyId').val();//代理商Id
	//alert(agencyId);
	var activeId = $(vart).parents('tr').children('.id').html().trim();//父级折扣Id
	var activeDiscount = $(vart).parents('td').prev().prev().children('.activeDiscount').val().trim();
	var agencyName = $('#agencyName').val();
	
	/* alert(activeId);
	alert(id); */
	//alert(activeDiscount);
	if(activeDiscount != "" && activeDiscount != null){
		//alert(optionIn);
		//alert(optionIn.indexOf('-'));
	if(optionIn.indexOf('-') == -1){//没有自己的折扣
		billType = $(vart).parents('td').prev().children('.billType').find('option:selected').val();
		layer.confirm('确认给'+agencyName+'增加费率吗？',function(index){
			$.ajax({
				type: 'POST',
				async: false,
				url: '/flowsys/rate/add_my_rate.do',
				//dataType: 'json',
				data: { activeDiscount:activeDiscount, activeId:activeId, channelDiscountId:cDiscountId, billType:billType},
				success: function(data){
					layer.close(index);
					layer.msg('更新成功', {icon:5,time:1000});
					location.reload();
				},
				error:function(data) {
					console.log(data.msg);
				},
			});	
		});
		
		//$(vart).removeAttr('disabled');
		//$(vart).attr("disabled",'disabled');
	}else{//有自己的折扣
		var id = $(vart).parents('td').prev().children('.billType').find('option:selected').val();//自己折扣id
		var arr = optionIn.split('-');
		//var nowActiveDis = arr[2];
		if(arr[1] != activeDiscount ){//发送ajax请求
			layer.confirm('确认给'+agencyName+'修改费率吗？',function(index){
				$.ajax({
					type: 'POST',
					async: false,
					url: '/flowsys/rate/add_my_rate.do',
					//dataType: 'json',
					data: {id:id, activeDiscount:activeDiscount},
					success: function(data){
						layer.close(index);
						layer.msg('更新成功', {icon:5,time:1000});
						location.reload();
					},
					error:function(data) {
						console.log(data.msg);
					},
				});	
				
			});
			
		}else{
			alert('已经设置了该折扣');
			//alert(1);
			//$(vart).attr("disabled",'disabled');
		}
	}
	}else{
		alert('折扣不能为空');
	} 
	
	//alert(optionIn);
	//alert(cDiscountId);
}

</script>
