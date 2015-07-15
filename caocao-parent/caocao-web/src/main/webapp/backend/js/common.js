// JavaScript Document

$(function(){


	
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
	})
	
	
	
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
		

	