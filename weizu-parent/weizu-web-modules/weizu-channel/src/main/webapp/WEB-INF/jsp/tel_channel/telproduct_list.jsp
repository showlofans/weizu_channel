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
<title>话费编码列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 平台通道管理 <span class="c-gray en">&gt;</span> 话费编码管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
<div class="page-container">
	<div class="text-c">
	<form class="form form-horizontal" action="/flowsys/tel_product/telproduct_list.do" method="post" id="formD" name="dataListForm">
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
		 平台名称:<input type="text" value="${resultMap.params.epName }" name="epName" id="" placeholder="平台名称" style="width:80px" class="input-text">
		&nbsp;&nbsp;
		 <!--  业务类型： -->
		 <span class="select-box inline">
			<select name="serviceType" class="select" onchange="formSub()">
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
		 <c:if test="${resultMap.params.serviceType == resultMap.city }">
		 <span class="select-box inline">
			<select class="select" id="city" name="cityid" onchange="initCity()">
				<option value="">城市</option>
			</select>
		</span> 
		</c:if>
		 
		<input type="hidden" value="${resultMap.params.cityid }" id="cityid" >
		&nbsp;&nbsp;
		 <!--  运营商类型： -->
		 <span class="select-box inline">
			<select name="operatorName" class="select"  onchange="formSub()">
				<option value="">运营商类型</option>
				<c:forEach items="${resultMap.operatorNameEnums }" var="operatorNameEnum" varStatus="vs1">
					<option value="${operatorNameEnum.value }" <c:if test="${operatorNameEnum.value == resultMap.params.operatorName }"> selected</c:if>>${operatorNameEnum.desc }</option>
				</c:forEach>
			</select>
		</span> 
		&nbsp;&nbsp;
		 <!--  充值类型： -->
		 <span class="select-box inline">
			<select name="telchargeSpeed" class="select"  onchange="formSub()">
				<option value="">充值类型</option>
				<c:forEach items="${resultMap.telchargeSpeedEnums }" var="telchargeSpeedEnum" varStatus="vs1">
					<option value="${telchargeSpeedEnum.value }" <c:if test="${telchargeSpeedEnum.value == resultMap.params.chargeSpeed }"> selected</c:if>>${telchargeSpeedEnum.desc }</option>
				</c:forEach>
			</select>
		</span> 
		
		<%-- &nbsp;&nbsp;
			<!-- 包状态 -->
		<span class="select-box inline">
			<select name="pgInService" class="select"  onchange="formSub()">
			<option value="">包状态</option>
			<c:forEach items="${resultMap.pgInEnums }" var="pgIn" varStatus="vs1">
				<option value="${pgIn.value }" <c:if test="${pgIn.value == resultMap.params.pgInService }"> selected</c:if>>${pgIn.desc }</option>
			</c:forEach>
		</select>
		</span> --%>
	</div>
	<!-- 第二行搜索 -->
	<div class="row cl" style="margin-top: 30dp">
		&nbsp;&nbsp;
		  话费价值:<input type="text" value="${resultMap.params.chargeValue }" name="chargeValue" id="" placeholder="话费价值" style="width:100px" class="input-text">
		 限制描述:<input type="text" value="${resultMap.params.limitDescription }" name="limitDescription" id="" placeholder="限制描述" style="width:80px" class="input-text">
		<%-- 流量大小:<input type="text" value="${resultMap.params.pgSize }" name="pgSize" id="" placeholder="大小" style="width:80px" class="input-text">
		原价：<input type="text" value="${resultMap.params.pgPrice }" name="pgPrice" id="" placeholder=" 原价" style="width:80px" class="input-text">元 --%>
		<button type="button" class="btn btn-success" onclick="javascript:location.replace(location.href);" value="重置">重置</button>
		<button name="" id=""  class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜编码</button>
		<a style="text-decoration:none" class="btn btn-success" onClick="telPc_add('话费编码添加','/flowsys/tel_product/telproduct_add_page.do')" href="javascript:;" title="添加"><i class="Hui-iconfont">&#xe600;</i>添加</a>
		<input type="hidden" name="pageNoLong" value="${pagination.pageNoLong }"> 
	</div>
</form>
</div>
	<!-- <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" data-title="添加资讯" data-href="article-add.html" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加资讯</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div> -->
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<!-- <th width="80">流量包Id</th> -->
					<th width="30">ID</th>
					<th width="80">平台名称</th>
					<th width="80">产品编码</th>
					<th width="80">话费价值</th>
					<!-- <th width="120">支持城市</th> -->
					<th width="80">业务类型</th>
					<th width="80">支持省份</th>
					<c:if test="${resultMap.params.serviceType == resultMap.city }">
					<th width="80">支持城市</th>
					</c:if>
					<th width="60">充值速度</th>
					<th width="80">限制描述</th>
					
					<th width="60">运营商类型</th>
					
					<th width="60">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="product" varStatus="vs">
					<tr class="text-c">
						<td>${product.id }</td> 
						<td>${product.epName }</td>
						<td class="c-blue">${product.telCode }</td>
						<td>${product.chargeValue }元</td>
						<!-- <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','article-zhang.html','10001')" title="查看">资讯标题</u></td> -->
						<td>
							<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceTypeEnum" varStatus="vs1">
							<c:if test="${product.serviceType == serviceTypeEnum.value }"> ${serviceTypeEnum.desc }</c:if>
							</c:forEach>
						</td>
						<td>
							${product.province }
						<%-- <c:forEach items="${resultMap.scopeCityEnums }" var="scopeCityEnum">
							<c:if test="${scopeCityEnum.value== product.cityid}">
								<span data-toggle="tooltip" data-placement="right" title="${product.cityid }">${scopeCityEnum.desc }</span>
							</c:if>
						</c:forEach> --%>
						</td>
						<c:if test="${resultMap.params.serviceType == resultMap.city }">
						<td>${product.city }</td> 
						</c:if>
						<td>
							<c:forEach items="${resultMap.telchargeSpeedEnums }" var="telchargeSpeedEnum" varStatus="vs1">
							<c:if test="${product.chargeSpeed == telchargeSpeedEnum.value }"> ${telchargeSpeedEnum.desc }</c:if>
							</c:forEach>
						</td>
						<td>${product.limitDescription }</td> 
						<td>
							<c:forEach items="${resultMap.operatorNameEnums }" var="operatorNameEnum" varStatus="vs1">
							<c:if test="${product.operatorName == operatorNameEnum.value }"> ${operatorNameEnum.desc }</c:if>
							</c:forEach>
						</td>
						 
						<td class="f-14 td-manage">
						<a style="text-decoration:none" class="ml-5" onClick="produce_del('/flowsys/tel_product/telproduct_del.do',${product.id })" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="pagaId" />  
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
/* function submitForm(){
	$('form').submit();
} */
/*话费编码-添加*/
function telPc_add(title,url){
	//alert("sd");pageTitle=' + title +"&
	//var pgServiceType = $('#pgServiceType').val();
	layer.open({
        type: 2,
        title: title,
        area: ['500px', '600px'],
        maxmin: false,
        closeBtn: 1,
        content: url,//+'?pgServiceType=' + pgServiceType,
         end: function () {
            location.reload();
        }
    });
}
/*话费编码-删除*/
function produce_del(url,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: url,
			data: {id:id},
			//dataType: 'json',
			success: function(data){
				if(data=="success")
				{
					layer.msg('删除编码成功!',{icon:1,time:1000});
					location.reload();
				}else{
					layer.msg('删除编码失败!',{icon:1,time:1000});
				}
			},
			error:function(data) {
				console.log(data.msg);
			}
		});		
	});
}
</script> 
</body>
</html>