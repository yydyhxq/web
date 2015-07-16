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
		current1("driver",1);
		
		//select	
		$(".select").select2();
			 
		//查询
		$("#search").click(function(){
			var name = $("input[name='name']").val(); //获取乘客手机号
			var phone = $("input[name='phone']").val();
			var registerDateBegin = $("input[name='registerDateBegin']").val();
			var registerDateEnd = $("input[name='registerDateEnd']").val();
			$("#dg").datagrid('load',{
				name:name,
				phone:phone,
				registerDateBegin:registerDateBegin,
				registerDateEnd:registerDateEnd
			})
			$('#dg').datagrid('reload');    // reload the current page data			
		})
		
		 //执行tabs
		var data = { title: '司机信息查看', url: '../backend/driverWatch.jsp' };	
		tabs(data);
	})
</script>
<title>司机信息查看</title>
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
             
               <h3><ul></ul></h3>
               <div class="mainConcls">
               		<!--查询条件 start-->
               		<div class="mainConcls1  clearfix">
                    	<div class="mainConcls2 clearfix">
                       		<label>姓名</label><input type="text" class="inputcls"  name="name" />
                            <label>手机号</label><input type="text" class="inputcls"  name="phone"/>
                            <label>车牌号</label><input type="text" class="inputcls" />
                        </div>
                       
                        <div class="mainConcls2 mainConcls2_1 clearfix">
                       		<label >注册日期</label>
                            <input type="text" class="Wdate inputcls rightcls8"  onclick="WdatePicker()" name="registerDateBegin">
                            <label class="mainConcls2_2">至</label>
                            <input type="text" class="Wdate inputcls"  onclick="WdatePicker()" name="registerDateEnd">
                       		<input type="button" class="buttoncls" value="查询" id="search" />   
                        </div> 	
                    </div>
                    <!--查询条件end-->
                    <!--内容 start--> 
                      <div class="mainConcls4 clearfix">
							 <a  class="btn1" onclick="detailUser()" >查看详情</a> 
                    </div>                      
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
                    
                        <table id="dg" class="easyui-datagrid" style="width:1077px;height:450px"  data-options="url:'../drivermanage/query.do',fitColumns:true,singleSelect:true,pagination:true,rownumbers:true">
                                <thead>
                                    <tr>
                                    	<th data-options="field:'id',width:90 ,hidden:'true' ">id</th>
                                        <th data-options="field:'name',width:90 ">姓名</th>
                                        <th data-options="field:'sexStr',width:90">性别</th>
                                        <th data-options="field:'phone',width:90">手机号</th>
                                        <th data-options="field:'cardno',width:90">身份证</th>
                                        <th data-options="field:'registerTimeStr',width:90">注册时间</th>
                                        <th data-options="field:'onlineStr',width:90">在线状态</th>
                                        <th data-options="field:'labIdStr',width:90">所属租赁公司</th>
                                      	<th data-options="field:'qualifiedDateStr',width:90">培训合格日期</th>
                                        <th data-options="field:'totalService',width:90">服务次数</th>
                                        <th data-options="field:'starLevel',width:90">星级</th>
                                        <th data-options="field:'remark',width:100">备注</th>
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

function detailUser(){
	 var row = $("#dg").datagrid("getSelected");
	  if (row) {
	     window.location.href = "driverDetail.jsp?id=" + row.id;
	  }else{
	 	   layer.alert("未选中任何对象");
	  }
		
}
</script>

</html>
