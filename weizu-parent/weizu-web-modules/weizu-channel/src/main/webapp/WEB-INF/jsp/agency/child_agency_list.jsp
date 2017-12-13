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
<title>资讯列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 代理商管理 <span class="c-gray en">&gt;</span> 
<c:choose>
	<c:when test="${resultMap.params.agencyTag == 1 }">
		认证代理商列表
	</c:when>
	<c:otherwise>
		代理商列表
	</c:otherwise>
</c:choose>
 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
<div class="page-container">
	<!-- <a href="getRegisterPage.do">生成代理商注册页面</a> -->
	<div class="text-c">
		<form action="/flowsys/agency/child_agency_list.do" method="post" id="formD" name="dataListForm">
				<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
				<button type="button"class="btn btn-success" onclick="javascript:location.replace(location.href);" value="重置">重置</button>
				代理商名称:<input type="text"  value="${resultMap.params.userName }" name="userName" id="" placeholder=" 代理商名称" style="width:150px" class="input-text">
				备注信息:<input type="text"  value="${resultMap.params.agencyMark }" name="agencyMark"" placeholder=" 备注信息" style="width:150px" class="input-text">
				<!-- <input type="text" style="width:150px" class="input-text" name="start_datetime"  value="2017-05-26 00:00:00"  onClick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
	                  	<em class="inputto">至</em>
	            <input style="width:150px" type="text" class="input-text" name="end_datetime"   value="2017-05-26 23:59:59"  onClick="WdatePicker({startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> -->
				<c:if test="${resultMap.params.agencyTag == 1 }"><!-- 认证用户页面 -->
				账户类型：<span class="select-box inline">
							<select name="billType"  id="billType" class="select" onchange="formSub()">
								<option value="">请选择</option>
								<c:forEach items="${resultMap.billTypeEnums }" var="billEnum" varStatus="vs1">
									<option value="${billEnum.value }" <c:if test="${billEnum.value == resultMap.params.billType }"> selected</c:if>>${billEnum.desc }</option>
								</c:forEach>
							</select>
						</span>
				</c:if>
				<button name="" id="" class="btn btn-success"  type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜代理</button>
				<c:if test="${loginContext.rootAgencyId == 0 }">
					<a class="c-red" style="text-decoration:none" data-href="/flowsys/account/confirm_company_account_page.do" data-title="认证审核" title="认证审核" onclick="Hui_admin_tab(this)">认证审核</a>
				</c:if>
				<c:if test="${empty resultMap.pagination.records }">
					<a  style="text-decoration:none" data-toggle="tooltip" data-href='/view/mine/html/agency_help.html' data-placement="top" class="ml-5 c-red" onclick="Hui_admin_tab(this)" data-title="代理商指南">代理商指南</a>
				</c:if>
				<input type="hidden" name="pageNo" value="${resultMap.pagination.pageNo }"> 
				<input type="hidden" name="agencyTag" value="${resultMap.params.agencyTag }"> 
				<!--  <div class="form-group pt5">提交时间：<div class="input-group" style="width:150px"><span class="input-group-addon"><i class="fa fa-calendar ft13em"></i></span> <input type="text" placeholder="开始时间" data-date-format="YYYY-MM-DD HH:mm:ss" name="created_start" id="created_start"></div>--
				<div class="input-group" style="width:150px"><span class="input-group-addon"><i class="fa fa-calendar ft13em"></i></span> <input type="text" placeholder="结束时间" data-date-format="YYYY-MM-DD HH:mm:ss" name="created_end" id="created_end"></div>
				</div>  -->
		</form>
	</div>
	<!-- <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" data-title="添加资讯" data-href="article-add.html" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加资讯</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div> -->
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<!-- <th width="25"><input type="checkbox" name="" value=""></th> -->
					<!-- <th width="80">流量包Id</th> -->
					<th width="80">代理名称</th>
					<th width="80">真实姓名</th>
					<th width="80">联系电话</th>
					<th width="80">邮箱</th>
					<!-- <th width="75">地址</th> -->
					<th width="60">余额</th>
					<!-- <th width="60">信用</th> -->
					<th width="60">账户类型</th>
					<!-- <th width="60">费率</th>
					<th width="60">带票费率</th> -->
					
					<th width="120">操作</th>
					<th width="120">创建时间</th>
				</tr>
			</thead>
			<tbody>
				<!-- <tr class="text-c">
				</tr> -->
				<c:forEach items="${resultMap.pagination.records }" var="agency" varStatus="vs">
					<tr class="text-c">
						<%-- <td style="display:none">${agency.id }</td> --%>
						<td>
						<c:choose>
							<c:when test="${agency.billType == 0 }">
								<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
									<c:if test="${billTypeEnum.value == 0 }">
										<span class="c-red" ><!-- data-toggle="tooltip"   data-placement="right" title="${billTypeEnum.desc }" -->
										${agency.userName }</span>
									</c:if>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
								<c:if test="${billTypeEnum.value == 1 }">
									<span class="c-green"><!--  data-toggle="tooltip"  data-placement="right" title="${billTypeEnum.desc }" -->
									${agency.userName }</span>
								</c:if>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						</td>
						<td>
							<span data-toggle="tooltip" data-placement="top" title="${agency.agencyMark }">
								${agency.userRealName }
							</span>
						</td>
						<!-- <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','article-zhang.html','10001')" title="查看">资讯标题</u></td> -->
						<td>${agency.agencyTel }</td>
						 <td>${agency.userEmail }</td>
						<%-- <td>${agency.agencyIp }</td> --%>
						<td style="display:none">${loginContext.id }</td>
						<!-- title="/flowsys/account/charge_list.do?agencyId=${agency.id }" -->
						<td>
						<c:choose>
							<c:when test="${agency.accountBalance <=0  }">
								<a class="c-error" data-href="/flowsys/account/charge_list.do?accountId=${agency.accountId }" data-toggle="tooltip" data-placement="top" title="点击查看记录" data-title="充值记录" style="text-decoration:none"  onclick="Hui_admin_tab(this)">
							${agency.accountBalance }</a>
							</c:when>
							<c:otherwise>
								<a class="c-green" data-href="/flowsys/account/charge_list.do?accountId=${agency.accountId }" data-toggle="tooltip" data-placement="top" title="点击查看记录" data-title="充值记录" style="text-decoration:none"  onclick="Hui_admin_tab(this)">
							${agency.accountBalance }</a>
							</c:otherwise>
						</c:choose>
						</td>
						<%-- <td>${agency.accountCredit }</td> --%>
						
						<td class="td-status"><c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vs1">
						<c:if test="${agency.billType == billTypeEnum.value }"> ${billTypeEnum.desc }</c:if>
						</c:forEach></td>
						<td class="td-manage">
							<a data-toggle="tooltip" data-placement="top" style="text-decoration:none;cursor:pointer" onClick="editAgency(${agency.id })" href="javascript:;" title="查看信息"><i class="Hui-iconfont">&#xe60c;</i></a>
							<%-- <a data-toggle="tooltip" data-placement="top" style="text-decoration:none" onClick="resetPass('/flowsys/agency/reset_pass_page.do?tag=0&agencyId=${agency.id}')" href="javascript:;" title="重置密码"><i class="Hui-iconfont">&#xe63f;</i></a> --%>
							<a data-toggle="tooltip" data-placement="top" style="text-decoration:none"  data-href="/flowsys/agency/reset_pass_page.do" data-title="重置密码" onclick="Hui_admin_tab(this)" title="重置密码"><i class="Hui-iconfont">&#xe63f;</i></a>
							<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" class="ml-5" onClick="account_charge('账户充值',${agency.accountId })" href="javascript:;" title="账户充值"><i class="Hui-iconfont">&#xe726;</i></a> 
							<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" class="ml-5" data-title="设置充值卡" data-href="/flowsys/bankAccount/attach_bank_page.do?accountId=${agency.accountId }" onClick="Hui_admin_tab(this)"><i class="Hui-iconfont">&#xe725;</i></a> 
							<%-- <a title="/flowsys/rate/rate_add_page.do?rateId=${agency.rateId }&agencyId=${agency.id}" data-href="/flowsys/rate/rate_add_page.do?rateId=${agency.rateId }&agencyId=${agency.id}" data-title="费率添加" onclick="Hui_admin_tab(this)"><i class="Hui-iconfont">&#xe6df;</i></a> --%>
							<c:choose>
								<c:when test="${loginContext.rootAgencyId == 0 }">
									<a data-toggle="tooltip" data-placement="top" style="text-decoration:none"  title="配置通道" data-href="/flowsys/rate/bind_channel_list.do?accountId=${agency.accountId }&agencyName=${agency.userName}&billTypeRate=${agency.billType}" data-title="配置通道" onclick="Hui_admin_tab(this)"><i class="Hui-iconfont">&#xe604;</i></a>
								</c:when>
								<c:otherwise>
									<a data-toggle="tooltip" data-placement="top" style="text-decoration:none"  title="配置折扣" data-href="/flowsys/rate/my_rate_list.do?accountId=${agency.accountId }&agencyName=${agency.userName}" data-title="配置折扣" onclick="Hui_admin_tab(this)"><i class="Hui-iconfont">&#xe604;</i></a>
								</c:otherwise>
							</c:choose>
							
						</td>
						<td>${agency.createTimeStr }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="agencyId" />  
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
<!-- jQuery -->

<!-- <script type="text/javascript" src="/view/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" charset="utf8" src="/view/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> -->
<script type="text/javascript" src="/view/lib/laypage/1.2/laypage.js"></script>
<!-- 时间选择器 -->
<!--  <script src="/view/lib/moment.js"></script>
<script src="/view/lib/bootstrap-datetimepicker.min.js"></script>
<script src="/view/lib/bootstrap-datetimepicker.zh-CN.js"></script> -->
<script type="text/javascript">
/**充值卡设置*/
function attach_bank(title,url,accountId){
	//alert("sd");
	layer.open({
        type: 2,
        title: title,
        area: ['430px', '500px'],
        maxmin: false,
        closeBtn: 1,
        content: url+'?accountId=' + accountId,
         end: function () {
            location.reload();
        }
    });
}
/*onchange通道状态*/
function formSub(){
	//alert($(vart).val());
	$('form').submit();
}
/**重置密码*/
/* function resetPass(agencyId){
	layer.open({
        type: 2,
        title: "重置密码",
        area: ['1000px', '500px'],
        maxmin: false,
        closeBtn: 1,
        content: '/flowsys/agency/reset_pass_page.do?tag=0&agencyId='+agencyId,
        end: function () {
            location.reload();
        }
    });
} */

/**账户-充值 */
function account_charge(title,accountId){
	layer.open({
        type: 2,
        title: "账户充值",
        area: ['430px', '500px'],
        maxmin: false,
        closeBtn: 1,
        content: '/flowsys/account/add_charge_page.do?accountId=' + accountId,
        end: function () {
            location.reload();
        }
    });
	/* layer.full(index); */
}
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
</script> 
</body>
</html>