
<%@ include file="partials/header.jspf" %>
<%@ include file="partials/navigation.jspf" %>

<div class="container">
<div> <h1>Bem vindo ${nome}</h1></div>
<table class="table">
	<thead>
		<th>Descrição</th>
		<th>Data Alvo</th>
		<th>Completo</th>
        <th></th>
        <th></th>
	</thead>
	<tbody>
		<c:forEach items="${afazeres}" var="afazer">
			<tr>
				<td>${afazer.descricao}</td>
				<td>${afazer.dataAlvo}</td>
				<td>${afazer.feito}</td>
				<td><a href="delete-afazer?id=${afazer.id}" class="btn btn-warning">Deletar</a></td>
                <td><a href="update-afazer?id=${afazer.id}" class="btn btn-success">Atualizar</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a href="adicionar-afazer" class="btn btn-success"> + </a>

</div>

<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>

<%@ include file="partials/footer.jspf"%>