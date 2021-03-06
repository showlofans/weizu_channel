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
<!-- <link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/style.css" /> -->
<link rel="stylesheet" type="text/css" href="/view/mine/paging.css" />
<link rel="stylesheet" href="/view/mine/bootstrap-datetimepicker.css">

<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->

<style type="text/css">
    /* .breadcrumb{ position:fixed; z-index:998} */
</style>
<title>充值列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 订单管理 <span class="c-gray en">&gt;</span> 订单列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
<div class="page-container">
	<div class="text-c">
		<form class="form form-horizontal" action="/flowsys/chargePg/purchase_list.do" method="post" id="formD" name="dataListForm">
				<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
				<div class="row cl formControls">
					<!-- 运营商类型： -->
					<span class="select-box inline">
						<select name="purchaseFor" class="select">
						<!-- <option value="">充值业务</option> -->
						<c:forEach items="${resultMap.pgServiceTypeEnums }" var="pgServicetypeEnum" varStatus="vs2">
							<option value="${pgServicetypeEnum.value }" <c:if test="${pgServicetypeEnum.value == resultMap.searchParams.purchaseFor }"> selected</c:if>>${pgServicetypeEnum.desc }</option>
						</c:forEach>
					</select>
					</span> 
					手机号:<input type="text"  value="${resultMap.searchParams.chargeTel }" name="chargeTel" id="" placeholder=" 手机号" style="width:150px" class="input-text">
					归属地:<input type="text"  value="${resultMap.searchParams.chargeTelDetail }" name="chargeTelDetail" id="" placeholder=" 归属地" style="width:80px" class="input-text">
					所属代理商:<input type="text"  value="${resultMap.searchParams.agencyName }" name="agencyName" id="" placeholder=" 代理商名称" style="width:100px" class="input-text">
					订单号:<input type="text"  value="${resultMap.searchParams.orderId }" name="orderId" id="" placeholder=" 订单号(18位)" style="width:250px" maxlength="19" onkeyup='this.value=this.value.replace(/\D/gi,"")' class="input-text">
				</div>
				
				<div class="row cl" style="margin-top: 30dp">
					<!-- 运营商类型： -->
					<c:choose>
						<c:when test="${resultMap.pgcharge == resultMap.searchParams.purchaseFor }"><!-- 流量充值 -->
							<span class="select-box inline">
								<select name="operatorType" class="select">
								<option value="">运营商类型</option>
								<c:forEach items="${resultMap.operatorTypeEnums }" var="otypeEnum" varStatus="vs2">
									<option value="${otypeEnum.value }" <c:if test="${otypeEnum.value == resultMap.searchParams.operatorType }"> selected</c:if>>${otypeEnum.desc }</option>
								</c:forEach>
							</select>
							</span> 
						</c:when>
						<c:otherwise>
							<span class="select-box inline">
								<select name="operatorName" class="select">
								<option value="">运营商名称</option>
								<c:forEach items="${resultMap.operatorNameEnums }" var="operatorNameEnum" varStatus="vs2">
									<option value="${operatorNameEnum.value }" <c:if test="${operatorNameEnum.value == resultMap.searchParams.operatorName }"> selected</c:if>>${operatorNameEnum.desc }</option>
								</c:forEach>
							</select>
							</span> 
							<span class="select-box inline">
								<select name="chargeSpeed" class="select">
								<option value="">充值速度</option>
								<c:forEach items="${resultMap.telChargeSpeedEnums }" var="chargeSpeedEnum" varStatus="vs2">
									<option value="${chargeSpeedEnum.value }" <c:if test="${chargeSpeedEnum.value == resultMap.searchParams.chargeSpeed }"> selected</c:if>>${chargeSpeedEnum.desc }</option>
								</c:forEach>
							</select>
							</span> 
						</c:otherwise>
					</c:choose>
					&nbsp;&nbsp;
						<!-- 扣款类型： -->
					<%-- <c:choose>
					<c:when test="${loginContext.rootAgencyId == 0 }">
						通道类型：
					</c:when>
					<c:otherwise>
					</c:otherwise>
					</c:choose> --%>
					
					<span class="select-box inline">
						<select name="billType" class="select">
						<option value="">扣款类型</option>
						<c:forEach items="${resultMap.billTypeEnums }" var="bTypeEnum" varStatus="vs2">
							<option value="${bTypeEnum.value }" <c:if test="${bTypeEnum.value == resultMap.searchParams.billType }"> selected</c:if>>${bTypeEnum.desc }</option>
						</c:forEach>
					</select>
					</span> 
					&nbsp;&nbsp;
					<c:if test="${loginContext.rootAgencyId == 0 }">
						通道名称:<input type="text"  value="${resultMap.searchParams.channelName }" name="channelName" id="" placeholder=" 通道名称" style="width:250px" class="input-text">
					</c:if>
					
					 提交时间:
					 <input type="text" style="width:150px" id="arriveStartTimeStr" class="input-text" name="arriveStartTimeStr"  value="${resultMap.searchParams.arriveStartTimeStr }"  onfocus="var arriveEndTimeStr=$dp.$('arriveEndTimeStr');WdatePicker({onpicked:function(){arriveEndTimeStr.focus();},startDate:'%y-%M-%d 00:00:00',autoPickDate:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
		                  	<em class="inputto">至</em>
		            <input style="width:150px" type="text" class="input-text" id="arriveEndTimeStr" name="arriveEndTimeStr"   value="${resultMap.searchParams.arriveEndTimeStr }"  onfocus="WdatePicker({startDate:'%y-%M-%d 23:59:59',autoPickDate:true,dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'arriveStartTimeStr\')}',onpicked:function(){formSub();}})"/>
					
					<button name="" id="" class="btn btn-success" type="submit" onclick="formSub()"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
					<button type="button"class="btn btn-primary" onclick="javascript:location.replace(location.href);" value="重置">重置</button>
					<input type="hidden" name="pageNoLong" value="${resultMap.pagination.pageNoLong }"> 
				</div>
		</form>
	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<!-- <th width="25"><input type="checkbox" name="" value=""></th> -->
					<!-- <th width="80">流量包Id</th> -->
					<th width="100">所属代理商</th>
					<th width="90">号码归属</th>
					<th width="70">业务类型</th>
					<c:if test="${resultMap.pgcharge == resultMap.searchParams.purchaseFor }">
						<th width="50">流量大小</th>
					</c:if>
					<th width="50">面值</th>
					<th width="60">金额</th><!-- 返款 -->
					<th width="90">手机号</th>
					<!-- <th width="150">充值时间</th> -->
					
					<c:if test="${resultMap.pgcharge == resultMap.searchParams.purchaseFor }">
						<th width="60">城市</th>
					</c:if>
					<th width="80">结果</th>
					<th width="100">结果描述</th>
					<th width="130">提交时间</th>
					<c:if test="${loginContext.rootAgencyId == 0 }">
						<th width="80">查看目录</th>
						<th width="140">通道名称</th>
					</c:if>
					<th width="100">充值方式</th>
					<th width="60">扣款类型</th>
					<th width="140">订单号</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="purchase" varStatus="vs">
					<tr class="text-c">
						<td>
							<c:choose>
								<c:when test="${purchase.agencyId == loginContext.id}">
									${purchase.agencyName }
								</c:when>
								<c:otherwise>
										${purchase.agencyName }
									<%-- <a data-toggle="tooltip" data-placement="top" style="text-decoration:none;cursor:pointer" onClick="editAgency(${purchase.agencyId})" href="javascript:;" title="查看代理商">
									</a> --%>
								</c:otherwise>
							</c:choose>
						</td>
						
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
							</td><!-- serviceTypeEnums -->
						 <c:if test="${resultMap.pgcharge == resultMap.searchParams.purchaseFor }">
						 	<td>${purchase.pgSizeStr }</td>
						 	<%-- <td>${purchase.pgSize }M</td> --%>
						 </c:if>
						 
						<td>${purchase.chargeValue }</td>
						<td>
							<span class="c-warning">
								<a style="text-decoration:none;" data-href="/flowsys/account/consume_list.do?purchaseId=${purchase.orderId }&userName=${purchase.agencyName}&pageNo=1&chargeFor=${purchase.purchaseFor}" data-title="订单消费" onclick="Hui_admin_tab(this)" href="javascript:void(0)">
								${purchase.orderPrice }
								</a>
							</span>
							<span class="label label-warning radius">
							</span>
						</td>
						<td>${purchase.chargeTel }</td>
						 <%-- <td>${purchase.orderBackTimeStr }</td> --%>
						<c:if test="${resultMap.pgcharge == resultMap.searchParams.purchaseFor }">
							 <td>${purchase.chargeTelCity }</td>
						</c:if>
						
						<!-- 结果 -->
						<td>
							<c:choose>
								<c:when test="${loginContext.rootAgencyId == 0 }">
									<c:forEach items="${resultMap.orderStateEnums }" var="orderStateEnum" varStatus="vs">
										<c:if test="${purchase.orderResult == orderStateEnum.value }">
											<c:choose>
												<c:when test="${orderStateEnum.value == 0 }">
													<span class="label label-danger radius mark">
														<a style="text-decoration:none;" data-href="/flowsys/chargePg/purchase_list.do?orderResult=${orderStateEnum.value }&purchaseFor=${resultMap.searchParams.purchaseFor }&backStartTimeStr=${resultMap.searchParams.arriveStartTimeStr }&backEndTimeStr=${resultMap.searchParams.arriveEndTimeStr }" data-title="充值失败" href="javascript:void(0)" onclick="Hui_admin_tab(this)">
														${orderStateEnum.desc }
														</a>
													</span>
												</c:when>
												<c:when test="${orderStateEnum.value == 2 }">
													<span class="label label-secondary radius mark">
													<a style="text-decoration:none;" data-href="/flowsys/chargePg/purchase_list.do?orderResult=${orderStateEnum.value }&purchaseFor=${resultMap.searchParams.purchaseFor }&arriveStartTimeStr=${resultMap.searchParams.arriveStartTimeStr }&arriveEndTimeStr=${resultMap.searchParams.arriveEndTimeStr }" data-title="充值进行" href="javascript:void(0)" onclick="Hui_admin_tab(this)">
														${orderStateEnum.desc }
													</a>
													</span>
												</c:when>
												<c:when test="${orderStateEnum.value == 4 }">
													<span class="label label-warning radius mark">
													<a style="text-decoration:none;" data-href="/flowsys/chargePg/purchase_list.do?orderResult=${orderStateEnum.value }&purchaseFor=${resultMap.searchParams.purchaseFor }&arriveStartTimeStr=${resultMap.searchParams.arriveStartTimeStr }&arriveEndTimeStr=${resultMap.searchParams.arriveEndTimeStr }" data-title="充值等待" href="javascript:void(0)" onclick="Hui_admin_tab(this)">
														${orderStateEnum.desc }
													</a>
													</span>
												</c:when>
												<c:otherwise>
													<span class="label label-success radius mark">
													<a style="text-decoration:none;" data-href="/flowsys/chargePg/purchase_list.do?orderResult=${orderStateEnum.value }&purchaseFor=${resultMap.searchParams.purchaseFor }&backStartTimeStr=${resultMap.searchParams.arriveStartTimeStr }&backEndTimeStr=${resultMap.searchParams.arriveEndTimeStr }&agencyName=${purchase.agencyName }" data-title="充值成功" href="javascript:void(0)" onclick="Hui_admin_tab(this)">
														${orderStateEnum.desc }
													</a>
													</span>
												</c:otherwise>
											</c:choose>
										</c:if>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach items="${resultMap.orderStateEnums }" var="orderStateEnum" varStatus="vs">
										<c:if test="${purchase.orderState == orderStateEnum.value }">
											<c:choose>
												<c:when test="${orderStateEnum.value == 0 }">
													<span class="label label-danger radius mark">
														<a style="text-decoration:none;" data-href="/flowsys/chargePg/purchase_list.do?orderState=${orderStateEnum.value }&purchaseFor=${resultMap.searchParams.purchaseFor }&backStartTimeStr=${resultMap.searchParams.arriveStartTimeStr }&backEndTimeStr=${resultMap.searchParams.arriveEndTimeStr }" data-title="充值失败" href="javascript:void(0)" onclick="Hui_admin_tab(this)">
														${orderStateEnum.desc }
														</a>
													</span>
												</c:when>
												<c:when test="${orderStateEnum.value == 2 }">
													<span class="label label-secondary radius mark">
													<a style="text-decoration:none;" data-href="/flowsys/chargePg/purchase_list.do?orderState=${orderStateEnum.value }&purchaseFor=${resultMap.searchParams.purchaseFor }&arriveStartTimeStr=${resultMap.searchParams.arriveStartTimeStr }&arriveEndTimeStr=${resultMap.searchParams.arriveEndTimeStr }" data-title="充值进行" href="javascript:void(0)" onclick="Hui_admin_tab(this)">
														${orderStateEnum.desc }
													</a>
													</span>
												</c:when>
												<c:otherwise>
													<span class="label label-success radius mark">
													<a style="text-decoration:none;" data-href="/flowsys/chargePg/purchase_list.do?orderState=${orderStateEnum.value }&purchaseFor=${resultMap.searchParams.purchaseFor }&backStartTimeStr=${resultMap.searchParams.arriveStartTimeStr }&backEndTimeStr=${resultMap.searchParams.arriveEndTimeStr }" data-title="充值成功" href="javascript:void(0)" onclick="Hui_admin_tab(this)">
														${orderStateEnum.desc }
													</a>
													</span>
												</c:otherwise>
											</c:choose>
										</c:if>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${loginContext.rootAgencyId == 0 }">
										${purchase.orderResultDetail}
								</c:when>
								<c:otherwise>
										${purchase.orderStateDetail }
								</c:otherwise>
							</c:choose>
						</td>
						<td>
								${purchase.orderArriveTimeStr }
							<!-- <span class="label label-defaunt">
							</span> -->
						</td>
						<c:if test="${loginContext.rootAgencyId == 0 }">
						<td class="f-14 td-manage success">
							<a  data-toggle="tooltip" data-placement="top" style="text-decoration:none;cursor:pointer" data-href="/flowsys/chargeLog/charge_log_list.do?orderId=${purchase.orderId }" title="查看传单日志" onclick="Hui_admin_tab(this)" data-title="接口订单日志" href="javascript:void(0)"><i class="Hui-iconfont">&#xe623;</i></a>
							<a data-toggle="tooltip" data-placement="top" style="text-decoration:none;cursor:pointer" onClick="editAgency(${purchase.agencyId})" href="javascript:;" title="查看代理商"><i class="Hui-iconfont">&#xe60a;</i></a>
							<a data-toggle="tooltip" data-placement="top" style="text-decoration:none;cursor:pointer" onClick="getEp('${purchase.orderId }',this)" href="javascript:;" title="查看平台信息"><i class="Hui-iconfont">&#xe72b;</i></a>
						</td> 
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
						<td>
						<%-- <a data-toggle="tooltip" data-placement="top" style="text-decoration:none;cursor:pointer" data-href="/flowsys/chargeLog/charge_log_list.do?orderId=${purchase.orderId }" title="查看传单日志" onclick="Hui_admin_tab(this)" data-title="接口订单日志" href="javascript:void(0)">${purchase.orderId }</a> --%>
						<span data-container="body" data-toggle="popover" data-placement="top" data-content="${purchase.secondOrderId }" <c:if test="${not empty purchase.secondOrderId }"> class="c-warning"</c:if>>
						${purchase.orderId }
						</span>
							<%-- <c:choose>
								<c:when test="${purchase.billType == 0 }">
									<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
										<c:if test="${billTypeEnum.value == 0 }">
											<span class="c-red" data-toggle="tooltip"  data-placement="right" title="${billTypeEnum.desc }"  >
											${purchase.orderId }</span>
										</c:if>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
									<c:if test="${billTypeEnum.value == 1 }">
										<span class="c-green" data-toggle="tooltip"  data-placement="right" title="${billTypeEnum.desc }"><!--   -->
										${purchase.orderId }</span>
									</c:if>
									</c:forEach>
								</c:otherwise>
							</c:choose> --%>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="purchaseId" />  
	</div>
	<footer class="footer mt-20">
		<div class="container">
			<p><!-- 感谢jQuery、layer、laypage、Validform、UEditor、My97DatePicker、iconfont、Datatables、WebUploaded、icheck、highcharts、bootstrap-Switch<br> -->
				Copyright &copy;2017-2018 南昌微族科技有限公司 All Rights Reserved.<br>
				<a href='http://www.miibeian.gov.cn' target='_blank'>赣ICP备18000855号-1</a>
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
<!-- 时间选择器 -->
<!--  <script src="/view/lib/moment.js"></script>
<script src="/view/lib/bootstrap-datetimepicker.min.js"></script>
<script src="/view/lib/bootstrap-datetimepicker.zh-CN.js"></script> -->
<script type="text/javascript">
/* function formSub(){
	$("input[name='pageNoLong']").val('');
	$('form').submit();
} */
/*代理商-编辑*/
function editAgency(id){
	//var $agencyTr = $(obj).parent().parent();//tr标签
	//var $id = $agencyTr.children(0);
	layer.open({
        type: 2,
        title: '查看代理商',
        area: ['800px', '500px'],
        maxmin: false,
        closeBtn: 1,
        content: '/flowsys/agency/child_agency_edit_page.do?id=' + id,
        end: function () {
            //location.reload();
        }
    });
}
/**查看平台信息*/
function getEp(orderId,obj){
	$.ajax({
		type:'post',
		async: false,
		url:'/flowsys/chargePg/ep_in_purchase.do',
		dataType: "json",
		data:{orderId:orderId},
		success: function(data){
			if(data == null || data == 'null'){
				layer.msg('没有找到平台信息！');
			}else{
				layer.msg(data.epName);
				var nextUrl = '/flowsys/platform/platform_list.do';
				nextUrl += '?epName='+data.epName;
				nextUrl += '&epFor='+data.epFor;
				nextUrl += '&id='+data.id;
				$(obj).attr('data-href',nextUrl);
				$(obj).attr("data-title","平台信息查看");
				Hui_admin_tab(obj);
			}
		},
		error:function(data) {
			console.log(data.msg);
		}
	})
}

$(document).ready(function() {
	$('.select').change(function(){
		//$('form').submit();
		$("input[name='pageNoLong']").val('');
		formSub();
	})
	/* $('.purchaseFor').change(function(){//特殊需求
		$("input[name='pageNoLong']").val('');
		$('#arriveStartTimeStr').val(null);
		$('form').submit();
	}) */
}); 
</script> 
</body>
</html>