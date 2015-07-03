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
<link href="js/select2/select2.css" type="text/css" rel="stylesheet" />
<link href="css/easyui.css" type="text/css" rel="stylesheet" />
<link href="css/icon.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.9.0.js"></script>
<script type="text/javascript" src="js/select2/select2.js"></script>
<script type="text/javascript" src="js/layer/layer.js"></script> 
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/city.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script> 
<!--[if IE]><script type="text/javascript" src="js/html5.js"></script><![endif]-->
<script>
	$(function(){
		//获取id名
		var id = getId("id");
		
		if(id!="") { $('#dg').datagrid('reload',{id:id})};
		
		//查询
		$("#search").click(function(){
			var costDateBegin = $("input[name='costDateBegin']").val(); //获取年
			var costDateEnd=$("input[name='costDateEnd']").val(); //获取月
			
			$("#dg").datagrid('load',{
				costDateBegin:costDateBegin,
				costDateEnd:costDateEnd
			})
			$('#dg').datagrid('reload');    // reload the current page data			
		})
		
	})
</script>
<title>普通客户详细信息</title>
</head>
<body>
	<!--header start-->
    <div class="fn-title">
        <div class="navbar navBg">
        	<div class="navIcon">
            	
            </div>
            <div class="navUser">
            	<a href="login.jsp">退出</a>
                <span class="sx">|</span>
                <a href="userInfo.jsp">个人设置</a>
                <span class="topUserInfo_manage">欢迎您，管理员</span>
            </div>
        </div>
    </div>
    <!--header end-->
   <div class="container detailcls  detailcls1">
   		<div class="mainCon">
            <a href="basicWatch.jsp">返回</a>
            <h3>普通客户详细信息 </h3>
             <div class="mainConcls2 mainConcls2_1 clearfix">
                <label >消费日期</label>
                <input type="text" class="Wdate inputcls rightcls8" readonly onclick="WdatePicker()" name="costDateBegin">
                <label class="mainConcls2_2">至</label>
                <input type="text" class="Wdate inputcls" readonly onclick="WdatePicker()" name="costDateEnd">
                <input type="button" class="buttoncls" value="查询" id="search" />   
            </div> 	
           	<div class="mainConcls3">
            	<table id="dg" class="easyui-datagrid" style="width:920px;height:450px"  data-options="url:'../comcustumer/comcost.do',fitColumns:true,singleSelect:true,pagination:true,rownumbers:true">
                    <thead>
                        <tr>
                            <th  data-options="field:'id',width:80" hidden="true">id</th>
                            <th  data-options="field:'costDate',width:80">消费日期</th>
                            <th  data-options="field:'distance',width:80">行驶里程（公里）</th>
                            <th  data-options="field:'driverMinutes',width:80">行驶时间（分钟）</th>
                            <th  data-options="field:'costMoney',width:80">费用小计</th>
                            <th  data-options="field:'discountMoney',width:80">优惠金额</th>
                            <th  data-options="field:'realMoney',width:80">已付金额</th>
                            <th  data-options="field:'privilegeCode',width:80">优惠码</th>
                            <th  data-options="field:'carType',width:80">搭乘车型</th>
                            <th  data-options="field:'costCity',width:80">消费城市</th>
                            <th  data-options="field:'startAndEnd',width:200">起止点</th>
                        </tr>
                    </thead>
                <table>
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
				var va = filed[i].split("=");
				if(va[0]==key){
					id=va[1];
				}	
			}
		}
		return id;
	 }
</script>
</html>
