<%@page import="org.openshift.Audioprocessor"%>
<%@page import="org.openshift.Load"%>
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
out.println(new Audioprocessor().getDPData());
//new Load().Test();
%>
<form method="post" action="Load">
Test CPU load burner: 
<input type="submit" value="burner" />
</form>
</body>
</html>
