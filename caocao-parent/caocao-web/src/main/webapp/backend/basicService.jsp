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
	current2("customer",2,1)
	
	$(".select").select2();
	//查询
	$("#search").click(function(){
		var name = $("input[name='name']").val(); //获取用户名称
		var phone = $("input[name='phone']").val(); //获取用户手机号
		var registerDateBegin =$("input[name='registerDateBegin']").val();
		var registerDateEnd =$("input[name='registerDateEnd']").val();
		var a = compare(registerDateBegin,registerDateEnd);
		if(a==1){layer.msg("结束日期不得小于开始日期");return false;}
		$("#dg").datagrid('load',{
			name:name,
			phone:phone,
			registerDateBegin:registerDateBegin,
			registerDateEnd:registerDateEnd
		})
		$('#dg').datagrid('reload');    // reload the current page data			
	})
	

	 //执行tabs
	var data = { title: '普通客户用户信息维护', url: '../backend/basicService.jsp' };	
	tabs(data);

			
})
</script>
<title>普通客户信息维护</title>
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
    <div class="container-fluid">
      <div class="row-fluid">
      
      <!--菜单start-->
        	<%@ include file="/backend/common/menu.jsp"%>
        <!--菜单end-->
        
         <!--Body content start-->
        <div class="rightArea">
        	<div class="mainCon">
             
               <h3><ul></ul></h3>
               <div class="mainConcls">
               		<!--查询条件 start-->
               		<div class="mainConcls1 clearfix">
                    	<div class="mainConcls2 clearfix">
                       		<label>姓名</label><input type="text" class="inputcls"  id="name" />
                            <label>联系电话</label><input type="text" class="inputcls" id="phone" />
                        </div>
                        <div class="mainConcls2 mainConcls2_1 clearfix">
                       		<label >注册日期</label>
                            <input type="text" class="Wdate inputcls rightcls8"  onclick="WdatePicker()" name="registerDateBegin" >
                            <label class="mainConcls2_2">至</label>
                            <input type="text" class="Wdate inputcls"  onclick="WdatePicker()" name="registerDateEnd">
                       		<input type="button" class="buttoncls" value="查询" id="search" />   
                        </div> 	
                    </div>
                    <!--查询条件end-->
                    <!--内容 start-->

                    <div class="mainConcls3">
                    	<!-- 点击区域start -->
                    	<div class="datagrid-header selectPoint" >
                    		<em class="emcls "></em>
                    	</div>
                    	<!-- 点击区域end -->
                    	<!-- 弹出框 -->
	                    <div class="selectArea fn-hide">
	                    	<ul> 	
	                    	</ul>
	                    </div>
	                  	<!-- 弹出框 -->
                    
                    
                    	<table id="dg" class="easyui-datagrid" style="width:1077px;height:450px"  data-options="url:'../comcustumer/combase.do',fitColumns:true,singleSelect:true,pagination:true,rownumbers:true">
                        	<thead>
                            	<tr>
                                	<th  data-options="field:'id',width:80" hidden="true">id</th>
                                    <th  data-options="field:'name',width:80">姓名</th>
                                    <th  data-options="field:'sexStr',width:80">性别</th>
                                    <th  data-options="field:'phone',width:80">手机号</th>
                                    <th  data-options="field:'costTimes',width:80">消费次数</th>
                                    <th  data-options="field:'costMoney',width:80">消费金额</th>
                                    <th  data-options="field:'inviteCode',width:80">邀请码</th>
                                    <th  data-options="field:'starLevel',width:80">星级</th>
                                    <th  data-options="field:'carType',width:80">车型偏好</th>
                                    <th  data-options="field:'registerDate',width:80">注册时间</th>
                                    <th  data-options="field:'costCity',width:80">消费城市</th>
                                </tr>
                            </thead>
                		<table>
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
