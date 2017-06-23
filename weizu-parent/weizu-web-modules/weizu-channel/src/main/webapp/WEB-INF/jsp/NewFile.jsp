<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>手机号码归属地查询</h1>
    <div class="outer">
        <p>请输入手机号码</p>
        <input type="text"  >
        <span class="button">查询</span>
        <span class="error">号码有误 或 无数据</span>
        <ul>
            <li class="num">手机号码: <span></span></li>            
            <li class="province">归属省份: <span></span></li>
            <li class="operators">运 营 商: <span></span></li>
            <li class="carrier">归属: <span></span></li>
        </ul>
    </div>
<script type="text/javascript" src="../view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script>
    var tel;
    var ajax=function(){
        //淘宝接口    
        $.ajax({
             type: "get",
             url: 'http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel='+tel,
             dataType: "jsonp",
             jsonp: "callback",
             success: function(data){
                console.log(data);
                $('.error').css('display','none');
                var province = data.province,
                    operators = data.catName,
                    carrier = data.carrier,
                    num = data.telString;
                $('.num span').html(num);
                $('.province span').html(province);
                $('.operators span').html(operators);
                $('.carrier span').html(carrier);
             },
             error:function (){    
                $('li span').html('');
                $('.error').css('display','block');        
             }
         });
    }
   
    var reg = /^(13|15|18)[0-9]{9}$/;//点击查询
    $('.button').click(function(){
        tel=$('input[type=text]').val();
        if(tel){
            if(reg.test(tel)){
                ajax();
            }else{
                $('li span').html('');
                $('.error').css('display','block');    
            }
        }
    });
    //键盘事件
    $(window).keydown(function(event){
        tel=$('input[type=text]').val();
        if(event.keyCode==13) {
            if(tel){
                if(reg.test(tel)){
                    ajax();
                }else{
                    $('li span').html('');
                    $('.error').css('display','block');    
                }
            }
        }
    });
</script>

</body>
</html>