<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="../../css/style.css">
  <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link rel="stylesheet" href="../../css/font-awesome.min.css">
  <title>Sign in</title>
</head>
<body>
<c:choose>
<c:when test="${sessionScope.login != null}">
	<c:redirect url="/view/accueil/accueil.jsp"/>
	</c:when>
	
<c:when test="${sessionScope.login == null}">
<div class="main">
 <p class="sign" align="center">Sign in</p>
 <form method='POST' action='../../login'>
	<input id='txtLogin' class="un "  name='txtLogin' align="center" type='text' placeholder='Username' required /><br/>
	<input name='txtPassword'  class="pass" type='password' align="center" placeholder='password' required/>
<input name='btnConnect' type='submit' value='Login' id='login' class="submit" />
</form>
  </div>
  </c:when>
</c:choose>
</body>
</html>