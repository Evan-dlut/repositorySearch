<%--
  Created by IntelliJ IDEA.
  User: Evan
  Date: 2015/3/7
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cc" uri="/mytaglib" %>
<div id="sideBar">
        <div class="bs-example" data-example-id="simple-nav-stacked">
            <ul class="nav nav-pills nav-stacked" style="max-width: 300px;">
                
                <li role="presentation"
                    <c:if test="${partyMessage == true}"> class="active"</c:if>>
                    <a href="/home">支部动态</a>
                </li>
                <li role="presentation"
                    <c:if test="${myCenter == true}"> class="active"</c:if> >
                    <a href="/myCenter">个人中心</a></li>
                <li role="presentation"
                    <c:if test="${messageCenter == true}">  class="active"</c:if>>
                    <a href="/myMessage">消息中心<span class="badge">${messageNum}</span></a></li>
                <li role="presentation"
                    <c:if test="${articleRelease == true}"> class="active"</c:if> >
                    <a href="/article/write">文章发布</a></li>
                <li role="presentation"
                    <c:if test="${permission == true}"> class="active"</c:if> >
                    <a href="/operate">操作（权限）</a></li>
            </ul>
        </div>

    <%--近期热文--%>
</div>
