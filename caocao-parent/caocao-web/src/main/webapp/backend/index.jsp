<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/backend/common/meta.jsp"%>
<%@ include file="/backend/common/script.jsp"%>
<script>
	$(function(){
		//当前选项
		current1("admin",1);
		
		//下拉框
		$(".select").select2();	
					
		$('#dg').datagrid({ 
		    width:'1077px',
			height:'450px',
			url:"../usermanage/query.do", 
			fitColumns:true,
			pagination:true,
			rownumbers:true,
			singleSelect:true,
			pageSize:10,
			
			columns:[[ 
				{field:'id',title:'id',width:'100',hidden:'true'}, 
				{field:'username',title:'姓名',width:'100'}, 
				{field:'phone',title:'手机号',width:'100'}, 
				{field:'post',title:'职位',width:'100',align:'center'} ,
				{field:'isactiveStr',title:'是否启用',width:'100',align:'center'},
				{field:'isactivetime',title:'启用时间',width:'100',align:'center'},
				{field:'freezetime',title:'冻结时间',width:'100',align:'center'},
				{field:'loginTimeStr',title:'最近登录时间',width:'100',align:'center'},
				{field:'companyName',title:'所属公司',width:'100',align:'center'},
				{field:'remark',title:'备注',width:'100',align:'center'}
			]]
			
		});  
	
		//查询
		$("#search").click(function(){
			var username = $("input[name='username']").val(); //获取用户名称
			var phone = $("input[name='phone']").val(); //获取用户手机号
			var companyName =$("input[name='companyName']").val();//获取公司名称
			
			$("#dg").datagrid('load',{
				username:username,
				phone:phone,
				companyName:companyName
			})
			$('#dg').datagrid('reload');    // reload the current page data			
		})
		
		
	});
</script>
<title>后台首页</title>
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
        <!--菜单end--
        
         <!--Body content start-->
        <div class="rightArea">
        	<div class="mainCon">
              
               <h3>用户信息维护</h3>
               <div class="mainConcls">
               		<!--查询条件 start-->
               		<div class="mainConcls1 ">
                    	<div class="mainConcls2 clearfix">
                       		<label>姓名</label><input type="text" class="inputcls"  name="username" />
                            <label>手机号</label><input type="text" class="inputcls" name="phone" />
                            <label>所属公司</label>
                             <select class="select " name="companyName" >
                                <option value="" >--请选择公司--</option>
                                <option value="杭州优行科技有限公司" >杭州优行科技有限公司</option>
                            </select>
                            <input type="button" class="buttoncls" value="查询" id="search"/>
                        </div>     	
                    </div>
                    <!--查询条件end-->
                    
                    <!--内容 start-->
                    <div class="mainConcls4 clearfix">
                    	<a href="#" class="btn1"  onclick="newuser()">新增</a> 
                        <a href="#" class="btn1" onclick="edituser()">编辑</a> 
                    </div>
                    
                    <div class="mainConcls3"  >
                    	<table id="dg"></table>
                    </div>	
                    
                    <!--内容 end--> 
               </div> 
               
            </div>
        </div>
         <!--Body content end-->
      </div>
    </div>
    


	<div id="dlg" class="easyui-dialog" style="width: 700px; height: 365px; padding: 10px 20px;" closed="true" buttons="#dlg-buttons"> 
	   <div class="ftitle">信息编辑 </div> 
	   <form id="fm" method="post"> 
	   			<div class=" toastcls1 clearfix">
	                 <label>姓名</label>
	                 <input type="text" class="inputcls required"  required="true" name="username"  id="username"/>
	                 <label>手机号</label>
	                 <input type="text" class="inputcls required "  name="phone" id="phone" />
	             </div>
	             <div class="toastcls1 clearfix">
	                 <label>职位</label>
	                 <input type="text" class="inputcls required" name="post" id="post"/>
	                 <label>所属公司</label>
	                 <select class="select  " name="companyName" id="companyName">
	                     <option  value="--请选择公司--" >--请选择公司--</option>
	                     <option value="杭州优行科技有限公司" >杭州优行科技有限公司</option>
	                 </select>
	              </div>
	              <div class="toastcls1 clearfix" >
	                 <label>备注</label>
	                 <textarea class="textareacls" name="name" id="remark"></textarea>
	             </div>
	             <input type="text" name="isactive" style="display:none" >
	    </form> 
	</div>
	<div id="dlg-buttons"> 
	     <a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveuser()" iconcls="icon-save">保存</a> 
		 <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#dlg').dialog('close')" iconcls="icon-cancel">取消</a> 
	</div> 
    
 
</body>

    <script>
        var url;
        var type;
        function newuser() {
            $("#dlg").dialog("open").dialog('setTitle', 'New User'); ;
            $("#fm").form("clear");
            url = "../usermanage/add.do";
        }
        function edituser() {
            var row = $("#dg").datagrid("getSelected");
          
            if (row) {
                $("#dlg").dialog("open").dialog('setTitle', 'Edit User');
                $("#fm").form("load", row);
                url = "../usermanage/update.do?id=" + row.id;
            }
        }
		
	
		function saveuser(){  
			var username = $("#username").val(); //获取用户名称
			var phone = $("#phone").val(); //获取用户手机号
			var post = $("#post").val(); //获取用户职位
			var companyName =$("#companyName").val();//获取公司名称
			var remark = $("#remark").val(); //获取备注名称
			if(username==""){layer.msg("请输入姓名");return false;}
			if(phone==""||phone.length!=11){layer.msg("请输入正确的手机号");return false;}
			if(post==""){layer.msg("职位不能为空");return false;}
			if(companyName.indexOf("请选择公司")!=-1){layer.msg("请选择公司");return false;}
			
			var form = $("#fm").serialize();
		    $('#fm').form('submit',{  
		        url: url,  
		        data: form,
		        onSubmit: function(){  
		            return $(this).form('validate');  
		        },  
		        success: function(result){  
		        	if(result=="1"||result=="2"||result=="4"){
		        		layer.alert("网络异常,请重试")
		        	} else {  
		        		layer.alert("保存成功")
		                $('#dlg').dialog('close'); // close the dialog  
		                $('#dg').datagrid('reload'); // reload the user data  
		            }  
		        }  
		    });  
		}  

    </script>

</html>
