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
		 
		//默认时间
			var d = new Date();
			var str = d.getFullYear()+"-"+fix((d.getMonth()+1),2)+"-"+fix(d.getDate(),2);
			$(".currentTime").val(str);

		//默认加载当天的数据
			var url = '../ordermanage/bookorder.do?appointStartBegin='+str+'&appointStarrtEnd='+str;
			$("#dg").datagrid({url:url});
			
		
			//datagrid 自适应	
			$("#dg").datagrid("resize",{  
				width: getWidth(0.95)  
			});                
		
			$(window).resize(function(){  
					//alert("change....");  
				$("#dg").datagrid("resize",{  
					width: getWidth(0.95)  
				});                
			})
			
		//查询
		$("#search").click(function(){
			var passengerPhone = $("#passengerPhone").val(); //获取乘客手机号
			var driverPhone = $("#driverPhone").val(); //获取司机手机号
			var costCity =$("#costCity").val();//获取所在城市
			var orderStatus =$("#orderStatus").val();//获取订单状态
			var appointmentBegin =$("#appointmentBegin").val();
			var appointmentEnd =$("#appointmentEnd").val();
			var appointStartBegin =$("#appointStartBegin").val();
			var appointStarrtEnd =$("#appointStarrtEnd").val();
			var a = compare(appointmentBegin,appointmentEnd);
			var b = compare(appointStartBegin,appointStarrtEnd);
			if(a==1){layer.msg("预约日期结束日期不得小于开始日期");return false;}
			if(b==1){layer.msg("预约出发日期结束日期不得小于开始日期");return false;}
			
			var url = "../ordermanage/bookorder.do?passengerPhone="+passengerPhone+"&driverPhone="+driverPhone+"&costCity="+costCity+"&orderStatus="+orderStatus+"&appointmentBegin="+appointmentBegin+"&appointmentEnd="+appointmentEnd+"&appointStartBegin="+appointStartBegin+"&appointStarrtEnd="+appointStarrtEnd;
			 $("#dg").datagrid({url:url});
			
			/* $("#dg").datagrid('load',{
				passengerPhone:passengerPhone,
				driverPhone:driverPhone,
				costCity:costCity,
				appointmentBegin:appointmentBegin,
				appointmentEnd:appointmentEnd,
				appointStartBegin:appointStartBegin,
				appointStarrtEnd:appointStarrtEnd
			})
			$('#dg').datagrid('reload');    // reload the current page data	 */
			
		})
		

		 //执行tabs
		var data = {title: '预约订单', url: '../backend/bookingOrder.jsp' };	
		tabs(data);
	
		
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
             
      <!--菜单start-->
        	<%@ include file="/backend/common/menu.jsp"%>
        <!--菜单end-->
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
     
        
         <!--Body content start-->
        <div class="rightArea">
        	<div class="mainCon">
             
               <h3><ul></ul></h3>
               <div class="mainConcls">
               		<!--查询条件 start-->
               		<div class="mainConcls1 clearfix">
                    	<div class="mainConcls2 clearfix">
                       		<label>乘客手机号</label><input type="text" class="inputcls" name="passengerPhone" id="passengerPhone" />
                            <label>司机手机号</label><input type="text" class="inputcls" name="driverPhone" id="driverPhone" />
                            <label>订单状态</label>
                            <select class="select" name="orderStatus" id="orderStatus">
                             	  <option value ="">--请选择订单状态--</option>
                                  <option value ="2">已派单</option>
                                  <option value="3">乘客已上车</option>
                            </select>   
                        </div>
                        <div class="mainConcls2 mainConcls2_1 clearfix">
                       		<label >预约日期</label>
                            <input type="text" class="Wdate inputcls rightcls8 "   onclick="WdatePicker()" name="appointmentBegin" id="appointmentBegin">
                            <label class="mainConcls2_2">至</label>
                            <input type="text" class="Wdate inputcls "  onclick="WdatePicker()" name="appointmentEnd" id="appointmentEnd">
                       		<label>消费城市</label> <input type="text"  placeholder="请输入城市名" id="costCity"  name="costCity"/>
                        </div> 	
                        <div class="mainConcls2 mainConcls2_1 clearfix">
                       		<label >预约出发日期</label>
                            <input type="text" class="Wdate inputcls rightcls8 currentTime"  onclick="WdatePicker()" name="appointStartBegin" id="appointStartBegin">
                            <label class="mainConcls2_2">至</label>
                            <input type="text" class="Wdate inputcls currentTime"  onclick="WdatePicker()" name="appointStarrtEnd" id="appointStarrtEnd">
                       		<input type="button" class="buttoncls" value="查询" id="search"/>  
                        </div> 	
                    </div>	
                    <!--查询条件end-->      	
                    
                    <!--内容 start-->
                                     
                    <div class="mainConcls3">
                    	<!-- 点击区域start -->
                    	<div class="datagrid-header selectPoint" >
                    		<em class="emcls"></em>	
                    	</div>
                    	<!-- 点击区域end -->
                    	<!-- 弹出框 -->
	                    <div class="selectArea fn-hide">
	                    	<ul>
	                    	</ul>
	                    </div>
	                  	<!-- 弹出框 -->
                    
                    	<table id="dg" class="easyui-datagrid" style="width:1077px;height:450px"  data-options="url:'',fitColumns:true,singleSelect:true,pagination:true,rownumbers:true">
                                <thead>
                                    <tr>
                                        <th data-options="field:'orderId',width:90 ">订单号</th>
                                        <th data-options="field:'passengerName',width:90">乘客姓名</th>
                                        <th data-options="field:'passengerPhone',width:90">乘客手机号</th>
                                        <th data-options="field:'appointmentTimeStr',width:90">预约时间</th>
                                        <th data-options="field:'appointStartTimeStr',width:90">预约出发时间</th>
                                        <th data-options="field:'startPlace',width:90">出发点</th>
                                        <th data-options="field:'destination',width:90">目的地</th>
                                        <th data-options="field:'driverName',width:90">司机姓名</th>
                                      	<th data-options="field:'driverPhone',width:90">司机手机号</th>
                                        <th data-options="field:'orderStatusStr',width:90">订单状态</th>
                                        <th data-options="field:'costCity',width:90">消费城市</th>
                                        <th data-options="field:'isBigStr',width:100">是否大客户</th>
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
