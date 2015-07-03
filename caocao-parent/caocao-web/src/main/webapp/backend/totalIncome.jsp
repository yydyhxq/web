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
		current1("income",2)
		
		
		$(".select").select2();	
		
		
		//查询
		$("#search").click(function(){
			var year = $("#year").val(); //获取年
			var month= $("#month").val(); //获取月
			$("#dg").datagrid('load',{
				year:year,
				month:month
			})
			$('#dg').datagrid('reload');    // reload the current page data			
		})
	})
</script>
<title>营业总收入</title>
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
               <h3>营业总收入</h3>
               <div class="mainConcls">
               		<!--查询条件 start-->
               		<div class="mainConcls1 clearfix">
                    	<div class="mainConcls2 clearfix">
                       		<label>年度</label>
                            <select class="select" name="year" id="year">
                            	<option value="">--请选择年份--</option>
                				<option value="2015-01-01">2015</option>
                                <option value="2016-01-01">2016</option>
                                <option value="2017-01-01">2017</option>
                                <option value="2018-01-01">2018</option>
                                <option value="2019-01-01">2019</option>
                                <option value="2020-01-01">2020</option>
                                <option value="2021-01-01">2021</option>
                                <option value="2022-01-01">2022</option>
                                <option value="2023-01-01">2023</option>
                                <option value="2024-01-01">2024</option>
                                <option value="2025-01-01">2025</option>                      
                			</select>
                            <label>月份</label>
                             <select class="select" name="month" id="month">
                             	<option value="">--请选择月份--</option>
                				<option value="2015-01-01">01</option>
                                <option value="2015-02-01">02</option>
                                <option value="2015-03-01">03</option>
                                <option value="2015-04-01">04</option>
                                <option value="2015-05-01">05</option>
                                <option value="2015-06-01">06</option>
                                <option value="2015-07-01">07</option>
                                <option value="2015-08-01">08</option>
                                <option value="2015-09-01">09</option>
                                <option value="2015-10-01">10</option>
                                <option value="2015-11-01">11</option>
                                <option value="2015-12-01">12</option>                       
                			</select>
                       		<input type="button" class="buttoncls" value="查询" id="search"/>  
                        </div>  	
                    </div>
                    <!--查询条件end-->
                   	
                    
                    <!--内容 start-->
                  
                    <div class="mainConcls3">
                    	<table id="dg" class="easyui-datagrid" style="width:1077px;height:450px"  data-options="url:'../financemanage/querybusiness.do',fitColumns:true,singleSelect:true,pagination:true,rownumbers:true">
                            <thead>
                                <tr>
                                    <th data-options="field:'yearStr',width:90">年度</th>
                                    <th data-options="field:'monthStr',width:120">月份</th>
                                    <th data-options="field:'totalMoney',width:90">合计金额</th>
                                    <th data-options="field:'disTotalMoney',width:90">优惠总金额</th>
                                    <th data-options="field:'incomeTotal',width:90">应收总金额</th>
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
