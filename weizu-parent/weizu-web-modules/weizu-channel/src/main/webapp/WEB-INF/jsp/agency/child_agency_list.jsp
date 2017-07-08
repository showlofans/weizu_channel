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
<title>资讯列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 下游管理 <span class="c-gray en">&gt;</span> 代理商列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<!-- <a href="getRegisterPage.do">生成代理商注册页面</a> -->
	<div class="text-c">
		<form action="/flowsys/agency/child_agency_list.do" method="post" id="formD" name="dataListForm">
				<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
				代理商名称:<input type="text"  value="${resultMap.params.userName }" name="userName" id="" placeholder=" 代理商名称" style="width:250px" class="input-text">
				<!-- <input type="text" style="width:150px" class="input-text" name="start_datetime"  value="2017-05-26 00:00:00"  onClick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
	                  	<em class="inputto">至</em>
	            <input style="width:150px" type="text" class="input-text" name="end_datetime"   value="2017-05-26 23:59:59"  onClick="WdatePicker({startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> -->
				
				<button type="reset"class="btn btn-success" value="重置">重置</button>
				<button name="" id="" class="btn btn-success" onClick="search1()" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
				<input type="hidden" name="pageNo" value="${resultMap.pagination.pageNo }"> 
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
					<th width="75">地址</th>
					<th width="60">余额</th>
					<th width="60">信用</th>
					<!-- <th width="60">费率</th>
					<th width="60">带票费率</th> -->
					<th width="120">操作</th>
					<th width="120">创建时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="agency" varStatus="vs">
					<tr class="text-c font-red">
						<!-- <td><input type="checkbox" value="" name=""></td> -->
						<%-- <td>${pg.pgId }</td> --%>
						<%-- <form action="agency_edit_page.do" method="post">
							<input name="userName" value="${agency.userName }">
							<input name="userRealname" value="${agency.userRealname }">
							<input name="agencyTel" value="${agency.agencyTel }">
							<input name="userEmail" value="${agency.userEmail }">
							<input name="agencyIp" value="${agency.agencyIp }">
							<input name="id" value="${agency.id }">
							<input name="rootAgencyId" value="${loginContext.id }">
							<input name="accountBalance" value="${agency.accountBalance }">
							<input name="accountCredit" value="${agency.accountCredit }">
							<input name="rateId" value="${agency.rateId }">
						</form> --%>
						<td style="display:none">${agency.id }</td>
						<td>${agency.userName }</td>
						<td>${agency.userRealName }</td>
						<!-- <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','article-zhang.html','10001')" title="查看">资讯标题</u></td> -->
						<td>${agency.agencyTel }</td>
						 <td>${agency.userEmail }</td>
						<td>${agency.agencyIp }</td>
						<td style="display:none">${loginContext.id }</td>
						<!-- title="/flowsys/account/charge_list.do?agencyId=${agency.id }" -->
						<td>
						<c:choose>
							<c:when test="${agency.accountBalance <=0  }">
								<a class="c-error" data-href="/flowsys/account/charge_list.do?agencyId=${agency.id }" data-toggle="tooltip" data-placement="top" title="点击查看记录" data-title="充值扣款记录" style="text-decoration:none"  onclick="Hui_admin_tab(this)">
							${agency.accountBalance }</a>
							</c:when>
							<c:otherwise>
								<a data-href="/flowsys/account/charge_list.do?agencyId=${agency.id }" data-toggle="tooltip" data-placement="top" title="点击查看记录" data-title="充值扣款记录" style="text-decoration:none"  onclick="Hui_admin_tab(this)">
							${agency.accountBalance }</a>
							</c:otherwise>
						</c:choose>
						</td>
						<td>${agency.accountCredit }</td>
						<!-- title="/flowsys/rate/rate_add_page.do"  -->
						<%-- <td><a data-toggle="tooltip" data-placement="top" title="点击编辑费率" data-href="/flowsys/rate/rate_edit_page.do?rateId=${agency.rateId }" data-title="费率编辑" style="text-decoration:none" onclick="Hui_admin_tab(this)">${agency.rateName }</a></td>
						<td><a data-toggle="tooltip" data-placement="top" title="点击编辑带票费率" data-href="/flowsys/rate/rate_edit_page.do?rateId=${agency.billRateId }" data-title="费率编辑" style="text-decoration:none" onclick="Hui_admin_tab(this)">${agency.billRateName }</a></td> --%>
						<td class="td-manage">
							<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" onClick="editRate(this)" href="javascript:;" title="编辑代理商"><i class="Hui-iconfont">&#xe6de;</i></a>
							<a data-toggle="tooltip" data-placement="top" style="text-decoration:none" class="ml-5" onClick="account_charge('账户充值','${agency.userName }',${agency.id })" href="javascript:;" title="账户充值"><i class="Hui-iconfont">&#xe6df;</i></a> 
							<%-- <a title="/flowsys/rate/rate_add_page.do?rateId=${agency.rateId }&agencyId=${agency.id}" data-href="/flowsys/rate/rate_add_page.do?rateId=${agency.rateId }&agencyId=${agency.id}" data-title="费率添加" onclick="Hui_admin_tab(this)"><i class="Hui-iconfont">&#xe6df;</i></a> --%>
							<a data-toggle="tooltip" data-placement="top" style="text-decoration:none"  title="活动通道列表" data-href="/flowsys/rate/bind_channel_list.do?agencyId=${agency.id }&agencyName=${agency.userName}" data-title="活动通道列表" onclick="Hui_admin_tab(this)"><i class="Hui-iconfont">&#xe6df;</i></a>
						</td>
						<td>${agency.createTimeStr }</td>
						<%-- <td class="td-status"><c:forEach items="${resultMap.pgInEnums }" var="pgIn" varStatus="vs1">
						
						<c:if test="${pg.pgInService == pgIn.value }"> ${pgIn.desc }</c:if>
						</c:forEach></td> --%>
					<!-- 	<td class="td-status"><span class="label label-success radius">已发布</span></td> -->
						
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
<script type="text/javascript" src="/view/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<!-- jQuery -->

<script type="text/javascript" charset="utf8" src="/view/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/view/lib/laypage/1.2/laypage.js"></script>
<!-- 时间选择器 -->
<!--  <script src="/view/lib/moment.js"></script>
<script src="/view/lib/bootstrap-datetimepicker.min.js"></script>
<script src="/view/lib/bootstrap-datetimepicker.zh-CN.js"></script> -->
<script type="text/javascript">
/* $(document).ready(function() {
	$('.table-sort').dataTable({
        "bServerSide": true,//这个用来指明是通过服务端来取数据
        "sAjaxSource": "testAoData",//这个是请求的地址
        'bPaginate':true, 
        "sPaginationType": "full_numbers", //分页风格，full_number会把所有页码显示出来（大概是，自己尝试）
        "bDestroy" : true,
        "bLengthChange": true, //改变每页显示数据数量
        "bAutoWidth": true,//自动宽度  
        
        "fnServerData": retrieveData // 获取数据的处理函数
	});
}); */

//3个参数的名字可以随便命名,但必须是3个参数,少一个都不行
function retrieveData( sSource111,aoData, fnCallback111) {
	alert(aoData[0].name);  
    // alert(JSON.stringify(aoData));  
    $.ajax( {    
        "type": "get",     
        "contentType": "application/json",    
        "url": sSource111,     
        "dataType": "json",    
        "data": { aoData: JSON.stringify(aoData) }, // 以json格式传递  
        "success": function(resp) {    
        	fnCallback111(resp.aaData); 
        },
        "error":function(msg){
        	alert(msg);
        }
    }); 
}  

/*资讯-添加*/
function article_add(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/**账户-充值 */
function account_charge(title,agencyUserName,id){
	/* layer.open({
		area: [w+'px', h +'px'],
		type: 1,
		title: title,
		content: '<form action="add_charge" class="page-container">代理客户名称：'+addstr+'<br>冲值金额:<input type="text" class="input-text"></input>元<br><input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;充值&nbsp;&nbsp;"></input></form>'
	}); */
	//layer_show(title,url,w,h);
	layer.open({
        type: 2,
        title: "账户充值",
        area: ['430px', '500px'],
        maxmin: false,
        closeBtn: 1,
        content: '/flowsys/account/add_charge_page.do?agencyId=' + id + '&userName=' + agencyUserName,
        end: function () {
            location.reload();
        }
    });
	/* layer.full(index); */
}
/*资讯-删除*/
function article_del(obj,id){
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
}

/*资讯-审核*/
function article_shenhe(obj,id){
	layer.confirm('审核文章？', {
		btn: ['通过','不通过','取消'], 
		shade: false,
		closeBtn: 0
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布', {icon:6,time:1000});
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
		$(obj).remove();
    	layer.msg('未通过', {icon:5,time:1000});
	});	
}
/*代理商-编辑*/
function editRate(obj){
	/* <td>${agency.userName }</td>
	<td>${agency.userRealname }</td>
	<!-- <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','article-zhang.html','10001')" title="查看">资讯标题</u></td> -->
	<td>${agency.agencyTel }</td>
	 <td>${agency.userEmail }</td>
	<td>${agency.agencyIp }</td>
	
	<td><a title="charge_list.do?agencyId=${agency.id }" data-href="charge_list.do?agencyId=${agency.id }" data-title="充值扣款记录" style="text-decoration:none"  onclick="Hui_admin_tab(this)">${agency.accountBalance }</a></td>
	<td>${agency.accountCredit }</td>
	<td>${agency.rateId }</td> */
	var $agencyTr = $(obj).parent().parent();//tr标签
	var $id = $agencyTr.children(0);
	/* var $userRealname = $userName.next();
	var $agencyTel = $userRealname.next();
	var $userEmail = $agencyTel.next();
	var $agencyIp =$userEmail.next();
	var $id = $agencyIp.next();
	var $rootAgencyId = $id.next();
	var $accountCredit = $rootAgencyId.next().next();
	var $rateId = $accountCredit.next(); */
	layer.open({
        type: 2,
        title: '代理商编辑',
        area: ['800px', '500px'],
        maxmin: false,
        closeBtn: 1,
        content: '/flowsys/agency/child_agency_edit.do?id=' + $id.html(),
        end: function () {
            location.reload();
        }
    });
	/* var $rateId = $(obj).parent().prev();//费率td
	var $accountCredit = $rateId.prev();//信用
	var $accountBalance = $accountCredit.prev().children();//余额
	
	alert($accountBalance.html()); */
	//var rows = 
	/*  top.layer.open({  
         id: "layer_say_hello",  
         type: 2,  
         title: '打招呼',  
         shadeClose: true,  
         shade: 0.8,  
         area: ['500px', '400px'],  
         content: '/Findfriend/Part_SayHello', //iframe的url  
         success: function (layero, index) {  
             var her_uli_id = $("#headico").attr("data-uli-id"); //headico 是 HomeFrame的元素  
             var her_nickname = $("#nickname").text();   //nickname 是 HomeFrame的元素  
             // layero.find("iframe")        找到iframe的jquery对象  
             // layero.find("iframe")[0]     将jqeruy对象转化为Dom对象  
             // contentWindow                获取当前 iframe 的 内容 window对象（Dom对象）  
             //.send-hello 是 LayerFrame 的元素  
             var jquerySendHelloButton = $(".send-hello", layero.find("iframe")[0].contentWindow.document);  
             jquerySendHelloButton.attr("data-her-uli-id", her_uli_id);  
             jquerySendHelloButton.attr("data-her-nick-name", her_nickname);  
         }  
     });  */
	/* layer.confirm('确认要下架吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
		$(obj).remove();
		layer.msg('已下架!',{icon: 5,time:1000});
	}); */
}

/*资讯-发布*/
function article_start(obj,id){
	layer.confirm('确认要发布吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布!',{icon: 6,time:1000});
	});
}
/*资讯-申请上线*/
function article_shenqing(obj,id){
	$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
	$(obj).parents("tr").find(".td-manage").html("");
	layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
}

</script> 
</body>
</html>