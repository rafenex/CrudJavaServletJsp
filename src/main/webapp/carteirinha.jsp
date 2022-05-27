<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD Java - Cadastro de Estudantes | Home</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Faculdade</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="index.html">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="CreateAndFind">Lista de Estudantes</a></li>
				</ul>
				<form action="CreateAndFind" method="GET" class="d-flex">
					<input name="pesquisa" class="form-control me-2" type="search"
						placeholder="Nome ou CPF" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Buscar</button>
				</form>
			</div>
		</div>
	</nav>
	<br>
	<div class="container d-flex justify-content-center"> 
		<div class="col-sm-12 col-md-8 col-lg-6 col-xl-6">
		   <table class="table table-bordered">
                <tr>
                    <td rowspan=" 4">
                        <figure class="figure">
                            <img class="mb-0" width="240px"src="${estudante.imagem}"
                                class="figure-img img-fluid rounded" alt="Foto do perfil">
                        </figure>
                    </td>
                    <td>Nome: ${estudante.nome}</td>
                </tr>
                <tr>
                    <td>Curso: ${estudante.curso}</td>
                </tr>
                <tr>
                    <td>CPF: ${estudante.cpf}</td>
                </tr>
                <tr>
                    <td>Matricula: ${estudante.situacao}</td>
                </tr>
            </table>
            </div>
           	</div>
           	   <div class="text-center">
        <button type="button" class="btn btn-secondary" onClick="window.print()">Imprimir</button>
        <a href="CreateAndFind"><button type="button" class="btn btn-secondary">Voltar</button></a>
    </div>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>