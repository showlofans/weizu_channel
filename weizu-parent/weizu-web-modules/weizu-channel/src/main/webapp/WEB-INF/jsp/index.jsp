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
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
	<META HTTP-EQUIV="Expires" CONTENT="0"> 
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
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
<title>H-ui.admin 3.0</title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="/aboutHui.shtml">微族通道系统</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml">H-ui</a> 
			<span class="logo navbar-slogan f-l mr-10 hidden-xs">1.0</span> 
			<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
			<nav class="nav navbar-nav">
				<ul class="cl">
					<li class="dropDown dropDown_hover"><a href="javascript:;" class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i class="Hui-iconfont">&#xe6d5;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a href="javascript:;"  onclick="Hui_admin_tab(this)"  data-title="通道添加" data-href="/flowsys/channel/channel_add_page.do" ><i class="Hui-iconfont">&#xe616;</i> 通道</a></li>
							<li><a href="javascript:;" onclick="Hui_admin_tab(this)"  data-title="费率添加" data-href="/flowsys/rate/rate_add_page.do" ><i class="Hui-iconfont">&#xe613;</i> 费率</a></li>
							<li><a href="javascript:;" onclick="Hui_admin_tab(this)"  data-title="流量包添加" data-href="/flowsys/operatorPg/pg_add_page.do" ><i class="Hui-iconfont">&#xe620;</i> 标准包</a></li>
							<li><a href="javascript:;" onclick="Hui_admin_tab(this)"  data-title="平台添加" data-href="/flowsys/platform/platform_add_page.do" ><i class="Hui-iconfont">&#xe60d;</i> 平台添加</a></li>
					</ul>
				</li>
			</ul>
		</nav>
			<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
				<ul class="cl">
					<!-- <li>超级管理员</li> -->
					<li>个人信用：<a href="#"><c:if test="${empty chargeAccount.accountCredit }">0.00</c:if> ${chargeAccount.accountCredit }</a></li>
					<li>余额：<a title="/flowsys/account/charge_list.do?agencyId=${loginContext.id }" data-href="/flowsys/account/charge_list.do?agencyId=${loginContext.id }" data-title="充值扣款记录" onclick="Hui_admin_tab(this)"><c:if test="${empty chargeAccount.accountBalance && empty chargeAccount1.accountBalance }">0.00</c:if> ${chargeAccount.accountBalance + chargeAccount1.accountBalance}</a></li>
					<li class="dropDown dropDown_hover">
						<a href="javascript:;" onClick="myselfinfo()" class="dropDown_A">${loginContext.userName} <i class="Hui-iconfont">&#xe6d5;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a href="javascript:;" onClick="myselfinfo()">个人信息</a>
							</li>
							<li><a href="/flowsys/agency/logout.do">切换账户</a></li>
							<li><a href="javascript:;" onClick="resetPass()">修改密码</a></li>
							<li><a href="/flowsys/agency/logout.do">退出</a></li>
					</ul>
				</li>
					<li id="Hui-msg"> <a href="#" title="消息"><span class="badge badge-danger">2</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li>
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
		<dl id="menu-picture"><!-- menu_dropdown-arrow -->
			<dt><i class="Hui-iconfont">&#xe679;</i> 通道管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="/flowsys/channel/channel_add_page.do" data-title="通道添加" href="javascript:void(0)">通道添加</a></li>
					<li><a data-href="/flowsys/channel/channel_list.do" data-title="通道列表" href="javascript:void(0)">通道列表</a></li>
					<!-- <li><a data-href="/flowsys/rate/bind_channel_list.do?bindTag=bAgency" data-title="活动通道" href="javascript:void(0)">活动通道</a></li> -->
					<c:if test="${power== 'no'}">
						<li><a data-href="/flowsys/platform/platform_list.do" data-title="平台管理" href="javascript:void(0)">平台管理</a></li>
						<li><a data-href="/flowsys/productCode/product_code_list.do" data-title="产品编码" href="javascript:void(0)">产品编码</a></li>
					</c:if>
			</ul>
		</dd>
	</dl>
		<dl id="menu-product">
			<dt><i class="Hui-iconfont">&#xe674;</i> 代理商管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<!-- <li><a data-href="/flowsys/rate/rate_add_page.do" data-title="费率添加" href="javascript:void(0)">费率添加</a></li>
					<li><a data-href="/flowsys/rate/rate_list.do" data-title="费率列表" href="javascript:void(0)">费率列表</a></li> -->
					<li><a data-href="/flowsys/agency/child_agency_list.do" data-title="认证用户" href="javascript:void(0)">认证用户</a></li>
					<li><a data-href="/flowsys/agency/child_agency_list.do" data-title="代理商" href="javascript:void(0)">代理商</a></li>
					<!-- <li><a data-href="/flowsys/agency/get_tel_location.do" data-title="号码归属地查询" href="javascript:void(0)">号码归属地查询</a></li> -->
			</ul>
		</dd>
	</dl>
		<dl id="menu-comments">
			<dt><i class="Hui-iconfont">&#xe687;</i> 订单管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="/flowsys/chargePg/purchase_list.do" data-title="订单列表" href="javascript:void(0)">订单列表</a></li>
			</ul>
		</dd>
	</dl>
		<dl id="menu-comments">
			<dt><i class="Hui-iconfont">&#xe687;</i> 在线充值<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="/flowsys/chargePg/pg_charge_page.do" title="/flowsys/chargePg/pg_charge_page.do" data-title="流量充值" href="javascript:;">流量充值</a></li>
			</ul>
		</dd>
	</dl>
	<dl id="menu-article">
			<dt><i class="Hui-iconfont">&#xe6c6;</i> 流量包管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="/flowsys/operatorPg/operatorPg_list.do" data-title="流量包管理" href="javascript:void(0)">流量包管理</a></li>
			</ul>
		</dd>
	</dl>
	<dl id="menu-member">
		<dt><i class="Hui-iconfont">&#xe6c6;</i> 账户管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
		<dd>
			<ul>
				<!-- <li><a data-href="/flowsys/account/open_company_account_page.do" data-title="认证信息" href="javascript:void(0)">认证信息</a></li> -->
				<c:if test="${chargeAccount1 == null && (companyAccount == 'yes' || power == 'no' ) }">
					<li><a data-href="/flowsys/account/open_company_account_page.do" data-title="开通对公账号" href="javascript:void(0)">开通对公账号</a></li>
				</c:if>
				<li><a data-href="/flowsys/account/consume_list.do" data-title="消费记录" href="javascript:void(0)">消费记录</a></li>
				<li><a data-href="/flowsys/account/charge_list.do" data-title="充值记录" href="javascript:void(0)">充值记录</a></li>
				<li><a data-href="/flowsys/account/account_info.do" data-title="账户信息" href="javascript:void(0)">账户信息</a></li>
			</ul>
		</dd>
	</dl>
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
					<span title="我的桌面" data-href="/flowsys/rate/welcome.do">我的桌面</span>
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
function myselfinfo(){
	layer.open({
        type: 2,
        title: "个人信息",
        area: ['1000px', '500px'],
        maxmin: false,
        closeBtn: 1,
        content: '/flowsys/agency/agency_info.do',
        end: function () {
            location.reload();
        }
    });
}
/**修改密码*/
function resetPass(){
	layer.open({
        type: 2,
        title: "重置密码",
        area: ['1000px', '500px'],
        maxmin: false,
        closeBtn: 1,
        content: '/flowsys/agency/reset_pass_page.do',
        end: function () {
            location.reload();
        }
    });
}

/*资讯-添加*/
function article_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*图片-添加*/
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}


</script> 
</body>
</html>