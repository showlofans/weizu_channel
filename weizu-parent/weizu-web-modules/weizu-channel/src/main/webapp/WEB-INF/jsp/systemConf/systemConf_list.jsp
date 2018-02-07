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
<link rel="stylesheet" type="text/css" href="/view/mine/Switch/bootstrapSwitch.css" />
<style type="text/css">
html { overflow-y: auto }
.Hui-nav-toggle { display: none!important }
</style>
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>H-ui.admin 3.0</title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<div class="page-container">
	<table class="table table-border table-bordered table-bg mt-20">
		<thead>
			<tr>
				<th scope="col">参数说明</th>
				<th scope="col">参数值</th>
				<th scope="col">参数名</th>
				<th scope="col">操作</th>
				<th scope="col">最后更新</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${resultMap.failBack != null }">
				<tr>
					<th >
						${resultMap.failBack.confDesc }
					</th>
					<td>
						${resultMap.failBack.confValue }
						<span class="c-danger">(${resultMap.failBack.confDetail })</span>
					</td>
					<td width="30%">${resultMap.failBack.confKey }</td>
					<td>
						<div class="testswitch">  
							<c:choose>
								<c:when test="${resultMap.failBack.confValue == '1' }">
						            <input class="testswitch-checkbox" id="onoffswitch" type="checkbox" checked>  
								</c:when>
								<c:otherwise>
						            <input class="testswitch-checkbox" id="onoffswitch" type="checkbox">  
								</c:otherwise>
							</c:choose>
				            <label class="testswitch-label" for="onoffswitch">  
				                <span class="testswitch-inner" data-on="ON" data-off="OFF"></span>  
				                <span class="testswitch-switch"></span>  
				            </label>  
				        </div> 
					   <!--  <div id="mySwitch" class="switch" data-on="primary" data-off="info">
					      <input type="checkbox"  checked />
					    </div> -->
						<%-- <a  data-toggle="tooltip" data-placement="top" style="text-decoration:none;cursor:pointer" data-href="/flowsys/chargeLog/charge_log_list.do?orderId=${purchase.orderId }" title="查看传单日志" onclick="Hui_admin_tab(this)" data-title="接口订单日志" href="javascript:void(0)">
							<i class="Hui-iconfont">&#xe623;</i>
						</a> --%>
					</td>
					<td>${resultMap.failBack.lastAccessStr }</td>
				</tr>
			</c:if>
			<c:if test="${resultMap.chargeTelTimesInOneDay != null }">
				<tr>
					<th >
						${resultMap.chargeTelTimesInOneDay.confDesc }
					</th>
					<td>
						${resultMap.chargeTelTimesInOneDay.confValue }
					</td>
					<td width="30%">
						${resultMap.chargeTelTimesInOneDay.confKey }
					</td>
					<td>
						<%-- <a  data-toggle="tooltip" data-placement="top" style="text-decoration:none;cursor:pointer" data-href="/flowsys/chargeLog/charge_log_list.do?orderId=${purchase.orderId }" title="查看传单日志" onclick="Hui_admin_tab(this)" data-title="接口订单日志" href="javascript:void(0)">
							<i class="Hui-iconfont">&#xe623;</i>
						</a> --%>
					</td>
					<td>${resultMap.chargeTelTimesInOneDay.lastAccessStr }</td>
				</tr>
			</c:if>
		</tbody>
	</table>
</div>
<footer class="footer mt-20">
	<div class="container">
		<p><!-- 感谢jQuery、layer、laypage、Validform、UEditor、My97DatePicker、iconfont、Datatables、WebUploaded、icheck、highcharts、bootstrap-Switch<br> -->
			Copyright &copy;2017-2018 南昌微族科技有限公司 All Rights Reserved.<br>
			<!-- 本后台系统由<a href="http://www.h-ui.net/" target="_blank" title="H-ui前端框架">H-ui前端框架</a>提供前端技术支持 -->
			</p>
	</div>
</footer>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="/view/mine/Switch/bootstrapSwitch.js"></script>
<script type="text/javascript">
$().ready(function(){
	
	//修改失败返回
	$("#onoffswitch").on('click', function(){  
		var confKey = $(this).parent().parent().prev().html();
        clickSwitch(confKey);  
    });  
  
    var clickSwitch = function(confKey) {  
    	var state = 0;
    	var msg = "";
        if ($("#onoffswitch").is(':checked')) {  
        	//更新为1
        	state = 1;
        	msg = "确认直接失败订单";
            console.log("在ON的状态下");  
        } else {  
        	msg = "确认保留所有失败订单";
            console.log("在OFF的状态下");  
        }  
        layer.confirm(msg,function(index){
	        $.ajax({
				type: 'POST',
				url: '/flowsys/systemConf/switch_fail_back.do',
				//dataType: 'json',
				data: {confKey:confKey, confValue:state},
				async: false,
				success: function(data){
					//tag = data;
					 //alert(data);
					if(data=="success")
					{
						layer.msg('手动修改成功',{icon:1,time:1000});
						location.reload();
					}else{
						layer.msg('手动修改失败',{icon:1,time:1000});
					}
				},
				error:function(data) {
					console.log(data.msg);
				},
			});
        },function(index){
        	if ($("#onoffswitch").is(':checked')){
	        	//$('#onoffswitch').removeClass('switch-off').addClass('switch-on');
	        	$('#onoffswitch').prop('checked', false);
        	}else{
	        	//$('#onoffswitch').addClass('switch-off').removeClass('switch-on');
	        	//$('#onoffswitch').attr('checked',true);
	        	$('#onoffswitch').prop('checked', true);
        	}
        	//location.reload();
        });
    };  
	/* $('#mySwitch').on('switch-change', function (e, data) {
	    var $el = $(data.el), 
	    value = data.value;
	    console.log(e, $el, value);
	}); */
})
</script>
</body>
</html>