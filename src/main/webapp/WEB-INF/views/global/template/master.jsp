<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
 	<title><tiles:getAsString name="global_title"/></title>
 	<link rel="stylesheet" href="<c:url  value='/resources/ui/bootstrap/css/bootstrap.css' />" />
    <link rel="stylesheet" href="<c:url  value='/resources/ui/bootstrap/css/bootstrap.min.css' />" />
   	<link rel="stylesheet" href="<c:url  value='/resources/ui/bootstrap/font-awesome/css/font-awesome.css' />" />
   	<link rel="stylesheet" href="<c:url  value='/resources/ui/custom/css/style.css' />" />
   	
	<script type="text/javascript" src="<c:url  value='/resources/ui/bootstrap/js/jquery.js' />"></script>	
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	
</head>
<body >
		<tiles:insertAttribute name="global_header" />
		<tiles:insertAttribute name="global_content" />
		<tiles:insertAttribute name="global_footer" />
</body>
</html>