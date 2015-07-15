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
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script> 
<!--[if IE]><script type="text/javascript" src="js/html5.js"></script><![endif]-->
<title>历史订单详情</title>
<script>
	$(function(){
		//获取id名
		var id = getId("orderId");
		
		 var url="../ordermanage/orderdetail.do?orderId="+id; 
	
		$.ajax({
			url:url,
			dataType:'json',
			success:function(data){		
				$("#startPlace").val(data.startPlace);
				$("#endPlace").val(data.endPlace);
				$("#livePlace").val(data.livePlace);
				$("#carType").val(data.carType);
				$("#privilegeCode").val(data.privilegeCode);
				$("#startPrice").val(data.startPrice);
				$("#distance").val(data.distance);
				$("#driverMinutes").val(data.driverMinutes);
				$("#costMoney").val(data.costMoney);
				$("#discountMoney").val(data.discountMoney);
				$("#costRealMoney").val(data.costRealMoney);				
			}

		});
		

	})
</script>
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
   <div class="container detailcls  detailcls1">
   		<div class="mainCon">
            <a href="historyOrder.jsp"><<返回</a>
            <h3>历史订单详情 </h3>
            <div class="formcls formcls1">
            	<div data-title="起点"> 
                	<input type="text" class="inputcls formcls2"  value="" id="startPlace"/>
                </div>
                <div data-title="终点">
                	<input type="text" class="inputcls formcls2" value="" id="endPlace"/>
                </div>
                <div data-title="搭乘车型">
                	<input type="text" class="inputcls" value="	"  id="carType" />
                </div>
                
            	<div data-title="优惠码">
                	<input type="text" class="inputcls"  value="" id="privilegeCode" />
                </div>
              
                <div data-title="起步价">
                	<input type="text" class="inputcls"  value="" id="startPrice"/>
                </div>
                <div data-title="行驶里程（公里）">
                	<input type="text" class="inputcls" value="" id="distance" />
                </div>
                <div data-title="行驶时间">
                	<input type="text" class="inputcls"  value="" id="driverMinutes"/>
                </div>
                <div data-title="费用小计">
                	<input type="text" class="inputcls"  value="" id="costMoney"/>
                </div>
                <div data-title="优惠金额">
                	<input type="text" class="inputcls"  value="" id="discountMoney"/>
                </div>
               <div data-title="已收费">
                	<input type="text" class="inputcls formcls2"  value="" id="costRealMoney"/>
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
