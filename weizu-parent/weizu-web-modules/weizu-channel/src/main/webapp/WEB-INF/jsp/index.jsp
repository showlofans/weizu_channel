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
<!-- <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0">  -->
<link rel="Bookmark" href="/view/iconW.jpg" >
<link rel="Shortcut Icon" href="/view/iconW.jpg" />
<link href="/view/iconW.jpg" type="image/x-icon" rel="icon">
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/view/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>微族通道系统</title>
<meta name="keywords" content="微族 小宁 流量 通道 系统 ">
<meta name="description" content="南昌微族科技-流量系统">
</head>
<body>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl"> <a title="系统最新更新时间：${applicationScope.startupTime }" class="logo navbar-logo f-l mr-10 hidden-xs" href="/home">微族通道系统Beta${portNum }</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="#">微族通道系统Beta</a> 
			<span class="logo navbar-slogan f-l mr-10 hidden-xs">
			</span> 
			<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
			<%-- <c:if test="${loginContext.rootAgencyId == 0 }">
			<nav class="nav navbar-nav">
				<ul class="cl">
					<li class="dropDown dropDown_hover"><a href="javascript:;" class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i class="Hui-iconfont">&#xe6d5;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a href="javascript:;"  onclick="Hui_admin_tab(this)"  data-title="通道添加" data-href="/flowsys/channel/channel_add_page.do" ><i class="Hui-iconfont">&#xe616;</i> 通道</a></li>
							<!-- <li><a href="javascript:;" onclick="Hui_admin_tab(this)"  data-title="费率添加" data-href="/flowsys/rate/rate_add_page.do" ><i class="Hui-iconfont">&#xe613;</i> 费率</a></li> -->
							<li><a href="javascript:;" onclick="Hui_admin_tab(this)"  data-title="流量包添加" data-href="/flowsys/operatorPg/pg_add_page.do" ><i class="Hui-iconfont">&#xe620;</i> 标准包</a></li>
							<li><a href="javascript:;" onclick="Hui_admin_tab(this)"  data-title="平台添加" data-href="/flowsys/platform/platform_add_page.do" ><i class="Hui-iconfont">&#xe60d;</i> 平台添加</a></li>
						</ul>
					</li>
				</ul>
			</nav>
			</c:if> --%>
			<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
				<ul class="cl">
					<!-- <li>超级管理员</li> -->
					<%-- <li>个人信用：<a href="#"><c:if test="${empty chargeAccount.accountCredit }">0.00</c:if> ${chargeAccount.accountCredit }</a></li> --%>
					<li>余额：<a title="充值记录" data-href="/flowsys/account/charge_list.do?agencyId=${loginContext.id }" data-title="充值记录" onclick="Hui_admin_tab(this)">${totalBalance }</a></li><!-- <c:if test="${empty chargeAccount.accountBalance && empty chargeAccount1.accountBalance }">0.00</c:if> ${chargeAccount.accountBalance + chargeAccount1.accountBalance} -->
					<li class="dropDown dropDown_hover">
						<a href="javascript:;" onClick="myselfinfo()" class="dropDown_A">${loginContext.userName} <i class="Hui-iconfont">&#xe6d5;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a title="" data-href="/flowsys/agency/agency_info.do" data-title="个人信息" onclick="Hui_admin_tab(this)">个人信息 </a>
							</li>
							<li><a href="/flowsys/agency/logout.do">切换账户</a></li>
							 <li><a data-href="/flowsys/bankAccount/my_bank_list.do" data-title="申请加款" href="javascript:void(0)" onclick="Hui_admin_tab(this)">申请加款</a></li>
							<li><a title="" data-href="/flowsys/agency/reset_pass_page.do" data-title="修改密码" onclick="Hui_admin_tab(this)">修改密码</a></li>
							<li><a href="/flowsys/agency/logout.do">退出</a></li>
						</ul>
					</li>
					<li id="Hui-msg" class="dropDown right dropDown_hover"> <a href="#" class="dropDown_A" title="消息">
						<c:if test="${msgNum != 0 }">
							<span class="badge badge-danger">${msgNum }</span>
						</c:if>
						
						<i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> 
						<ul class="dropDown-menu menu radius box-shadow">
							<c:if test="${loginContext.rootAgencyId == 0 }">
								<li><a data-href="/flowsys/account/confirm_company_account_page.do" data-title="认证审核" title="认证审核" onclick="Hui_admin_tab(this)">认证审核 &nbsp;&nbsp;&nbsp;&nbsp;  ${unconfirmSize }</a></li>
							</c:if>
							<c:forEach items="${transferMsgList }" var="transferMsg" varStatus="vst">
								<li><a data-href="/flowsys/bankAccount/transfer_record.do?bankId=${transferMsg.id }&confirmState=2&direction=0" data-title="转账审核" title="转账审核" onclick="Hui_admin_tab(this)">${transferMsg.remmitanceBankAccount} &nbsp;&nbsp;&nbsp;&nbsp;  <span class="c-danger">${transferMsg.tfnum}</span></a></li>
							</c:forEach>
							<%-- <c:forEach items="${unconfirmList }" var="unconfirm" varStatus="vst" >
								<li><a href="javascript:;" title="">${unconfirm.companyName }</a></li>
							</c:forEach> --%>
						</ul>
					</li>
					<li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
							<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
							<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
							<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
							<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
							<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
							
					</ul>
				</li>
			</ul>
		</nav>
	</div>
</div>

</header>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<dl id="menu-product"><!-- menu_dropdown-arrow -->
		<c:choose>
			<c:when test="${loginContext.rootAgencyId == 0 }">
				<dt><i class="Hui-iconfont" style="font-size:20px;">&#xe643;</i> 通道管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
				<dd>
					<ul>
						<li><a data-href="/flowsys/channel/channel_add_page.do" data-title="流量添加" href="javascript:void(0)"><i class="Hui-iconfont">&#xe675;</i> 流量添加</a></li>
						<li><a data-href="/flowsys/channel/channel_list.do" data-title="流量通道" href="javascript:void(0)"><i class="Hui-iconfont">&#xe675;</i> 流量通道</a></li>
						
						<li><a data-href="/flowsys/tel_channel/telchannel_add_page.do" data-title="话费通道添加" href="javascript:void(0)"><i class="Hui-iconfont">&#xe6a3;</i> 话费添加</a></li>
						<li><a data-href="/flowsys/tel_channel/telchannel_list.do" data-title="话费通道" href="javascript:void(0)"><i class="Hui-iconfont">&#xe6a3;</i> 话费通道</a></li>
						<li><a data-href="/flowsys/showRate/showRate_list.do?showModel=1" data-title="通道展示列表" href="javascript:void(0)">通道展示</a></li>
					</ul>
				</dd>
			</c:when>
			<c:otherwise>
				 <dt><i class="Hui-iconfont" style="font-size:20px;">&#xe643;</i> 我的通道<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
				<dd>
					<ul>
						<!-- <li><a data-href="/flowsys/channel/channel_list.do" data-title="流量通道" href="javascript:void(0)"><i class="Hui-iconfont">&#xe675;</i> 流量通道</a></li> -->
						<li><a data-href="/flowsys/telRate/agency_telchannel_list.do" data-title="话费通道" href="javascript:void(0)"><i class="Hui-iconfont">&#xe6a3;</i> 话费通道</a></li>
						<li><a data-href="/flowsys/rate/my_rate_list.do" data-title="流量通道" href="javascript:void(0)"><i class="Hui-iconfont">&#xe675;</i> 流量通道</a></li>
						
						<c:if test="${loginContext.agencyTag == 1 }">
						<li><a data-href="/flowsys/showRate/showRate_list.do?showModel=0" data-title="通道展示列表" href="javascript:void(0)">通道展示</a></li>
						</c:if>
					</ul>
				</dd> 
			</c:otherwise>
		</c:choose>
		</dl>
		<dl id="menu-product">
			<dt><i class="Hui-iconfont" style="font-size:20px;">&#xe62b;</i> 代理商管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<!-- <li><a data-href="/flowsys/rate/rate_add_page.do" data-title="费率添加" href="javascript:void(0)">费率添加</a></li>
					<li><a data-href="/flowsys/rate/rate_list.do" data-title="费率列表" href="javascript:void(0)">费率列表</a></li> -->
					<c:if test="${loginContext.agencyTag == 1 }">
					<li><a data-href="/flowsys/agency/child_agency_list.do?agencyTag=1" data-title="认证用户" href="javascript:void(0)">认证用户</a></li>
					</c:if>
					<li><a data-href="/flowsys/agency/child_agency_list.do?agencyTag=0" data-title="代理商" href="javascript:void(0)">代理商</a></li>
					<c:if test="${loginContext.rootAgencyId == 0 }">
						<li><a data-href="/flowsys/crm/crm_list.do" data-title="客户信息" href="javascript:void(0)">客户信息</a></li>
						<!-- <li><a data-href="/flowsys/otherPart/server_file_log.do" data-title="其他数据" href="javascript:void(0)">其他数据</a></li> -->
					</c:if>
					<!-- <li><a data-href="/flowsys/agency/get_tel_location.do" data-title="号码归属地查询" href="javascript:void(0)">号码归属地查询</a></li> -->
				</ul>
			</dd>
		</dl>
		<dl id="menu-comments">
			<dt><i class="Hui-iconfont"style="font-size:20px;">&#xe627;</i> 订单管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<c:choose>
						<c:when test="${loginContext.rootAgencyId == 0 }">
							<li><a data-href="/flowsys/chargePg/purchase_list.do" data-title="订单列表" href="javascript:void(0)">订单列表</a></li>
							<li><a data-href="/flowsys/chargePg/purchase_list.do?orderResult=2" data-title="充值进行" href="javascript:void(0)">充值进行</a></li>
							<li><a data-href="/flowsys/chargePg/purchase_list.do?orderResult=4" data-title="充值等待" href="javascript:void(0)">充值等待</a></li>
							<li><a data-href="/flowsys/chargePg/purchase_list.do?orderResult=1" data-title="充值成功" href="javascript:void(0)">充值成功</a></li>
							<li><a data-href="/flowsys/chargePg/purchase_list.do?orderResult=0" data-title="充值失败" href="javascript:void(0)">充值失败</a></li>
							<li><a data-href="/flowsys/chargeLog/charge_log_list.do" data-title="接口订单日志" href="javascript:void(0)">接口订单日志</a></li>
						</c:when>
						<c:otherwise>
							<li><a data-href="/flowsys/chargePg/purchase_list.do" data-title="订单列表" href="javascript:void(0)">订单列表</a></li>
							<li><a data-href="/flowsys/chargePg/purchase_list.do?orderState=2" data-title="充值进行" href="javascript:void(0)">充值进行</a></li>
							<li><a data-href="/flowsys/chargePg/purchase_list.do?orderState=1" data-title="充值成功" href="javascript:void(0)">充值成功</a></li>
							<li><a data-href="/flowsys/chargePg/purchase_list.do?orderState=0" data-title="充值失败" href="javascript:void(0)">充值失败</a></li>
						</c:otherwise>
					</c:choose>
			</ul>
		</dd>
	</dl>
	<c:if test="${loginContext.userName != 'wechat' }">
	<dl id="menu-comments">
		<dt><i class="Hui-iconfont" style="font-size:20px;">&#xe726;</i> 在线充值<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
		<dd>
			<ul>
				<li><a data-href="/flowsys/chargePg/pg_charge_page.do" title="/flowsys/chargePg/pg_charge_page.do" data-title="流量充值" href="javascript:;"><i class="Hui-iconfont">&#xe675;</i>  流量充值</a></li>
				<li><a data-href="/flowsys/chargeTel/tel_charge_page.do"  data-title="话费充值" href="javascript:;"><i class="Hui-iconfont">&#xe6c7;</i> 话费充值</a></li> 
				<li><a data-href="/flowsys/chargePg/pg_batch_charge_page.do" title="批量充值" data-title="批量充值" href="javascript:;">流量批量充值</a></li> 
				
			</ul>
		</dd>
	</dl>
	</c:if>
	<dl id="menu-member">
		<dt><i class="Hui-iconfont" style="font-size:20px;">&#xe670;</i> 账户管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
		<dd>
			<ul>
				<!-- <li><a data-href="/flowsys/account/open_company_account_page.do" data-title="认证信息" href="javascript:void(0)">认证信息</a></li> -->
				<li><a data-href="/flowsys/bankAccount/my_bank_list.do" data-title="申请加款" href="javascript:void(0)" onclick="Hui_admin_tab(this)">申请加款</a></li>
				<li><a data-href="/flowsys/account/charge_list.do" data-title="充值明细" href="javascript:void(0)">充值明细</a></li>
				<li><a data-href="/flowsys/account/account_info.do" data-title="账户信息" href="javascript:void(0)">账户信息</a></li>
				<li><a data-href="/flowsys/account/consume_list.do" data-title="订单消费" href="javascript:void(0)">订单消费</a></li>
				<c:choose>
					<c:when test="${loginContext.agencyTag != 1 && (companyAccount == 'yes' || power == 'no' ) }">
						<li><a data-href="/flowsys/account/open_company_account_page.do" data-title="开通对公账号" href="javascript:void(0)">开通对公账号</a></li>
					</c:when>
					<c:when test="${loginContext.agencyTag == 1 && loginContext.rootAgencyId != 0 }"><!-- 有对公账户 -->
						<li><a data-href="/flowsys/account/confirm_account_info.do?agencyId=${loginContext.id }" data-title="查看验证信息" href="javascript:void(0)">查看验证信息</a></li>
					</c:when>
				</c:choose>
				<%-- <c:if test="${loginContext.agencyTag != 1 && (companyAccount == 'yes' || power == 'no' ) }">
					<c:choose>
						<c:when test="${loginContext.agencyTag != 1 }">
						
						</c:when>
					</c:choose>
				</c:if> --%>
			</ul>
		</dd>
	</dl>
	<c:if test="${loginContext.rootAgencyId == 0 }">
	<dl id="menu-article">
			<dt><i class="Hui-iconfont" style="font-size:20px;">&#xe6c6;</i> 标准价管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="/flowsys/operatorPg/operatorPg_list.do" data-title="标准价管理" href="javascript:void(0)">标准价管理</a></li>
				</ul>
		</dd>
	</dl>
	<dl id="menu-system">
			<dt><i class="Hui-iconfont" style="font-size:20px;">&#xe6c6;</i>系统配置<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="/flowsys/systemConf/systemConf_list.do" data-title="系统配置信息" href="javascript:void(0)">系统配置信息</a></li>
				</ul>
		</dd>
		<c:if test="${power== 'no'}">
			<dt><i class="Hui-iconfont" style="font-size:20px;">&#xe643;</i> 对接管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="/flowsys/platform/platform_list.do" data-title="平台列表" href="javascript:void(0)">平台列表</a></li>
					<li><a data-href="/flowsys/productCode/product_code_list.do" data-title="流量编码" href="javascript:void(0)"><i class="Hui-iconfont">&#xe675;</i> 流量编码</a></li>
					<li><a data-href="/flowsys/tel_product/telproduct_list.do" data-title="话费编码列表" href="javascript:void(0)"><i class="Hui-iconfont">&#xe6a3;</i> 话费编码</a></li>
				</ul>
			</dd>
		</c:if>
	</dl>
	</c:if>
	
	<c:if test="${not empty telLogin }">
	<%-- <dl>
 	<dt>余额：<a title="/flowsys/account/charge_list.do?agencyId=${loginContext.id }" data-href="/flowsys/account/charge_list.do?agencyId=${loginContext.id }" data-title="充值记录" onclick="Hui_admin_tab(this)"><c:if test="${empty chargeAccount.accountBalance && empty chargeAccount1.accountBalance }">0.00</c:if> ${chargeAccount.accountBalance + chargeAccount1.accountBalance}<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></a></dt>
 	<dd>  余额：<a title="/flowsys/account/charge_list.do?agencyId=${loginContext.id }" data-href="/flowsys/account/charge_list.do?agencyId=${loginContext.id }" data-title="充值记录" onclick="Hui_admin_tab(this)"><c:if test="${empty chargeAccount.accountBalance && empty chargeAccount1.accountBalance }">0.00</c:if> ${chargeAccount.accountBalance + chargeAccount1.accountBalance}</a>
 	</dd></dl> --%>
	<dl>
 		 <dt>
 		 	<i class="Hui-iconfont" style="font-size:20px;">&#xe705;</i> 个人中心<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
 		 </dt> 
	 	<dd>
 			<ul>
 				<li><a title="" data-href="/flowsys/agency/agency_info.do" data-title="个人信息" onclick="Hui_admin_tab(this)">个人信息 </a></li>
				<li><a title="" data-href="/flowsys/account/charge_list.do?agencyId=${loginContext.id }" data-title="充值记录" onclick="Hui_admin_tab(this)">余额：<c:if test="${empty chargeAccount.accountBalance && empty chargeAccount1.accountBalance }">0.00</c:if> ${chargeAccount.accountBalance + chargeAccount1.accountBalance}</a></li>
				<li><a href="/flowsys/agency/logout.do">切换账户</a></li>
				 <!-- <li><a data-href="/flowsys/bankAccount/my_bank_list.do" data-title="申请加款" href="javascript:void(0)" onclick="Hui_admin_tab(this)">申请加款</a></li> -->
 				<li><a title="" data-href="/flowsys/agency/reset_pass_page.do" data-title="修改密码" onclick="Hui_admin_tab(this)"><%-- ${loginContext.userName} --%>修改密码 </a></li>
				<!-- <li><a href="javascript:;" onClick="resetPass()">修改密码</a></li> -->
				<li><a href="/flowsys/agency/logout.do">退出</a></li>
			</ul>
		</dd>
	 </dl>
	<dl>
	 <dt><i class="Hui-iconfont" style="font-size:20px;">&#xe68a;</i>  消息<c:if test="${msgNum != 0 }">
			<span class="badge badge-danger">${msgNum }</span>
			</c:if><i class="Hui-iconfont menu_dropdown-arrow" style="font-size:18px">&#xe6d5; </i>
	 </dt> 
	<dd>
		<ul >
			<c:if test="${loginContext.rootAgencyId == 0 }">
				<li><a data-href="/flowsys/account/confirm_company_account_page.do" data-title="认证审核" title="认证审核" onclick="Hui_admin_tab(this)">认证审核 &nbsp;&nbsp;&nbsp;&nbsp;  ${unconfirmSize }</a></li>
			</c:if>
			<c:forEach items="${transferMsgList }" var="transferMsg" varStatus="vst">
				<li><a data-href="/flowsys/bankAccount/transfer_record.do?bankId=${transferMsg.id }&confirmState=2&direction=0" data-title="转账审核" title="转账审核" onclick="Hui_admin_tab(this)">${transferMsg.remmitanceBankAccount} &nbsp;&nbsp;&nbsp;&nbsp;  <span class="c-danger">${transferMsg.tfnum}</span></a></li>
			</c:forEach>
		</ul>
	</dd>
	 </dl>
	</c:if>
	<!-- <dl>
	 <dt> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i>换肤</a>
	 </dt> 
	<dd>
		<ul>
			<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
			<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
			<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
			<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
			<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
			<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
		</ul>
	</dd>
	 </dl> -->
 		<%--  <dl>
 		 <dt> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
		</dt>
		 <dd> <c:if test="${loginContext.rootAgencyId == 0 }">
				<dd><a data-href="/flowsys/account/confirm_company_account_page.do" data-title="认证审核" title="认证审核" onclick="Hui_admin_tab(this)">认证审核 &nbsp;&nbsp;&nbsp;&nbsp;  ${unconfirmSize }</a></dd>
			</c:if>
			<c:forEach items="${transferMsgList }" var="transferMsg" varStatus="vst">
				<dd><a data-href="/flowsys/bankAccount/transfer_record.do?bankId=${transferMsg.id }&confirmState=2&direction=0" data-title="转账审核" title="转账审核" onclick="Hui_admin_tab(this)">${transferMsg.remmitanceBankAccount} &nbsp;&nbsp;&nbsp;&nbsp;  <span class="c-danger">${transferMsg.tfnum}</span></a></dd>
			</c:forEach>
		</dd>
		</dl>
		 <dl>
 		 <dt>  <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a></dt> 
 		  <dd><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></dd>
			<dd><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></dd>
			<dd><a href="javascript:;" data-val="green" title="绿色">绿色</a></dd>
			<dd><a href="javascript:;" data-val="red" title="红色">红色</a></dd>
			<dd><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></dd>
			<dd><a href="javascript:;" data-val="orange" title="橙色">橙色</a></dd>
		</dl>
 --%>
	<!-- http://htmlify.wps.cn/doc/index.html?ksyun=UD4oMeA6/word.html&theme=clear -->
	<dl id="menu-member">
		<dt><i class="Hui-iconfont" style="font-size:20px;">&#xe633;</i> 平台相关<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
		<dd>
			<ul>
			<c:if test="${loginContext.rootAgencyId == 0 }">
				<li><a href="/view/index.html" title="平台页面模板" target="_blank">平台页面模板</a></li>
			</c:if>
			<c:choose>
				<c:when test="${empty telLogin }"><!-- 当前不是手机模式 -->
					<li><a href="/flowsys/agency/logout.do?logOutModel=1" title="手机模式" target="_self">手机模式</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/flowsys/agency/logout.do?logOutModel=2" title="一般模式" target="_self">一般模式</a></li>
				</c:otherwise>
			</c:choose>
				<li><a href="/view/mine/jk-doc/jk-doc.html" title="南昌微族流量接口文档" target="_blank">流量接口文档</a></li>
				<li><a data-href="http://htmlify.wps.cn/doc/index.html?ksyun=hPT1Afio/word.html&theme=clear" data-title="平台操作指南" href="javascript:void(0)">平台操作指南</a></li>
			</ul>
		</dd>
	</dl>
	<%-- <ul>
		<c:if test="${loginContext.agencyTag == 1 }">
			<!-- <li><a data-href="/view/mine/jk-doc/jk-doc.html" data-title="南昌微族接口文档" href="javascript:void(0)">南昌微族接口文档</a></li> -->
			<!-- <li><a href="/view/mine/jk-doc/jk-doc.html" data-title="南昌微族接口文档" target="_blank">南昌微族接口文档</a></li> -->
			<li><a href="/view/mine/jk-doc/jk-doc.html" data-title="南昌微族接口文档" target="_blank">南昌微族接口文档</a></li>
		</c:if>
					<li><a data-href="http://htmlify.wps.cn/doc/index.html?ksyun=UD4oMeA6/word.html&theme=clear" data-title="平台操作指南" href="javascript:void(0)">平台操作指南</a></li>
	</ul> --%>
	
		<!-- <dl id="menu-member">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 会员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="/view/member-list.html" data-title="会员列表" href="javascript:;">会员列表</a></li>
					<li><a data-href="/view/member-del.html" data-title="删除的会员" href="javascript:;">删除的会员</a></li>
					<li><a data-href="/view/member-level.html" data-title="等级管理" href="javascript:;">等级管理</a></li>
					<li><a data-href="/view/member-scoreoperation.html" data-title="积分管理" href="javascript:;">积分管理</a></li>
					<li><a data-href="/view/member-record-browse.html" data-title="浏览记录" href="javascript:void(0)">浏览记录</a></li>
					<li><a data-href="/view/member-record-download.html" data-title="下载记录" href="javascript:void(0)">下载记录</a></li>
					<li><a data-href="/view/member-record-share.html" data-title="分享记录" href="javascript:void(0)">分享记录</a></li>
			</ul>
		</dd>
	</dl>
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="/view/admin-role.html" data-title="角色管理" href="javascript:void(0)">角色管理</a></li>
					<li><a data-href="/view/admin-permission.html" data-title="权限管理" href="javascript:void(0)">权限管理</a></li>
					<li><a data-href="/view/admin-list.html" data-title="管理员列表" href="javascript:void(0)">管理员列表</a></li>
			</ul>
		</dd>
	</dl>
		<dl id="menu-tongji">
			<dt><i class="Hui-iconfont">&#xe61a;</i> 系统统计<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="/view/charts-1.html" data-title="折线图" href="javascript:void(0)">折线图</a></li>
					<li><a data-href="/view/charts-2.html" data-title="时间轴折线图" href="javascript:void(0)">时间轴折线图</a></li>
					<li><a data-href="/view/charts-3.html" data-title="区域图" href="javascript:void(0)">区域图</a></li>
					<li><a data-href="/view/charts-4.html" data-title="柱状图" href="javascript:void(0)">柱状图</a></li>
					<li><a data-href="/view/charts-5.html" data-title="饼状图" href="javascript:void(0)">饼状图</a></li>
					<li><a data-href="/view/charts-6.html" data-title="3D柱状图" href="javascript:void(0)">3D柱状图</a></li>
					<li><a data-href="/view/charts-7.html" data-title="3D饼状图" href="javascript:void(0)">3D饼状图</a></li>
			</ul>
		</dd>
	</dl>
		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="/view/system-base.html" data-title="系统设置" href="javascript:void(0)">系统设置</a></li>
					<li><a data-href="/view/system-category.html" data-title="栏目管理" href="javascript:void(0)">栏目管理</a></li>
					<li><a data-href="/view/system-data.html" data-title="数据字典" href="javascript:void(0)">数据字典</a></li>
					<li><a data-href="/view/system-shielding.html" data-title="屏蔽词" href="javascript:void(0)">屏蔽词</a></li>
					<li><a data-href="/view/system-log.html" data-title="系统日志" href="javascript:void(0)">系统日志</a></li>
			</ul>
		</dd>
	</dl> -->
</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active">
					<span title="我的桌面" data-href="/flowsys/rate/welcome.do">我的通道</span>
					<em></em></li>
		</ul>
	</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="/flowsys/rate/welcome.do"></iframe>
	</div>
</div>
</section>

<div class="contextMenu" id="Huiadminmenu">
	<ul>
		<li id="closethis">关闭当前 </li>
		<li id="closeall">关闭全部 </li>
		<li id="closeother">关闭其他 </li>
</ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/view/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
//收藏本站 www.jb51.net
function AddFavorite(title, url) {
 try {
   window.external.addFavorite(url, title);
 }
catch (e) {
   try {
    window.sidebar.addPanel(title, url, "");
  }
   catch (e) {
     alert("抱歉，您所使用的浏览器无法完成此操作。\n\n加入收藏失败，请进入新网站后使用Ctrl+D进行添加");
   }
 }
}

$(function(){
	$("#min_title_list li").contextMenu('Huiadminmenu', {
		bindings: {
			'closethis': function(t) {
				console.log(t);
				if(t.find("i")){
					t.find("i").trigger("click");
				}		
			},
			'closeall': function(t) {
				alert('Trigger was '+t.id+'\nAction was Email');
			},
		}
	});
});
/**个人信息*/
/* function myselfinfo(){
	layer.open({
        type: 2,
        title: "个人信息",
        area: ['500px', '600px'],
        maxmin: false,
        closeBtn: 1,
        content: '/flowsys/agency/agency_info.do',
        end: function () {
            //location.reload();
        }
    });
} */
/**修改密码*/
/*  function resetPass(){
	layer.open({
        type: 2,
        title: "重置密码",
        area: ['1000px', '500px'],
        maxmin: false,
        closeBtn: 1,
        content: '/flowsys/agency/reset_pass_page.do?tag=1',
        end: function () {
           // location.reload();
        }
    });
}  */

</script> 
</body>
</html>