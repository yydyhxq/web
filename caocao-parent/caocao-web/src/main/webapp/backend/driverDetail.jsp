<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<%@ include file="/backend/common/meta.jsp" %>
<%@ include file="/backend/common/script.jsp"%>

<script>
	$(function(){
		//获取id名
		var id = getId("id");
		if(id!=""){
			
			var url="../drivermanage/queryid.do?id="+id;
			$.ajax({
				url:url,
				dataType:'json',
				success:function(data){				
					$("#name").html(data.name);
					if(data.sex=="1"){
						$("#sex").html("男");
					}else{
						$("#sex").html("女");
					}
					$("#birthPlace").html(data.birthPlace);
					$("#livePlace").html(data.livePlace);
					$("#email").html(data.email);
					$("#cardno").val(data.cardno);
					$("#livePlace").html(data.livePlace);
					$("#birthPlace").html(data.birthPlace);
					$("#height").html(data.height);
					$("#weight").html(data.weight);			
					$("#brand").html(data.brand);
					$("#totalService").html(data.totalService);
					$("#starLevel").html(data.starLevel);
					$("#inviteCode").html(data.inviteCode);
					$("#registerTimeStr").html(data.registerTimeStr);
					$("#distance").html(data.distance);
					$("#city").html(data.city);
					$("#remark").val(data.remark);
					$("#licenceNo").val(data.licenceNo);
					$("#educateDegree").val(data.educateDegree);
					$("#remark").val(data.remark);
				}

			});
			
		}
		

	})
</script>
<title>司机详细信息</title>
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
   <div class="container detailcls">
   		<div class="mainCon">
            <a href="driverWatch.jsp"><<返回</a>
            <h3>司机详细信息 <span class="stauscls">当前在线</span></h3>
         
            <div class=" mainConcls2 clearfix">
            	<span class="spancls1">姓名 : <i id="name"></i></span>
                <span class="spancls1">性别 : <i id="sex"></i></span>
                <span class="spancls1">出生年月 : <i id=""></i></span>
            </div>
             <div class=" mainConcls2 clearfix">
            	<span class="spancls1">身高 : <i id="height"></i></span>
                <span class="spancls1">体重 : <i id="weight"></i></span>
                <span class="spancls1">电子邮件 : <i id="email"></i></span>
            </div>
              <div class=" mainConcls2 clearfix">
            	<span class="spancls1">户籍所在地 : <i id="birthPlace"></i></span>
                <span class="spancls1">现居住地址 : <i id="livePlace"></i></span>
                <span class="spancls1">联系电话 :<i id="phone"></i></span>
            </div>
             <div class=" mainConcls2 clearfix">
            	<span class="spancls1">学历 : <i id="educateDegree"></i></span>
                <span class="spancls1">专业 : <i id=""></i></span>
                <span class="spancls1">毕业院校 : <i id=""></i></span>
            </div>
            <div class="mainConcls2 clearfix">
            	<span class="spancls1">品牌 : <i id="brand"></i></span>
            	<span class="spancls1">车型 :<i id="mode"></i></span>
                <span class="spancls1">车牌号 : <i id=""></i></span>  
            </div>
             <div class="mainConcls2 clearfix">
            	<span class="spancls1">服务次数 : <i id="totalService"></i></span>
                <span class="spancls1">星级 : <i id="starLevel"></i></span>
                <span class="spancls1">邀请码 : <i id="inviteCode"></i> </span>
            </div>
             <div class="mainConcls2 clearfix">
            	<span class="spancls1">注册时间 : <i id="registerTimeStr"></i></span>
                <span class="spancls1">行驶里程 : <i id="distance"></i></span>
                <span class="spancls1">所属城市 : <i id="city"></i> </span>
            </div>
        	 <div class="mainConcls2 clearfix">
            	<span class="spancls1">所属租赁公司 : <i id=""></i></span>
                <span class="spancls1">所属劳务公司 : <i id="labId"></i></span>
               
            </div>
            <div class="mainConcls2 clearfix">
            	<span class="spancls1">商业险编号 :<i id=""></i></span>
                <span class="spancls1">交强险编号 :<i id=""></i></span> 
            </div>
            
            
            <div class="mainConcls2 clearfix">
            	<label class="labelcls1">身份证号:</label>
                <input type="text" readonly="readonly" class="inputcls1 w370" id="cardno" value=""   />
            </div>
             <div class="mainConcls2 mainConcls2_3 clearfix">
            	<label class="labelcls1">正面图片:</label>
                <img src="" class="imgcls" />
                <label class="labelcls1">反面图片:</label>
                <img src="" class="imgcls"  />
            </div>
            <div class="mainConcls2 clearfix">
            	<label class="labelcls1">驾驶证号:</label>
                <input type="text" readonly="readonly" class="inputcls1 w370" id="licenceNo" value=""   />
            </div>
             <div class="mainConcls2 mainConcls2_3 clearfix">
            	<label class="labelcls1">正本图片:</label>
                <img src="" class="imgcls" />
                <label class="labelcls1">副本图片图片:</label>
                <img src="" class="imgcls"  />
            </div>
            <div class="mainConcls2 clearfix">
            	<label class="labelcls1">行驶证号:</label>
                <input type="text" readonly="readonly" class="inputcls1 w370" id="" value=""   />
            </div>
            <div class="mainConcls2 mainConcls2_3 clearfix">
            	<label class="labelcls1">正本图片:</label>
                <img src="" class="imgcls" />
                <label class="labelcls1">副本图片图片:</label>
                <img src="" class="imgcls"  />
            </div>
            <div class="mainConcls2 clearfix">
            	<label class="labelcls3">备注:</label>
                <textarea class="textareacls textareacls1 " readonly="readonly" id="remark"></textarea>
            </div>
        </div>
   </div>
    

    
</body>
<script>
	//获取url参数
	function getId(key){
		var id;
		var urlmap = location.href.split("?");
		if(urlmap[1]==""||urlmap[1]== undefined){
			id=""; 
		}else{
		var field = urlmap[1].split("&");
			for(var i=0;i<field.length;i++){
				var va = field[i].split("=");
				if(va[0]==key){
					id=va[1];
				}	
			}
		}
		return id;
	 }
</script>
</html>
