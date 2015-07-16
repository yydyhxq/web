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
		current1("admin",2);
		
		//下拉框
		$(".select").select2();	
		
		//双击显示权限管理
		$("#dg").datagrid({
			onDblClickRow:function(rowIndex,rowData){
			var id = rowData.id;
				var data = { id:id};	
			    var cookie = JSON.stringify(data);
			    $.cookie("id",cookie);
				$(".priviLcls").show();
				var cookieStr = $.cookie("id"); 
				var cookieJson = JSON.parse(cookieStr); 
				console.log(cookieJson.id)
			}
			
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
		
		//tab
		var data = { title: '用户权限设置', url: '../backend/privilege.jsp' };	
		tabs(data);
		
		
		var setting = {
				check: {
					enable: true
				},
				data: {
					simpleData: {
						enable: true
					}
				},
				callback: {
					onClick: function(event, treeId, treeNode){
						$(".priviLcls2").show()
						
					}
				}
			};

			var zNodes =[
				{ id:1, pId:0, name:"系统设置", open:true},
				{ id:11, pId:1, name:"基本参数设置", open:true},
				{ id:2, pId:0, name:"用户权限管理", checked:true, open:true},
				{ id:21, pId:2, name:"用户信息维护"},
				{ id:22, pId:2, name:"用户权限维护", open:true},
				{ id:3, pId:0, name:"司机管理",  open:true},
				{ id:31, pId:3, name:"司机注册审批"},
				{ id:32, pId:3, name:"司机资料变更审批", open:true},
				{ id:33, pId:3, name:"司机信息查看", open:true},
				{ id:34, pId:3, name:"司机权限管控", open:true},
				{ id:4, pId:0, name:"乘客管理",  open:true},
				{ id:41, pId:4, name:"大客户乘客管理", open:true},
				{ id:42, pId:4, name:"普通乘客管理", open:true},
				{ id:411, pId:41, name:"基本信息维护"},
				{ id:412, pId:41, name:"账户明细"},
				{ id:421, pId:42, name:"基本信息维护"},
				{ id:422, pId:42, name:"账户明细"},
				{ id:5, pId:0, name:"订单管理",  open:true},
				{ id:51, pId:5, name:"预约订单"},
				{ id:52, pId:5, name:"实时订单", open:true},
				{ id:53, pId:5, name:"历史订单", open:true},
				{ id:6, pId:0, name:"推广管理",  open:true},
				{ id:61, pId:6, name:"推广维护"},
				{ id:62, pId:6, name:"推广查看", open:true},
				{ id:7, pId:0, name:"财务", open:true},
				{ id:61, pId:7, name:"大客户乘客应收账款"},
				{ id:62, pId:7, name:"营业总收入", open:true},
				{ id:67, pId:7, name:"平台返利"},
				{ id:63, pId:7, name:"加盟商返利", open:true},
				{ id:64, pId:7, name:"司机收入", open:true},
				{ id:65, pId:7, name:"推广费用", open:true},
				{ id:641, pId:64, name:"基本收入", open:true},
				{ id:642, pId:64, name:"返利收入", open:true}
			];
			
		 $.fn.zTree.init($("#tree"), setting, zNodes);
		
	});
	
</script>
<title>用户权限维护</title>
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
	            <h3>
	            	<ul></ul>
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
                 
                    <div class="mainConcls3"  >
                    	<!-- 权限信息弹出层 start-->
				        	<div class="priviLcls ">
				        		<h4>后台管理
				        			<input type="button" class="buttoncls" value="保存" id="save">
				        		</h4>
				        		<!-- 操作和数据权限  start-->
				        		<div class="priviLcls2 "  >
				        			<div class="priviLcls2_1">
				        				<h4>操作权限</h4>
				        				<ul class="thirdTree">
				        					<li>
					        					<span class="iconTree icon-uncheck"></span>
					        					<input type="checkbox" name="pdi" class="fn-hide"  id="1"  company="111"  value="1111111111"/>
					        					<span>新增</span>
				        					</li>
				        					<li>
					        					<span class="iconTree icon-uncheck"></span>
					        					<input type="checkbox" name="" class="fn-hide" />
					        					<span>编辑</span>
				        					</li>
				        					<li>
					        					<span class="iconTree icon-uncheck"></span>
					        					<input type="checkbox" name="" class="fn-hide" />
					        					<span>批量导入</span>
				        					</li>
				        				</ul>
				        			</div>
				        			<div class="priviLcls2_1">
				        				<h4>数据权限</h4>
				        				<ul class="thirdTree">
				        					<li>
				        						<input type="radio" class="radiocls" name="privilege" value="0"/>
				        						<span >全部</span>
				        					</li>
				        					<li>
				        						<input type="radio" class="radiocls" name="privilege" value="1" />
				        						<span >本公司</span>
				        					</li>
				        				</ul>
				        			</div>
				        		</div>
				        		<!-- 操作和数据权限 end -->
				        		<div class="priviLcls1">
				        		
				        	
									 <ul id="tree" class="ztree"></ul>  
	
					        		<!-- <ul  class="z-tree">
					        			<li><span class="iconTree icon-switchP"></span>
					        				<span class="iconTree icon-uncheck parentTree"></span>
					        				<span>系统设置</span>
					        				<ul class="secondTree">
					        					<li>
						        					<span class="iconTree icon-uncheck "></span>
						        					<input type="checkbox" name="" class="fn-hide" />
						        					<span class="priviLcls3">基本参数设置</span>
					        					</li>
					        				</ul>
					        			</li>
					        			<li><span class="iconTree icon-switchP"></span>
					        				<span class="iconTree icon-uncheck parentTree"></span>
					        				<span>用户权限管理</span>
					        				<ul class="secondTree">
					        					<li>
					        						<span class="iconTree icon-uncheck"></span>
					        						<input type="checkbox" name="" class="fn-hide" />
					        						<span class="priviLcls3">用户信息维护</span>
					        					</li>
					        					<li>
						        					<span class="iconTree icon-uncheck"></span>
						        					<input type="checkbox" name="" class="fn-hide" />
						        					<span class="priviLcls3">用户权限维护</span>
					        					</li>
					        				</ul>
					        			</li>
					        		<li><span class="iconTree icon-switchP"></span>
					        			<span class="iconTree icon-uncheck parentTree"></span>
					        			<span>司机管理</span>
					        				<ul class="secondTree">
					        					<li>
						        					<span class="iconTree icon-uncheck"></span>
						        					<input type="checkbox" name="" class="fn-hide" />
						        					<span class="priviLcls3">司机注册审批</span>
					        					</li>
					        					<li>
						        					<span class="iconTree icon-uncheck"></span>
						        					<input type="checkbox" name="" class="fn-hide" />
						        					<span class="priviLcls3">司机资料变更审批</span>
					        					</li>
					        					<li>
						        					<span class="iconTree icon-uncheck"></span>
						        					<input type="checkbox" name="" class="fn-hide" />
						        					<span class="priviLcls3">司机信息查看</span>
					        					</li>
					        					<li>
						        					<span class="iconTree icon-uncheck"></span>
						        					<input type="checkbox" name="" class="fn-hide" />
						        					<span class="priviLcls3">司机权限管控</span>
					        					</li>
					        				</ul>
					        			</li>
					        			<li><span class="iconTree icon-switchP"></span>
					        				<span class="iconTree icon-uncheck parentTree"></span>
					        				<span>乘客管理</span>
					        				<ul class="secondTree">
					        					<li><span class="iconTree icon-switchP"></span>
					        						<span class="iconTree icon-uncheck parentTree"></span>
					        						<span>大客户乘务管理</span>
					        						<ul class="secondTree">
					        							<li>
								        					<span class="iconTree icon-uncheck"></span>
								        					<input type="checkbox" name="" class="fn-hide" />
								        					<span class="priviLcls3">基本信息维护</span>
							        					</li>
							        					<li>
								        					<span class="iconTree icon-uncheck"></span>
								        					<input type="checkbox" name="" class="fn-hide" />
								        					<span class="priviLcls3">账户明细</span>
							        					</li>
					        						</ul>
					        					</li>
					        					<li><span class="iconTree icon-switchP"></span>
					        						<span class="iconTree icon-uncheck parentTree"></span>
					        						<span>普通乘务管理</span>
					        						<ul class="secondTree">
							        					<li>
								        					<span class="iconTree icon-uncheck"></span>
								        					<input type="checkbox" name="" class="fn-hide" />
								        					<span class="priviLcls3">基本信息维护</span>
							        					</li>
							        					<li>
								        					<span class="iconTree icon-uncheck"></span>
								        					<input type="checkbox" name="" class="fn-hide" />
								        					<span class="priviLcls3">账户明细</span>
							        					</li>
					        						</ul>      						
					        					</li>
					        				</ul>
					        			</li>
					        			<li><span class="iconTree icon-switchP"></span>
					        				<span class="iconTree icon-uncheck parentTree"></span>
					        				<span>订单管理</span>
					        				<ul class="secondTree">
						       					<li>
						        					<span class="iconTree icon-uncheck"></span>
						        					<input type="checkbox" name="" class="fn-hide" />
						        					<span class="priviLcls3">预约订单</span>
						      					</li>
						      					<li>
						        					<span class="iconTree icon-uncheck"></span>
						        					<input type="checkbox" name="" class="fn-hide" />
						        					<span class="priviLcls3">实时订单</span>
						      					</li>
						      					<li>
						        					<span class="iconTree icon-uncheck"></span>
						        					<input type="checkbox" name="" class="fn-hide" />
						        					<span class="priviLcls3">历史订单</span>
						      					</li>
					        				</ul>
					        			</li>
					        			<li><span class="iconTree icon-switchP"></span>
					        				<span class="iconTree icon-uncheck parentTree"></span>
					        				<span>推广管理</span>
					        				<ul class="secondTree">
					        					<li>
						        					<span class="iconTree icon-uncheck"></span>
						        					<input type="checkbox" name="" class="fn-hide" />
						        					<span class="priviLcls3">推广维护</span>
						      					</li>
						      					<li>
						        					<span class="iconTree icon-uncheck"></span>
						        					<input type="checkbox" name="" class="fn-hide" />
						        					<span class="priviLcls3">推广查看</span>
						      					</li>
					        				</ul>
					        			</li>
					        			<li><span class="iconTree icon-switchP"></span>
					        				<span class="iconTree icon-uncheck parentTree"></span>
					        				<span>财务</span>
					        				<ul class="secondTree">
					        					<li>
						        					<span class="iconTree icon-uncheck"></span>
						        					<input type="checkbox" name="" class="fn-hide" />
						        					<span class="priviLcls3">大客户乘客应收账款</span>
						      					</li>
						      					<li>
						        					<span class="iconTree icon-uncheck"></span>
						        					<input type="checkbox" name="" class="fn-hide" />
						        					<span class="priviLcls3">营业总收入</span>
						      					</li>
						      					<li>
						        					<span class="iconTree icon-uncheck"></span>
						        					<input type="checkbox" name="" class="fn-hide" />
						        					<span class="priviLcls3">平台返利</span>
						      					</li>
						      					<li>
						        					<span class="iconTree icon-switchP"></span>
						        					<span class="iconTree icon-uncheck parentTree"></span>
						        					<span>司机收入</span>
						        					<ul class="secondTree">
						        						<li>
								        					<span class="iconTree icon-uncheck"></span>
								        					<input type="checkbox" name="" class="fn-hide" />
								        					<span class="priviLcls3">基本收入</span>
							        					</li>
							        					<li>
								        					<span class="iconTree icon-uncheck"></span>
								        					<input type="checkbox" name="" class="fn-hide" />
								        					<span class="priviLcls3">返利</span>
							        					</li>
						        					</ul>
						      					</li>
						      					<li>
						        					<span class="iconTree icon-uncheck"></span>
						        					<input type="checkbox" name="" class="fn-hide" />
						        					<span class="priviLcls3">推广费用</span>
						      					</li>
						      					
					        				</ul>
					        			</li>
					        		</ul> -->
				        		</div>
				        	</div>
        				<!-- 权限信息弹出层end -->
                    	
                    
                    	<div class="datagrid-header selectPoint" >
                    		<em class="emcls"></em>
                    	</div>
                    	<!-- 弹出框 -->
	                    <div class="selectArea fn-hide">
	                    	<ul>
	                    	</ul>
	                    </div>
	                  	<!-- 弹出框 -->
	                  	
                    	
                    	<table id="dg" class="easyui-datagrid" style="width:625px;height:450px"  data-options="url:'../labourmanage/query.do',singleSelect:true,fitColumns:true,singleSelect:true,pagination:true,rownumbers:true">
                        	<thead>
                            	<tr>
                                	<th data-options="field:'id',width:80 " hidden="true">id</th>
                                	<th data-options="field:'name',width:80 ">姓名</th>
                                    <th data-options="field:'phone',width:80">手机号</th>
                                    <th data-options="field:'post',width:80">职位</th>
                                    <th data-options="field:'companyName',width:80">所属公司</th>
                                    <th data-options="field:'isactiveStr',width:80">是否启用</th>
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
