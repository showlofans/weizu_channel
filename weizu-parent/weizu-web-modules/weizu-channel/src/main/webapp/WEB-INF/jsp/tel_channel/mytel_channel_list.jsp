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
<script type="text/javascript">
</script>
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>话费通道列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 我的通道 <span class="c-gray en">&gt;</span> 话费通道列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
	<form class="form form-horizontal" action="/flowsys/my_channel/tel_channel_list.do" method="post" id="formD" name="dataListForm">
		<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
	<div class="row cl formControls">
		<%-- <span class="select-box inline">
			<select name="pgServiceType" id="pgServiceType" class="select c-green"  onchange="submitForm()">
			<!-- <option value="">包体类型</option> -->
			<c:forEach items="${resultMap.pgServiceTypeEnums }" var="pgServiceTypeEnum" varStatus="vs1">
				<option value="${pgServiceTypeEnum.value }" <c:if test="${pgServiceTypeEnum.value == resultMap.params.pgServiceType }"> selected</c:if>>${pgServiceTypeEnum.desc }</option>
			</c:forEach>
		</select>
		</span>
		&nbsp;&nbsp; --%>
		 业务类型：
		 <span class="select-box inline">
			<select name="serviceType" class="select" onchange="submitForm()">
				<!-- <option value="">业务类型</option> -->
				<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceTypeEnum" varStatus="vs1">
					<option value="${serviceTypeEnum.value }" <c:if test="${serviceTypeEnum.value == resultMap.params.serviceType }"> selected</c:if>>${serviceTypeEnum.desc }</option>
				</c:forEach>
			</select>
		</span> 
		&nbsp;&nbsp;
		<!--  地区省份： -->
		 <span class="select-box inline">
			<select name="provinceid" id="provinceid" class="select" onchange="province_change(this.value);">
				<option value="">省份</option>
				<c:forEach items="${resultMap.provinces }" var="province" varStatus="vs1">
					<option <c:if test="${province.provinceid == resultMap.params.provinceid }"> selected</c:if> value="${province.provinceid }" >${province.province }</option><!-- <c:if test="${serviceTypeEnum.value == resultMap.params.serviceType }"> selected</c:if> -->
				</c:forEach>
			</select>
		</span> 
		 <!--  地区城市： -->
		 <c:if test="${resultMap.city ==  resultMap.params.serviceType}">
		 <span class="select-box inline">
			<select class="select" id="city" name="cityid" onchange="submitForm()">
				<option value="">城市</option>
			</select>
		</span> 
		</c:if>
		 
		<input type="hidden" value="${resultMap.params.cityid }" id="cityid" >
		&nbsp;&nbsp;
		 <!--  运营商类型： -->
		 <span class="select-box inline">
			<select name="operatorName" class="select"  onchange="submitForm()">
				<option value="">运营商名称</option>
				<c:forEach items="${resultMap.operatorNameEnums }" var="operatorNameEnum" varStatus="vs1">
					<option value="${operatorNameEnum.value }" <c:if test="${operatorNameEnum.value == resultMap.params.operatorName }"> selected</c:if>>${operatorNameEnum.desc }</option>
				</c:forEach>
			</select>
		</span> 
		&nbsp;&nbsp;
		 <!--  充值类型： -->
		 <span class="select-box inline">
			<select name="telchargeSpeed" class="select"  onchange="submitForm()">
				<option value="">充值速度</option>
				<c:forEach items="${resultMap.telchargeSpeedEnums }" var="telchargeSpeedEnum" varStatus="vs1">
					<option value="${telchargeSpeedEnum.value }" <c:if test="${telchargeSpeedEnum.value == resultMap.params.chargeSpeed }"> selected</c:if>>${telchargeSpeedEnum.desc }</option>
				</c:forEach>
			</select>
		</span> 
		
		限制描述:<input type="text" value="${resultMap.params.limitDescription }" name="limitDescription" id="" placeholder="限制描述" style="width:80px" class="input-text">
		<%-- &nbsp;&nbsp;
			<!-- 包状态 -->
		<span class="select-box inline">
			<select name="pgInService" class="select"  onchange="submitForm()">
			<option value="">包状态</option>
			<c:forEach items="${resultMap.pgInEnums }" var="pgIn" varStatus="vs1">
				<option value="${pgIn.value }" <c:if test="${pgIn.value == resultMap.params.pgInService }"> selected</c:if>>${pgIn.desc }</option>
			</c:forEach>
		</select>
		</span> --%>
	</div>
	<!-- 第二行搜索 -->
	<div class="row cl" style="margin-top: 30dp">
		<%-- <c:if test="${loginContext.rootAgencyId == 0 }"> --%>
		<%-- 平台名称：<input type="text" value="${resultMap.params.epName }" name="epName" id="" placeholder="平台名称" style="width:80px" class="input-text"> --%>
		折扣类型:
		<span class="select-box inline">
			<select name="rateFor" id="rateFor" class="select" onchange="submitForm()">
				<!-- <option value="">折扣类型</option> -->
				<c:forEach items="${resultMap.telChannelTagEnums }" var="telChannelTagEnum" varStatus="vs1">
					<option value="${telChannelTagEnum.value }" <c:if test="${telChannelTagEnum.value == resultMap.params.rateFor }"> selected</c:if>>${telChannelTagEnum.desc }</option>
				</c:forEach>
			</select>
			<%-- <input type="hidden" class="input-text" name="rateFor" id="rateFor"  value="${resultMap.rateFor }" placeholder=""> --%>
		</span>
		&nbsp;&nbsp;
		<%-- <span class="select-box inline">
			<select name="telchannelState" class="select" onchange="submitForm()">
			<option value="">通道状态</option>
			<c:forEach items="${resultMap.channelStateEnums }" var="cstate" varStatus="vs1">
				<option value="${cstate.value }" <c:if test="${cstate.value == resultMap.params.telchannelState }"> selected</c:if>>${cstate.desc }</option>
			</c:forEach>
		</select>
		</span>
		&nbsp;&nbsp;
		<span class="select-box inline">
			<select name="telchannelUseState" class="select" onchange="submitForm()">
			<option value="">通道使用状态</option>
			<c:forEach items="${resultMap.channelUseStateEnums }" var="cstate" varStatus="vs1">
				<option value="${cstate.value }" <c:if test="${cstate.value == resultMap.params.telchannelUseState }"> selected</c:if>>${cstate.desc }</option>
			</c:forEach>
		</select>
		</span>
		&nbsp;&nbsp; --%>
		  话费价值:<input type="text" value="${resultMap.params.chargeValue }" name="chargeValue" id="" placeholder="话费价值" style="width:100px" class="input-text">
		<%-- 流量大小:<input type="text" value="${resultMap.params.pgSize }" name="pgSize" id="" placeholder="大小" style="width:80px" class="input-text">
		原价：<input type="text" value="${resultMap.params.pgPrice }" name="pgPrice" id="" placeholder=" 原价" style="width:80px" class="input-text">元 --%>
		<button name="" id=""  class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜话费</button>
		<button type="button" class="btn btn-success" onclick="javascript:location.replace(location.href);" value="重置">重置</button>
		<!-- <a style="text-decoration:none" class="btn btn-success" onClick="telPc_add('话费编码添加','/flowsys/tel_telchannel/teltelchannel_add_page.do')" href="javascript:;" title="添加"><i class="Hui-iconfont">&#xe600;</i>添加</a> -->
		<input type="hidden" name="pageNoLong" value="${pagination.pageNoLong }"> 
	</div>
</form>
</div>
	</div>
	<!-- <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" data-title="添加资讯" data-href="article-add.html" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加资讯</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div> -->
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<!-- <th width="80">流量包Id</th> -->
					<!-- <th width="30">ID</th> -->
					<!-- <th width="80">平台名称</th> -->
					<th width="80">话费价值</th>
					<th width="120">通道折扣</th>
					<th width="120">折扣价格</th>
					<th width="60">票务</th>
					<th width="60">运营商名称</th>
					<th width="100">业务类型</th>
					<th width="120">支持省份</th>
					<c:if test="${resultMap.city ==  resultMap.params.serviceType}">
					<th width="120">支持城市</th>
					</c:if>
					<th width="60">充值速度</th>
					<th width="120">限制描述</th>
					
					
					<!-- <th width="80">通道状态</th>
					<th width="80">通道使用状态</th> -->
					<!-- <th width="100">操作</th> -->
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="telchannel" varStatus="vs">
					<tr class="text-c">
						<%-- <td>${telchannel.id }</td> 
						<td>${telchannel.epName }</td> --%>
						<td>${telchannel.chargeValue }元</td>
					 	<td class="c-blue">${telchannel.telchannelDiscount }</td>
						<td class="c-blue">${telchannel.telchannelPrice }</td>
						 <td>
						 	<c:choose>
								<c:when test="${telchannel.billType == 0 }">
									<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
										<c:if test="${billTypeEnum.value == 0 }">
											<span data-toggle="tooltip"  class="c-red" data-placement="right" title="${billTypeEnum.desc }">
											${billTypeEnum.desc }</span>
										</c:if>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
									<c:if test="${billTypeEnum.value == 1 }">
										<span data-toggle="tooltip" class="c-green" data-placement="right" title="${billTypeEnum.desc }">
										${billTypeEnum.desc }</span>
									</c:if>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						 </td>
						 
						<!-- <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','article-zhang.html','10001')" title="查看">资讯标题</u></td> -->
						<td>
							<c:forEach items="${resultMap.operatorNameEnums }" var="operatorNameEnum" varStatus="vs1">
							<c:if test="${telchannel.operatorName == operatorNameEnum.value }"> ${operatorNameEnum.desc }</c:if>
							</c:forEach>
						</td>
						<td>
							<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceTypeEnum" varStatus="vs1">
							<c:if test="${telchannel.serviceType == serviceTypeEnum.value }"> ${serviceTypeEnum.desc }</c:if>
							</c:forEach>
						</td>
						<td>
							${telchannel.province }
						<%-- <c:forEach items="${resultMap.scopeCityEnums }" var="scopeCityEnum">
							<c:if test="${scopeCityEnum.value== telchannel.cityid}">
								<span data-toggle="tooltip" data-placement="right" title="${telchannel.cityid }">${scopeCityEnum.desc }</span>
							</c:if>
						</c:forEach> --%>
						</td>
						<c:if test="${resultMap.city ==  telchannel.serviceType}">
						<td>${telchannel.city }</td> 
						</c:if>
						<td>
							<c:forEach items="${resultMap.telchargeSpeedEnums }" var="telchargeSpeedEnum" varStatus="vs1">
							<c:if test="${telchannel.chargeSpeed == telchargeSpeedEnum.value }"> ${telchargeSpeedEnum.desc }</c:if>
							</c:forEach>
						</td>
						<td>${telchannel.limitDescription }</td> 
						
						<%--  <td class="td-status">
							<c:forEach items="${resultMap.channelStateEnums }" var="cState" varStatus="vs1">
								<c:if test="${telchannel.telchannelState == cState.value && telchannel.telchannelState==0  }"> <span class="label label-success radius">${cState.desc }</span></c:if>
								<c:if test="${telchannel.telchannelState == cState.value && telchannel.telchannelState==1  }"> <span class="label radius">${cState.desc }</span></c:if>
							</c:forEach>
						</td>
						<td class="td-status">
							<c:forEach items="${resultMap.channelUseStateEnums }" var="cUseState" varStatus="vs1">
								<c:if test="${telchannel.telchannelUseState == cUseState.value  && telchannel.telchannelUseState==0}"> <span class="label label-success radius">${cUseState.desc }</span></c:if>
								<c:if test="${telchannel.telchannelUseState == cUseState.value  && telchannel.telchannelUseState==1}"> <span class="label radius">${cUseState.desc }</span></c:if>
							</c:forEach>
						</td> --%>
						<!-- <td class="f-14 td-manage"> -->
							<%-- <c:choose>
								<c:when test="${telchannel.telchannelState == 1 }"><!-- 暂停 -->
									<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="changeCState(${telchannel.id},'0','state')" href="javascript:;" title="运行">
										<i class="Hui-iconfont">&#xe6e6;</i>
									</a> 
								</c:when>
								<c:when test="${telchannel.telchannelState == 0 }"><!-- 运行 -->
									<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="changeCState(${telchannel.id},'1','state')" href="javascript:;" title="暂停">
										<i class="Hui-iconfont">&#xe6e5;</i>
									</a> 
								</c:when>
							</c:choose>
							<c:choose>
							<c:when test="${telchannel.telchannelUseState == 1 }"><!-- 已暂停 -->
								<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="changeCState(${telchannel.id},'0','useState')" href="javascript:;" title="启用">
									<i class="Hui-iconfont">&#xe615;</i>
								</a> 
							</c:when>
							<c:when test="${telchannel.telchannelUseState == 0 }"><!-- 已启用 -->
								<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="changeCState(${telchannel.id},'1','useState')" href="javascript:;" title="停用">
									<i class="Hui-iconfont">&#xe631;</i>
								</a> 
							</c:when>
							</c:choose> --%>
						<%-- <a style="text-decoration:none" class="ml-5" onClick="produce_del('/flowsys/telchannelCode/telchannelcode_delete.do',${telchannel.id })" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
						<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" class="ml-5" data-href="javascript:;" onClick="getTelrateList(this,'/flowsys/telRate/bind_telRate_list.do',${telchannel.id },${telchannel.serviceType })" data-title="折扣信息"><i class="Hui-iconfont">&#xe725;</i></a>
						<a style="text-decoration:none" data-toggle="tooltip" data-href='/flowsys/tel_channel/telchannel_edit_page.do?id=${telchannel.id}&serviceType=${telchannel.serviceType }' data-placement="top" class="ml-5" onclick="Hui_admin_tab(this)" data-title="编辑通道"><i class="Hui-iconfont">&#xe6df;</i></a>
						<a style="text-decoration:none" data-toggle="tooltip" data-href='/flowsys/telRate/telRate_add_page_plat.do?id=${telchannel.id}&serviceType=${telchannel.serviceType }' data-placement="top" class="ml-5" onclick="Hui_admin_tab(this)" data-title="平台用户折扣"><i class="Hui-iconfont">&#xe72b;</i></a> --%>
						<%-- editChannel(this,'/flowsys/tel_channel/telchannel_edit_page.do?channelId=${telchannel.id}&serviceType='${telchannel.serviceType }) --%>
						<!-- </td> -->
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="pagaId" />  
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
<script type="text/javascript" src="/view/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var provinceid = $("#provinceid").val();
	//alert($("#provinceid").val());
	var ss;
    var city = document.getElementById("city");
    var cityid = $('#cityid').val();
   $.getJSON("/view/mine/data/cityData.json",function(data){
	    ss=data;
	    //var html="<option value='-1'>==请选择==</option>";
	    for(var i=0;i<ss.length;i++){
	    	if(provinceid==ss[i].provinceid){
                var citys=ss[i].cities;
                city.innerHTML = "";
                for(var j=0;j<citys.length;j++){
                	city.add(new Option(citys[j].city,citys[j].cityid));
                	if(cityid == citys[j].cityid){
	   					city.options[j].selected=true;
   					}
                }
            }
	    }
	});
})

/**编辑通道页面*/
function editChannel(obj,url,title){
	$(obj).attr('data-href',url);
	Hui_admin_tab(obj);
	/* layer.open({
        type: 2,
        title: title,
        //area: ['530px', '510px'],
        maxmin: false,
        closeBtn: 1,
        content: url,
         end: function () {
            location.reload();
        }
    }); */
	//$(objt).attr('data-href',url); //+$('form').serialize()
	//Hui_admin_tab(objt);
}

/*通道状态-修改*/
function changeCState(telchannelId,state, tag){
	var url = '/flowsys/tel_channel/update_telchannel_state.do';
	var keyWord = '';
	var resultMsg = '失败';
	if(tag == 'state'){
		if(state == '0'){
			keyWord = '运行';
		}else if(state == '0'){
			keyWord = '暂停';
		}
	}else{
		if(state == '1\0'){
			keyWord = '启用';
		}else{
			keyWord = '停用';
		}
	}
	var msg = '确定要' + keyWord + '该通道吗？';
	layer.confirm(msg,function(index){
		$.ajax({
			type: 'POST',
			url: '/flowsys/tel_channel/update_telchannel_state.do',
			dataType: 'json',
			data: {id:telchannelId, telchannelState:state, telchannelUseState:state, tag:tag },
			async: false,
			success: function(data){
				tag = data;
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
		if(tag == "success"){
			layer.msg(keyWord + '成功', {icon:5,time:1000});
		}
		layer.close(index);
		location.reload();
	});
}

/** 获得费率列表**/
function getTelrateList(objt,url,telchannelId,serType){
	/* var telchannelId = $(objt).parent().parent().children(":first").html();
	var serviceType = $(objt).parent().parent().children(":eq(3)").html();
	var operatorType = $(objt).parent().parent().children(":eq(4)").html();
	var specialTag = $(objt).parent().parent().children(":eq(5)").html();
	//alert(specialTag)
	//alert(serviceType);
	//alert(operatorType);
	//alert(channelId);
	$("#channelId").val(channelId); */
	layer.msg(url);
	$(objt).attr('data-href',url+'?telchannelId='+ telchannelId + '&serviceType='+ serType);
		Hui_admin_tab(objt);
}

/**省份变化*/
function province_change(v){
	var ss;
    var city = document.getElementById("city");
	city.innerHTML = "";
	//alert("1");
	$.getJSON("/view/mine/data/cityData.json",function(data){
	    ss=data;
	    //var html="<option value='-1'>==请选择==</option>";
	    for(var i=0;i<ss.length;i++){
	    	if(v==ss[i].provinceid){
                var citys=ss[i].cities;
                //var arrLen = citys.length;
               // if(arrLen > 0 ){
                	//city.add(new Option(citys[0].city,citys[0].cityid),true);
	                //if(citys.length > 1){
		                for(var j=0;j<citys.length;j++){
		                	city.add(new Option(citys[j].city,citys[j].cityid));
		                	//city.append("<option value='"+citys[j].cityid+"'>"+citys[j].city+"</option>");
		                }
	               // }
                //}
            }
	    }
	});
   // city.options[0].selected=true;
	$('form').submit();
}
function initCity(){
	$('form').submit();
}


/**onchange提交表单*/
function submitForm(){
	$('form').submit();
}
/*话费编码-删除*/
function pg_del(obj,id){
	layer.confirm("确认要删除该包体吗？",function(index){
		//alert(index);
		var tag = "";
		/* $.ajax({
			type: "post",
			url: "/flowsys/operatorPg/pg_delete.do?pgId="+ id,
			dataType: "json",
			async: false,
			success: function(data){	
				tag = data;
			},
			error:function(data) {
				tag = data;
				console.log(data.msg);
			},
		});	 */
		if(tag == "success"){
			layer.msg('删除成功', {icon:5,time:1000});
		}
		layer.close(index);
		location.reload();
	});
}
</script> 
</body>
</html>