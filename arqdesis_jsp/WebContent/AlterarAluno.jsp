<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Faculdade - Alterar Aluno</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <jsp:useBean id="aluno" class="to.AlunoTO" scope="request" />
    	<!-- Modal -->
	<div class="modal fade" id="alterar-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Alteração de Dados</h4>
				</div>
					<div class="modal-body">Dados do Aluno alterado com sucesso!</div>
				</div>
			</div>
		</div>
	<!-- /.modal -->
    
    <!-- Barra superior com os menus de navegação -->
    <c:import url="menu.jsp" />
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Alterar Aluno #${aluno.id }</h3>
        <!-- Formulario para alteração de clientes -->
        <form action="ManterAluno.do" method="post">
            <!-- area de campos do form -->
            <input type="hidden" name="id" value="${aluno.id}" />
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="nome">CPF</label>
                    <input type="text" class="form-control" name="cpf" id="cpf" required maxlength="11" placeholder="CPF" value="${aluno.cpf }">
                </div>
                
                <div class="form-group col-md-6">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="240" placeholder="nome completo" value="${aluno.nome }">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="nome">RG</label>
                    <input type="text" class="form-control" name="rg" id="rg" required maxlength="9" placeholder="RG" value="${aluno.rg }">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="fone">Telefone</label>
                    <input type="tel" class="form-control" name="telefone" id="telefone" maxlength="11" pattern="(?:\(\d{2}\)|\d{2})[- ]?\d{5}[- ]?\d{4}" placeholder="opcional; celular com ddd no formato (99) 99999-9999" value="${aluno.telefone }">
                </div>

                <div class="form-group col-md-6">
                    <label for="email">E-mail</label>
                    <input type="email" class="form-control" name="email" id="email" required maxlength="150" placeholder="email obrigatório" value="${aluno.email }">
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="acao" data-target="#alterar-modal" value="Alterar">Salvar</button>
                    <a href="listar_alunos.do" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>