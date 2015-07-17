<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page isELIgnored="false" %> 
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
		    width: getWidth(0.95) ,
			height:'450px',
			url:"../usermanage/query.do", 
			fitColumns:true,
			pagination:true,
			rownumbers:true,
			singleSelect:true,
			pageSize:10,
			pageList:[10,20,30,40,50],
			columns:[[ 
				{field:'id',title:'id',width:'100',hidden:'true'}, 
				{field:'username',title:'姓名',width:'100'}, 
				{field:'phone',title:'手机号',width:'100'}, 
				{field:'post',title:'职位',width:'100',align:'center'} ,
				{field:'isactiveStr',title:'是否启用',width:'100',align:'center'},
				{field:'isactivetimeStr',title:'启用时间',width:'100',align:'center'},
				{field:'freezetimeStr',title:'停用时间',width:'100',align:'center'},
				{field:'loginTimeStr',title:'最近登录时间',width:'100',align:'center'},
				{field:'companyName',title:'所属公司',width:'100',align:'center'},
				{field:'remark',title:'备注',width:'100',align:'center'},
				{
					title : '操作',
					field : '_opt',//不对应数据库或json字段，取的名字
					width : 100,
					align:'center',
					formatter:function(value,rec){   //格式化函数添加一个操作列
						var isactive = rec.isactive;
						if(isactive==1){
	                    	var btn = '<a class="editcls" data-href="../usermanage/updatestatus.do?id='+rec.id+'&isactive='+rec.isactive+'"  onclick=freeZ(this);>停用</a>';	  
						}else if(isactive==2){
						    var btn = '<a class="editcls" data-href="../usermanage/updatestatus.do?id='+rec.id+'&isactive='+rec.isactive+'"  onclick=freeZ(this);>启用</a>';	  	
						}
	                    return btn; 
	                }
				}
			]]
			
		});  
		
		$(window).resize(function(){  
				//alert("change....");  
			$("#dg").datagrid("resize",{  
				width: getWidth(0.95)  
			});                
		})
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
		
		
		
		 //执行tabs
		var data = { title: '用户管理维护', url: '../backend/index.jsp' };	
	    var cookie = JSON.stringify(data);
	    $.cookie("con",cookie); 
		 
		var data = { title: '用户管理维护', url: '../backend/index.jsp' };	
		tabs(data);

	
			/* var zNodes =[
				{ id:1, pid:0, name:"用户系统管理"},
				{ id:11, pid:1, name:"用户信息维护",url:"#",target:"_self"},
				{ id:12, pid:1, name:"用户权限维护",url:"#",target:"_self"},
				{ id:2, pid:0, name:"企业管理"},
				{ id:21, pid:2, name:"父节点21 - 展开",url:"#",target:"_self"},
				{ id:22, pid:2, name:"父节点22 - 折叠",url:"#",target:"_self"},				
				{ id:3, pid:0, name:"车型设置"},
				{ id:31, pid:3, name:"车型设置",url:"#",target:"_self"},
				{ id:4, pid:0, name:"司机管理"},
				{ id:5, pid:0, name:"客户管理"},
				{ id:51, pid:5, name:"大客户管理"},
				{ id:52, pid:5, name:"普通客户管理"},
				{ id:511, pid:51, name:"账户管理",url:"#",target:"_self"},
				{ id:512, pid:51, name:"账户查看",url:"#",target:"_self"},
				{ id:521, pid:52, name:"账户管理",url:"#",target:"_self"},
				{ id:522, pid:52, name:"账户查看",url:"#",target:"_self"},
				{ id:6, pid:0, name:"订单管理"},
				{ id:7, pid:0, name:"推广维护"},
				{ id:8 ,pid:0, name:"财务管理"}
				
			];
 */
			
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
              
               <h3>
               	<ul>
               		
               	</ul>
          </h3>
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
                            <input type="button" class="buttoncls" value="查询" id="search" />
                        </div>     	
                    </div>
                    <!--查询条件end-->
                    
                    <!--内容 start-->
                    <div class="mainConcls4 clearfix">
                    	<a href="#" class="btn1"  onclick="newuser()">新增</a> 
                        <a href="#" class="btn1" onclick="edituser()">编辑</a> 
                         
                    </div>
                    
                     <!--[if lte IE 8]>
					     <p>You are using an <strong>outdated</strong> browser. Please <a href="http://windows.microsoft.com/en-us/internet-explorer/download-ie">upgrade your browser</a> to improve your experience.</p>
					 <![endif]-->
                    
                    <div class="mainConcls3"  >
                    	<div class="datagrid-header selectPoint" >
                    		<em class="emcls"></em>
                    	</div>
                    	<!-- 弹出框 -->
	                    <div class="selectArea fn-hide">
	                    	<ul>
		                    	<li><input type="checkbox"  dataId="username"  checked="checked"/>姓名</li>
		                    	<li><input type="checkbox"  dataId="phone"  checked="checked"/>手机号</li>
		                    	<li><input type="checkbox"  dataId="post"  checked="checked"/>职位</li>
		                    	<li><input type="checkbox"  dataId="isactivetimeStr"  checked="checked"/>启用时间</li>
		                    	<li><input type="checkbox"  dataId="isactiveStr"  checked="checked"/>是否启用</li>
		                    	<li><input type="checkbox"  dataId="freezetimeStr"  checked="checked"/>停用时间</li>
		                    	<li><input type="checkbox"  dataId="loginTimeStr"  checked="checked"/>最近登陆时间</li>
		                    	<li><input type="checkbox"  dataId="companyName"  checked="checked"/>所属公司</li>
		                    	<li><input type="checkbox"  dataId="remark"  checked="checked"/>备注</li>
	                    	</ul>
	                    </div>
	                  	<!-- 弹出框 -->
	                  	
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
	                 <input type="text" class="inputcls required "  name="phone" id="phone" onkeyup="chekNum(this,11)" />
	             </div>
	             <div class="toastcls1 clearfix">
	                 <label>职位</label>
	                 <input type="text" class="inputcls required" name="post" id="post"/>
	                 <label>所属公司</label>
	                 <select class="select  " name="companyName" id="companyName">
	                     <option  value="" >--请选择公司--</option>
	                     <option value="杭州优行科技有限公司" >杭州优行科技有限公司</option>
	                 </select>
	              </div>
	              <div class="toastcls1 clearfix" >
	                 <label>备注</label>
	                 <textarea class="textareacls" name="remark" id="remark"></textarea>
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
            }else{
            	layer.alert("未选中任何对象")
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
			if(companyName==""){layer.msg("请选择公司");return false;}
			
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
		
		//停用
		function freeZ(obj){
			$this = $(obj);
			var html = $this.html(); //获取操作按钮的值
			var url = $this.attr("data-href"); //获取操作的url
			
			$.ajax({
				url:url,
				datatype:"json",
				success:function(result){					
					$('#dg').datagrid('reload');
				},
				error:function(){
					layer.msg("网络异常，请稍后重试")
				}
				
			});
			
		}
		
		
    </script>

</html>
