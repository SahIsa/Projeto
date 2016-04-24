<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Faculdade - Criar Curso</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/datepicker.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegacao -->
	<c:import url="menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Incluir Curso</h3>
		<!-- Formulario para inclusao de alunos -->
		<form action="ManterCurso.do" method="post">
			
				<!-- area de campos do form -->
				<div class="row well">
					<div class="form-group col-md-12">
						<label for="nomeCurso">Nome do Curso</label> 
						<input type="text" class="form-control" name="nomeCurso" id="nomeCurso" required maxlength="45" placeholder="Nome do curso">
					</div>

					<div class="form-group col-md-6">
						<label for="dataIni">Data de Inicio:</label>
						<div class="input-group date">
							<input type="text" class="form-control" value="" name="dataIniCurso" id="dataIniCurso">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-calendar"></span>
							</div>
						</div>
					</div>

					<div class="form-group col-md-6">
						<label for="dataFimCurso">Data final:</label>
						<div class="input-group date">
							<input type="text" class="form-control" value="" name="dataFimCurso" id="dataFimCurso">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-calendar"></span>
							</div>
						</div>
					</div>

					<div class="form-group col-md-6">
						<label for="valCurso">Valor do Curso</label> 
						<input type="text" class="form-control" name="valorCurso" id="valorCurso" maxlength="45" placeholder="R$ 1,000.00">
					</div>

					<div class="form-group col-md-6">
						<label for="numVagas">Número de vagas</label> 
						<input type="number" class="form-control" name="numVagasCurso" id="numVagasCurso" required maxlength="45" placeholder="Número de vagas">
					</div>
				</div>

				<hr />
				<div id="actions" class="row">
					<div class="col-md-12">
						<button type="submit" class="btn btn-primary" name="acao" value="Criar">Salvar</button>
						<a href="ListarCursos.jsp" class="btn btn-default">Cancelar</a>
					</div>
				</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script>
		if (top.location != location) {
			top.location.href = document.location.href;
		}
		$(function() {
			window.prettyPrint && prettyPrint();
			$('#dataIniCurso').datepicker({
				format : 'dd/mm/yyyy'
			
			});
			$('#dataFimCurso').datepicker({
				format : 'dd/mm/yyyy'
			});
	
			var startDate = new Date(2012, 1, 20);
			var endDate = new Date(2012, 1, 25);

			// disabling dates
			var nowTemp = new Date();
			var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(),
					nowTemp.getDate(), 0, 0, 0, 0);

			var checkin = $('#dataIniCurso').datepicker({
				onRender : function(date) {
					return date.valueOf() < now.valueOf() ? 'disabled' : '';
				}
			}).on('changeDate', function(ev) {
				if (ev.date.valueOf() > checkout.date.valueOf()) {
					var newDate = new Date(ev.date)
					newDate.setDate(newDate.getDate() + 1);
					checkout.setValue(newDate);
				}
				checkin.hide();
				$('#dataFimCurso')[0].focus();
			}).data('datepicker');
			var checkout = $('#dataFimCurso')
					.datepicker(
							{
								onRender : function(date) {
									return date.valueOf() <= checkin.date
											.valueOf() ? 'disabled' : '';
								}
							}).on('changeDate', function(ev) {
						checkout.hide();
					}).data('datepicker');
		});
	</script>
</body>

</html>