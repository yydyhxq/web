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
		current1("income",3)
		
		$(".select").select2();	
		
			//查询
		$("#search").click(function(){
			var year = $("select[name='year']").val(); //获取年
			var costProduceBegin= $("input[name='costProduceBegin']").val();
			var costProduceEnd= $("input[name='costProduceEnd']").val();
			if(compare(costProduceBegin,costProduceEnd)==0){
				$("#dg").datagrid('load',{
					year:year,			
					costProduceBegin:costProduceBegin,
					costProduceEnd:costProduceEnd
				})
				$('#dg').datagrid('reload');    // reload the current page data		
			}else{
				layer.msg("结束日期不能小于开始日期");
			}
		})
	})
</script>
<title>平台返利</title>
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
               <h3>平台返利</h3>
               <div class="mainConcls">
               		<!--查询条件 start-->
               		<div class="mainConcls1 clearfix">
                    	<div class="mainConcls2 clearfix">
                            <label>年度</label>
                            <select class="select" name="year" id="year">
                            	<option value="">--请选择年份--</option>
                				<option value="2015-01-01">2015</option>
                                <option value="2016-01-01">2016</option>
                                <option value="2017-01-01">2017</option>
                                <option value="2018-01-01">2018</option>
                                <option value="2019-01-01">2019</option>
                                <option value="2020-01-01">2020</option>
                                <option value="2021-01-01">2021</option>
                                <option value="2022-01-01">2022</option>
                                <option value="2023-01-01">2023</option>
                                <option value="2024-01-01">2024</option>
                                <option value="2025-01-01">2025</option>                      
                			</select>                
                        	<label style="margin-left:10px">费用产生日期</label>
                            <input type="text" class="Wdate inputcls rightcls8"   onclick="WdatePicker()" name="costProduceBegin">
                            <label class="mainConcls2_2">至</label>
                            <input type="text" class="Wdate inputcls currentTime"  onclick="WdatePicker()" name="costProduceEnd">
                       		<input type="button" class="buttoncls" value="查询" id="search" />  
                        </div>
                        
                    </div>
                    <!--查询条件end-->
                    
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
	                  	
                   		 <table id="dg" class="easyui-datagrid" style="width:1077px;height:450px"  data-options="url:'../financemanage/queryplat.do',fitColumns:true,singleSelect:true,pagination:true,rownumbers:true">
                            <thead>
                                <tr>
                                    <th data-options="field:'yearStr',width:90">年度</th>
                                    <th data-options="field:'costProduceDateStr',width:120">费用产生日期</th>
                                    <th data-options="field:'totalBackMoney',width:90">合计返利金额</th>
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
</html>
