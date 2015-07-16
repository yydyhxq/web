<%@page import="com.caocao.util.JsonUtil"%>
<%@page import="com.caocao.server.constant.ResultCode"%>
<%@page import="com.caocao.server.constant.ResultState"%>
<%@page import="com.caocao.server.dto.MobileHttpDto"%>
<%@page import="com.caocao.server.dto.MobileHttpDto.Error"%>
<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
</head>
<body>
<%
MobileHttpDto dto = new MobileHttpDto();
dto.setStatus(ResultState.ERROR);

dto.setError(new Error(ResultCode.MOBLE_SERVER_EXCEPTION.getCode(),
		ResultCode.MOBLE_SERVER_EXCEPTION.getMessage()));

	response.getWriter().write(JsonUtil.getJSONString(dto));

%>
</body>
</html>