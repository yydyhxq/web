<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0"/>
<link href="css/common.css" type="text/css" rel="stylesheet"/>
<link href="css/style.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<!--[if IE]><script type="text/javascript" src="js/html5.js"></script><![endif]-->
<script>
$(document).ready(function(){
	$(".logincls08").focus(function(){
		var htm=$(this).next(".logincls10").html();
		if(htm=="获取验证码"||htm=="验证码"){
			$(this).next(".logincls10").hide();
		}else{
			$(this).next(".logincls10").show();
		}
	});
		
	$(".logincls08").keyup(function(){
		var txt = $(this).val();
		if(txt != ""){
			$(this).next(".logincls10").hide();	
		}else{
			$(this).next(".logincls10").show();		
		}
	});
     
	$(".logincls10").click(function(){
		$(this).prev(".logincls08").focus();	
	});
		
	$(".logincls13").click(function(){
		var cls = $(this).attr("class");
		if(cls == "logincls13"){
			$(this).addClass("check");	
		}else{
			$(this).removeClass("check");		
		}
	});
		
	var error = $(".errorcls");
		
	//ajax 获取验证码
	$(".logincls10_1").click(function(){
		var phone = $(this).siblings("#telphone").val();
		if(phone==""){
			error.html("手机号不能为空！");
			return false;
		}else if(phone.length!=11){
			error.html("手机号码不正确！");
			return false;
		}
		error.html("验证码已发送");
		$.ajax({
			type: 'get',
			url: '../login/acquireCode.do?mobile='+phone ,
			dataType: 'json',
			success: function(data){
				error.html("验证码已发送")
			} ,
			error:function(){
				error.html("网络异常,请稍后再试");
			}
		});		
	});
	
	//ajax 登陆
	$("#loginsubmit").click(function(){
		var phone=$("#telphone").val();
		var code=$("#code").val();
		
		if(code==""){
			error.html("验证码不能为空");
			return false;	
		}
		var url = '../login/userLogin.do?mobile='+phone+'&pin='+code;
		$.ajax({
			type: 'get',
			url: url,
			dataType: 'json',
			success: function(data){
			
				if(data=="0"){
					error.html("用户不存在");
					return false;	
				}else if(data=="1"){
					error.html("验证码不正确，请重新获取");
					return false;	
				}else if(data=="2"){
					error.html("账号未启用，请联系管理员");
					return false;	
				}else if(data=="3"){
					error.html("账号已过期，请联系管理员");
					return false;	
				}else if(data=="4") {
					
					window.location.href="../backend/index.jsp";
				}
			} ,
			 error : function() {       
				layer.msg("网络异常，请稍后再试！");    
			}    	
		});
	});
 });  

</script>

<title>登陆界面</title>
</head>

<body>
	

	<div class="header">
    	<p></p>
    </div>
    <div class="midArea">
        <div class="container">
            <div class="loginArea">
                <div class="logincls06">
                    用户登陆
                </div>
                
                <div class="logincls07">
                <div class="errorcls"></div>
                    <form method="post" action="userInfo.html">
                        <div class="textArea">                        	
                            <input type="text" class="logincls08"  id="telphone" tabindex="1">
                            <label class="logincls10" >手机号</label>
                           	<label class="logincls10_1">获取验证码</label>
                        </div>
                        <div class="textArea">
                            <input type="password" class="logincls08 logincls09"  id="code" tabindex="2">
                            <label class="logincls10">验证码</label>
                        </div>
                        <input type="button" class="logincls15" id="loginsubmit" tabindex="3" value="登陆">
                     </form>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
    	<ul class="footerText"> 
        	<li>建议使用ie8/9/10,firefox,chrome，safari浏览器<a href="#" target="_blank" > Chrome点击下载</a></li>
          	<li>Copyright © 2009-2012 evun.cn,inc. 公司版权所有，保留所有权利。</li>  
        </ul>
    </div>
   
</body>
</html>
