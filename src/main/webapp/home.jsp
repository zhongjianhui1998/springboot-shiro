<%--
  /**
  
   * @Description 
  
   * @Author 钟建辉
  
   * @date  2020/5/7 14:44
  
   */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%--shiro 标签 --%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>后台管理 - yellowcong</title>
</head>
<body class="layui-layout-body"  >

<shiro:hasRole name="admin">
    <a href="<%=request.getContextPath() %>/user/admin">管理员</a><br/>
</shiro:hasRole>

<shiro:hasRole name="vip">
    <a href="<%=request.getContextPath() %>/user/user">普通用户</a><br/>
</shiro:hasRole>

<a href="<%=request.getContextPath() %>/user/loginOut">退出</a>
</body>
</html>