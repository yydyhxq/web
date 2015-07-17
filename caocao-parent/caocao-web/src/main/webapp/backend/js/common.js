// JavaScript Document

$(function(){
 	//菜单
	var setting = {

			view: {
				showLine: false,
				showIcon:false,
				
			},
			data: {
				simpleData: {
					enable: true,
					idKey:"id",
					pIdKey:"pid"
				}
			}
		};

	var userId = $("input[name='userId']").val();
	$.ajax({
		url:"../menu/usermenu.do?userId="+userId,
		type:"post",
		dataType:"json",
		success:function(data){
			console.log(data);
			zNodes = data;
			$(document).ready(function(){
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			});
		},
		error:function(){
			layer.alert("网络异常");
		}
		
	}) ;
      
	
	
	// 菜单栏
	$(".secondMenu").addClass("fn-hide");
	$(".thirdMenu").addClass("fn-hide");
	$(".mainMenucls").click(function(){
		var childUl = $(this).siblings("ul");
		var className = childUl.attr("class");
		if(className.indexOf("fn-hide")>=0){
			childUl.show().removeClass("fn-hide").parents(".mainMenucls").siblings().hide();
		}else{
			childUl.hide().addClass("fn-hide");
			}
	});
	
	// 二级菜单栏
	$(".secondMenu .mainMenucls").click(function(){
		$(this).toggleClass("currentcls");
	});
	
	//推广维护 时段选择
	
		$(".select1").html('<option value="00:00">00:00</option><option value="00:00">00:00</option><option value="00:30">00:30</option><option value="01:00">01:00</option><option value="01:30">01:30</option><option value="02:00">02:00</option><option value="02:30">02:30</option><option value="03:00">03:00</option><option value="03:30">03:30</option><option value="04:00">04:00</option><option value="04:30">04:30</option><option value="05:00">05:00</option><option value="05:30">05:30</option><option value="06:00">06:00</option><option value="06:30">06:30</option><option value="07:00">07:00</option><option value="07:30">07:30</option><option value="08:00">08:00</option><option value="08:30">08:30</option><option value="09:00">09:00</option><option value="09:30">09:30</option><option value="10:00">10:00</option><option value="10:30">10:30</option><option value="11:00">11:00</option><option value="11:30">11:30</option><option value="12:00">12:00</option><option value="12:30">12:30</option><option value="13:00">13:00</option><option value="13:30">13:30</option><option value="14:00">14:00</option><option value="14:30">14:30</option><option value="15:00">15:00</option><option value="15:30">15:30</option><option value="16:00">16:00</option><option value="16:30">16:30</option><option value="17:00">17:00</option><option value="17:30">17:30</option><option value="18:00">18:00</option><option value="18:30">18:30</option><option value="19:00">19:00</option><option value="19:30">19:30</option><option value="20:00">20:00</option><option value="20:30">20:30</option><option value="21:00">21:00</option><option value="21:30">21:30</option><option value="22:00">22:00</option><option value="22:30">22:30</option><option value="23:00">23:00</option><option value="23:30">23:30</option>')
				
		var sy = $.extend({}, sy);/*定义一个全局变量*/
		sy.serializeObject = function (form) { /*将form表单内的元素序列化为对象，扩展Jquery的一个方法*/
		var o = {};
		$.each(form.serializeArray(), function (index) {
		if (o[this['name']]) {
		o[this['name']] = o[this['name']] + "," + this['value'];
		} else {
		o[this['name']] = this['value'];
		}
		});
		return o;
		};
		
		//获取下拉选项框的值
		getName();
		

		//点击获取拉下选择框
		$(".selectPoint").on("click",function(){
			var $em = $(this).children(".emcls");
			$em.toggleClass("emclsp");
			$(".selectArea").toggleClass("fn-hide");
		});
		
		$(".selectArea input").on("click",function(){
			var dataId=$(this).attr("dataId");
			var checked = $(this).attr("checked");
			if(checked=="checked"){
				$('#dg').datagrid('hideColumn',dataId);
				$(this).removeAttr("checked");
			}else{
				$('#dg').datagrid('showColumn',dataId);
				$(this).attr("checked","checked");
			}
		});

		//后台权限设置
		
		
		$(".icon-switchP").on("click",function(){
			$(this).toggleClass("icon-switchA").siblings(".secondTree").slideToggle(200);
		});
		
		
		
		
		$(".parentTree").click(function(){
			
			var hasCheck = $(this).hasClass("icon-check");
			var childlist = $(this).siblings("ul").find(".icon-uncheck");
			if(!hasCheck){
				childlist.addClass("icon-check");
			}else{
				childlist.removeClass("icon-check");
			}
		})
		
		$(".icon-uncheck").on("click",function(){
			$(this).toggleClass("icon-check");
			var hasCheck = $(this).hasClass("icon-check");
			if(!hasCheck){
				$(this).next("input").attr("checked","checked");
			}else{
				$(this).next("input").removeAttr("checked");
			}
		});
		
		
		/*$(".priviLcls3").on("dblclick",function(){
			$(".priviLcls2").show();
		});*/
	});


	// 日期比较
		function compare(startTime,endTime){
			var a=0;
			if(startTime!=""&&endTime!=""){
				var startTime = split(startTime);
				var endTime = split(endTime);
				if(endTime<startTime){
					a=1;
				}else{
					a=0
				}
			}
			return a;
		}
		
		//日期比较
		function split(time){
			var time =time;
			var Arrtime = time.split("-");
			var sum="";
			for(var i=0;i<Arrtime.length;i++){
				sum += Arrtime[i];
			}
			return parseInt(sum);
		}
		
		
	/*	//日期时间比较
		function compare1(startTime,endTime){
			var a=0;
			if(startTime!=""&&endTime!=""){
				var startTime = split1(startTime);
				var endTime = split1(endTime);
				if(endTime<startTime){
					a=1;
				}else{
					a=0
				}
			}
			return a;
		}
		
		function split1(time){
			var yourtime =time;
			yourtime = yourtime.replace("-","/");
			var d1 = new Date(Date.parse(yourtime));    
			return d1
		}*/
		
		
		//菜单栏当前选项
		function current1(id,index){
			var $id = $("#"+id);
			var index = index -1;
			$id.addClass("currentcls").children(".secondMenu")
			.children("li").eq(index).addClass("currentcls2");
					
		}
		
		function current2(id,index1,index2){
			var $id = $("#"+id);
			var index1 = index1-1;
			var index2 = index2-1;
			$id.addClass("currentcls").children(".secondMenu").children("li")
			.eq(index1).addClass("currentcls1").children(".thirdMenu").children("li")
			.eq(index2).addClass("currentcls2");
		}
		
		
		
		//获取相应长度字符
		function fix(num, length) {
			return ('' + num).length < length ? ((new Array(length + 1)).join('0') + num).slice(-length) : '' + num;
		}

		//获取下拉框的值
		function getName(){
			var $th = $("#dg thead th");
			var name ="";
			var html="";
			var startIndex = 7;
			var $selectArea = $(".selectArea ul");
			for(var i=0;i<$th.length;i++){
				var data = $th.eq(i).attr("data-options");
				var endIndex = data.indexOf("',width");
				html = $th.eq(i).html();
				name = data.substring(startIndex,endIndex).trim();
				if(html.indexOf("id")<0){
					$selectArea.append('<li><input type="checkbox"  dataId=' +name +'  checked="checked"/>'+html+'</li>');
				}
			}
		}
		
		
		//控制输入数字长度 （手机号，身份证）
		  function chekNum(obj,num){
			  	var num = parseInt(num);
		        obj.value = obj.value.replace(/[^\d.]/g,"");
		        obj.value = obj.value.replace(/^\./g,"");
		        obj.value = obj.value.replace(/\.{2,}/g,".");
		        obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
		        if(obj.value.length > num){
		                obj.value = obj.value.substring(0,num);      
		        }
		    }
		
		  //添加tab栏
		  function tabs(data){
			 	var cookieStr = $.cookie("con"); 
				var cookieJson = JSON.parse(cookieStr); 
				cookieJson  = Splice(cookieJson);
				if(cookieJson.length>6){
					cookieJson.splice(0,1);   //如果cookie里的个数大于6个，就把cookie中的第一个jsp删了
				}
			
				var s = cookielist(cookieJson,data);
				s.push(data);
				$(".mainCon h3 ul").append("<li><a href="+data.url+" class='red'>"+data.title+"</a></li>");
				var cookieJsonStr = JSON.stringify(s);  //转化成字符串
				$.cookie("con",cookieJsonStr); //将值存入cookie 
		  }
		  
		  //删除tabs
		  function deltabs(obj){
			 var  $this = $(obj);
			 var  title = $this.html();
			 var $ul = $this.parent("li").parent("ul");
			 var  Alist = $ul.children("li").children("a");
			 for (var b=0;b<Alist.length;b++){
				 if(Alist.eq(b).html()==title){
					 var index = b;
				 }
			 }
			 $ul.children("li").eq(index).remove();
			 var cookieStr = $.cookie("con"); 
			 var cookieJson = JSON.parse(cookieStr); 
			 cookieJson =  Splice(cookieJson);
			 var s=[];
			 var l={};
			 for(var i = 0;i<cookieJson.length;i++){
				 if(title!= cookieJson[i].title){
					 l = cookieJson[i];	 
					
				 }
				 s[i] = l;
			 } 
			s= s;
			var cookieJsonStr = JSON.stringify(s);  //转化成字符串
		    $.cookie("con",cookieJsonStr); //将值存入cookie 
				
		  }
		  
		  
		  
		  //cookie 去重
		  function Splice(cookie){
		  var a = cookie;
		  for(var i=0; i < a.length; i++) {
			    for(var j=i+1; j < a.length; j++) {
			        if(a[i].title == a[j].title) {
			            a.splice(j,1);

			        }
			    }
			}
		 
		  return a; 
		
		  }
		  
		  /*Array.prototype.removeRepeatAttr=function(){
			    var tmp={},a=this.slice(); 
			    for(var i=j=0;i<a.length;i++){
			        if(!tmp[a[i].id]){
			            tmp[a[i].id]=!0;
			            j++;
			        }else{
			            this.splice(j,1);
			        }
			    };
			}
			var arr=[{"id":"1"}, {"id":"2"}, {"id":"1"}, {"id":"3"}, {"id":"2"}, {"id":"5"}, {"id":"3"}, {"id":"4"}, {"id":"2"}, {"id":"4"}];
			arr.removeRepeatAttr();*/
			 
		  
		  // 添加cookie
		  function cookielist(obj,data){
			  var data = data;
			  var cookieJson  = obj;
			  var s=[];
			  var l={};
			
			  for(var i= 0 ; i<cookieJson.length;i++){
				   if(cookieJson[i].title!=data.title && cookieJson[i].title!= undefined ){
					     l = cookieJson[i];	  
						 var title = cookieJson[i].title;
						 var url = cookieJson[i].url;
						 $(".mainCon h3 ul").append("<li><a href="+url+">"+title+"</a><em  onclick='emdelete(this)'></em></li>");
				   }
				   s[i] = l;
				   
				}
			  return s;
		  }
		  
		  
		  //删除tabs
			
				function emdelete(obj){
					$this= $(obj);
					var a = $this.prev("a");
					deltabs(a);
				}
		  
				//datagrid 自适应	
		function reSize(id,percent){	
			var $obj= $("#"+id)
			$obj.datagrid("resize",{  
				width: getWidth(percent)  
			});                
			$(window).resize(function(){  	
				$obj.datagrid("resize",{  
					width: getWidth(percent)  
				});                
			});	
		}	
		//datagrid获取宽度
		function getWidth(percent){  
	           return $(window).width() * percent;  
	     }  
		
			
		
		  
	