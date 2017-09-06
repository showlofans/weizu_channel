<%@ page contentType="text/html;charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
<meta http-equiv="expires" content="0">
<style type="text/css">
.style1 {
	color: #0000CC;
	font-size: 16px;
	font-weight: bold;
}
</style>
<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js">//引入jquery框架
</script>
</head>
<body>
	<form name="loginForm" id="loginForm" method="post" action="goLogin">
		<table width="50%" border="1" align="center" cellpadding="0"
			cellspacing="0" bordercolor="#CCCCCC">
			<caption>
				<span class="style1"> 登 录 </span><br>
			</caption>
			<tr align="left">
				<th width="40%" height="35" align="center" scope="row">用户名:</th>
				<td width="60%"><input name="userName"  type="text" id="userName"
					  onblur="nameText()" maxlength="20"><div id="divName"></div></td>
			</tr>
			<tr align="left">
				<th height="35" align="center" scope="row">密&nbsp;&nbsp;码:</th>
				<td><input name="userPass" type="text" autocomplete="off" id="userPass"
					onblur="passText()"  onfocus="this.type='password'" maxlength="30"><div id="divPass"></div></td>
			</tr>
			<tr align="center">
				<th height="35" colspan="2" scope="row"><input class="loginButton" id="loginBtn" type="submit"
					name="Submit" value="登录"> <input type="button"
					name="Submit2" value="注册"
					onclick="javascript:window.location='userRegister.jsp'"></th>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	 function nameText() {
		/* var name = document.getElementByIdx_x("userName");
		var divID = document.getElementByIdx_x("divName");
		divID.innerHTML = "";
		if (name.value == "") {
			divID.innerHTML = "用户名不能为空";
			return false;
		} */
	}
	$(function(){
		$("#loginBtn").click(function(){  
            // 做表单输入校验  
            var userName = $("#userName");  
            var userPass = $("#userPass");  
            /* var code = $("#code");   */
            var msg = "";  
            if ($.trim(userName.val()) == ""){  
                msg = "用户名不能为空！";  
                userName.focus();  
            }
           /*  else if (!/^\w{5,20}$/.test($.trim(userName.val()))){  
                msg = "用户名格式不正确！";  
                userName.focus();  
            } */
            else if ($.trim(userPass.val()) == ""){  
                msg = "密码不能为空！";  
                userPass.focus();  
            }
           /*  else if (!/^\w{6,20}$/.test($.trim(userPass.val()))){  
                msg = "密码格式不正确！";  
                userPass.focus();  
            } */
            /* else if ($.trim(code.val()) == ""){  
                msg = "验证码不能为空！";  
                code.focus();  
            }else if (!/^[0-9a-zA-Z]{4}$/.test($.trim(code.val()))){  
                msg = "验证码格式不正确！";  
                code.focus();  
            }   */
            if (msg != ""){  
                alert(msg);
                event.preventDefault(); //禁止提交
            }else{  
                // 获取表单中的参数  
                //var params = $("#loginForm").serialize();  
                //$("#loginBtn").trigger("click"); 
                $("#loginForm").submit();
                //alert(params);  
                // 发送登录的异步请求  
               /*  $.post("login.action", params, function(data, status){  
                    alert(data.tip);  
                }, "json"); 
             // 为document绑定onkeydown事件监听是否按了回车键  
               $(document).keydown(function(event){  
                    if (event.keyCode === 13){ // 按了回车键  
                        $("#loginBtn").trigger("click");  
                    }  
                });  */
            }
		})
	});
	
	function passText() {
		/* var pass = document.getElementByIdx_x("userPass");
		var divIP = document.getElementByIdx_x("divPass");
		divIP.innerHTML = "";
		if (pass.value == "") {
			divIP.innerHTML = "密码不能为空";
			return false;
		} */
	} 
</script>
</html>
