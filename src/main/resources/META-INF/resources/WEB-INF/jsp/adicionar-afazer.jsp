
<%@ include file="partials/header.jspf" %>
<%@ include file="partials/navigation.jspf" %>
<div class="container">

<h1>Insira os Afazeres</h1>

<form:form action="" method="post" modelAttribute="afazer"> <!-- edita atributte session bean afazer -->
	<fieldset class="mb-3">
		<form:label path="descricao">Descricao</form:label>
		<form:input type="text" required="required" path="descricao" /> <!--  propriedade descricao do bean -->
		<form:errors path="descricao" cssClass="text-warning"/>
	</fieldset>

	<fieldset class="mb-3">
		<form:label path="dataAlvo">Data Alvo</form:label>
		<form:input type="text" required="required" path="dataAlvo" cssClass="datepicker"/>  <!-- data alvo do bean -->
		<form:errors path="dataAlvo" cssClass="text-warning"/>
	</fieldset>

	<form:input type="hidden" path="id" />
	<form:input type="hidden" path="feito" />

	<input type="submit" class="btn btn-success">

</form:form>

</div>

<script type="text/javascript">
	$('.datepicker').datepicker({
		format: 'yyyy-mm-dd'
	});</script>

<%@ include file="partials/footer.jspf"%>