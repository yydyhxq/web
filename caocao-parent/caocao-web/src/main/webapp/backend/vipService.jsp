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
		current2("customer",1,1)
		
		$(".select").select2();
		
		//所在城市
		 var test=new Vcity.CitySelector({input:'cityCode'});
		 var test=new Vcity.CitySelector({input:'cityCode1'});

		//查询
		$("#search").click(function(){

			var name = $("input[name='name']").val(); //获取用户名称
			var phone = $("input[name='phone']").val(); //获取用户手机号
			var cityCode =$("input[name='cityCode']").val();//获取公司名称
			var registerDateBegin =$("input[name='registerDateBegin']").val();
			var registerDateEnd =$("input[name='registerDateEnd']").val();
			var a = compare(registerDateBegin,registerDateEnd);
			if(a==1){layer.msg("结束日期不得小于开始日期");return false;}
			$("#dg").datagrid('load',{
				name:name,
				phone:phone,
				cityCode:cityCode,
				registerDateBegin:registerDateBegin,
				registerDateEnd:registerDateEnd
			})
			$('#dg').datagrid('reload');    // reload the current page data			
		})
				
	})
</script>
<title>大客户信息维护</title>
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
               
               <h3>大客户用户信息维护</h3>
               <div class="mainConcls">
               		<!--查询条件 start-->
               		<div class="mainConcls1 clearfix">
                    	<div class="mainConcls2 clearfix">
                       		<label>姓名</label><input type="text" class="inputcls"  name="name"/>
                            <label>联系电话</label><input type="text" class="inputcls"  name="phone" />
                            <label>所在城市</label><input type="text"  placeholder="请输入城市名" id="cityCode"  class="inputcls" name="cityCode"/>
                        </div>
                        <div class="mainConcls2 mainConcls2_1 clearfix">
                       		<label>注册日期</label>
                            <input type="text" class="Wdate inputcls rightcls8"  onclick="WdatePicker()" name="registerDateBegin">
                            <label class="mainConcls2_2">至</label>
                            <input type="text" class="Wdate inputcls"  onclick="WdatePicker()" name="registerDateEnd">
                       		<input type="button" class="buttoncls" value="查询" id="search" />   
                        </div> 	
                    </div>
                    <!--查询条件end-->                   
                    <!--内容 start-->
                    <div class="mainConcls4 clearfix">
                    	<a href="#" class="btn1" onclick="newuser()">新增</a> 
                        <a href="#" class="btn1" onclick="edituser()">编辑</a> 
                        <a href="#" class="btn1" >批量导入</a>
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
                    
                    	<table id="dg" class="easyui-datagrid" style="width:1077px;height:450px"  data-options="url:'../bigcustumermanage/querybase.do',fitColumns:true,singleSelect:true,pagination:true,rownumbers:true">
                                <thead>
                                    <tr>
                                    	<th data-options="field:'id',width:80" hidden="true">id</th>
                                        <th data-options="field:'name',width:90 ">姓名</th>
                                        <th data-options="field:'sexStr',width:90">性别</th>
                                        <th data-options="field:'phone',width:90">手机号</th>
                                        <th data-options="field:'costTimes',width:90">消费次数</th>
                                        <th data-options="field:'costMoney',width:90">消费金额</th>
                                        <th data-options="field:'carType',width:90">车型需求</th>
                                        <th data-options="field:'rank',width:90">等级</th>
                                      	<th data-options="field:'inviteCode',width:90">邀请码</th>
                                        <th data-options="field:'companyCode',width:90">公司名称</th>
                                        <th data-options="field:'registerTimeStr',width:90">注册时间</th>
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
     
    
    
  
     
 <div id="dlg" class="easyui-dialog" style="width: 700px; height: 465px; padding: 10px 20px;"
       closed="true" buttons="#dlg-buttons"> 
      
       <div class="ftitle"> 
           信息编辑 
       </div> 
      <form id="fm" method="post"> 
             <div class="toastcls">
                <div class="clearfix">
                    <label>姓名 </label>
                    <input type="text" class="inputcls required" id="name" name="name" />
                    <label>性别</label>
                    <select class="select" name="sex" id="sex">
                     	<option value="">--请选择性别--</option>
                        <option value="1">男</option>
                        <option value="2">女</option>
                    </select>
                </div>
                <div class="toastcls1 clearfix">
                     <label>联系电话</label>
                     <input type="text" class="inputcls required" id="phone" name="phone" onkeyup="chekNum(this,11)"/>
                     <label>公司名称</label>
                     <select class="select" id="companyCode" name="companyCode">
                        <option value="">--请选择公司--</option>   
                        <option value="10000">杭州优行科技有限公司</option>                   
                     </select>
                </div>
                <div class="toastcls1 clearfix">
                    <label>所在城市</label>
                    <input type="text"  placeholder="请输入城市名" id="cityCode1"  class="inputcls required" />
                     <label>注册时间</label>
                    <input type="text" class="Wdate inputcls rightcls8 required"  onclick="WdatePicker()" name="registerTime" id="registerTime">
                </div>
                <div class="toastcls1 clearfix">
                    <label>备注</label>
                    <textarea class="textareacls" name="remark" id="remark" ></textarea>
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
        	$("#registerTime").attr("name","registerTime");
        	$("#sex").attr('name','sex');
        	$("#save").show().siblings("#save1").hide();
        	$("#registerTime").attr("name","registerTime");
            $("#dlg").dialog("open").dialog('setTitle', 'New User'); ;
            $("#fm").form("clear");
            url = "../bigcustumermanage/add.do?";
            
        }
        function edituser() {
        	$("#registerTime").attr("name","registerTimeStr");
        	
        	$("#save1").show().siblings("#save").hide();
            var row = $("#dg").datagrid("getSelected");
            if (row) {
                $("#dlg").dialog("open").dialog('setTitle', 'Edit User');
                $("#fm").form("load", row);
                url = "../bigcustumermanage/update.do?id=" + row.id;
            }else{
            	layer.msg("未选中任何对象")
            }
        }
		
		
		function saveuser(){  
			
			var name = $("#name").val(); //获取公司名称
		    /* var companyAddress = $("#companyAddress").val(); //获取公司地址  */
			var sex = $("#sex").val(); //获取所在城市
			var companyCode =$("#companyCode").val();//获取企业代码
			var phone = $("#phone").val(); //获取联系电话
			var cityCode = $("#cityCode1").val(); //获取所在城市
		    var registerTime = $("registerTime").val(); //获取签约日期 
			var remark = $("#remark").val(); //获取备注名称
			if(name==""){layer.msg("请输入公司名称");return false;}
			if(sex==""){layer.msg("请选择性别");return false;} 
			/* if(companyAddress==""){layer.msg("请输入公司地址");return false;}  */
			if(cityCode.indexOf("所在城市")!=-1){layer.msg("请选择所在城市");return false;}
			if(companyCode==""){layer.msg("请输入企业代码");return false;}
			if(phone==""){layer.msg("请输联系电话");return false;}
			if(registerTime==""){layer.msg("请选择注册时间");return false;}
			
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
			$("#registerTime").attr("name","registerTime");
			$("#sex").attr('name','sex');
			var name = $("#name").val(); //获取公司名称
		    /* var companyAddress = $("#companyAddress").val(); //获取公司地址  */
			var sex = $("#sex").val(); //获取所在城市	
			var companyCode =$("#companyCode").val();//获取企业代码
			var phone = $("#phone").val(); //获取联系电话
			var cityCode = $("#cityCode1").val(); //获取所在城市
		    var registerTime = $("#createtime").val(); //获取签约日期 
			var remark = $("#remark").val(); //获取备注名称
			if(name==""){layer.msg("请输入公司名称");return false;}
			if(sex==""){layer.msg("请选择性别");return false;} 
			/* if(companyAddress==""){layer.msg("请输入公司地址");return false;}  */
			if(cityCode.indexOf("所在城市")!=-1){layer.msg("请选择所在城市");return false;}
			if(companyCode.indexOf("选择公司")!=-1){layer.msg("请输入企业代码");return false;}
			if(phone==""){layer.msg("请输联系电话");return false;}
			if(registerTime==""){layer.msg("请输入注册日期");return false;}
			
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
