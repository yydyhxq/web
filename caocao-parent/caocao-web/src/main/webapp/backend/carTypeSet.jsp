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
		current1("car",1)
		
		//下拉框
		$(".select").select2();	
		
		
		//查询
		$("#search").click(function(){
			var brand = $("input[name='brand']").val(); //获取品牌名称
			var mode = $("input[name='mode']").val(); //获取车型名称
			var type = $("select[name='type']").val();//获取服务类型
		/* 	$("#dg").datagrid({url:'../cartype/query.do'}); */
			$("#dg").datagrid('load',{
		
				brand:brand,
				mode:mode,
				type:type
			})
			$('#dg').datagrid('reload');    // reload the current page data			
		})
		
		
	})
</script>
<title>车型设置</title>
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
              
               <h3>车型设置</h3>
               <div class="mainConcls">
               		<!--查询条件 start-->
               		<div class="mainConcls1 ">
                    	<div class="mainConcls2 clearfix">
                       		<label>品牌名称</label><input type="text" class="inputcls "  name="brand"  />
                            <label>车型名称</label><input type="text" class="inputcls "  name="mode" />
                            <label>服务类型</label>
                            <select class="select" name="type"  >
                            	<option value="">--请选择服务类型--</option>
                            	<option value="1">经济型</option>
                            	<option value="2">舒适型</option>
                            	<option value="3">商务型</option>
                                <option value="4">豪华型</option>
                            </select>
                            <input type="button" class="buttoncls" value="查询"  id="search"/>
                        </div>     	
                    </div>
                    <!--查询条件end-->
                   	
                    
                    <!--内容 start-->
                    
                    <div class="mainConcls4 clearfix">
                    	<a href="#" class="btn1" onclick="newuser()">新增</a>
                        <a href="#" class="btn1" onclick="edituser()">编辑</a>  
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
                    
                        <table id="dg" class="easyui-datagrid" style="width:1077px;height:450px"  data-options="url:'../cartype/query.do',fitColumns:true,singleSelect:true,pagination:true,rownumbers:true">
                        	<thead>
                            	<tr>
                            		<th data-options="field:'id',width:80 " hidden="true">id</th>
                                	<th data-options="field:'brand',width:80">品牌名称</th>
                                    <th data-options="field:'mode',width:80">车型名称</th>
                                    <th data-options="field:'typeStr',width:80">服务类型</th>
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
  
    
<div id="dlg" class="easyui-dialog" style="width: 700px; height: 365px; padding: 10px 20px;"
       closed="true" buttons="#dlg-buttons"> 
      
       <div class="ftitle"> 
           信息编辑 
       </div> 
      <form id="fm" method="post"> 
             <div class="toastcls">
                <div class="clearfix">
                    <label>品牌名称</label><input type="text" class="inputcls required"  name="brand" id="brand"  />
                    <label>车型名称</label><input type="text" class="inputcls required"  name="mode"  id="brand" />
                </div>
                <div class="toastcls1 clearfix">
                   <label>服务类型</label>
                   <select class="select" name="type" id="type" >
                        <option value="">--请选择服务类型--</option>
                        <option value="1">经济型</option>
                        <option value="2">舒适型</option>
                        <option value="3">商务型</option>
                        <option value="4">豪华型</option>
                   </select>
                 
                </div>
               
           </div>
       </form> 
   </div>
   <div id="dlg-buttons"> 
   		 <a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveuser()" iconcls="icon-save" id="save">保存</a> 
        <a href="javascript:void(0)" class="easyui-linkbutton fn-hide" onclick="saveuser1()" iconcls="icon-save" id="save1">保存</a> 
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#dlg').dialog('close')"
            iconcls="icon-cancel">取消</a> 
   	</div> 

</body>

   <script type="text/javascript">
        var url;
        var type;
        function newuser() {
        	$("#save").show().siblings("#save1").hide();
        	$("#type").attr("name","type");
            $("#dlg").dialog("open").dialog('setTitle', 'New User'); ;
            $("#fm").form("clear");
            url = "../cartype/add.do?";
            
        }
        function edituser() {
        	$("#save1").show().siblings("#save").hide();
        	$("#type").attr("name","typeStr");
            var row = $("#dg").datagrid("getSelected");
            if (row) {
                $("#dlg").dialog("open").dialog('setTitle', 'Edit User');
                $("#fm").form("load", row);
                url = "../cartype/update.do?id=" + row.id;
            }
        }
		
		function lookUser(){
			if (row){  
				 url = "UserManage.aspx?id=" + row.id;
			}  	
			
		}
		
		function saveuser(){  
			var brand = $("#brand").val(); //获取公司名称
		    var mode = $("#mode").val(); //获取签约日期 
			var type = $("#type").val(); //获取备注名称
			if(brand==""){layer.msg("请输入品牌名称");return false;}
			if(mode==""){layer.msg("请输入车型名称");return false;} 
			if(type==""){layer.msg("请输入服务类型");return false;}
			
			var form = $("#fm").serialize();
		    $('#fm').form('submit',{  
		        url: url,  
		        data: form,
		        onSubmit: function(){  
		            return $(this).form('validate');  
		        },  
		        success: function(result){  
		        	if(result=="0"){layer.alert("必填写项不能为空！")}
			        if(result=="1"){layer.alert("该车型已存在")}
			        if(result=="2"){layer.alert("数据新增失败")}
		            if(result=="3"){  
		        		layer.alert("保存成功")
		                $('#dlg').dialog('close'); // close the dialog  
		                $('#dg').datagrid('reload'); // reload the user data  
		            }  
		        }  
		    });  
		}  
		
		
		function saveuser1(){  
			$("#type").attr("name","type");
			var brand = $("#brand").val(); //获取公司名称
		    var mode = $("#mode").val(); //获取签约日期 
			var type = $("#type").val(); //获取备注名称
			if(brand==""){layer.msg("请输入品牌名称");return false;}
			if(mode==""){layer.msg("请输入车型名称");return false;} 
			if(type==""){layer.msg("请输入服务类型");return false;}
			var form = $("#fm").serialize();
		    $('#fm').form('submit',{  
		        url: url,  
		        data: form,
		        onSubmit: function(){  
		            return $(this).form('validate');  
		        },  
		        success: function(result){  
		        	if(result=="0"){layer.alert("必填写项不能为空！")}
		        	if(result=="1"){layer.alert("后台数据已发生变化,请重新提取数据")}
		        	if(result=="2"){layer.alert("数据修改失败")}
		        	if(result=="4"){layer.alert("系统异常请联系管理员")}
		        	if(result=="3"){  
		        		layer.alert("保存成功")
		                $('#dlg').dialog('close'); // close the dialog  
		                $('#dg').datagrid('reload'); // reload the user data  
		            }  
		        }  
		    });  
		}  
		

	
    </script>
</html>
