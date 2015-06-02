<%--
  Created by IntelliJ IDEA.
  User: Evan
  Date: 2015/5/31
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>包管理工具</title>
</head>
<body>
<div>
<table class="table table-hover" border="2" align="center">
    <tr>
        <td>
            <form action="/">
                <input type="text" name="name" value="${className}">
                <br/>
                <input type="submit" value="submit" class="btn btn-primary">
            </form>
        </td>
        <td>
            构造函数如下：<br/>
            <c:forEach items="${constructorList}" var="constructor">
                ${constructor.description} <br/>
            </c:forEach>
            函数如下:<br/>
            <c:forEach items="${functions}" var="function">
                ${function.description} <br/>
            </c:forEach>
            变量如下:<br/>
            <c:forEach items="${variables}" var="variable">
                ${variable.description}<br/>
            </c:forEach>
        </td>
    </tr>
</table>
<br/>
</div>
<br/>
<br/>
<br/>
<h1>历史信息</h1>
<table>
    <%Integer i=1;%>
    <c:forEach items="${histories}" var="item">
        <tr>
            <td>
                <%= i%>
            </td>
            <td>
                <a href="/?name=${item.name}">${item.name}</a>
            </td>
            <% i=i+1; %>
        </tr>
    </c:forEach>
</table>
</body>
</html>
