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
<title>流量包列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 标准价管理 <span class="c-gray en">&gt;</span> 标准价列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
	<form class="form form-horizontal" action="/flowsys/operatorPg/operatorPg_list.do" method="post" id="formD" name="dataListForm">
		<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
	<div class="row cl formControls">
		<span class="select-box inline">
			<select name="pgServiceType" id="pgServiceType" class="select c-green"  onchange="submitForm()">
			<!-- <option value="">包体类型</option> -->
			<c:forEach items="${resultMap.pgServiceTypeEnums }" var="pgServiceTypeEnum" varStatus="vs1">
				<option value="${pgServiceTypeEnum.value }" <c:if test="${pgServiceTypeEnum.value == resultMap.params.pgServiceType }"> selected</c:if>>${pgServiceTypeEnum.desc }</option>
			</c:forEach>
		</select>
		</span>
		&nbsp;&nbsp;
		 
		 <c:if test="${resultMap.params.pgServiceType ==1 }"><!-- 流量还是话费 -->
			 <!--  包体有效期： -->
			 <span class="select-box inline">
				<select name="pgValidity" class="select"  onchange="submitForm()">
					<option value="">包体有效期</option>
					<c:forEach items="${resultMap.pgValidityEnums }" var="pgValidityEnum" varStatus="vs1">
						<option value="${pgValidityEnum.value }" <c:if test="${pgValidityEnum.value == resultMap.params.pgValidity }"> selected</c:if>>${pgValidityEnum.desc }</option>
					</c:forEach>
				</select>
			</span> 
			&nbsp;&nbsp;
			 <!--  流量流通方式： -->
			 <span class="select-box inline">
				<select name="circulateWay" class="select"  onchange="submitForm()">
					<option value="">流量流通方式</option>
					<c:forEach items="${resultMap.channelTypeEnums }" var="channelTypeEnum" varStatus="vs1">
						<option value="${channelTypeEnum.value }" <c:if test="${channelTypeEnum.value == resultMap.params.circulateWay }"> selected</c:if>>${channelTypeEnum.desc }</option>
					</c:forEach>
				</select>
			</span> 
			&nbsp;&nbsp;
		</c:if>
		
		 <!--  运营商类型： -->
		 <span class="select-box inline">
			<select name="operatorType" class="select"  onchange="submitForm()">
				<option value="">运营商类型</option>
				<c:forEach items="${resultMap.operatoerTypeEnums }" var="operatorTypeEnum" varStatus="vs1">
					<option value="${operatorTypeEnum.value }" <c:if test="${operatorTypeEnum.value == resultMap.params.operatorType }"> selected</c:if>>${operatorTypeEnum.desc }</option>
				</c:forEach>
			</select>
		</span> 
		&nbsp;&nbsp;
		 <!--  流量类型： -->
		 <span class="select-box inline">
			<select name="serviceType" class="select" onchange="submitForm()">
				<option value="">业务类型</option>
				<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceTypeEnum" varStatus="vs1">
					<option value="${serviceTypeEnum.value }" <c:if test="${serviceTypeEnum.value == resultMap.params.serviceType }"> selected</c:if>>${serviceTypeEnum.desc }</option>
				</c:forEach>
			</select>
		</span> 
		&nbsp;&nbsp;
			<!-- 包状态 -->
		<span class="select-box inline">
			<select name="pgInService" class="select"  onchange="submitForm()">
			<option value="">包状态</option>
			<c:forEach items="${resultMap.pgInEnums }" var="pgIn" varStatus="vs1">
				<option value="${pgIn.value }" <c:if test="${pgIn.value == resultMap.params.pgInService }"> selected</c:if>>${pgIn.desc }</option>
			</c:forEach>
		</select>
		</span>
		
		<c:if test="${resultMap.params.pgServiceType ==1 }"><!-- 流量还是话费 -->
		&nbsp;&nbsp;
			<!-- 包状态 -->
		<span class="select-box inline">
			<select name="pgType" class="select"  onchange="submitForm()">
			<option value="">流量类型</option>
			<c:forEach items="${resultMap.pgTypeEnums }" var="pgTypeEnum" varStatus="vs1">
				<option value="${pgTypeEnum.value }" <c:if test="${pgTypeEnum.value == resultMap.params.pgType }"> selected</c:if>>${pgTypeEnum.desc }</option>
			</c:forEach>
		</select>
		</span>
		</c:if>
	</div>
	
	<div class="row cl" style="margin-top: 30dp">
		 <!--  地区省份： -->
		 <span class="select-box inline">
			<select class="select" onchange="province_change(this.value);">
				<option value="">省份</option>
				<c:forEach items="${resultMap.provinces }" var="province" varStatus="vs1">
					<option value="${province.provinceid }" >${province.province }</option><!-- <c:if test="${serviceTypeEnum.value == resultMap.params.serviceType }"> selected</c:if> -->
				</c:forEach>
			</select>
		</span> 
		 <!--  地区城市： -->
		 <span class="select-box inline">
			<select class="select" id="city" onchange="submitForm()">
				<option value="">城市</option>
			</select>
		</span> 
		<%-- <input type="hidden" id="provincesJson" value="${resultMap.provincesJson }" /> --%>
		&nbsp;&nbsp;
	
		流量大小:<input type="text" value="${resultMap.params.pgSize }" name="pgSize" id="" placeholder="大小" style="width:80px" class="input-text">
		原价：<input type="text" value="${resultMap.params.pgPrice }" name="pgPrice" id="" placeholder=" 原价" style="width:80px" class="input-text">元
		<!-- 支持城市：<input type="text" name="scopeCityName" id="" placeholder=" 支持城市" style="width:250px" class="input-text"> -->
		<!-- 日期范围：
		<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}' })" id="logmin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d' })" id="logmax" class="input-text Wdate" style="width:120px;"> -->
		<button type="button" class="btn btn-success" onclick="javascript:location.replace(location.href);" value="重置">重置</button>
		<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜流量</button>
		<a style="text-decoration:none" class="btn btn-success" onClick="pg_add('包体添加','/flowsys/operatorPg/pg_add_page.do')" href="javascript:;" title="添加"><i class="Hui-iconfont">&#xe600;</i>添加</a>
		<!-- <button class="btn btn-success" onClick="pg_add('包体添加','pg_add_page.do')" value="添加流量包体">添加</button> -->
		<input type="hidden" name="pageNo" value="${pagination.pageNo }"> 
	</div>
</form>
</div>
	</div>
	<!-- <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" data-title="添加资讯" data-href="article-add.html" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加资讯</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div> -->
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<!-- <th width="25"><input type="checkbox" name="" value=""></th> -->
					<!-- <th width="80">流量包Id</th> -->
					
					<th width="80">属性</th>
					<th width="200">包名称</th>
					<th width="80">业务类型</th>
					
					<c:if test="${resultMap.params.pgServiceType ==1 }">
						<th width="80">有效期</th>
						<th width="80">流通方式</th>
						<!-- <th width="80">流量类型</th> -->
						<th width="80">流量大小</th>
					</c:if>
					<th width="80">运营商类型</th>
					<!-- <th width="80">运营商名称</th> -->
					<!-- <th width="120">支持城市</th> -->
					<th width="75">原价</th>
					<!-- <th width="60">使用状态</th> -->
					 <th width="120">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap.pagination.records }" var="pg" varStatus="vs">
					<tr class="text-c">
						<!-- <td><input type="checkbox" value="" name=""></td> -->
						<%-- <td>${pg.pgId }</td> --%>
						<td><c:forEach items="${resultMap.pgServiceTypeEnums }" var="pgServiceType" varStatus="vs1">
						<c:if test="${pg.pgServiceType == pgServiceType.value }"> ${pgServiceType.desc }</c:if>
						</c:forEach>
						</td>
						
						<td>
						<c:choose>
							<c:when test="${pg.pgInService == 1 }"><!-- 使用状态为开通状态 -->
								<c:forEach items="${resultMap.pgInEnums }" var="pgIn" varStatus="vs1">
									<c:if test="${pg.pgInService == pgIn.value }">
										<span data-toggle="tooltip" data-placement="top" title="${pgIn.desc }" class="c-green">${pg.pgName }</span>
									 </c:if>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<span class="">${pg.pgName }</span>
							</c:otherwise>
						</c:choose>
						</td>
						<td><c:forEach items="${resultMap.serviceTypeEnums }" var="serviceType" varStatus="vs1">
						<c:if test="${pg.serviceType == serviceType.value }"> ${serviceType.desc }</c:if>
						</c:forEach>
						</td>
						<c:if test="${resultMap.params.pgServiceType ==1 }"><!-- 流量还是话费 -->
							<td><c:forEach items="${resultMap.pgValidityEnums }" var="pgValidityEnum" varStatus="vs1">
							<c:if test="${pg.pgValidity == pgValidityEnum.value }"> ${pgValidityEnum.desc }</c:if>
							</c:forEach>
							</td>
							<td><c:forEach items="${resultMap.channelTypeEnums }" var="channelTypeEnum" varStatus="vs1">
							<c:if test="${pg.circulateWay == channelTypeEnum.value }"> ${channelTypeEnum.desc }</c:if>
							</c:forEach>
							</td>
							<%-- <td><c:forEach items="${resultMap.pgTypeEnums }" var="pgTypeEnum" varStatus="vs1">
							<c:if test="${pg.pgType == pgTypeEnum.value }"> ${pgTypeEnum.desc }</c:if>
							</c:forEach>
							</td> --%>
							
							<td>
								<c:forEach items="${resultMap.pgTypeEnums }" var="pgTypeEnum" varStatus="vs1">
									<c:if test="${pgTypeEnum.value == pg.pgType }"> 
										<span data-toggle="tooltip" data-placement="bottom" title="${pgTypeEnum.desc }">
											${pg.pgSize }M
										</span>
									</c:if>
								</c:forEach>
							</td>
						</c:if>
						
						<td><c:forEach items="${resultMap.operatoerTypeEnums }" var="operatorType" varStatus="vs1">
						<c:if test="${pg.operatorType == operatorType.value }">
							<span data-toggle="tooltip" data-placement="top" title="${pg.operatorName  }"> ${operatorType.desc }</span>
						</c:if>
						</c:forEach>
						</td>
						<%-- <td>${pg.operatorName }</td> --%>
						<td>${pg.pgPrice }</td>
						<%-- <td class="td-status"><c:forEach items="${resultMap.pgInEnums }" var="pgIn" varStatus="vs1">
						<c:if test="${pg.pgInService == pgIn.value }"> ${pgIn.desc }</c:if>
						</c:forEach></td> --%>
						<td class="f-14 td-manage">
						<a style="text-decoration:none" class="ml-5" onClick="pg_del(this,${pg.id})" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
						</td>
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
<script type="text/javascript" src="/view/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<!-- jQuery -->
<script type="text/javascript" src="/view/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">


/**省份变化*/
function province_change(v){
	var ss;
    var city = document.getElementById("city");
	city.innerHTML = "";
	
	$.getJSON("/view/mine/data/cityData.json",function(data){
	    ss=data;
	    //var html="<option value='-1'>==请选择==</option>";
	    for(var i=0;i<ss.length;i++){
	    	if(v==ss[i].provinceid){
                var citys=ss[i].cities;
                for(var j=0;j<citys.length;j++){
                	city.add(new Option(citys[j].city,citys[j].cityid));
                	//htmls+="<option value='"+a[j].c1+"'>"+a[j].c1+"</option>";
                }
                //$("#country").html(htmls);
            }
	    	
	     /// html+="<option value='"+ss[i].p+"'>"+ss[i].p+"</option>";
	    }
	    //$("#city").html(html);
	});
	
	
	/* var areaList = $('#provincesJson').val();
	var city = document.getElementById("city");
	city.innerHTML = "";
	//alert(v);
//var vObj = eval(areaList );
	//alert(vObj[0].provinceid);
	 var jsonS = $.parseJSON(areaList);   //jquery的.parseJSON（）方法
     for (var i = 0; i < jsonS.length; i++) {
         var json = jsonS[i].provinceid;
         alert(json);
         //alert(json.city);    //结果为 输出2次 一次北京 一次上海
     } */
	//alert(eval(areaList)); 
	//alert(areaList.parseJSON());
	//eval("var citys = areaList."+v+";");
	//alert(citys.length);	
	//for(var i=0;i<citys.length;i++){
	//city.add(new Option(citys[i].cityid,citys[i].city));
}

/**onchange提交表单*/
function submitForm(){
	$('form').submit();
}
/*包体-添加*/
function pg_add(title,url){
	//alert("sd");pageTitle=' + title +"&
	var pgServiceType = $('#pgServiceType').val();
	layer.open({
        type: 2,
        title: title,
        area: ['500px', '600px'],
        maxmin: false,
        closeBtn: 1,
        content: url+'?pgServiceType=' + pgServiceType,
         end: function () {
            location.reload();
        }
    });
}
/*包体-删除*/
function pg_del(obj,id){
	layer.confirm("确认要删除该包体吗？",function(index){
		//alert(index);
		var tag = "";
		$.ajax({
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
		});	
		if(tag == "success"){
			layer.msg('删除成功', {icon:5,time:1000});
		}
		layer.close(index);
		location.reload();
	});
}
/* //3个参数的名字可以随便命名,但必须是3个参数,少一个都不行
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
}   */
</script> 
</body>
</html>