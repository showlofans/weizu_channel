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
<style type="text/css">
/* .Hui-iconfont:hover {
	font-size: 25px
} */
	
</style>
<title>充值列表</title>

</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 订单管理 <span class="c-gray en">&gt;</span> 订单列表-充值等待 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
		<form class="form form-horizontal" action="/flowsys/chargePg/purchase_list.do?orderState=3" method="post" id="formD" name="dataListForm">
				<div class="row cl formControls">
					手机号:<input type="text"  value="${resultMap.searchParams.chargeTel }" name="chargeTel" id="" placeholder=" 手机号" style="width:150px" class="input-text">
					所属代理商:<input type="text"  value="${resultMap.searchParams.agencyName }" name="agencyName" id="" placeholder=" 代理商名称" style="width:100px" class="input-text">
					订单号:<input type="text"  value="${resultMap.searchParams.orderId }" name="orderId" id="" placeholder=" 订单号" style="width:250px" class="input-text">
					归属地:<input type="text"  value="${resultMap.searchParams.chargeTelDetail }" name="chargeTelDetail" id="" placeholder=" 归属地" style="width:80px" class="input-text">
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
					<c:choose>
					<c:when test="${loginContext.rootAgencyId == 0 }">
						通道类型：
					</c:when>
					<c:otherwise>
						扣款类型：
					</c:otherwise>
					</c:choose>
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
					
					 提交时间：
					 <input type="text" style="width:150px" id="arriveStartTimeStr" class="input-text" name="arriveStartTimeStr"  value="${resultMap.searchParams.arriveStartTimeStr }"  onfocus="var arriveEndTimeStr=$dp.$('arriveEndTimeStr');WdatePicker({onpicked:function(){arriveEndTimeStr.focus();formSub();},startDate:'%y-%M-%d 00:00:00',autoPickDate:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
		                  	<em class="inputto">至</em>
		            <input style="width:150px" type="text" class="input-text" id="arriveEndTimeStr" name="arriveEndTimeStr"   value="${resultMap.searchParams.arriveEndTimeStr }"  onfocus="WdatePicker({startDate:'%y-%M-%d 23:59:59',autoPickDate:true,dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'arriveStartTimeStr\')}',onpicked:function(){formSub();}})"/>
					
					<button type="button"class="btn btn-success" onclick="javascript:location.replace(location.href);" value="重置">重置</button>
					<button class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
					<input type="hidden" name="pageNo" value="${resultMap.pagination.pageNo }"> 
					<input type="hidden" name="orderResult" value="${resultMap.searchParams.orderResult }">
				</div>
				<!--  <div class="form-group pt5">提交时间：<div class="input-group" style="width:150px"><span class="input-group-addon"><i class="fa fa-calendar ft13em"></i></span> <input type="text" placeholder="开始时间" data-date-format="YYYY-MM-DD HH:mm:ss" name="created_start" id="created_start"></div>--
				<div class="input-group" style="width:150px"><span class="input-group-addon"><i class="fa fa-calendar ft13em"></i></span> <input type="text" placeholder="结束时间" data-date-format="YYYY-MM-DD HH:mm:ss" name="created_end" id="created_end"></div>
				</div>  -->
		</form>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			 <span class="l"><a href="javascript:;" onclick="batchCommit()" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe603;</i> 批量提交</a></span>
		</div>
					
	</div>
	<!-- <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" data-title="添加资讯" data-href="article-add.html" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加资讯</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div> -->
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="100">所属代理商</th>
					<th width="150">订单号</th>
					<th width="100">手机号</th>
					<th width="80">流量大小</th>
					<th width="70">面值</th>
					<th width="150">提交时间</th>
					<th width="150">充值时间</th>
					<th width="100">号码归属</th>
					<th width="60">城市</th>
					<th width="60">充值方式</th>
					<th width="80">结果</th>
					<th width="80">结果描述</th>
					<th width="60">扣款</th>
					<th width="60">操作</th>
					<c:if test="${loginContext.rootAgencyId == 0 }">
						<th width="120">通道名称</th>
					</c:if>
					<th width="60">扣款类型</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="purchase" varStatus="vs">
					<tr class="text-c">
						<td><input type="checkbox" class="ckpur" value="" name=""></td>
						<td style="display:none;">${purchase.accountId }</td>
						<td>${purchase.agencyName }</td>
						<td>${purchase.orderId }</td>
						<td>${purchase.chargeTel }</td>
						 <td>${purchase.pgSize }</td>
						<td>${purchase.pgPrice }</td>
						<td>${purchase.orderArriveTimeStr }</td>
						 <td>${purchase.orderBackTimeStr }</td>
						<td>${purchase.chargeTelDetail }</td>
						<td>${purchase.chargeTelCity }</td>
						<!-- 充值方式 -->
						<td>
						<c:forEach items="${resultMap.orderPathEnums }" var="orderPathEnum" varStatus="vsp">
							<c:if test="${purchase.orderPlatformPath == orderPathEnum.value }">
								${orderPathEnum.desc }
							</c:if>
						</c:forEach>
						</td>
						<!-- 结果 -->
						<td>
						<c:forEach items="${resultMap.orderStateEnums }" var="orderStateEnum" varStatus="vs">
							<c:if test="${purchase.orderResult == orderStateEnum.value }">
								${orderStateEnum.desc }
							</c:if>
						</c:forEach>
						</td>
						
						<td>${purchase.orderResultDetail }</td>
						<td>${purchase.orderPrice }</td>
						<td class="f-14 td-manage">
							<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="changeState(this,'1')" href="javascript:;" title="成功">
								<input type="hidden" value="${purchase.orderId }" >
								<i class="Hui-iconfont">&#xe6e6;</i>
							</a>
							<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="changeState(this,'0')" href="javascript:;" title="失败">
								<input type="hidden" value="${purchase.orderId }" >
								<i class="Hui-iconfont">&#xe6e5;</i>
							</a> 
							<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="ajaxCommit(this,'${purchase.orderId }','${purchase.chargeTelDetail }','${purchase.accountId }')" href="javascript:;" title="提交">
								<input type="hidden" value="${purchase.orderId }" >
								<i class="Hui-iconfont">&#xe6dc;</i>
							</a> 
						</td>
						<c:if test="${loginContext.rootAgencyId == 0 }"><td>${purchase.channelName }</td> 
						</c:if>
						<td>
							<c:forEach items="${resultMap.billTypeEnums }" var="bTypeEnum" varStatus="vs">
								<c:if test="${purchase.billType == bTypeEnum.value }">
									${bTypeEnum.desc }
								</c:if>
							</c:forEach>
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

<script type="text/javascript" charset="utf8" src="/view/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/view/lib/laypage/1.2/laypage.js"></script>
<!-- 时间选择器 -->
<!--  <script src="/view/lib/moment.js"></script>
<script src="/view/lib/bootstrap-datetimepicker.min.js"></script>
<script src="/view/lib/bootstrap-datetimepicker.zh-CN.js"></script> -->
<script type="text/javascript">
/**批量提交*/
function batchCommit(){
	var purchaseIds = "";
	var accountIds = "";
	$(".ckpur:checked").each(function(){ //遍历table里的全部checkbox
       // allcheckbox += $(this).next().html() + ","; //获取所有checkbox的值
        //alert($(this).is(':checked'));
        	accountIds += $(this).next().html() + ","; //获取被选中的代理商id
        	purchaseIds +=  $(this).next().next().next().html() + ",";
    });
        	//alert(accountIds);
	if(accountIds.length > 1) //如果获取到
    {
    	accountIds = accountIds.substring(0, accountIds.length - 1);
    	purchaseIds = purchaseIds.substring(0, purchaseIds.length - 1);
    	alert(purchaseIds);
    	$.ajax({
			type: 'POST',
			url: "",
			//dataType: 'json',
			data: {purchaseIds:purchaseIds,accountIds:accountIds},
			success: function(resp){
				//$(obj).parents("tr").remove();
				//alert
				if(resp=="success"){
					//layer.msg('更新绑定成功',{icon:1,time:1000});
					location.reload();
               	 }else{
					layer.msg('更新绑定失败',{icon:1,time:1000});
               	 }
			},
			error:function(resp) {
				console.log(resp.msg);
			}
		});
    }else{
    	alert("未选中");
    } 
}
function formSub(){
	$('form').submit();
}
$(document).ready(function() {
	$('.select').change(function(){
		//$('form').submit();
		formSub();
	})
}); 
/**手动提交订单*/
function ajaxCommit(vart,orderId,chargeTelDetail,accountId,billType){
	alert(orderId +'<br>' + chargeTelDetail + "<br>" + accountId + "<br>" + billType );
	
	var msg='确认提交订单吗？';
	var msgStr = '手动提交';
	
	layer.confirm(msg,function(index){
		$.ajax({
			type: 'POST',
			url: '/flowsys/chargePg/ajax_commit_order.do',
			//dataType: 'json',
			data: {orderId:orderId, chargeTelDetail:chargeTelDetail, accountId:accountId},
			async: false,
			success: function(data){
				//tag = data;
				 //alert(data);
				if(data=="success")
				{
					layer.msg('手动提交成功',{icon:1,time:1000});
					location.reload();
				}else{
					layer.msg('手动提交失败',{icon:2,time:1000});
				}
			},
			error:function(data) {
				console.log(data.msg);
			},
		});	
	});
}
/**设置状态*/
function changeState(vart,state){
	var orderId = $(vart).children().eq(0).val();
	var tag = "";
	var msg='确认设置成功吗？';
	var msgStr = '手动成功';
	//成功和失败
	if(state==0){
		var msgStr = '手动失败';
		msg='确认设置失败吗？';
	}
	layer.confirm(msg,function(index){
		$.ajax({
			type: 'POST',
			url: '/flowsys/chargePg/update_purchase_state.do',
			//dataType: 'json',
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
		/* if(tag == "success"){
			layer.msg('删除成功', {icon:5,time:1000});
		}
		layer.close(index);
		location.reload(); */
	});
	
}	
	
</script> 
</body>
</html>