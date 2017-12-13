<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" /> 
<title>错误页面</title>
</head>
<body>
	<section class="container-fluid page-404 minWP text-c">
	<p class="error-description">系统最后更新时间：${applicationScope.startupTime }</p>
	<p class="error-title"><i class="Hui-iconfont va-m" style="font-size:80px">&#xe688;</i>
		<span class="va-m"> 500-12</span>
	</p>
	<p class="error-description">您暂时不在登陆状态~</p>
	 <c:choose>
       	<c:when test="${not empty errorMsg }">
       		<p class="error-description">${errorMsg }</p>
       		${loginIpAddress} 
       	</c:when>
       	<c:otherwise>
       		<p class="error-description">系统维护之后，用户未登陆！！</p>
       	</c:otherwise>
      </c:choose>
	<p class="error-info">您可以：
		<a href="javascript:;" onclick="history.go(-1)" class="c-primary">&lt; 返回重新登陆</a>
		<span class="ml-20">|</span>
		<!-- <a class="btn btn-success radius" href="javascript:parent.location.reload();" title="去首页"><i class="Hui-iconfont">&#xe68f;</i></a> -->
		<a href="javascript:parent.location.reload();" class="c-primary ml-20">刷新登陆 &gt;</a>
	</p>
	</section>
<%-- <table width="100%" border="0" cellspacing="0" bordercolor="#B0E1B3">
  <tr>
    <td bordercolor="#FFFFFF" bgcolor="#80D7F0">
      <table width="100%" border="0" align="center">
        <tr align="center" height="50" >
          <td width="90%">
				<font color="red">发生错误</font>
		  </td>
        </tr>
        <tr align="center">
          <td width="90%">
	       <c:choose>
	       	<c:when test="${not empty errorMsg }">
	       		<font color="red">${errorMsg }</font>
	       	</c:when>
	       	<c:otherwise>
	       		<font color="red">系统维护之后，用户未登陆！！</font>
	       		<br>
	       	</c:otherwise>
	       </c:choose>
	      <br> <font color="green">系统最后更新时间：${applicationScope.startupTime }</font>
		  </td>
        </tr>
      </table>
   </td>
  </tr>
   <tr>
    <td >
      <table width="100%" border="0" align="center" cellspacing="0">
        <tr align="center">
          <td width="90%">
			<!-- <input type="button" name="back" value="返回" onclick="history.back();"> -->
			<a class="btn btn-success radius" href="javascript:parent.location.reload();" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
		  </td>
        </tr>
      </table>
   </td>
  </tr>
</table> --%>
<%-- <table width="100%" border="0" cellspacing="0" bordercolor="">
  <tr>
    <td bordercolor="#FFFFFF" bgcolor="#80D7F0">
      <table width="100%" border="0" align="center">
        <tr align="center" height="50" >
          <td width="90%">
				<font color="green">发生错误</font>
		  </td>
        </tr>
        <tr align="center">
          <td width="90%">
	       <c:choose>
	       	<c:when test="${not empty errorMsg }">
	       		<font color="green">${errorMsg }</font>
	       	</c:when>
	       	<c:otherwise>
	       		<font color="green">系统维护之后，用户未登陆！！</font>
	       		<br>
	       	</c:otherwise>
	       </c:choose>
	      <br> <font color="green">系统最后更新时间：${applicationScope.startupTime }</font>
		  </td>
        </tr>
      </table>
   </td>
  </tr>
   <tr>
    <td >
      <table width="100%" border="0" align="center" cellspacing="0">
        <tr align="center">
          <td width="90%">
			<!-- <input type="button" name="back" value="返回" onclick="history.back();"> -->
			<a class="btn btn-success radius" href="javascript:parent.location.reload();" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
		  </td>
        </tr>
      </table>
   </td>
  </tr>
</table> --%> 
</body>
</html>
