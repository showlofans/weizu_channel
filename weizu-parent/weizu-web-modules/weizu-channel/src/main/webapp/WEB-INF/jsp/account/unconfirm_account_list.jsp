<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/MyTaglib.tld" prefix="mytag"%>
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

<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>待充值审核列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 消息管理 <span class="c-gray en">&gt;</span> 待认证代理商列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
<div class="page-container">
	<%-- <form action="/flowsys/account/charge_list.do" method="post" id="formD" name="dataListForm">
		<div class="text-c">
		<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
			代理商名称:<input type="text" value="${resultMap.searchParams.userName }" name="userName" id="" placeholder=" 代理商名称" style="width:250px" class="input-text">
			交易时间：
			<input type="text" style="width:150px" class="input-text" name="startTimeStr"  value="${resultMap.searchParams.startTimeStr }"  onfocus="var endTimeStr=$dp.$('endTimeStr');WdatePicker({onpicked:function(){endTimeStr.focus();},autoPickDate:true,startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss' })"/>
	            <em class="inputto">至</em>
	        <input style="width:150px" type="text"  class="input-text" name="endTimeStr" id="endTimeStr"   value="${resultMap.searchParams.endTimeStr }"  onfocus="WdatePicker({autoPickDate:true,startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
			<button type="reset"class="btn btn-success" value="重置">重置</button>
			<button class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 查询</button>
			<input type="hidden" name="pageNo" value="${resultMap.pagination.pageNo }"> 
		</div>
	</form> --%>
	</div>
	<!-- <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" data-title="添加资讯" data-href="article-add.html" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加资讯</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div> -->
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<!-- <th width="80">流量包Id</th> -->
					<th width="80">代理商名称</th>
					<th width="80">公司名称</th>
					<th width="60">银行账号</th>
					<th width="80">发票收件人</th>
					<th width="75">收件人电话</th>
					<th width="120">收件地址</th>
					<th width="60">公司地址</th>
					<th width="80">商务负责人姓名</th>
					<th width="80">商务联系电话</th>
					<th width="80">紧急联系人</th>
					<th width="80">紧急联系人电话</th>
					<th width="80">提交时间</th>
					<th width="80">审核时间</th>
					<th width="80">审核状态</th>
					<th width="80">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.unconfirmList }" var="unconfirm" varStatus="vs">
					<tr class="text-c">
						<%-- <td>${pg.pgId }</td> --%>
						<td>${unconfirm.agencyName }</td>
						<td>${unconfirm.companyName }</td>
						<td>${unconfirm.bankAccount }</td><!-- 代理名称 -->
						<td>${unconfirm.billRecipientsName }</td>
						<!-- <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','article-zhang.html','10001')" title="查看">资讯标题</u></td> -->
						<td>${unconfirm.billRecipientsTel }</td>
						 <td>${unconfirm.billRecipientsAddress }</td>
						<td>${unconfirm.companyLocation }</td>
						 <td>${unconfirm.businessExecutiveName }</td>
						 <td>${unconfirm.beTel }</td>
						 <td>${unconfirm.emergencyContact }</td>
						 <td>${unconfirm.ecTel }</td>
						 <td>${unconfirm.commitTimeStr }</td>
						 <td>${unconfirm.confirmTimeStr }</td>
						<td><c:forEach items="${resultMap.confirmStateEnums }" var="confirmStateE" varStatus="vs1">
						<!-- <td class="td-status"><span class="label label-success radius">已发布</span></td> -->
						<c:if test="${unconfirm.confirmState == confirmStateE.value }"> <span class="label label-defaunt radius">${confirmStateE.desc }</span></c:if>
						</c:forEach></td>
						<td>
							<c:choose>
								<c:when test="${unconfirm.confirmState != 1}">
									<%-- ${unconfirm.confirmState} --%>
									<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" class="ml-5" onClick="confirmState(${unconfirm.id },${unconfirm.agencyId },1)" href="javascript:;" title="审核通过"><i class="Hui-iconfont">&#xe6e1;</i></a>
									<a style="text-decoration:none" data-toggle="tooltip" data-placement="top" class="ml-5" onClick="confirmState(${unconfirm.id },${unconfirm.agencyId },0)" href="javascript:;" title="审核不通过"><i class="Hui-iconfont">&#xe6e0;</i></a>
								</c:when>
								<c:otherwise>
									
								</c:otherwise>
							</c:choose>
						</td>
						<!-- 备注 -->
						<%-- <td><c:forEach items="${resultMap.accountTypeEnum }" var="accountType" varStatus="vs1">
						<c:if test="${unconfirm.accountType == accountType.value }"> ${accountType.desc }</c:if>
						</c:forEach></td> --%>
						<%-- <td>${unconfirm.remittanceTimeStr }</td> --%>
						<%-- <fmt:formatDate value="${unconfirm.remittanceTime }" pattern="yyyy-MM-dd HH:mm:ss"/> ${unconfirm.remittanceTime }</td> --%>
						<%-- <td class="td-status"><c:forEach items="${resultMap.pgInEnums }" var="pgIn" varStatus="vs1">
						
						<c:if test="${pg.pgInService == pgIn.value }"> ${pgIn.desc }</c:if>
						</c:forEach></td> --%>
					<!-- 	<td class="td-status"><span class="label label-success radius">已发布</span></td> -->
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%-- <mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="recordId" /> --%>  
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
<script type="text/javascript">
function confirmState(id,agencyId,state){
	var tips = '确认通过认证吗？';
	//alert(state);
	if(state=='0'){
		tips = '确认否定认证吗？';
	}
	layer.confirm(tips,function(index){
		$.ajax({
			type: 'POST',
			url: '/flowsys/account/verify_credentials.do?id='+id +'&agencyId='+agencyId+'&confirmState='+state,
			//dataType: 'json',
			success: function(data){
				//$(obj).parents("tr").remove();
				//alert(data);
				if(data == 'success'){
					layer.msg('已验证!',{icon:1,time:1000});
					location.reload();
				}
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
/* function search1(){
	alert($("#startTime").val());
	alert($("#endTime").val());
} */
/* $(document).ready(function() {
	var date = new Date();    
	var startTime = "00:00:00";
	var endTime = "23:59:59";
	 var seperator1 = "-";
    //var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var startdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
    + " " + startTime;
    var enddate = date.getFullYear() + seperator1 + month + seperator1 + strDate
    + " " + endTime;
    $("#startTime").val(startdate);
    $("#endTime").val(enddate);
    
    
	//$("#startTime").val()
	//alert(new Date($("#time").html());
	//$("#time").val(new Date($("#time").val()).format("yyyy-MM-dd hh:mm:ss"));
})  */
/*资讯-删除*/
/* function article_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
} */

</script> 
</body>
</html>