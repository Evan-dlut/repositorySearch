<%--
  Created by IntelliJ IDEA.
  User: Evan
  Date: 2015/4/28
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cc" uri="/mytaglib" %>
<div id="leftCol">

    <div id="pagelet_navigation" class="bs-example" data-example-id="simple-nav-stacked">
        <div class="_55y4" >
            <div id="sideNav" class="uiFutureSideNav" role="navigation">
                <div data-reactid=".16">
                    <div id="pinnedNav" class="homeSideNav" data-reactid=".16.$pinnedNav">
                        <ul class="_bui droppableNav _3-8w _3-96">

                            <li class="sideNavItem stat_elem" <c:if test="${partyMessage == true}"> class="active"</c:if>>
                                <div>
                                    <div class="clearfix">
                                        <a class="_5afe sortableItem" title="支部动态" href="/messages/" draggable="false" >
                                            <div class="linkWrap noCount" data-reactid=".16.$pinnedNav.1.$217974574879787.0.$link.0.2">
                                                <span data-reactid=".16.$pinnedNav.1.$217974574879787.0.$link.0.2.0">支部动态</span>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
