<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ctrip.sec.sso.principal.AttributePrincipal" %>
<%@ page import="com.ctrip.sec.sso.util.AssertionHolder" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map.Entry" %>
<html>
<body>
<h2>这是一个新的页面</h2>
<h2>这是一个新的页面</h2>
<h2>这是一个新的页面</h2>

<%
    AttributePrincipal principal = (AttributePrincipal) AssertionHolder.getAssertion().getPrincipal();
    Map map=principal.getAttributes();
    String name=(String) map.get("name");
    out.println(name);
    java.util.Iterator it = map.entrySet().iterator();
    while(it.hasNext()){
        java.util.Map.Entry entry = (java.util.Map.Entry)it.next();
        out.println(entry.getKey());
        out.println(entry.getValue());
    }
%>

<%--<%=name;%>--%>
</body>
</html>