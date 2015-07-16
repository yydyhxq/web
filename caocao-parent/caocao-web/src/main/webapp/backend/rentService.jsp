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
		current1("company",2);
		
		//所在城市
		  var test=new Vcity.CitySelector({input:'cityCode'});
		  var test=new Vcity.CitySelector({input:'cityCode1'});

		 //查询
		$("#search").click(function(){
			var name = $("input[name='name']").val(); //获取用户名称
			var contactPhone =$("input[name='contactPhone']").val(); //获取用户手机号
			var cityCode =$("input[name='cityCode']").val();//获取公司名称
			var signDateBegin =$("input[name='signDateBegin']").val();//获取签约开始日期
			var signDateEnd =$("input[name='signDateEnd']").val();//获取签约结束日期
			var a = compare(signDateBegin,signDateEnd);
			if(a==1){layer.msg("结束日期不得小于开始日期");return false;}
			$("#dg").datagrid('load',{
				name:name,
				contactPhone:contactPhone,
				cityCode:cityCode,
				signDateBegin:signDateBegin,
				signDateEnd:signDateEnd
			})
			$('#dg').datagrid('reload');    // reload the current page data			
		})
			
	   //执行tabs
		var data ={title:'租赁公司管理', url:'../backend/rentService.jsp'};	
		tabs(data);
	  
	})
</script>
<!--[if IE]><script type="text/javascript" src="js/html5.js"></script><![endif]-->

<title>租赁公司维护</title>
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
                       		<label>公司名称</label><input type="text" class="inputcls" name="name" />
                            <label>联系电话</label><input type="text" class="inputcls" name="contactPhone" />
                            <label>所在城市</label><input type="text"  placeholder="请输入城市名" id="cityCode" name="cityCode" class="inputcls" />
                        </div>                       
                        <div class="mainConcls2 mainConcls2_1 clearfix">
                       		<label >签约日期</label>
                            <input type="text" class="Wdate inputcls rightcls8"  onclick="WdatePicker()"  name="signDateBegin" >
                            <label class="mainConcls2_2">至</label>
                            <input type="text" class="Wdate inputcls"  onclick="WdatePicker()" name="signDateEnd">
                       		<input type="button" class="buttoncls" value="查询" id="search" />   
                        </div> 	
                    </div>
                    <!--查询条件end-->
                    <!--内容 start-->
                    <div class="mainConcls4 clearfix">
                    	<a href="#" class="btn1" onclick="newuser()">新增</a> 
                        <a href="#" class="btn1" onclick="edituser()" >编辑</a> 
                    </div>
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
                    
                    	<table id="dg" class="easyui-datagrid" style="width:1077px;height:450px"  data-options="url:'../leasemanage/query.do',singleSelect:true,fitColumns:true,singleSelect:true,pagination:true,rownumbers:true">
                        	<thead>
                            	<tr>
                                	<th data-options="field:'id',width:80 " hidden="true">id</th>
                                	<th data-options="field:'name',width:80 ">公司名称</th>
                                    <th data-options="field:'cityCode',width:80">所在城市</th>
                                    <th data-options="field:'companyCode',width:80">企业代码</th>
                                    <th data-options="field:'masterName',width:80">法人</th>
                                    <th data-options="field:'masterNumber',width:80">法人身份证号</th>
                                    <th data-options="field:'contactPhone',width:80">联系电话</th>
                                    <th data-options="field:'companyAddress',width:80">公司地址</th>
                                    <th data-options="field:'signDateStr',width:80">签约日期</th>
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
    

     
 <div id="dlg" class="easyui-dialog" style="width: 700px; height: 465px; padding: 10px 20px;"
       closed="true" buttons="#dlg-buttons"> 
      
       <div class="ftitle"> 
           信息编辑 
       </div> 
      <form id="fm" method="post"> 
            <div class="toastcls">
                <div class=" toastcls1 clearfix">
                    <label>公司名称</label>
                    <input type="text" class="inputcls required " id="name" name="name" required="true"/>
                    <label>公司地址</label>
                    <input type="text" class="inputcls required"  id="companyAddress" name="companyAddress"/>
                </div>
                <div class=" toastcls1 clearfix">
                    <label>所在城市</label>
                    <input type="text"  placeholder="请输入城市名"   class="inputcls required" name="cityCode"  id="cityCode1" />
                    <label>企业代码</label>
                    <input type="text" class="inputcls required"  name="companyCode" id="companyCode" />
                </div>
                 <div class="toastcls1 clearfix">
                    <label>法人</label>
                    <input type="text" class="inputcls required"  name="masterName" id="masterName"/>
                    <label>法人身份证号</label>
                    <input type="text" class="inputcls required"  name="masterNumber"  id="masterNumber" onkeyup="chekNum(this,18)" />
                </div>
                <div class="toastcls1 clearfix">
                    <label>联系电话</label>
                    <input type="text" class="inputcls required" name="contactPhone" id="contactPhone" onkeyup="chekNum(this,11)" />
                    <label>签约日期</label>
                    <input type="text" class="Wdate inputcls rightcls8 required"  onclick="WdatePicker()"  name="signDate" id="signDate">
                </div>
                 <div class="toastcls1 clearfix">
                    <label>备注</label>
                    <textarea class="textareacls"  name="remark"></textarea>
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
        	$("#signDate").attr('name','signDate')
        	$("#save").show().siblings("#save1").hide();
            $("#dlg").dialog("open").dialog('setTitle', 'New User'); ;
            $("#fm").form("clear");
            url = "../leasemanage/add.do?";
            
        }
        function edituser() {
        	$("#signDate").attr('name','signDateStr')
        	$("#save1").show().siblings("#save").hide();
            var row = $("#dg").datagrid("getSelected");
          
            if (row) {
                $("#dlg").dialog("open").dialog('setTitle', 'Edit User');
                $("#fm").form("load", row);
                url = "../leasemanage/update.do?id=" + row.id;
            }
        }
		
		function lookUser(){
			if (row){  
				 url = "UserManage.aspx?id=" + row.id;
			}  	
			
		}
		
		function saveuser(){  
			var name = $("#name").val(); //获取公司名称
			var companyAddress = $("#companyAddress").val(); //获取公司地址
			var cityCode = $("#cityCode").val(); //获取所在城市
			var companyCode =$("#companyCode").val();//获取企业代码
			var masterName = $("#masterName").val(); //获取法人
			var masterNumber = $("#masterNumber").val(); //获取法人身份证
			var contactPhone = $("#contactPhone").val(); //获取备联系电话
			var signDate = $("#signDate").val(); //获取签约日期
			var remark = $("#remark").val(); //获取备注名称
			if(name==""){layer.msg("请输入公司名称");return false;}
			if(companyAddress==""){layer.msg("请输入公司地址");return false;}
			if(cityCode.indexOf("所在城市")!=-1){layer.msg("请选择所在城市");return false;}
			if(companyCode==""){layer.msg("请输入企业代码");return false;}
			if(masterName==""){layer.msg("法人不能为空");return false;}
			if(masterNumber==""){layer.msg("请输入法人身份证");return false;}
			if(contactPhone==""){layer.msg("请输联系电话");return false;}
			if(signDate=""){layer.msg("请输入签约日期");return false;}
			
			var form = $("#fm").serialize();
		    $('#fm').form('submit',{  
		        url: url,  
		        data: form,
		        onSubmit: function(){  
		            return $(this).form('validate');  
		        },  
		        success: function(result){  
		        	if(result=="0"){layer.alert("必填写项不能为空！")}
			        if(result=="1"){layer.alert("该公司已存在")}
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
			$("#signDate").attr("name","signDate");
			var name = $("#name").val(); //获取公司名称
			var companyAddress = $("#companyAddress").val(); //获取公司地址
			var cityCode = $("#cityCode").val(); //获取所在城市
			var companyCode =$("#companyCode").val();//获取企业代码
			var masterName = $("#masterName").val(); //获取法人
			var masterNumber = $("#masterNumber").val(); //获取法人身份证
			var contactPhone = $("#contactPhone").val(); //获取备联系电话
			var signDate = $("#signDate").val(); //获取签约日期
			var remark = $("#remark").val(); //获取备注名称
			if(name==""){layer.msg("请输入公司名称");return false;}
			if(companyAddress==""){layer.msg("请输入公司地址");return false;}
			if(cityCode.indexOf("所在城市")!=-1){layer.msg("请选择所在城市");return false;}
			if(companyCode==""){layer.msg("请输入企业代码");return false;}
			if(masterName==""){layer.msg("法人不能为空");return false;}
			if(masterNumber==""){layer.msg("请输入法人身份证");return false;}
			if(contactPhone==""){layer.msg("请输联系电话");return false;}
			if(signDate==""){layer.msg("请输入签约日期");return false;}
			
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
