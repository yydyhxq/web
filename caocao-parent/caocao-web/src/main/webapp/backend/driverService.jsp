<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%> 
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/backend/common/meta.jsp" %>
<%@ include file="/backend/common/script.jsp"%>

<script>
ddsmoothmenu.init({
	mainmenuid: "smoothmenu1", 		//菜单div的ID
	orientation: 'h', 				//水平菜单or垂直菜单 : 请设置"h" or "v"
	classname: 'ddsmoothmenu', 		//导航菜单的ul标签的class样式名，在这里是ddsmoothmenu.css的样式名
	contentsource: "markup"	,	 	//"markup" or ["container_id", "path_to_menu_file"]
	//customtheme: ["#1c5a80", "#18374a"] //菜单背景色和鼠标移过去时的颜色
})
	$(function(){
		
		//当前菜单
		current1("driver",3);
		
		  var test=new Vcity.CitySelector({input:'fromcity'});
		  
		//datagrid 自适应	
		reSize("dg",0.95);
		  
		//查询
			$("#search").click(function(){
				var name = $("input[name='name']").val(); //获取乘客手机号
				var phone = $("input[name='phone']").val();
				var city = $("input[name='city']").val();
				var qualifiedDateBegin = $("input[name='qualifiedDateBegin']").val();
				var qualifiedDateEnd = $("input[name='qualifiedDateEnd']").val();
				$("#dg").datagrid('load',{
					name:name,
					phone:phone,
					city:city,
					qualifiedDateBegin:qualifiedDateBegin,
					qualifiedDateEnd:qualifiedDateEnd
				})
				$('#dg').datagrid('reload');    // reload the current page data			
			})
			
			
		
			
	})
</script>
<title>司机培训合格维护</title>
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
            
               <h3>司机训练合格维护</h3>
               <div class="mainConcls">
               		<!--查询条件 start-->
               		<div class="mainConcls1 clearfix">
                    	<div class="mainConcls2 clearfix">
                       		<label>姓名</label><input type="text" class="inputcls"  name="name"/>
                            <label>联系电话</label><input type="text" class="inputcls"  name="phone"/>
                            <label>所在城市</label>
                			<input type="text"  placeholder="请输入城市名" id="fromcity"  class="inputcls" name="city"/>
                        </div>
                        <div class="mainConcls2 mainConcls2_1 clearfix">
                       		<label >培训日期</label>
                            <input type="text" class="Wdate inputcls rightcls8"  onclick="WdatePicker()" name="qualifiedDateBegin">
                            <label class="mainConcls2_2">至</label>
                            <input type="text" class="Wdate inputcls"  onclick="WdatePicker()" name="qualifiedDateEnd">
                       		<input type="button" class="buttoncls" value="查询" id="search" />   
                        </div> 	
                    </div>
                    <!--查询条件end-->
                   	
                    
                    <!--内容 start-->
                    
                    <div class="mainConcls4 clearfix">
                    	<a  class="btn1" onclick="addUser()" >新增</a>
                        <a  class="btn1" onclick="editUser()">编辑</a>
                        <a  class="btn1" onclick="detailUser()" >查看详情</a> 
                        <a href="#" class="btn1" >批量导入</a>
                    </div>
                    <div class="mainConcls3">
                    	<table id="dg" class="easyui-datagrid" style="width:1077px;height:450px"  data-options="url:'../drivermanage/queryqualified.do',fitColumns:true,singleSelect:true,pagination:true,rownumbers:true">
                        	<thead>
                            	<tr>
                                	<th data-options="field:'name',width:80 ">姓名</th>
                                    <th data-options="field:'sexStr',width:80">性别</th>
                                    <th data-options="field:'phone',width:80">手机号</th>
                                    <th data-options="field:'cardno',width:80">身份证</th>
                                    <th data-options="field:'city',width:80">所在城市</th>
                                    <th data-options="field:'qualifiedDateStr',width:80">培训合格日期</th>
                                    <th data-options="field:'remark',width:80">备注</th>
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
	function addUser(){
            window.location.href = "registerform.jsp";
	}
	
	function editUser(){
		 var row = $("#dg").datagrid("getSelected");
        if (row) {
           window.location.href = "registerform1.jsp?id=" + row.id;
        }else{
       	   layer.alert("未选中任何对象");
        }
	}
	
	function detailUser(){
		 var row = $("#dg").datagrid("getSelected");
       if (row) {
          window.location.href = "registerform2.jsp?id=" + row.id;
       }else{
      	   layer.alert("未选中任何对象");
       }
		
	}

</script>
</html>
