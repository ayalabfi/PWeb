<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<c:import url="/common/header.jsp" />
<body>
	<div class="container-fluid">
		<c:import url="/common/title.jsp" />
		<div class="row">
			<c:import url="/common/sidebar.jsp" />
			<div class="col-9">
				<div class="container">
					<div class="row">
						<div class="col-12">
							<h3 style="color:#C37106">Carrinho de compras</h3>
						</div>
					</div>
				</div>
				<table class="table table-bordered table-hover table-striped">
					<thead class="thead thead-dark">
						<tr>
							<th class="text-center align-middle">Nome</th>
							<th class="text-center align-middle">Preço</th>
							<th class="text-center align-middle">Imagem</th>
							<th />
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ cart }" var="roupa" varStatus="index">
							<tr>
								<td class="text-center align-middle">${ roupa.nome }</td>
								<td class="text-center align-middle"><fmt:formatNumber
										value="${roupa.preco }" type="currency" currencySymbol="R$" /></td>
								<td class="text-center align-middle"><img
									style="width: 10vw; height: auto"
									src="assets/img/catalogo/${ roupa.nomeImagem }"></td>
								<td class="text-center align-middle">
									<form method="post">
										<button class="btn btn-secondary" name="remover" value="${index.count }">remover</button>
									</form>
								</td>
							</tr>

						</c:forEach>
					</tbody>
					<tfoot class="bg-dark text-light">
						<tr>
							<th />
							<th />
							<th class="text-center align-middle">Total</th>
							<th class="text-center align-middle"><fmt:formatNumber
									value="${ total }" type="currency" currencySymbol="R$" /></th>
						</tr>
					</tfoot>

				</table>
			</div>
		</div>
	</div>
	<c:import url="/common/footer.jsp" />
</body>
</html>