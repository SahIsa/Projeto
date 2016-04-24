<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Faculdade - Buscar Alunos</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>

<body>
    <!-- Modal -->
    <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="modalLabel">Excluir Aluno</h4>
                </div>
                <div class="modal-body">
                    Deseja realmente excluir este Aluno?
                </div>
                <div class="modal-footer">
                    <form action="ManterAluno.do" method="post">
                        <input type="hidden" name="id" id="id_excluir" />
                        <button type="submit" class="btn btn-primary" name="acao" value="Excluir">Sim</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- /.modal -->
    <!-- Barra superior com os menus de navegação -->
    <c:import url="menu.jsp" />
    <!-- Container Principal -->
    <div id="main" class="container">
        <form action="listar_alunos.do" method="post">
            <div id="top" class="row">
                <div class="col-md-3">
                    <h2>Alunos</h2>
                </div>

                <div class="col-md-6">
                    <div class="input-group h2">
                        <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Alunos (deixe vazio para trazer todos)">
                        <span class="input-group-btn">
        <button class="btn btn-primary" type="submit">
            <span class="glyphicon glyphicon-search"></span>
                        </button>
                        </span>
                    </div>
                </div>

                <div class="col-md-3">
                    <a href="CriarAluno.jsp" class="btn btn-primary pull-right h2">Novo Aluno</a>
                </div>
            </div>
            <!-- /#top -->
        </form>
        <hr />
        <jsp:useBean id="lista" class="to.ListaDeAlunos" scope="request" />
        <c:if test="${not empty lista}">
            <c:if test="${not empty lista.alunos}">
                <div id="list" class="row">
                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                	<th>ID</th>
                                    <th>CPF</th>
                                    <th>Nome</th>
                                    <th>RG</th>
                                    <th>E-mail</th>
                                    <th>Telefone</th>
                                    <th class="actions">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="aluno" items="${lista.alunos}">
                                    <tr>
                                        <td>
                                            ${aluno.id }
                                        </td>
                                        <td>
                                            ${aluno.cpf }
                                        </td>
                                        <td>
                                            ${aluno.nome }
                                        </td>
                                        <td>
                                            ${aluno.rg }
                                        </td>
                                        <td>
                                            ${aluno.email }
                                        </td>
                                        <td>
                                        	${aluno.telefone }
                                        </td>
                                        <td class="actions">
                                            <a class="btn btn-success btn-xs" href="ManterAluno.do?acao=Visualizar&id=${aluno.id }">Visualizar</a>
                                            <a class="btn btn-warning btn-xs" href="ManterAluno.do?acao=Editar&id=${aluno.id }">Editar</a>
                                            <button id="btn ${aluno.id }" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-aluno="${aluno.id }">Excluir</button>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>
                <!-- /#list -->

                <div id="bottom" class="row">
                    <div class="col-md-12">
                        <!-- paginação ainda não foi implementada -->
                        <ul class="pagination">
                            <li class="disabled"><a>&lt; Anterior</a>
                            </li>
                            <li class="disabled"><a>1</a>
                            </li>
                            <li><a href="#">2</a>
                            </li>
                            <li><a href="#">3</a>
                            </li>
                            <li class="next"><a href="#" rel="next">Próximo &gt;</a>
                            </li>
                        </ul>
                        <!-- /.pagination -->

                    </div>
                </div>
                <!-- /#bottom -->
            </c:if>
        </c:if>

    </div>


    <!-- /#main -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $("#delete-modal").on('show.bs.modal', function(event) {
            var button = $(event.relatedTarget); //botao que disparou a modal
            var recipient = button.data('aluno');
            $("#id_excluir").val(recipient);
        });
    </script>
</body>

</html>