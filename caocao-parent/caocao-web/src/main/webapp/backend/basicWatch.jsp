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
		current2("customer",2,2)
		
		//所在城市
		 var test=new Vcity.CitySelector({input:'cityCode'});	
		 
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
			var name = $("input[name='name']").val(); //获取用户名称
			var phone =$("input[name='phone']").val(); //获取用户手机号
			var cityCode =$("input[name='cityCode']").val();//获取公司名称
			
			$("#dg").datagrid('load',{
				name:name,
				phone:phone,
				cityCode:cityCode
			})
			$('#dg').datagrid('reload');    // reload the current page data			
		})
		

		 //执行tabs
		var data = { title: '普通客户信息查看', url: '../backend/basicWatch.jsp' };	
		tabs(data);
	
	})
</script>
<title>普通客户信息查询</title>
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
                       		<label>姓名</label><input type="text" class="inputcls"  name="name"/>
                            <label>联系电话</label><input type="text" class="inputcls"  name="phone"/>
                            <label>所在城市</label><input type="text" class="inputcls" id="cityCode" name="cityCode"/>
                            <input type="button" class="buttoncls" value="查询" id="search"/>   
                        </div>
                    </div>
                    <!--查询条件end-->
                      <div class="mainConcls4 clearfix">
                        <a  class="btn1"  onclick="detailUser()">查看详情</a>
                    </div>
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
                    
                   		 <table id="dg" class="easyui-datagrid" style="width:1077px;height:450px"  data-options="url:'../comcustumer/comaccount.do',fitColumns:true,singleSelect:true,pagination:true,rownumbers:true">
                        	<thead>
                            	<tr>
                                	<th  data-options="field:'id',width:80" hidden="true">id</th>
                                    <th  data-options="field:'name',width:80">姓名</th>
                                    <th  data-options="field:'sexStr',width:80">性别</th>
                                    <th  data-options="field:'phone',width:80">手机号</th>
                                    <th  data-options="field:'totalCost',width:80">消费总金额</th>
                                  	<th  data-options="field:'cityCode',width:80">所在城市</th>
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
<script>
	function detailUser() {
		
	    var row = $("#dg").datagrid("getSelected");
	    if (row) {
	        window.location.href = "basicDetail.jsp?id=" + row.id;
	    }else{
	    	layer.alert('未选中任何对象')
	    }
	}
</script>
</html>
