<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
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
<link href="/view/tab/css/bootstrap.min.css" rel="stylesheet">
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->
<style type="text/css">
	.demo{padding: 1em 0;}
	a:hover,a:focus{
		outline: none;
		text-decoration: none;
	}
	.tab .nav-tabs{
		border: 1px solid #1fc1dd;
	}
	.tab .nav-tabs li{
		margin: 0;
	}
	.tab .nav-tabs li a{
		font-size: 14px;
		color: #999898;
		background: #fff;
		margin: 0;
		padding: 20px 25px;
		border-radius: 0;
		border: none;
		border-right: 1px solid #ddd;
		text-transform: uppercase;
		position: relative;
	}
	.tab .nav-tabs li a:hover{
		border-top: none;
		border-bottom: none;
		border-right-color: #ddd;
	}
	.tab .nav-tabs li.active a,
	.tab .nav-tabs li.active a:hover{
		color: #fff;
		border: none;
		background: #1fc1dd;
		border-right: 1px solid #ddd;
	}
	.tab .nav-tabs li.active a:before{
		content: "";
		width: 58%;
		height: 4px;
		background: #fff;
		position: absolute;
		top: 0;
		left: 0;
		right: 0;
		margin: 0 auto;
	}
	.tab .nav-tabs li.active a:after{
		content: "";
		border-top: 10px solid #1fc1dd;
		border-left: 10px solid transparent;
		border-right: 10px solid transparent;
		position: absolute;
		bottom: -10px;
		left: 43%;
	}
	.tab .tab-content{
		font-size: 13px;
		color: #999898;
		line-height: 25px;
		background: #fff;
		padding: 20px;
		border: 1px solid #1fc1dd;
		border-top: none;
	}
	.tab .tab-content h3{
		font-size: 24px;
		color: #999898;
		margin-top: 0;
	}
	@media only screen and (max-width: 480px){
		.tab .nav-tabs li{
			width: 100%;
			text-align: center;
		}
		.tab .nav-tabs li.active a,
		.tab .nav-tabs li.active a:after,
		.tab .nav-tabs li.active a:hover{
			border: none;
		}
	}
</style>

<title>添加费率</title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form action="/flowsys/rate/rate_add.do" method="post" class="form form-horizontal" id="form-member-add" onsubmit="return changeName()">
		<!-- 代理商id，方便自动绑定费率 -->
		<%-- <input type="hidden" value="${resultMap.agencyId }"placeholder=""name="id"> --%>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">代理商名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" readonly="readonly" class="input-text  ac_input" autocomplete="off" value="${resultMap.agencyName }" onkeyup="checkName()" placeholder="${resultMap.agencyName }" id="agencyName" name="">
			</div>
		</div>
		
		<%-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>运营商类型：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<div class="radio-box" id="head">
					<ul>
					<c:forEach items="${resultMap.operatorTypes }" var="operatorEnum" varStatus="vs">
							<li id="L${vs.index+1 }" onclick="Tab(${vs.index+1 })"><a href="#">${operatorEnum.desc}</a></li>
							<input name="operatorType" class="radioItem" type="radio" id="operatorType-${vs.index }" value="${operatorEnum.value }" <c:if test="${vs.index==0 }">checked</c:if> >
							${${operatorEnum.desc} }
							<label for="operatorType-${vs.index }"></label>
					</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<c:forEach items="${resultMap.operatorTypes }" var="operatorEnum" varStatus="vs">
			<div class="row cl" id="d${vs.index+1 }">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>地区折扣：</label><br>
				<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<table>
					<c:forEach items="${resultMap.scopeCityNames }" var="scopeCityName" varStatus="vs">
						<c:if test="${vs.index % 4==0 }"><tr></c:if>
							<td> 
								<div class="radio-box">
									<input class="cbox" onClick="checkBoxes(this)" type="checkbox" id="scopeCityName-${vs.index }" value="${scopeCityName.value }">
									${scopeCityName.desc }
									<label for="operatorType-${vs.index }"></label>
									<!-- 输入两位折扣数字 -->
									<input class="disscount" style="display: none; " type="text" maxlength="3" onkeyup='this.value=this.value.replace(/\D/gi,"")' placeholder="1.00">
								</div>
							</td>
						<c:if test="${(vs.index+1) % 4==0 }"></tr></c:if>
						<!-- <div class="formControls col-xs-3 col-sm-3">
							<input type="text" placeholder="1.00" name="channelDiscount" id="channelDiscount">
						</div> -->
					</c:forEach>
				</table>
				</div>
			</div>
		</c:forEach>  --%>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">费率：</label>
			<div role="tabpanel" class="tab formControls col-xs-8 col-sm-9 skin-minimal">
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<c:forEach items="${resultMap.operatorTypes }" var="operatorTypeEnum" varStatus="vs">
							<li role="presentation" class="<c:if test='${vs.index==0 }'>active</c:if>">
								<a class="operator" href="#Section${vs.index+1}" aria-controls="home" role="tab" data-toggle="tab">
									${operatorTypeEnum.desc}
								</a>
								<span style="display:none">${operatorTypeEnum.value}</span>
							</li>
						</c:forEach>
					</ul>
					<%-- <span id="operatorTypesE"> ${resultMap.operatorTypes }</span> --%>
					<!-- Tab panes -->
					<%-- <div class="row cl">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>流量类型：</label>
						<div class="formControls col-xs-8 col-sm-9 skin-minimal">
							<c:forEach items="${resultMap.serviceTypes }" var="serviceEnum" varStatus="vs">
								<div class="radio-box">
									<input name="serviceType" class="radioItem" type="radio" id="serviceType-${vs.index }" value="${serviceEnum.value }" <c:if test="${vs.index==0 }">checked</c:if>>
									${serviceEnum.desc }
									<label for="operatorType-${vs.index }"></label>
								</div>
							</c:forEach>
						</div>
					</div> --%>
					<div class="tab-content tabs">
						<c:forEach items="${resultMap.operatorTypes }" var="operatorTypeEnum" varStatus="vst">
							<c:choose>
								<c:when test="${vst.index==0 }">
									<div role="tabpanel" class="tab-pane fade in active" id="Section${vst.index+1}">
										<table>
											<c:forEach items="${resultMap.scopeCityNames }" var="scopeCityName" varStatus="vs">
											<c:if test="${vs.index % 4==0 }"><tr></c:if>
												<td> 
													<div class="radio-box">
														<input class="cbox0" onClick="checkBoxes(this)" type="checkbox" id="scopeCityName-${vs.index }" value="${scopeCityName.desc }">
														${scopeCityName.desc }
														<%-- <label for="operatorType-${vs.index }"></label> --%>
														<!-- 输入两位折扣数字 -->
														<input class="disscount" style="display: none; " type="text" maxlength="3" onkeyup='this.value=this.value.replace(/\D/gi,"")' placeholder="1.00">
														<!-- 显示平台和通道折扣 -->
														<span class="price" style="display: none; "></span>
													</div>
												</td>
											<c:if test="${vs.index+1 % 4==0 }"></tr></c:if>
											</c:forEach>
										</table>
									</div>
								</c:when>
								<c:otherwise>
									<div role="tabpanel" class="tab-pane fade" id="Section${vst.index+1}">
										<table>
											<c:forEach items="${resultMap.scopeCityNames }" var="scopeCityName" varStatus="vs">
											<c:if test="${vs.index % 4==0 }"><tr></c:if>
												<td> 
													<div class="radio-box">
														<input class="cbox${vst.index }" onClick="checkBoxes(this)" type="checkbox" id="scopeCityName-${vs.index }" value="${scopeCityName.value }">
														${scopeCityName.desc }
														<%-- <label for="operatorType-${vs.index }"></label> --%>
														<!-- 输入两位折扣数字 -->
														<input class="disscount" style="display: none; " type="text" maxlength="3" onkeyup='this.value=this.value.replace(/\D/gi,"")' placeholder="1.00">
														<!-- 显示平台和通道折扣 -->
														<span class="price" style="display: none; "></span>
													</div>
												</td>
											<c:if test="${vs.index+1 % 4==0 }"></tr></c:if>
											</c:forEach>
										</table>
									</div>
								</c:otherwise>
								</c:choose>
						</c:forEach>
					</div>
				</div>
				</div>
				<div class="row cl">  通道名称：
					 <span class="select-box inline">
						<select name="channelId" class="select">
							<option value="">通道</option>
							<c:forEach items="${channelList }" var="channel" varStatus="vs1">
								<option value="${channel.id }" >${channel.channelName }</option>
							</c:forEach>
						</select>
					</span> 
				</div>
			<%-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">费率：</label>
			<div role="tabpanel" class="tab formControls col-xs-8 col-sm-9 skin-minimal">
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<c:forEach items="${resultMap.operatorTypes }" var="operatorTypeEnum" varStatus="vs">
							<li role="presentation" class="<c:if test='${vs.index==0 }'>active</c:if>">
								<a class="operator" href="#Section${vs.index+1}" aria-controls="home" role="tab" data-toggle="tab">
									${operatorTypeEnum.desc}
								</a>
								<span style="display:none">${operatorTypeEnum.value}</span>
							</li>
						</c:forEach>
					</ul>
					<span id="operatorTypesE"> ${resultMap.operatorTypes }</span>
					<!-- Tab panes -->
					<div class="tab-content tabs">
						<c:forEach items="${resultMap.operatorTypes }" var="operatorTypeEnum" varStatus="vst">
							<c:choose>
								<c:when test="${vst.index==0 }">
									<div role="tabpanel" class="tab-pane fade in active" id="Section${vst.index+1}">
										<table>
											<c:forEach items="${resultMap.scopeCityNames }" var="scopeCityName" varStatus="vs">
											<c:if test="${vs.index % 4==0 }"><tr></c:if>
												<td> 
													<div class="radio-box">
													<c:forEach items="${resultMap.discountList }" var="opdiscount"  varStatus="vsddd">
														<!-- 比较字符串是否存在 -->
														<c:choose>
															<c:when test="${scopeCityName==opdiscount.scopeName &&  operatorTypeEnum.value==opdiscount.operatorType}">
																<input class="cbox0" checked="checked" onClick="checkBoxes(this)" type="checkbox" id="scopeCityName-${vs.index }" value="${scopeCityName.desc }">
																${scopeCityName.desc }
																<label for="operatorType-${vs.index }"></label>
																<!-- 输入两位折扣数字 -->
																<input class="disscount" value="${opdiscount.discount }" type="text" maxlength="3" onkeyup='this.value=this.value.replace(/\D/gi,"")' placeholder="1.00">
																<!-- 显示平台和通道折扣 -->
																<span class="price" style="display: none; "></span>
															</c:when>
															<c:otherwise>
																<input class="cbox0" onClick="checkBoxes(this)" type="checkbox" id="scopeCityName-${vs.index }" value="${scopeCityName.desc }">
																${scopeCityName.desc }
																<label for="operatorType-${vs.index }"></label>
																<!-- 输入两位折扣数字 -->
																<input class="disscount" style="display: none; " type="text" maxlength="3" onkeyup='this.value=this.value.replace(/\D/gi,"")' placeholder="1.00">
																<!-- 显示平台和通道折扣 -->
																<span class="price" style="display: none; "></span>
															</c:otherwise>
														</c:choose>
														<c:if test="${operatorTypeEnum.value + scopeCityName == opdiscount.operatorScope}">
															
														</c:if>
													</c:forEach>
														
														
													</div>
												</td>
											<c:if test="${vs.index+1 % 4==0 }"></tr></c:if>
											</c:forEach>
										</table>
									</div>
								</c:when>
								<c:otherwise>
									<div role="tabpanel" class="tab-pane fade" id="Section${vst.index+1}">
										<table>
											<c:forEach items="${resultMap.scopeCityNames }" var="scopeCityName" varStatus="vs">
											<c:if test="${vs.index % 4==0 }"><tr></c:if>
												<td> 
													<div class="radio-box">
														<c:forEach items="${resultMap.discountList }" var="opdiscount" varStatus="vssssss">
														<!-- 比较字符串是否存在 -->
														<c:choose>
															<c:when test="${scopeCityName==opdiscount.scopeName &&  operatorTypeEnum.value==opdiscount.operatorType}">
																<input class="cbox${vst.index }" checked onClick="checkBoxes(this)" type="checkbox" id="scopeCityName-${vs.index }" value="${scopeCityName.desc }">
																${scopeCityName.desc }<span style="display: none; "></span>
																<label for="operatorType-${vs.index }"></label>
																<!-- 输入两位折扣数字 -->
																<input class="disscount" value="${opdiscount.discount }" type="text" maxlength="3" onkeyup='this.value=this.value.replace(/\D/gi,"")' placeholder="1.00">
																<!-- 显示平台和通道折扣 -->
																<span class="price" style="display: none; "></span>
															</c:when>
															<c:otherwise>
																<input class="cbox${vst.index }" onClick="checkBoxes(this)" type="checkbox" id="scopeCityName-${vs.index }" value="${scopeCityName.desc }">
																${scopeCityName.desc }<span style="display: none; "></span>
																<label for="operatorType-${vs.index }"></label>
																<!-- 输入两位折扣数字 -->
																<input class="disscount" style="display: none; " value="${opdiscount.discount }" type="text" maxlength="3" onkeyup='this.value=this.value.replace(/\D/gi,"")' placeholder="1.00">
																<!-- 显示平台和通道折扣 -->
																<span class="price" style="display: none; "></span>
															</c:otherwise>
														</c:choose>
														<c:if test="${operatorTypeEnum.value + scopeCityName == opdiscount.operatorScope}">
															
														</c:if>
													</c:forEach>
													
														
													</div>
												</td>
											<c:if test="${vs.index+1 % 4==0 }"></tr></c:if>
											</c:forEach>
										</table>
									</div>
								</c:otherwise>
								</c:choose>
						</c:forEach>
					</div>
				</div>
				</div> --%>
		<span id="ajaxBestChannel"></span>
				
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="beizhu" cols="" rows="" class="textarea"  placeholder="说点什么.最少输入10个字符" onKeyUp="$.Huitextarealength(this,100)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
			</div>
		</div> -->
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>
<div class="demo">
	<div class="container">
		<div class="row">
			<div class="col-lg-offset-3 col-lg-6">
				
			</div>
		</div>
	</div>
</div>

</body>
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script src="/view/tab/js/bootstrap.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){

})

function changeName(){
	var j = 0;//统计总共有多少家运营商有折扣配置
	var m = 0;	//cbox下标
	$(".operator").each(function(){
		var i = 0;//统计某个运营商有多少个折扣
		//alert($(".cbox"+m).attr('class'));
		$(".cbox"+m).each(function(){
			//alert($(this));
	    	if($(this).is(':checked')){ 
	    		$('<input />', {
	    	        name: 'discountList['+ i +'].channelDiscount',
	    	        id: 'channelDiscount-'+ i,
	    	        type: 'hidden',
	    	        value: $(this).next().val()
	    	        
	    	      }).appendTo($('#ajaxBestChannel'));
	    		$('<input />', {
	    	        name: 'discountList['+ i +'].scopeCityCode',
	    	        type: 'hidden',
	    	        value: $(this).val()
	    	      }).appendTo($('#ajaxBestChannel'));
	    		i++;
	    	}
		})
		
		if(i > 0){//在存在折扣的情况下，开始增加运营商
			$('<input />', {
		        name: 'discountList['+ j +'].operatorType',
		        type: 'hidden',
		        value: $(this).next().html().trim()
		      }).appendTo($('#ajaxBestChannel'));
			j++;
		}
		m++;
		//alert("i="+i + "j=" + j);
	})
	/**费率价格不能低于费率价格*/
	/* $(".price").each(function(){
		if($(this).is(':visible')){//找到每一个选中的折扣进行判断
			var channelP = $(this).html().trim(); 
			alert(channelP);//通道价格
			var $rateP = $(this).privious().val();
			if($rateP < channelP){
				
				
			//做其他提示性工作
				return false;
			}
			
		}
	}) */
	
	
	if(j>0){
		return true;
	}
	return false;
}
/**checkBox的点击事件*/
function checkBoxes(vart){
	var $price = $(vart).next().next();		//最优通道显示区
	if($(vart).next().is(':hidden')){
		var operatorType = $("li.active").children('span').eq(0).html().trim();
		var scopeCityCode = $(vart).val().trim();
		 $.ajax( {    
	        "type": "get",     
	        "contentType": "application/x-www-form-urlencoded; charset=utf-8",    
	        "url": "/flowsys/rate/get_best_channel.do?operatorType="+operatorType+"&scopeCityCode="+scopeCityCode,     
	        "dataType": "json",    
	        "success": function(resp) { 
	        	
	        	/* if(typeof(resp[0]) == "undefined"){
	        		$price.html(resp.discount);
	        	}else{
	        		var msgt = resp[0].trim();
	        		if(msgt == "error"){
		        		$price.html("没有通道信息");
		        	}
	        	}
	        	$price.show(); */
	        	alert("success");
	        },
	        "error":function(msg){
	        	alert(msg);
	        }
	    }); 
	
		//$(vart).next().show();
	}else{
		//$(vart).next().hide();
		//$price.hide();
	}
} 


</script>
</html>