<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0"/>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
<link href="css/common.css" type="text/css" rel="stylesheet"/>
<link href="css/style.css" type="text/css" rel="stylesheet"/>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/layer/layer.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="js/common.js"></script>
<!--[if IE]><script type="text/javascript" src="js/html5.js"></script><![endif]-->
<script>
	$(function(){
		$("#save").click(function(){
			
			var name=$("#name").val();//获取名字
			var sex = $("input[name='sex']").val()//获取性别
			var birthPlace=$("#birthPlace").val();//获取户籍所在地
			var livePlace=$("#livePlace").val();//获取现居住地址
			var phone=$("#phone").val();//联系电话
			var email=$("#email").val();//电子邮箱
			var driverAge = $("#driverAge").val()
			var educateDegree=$("#educateDegree").val();//学历
			var height=$("#height").val();//身高/体重
			var weight=$("#weight").val();//身高/体重
			var isSpecificduty = $("input[name='isSpecificduty']").val();//应聘形式
			var brand=$("#brand").val();//品牌
			var model=$("#model").val();//车型
			if(name==""||sex==""||phone==""){
				layer.msg("必填项为空");return false;
			}
			var form = $("#form").serialize();
			var url = '../drivermanage/add.do';
			$.ajax({
				type:"post",
				url:url,
				dataType:'json',
				data:form,
				success:function(result){
					if(result=="0"){layer.alert("必填写项不能为空！")}
		        	if(result=="1"){layer.alert("后台数据已发生变化,请重新提取数据")}
		        	if(result=="2"){layer.alert("数据修改失败")}
		        	if(result=="4"){layer.alert("系统异常请联系管理员")}
		        	if(result=="3"){  
		        		layer.alert("保存成功")
		        		setTimeout('back("driverService.jsp")',1500);
		        		/* setTimeout(window.location.href="driverService.html",3000); */
		        	};
				},
				error:function(){
					layer.msg("网络异常，请稍后再试！")	
				}
					
			})
		});
	});
	
	function back(url){
		var url = url;
		window.location.href=url;
		
	}
</script>
<title>应聘人员信息登记表</title>
</head>

<body>
	

	<!--header start-->
    <div class="fn-title">
        <div class="navbar navBg">
        	<div class="navIcon">
            	
            </div>
            <div class="navUser">
            	<a href="login.html">退出</a>
                <span class="sx">|</span>
                <a href="userInfo.html">个人设置</a>
                <span class="topUserInfo_manage">欢迎您，管理员</span>
            </div>
        </div>
    </div>
    <!--header end-->
   <div class="container detailcls detailcls2">
   		<div class="mainCon" >
            <a href="driverService.html"><<返回</a>
            <h3>应聘人员信息登记表 </h3>
            <form id="form">
        	<div class="formcls">
            
            	<div data-title="姓名">
                	<input type="text" class="inputcls" id="name" name="name"/>
                </div>
                <div data-title="性别">
                	<span class="radio" >
                        <input type="radio" name="sex" value="0" checked="checked"/>男
                        <input type="radio" name="sex" value="1"  style="margin-left:35px"/>女
                    </span>
                </div>
                <div data-title="户籍所在地">
                	<input type="text" class="inputcls"  id="birthPlace" name="birthPlace" />
                </div>
                <div data-title="现居住地址">
                	<input type="text" class="inputcls"  id="livePlace" name="livePlace"/>
                </div>
                <div data-title="联系电话">
                	<input type="text" class="inputcls" id="phone"  name="phone"/>
                </div>
                <div data-title="电子邮箱">
                	<input type="text" class="inputcls"  id="email" name="email"/>
                    <i>非必填</i>
                </div>
                <div data-title="身份证/护照号">
                	<input type="text" class="inputcls" id="cardno" name="cardno"/>
                </div>
                <div data-title="取得驾照时间">
                	<input type="text" class="Wdate inputcls "  onclick="WdatePicker({position:{left:200,top:0}})"  id="drivelicenseDate" name="drivelicenseDate" />
                </div>
                 <div data-title="培训合格日期">
                	<input type="text" class="Wdate inputcls "  onclick="WdatePicker({position:{left:200,top:0}})"  id="qualifiedDate" name="qualifiedDate"/>
                </div>
                <div data-title="实际驾龄">
                	<input type="text" class="inputcls" id="driverAge" name="driverAge"/>
                </div>
                <div data-title="学历">
                	<input type="text" class="inputcls"  id="educateDegree" name="educateDegree"/>
                </div>
                <div data-title="身高(CM)">
                	<input type="text" class="inputcls" id="height" name="height"/>
                </div>
                <div data-title="体重(KG)">
                	<input type="text" class="inputcls" id="weight" name="weight"/>
                </div>
                 <div data-title="应聘形式">
                 	<span class="radio">
                        <input type="radio" name="isSpecificduty" value="1" checked="checked"/>兼职
                        <input type="radio" name="isSpecificduty" value="0"  style="margin-left:20px"/>全职
                    </span>
                </div>
                 <div data-title="名下是否有自驾车">
                	<span class="radio" >
                        <input type="radio"  value="1" checked="checked"/>是
                        <input type="radio"  value="0"  style="margin-left:35px"/>否
                    </span>
                </div>
                <div data-title="如有自驾车" class="spiltecls">
                
                </div>
            	<div data-title="品牌">
                	<input type="text" class="inputcls" id="trand" name="trand"/>
                </div>
                <div data-title="车型">
                	<input type="text" class="inputcls" id="mode" name="mode"/>
                </div>
                <div data-title="裸车价">
                	<input type="text" class="inputcls" />
                </div>
                <div data-title="车龄">
                	<input type="text" class="inputcls" />
                </div>
            </div>
           	
            <div class="buttonArea">
           		 <input type="button" class="buttoncls" value="保存"  id="save"/>
            </div>
           </form>
        </div>
   </div>
    

    
</body>
</html>



