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
		current1("order",2)
		
		//所在城市
		 var test=new Vcity.CitySelector({input:'costCity'});
		
		//默认时间
		var d = new Date();
		var str = d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate()+" "+d.getHours()+":"+d.getMinutes();
		$(".currentTime").val(str);
		
		//查询
		$("#search").click(function(){
			var passengerPhone = $("#passengerPhone").val(); //获取乘客手机号
			var driverPhone = $("#driverPhone").val(); //获取司机手机号
			var costCity =$("#costCity").val();//获取所在城市
			var orderCreateBegin =$("#orderCreateBegin").val();//获取订单产生时间
			var orderCreateEnd =$("#orderCreateEnd").val();//获取订单产生时间
			
			$("#dg").datagrid('load',{
				passengerPhone:passengerPhone,
				driverPhone:driverPhone,
				costCity:costCity,
				orderCreateBegin:orderCreateBegin,
				orderCreateEnd:orderCreateEnd
			})
			$('#dg').datagrid('reload');    // reload the current page data			
		})
	})
</script>
<title>实时订单</title>
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
               <h3>实时订单</h3>
               <div class="mainConcls">
               		<!--查询条件 start-->
               		<div class="mainConcls1 clearfix">
                    	<div class="mainConcls2 clearfix">
                       		<label>乘客手机号</label><input type="text" class="inputcls"  name="passengerPhone" id="passengerPhone"/>
                            <label>司机手机号</label><input type="text" class="inputcls"  name="driverPhone" id="driverPhone"/>
                           	<label>消费城市</label> <input type="text"  placeholder="请输入城市名" id="costCity"  name="costCity"/>    
                        </div>
                        <div class="mainConcls2 mainConcls2_1 clearfix">
                       		<label >订单产生时间</label>
                            <input type="text" class="Wdate inputcls rightcls8"   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" id="orderCreateBegin">
                            <label class="mainConcls2_2">至</label>
                            <input type="text" class="Wdate inputcls currentTime"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" id="orderCreateEnd">
                       		 
                       		<input type="button" class="buttoncls" value="查询" />  
                        </div> 	
                    </div>
                    <!--查询条件end-->
                   	
                    
                    <!--内容 start-->
                    
                    <div class="mainConcls3">
                  		  <table id="dg" class="easyui-datagrid" style="width:1077px;height:450px"  data-options="url:'../ordermanage/soonorder.do',fitColumns:true,singleSelect:true,pagination:true,rownumbers:true">
                                <thead>
                                    <tr>
                                        <th data-options="field:'orderId',width:90 ">订单号</th>
                                        <th data-options="field:'passengerName',width:90">乘客姓名</th>
                                        <th data-options="field:'passengerPhone',width:120">乘客手机号</th>
                                        <th data-options="field:'orderProduceTime',width:90">订单产生时间</th>
                                        <th data-options="field:'startPlace',width:90">起点</th>
                                        <th data-options="field:'onCarTime',width:90">上车时间</th>
                                        <th data-options="field:'driverName',width:90">司机姓名</th>
                                      	<th data-options="field:'driverPhone',width:90">司机手机号</th>
                                        <th data-options="field:'costCity',width:90">消费城市</th>
                                        <th data-options="field:'isBig',width:90">是否大客户</th>
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
