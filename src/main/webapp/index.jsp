<%@page import="org.openshift.InsultGenerator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Database Get</title>
</head>
<body>
<h1>TEST DOWNLOAD DB ROWS</h1>
<p>
<%
out.println(new InsultGenerator().testConnection());
%>
</form>
</body>
</html>
