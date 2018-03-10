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
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 代理商管理 <span class="c-gray en">&gt;</span> 客户列表
 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
<div class="page-container">
	<!-- <a href="getRegisterPage.do">生成代理商注册页面</a> -->
	<div class="text-c">
		<form action="/flowsys/crm/crm_list.do" method="post" id="formD" name="dataListForm">
				<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
				<button type="button"class="btn btn-success" onclick="javascript:location.replace(location.href);" value="重置">重置</button>
				公司名称:<input type="text"  value="${resultMap.params.crmName }" name="crmName" id="" placeholder=" 公司名称" style="width:150px" class="input-text">
				群备注:<input type="text"  value="${resultMap.params.crmGroupMark }" name="crmGroupMark"" placeholder=" 备注信息" style="width:150px" class="input-text">
				<!-- <input type="text" style="width:150px" class="input-text" name="start_datetime"  value="2017-05-26 00:00:00"  onClick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
	                  	<em class="inputto">至</em>
	            <input style="width:150px" type="text" class="input-text" name="end_datetime"   value="2017-05-26 23:59:59"  onClick="WdatePicker({startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> -->
				是否已对接：<span class="select-box inline">
							<select name="crmPlatformTag"  id="crmPlatformTag" class="select" onchange="formSub()">
								<option value="">请选择</option>
								<c:forEach items="${resultMap.crmPlatformTagEnums }" var="crmPlatformTagEnum" varStatus="vs1">
									<option value="${crmPlatformTagEnum.value }" <c:if test="${crmPlatformTagEnum.value == resultMap.params.crmPlatformTag }"> selected</c:if>>${crmPlatformTagEnum.desc }</option>
								</c:forEach>
							</select>
						</span>
				<button name="" id="" class="btn btn-success"  type="submit"  onclick="formSub()"><i class="Hui-iconfont">&#xe665;</i> 搜客户</button>
				<a style="text-decoration:none" class="btn btn-success" data-title='客户资料添加' onClick="crm_add(this,'客户资料添加','/flowsys/crm/crm_add_page.do',0)" href="javascript:;" title="添加"><i class="Hui-iconfont">&#xe600;</i>添加</a>
				<input type="hidden" name="pageNo" value="${resultMap.pagination.pageNo }"> 
				<%-- <input type="hidden" name="agencyTag" value="${resultMap.params.agencyTag }">  --%>
		</form>
	</div>
	<!-- <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" data-title="添加资讯" data-href="article-add.html" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加资讯</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div> -->
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<!-- <th width="80">流量包Id</th> -->
					<th width="80">公司名称</th>
					<th width="80">群备注</th>
					<th width="150">上游分析</th>
					<th width="150">客户分析</th>
					<th width="40">对接情况</th>
					<th width="60">最后更新时间</th>
					<th width="40">操作</th>
				</tr>
			</thead>
			<tbody>
				<!-- <tr class="text-c">
				</tr> -->
				<c:forEach items="${resultMap.pagination.records }" var="crm" varStatus="vs">
					<tr class="text-c">
						<td>
							<span data-toggle="tooltip" data-placement="top" title="${crm.crmName }">
								${crm.crmName }
							</span>
						</td>
						<td>${crm.crmGroupMark}</td>
						<td>
							<a style="text-decoration:none" onclick="editInfo('/flowsys/crm/crm_info_edit_page.do?id=${crm.id}&agencyForward=1','${crm.crmName }-上游信息编辑')" href="javascript:;" >
								${fn:substring(crm.crmForwardDesc,0,100)}
							</a> 
						</td>
						<td>
							<a style="text-decoration:none"  onclick="editInfo('/flowsys/crm/crm_info_edit_page.do?id=${crm.id}&agencyForward=0','${crm.crmName }-上游信息编辑')" href="javascript:;" >
							${fn:substring(crm.crmBackwardDesc,0,100)}
							</a>
							<%-- <span data-container="body" data-toggle="popover" data-placement="left" data-content="${crm.crmBackwardDesc }">
							${fn:substring(crm.crmBackwardDesc,0,100)}
							</span> --%>
						</td>
						<td class="td-status"><c:forEach items="${resultMap.crmPlatformTagEnums }" var="crmPlatformTagEnum" varStatus="vs1">
						<c:if test="${crm.crmPlatformTag == crmPlatformTagEnum.value }"> ${crmPlatformTagEnum.desc }</c:if>
						</c:forEach></td>
						<td>${crm.lastAccessStr }</td>
						<td class="td-manage">
							<a style="text-decoration:none" class="ml-5" onClick="crm_del('/flowsys/crm/del_crm.do',${crm.id })" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
							<a style="text-decoration:none" class="ml-5" data-title='客户资料编辑' onClick="crm_add(this,'客户资料编辑','/flowsys/crm/crm_edit_page.do',${crm.id })" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>			
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="formD" />  
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
function editInfo(url,title){
	layer.open({
        type: 2,
        title: title,
        area: ['40%', '80%'],
        maxmin: false,
        closeBtn: 1,
        content: url,
         end: function () {
            location.reload();
        }
    });
}

/*客户信息-删除*/
function crm_del(url,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: url,
			data: {id:id},
			//dataType: 'json',
			success: function(data){
				if(data=="success")
				{
					layer.msg('删除客户信息成功!',{icon:1,time:1000});
					location.reload();
				}else{
					layer.msg('删除客户信息失败!',{icon:1,time:1000});
				}
			},
			error:function(data) {
				console.log(data.msg);
			}
		});		
	});
}
/*onchange通道状态*/
/* function formSub(){
	//alert($(vart).val());
	$('form').submit();
} */
/*客户资料添加-添加*/
function crm_add(obj,title,url,id){
	//alert(id);
	if(id != '0'){//编辑展示通道
		url = url + '?id=' + id; 
	}
	$(obj).attr('data-href',url);
	Hui_admin_tab(obj);
}

</script> 
</body>
</html>