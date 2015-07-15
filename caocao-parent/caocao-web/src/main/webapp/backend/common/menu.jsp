<%@ page pageEncoding="UTF-8"%>

<!--菜单start-->
        <div class="leftArea">
         	   <ul class="mainMenu">
            	<!--<li ><a href="javascript:void;" class="mainMenucls">系统设置</a>
                	<ul class="secondMenu">
                    	<li><a href="#" class="mainMenucls" >系统参数设置</a> </li>
                    </ul>
                </li>-->
                  <li id="admin" class="mainMenu1 "><a  class="mainMenucls">用户管理</a>
                	<ul class="secondMenu">
                    	<li><em></em><a href="index.jsp">用户信息维护</a></li>
                    </ul>
                </li>
                <li id="company" class="mainMenu1"><a  class="mainMenucls">企业管理</a>
                	<ul class="secondMenu ">
                    	<li><em></em><a href="vipCompanyService.jsp">大客户企业维护</a></li>
                        <li><em></em><a href="rentService.jsp">租赁公司维护</a></li>
                        <li><em></em><a href="labourService.jsp">劳务公司维护</a></li>
                    </ul>
                </li>
                  <li id="car" class="mainMenu1" ><a class="mainMenucls">车辆管理</a>
                 	<ul class="secondMenu">
                    	<li><em></em><a href="carTypeSet.jsp">车型设置</a></li>
                    </ul>
                </li>
                <li  id="driver" class="mainMenu1" ><a class="mainMenucls">司机管理</a>
                	<ul class="secondMenu">
                		<!--<li><em></em><a href="driverInterview.jsp">司机初审/面试</a></li> 
                        <li><em></em><a href="dirverRetrial.jsp">司机复试</a></li> 
                         <li><em></em><a href="driverContract.jsp">合同/协议签订</a></li>-->
                       <!--  <li><em></em><a href="driverService.jsp">司机培训</a></li>  -->
                        <li><em></em><a href="driverWatch.jsp">司机信息查看</a></li>                     
                    </ul>
                </li>
                <li id="customer" class="mainMenu1"><a  class="mainMenucls">客户管理</a>
                	<ul class="secondMenu">
                    	<li><a class="mainMenucls">大客户管理</a>
                        	<ul class="thirdMenu">
                            	<li><em></em><a href="vipService.jsp">基本信息维护</a></li>
                                <li><em></em><a href="vipWatch.jsp">账户明细查看</a></li>
                            </ul>
                        </li>
                        <li><a class="mainMenucls ">普通客户管理</a>
                        	<ul class="thirdMenu">
                            	<li><em></em><a href="basicService.jsp">基本信息维护</a></li>
                                <li><em></em><a href="basicWatch.jsp">账户明细查看</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li id="order" class="mainMenu1 "><a  class="mainMenucls">订单管理</a>
                	<ul class="secondMenu">
                    	<li><em></em><a href="bookingOrder.jsp">预约订单</a></li>
                        <li><em></em><a href="currentOrder.jsp">实时订单</a></li>
                        <li><em></em><a href="historyOrder.jsp">历史订单</a></li>
                    </ul>
                </li>
                <li id="promotion" class="mainMenu1" ><a  class="mainMenucls">推广管理</a>
                	<ul class="secondMenu">
                    	<li><em></em><a href="promotion.jsp">推广维护</a></li>                      
                    </ul>
                </li>
                <li id="income" class="mainMenu1"><a  class="mainMenucls">财务管理</a>
                	<ul class="secondMenu">
                    	<li><em></em><a href="vipIncome.jsp">大客户应收账款</a></li>
                        <li><em></em><a href="totalIncome.jsp">营业总收入</a></li>
                        <li><em></em><a href="platform.jsp">平台返利</a></li>
                        <li><em></em><a href="driverIncome.jsp">司机基本收入</a> </li>
                    </ul>
                </li>
            </ul>
        </div>
        <!--菜单end-->