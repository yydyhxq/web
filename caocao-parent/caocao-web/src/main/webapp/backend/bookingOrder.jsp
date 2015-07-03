<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/backend/common/meta.jsp" %>
<%@ include file="/backend/common/script.jsp"%>

<script>
	$(function(){
		//当前菜单
		current1("order",1)
		
		$(".select").select2();
		
		//所在城市
		 var test=new Vcity.CitySelector({input:'costCity'});
		 
		//查询
		$("#search").click(function(){
			var passengerPhone = $("#passengerPhone").val(); //获取乘客手机号
			var driverPhone = $("#driverPhone").val(); //获取司机手机号
			var costCity =$("#costCity").val();//获取所在城市
			var appointmentBegin =$("#appointmentBegin").val();
			var appointmentEnd =$("#appointmentEnd").val();
			var appointStartBegin =$("#appointStartBegin").val();
			var appointStarrtEnd =$("#appointStarrtEnd").val();
			var a = compare1(appointmentBegin,appointmentEnd);
			var b = compare(appointStartBegin,appointStarrtEnd);
			if(a==1){layer.msg("预约日期结束日期不得小于开始日期");return false;}
			if(b==1){layer.msg("预约出发日期结束日期不得小于开始日期");return false;}
			$("#dg").datagrid('load',{
				passengerPhone:passengerPhone,
				driverPhone:driverPhone,
				costCity:costCity,
				appointmentBegin:appointmentBegin,
				appointmentEnd:appointmentEnd,
				appointStartBegin:appointStartBegin,
				appointStarrtEnd:appointStarrtEnd
			})
			$('#dg').datagrid('reload');    // reload the current page data	
			
		})
		
	})
</script>
<title>预约订单</title>
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
    <div class="container-fluid">
      <div class="row-fluid">
      
      <!--菜单start-->
        	<%@ include file="/backend/common/menu.jsp"%>
        <!--菜单end-->
        
         <!--Body content start-->
        <div class="rightArea">
        	<div class="mainCon">
             
               <h3>预约订单</h3>
               <div class="mainConcls">
               		<!--查询条件 start-->
               		<div class="mainConcls1 clearfix">
                    	<div class="mainConcls2 clearfix">
                       		<label>乘客手机号</label><input type="text" class="inputcls" name="passengerPhone" id="passengerPhone" />
                            <label>司机手机号</label><input type="text" class="inputcls" name="driverPhone" id="driverPhone" />
                            <label>订单状态</label>
                            <select class="select" name="orderStatus" id="orderStatus">
                                  <option value ="3">已到达上车地</option>
                                  <option value ="4">乘客已上车</option>
                                  <option value="6">乘客已到达</option>
                            </select>   
                        </div>
                        <div class="mainConcls2 mainConcls2_1 clearfix">
                       		<label >预约日期</label>
                            <input type="text" class="Wdate inputcls rightcls8"   onclick="WdatePicker()" name="appointmentBegin" id="appointmentBegin">
                            <label class="mainConcls2_2">至</label>
                            <input type="text" class="Wdate inputcls currentTime"  onclick="WdatePicker()" name="appointmentEnd" id="appointmentEnd">
                       		<label>消费城市</label> <input type="text"  placeholder="请输入城市名" id="costCity"  name="costCity"/>
                        </div> 	
                        <div class="mainConcls2 mainConcls2_1 clearfix">
                       		<label >预约出发日期</label>
                            <input type="text" class="Wdate inputcls rightcls8"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" name="appointStartBegin" id="appointStartBegin">
                            <label class="mainConcls2_2">至</label>
                            <input type="text" class="Wdate inputcls"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" name="appointStarrtEnd" id="appointStarrtEnd">
                       		<input type="button" class="buttoncls" value="查询" id="search"/>  
                        </div> 	
                    </div>	
                    <!--查询条件end-->
                   	
                    
                    <!--内容 start-->
                    
                   
                    <div class="mainConcls3">
                    	<table id="dg" class="easyui-datagrid" style="width:1077px;height:450px"  data-options="url:'../ordermanage/bookorder.do',fitColumns:true,singleSelect:true,pagination:true,rownumbers:true">
                                <thead>
                                    <tr>
                                        <th data-options="field:'orderId',width:90 ">订单号</th>
                                        <th data-options="field:'passengerName',width:90">乘客姓名</th>
                                        <th data-options="field:'passengerPhone',width:90">乘客手机号</th>
                                        <th data-options="field:'appointmentTime',width:90">预约时间</th>
                                        <th data-options="field:'appointStartTime',width:90">预约出发时间</th>
                                        <th data-options="field:'startPlace',width:90">出发点</th>
                                        <th data-options="field:'destination ',width:90">目的地</th>
                                        <th data-options="field:'driverName',width:90">司机姓名</th>
                                      	<th data-options="field:'driverPhone',width:90">司机手机号</th>
                                        <th data-options="field:'orderStatus',width:90">订单状态</th>
                                        <th data-options="field:'costCity',width:90">消费城市</th>
                                        <th data-options="field:'isBig',width:100">是否大客户</th>
                                    </tr>
                                </thead>                   
                           </table>
                    </div>	
                    
                    <!--内容 end--> 
               </div> 
               
            </div>
        </div>
         <!--Body content end-->
      </div>
    </div>
    
    
  
</body>
</html>
