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
<link rel="stylesheet" href="/view/mine/bootstrap-datetimepicker.css">

<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>充值列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 订单管理 <span class="c-gray en">&gt;</span> 订单列表-充值成功 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
<div class="page-container">
	<div class="text-c">
		<form class="form form-horizontal" action="/flowsys/chargePg/purchase_list.do" method="post" id="formD" name="dataListForm">
				<div class="row cl formControls">
					<span class="select-box inline">
						<select name="purchaseFor" class="select">
						<!-- <option value="">充值业务</option> -->
						<c:forEach items="${resultMap.pgServiceTypeEnums }" var="pgServicetypeEnum" varStatus="vs2">
							<option value="${pgServicetypeEnum.value }" <c:if test="${pgServicetypeEnum.value == resultMap.searchParams.purchaseFor }"> selected</c:if>>${pgServicetypeEnum.desc }</option>
						</c:forEach>
					</select>
					</span> 
					手机号:<input type="text"  value="${resultMap.searchParams.chargeTel }" name="chargeTel" id="" placeholder=" 手机号" style="width:150px" class="input-text">
					所属代理商:<input type="text"  value="${resultMap.searchParams.agencyName }" name="agencyName" id="" placeholder=" 代理商名称" style="width:100px" class="input-text">
					订单号:<input type="text"  value="${resultMap.searchParams.orderId }" name="orderId" id="" placeholder=" 订单号（18位）" maxlength="19" onkeyup='this.value=this.value.replace(/\D/gi,"")' style="width:250px" class="input-text">
					充值时间:
					 <input type="text" style="width:150px" id="backStartTimeStr" class="input-text" name="backStartTimeStr"  value="${resultMap.searchParams.backStartTimeStr }"  onfocus="var backEndTimeStr=$dp.$('backEndTimeStr');WdatePicker({onpicked:function(){backEndTimeStr.focus();},startDate:'%y-%M-%d 00:00:00',autoPickDate:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
		                  	<em class="inputto">至</em>
		            <input style="width:150px" type="text" class="input-text" id="backEndTimeStr" name="backEndTimeStr"   value="${resultMap.searchParams.backEndTimeStr }"  onfocus="WdatePicker({startDate:'%y-%M-%d 23:59:59',autoPickDate:true,dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'backStartTimeStr\')}',onpicked:function(){formSub();}})"/>
				</div>
					
				
				<div class="row cl" style="margin-top: 30dp">
					运营商类型：
					<span class="select-box inline">
						<select name="operatorType" class="select">
						<option value="">请选择</option>
						<c:forEach items="${resultMap.operatorTypeEnums }" var="otypeEnum" varStatus="vs2">
							<option value="${otypeEnum.value }" <c:if test="${otypeEnum.value == resultMap.searchParams.operatorType }"> selected</c:if>>${otypeEnum.desc }</option>
						</c:forEach>
					</select>
					</span> 
						扣款类型：
					<span class="select-box inline">
						<select name="billType" class="select">
						<option value="">请选择</option>
						<c:forEach items="${resultMap.billTypeEnums }" var="bTypeEnum" varStatus="vs2">
							<option value="${bTypeEnum.value }" <c:if test="${bTypeEnum.value == resultMap.searchParams.billType }"> selected</c:if>>${bTypeEnum.desc }</option>
						</c:forEach>
					</select>
					</span> 
					<c:if test="${loginContext.rootAgencyId == 0 }">
						通道名称:<input type="text"  value="${resultMap.searchParams.channelName }" name="channelName" id="" placeholder=" 通道名称" style="width:250px" class="input-text">
					</c:if>
					
					 归属地:<input type="text"  value="${resultMap.searchParams.chargeTelDetail }" name="chargeTelDetail" id="" placeholder=" 归属地" style="width:80px" class="input-text">
					
					<button name="" id="" class="btn btn-success" type="submit" onclick="formSub()"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
					<button type="button"class="btn btn-primary" onclick="javascript:location.replace(location.href);" value="重置">重置</button>
					
					<c:choose>
						<c:when test="${loginContext.rootAgencyId == 0 }">
							<a href="/flowsys/chargePg/export_charged_list.do?chargeTel=${resultMap.searchParams.chargeTel }&agencyName=${resultMap.searchParams.agencyName }&orderId=${resultMap.searchParams.orderId }&chargeTelDetail=${resultMap.searchParams.chargeTelDetail }
											&operatorType=${resultMap.searchParams.operatorType }
											&billType=${resultMap.searchParams.billType }
											&channelName=${resultMap.searchParams.channelName }
											&backStartTimeStr=${resultMap.searchParams.backStartTimeStr }
											&backEndTimeStr=${resultMap.searchParams.backEndTimeStr }
											&purchaseFor=${resultMap.searchParams.purchaseFor }
											&orderResult=${resultMap.searchParams.orderResult }">【导出列表】
							</a>
							<button name="" id="" class="btn btn-primary radius" onclick="batchPush()" type="button"><i class="Hui-iconfont">&#xe665;</i> 批量推送</button>
							<input type="hidden" name="orderResult" value="${resultMap.searchParams.orderResult }">
						</c:when>
						<c:otherwise>
							<a href="/flowsys/chargePg/export_charged_list.do?chargeTel=${resultMap.searchParams.chargeTel }&agencyName=${resultMap.searchParams.agencyName }&orderId=${resultMap.searchParams.orderId }&chargeTelDetail=${resultMap.searchParams.chargeTelDetail }
											&operatorType=${resultMap.searchParams.operatorType }
											&billType=${resultMap.searchParams.billType }
											&channelName=${resultMap.searchParams.channelName }
											&backStartTimeStr=${resultMap.searchParams.backStartTimeStr }
											&backEndTimeStr=${resultMap.searchParams.backEndTimeStr }
											&purchaseFor=${resultMap.searchParams.purchaseFor }
											&orderState=${resultMap.searchParams.orderState }">【导出列表】
							</a>
							<input type="hidden" name="orderState" value="${resultMap.searchParams.orderState }">
						</c:otherwise>
					</c:choose>
					
					<!-- <button name="" id="" class="btn btn-primary radius" onclick="exportS()" type="button"><i class="Hui-iconfont">&#xe665;</i> 导出</button> -->
					<input type="hidden" name="pageNoLong" value="${resultMap.pagination.pageNoLong }"> 
				</div>
		</form>
	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="100">所属代理商</th>
					<th width="80">号码归属</th>
					<th width="70">业务类型</th>
					<c:if test="${resultMap.pgcharge == resultMap.searchParams.purchaseFor }">
						<th width="60">流量大小</th>
					</c:if>
					<th width="50">面值</th>
					<th width="60">扣款</th>
					<th width="60">成本</th>
					<th width="90">手机号</th>
					<c:if test="${resultMap.pgcharge == resultMap.searchParams.purchaseFor }">
						<th width="60">城市</th>
					</c:if>
					<th width="80">结果</th>
					<th width="100">结果描述</th>
					<c:if test="${loginContext.rootAgencyId == 0 }">
					<th width="40">操作</th>
					</c:if>
					<th width="140">提交时间</th>
					<th width="140">充值时间</th>
					<c:if test="${loginContext.rootAgencyId == 0 }">
						<th width="110">通道名称</th>
					</c:if>
					<th width="100">充值方式</th>
					<th width="60">通道类型</th>
					<th width="150">订单号</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="purchase" varStatus="vs">
					<tr class="text-c one">
						<td><c:choose>
							<c:when test="${purchase.agencyId == loginContext.id}">
								${purchase.agencyName }
							</c:when>
							<c:otherwise>
								<a data-toggle="tooltip" data-placement="top" style="text-decoration:none;cursor:pointer" onClick="editAgency(${purchase.agencyId})" href="javascript:;" title="查看代理商">
									${purchase.agencyName }
								</a>
							</c:otherwise>
						</c:choose></td>
						<td>${purchase.chargeTelDetail }</td>
						 <td>
						 	<c:choose>
						 		<c:when test="${resultMap.pgcharge == resultMap.searchParams.purchaseFor }"><!-- 流量订单 -->
									 <c:forEach items="${resultMap.serviceTypeEnums }" var="serviceTypeEnum" varStatus="vs">
										<c:if test="${purchase.serviceType == serviceTypeEnum.value }">
											${serviceTypeEnum.desc }
										</c:if>
									</c:forEach>
						 		</c:when>
						 		<c:otherwise>
									 <c:forEach items="${resultMap.huaServiceTypeEnums }" var="huaServiceTypeEnum" varStatus="vs">
										<c:if test="${purchase.serviceType == huaServiceTypeEnum.value }">
											${huaServiceTypeEnum.desc }
										</c:if>
									</c:forEach>
						 		</c:otherwise>
						 	</c:choose>
						</td>
						 <c:if test="${resultMap.pgcharge == resultMap.searchParams.purchaseFor }">
						 	<td>${purchase.pgSizeStr }</td>
						 	<%-- <td>${purchase.pgSize }M</td> --%>
						 </c:if>
						<td>${purchase.chargeValue }
						<span class="label label-warning radius">
							</span></td>
						<td>${purchase.orderPrice }
						<span class="label label-warning radius">
							</span></td>
						<td>${purchase.orderAmount }
						<span class="label label-warning radius">
							</span></td>
						<td>${purchase.chargeTel }</td>
						
						<c:if test="${resultMap.pgcharge == resultMap.searchParams.purchaseFor }">
							 <td>${purchase.chargeTelCity }</td>
						</c:if>
						<!-- 结果 -->
						<td>
						<c:forEach items="${resultMap.orderStateEnums }" var="orderStateEnum" varStatus="vs">
							<c:if test="${purchase.orderState == orderStateEnum.value }">
								${orderStateEnum.desc }
							</c:if>
						</c:forEach>
						</td>
						<td>${purchase.orderStateDetail }</td>
						<c:if test="${loginContext.rootAgencyId == 0 }">
						<td class="f-14 td-manage success">
							<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="refund(this)" href="javascript:;" title="退款">
								<input type="hidden" value="${purchase.orderId }" >
								<i class="Hui-iconfont">&#xe6e6;</i>
							</a>
						</td>
						</c:if>
						<td>${purchase.orderArriveTimeStr }</td>
						 <td>${purchase.orderBackTimeStr }</td>
						<c:if test="${loginContext.rootAgencyId == 0 }">
						<td>${purchase.channelName }</td> 
						</c:if>
						<!-- 充值方式 -->
						<td>
						<c:forEach items="${resultMap.orderPathEnums }" var="orderPathEnum" varStatus="vsp">
							<c:if test="${purchase.orderPlatformPath == orderPathEnum.value }">
								${orderPathEnum.desc }
							</c:if>
						</c:forEach>
						</td>
						<td>
							<c:forEach items="${resultMap.billTypeEnums }" var="bTypeEnum" varStatus="vs">
								<c:if test="${purchase.billType == bTypeEnum.value }">
									${bTypeEnum.desc }
								</c:if>
							</c:forEach>
						</td>
						
						<td>${purchase.orderId }</td>
					</tr>
				</c:forEach>
				<c:if test="${resultMap.pagination.records != null && resultMap.pagination.records.size() > 0 }">
				<tr>
					<td class="text-r c-success" >总单数</td>
					<td  class="text-l c-warning">${tot.totalRecords }</td>
					<td  class="text-r c-success">总面值</td>
					<td colspan="2" class="text-l c-warning">${tot.totalPrice }</td>
					<td  class="text-r c-success">总扣款</td>
					<td colspan="2"  class="text-l c-warning">${tot.totalAmount }</td>
					<td  class="text-r c-success">总成本</td>
					<td colspan="5"  class="text-l c-warning">${tot.totalCost}</td>
					<c:choose>
						<c:when test="${resultMap.pgcharge == resultMap.searchParams.purchaseFor }">
							<c:choose>
								<c:when test="${loginContext.rootAgencyId == 0 }">
									<td colspan="4"></td>
								</c:when>
								<c:otherwise>
									<td colspan="2"></td>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<c:if test="${loginContext.rootAgencyId == 0 }">
								<td colspan="2"></td>
							</c:if>
						</c:otherwise>
					</c:choose>
				</tr>
				</c:if>
			</tbody>
		</table>
		<mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="purchaseId" />  
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
<script type="text/javascript" src="/view/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<!-- jQuery -->

<script type="text/javascript" src="/view/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
/*代理商-编辑*/
function editAgency(id){
	//var $agencyTr = $(obj).parent().parent();//tr标签
	//var $id = $agencyTr.children(0);
	layer.open({
        type: 2,
        title: '查看APIKey',
        area: ['800px', '500px'],
        maxmin: false,
        closeBtn: 1,
        content: '/flowsys/agency/child_agency_edit_page.do?id=' + id,
        end: function () {
            //location.reload();
        }
    });
}

/**批量推送订单*/
function batchPush(){
	$.ajax({
		type: 'POST',
		url: "/flowsys/chargePg/batch_push_order.do",
		//dataType: 'json',
		data: $('form').serialize(),
		success: function(resp){
			//$(obj).parents("tr").remove();
			//alert
			/* if(resp=="success"){
				layer.msg('批量推送成功',{icon:1,time:1000});
				//location.reload();
           	 }else{
				layer.msg('批量推送失败',{icon:2,time:1000});
           	 } */
			layer.msg(resp,{icon:1,time:1000});
		},
		error:function(resp) {
			console.log(resp.msg);
		}
	}); 
}
/**手动退款*/
function refund(vart){
	var orderId = $(vart).children().eq(0).val();
	var state = 1;//不更新订单状态
	var msg='确认手动退款吗？';
	var msgStr = '手动退款';//更新订单详情
	layer.confirm(msg,function(index){
		$.ajax({
			type: 'POST',
			url: '/flowsys/chargePg/refund.do',
			data: {orderId:orderId, orderResult:state,orderResultDetail:msgStr},
			async: false,
			success: function(data){
				//tag = data;
				 //alert(data);
				if(data=="success")
				{
					layer.msg('手动修改成功',{icon:1,time:1000});
					location.reload();
				}else{
					layer.msg('手动修改失败',{icon:1,time:1000});
				}
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
	
}	
/**导出列表*/
/* function exportS(){
	$.ajax({
        type:"get",
        url:"/flowsys/chargePg/export_charged_list.do",
        data: $('form').serialize(),//表单数据
        async : false,
        success:function(d){
        	//removeIframe();
           /* if(d=="success"){
                layer.msg('提交成功！');//保存成功提示
            }
            if(d=="error"){
                layer.msg('提交异常!');
            } 
        }
    });
} */
/* function formSub(){
	$("input[name='pageNoLong']").val('');
	$('form').submit();
} */
$(document).ready(function() {
	$('.select').change(function(){
		//$('form').submit();
		formSub();
	});
	/* $('.purchaseFor').change(function(){//特殊需求
		$("input[name='pageNoLong']").val('');
		//$('#backStartTimeStr').val('');
		$('form').submit();
	}); */
	
}); 

</script> 
</body>
</html>