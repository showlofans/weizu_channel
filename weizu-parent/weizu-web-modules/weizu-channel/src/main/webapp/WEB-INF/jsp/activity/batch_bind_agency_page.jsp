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
<title>批量绑定代理商</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 通道列表 <span class="c-gray en">&gt;</span> 费率列表 <span class="c-gray en">&gt;</span>绑定代理商 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:closeContextFrame();" title="关闭" >绑定页面<i class="Hui-iconfont">&#xe6a6;</i></a> </nav>
<div class="page-container">
	<!-- <a href="getRegisterPage.do">生成代理商注册页面</a> -->
	<div class="text-c">
		<c:forEach items="${resultMap.scopeCityEnums }" var="scopeEnum" varStatus="vs">
			<c:if test="${scopeEnum.value == ratePo.scopeCityCode }">${scopeEnum.desc }</c:if>
		</c:forEach>
		<c:forEach items="${resultMap.stypeEnums }" var="stype" varStatus="vs1">
			<c:if test="${ stype.value == ratePo.serviceType }">
				${stype.desc }
			</c:if>
		</c:forEach>
		<c:forEach items="${resultMap.otypeEnums }" var="otype" varStatus="vs1">
			 <c:if test="${ratePo.operatorType == otype.value }">
				${otype.desc }
			</c:if>	
		</c:forEach>
		<c:forEach items="${resultMap.billTypeEnums }" var="billEnum" varStatus="vs">
			<span id="billTypeDesc"  class="c-red">
			<c:if test="${ratePo.billType==billEnum.value }">${billEnum.desc }</c:if>
			</span>
		</c:forEach>
		<span id="billTypeDesc"  class="c-red">
			${ratePo.activeDiscount }  
		</span>
		<span id="specialTag"  class="c-red">
			 ${ratePo.specialTag }
		</span>
	</div>
	<div class="text-c">
		<form action="/flowsys/rate/batch_bind_agency_page.do" method="post" id="formD" name="dataListForm">
				<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
				<%-- <input type="hidden" id="scopeCityCode" value="${resultMap.ratePo.scopeCityCode }" >
				<input type="hidden" id="serviceType" value="${resultMap.ratePo.serviceType }" >
				<input type="hidden" id="operatorType" value="${resultMap.ratePo.operatorType }" > --%>
				<input type="hidden" id="billType" name="billType" value="${ratePo.billType }" >
				<%-- <input type="hidden" id="activeDiscount" value="${resultMap.ratePo.activeDiscount }" > --%>
				代理类型：<span class="select-box inline">
						<select name="agencyTag" id="agencyTag" class="select" onchange="onSub()">
						<!-- <option value="">请选择</option> -->
						<c:forEach items="${resultMap.agencyTagEnums }" var="agencyTagEnum" varStatus="vst">
							<option value="${agencyTagEnum.value }" <c:if test="${agencyTagEnum.value == resultMap.aardto.agencyTag }"> selected</c:if>>${agencyTagEnum.desc }</option>
						</c:forEach>
					</select>
				</span>
				绑定状态：<span class="select-box inline">
						<select name="bindState" id="bindState" class="select" onchange="onSub()">
						<!-- <option value="">请选择</option> -->
						<c:forEach items="${resultMap.bindStateEnums }" var="bState" varStatus="vst">
							<option value="${bState.value }" <c:if test="${bState.value == resultMap.aardto.bindState }"> selected</c:if>>${bState.desc }</option>
						</c:forEach>
					</select>
				</span>
				
				代理商名称:<input type="text"  value="${resultMap.aardto.agencyName }" name="agencyName" id="" placeholder=" 代理商名称" style="width:150px" class="input-text">
				<!-- <button type="reset"class="btn btn-success" value="重置">重置</button> -->
				备注信息:<input type="text"  value="${resultMap.aardto.agencyMark }" name="agencyMark" id="" placeholder=" 用户备注" style="width:150px" class="input-text">
				<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
				<c:choose>
					<c:when test="${resultMap.aardto.bindState==1 }"><!-- 已解绑：批量绑定 -->
						<a style="text-decoration:none" data-toggle="tooltip" class="btn btn-success" data-placement="top"  onClick="changeBState('/flowsys/rate/batch_update_bind_state.do',0)" href="javascript:;" title="批量绑定"><i class="Hui-iconfont">&#xe60e;</i>批量绑定</a>
						<a style="text-decoration:none" data-toggle="tooltip" class="btn btn-success" data-placement="top"  onClick="changeBAllState('/flowsys/rate/batch_bind_allagency.do',1,0)" href="javascript:;" title="全量绑定"><i class="Hui-iconfont">&#xe60e;</i>全量绑定</a>
					</c:when>
					<c:otherwise><!-- 未绑定 -->
						<a style="text-decoration:none" data-toggle="tooltip" class="btn btn-success" data-placement="top"  onClick="changeBAllState('/flowsys/rate/batch_bind_allagency.do',2,0)" href="javascript:;" title="全量增加"><i class="Hui-iconfont">&#xe60e;</i>全量增加</a>
						<a style="text-decoration:none" name="" id="" class="btn btn-success"  type="button" onclick="changeBState('/flowsys/rate/batch_bind_agency.do',0)" href="javascript:;" > 批量增加</a>
					</c:otherwise>
				</c:choose>
				<%-- <c:forEach items="${resultMap.bindStateEnums }" var="bState" varStatus="vst">
					<c:if test="${bState.value == resultMap.searchParams.bindState }"> selected</c:if>
				</c:forEach> --%>
				<input type="hidden" name="pageNo" value="${resultMap.pagination.pageNo }"> 
				<input type="hidden" id="rateDiscountId" name="rateDiscountId" value="${resultMap.aardto.rateDiscountId }"> 
		</form>
	</div>
	<!-- <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" data-title="添加资讯" data-href="article-add.html" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加资讯</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div> -->
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<!-- <th width="80">流量包Id</th> -->
					<th width="80">代理名称</th>
					<th width="80">真实姓名</th>
					<th width="80">邮箱</th>
					<!-- <th width="60">费率</th>
					<th width="60">带票费率</th> -->
					<!-- <th width="120">操作</th> -->
					<c:if test="${resultMap.aardto.bindState==1  }">
						<th width="120">解绑时间</th>
					</c:if>
					<%-- <c:choose>
						<c:when test="${resultMap.aardto.bindState==1  }">|| resultMap.aardto.bindState==null
							<th width="120">解绑时间</th>
						</c:when>
						<c:otherwise>
							<th width="120">创建时间</th>
						</c:otherwise>
					</c:choose> --%>
					<th width="80">联系电话</th>
					<th width="80">用户备注</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="agency" varStatus="vs">
					<tr class="text-c font-red">
						<td><input type="checkbox" value="${agency.accountId }" name="agencyCheck"></td>
						<td style="display:none">${agency.accountId }</td>
						<td>${agency.userName }</td>
						<td>${agency.userRealName }</td>
						<!-- <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','article-zhang.html','10001')" title="查看">资讯标题</u></td> -->
						 <td>${agency.userEmail }</td>
						<%-- <td>${agency.agencyIp }</td> --%>
						<td style="display:none">${loginContext.id }</td>
						<c:if test="${resultMap.aardto.bindState==1  }"><td>${agency.createTimeStr }</td></c:if>
						<td>${agency.agencyTel }</td>
						<td>${agency.agencyMark }</td>
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
<!-- <script type="text/javascript" src="/view/lib/My97DatePicker/4.8/WdatePicker.js"></script>  -->
<!-- jQuery -->

<!-- <script type="text/javascript" charset="utf8" src="/view/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> -->
<script type="text/javascript" src="/view/lib/laypage/1.2/laypage.js"></script>
<!-- 时间选择器 -->
<!--  <script src="/view/lib/moment.js"></script>
<script src="/view/lib/bootstrap-datetimepicker.min.js"></script>
<script src="/view/lib/bootstrap-datetimepicker.zh-CN.js"></script> -->
<script type="text/javascript">
function onSub(){
	$('form').submit();
}
//关闭当前弹出层
function closeContextFrame(){
	 var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	parent.layer.close(index); // 执行关闭
}
/**绑定全部代理商**/
function changeBAllState(url,bindState, updateBindState){
	var rateDiscountId = $('#rateDiscountId').val();
	var billType = $('#billType').val();
	var agencyTag = $('#agencyTag').val();
	//var bindState = $('#bindState').val();
	var agencyName = $('#agencyName').val();
	var agencyMark = $('#agencyMark').val();
	var msg = "确认要全量绑定所有查询得到的代理商？";
	layer.confirm(msg,function(index){
		$.ajax({
			type: 'POST',
			url: url,
			//dataType: 'json',
			data: {updateBindState:updateBindState,rateDiscountId:rateDiscountId,billType:billType,agencyTag:agencyTag,agencyName: agencyName,agencyMark: agencyMark,bindState: bindState},
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
	});
}

/**批量更新绑定状态*/
function changeBState(url,bindState){
	var rateDiscountId = $('#rateDiscountId').val();
	var accountIds = "";
	$("input[name=agencyCheck]").each(function(){ //遍历table里的全部checkbox
       // allcheckbox += $(this).next().html() + ","; //获取所有checkbox的值
        //alert($(this).is(':checked'));
       if($(this).is(':checked')) //如果被选中
        	accountIds += $(this).parent().next().html() + ","; //获取被选中的值
        	//alert(accountIds);
    });
	if(accountIds.length > 1) //如果获取到
    {
    	accountIds = accountIds.substring(0, accountIds.length - 1);
    	//alert(accountIds);
    	$.ajax({
			type: 'POST',
			url: url,
			//dataType: 'json',
			data: {bindState: bindState,rateDiscountId:rateDiscountId,accountIds:accountIds},
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
</script> 
</body>
</html>