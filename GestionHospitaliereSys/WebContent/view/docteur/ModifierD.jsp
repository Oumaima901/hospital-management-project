<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<link rel="stylesheet" href="./css/sidebar.css">
<link rel="stylesheet" href="./css/form.css">
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
      <li><a href="./view/docteur/AjoutD.jsp"><i class="fa fa-plus-square" aria-hidden="true"></i><span class="ml-1">Ajouter</span></a></li>
    
      <li><a href="./view/docteur/ChercherD.jsp"><i class="fa fa-search-plus" aria-hidden="true"></i><span class="ml-1">chercher</span></a></li>
       <li><a href="./AffichageDoc"> <i class="fa fa-hand-o-left" aria-hidden="true"></i><span class="ml-1">retourne </span></a></li>
      </ul>
<center>
 <div class="main">

        <div class="container-fluid">
          <div class="row">
            <div class="col-md-8">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Modifier un docteur</h4>
                  <p class="card-category">Les informations du docteur</p>
                </div>
                <div class="card-body">
 <form method='POST' action='./ModifierDoc'>
   <c:forEach items= "${listD}"  var="doc">
    <div class="row">
                      <div class="col-md-5">
                        <div class="form-group">
                          <label class="bmd-label-floating">ID</label>
                          <input name='txtid' type='text' value= "${doc.id}" required='required' class="form-control" />
                        </div>
                      </div>
      <div class="col-md-3">
                        <div class="form-group">
                          <label class="bmd-label-floating">NOM</label>
                          <input id='txtnom' name='txtnom'  value= "${doc.nom}" type='text' required='required' class="form-control"/>
                        </div>
                      </div>
<div class="col-md-3">
                        <div class="form-group">
                          <label class="bmd-label-floating">Prenom</label>
                          <input name='txtprenom' id='txtprenom' type='text' value= "${doc.prenom}"  required='required' class="form-control"/>
                        </div>
                      </div>

 <div class="col-md-12">
                        <div class="form-group">
                          <label class="bmd-label-floating">Email address</label>
                          <input id='email' name='email' type='text' value= "${doc.email}" required='required' class="form-control">
                        </div>
                      </div>
                    </div>


<div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Spécialité</label>
                          <input id='txtspec' name='txtspec' type='text' value= "${doc.specialisation}" required='required' class="form-control">
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Numero de téléphone</label>
                          <input id='numero' name='numero' type='text' required='required' value= "${doc.numero}" class="form-control">
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group">
                          <label class="bmd-label-floating">Adresse</label>
                          <input id='txtadresse' name='txtadresse' type='text' value= "${doc.adresse}" required='required'class="form-control">
                        </div>
                      </div>
                    </div>
	
<input name='btnModifier' type='submit' value='Modifier' id='Modifier'  class="btn btn-primary pull-right"/>
 </c:forEach>
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