<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/MyTaglib.tld" prefix="mytag"%>
<!DOCTYPE >
<html ><!-- class="no-js" -->
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

<link rel="stylesheet" type="text/css" href="/view/mine/amaze/admin.css" />
<link rel="stylesheet" type="text/css" href="/view/mine/amaze/amazeui.css" />


<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>流量通道展示</title>
<style type="text/css">

</style>
</head>
<body>
<c:if test="${loginContext.rootAgencyId == 0  && resultMap.showModel == 1}">
 <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 平台通道管理 <span class="c-gray en">&gt;</span> 通道展示列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
 </c:if> 
<div class="page-container">
	<div class="text-c">
	<form class="form form-horizontal" action="/flowsys/showRate/showRate_list.do" method="post" id="formD" name="dataListForm">
		<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
		<div class="row cl formControls">
		<%-- 平台名称：<input type="text" value="${resultMap.searchParam.epName }" name="epName" id="epName" placeholder=" 平台名称" style="width:150px" class="input-text">&nbsp;&nbsp; --%>
		<span class="select-box inline">
				<select name="operatorType" onchange="submitForm()" class="select">
				<option value="">运营商</option>
				<c:forEach items="${resultMap.operatorTypeEnums }" var="otypeEnum" varStatus="vs2">
					<option value="${otypeEnum.value }" <c:if test="${otypeEnum.value == resultMap.searchParam.operatorType }"> selected</c:if>>${otypeEnum.desc }</option>
				</c:forEach>
			</select>
			</span> 
			&nbsp;&nbsp;
		<%-- 包体编码名称：<input type="text" value="${resultMap.searchParam.productName }" name="productName" id="" placeholder="包体编码名称" style="width:250px" class="input-text">&nbsp;&nbsp; --%>
		<%-- 包体编码名称：<input type="text" value="${resultMap.searchParam.productName }" name="productName" id="" placeholder="包体编码名称" style="width:250px" class="input-text">&nbsp;&nbsp; --%>
		<span class="select-box inline">
			<select name="scopeCityCode" onchange="submitForm()" class="select">
			<option value="">通道地区</option>
			<c:forEach items="${resultMap.scopeCityEnums }" var="scopeCityEnum">
				<option value="${scopeCityEnum.value }" <c:if test="${scopeCityEnum.value == resultMap.searchParam.scopeCityCode }"> selected</c:if>>${scopeCityEnum.desc }</option>
			</c:forEach>
		</select>
		</span> 
		&nbsp;&nbsp;
		<span class="select-box inline">
			<select name="serviceType" onchange="submitForm()" class="select">
				<option value="">业务类型</option>
				<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceType" varStatus="vs1">
					<option value="${serviceType.value }" <c:if test="${serviceType.value == resultMap.searchParam.serviceType }"> selected</c:if>>${serviceType.desc }</option>
				</c:forEach>
			</select>
		</span> 
		
		<c:choose>
				<c:when test="${loginContext.rootAgencyId == 0  && resultMap.showModel == 1}">
					<input type="hidden" id="showModel" name="showModel" value="${resultMap.showModel }">
					<a style="text-decoration:none" class="btn btn-success" data-title='展示通道添加' onClick="showRate_add(this,'展示通道添加','/flowsys/showRate/showRate_add_page.do',0)" href="javascript:;" title="添加"><i class="Hui-iconfont">&#xe600;</i>添加</a>
					<input value="查询" class="btn btn-success" type="submit"><!-- <i class="Hui-iconfont">&#xe665;</i> -->
					<div class="row cl" style="margin-top: 30dp;">
					&nbsp;&nbsp;
					<span class="select-box inline">
						<select name="bussinessMan" onchange="submitForm()" class="select">
							<option value="">商务</option>
							<c:forEach items="${resultMap.businessOneEnums }" var="businessOneEnum">
								<option value="${businessOneEnum.value }" <c:if test="${businessOneEnum.value == resultMap.searchParam.bussinessMan }"> selected</c:if>>${businessOneEnum.desc }</option>
							</c:forEach>
						</select>
					</span> 
					&nbsp;&nbsp;
					<span class="select-box inline">
						<select name="channelBill" onchange="submitForm()" class="select">
							<option value="">拿货票务</option>
							<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum">
								<option value="${billTypeEnum.value }" <c:if test="${billTypeEnum.value == resultMap.searchParam.channelBill }"> selected</c:if>>${billTypeEnum.desc }</option>
							</c:forEach>
						</select>
					</span> 
					渠道备注:<input type="text"  value="${resultMap.searchParam.channelCompany }" name="channelCompany" id="channelCompany" placeholder=" 渠道备注" style="width:250px" class="input-text">
					<!-- 公司商务 -->
					</div>
				</c:when>
				<c:otherwise>
					<button type="button" class="btn btn-success" onclick="javascript:location.replace(location.href);" value="重置">重置</button>
					<input value="查询" class="btn btn-success" type="submit"><!-- <i class="Hui-iconfont">&#xe665;</i> -->
					<span class="am-text-warning">标红表示维护</span>
				</c:otherwise>
			</c:choose>
		</div>
		</form>
	</div>
	<div class="mt-20 ">
		<c:choose>
			<c:when test="${not empty resultMap.showRateList }">
				<c:choose>
					<c:when test="${loginContext.rootAgencyId == 0  && resultMap.showModel == 1 }">
						<table class="table table-border table-bordered table-bg table-hover table-sort">
							<thead>
								<tr class="text-c">
									<!-- <th width="80">流量包Id</th> -->
									<th width="80">地区</th>
									<th width="40">运营商</th>
									<th width="100">业务类型/包体描述</th>
									
									<th width="100">不带/带价格</th>
									<th width="80">是否限价</th>
									<th width="120">更新时间</th>
									<th width="40">状态</th>
									<%-- <c:if test="${loginContext.rootAgencyId == 0  && resultMap.showModel == 1 }"> --%>
										<th width="150">商务备注</th>
										<th width="80">操作</th>
									<%-- </c:if> --%>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${resultMap.showRateList }" var="showRate" varStatus="vs">
									<tr class="text-c <c:if test='${showRate.showRateState == 1 }'>danger</c:if>"><!-- <c:choose> <c:when test='${showRate.showRateState == 1 }'>danger</c:when><c:otherwise>success</c:otherwise></c:choose> -->
										<td>
										<c:forEach items="${resultMap.scopeCityEnums }" var="scopeCityEnum">
											<c:if test="${scopeCityEnum.value== showRate.scopeCityCode}">
												<span >${scopeCityEnum.desc }</span><!-- data-toggle="tooltip" data-placement="right" title="${showRate.scopeCityCode }" -->
											</c:if>
										</c:forEach>
										</td>
										<td>
											<c:forEach items="${resultMap.operatorTypeEnums }" var="operatorType" varStatus="vs1">
												<c:if test="${showRate.operatorType == operatorType.value }"> ${operatorType.desc }</c:if>
											</c:forEach>
										</td>
										<td>
											<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceType" varStatus="vs1">
												<c:if test="${showRate.serviceType == serviceType.value }"> ${serviceType.desc }</c:if>
											</c:forEach>
											${showRate.productDesc }
										</td>
										
										<td>
											<c:if test="${not empty showRate.privateRate && showRate.privateRate != 1.1 }">
												不带 ${showRate.privateRate }
											</c:if>
											<c:if test="${not empty showRate.billRate && showRate.billRate != 1.1 }">
												&nbsp;带 ${showRate.billRate }
											</c:if>
											<%-- <c:choose>
												<c:when test="${empty showRate.privateRate || showRate.privateRate == 1.1 }">
													--
												</c:when>
												<c:otherwise>
												不带票
													${showRate.privateRate }
												</c:otherwise>
											</c:choose> 
											<c:choose>
												<c:when test="${empty showRate.billRate || showRate.billRate == 1.1 }">
													--
												</c:when>
												<c:otherwise>
													&nbsp;带票 &nbsp;
													${showRate.billRate }
												</c:otherwise>
											</c:choose> --%>
										</td>
										<td>
											<c:forEach items="${resultMap.limitPriceEnums }" var="limitPriceEnum">
												<c:if test="${limitPriceEnum.value== showRate.limitPrice}">
													<span>${limitPriceEnum.desc }</span>
												</c:if>
											</c:forEach>
										</td>
										<td>${showRate.lastAccessStr }</td>
										<td><c:choose>
												<c:when test="${showRate.showRateState == 0 }">
													正常
												</c:when>
												<c:otherwise>
													<span class="c-red">维护</span>  
												</c:otherwise>
											</c:choose>
										</td>
										
										<%-- <c:if test="${loginContext.rootAgencyId == 0  && resultMap.showModel == 1}"> --%>
											<td>
												<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum">
													<c:if test="${billTypeEnum.value== showRate.channelBill}">
														<span>${billTypeEnum.desc }</span>
													</c:if>
												</c:forEach>
												${showRate.channelPrice } &nbsp;&nbsp;
												${showRate.channelCompany } &nbsp;&nbsp;
												<c:forEach items="${resultMap.businessOneEnums }" var="businessOneEnum">
													<c:if test="${businessOneEnum.value== showRate.bussinessMan}">
														<span>${businessOneEnum.desc }</span>
														<%-- <span data-toggle="tooltip" data-placement="right" title="${businessOneEnum.desc }">${businessOneEnum.desc }</span> --%>
													</c:if>
												</c:forEach>
												<%-- ${showRate.bussinessMan }  --%>
											</td> 
											<td class="f-14 td-manage">
											<a style="text-decoration:none" class="ml-5" onClick="produce_del('/flowsys/showRate/del_showRate.do',${showRate.id })" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
											<a style="text-decoration:none" class="ml-5" data-title='展示通道编辑' onClick="showRate_add(this,'展示通道编辑','/flowsys/showRate/showRate_edit_page.do',${showRate.id })" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
											<!-- 编辑展示通道维护状态 -->
											<c:choose>
												<c:when test="${showRate.showRateState == 0 }">
													<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="changeUseState('/flowsys/showRate/update_showRate_state.do','1',${showRate.id})" href="javascript:;" title="维护">
														<i class="Hui-iconfont">&#xe631;</i>
													</a>
												</c:when>
												<c:otherwise>
													<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" onClick="changeUseState('/flowsys/showRate/update_showRate_state.do','0',${showRate.id})" href="javascript:;" title="恢复">
														<i class="Hui-iconfont">&#xe615;</i>
													</a> 
												</c:otherwise>
											</c:choose>
											</td>
										<%-- </c:if> --%>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<div>
						<c:forEach items="${resultMap.showRateList }" var="showRate" varStatus="vs">
							<c:if test="${vs.index % 4 == 0 }">
								<ul class="am-avg-sm-1 am-avg-md-4 am-margin am-padding am-text-center admin-content-list "></c:if>
							      <li class="<c:if test='${showRate.showRateState != 0 }'>am-text-danger</c:if>">
							      	<c:forEach items="${resultMap.scopeCityEnums }" var="scopeCityEnum">
										<c:if test="${scopeCityEnum.value== showRate.scopeCityCode}">
											<span >${scopeCityEnum.desc }</span><!-- data-toggle="tooltip" data-placement="right" title="${showRate.scopeCityCode }" -->
										</c:if>
									</c:forEach>
									<c:forEach items="${resultMap.operatorTypeEnums }" var="operatorType" varStatus="vs1">
										<c:if test="${showRate.operatorType == operatorType.value }"> ${operatorType.desc }</c:if>
									</c:forEach>
									<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceType" varStatus="vs1">
										<c:if test="${showRate.serviceType == serviceType.value }"> ${serviceType.desc }</c:if>
									</c:forEach><br>
									${showRate.productDesc }<br>
									<c:if test="${not empty showRate.privateRate && showRate.privateRate != 1.1 }">
										不带 ${showRate.privateRate }
									</c:if>
									<c:if test="${not empty showRate.billRate && showRate.billRate != 1.1 }">
										&nbsp;带 ${showRate.billRate }
									</c:if>
									<c:forEach items="${resultMap.limitPriceEnums }" var="limitPriceEnum">
										<c:if test="${limitPriceEnum.value== showRate.limitPrice}">
											<span>${limitPriceEnum.desc }</span>
										</c:if>
									</c:forEach>
							      </li><!-- <span class="am-icon-btn am-icon-file-text"></span> -->
							  <c:if test="${(vs.index+1) % 4==0 }">
							    </ul>
						    </c:if>
						</c:forEach>
						</div>
					     <!--  <li><a href="#" class="am-text-warning"><span class="am-icon-btn am-icon-briefcase"></span><br/>成交订单<br/>308</a></li>
					      <li><a href="#" class="am-text-danger"><span class="am-icon-btn am-icon-recycle"></span><br/>昨日访问<br/>80082</a></li>
					      <li><a href="#" class="am-text-secondary"><span class="am-icon-btn am-icon-user-md"></span><br/>在线用户<br/>3000</a></li> -->
						<%-- <ul id="menu">
						<c:forEach items="${resultMap.showRateList }" var="showRate" varStatus="vs">
						 <li>
						 	
						 </li>
		 			 </c:forEach>
						</ul> --%>
					</c:otherwise>
				</c:choose>
				<span class="c-blue r">总通道数：${fn:length(resultMap.showRateList)}条</span>
				<%-- <mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="channellistId" />   --%>
			</c:when>
			<c:otherwise>
				<span class="error-description">暂没有收藏该地区相关资源!!!</span>
			</c:otherwise>
		</c:choose>
	</div>
	<footer class="footer mt-20">
		<div class="container">
			<p><!-- 感谢jQuery、layer、laypage、Validform、UEditor、My97DatePicker、iconfont、Datatables、WebUploaded、icheck、highcharts、bootstrap-Switch<br> -->
				Copyright &copy;2017-2018 南昌微族科技有限公司 All Rights Reserved.<br>
				</p>
		</div>
	</footer>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="/view/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="/view/mine/showRate.js"></script>
<script type="text/javascript" >
/* var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1265916742'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s22.cnzz.com/z_stat.php%3Fid%3D1265916742%26show%3Dpic' type='text/javascript'%3E%3C/script%3E")); */
</script> 
</body>
</html>