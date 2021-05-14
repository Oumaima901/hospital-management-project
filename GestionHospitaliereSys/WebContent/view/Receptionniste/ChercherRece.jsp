<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<link rel="stylesheet" href="../../css/sidebar.css">
<link rel="stylesheet" href="../../css/form.css">
 <link href='https://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${sessionScope.login == null}">
	<c:redirect url="/view/accueil/accueil.jsp"/>
	</c:when>
	
<c:when test="${sessionScope.login != null}">
<ul class="sidebar">
  <li class="sidebar-brand"><a href="./view/accueil/accueil.jsp">Gestion Hospitaliere</a></li>
 <li> <a  href="AjoutRece.jsp" ><i class="fa fa-plus-square" aria-hidden="true"></i> <span class="ml-1">Ajouter</span></a></li>
     <li><a href="../../AffichageRece"> <i class="fa fa-hand-o-left" aria-hidden="true"></i><span class="ml-1">retourne </span></a></li>
      </ul>
     
      <center>
    <div class="main">

        <div class="container-fluid">
          <div class="row">
            <div class="col-md-8">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">chercher un Receptionniste</h4>
                  <p class="card-category">Les informations du Receptionniste</p>
                </div>
                <div class="card-body">
      
 <form method='POST' action='../../ChercherRece'>
 
 
 
 <div class="row">
                      <div class="col-md-12">
                        <div class="form-group">
                          <label class="bmd-label-floating">ID</label>
                          <input id='txtid' name='txtid' type='text' required='required'class="form-control">
                        </div>
                      </div>
                    </div>

 <div class="row">
                      <div class="col-md-12">
                        <div class="form-group">
                          <label class="bmd-label-floating">Nom</label>
                          <input id='txtprenomdoc' name='txtprenomdoc' type='text' required='required'class="form-control">
                        </div>
                      </div>
                    </div>
                    <input name='btnajouter' type='submit' value='chercher' class="btn btn-primary pull-right"  />
                    <div class="clearfix"></div>

 </form>
                </div>
              </div>
            </div>
              </div>
        </div>
   </div>
      
  </center>    
 

 </c:when>
</c:choose>
</body>
</html>