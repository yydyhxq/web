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
		current2("customer",1,2)
		
		$(".select").select2();
	//查询
		$("#search").click(function(){
			var username = $("#username").val(); //获取用户名称
			var phone = $("#phone").val(); //获取用户手机号
			var companyName =$("#companyName").val();//获取公司名称
			
			$("#dg").datagrid('load',{
				username:username	,
				phone:phone,
				companyName:companyName
			})
			$('#dg').datagrid('reload');    // reload the current page data			
		});
	
	
	})
</script>
<title>大客户信息查询</title>
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
               <h3>大客户基本信息查询</h3>
               <div class="mainConcls">
               		<!--查询条件 start-->
               		<div class="mainConcls1 clearfix">
                    	<div class="mainConcls2 clearfix">
                       		<label>姓名</label><input type="text" class="inputcls"  />
                            <label>手机号</label><input type="text" class="inputcls"  />
                            <label>所属公司</label>
							<select class="select" id="companyCode" name="companyCode">
		                        <option value="">--请选择公司--</option>   
		                        <option value="10000">杭州优行科技有限公司</option>                   
		                    </select>
                            <input type="button" class="buttoncls" value="查询" />   
                        </div>
                    </div>
                    <!--查询条件end-->
                   	  <div class="mainConcls4 clearfix">
                        <a  class="btn1" onclick="detailuser()" >查看详情</a>
                    </div>
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
	                  	
                    	<table id="dg" class="easyui-datagrid" style="width:1077px;height:450px"  data-options="url:'../bigcustumermanage/queryaccount.do',fitColumns:true,singleSelect:true,pagination:true,rownumbers:true">
                                <thead>
                                    <tr>
                                    	<th data-options="field:'id',width:90" hidden="true">id</th>
                                        <th data-options="field:'name',width:90 ">姓名</th>
                                        <th data-options="field:'sexStr',width:90">性别</th>
                                        <th data-options="field:'phone',width:90">手机号</th>
                                        <th data-options="field:'costMoney1',width:90">个人消费金额</th>
                                        <th data-options="field:'costMoney2',width:90">出差消费金额</th>
                                        <th data-options="field:'costMoney',width:90">消费总金额</th>
                                        <th data-options="field:'company',width:90">公司名称</th>
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
<script>
function detailuser(){
	 var row = $("#dg").datagrid("getSelected");
	 if(row){
		window.location.href= "vipDetail.jsp?custumerId="+ row.id ;
	 }else{
		 layer.alert("未选中任何对象");
	 }
}
</script>
</html>
