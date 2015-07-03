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
		//获取id名
		var id = getId("id");
		
		var url="../drivermanage/queryid.do?id="+id;
		$.ajax({
			url:url,
			dataType:'json',
			success:function(data){
				$("#name").val(data.name);
				/* $("#sex").val(data.sexStr); */
				if(data.sex=="0"){
				 	$("#sex").val("男"); 
				}else{
					 $("#sex").val("女"); 	
				}
				$("#birthPlace").val(data.birthPlace);
				$("#livePlace").val(data.livePlace);
				$("#phone").val(data.phone);
				$("#email").val(data.email);
				$("#cardno").val(data.cardno);
				$("#qualifiedDate").val(data.qualifiedDate);
				$("#educateDegree").val(data.educateDegree);
				$("#height").val(data.height);
				$("#weight").val(data.weight);
				if(data.isSpecificduty=="1"){
					$("#radio1").attr("checked","checked").siblings().removeAttr("checked");
				}else{
					$("#radio2").attr("checked","checked").siblings().removeAttr("checked");
				}
				$("#brand").val(data.brand);
				$("#mode").val(data.mode);
				$("#remark").val(data.remark);
			}
		})
	});
</script>
<style>
	 input[readonly]{background-color:#fff}
</style>
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
           
        	<div class="formcls">
            
            	<div data-title="姓名">
                	<input type="text" class="inputcls" id="name" name="name" readonly="readonly" />
                </div>
                <div data-title="性别">
                	<input type="text" class="inputcls" id="sex" name="sexStr" readonly="readonly"/>
                </div>
                <div data-title="户籍所在地">
                	<input type="text" class="inputcls"  id="birthPlace" name="birthPlace" readonly="readonly"/>
                </div>
                <div data-title="现居住地址">
                	<input type="text" class="inputcls"  id="livePlace" name="livePlace" readonly="readonly"/>
                </div>
                <div data-title="联系电话">
                	<input type="text" class="inputcls" id="phone"  name="phone" readonly="readonly"/>
                </div>
                <div data-title="电子邮箱">
                	<input type="text" class="inputcls"  id="email" name="email" readonly="readonly"/>
                    <i>非必填</i>
                </div>
                <div data-title="身份证/护照号">
                	<input type="text" class="inputcls" id="cardno" name="cardno" readonly="readonly"/>
                </div>
                <div data-title="取得驾照时间">
                	<input type="text" class="inputcls"  id="drivelicenseDate" name="drivelicenseDate" readonly="readonly" />
                </div>
                <div data-title="培训合格日期">
                	<input type="text" class="Wdate inputcls "   id="qualifiedDate" name="qualifiedDate" readonly="readonly" />
                </div>
                <div data-title="实际驾龄">
                	<input type="text" class="inputcls" id="driverAge" name="driverAge" readonly="readonly" />
                </div>
                <div data-title="学历">
                	<input type="text" class="inputcls"  id="educateDegree" name="educateDegree" readonly="readonly" />
                </div>
                <div data-title="身高(CM)">
                	<input type="text" class="inputcls" id="height" name="height" readonly="readonly" />
                </div>
                <div data-title="体重(KG)">
                	<input type="text" class="inputcls" id="weight" name="weight" readonly="readonly"/>
                </div>
                 <div data-title="应聘形式">
                 	<span class="radio">
                        <input type="radio" name="isSpecificduty" value="1"  id="radio1" checked="checked" readonly="readonly" />兼职
                        <input type="radio" name="isSpecificduty" value="0"  id="radio2" style="margin-left:20px" readonly="readonly" />全职
                    </span>
                </div>
                 <div data-title="名下是否有自驾车">
                	<span class="radio" >
                        <input type="radio" name="hasCar" value="1" checked="checked" readonly="readonly" />是
                        <input type="radio" name="hasCar" value="0"  style="margin-left:35px" readonly="readonly" />否
                    </span>
                </div>
                <div data-title="如有自驾车" class="spiltecls">
                
                </div>
            	<div data-title="品牌">
                	<input type="text" class="inputcls" id="trand" name="trand" readonly="readonly" />
                </div>
                <div data-title="车型">
                	<input type="text" class="inputcls" id="mode" name="mode" readonly="readonly" />
                </div>
                <div data-title="裸车价">
                	<input type="text" class="inputcls" readonly="readonly" />
                </div>
                <div data-title="车龄">
                	<input type="text" class="inputcls" readonly="readonly" />
                </div>
            </div>
           	
          
        </div>
   </div>
    

    
</body>
<script>

	//获取url参数
	function getId(key){
		var id;
		var urlmap = location.href.split("?");
		
		if(urlmap[1]==""||urlmap[1]== undefined){
			
			id=""; 
		}else{
		var field = urlmap[1].split("&");
			for(var i=0;i<field.length;i++){
				var va = field[i].split("=");
				if(va[0]==key){
					id=va[1];
					
				}	
			}
		}
		return id;
	 }
</script>
</html>
