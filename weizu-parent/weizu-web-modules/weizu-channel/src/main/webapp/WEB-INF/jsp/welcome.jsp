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
<div class="page-container">
	<p class="f-20 text-success">欢迎使用微族通道系统 <span title="最后更新时间：${startupTime }" class="f-14">Beta</span>版本</p>
	<p>最后更新时间：${startupTime }</p>
	<!-- <p>登录次数：18 </p>
	<p>上次登录IP：222.35.131.79.1  上次登录时间：2014-6-14 11:19:55</p> -->
	<!-- <iframe width='738' height='523' class='preview-iframe' scrolling='no' frameborder='0' src='http://download.csdn.net/source/preview/2453923/e55ebbf1b3ddcc48ccaa5684a663488d' ></iframe> -->
	<!-- <table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th colspan="7" scope="col">信息统计</th>
			</tr>
			<tr class="text-c">
				<th>统计</th>
				<th>资讯库</th>
				<th>图片库</th>
				<th>产品库</th>
				<th>用户</th>
				<th>管理员</th>
			</tr>
		</thead>
		<tbody>
			<tr class="text-c">
				<td>总数</td>
				<td>92</td>
				<td>9</td>
				<td>0</td>
				<td>8</td>
				<td>20</td>
			</tr>
			<tr class="text-c">
				<td>今日</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
			</tr>
			<tr class="text-c">
				<td>昨日</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
			</tr>
			<tr class="text-c">
				<td>本周</td>
				<td>2</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
			</tr>
			<tr class="text-c">
				<td>本月</td>
				<td>2</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
			</tr>
		</tbody>
	</table> -->
	<%-- <c:forEach items="${resultMap.billTypeEnums }" var="billTypeEnum" varStatus="vst"></c:forEach> --%>
	<table class="table table-border table-bordered table-bg mt-20">
		<thead>
			<tr>
				<th colspan="2" scope="col">流量信息</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${resultMap.rateList }" var="ratePo" varStatus="vst">
				<c:choose>
					<c:when test="${empty ratePo.specialTag }">
						<c:forEach items="${resultMap.billTypeEnums }" var="billTypeE" varStatus="vst1">
							<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceTypeE" varStatus="vst2">
								<c:if test="${ratePo.serviceType == serviceTypeE.value && ratePo.billType == billTypeE.value }">
									<tr>
											<c:choose>
												<c:when test="${empty ratePo.discountPo.discount0 && empty ratePo.discountPo.discount1 && empty ratePo.discountPo.discount2 }">
												</c:when>
												<c:otherwise>
													<th width="20%">
														${serviceTypeE.desc }-${billTypeE.desc }
													</th>
												</c:otherwise>
											</c:choose>
										
										<c:choose>
											<c:when test="${empty ratePo.discountPo.discount0 && empty ratePo.discountPo.discount1 && empty ratePo.discountPo.discount2 }">
											</c:when>
											<c:otherwise>
												<td>
													<c:if test="${not empty ratePo.discountPo.discount0 }">
														移动：${ratePo.discountPo.discount0 }<br>
													</c:if>
													<c:if test="${not empty ratePo.discountPo.discount1 }">
														联通：${ratePo.discountPo.discount1 }<br>
													</c:if>
													<c:if test="${not empty ratePo.discountPo.discount2 }">
														电信：${ratePo.discountPo.discount2 }<br>
													</c:if>
												</td>
											</c:otherwise>
										</c:choose>
										
									</tr>
								</c:if>
							</c:forEach>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach items="${resultMap.billTypeEnums }" var="billTypeE" varStatus="vst1">
							<c:forEach items="${resultMap.serviceTypeEnums }" var="serviceTypeE" varStatus="vst2">
								<c:if test="${ratePo.serviceType == serviceTypeE.value && ratePo.billType == billTypeE.value}">
									<tr>
										<th class="c-red">${serviceTypeE.desc }-${billTypeE.desc }-${ratePo.specialTag }</th>
										<td >
											<c:choose>
												<c:when test="${not empty ratePo.discountPo.discount0 }">
													移动：${ratePo.discountPo.discount0 }<br>
												</c:when>
												<c:when test="${not empty ratePo.discountPo.discount1 }">
													联通：${ratePo.discountPo.discount1 }<br>
												</c:when>
												<c:when test="${not empty ratePo.discountPo.discount2 }">
													电信：${ratePo.discountPo.discount2 }<br>
												</c:when>
											</c:choose>
										</td>
									</tr>
								</c:if>
							</c:forEach>
						</c:forEach>
					</c:otherwise>
					
				</c:choose>
			
			</c:forEach>
		</tbody>
	</table>
	
	
	<%-- <c:if test="${not empty resultMap.map.nationWide }">
		<h3>全国</h3>
		<c:if test="${not empty resultMap.map.nationWide.billDTO }">
		<h4>带费率：</h4>
			移动：${resultMap.map.nationWide.billDTO.discountPo.discount0 } <br>
			联通：${resultMap.map.nationWide.billDTO.discountPo.discount1 }<br>
			电信：${resultMap.map.nationWide.billDTO.discountPo.discount2 }<br>
		</c:if>
		<c:if test="${not empty resultMap.map.nationWide.noDTO }">
		<h4>不带费率：</h4>
			移动：${resultMap.map.nationWide.noDTO.discountPo.discount0 } <br>
			联通：${resultMap.map.nationWide.noDTO.discountPo.discount1 }<br>
			电信：${resultMap.map.nationWide.noDTO.discountPo.discount2 }<br>
		</c:if>
	</c:if>
	<c:if test="${not empty resultMap.map.provinceRoaming }">
		<h3>省漫游</h3>
		<c:if test="${not empty resultMap.map.provinceRoaming.billDTO }">
		<h4>带费率：</h4>
			移动：${resultMap.map.provinceRoaming.billDTO.discountPo.discount0 } <br>
			联通：${resultMap.map.provinceRoaming.billDTO.discountPo.discount1 }<br>
			电信：${resultMap.map.provinceRoaming.billDTO.discountPo.discount2 }<br>
		</c:if>
		<c:if test="${not empty resultMap.map.provinceRoaming.noDTO }">
		<h4>不带费率：</h4>
			移动：${resultMap.map.provinceRoaming.noDTO.discountPo.discount0 } <br>
			联通：${resultMap.map.provinceRoaming.noDTO.discountPo.discount1 }<br>
			电信：${resultMap.map.provinceRoaming.noDTO.discountPo.discount2 }<br>
		</c:if>
	</c:if>
	<c:if test="${not empty resultMap.map.province }">
		<h3>省内</h3>
		<c:if test="${not empty resultMap.map.province.billDTO }">
			<h4>带费率：</h4>
			移动：${resultMap.map.province.billDTO.discountPo.discount0 } <br>
			联通：${resultMap.map.province.billDTO.discountPo.discount1 }<br>
			电信：${resultMap.map.province.billDTO.discountPo.discount2 }<br>
		</c:if>
		<c:if test="${not empty resultMap.map.province.noDTO }">
			<h4>不带费率：</h4>
			移动：${resultMap.map.province.noDTO.discountPo.discount0 } <br>
			联通：${resultMap.map.province.noDTO.discountPo.discount1 }<br>
			电信：${resultMap.map.province.noDTO.discountPo.discount2 }<br>
		</c:if>
	</c:if> --%>
	<!-- <table class="table table-border table-bordered table-bg mt-20">
		<thead>
			<tr>
				<th colspan="2" scope="col">服务器信息</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th width="30%">服务器计算机名</th>
				<td><span id="lbServerName">http://127.0.0.1/</span></td>
			</tr>
			<tr>
				<td>服务器IP地址</td>
				<td>192.168.1.1</td>
			</tr>
			<tr>
				<td>服务器域名</td>
				<td>www.h-ui.net</td>
			</tr>
			<tr>
				<td>服务器端口 </td>
				<td>80</td>
			</tr>
			<tr>
				<td>服务器IIS版本 </td>
				<td>Microsoft-IIS/6.0</td>
			</tr>
			<tr>
				<td>本文件所在文件夹 </td>
				<td>D:\WebSite\HanXiPuTai.com\XinYiCMS.Web\</td>
			</tr>
			<tr>
				<td>服务器操作系统 </td>
				<td>Microsoft Windows NT 5.2.3790 Service Pack 2</td>
			</tr>
			<tr>
				<td>系统所在文件夹 </td>
				<td>C:\WINDOWS\system32</td>
			</tr>
			<tr>
				<td>服务器脚本超时时间 </td>
				<td>30000秒</td>
			</tr>
			<tr>
				<td>服务器的语言种类 </td>
				<td>Chinese (People's Republic of China)</td>
			</tr>
			<tr>
				<td>.NET Framework 版本 </td>
				<td>2.050727.3655</td>
			</tr>
			<tr>
				<td>服务器当前时间 </td>
				<td>2014-6-14 12:06:23</td>
			</tr>
			<tr>
				<td>服务器IE版本 </td>
				<td>6.0000</td>
			</tr>
			<tr>
				<td>服务器上次启动到现在已运行 </td>
				<td>7210分钟</td>
			</tr>
			<tr>
				<td>逻辑驱动器 </td>
				<td>C:\D:\</td>
			</tr>
			<tr>
				<td>CPU 总数 </td>
				<td>4</td>
			</tr>
			<tr>
				<td>CPU 类型 </td>
				<td>x86 Family 6 Model 42 Stepping 1, GenuineIntel</td>
			</tr>
			<tr>
				<td>虚拟内存 </td>
				<td>52480M</td>
			</tr>
			<tr>
				<td>当前程序占用内存 </td>
				<td>3.29M</td>
			</tr>
			<tr>
				<td>Asp.net所占内存 </td>
				<td>51.46M</td>
			</tr>
			<tr>
				<td>当前Session数量 </td>
				<td>8</td>
			</tr>
			<tr>
				<td>当前SessionID </td>
				<td>gznhpwmp34004345jz2q3l45</td>
			</tr>
			<tr>
				<td>当前系统用户名 </td>
				<td>NETWORK SERVICE</td>
			</tr>
		</tbody>
	</table> -->
	<span style="display: none;" id="rootAgencyId">${loginContext.rootAgencyId }</span>
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
<script  type="text/javascript">
var rootId = $('#rootAgencyId').html();
if(rootId == 0 || rootId == '0'){
	var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1265916742'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s22.cnzz.com/z_stat.php%3Fid%3D1265916742%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));
}
</script>
</body>
</html>