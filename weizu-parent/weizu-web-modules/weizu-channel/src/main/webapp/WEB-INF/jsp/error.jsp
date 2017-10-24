<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>错误页面</title>
</head>
<body  bgcolor="#DAF9FE">
<table width="100%" border="0" cellspacing="0" bordercolor="#B0E1B3">
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
	       		<font color="red">系统维护之后，用户未登陆！！</font><br>
	       	</c:otherwise>
	       </c:choose>
	       系统最后更新时间：${applicationScope.startupTime }
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
			<input type="button" name="back" value="返回" onclick="history.back();">
		  </td>
        </tr>
      </table>
   </td>
  </tr>
</table>
</body>
</html>
