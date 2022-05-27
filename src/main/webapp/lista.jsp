<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/bbcd577535.js" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>CRUD Java - Lista de Estudantes</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Faculdade</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.html">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="CreateAndFind">Lista de Estudantes</a>
        </li>
      </ul>
      <form action="CreateAndFind" method="GET" class="d-flex">
        <input name="pesquisa" class="form-control me-2" type="search" placeholder="Nome ou CPF" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Buscar</button>
      </form>
    </div>
  </div>
</nav>
<br>
<div class="container col-12">
	
		<div>
			<hr>
			<h3>Estudantes Cadastrados</h3>
			<hr>
			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>Nome</th>
						<th>Curso</th>
						<th>CPF</th>
			
						<th>Situação</th>
					</tr>
				</thead>
				<tbody>
						<c:forEach items="${estudantes}" var="estudante">
							<tr>
								<td>${estudante.id}</td>
								<td>${estudante.nome}</td>
								<td>${estudante.curso}</td>
								<td>${estudante.cpf}</td>
					
								<td>${estudante.situacao}</td>
								<td>							
									<a href="EstudanteCarteirinha?estudanteId=${estudante.id}"><i class="fa-solid fa-address-card btn-outline-success" title="Carteirinha"></i></a>
									<a href="EstudanteUpdate?estudanteId=${estudante.id}"><i class="fa-solid fa-pen-to-square btn-outline-primary" title="Editar"></i></a>						
									<a href="EstudanteDestroy?estudanteId=${estudante.id}"><i class="fa-solid fa-trash-can btn-outline-danger" title="Deletar"></i></a> 
								</td>
							
						</c:forEach>			
				</tbody>
			</table>
			
			<h5><a href="index.html"><button type="button" class="btn btn-info">Voltar</button></a></h5>
		</div>		

</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>