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
   <li> <a href="../../GestionHospitaliereSys/DocteurPat" ><i class="fa fa-plus-square" aria-hidden="true"></i> <span class="ml-1">Ajouter</span></a></li>
      <li><a href="./view/Patient/ChercherP.jsp"><i class="fa fa-search-plus" aria-hidden="true"></i><span class="ml-1">chercher</span></a></li>
     <li><a href="./AffichagePat"> <i class="fa fa-hand-o-left" aria-hidden="true"></i><span class="ml-1">retourne </span></a></li>
      </ul>
      <center>
      <div class="main">

        <div class="container-fluid">
          <div class="row">
            <div class="col-md-8">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Modifier un patient</h4>
                  <p class="card-category">Les informations du patient</p>
                </div>
                <div class="card-body">
 <form method='POST' action='./ModifierPat'>
   <c:forEach items= "${listpa}"  var="pat">
   <div class="row">
                      <div class="col-md-12">
                        <div class="form-group">
                          <label class="bmd-label-floating">ID</label>
                          <input name='txtid' type='text'  value= "${pat.id}" required='required'class="form-control">
                        </div>
                      </div>
                    </div>
   <div class="row">
                      <div class="col-md-6">
                        
                        <div class="form-group">
                          <label class="bmd-label-floating">NOM</label>
                          <input id='txtnom' name='txtnom'  value= "${pat.nom_pat}" type='text' required='required' class="form-control"/>
                        </div>
                     
                      </div>
<div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Prenom</label>
                          <input name='txtprenom' id='txtprenom' type='text' value= "${pat.prenom}"  required='required' class="form-control"/>
                        </div>
                      </div>
                      </div>
  <div class="row">
                   
 <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Email address</label>
                          <input id='email' name='email' type='text' value= "${pat.email}" required='required' class="form-control">
                        </div>
                      </div>
                   
<div class="col-md-6">
                        <div class="form-group">
                       
		<label for='txtdocteur' class="bmd-label-floating">Nom du docteur:</label>
	<div class="dropdown">
	
	<select id="txtdocteur" name="txtdocteur" class="custom-select" style="width:200px;">
	 <c:forEach items="${listDoc}"  var="doc">
	<option value="${doc.id}">${doc.nom}</option>
	</c:forEach>
	</select>
	</div>
	</div>
	</div>
	 </div>	
	<div class="row">
	<div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Numero de téléphone</label>
                          <input id='numero' name='numero' type='text' required='required' value= "${pat.numero}"  class="form-control">
                        </div>
                      </div>
      <div class="col-md-6">
    <div class="form-group">
                          <label class="bmd-label-floating">Adresse</label>
                          <input id='txtadresse' name='txtadresse' type='text' required='required'  value= "${pat.adresse}" class="form-control">
                        </div>
                      </div>                    
                      
                    </div>  
	
<input name='btnModifier' type='submit' value='Modifier' id='Modifier' class="btn btn-primary pull-right"   />
 </c:forEach>
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