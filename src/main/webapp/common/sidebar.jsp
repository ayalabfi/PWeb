<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<div class="col-3 text-center">
<nav id="sidebar">
		<ul class="list-unstyled components">
			<li><a class="btn btn-dark btn-block m-1 text-danger" href="<c:url value="/index.jsp"/>">Inicio</a></li>
			<li><a class="btn btn-dark btn-block m-1 text-danger" href="<c:url value="/catalogo"/>">Catalogo</a></li>
						<li><a class="btn btn-dark btn-block m-1 text-danger" href="<c:url value="/cart"/>">Meu carrinho</a></li>
												<li><a class="btn btn-dark btn-block m-1 text-danger" href="<c:url value="/QuemSomosNos.jsp"/>">Quem Somos nós?</a></li>
		</ul>
		</nav>
	</div>