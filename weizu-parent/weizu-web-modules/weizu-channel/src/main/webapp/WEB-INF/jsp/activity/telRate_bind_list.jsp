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
<title>话费折扣列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 通道管理  <span class="c-gray en">&gt;</span> 话费通道列表  <span class="c-gray en">&gt;</span> 折扣信息 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<!-- <a href="getRegisterPage.do">生成代理商注册页面</a> -->
	<div class="text-c">
		<form action="/flowsys/telRate/bind_telRate_list.do" method="post" id="formD" name="formD">
				<%-- 通道名称：<sapn class="c-red" data-toggle="tooltip" data-placement="bottom" title="${resultMap.specialTag }">${resultMap.channelName }</sapn> --%>
			话费类型:
		<span class="c-red">
			<c:forEach items="${resultMap.billTypeEnums }" var="billEnum" varStatus="vs">
				<c:if test="${resultMap.telChannelParams.billType == billEnum.value }">
					${billEnum.desc } 
				</c:if>
			</c:forEach>
			<c:forEach items="${resultMap.huaServiceTypeEnums }" var="huaStype" varStatus="vs1">
				<c:if test="${resultMap.telChannelParams.serviceType == huaStype.value }">
					<input type="hidden" id="serviceType" name="serviceType" value="${huaStype.value }">
					${huaStype.desc } 
				</c:if>
			</c:forEach>
			<c:forEach items="${resultMap.operatorNameEnums }" var="operatorNameEnum" varStatus="vs2">
				<c:if test="${resultMap.telChannelParams.operatorName == operatorNameEnum.value }">
					
							${operatorNameEnum.desc } 
						<input type="hidden" id="operatorName" name="operatorName" value="${operatorNameEnum.value }">
				</c:if>
			</c:forEach>
		</span>
			
			
			通道折扣：<span id=""  class="c-red">${resultMap.telChannelParams.telchannelDiscount }</span>
			话费价值：<span id=""  class="c-red">${resultMap.telChannelParams.chargeValue }</span>
			</sapn>
				地区：<span id=""  class="c-red">${resultMap.telChannelParams.province } &nbsp;${resultMap.telChannelParams.city } </span>
				<br>
			<br>
			<!-- 搜索条件 -->
				折扣类型
				<span class="select-box inline">
						<select name="billType" id="billType" class="select" onchange="setDiscount()">
							<c:forEach items="${resultMap.billTypeEnums }" var="billEnum" varStatus="vs">
								<option value="${billEnum.value }" <c:if test="${resultMap.tbaVO.billType==billEnum.value }">selected</c:if>>${billEnum.desc }</option>
							</c:forEach>
						</select>
				</span>
				折扣:
				<span class="select-box inline">
					<select name="telRateId" id="telRateId" class="select" onchange="dischange()">
						<c:if test="${empty resultMap.telrateList }">
							<option value="">没有配置折扣</option>
						</c:if>
						<c:forEach items="${resultMap.telrateList }" var="telRatePo" varStatus="vs1">
							<option value="${telRatePo.id }" <c:if test="${telRatePo.id == resultMap.tbaVO.telRateId }"> selected</c:if>>${telRatePo.activeDiscount }</option>
						</c:forEach>
					</select>
				</span>
				<%-- <input type="hidden" id="rateId" name="rateId" value="${resultMap.rateId }"> --%>
				<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
				<%-- 代理商名称:<input type="text" value="${resultMap.params.rateName }" name="rateName" id="" placeholder=" 代理商名称" style="width:150px" class="input-text">
				移动省份:<input type="text" value="${resultMap.params.ratePrice0 }" name="ratePrice0" id="" placeholder=" 移动省份" style="width:150px" class="input-text">
				联通省份:<input type="text" value="${resultMap.params.ratePrice1 }" name="ratePrice1" id="" placeholder=" 联通省份" style="width:150px" class="input-text">
				电信省份:<input type="text" value="${resultMap.params.ratePrice2 }" name="ratePrice2" id="" placeholder=" 电信省份" style="width:150px" class="input-text"> --%>
				<a style="text-decoration:none" name="" id="" class="btn btn-success"  type="button" onclick="addRate('/flowsys/rate/bind_rate_add_page.do','折扣添加')" href="javascript:;" > 添加折扣</a>
				<a style="text-decoration:none" name="" id="" class="btn btn-success"  type="button" onclick="editRate('/flowsys/rate/bind_rate_add_page.do','折扣编辑')" href="javascript:;" > 修改折扣</a>
				<a style="text-decoration:none" name="" id="" class="btn btn-success"  type="button" onclick="delRateDiscount()" href="javascript:;" > 删除折扣</a> 
				<br><br>
				代理商名称： <input type="text" style="width:150px;" class="input-text ac_input" value="${resultMap.tbaVO.agencyName }" autocomplete="off" id="agencyName" name="agencyName">
				<button name="" id="" class="btn btn-success"  type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
				<input type="hidden" id="pageNoLong" name="pageNoLong" value="${resultMap.pagination.pageNoLong }"> 
		</form>
	</div> 
		<div class="mt-20">
			 <a style="text-decoration:none" class="btn btn-success" onClick="batch_bind('绑定代理商',' /flowsys/rate/batch_bind_agency_page.do','10001')" href="javascript:;" title="绑定代理商"><i class="Hui-iconfont">&#xe6df;</i>绑定代理商</a>
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<!-- <th width="25"><input type="checkbox" name="" value=""></th> -->
					<th>代理商名称</th>
					<!-- <th>通道折扣</th>
					<th>移动折率</th>
					<th>联通折率</th>
					<th>电信折率</th> -->
					<th>绑定状态</th>
					<th>添加时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="activePo" varStatus="vs">
					<tr class="text-c">
						<!-- <td><input type="checkbox" value="" name=""></td> -->
						<td>${activePo.agencyName }</td>
						<td><c:forEach items="${resultMap.bindStateEnums }" var="bindStateEnum" varStatus="vs1">
							<c:if test="${activePo.bindState == bindStateEnum.value }"> ${bindStateEnum.desc }</c:if>
							</c:forEach>
						</td>
						<td>${activePo.activeTimeStr }</td>
						
						<td class="td-manage">
						<c:choose>
							<c:when test="${activePo.bindState == 0 }">
								<a style="text-decoration:none" data-toggle="tooltip" data-placement="top"  onClick="changeBState('/flowsys/rate/update_bind_state.do',${activePo.id },'${activePo.agencyName }',1)" href="javascript:;" title="解绑"><i class="Hui-iconfont">&#xe605;</i></a> 
							</c:when>
							<c:otherwise>
								<a style="text-decoration:none" data-toggle="tooltip" data-placement="top"  onClick="changeBState('/flowsys/rate/update_bind_state.do',${activePo.id },'${activePo.agencyName }',0)" href="javascript:;" title="绑定"><i class="Hui-iconfont">&#xe60e;</i></a> 
							</c:otherwise>
						</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%-- <c:if test="${empty pagination }">
			
		</c:if> --%>
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
<!-- jQuery -->

<!-- <script type="text/javascript" src="/view/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" charset="utf8" src="/view/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> -->
<script type="text/javascript" src="/view/lib/laypage/1.2/laypage.js"></script>
<!-- 时间选择器 -->
<!--  <script src="/view/lib/moment.js"></script>
<script src="/view/lib/bootstrap-datetimepicker.min.js"></script>
<script src="/view/lib/bootstrap-datetimepicker.zh-CN.js"></script> -->
<script type="text/javascript">
/* $(document).ready(function(){ 
	$('#formD').submit();
}); */
/**删除折扣*/
function delRateDiscount(){
	var activeDiscount = $("#rateDiscountId option:selected").text();
	layer.confirm('确认删除<br>'+ activeDiscount +'折扣<br>并解除所有的绑定吗？',function(index){
		var rateDiscountId = $("#rateDiscountId").val();
		$.ajax({
			type: 'POST',
			async: false,
			url: '/flowsys/rate/del_rate.do',
			//dataType: 'json',
			data: {rateDiscountId:rateDiscountId},
			success: function(data){
				//tag = data;
				//alert(data);
				if(data=="success")
				{
					layer.close(index);
					layer.msg('折扣删除成功', {icon:5,time:1000});
					//alert(tag);
					//location.reload();
					var selectedVar = $("#rateDiscountId option:selected").next().val();
					//alert(selectedVar);
					$("#rateDiscountId").val(selectedVar);
					$('#pageNoLong').val("1");
					$('#formD').submit();
				}
				/* else if(data == "exist"){
					layer.msg('该折扣已存在，所以更新绑定失败!',{icon:1,time:1000});
				} else{
					layer.msg('或许没有绑定代理商，所以更新绑定失败!',{icon:1,time:1000});
				} */
			},
			error:function(data) {
				console.log(data.msg);
			},
		});	
		/* if(tag == "success"){
			
		} */
		//layer.close(index);
		//location.reload();
	});
}

/*批量绑定代理商页面 */
function batch_bind(title,url,id,w,h){
	var rateDiscountId = $("#rateDiscountId").val();
	var activeDiscount = $("#rateDiscountId option:selected").text();
	var scopeCityCode = $('#scopeCityCode').val();
	var serviceType = $('#serviceType').val();
	var operatorType = $('#operatorType').val();
	var billType = $('#billTypeRate').val();
	var specialTag = $('#specialTag').val();
	//alert(rateDiscountId);
	if(rateDiscountId == ""){
		alert("没有可选的折扣！");
	}else{
		url = url + '?scopeCityCode='+scopeCityCode+'&serviceType='+serviceType+'&specialTag='+specialTag+'&operatorType='+operatorType+'&billType='+billType + '&rateDiscountId=' + rateDiscountId + '&activeDiscount=' + activeDiscount; 
		var index = layer.open({
			type: 2,
			title: title,
			content: url,
			 end: function () {
	            location.reload();
	        }
		});
		layer.full(index);
	}
}

//onchange获得折扣
function dischange(){
	//alert(1);
	$('#pageNoLong').val("1");
	$('#formD').submit();
}
//更新绑定状态
function changeBState(url,activeId,agencyName,bindS){
	//alert(agencyName);
	var cDId = $("#channelDiscountId").val();
	var activeDiscount = $("#rateDiscountId option:selected").text(); 
	//alert(cDId);
	var bindConfirm = "";
	var bindState = -1;
	if(bindS==1){
		bindConfirm = '解绑';
		bindState = 0;
	}else{
		bindConfirm = '绑定';
		bindState = 1;
	}
	layer.open({
        type: 2,
       // title: title,
        area: ['530px', '510px'],
        maxmin: false,
        shadeClose: true,
        shade: 0.4,
        content: '/flowsys/rate/update_bind_state_confirm.do?channelDiscountId=' + cDId+'&activeDiscount='+activeDiscount+'&agencyName='+agencyName+'&bindState='+bindState,
        btn: [bindConfirm,'关闭'],
        yes: function(index){
            //当点击‘确定’按钮的时候，获取弹出层返回的值
           // var res = window["layui-layer-iframe" + index].callbackdata();
            //打印返回的值，看是否有我们想返回的值。
            //console.log(res);
            //最后关闭弹出层
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
            layer.close(index);
        },
        cancel: function(){
            //右上角关闭回调
        }
    });
}


//onchange获得选中的option,设置折扣列表
function setDiscount(){
	//var scopeCityCode = $('#selDiscount option:selected').val();
	var scopeCityCode = $('#scopeCityCode').val();
	var serviceType = $('#serviceType').val();
	var operatorType = $('#operatorType').val();
	var billType = $('#billTypeRate').val();
	//alert(scopeCityCode);
	$.ajax({
		type: 'POST',
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		url: '/flowsys/rate/get_discount.do?scopeCityCode='+scopeCityCode+'&serviceType='+serviceType+'&operatorType='+operatorType+'&billType='+billType,
		dataType: 'json',
		success: function(resp){
			//$(obj).parents("tr").remove();
			$("#rateDiscountId").empty();
			//alert(resp);
			//alert(resp.length);
   		 if(resp.length == 0){ //如果没有通道信息，就设置折扣为不可编辑
   			 $("#rateDiscountId").append("<option value=''>没有添加折扣</option>");
   		 }else{
	   		 //如果resp没有值，下面函数也不会执行
	       	 $.each(resp, function(i, item) {
	            	 $("#rateDiscountId").append("<option class='activeDiscount' value='"+item.id+"'>" + item.activeDiscount + "</option>");//"+ operatorType +"
	            	 $('#rateId').val(item.id);
	            	 $('#channelDiscountId').val(item.channelDiscountId);
	       		 //alert(i);//从0开始
	   				//alert(item.channelName);
	       		 ///不管有没有通道
	          });
   		 }
   		 $('#pageNoLong').val("1");
	      $('#formD').submit();
       	//location.reload();//重新加载最新折扣的数据
   		 
			//layer.msg('添加成功!',{icon:1,time:1000});
		},
		error:function(resp) {
			console.log(resp.msg);
		},
	});	
}

/*折扣-添加页面 */
function addRate(url,title){
	//alert("sd");
	var cDId = $("#channelDiscountId").val();
	//var billType = $("#billTypeRate").val();
	//var cId = $('channelId').val();
	//layer_show(title,url+'?channelDiscountId=' + cDId,'','510');
	//location.reload();
	layer.open({
        type: 2,
        title: title,
        area: ['530px', '510px'],
        maxmin: false,
        closeBtn: 1,
        content: url+'?channelDiscountId=' + cDId + '&fromTag=add',
         end: function () {
            location.reload();
        }
    });
}
/*折扣-编辑页面 */
function editRate(url,title){
	//alert("sd");
	var cDId = $("#channelDiscountId").val();
	var rateDiscountId = $("#rateDiscountId").val();
	if(rateDiscountId == ""){
		alert("没有选择可修改的折扣！");
	}else{
		var rateDiscount = $("#rateDiscountId option:selected").text();
		//alert(rateDiscount);
		var billType = $("#billTypeRate").val();
		//layer_show(title,url+'?channelDiscountId=' + cDId,'','510');
		//location.reload();
		layer.confirm('要修改折扣必须先解除所有绑定了该折扣的代理商的绑定，\t确认要解除所有的绑定吗？',function(index){
			$.ajax({
				type: 'POST',
				async: false,
				url: '/flowsys/rate/batch_update_bind_state.do',
				//dataType: 'json',
				data: {rateDiscountId:rateDiscountId, bindState:1},
				success: function(data){
					//tag = data;
					//alert(data);
					if(data=="success")
					{
						layer.close(index);
						layer.msg('更新绑定成功', {icon:5,time:1000});
						//alert(tag);
						layer.open({
					        type: 2,
					        title: title,
					        area: ['530px', '510px'],
					        maxmin: false,
					        closeBtn: 1,
					        content: url+'?rateDiscountId=' + rateDiscountId+ '&channelDiscountId='+cDId+ '&billType='+billType + '&fromTag=edit',  
					         end: function () {
					          	  location.reload();
					        }
					    });
						//location.reload();
					}
					/* else if(data == "exist"){
						layer.msg('该折扣已存在，所以更新绑定失败!',{icon:1,time:1000});
					} else{
						layer.msg('或许没有绑定代理商，所以更新绑定失败!',{icon:1,time:1000});
					} */
				},
				error:function(data) {
					console.log(data.msg);
				},
			});	
		});
	}
}
</script> 
</body>
</html>