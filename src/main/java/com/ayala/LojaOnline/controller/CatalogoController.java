package com.ayala.LojaOnline.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ayala.LojaOnline.business.bean.CatalogoBean;
import com.ayala.LojaOnline.business.bean.RoupaBean;
import com.ayala.LojaOnline.business.enums.CategoriaEnum;


/**
 * Servlet implementation class CatalogoController
 */
@WebServlet("/catalogo")
public class CatalogoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CatalogoBean catalogoBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CatalogoController() {
		super();

		catalogoBean = new CatalogoBean();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//recupera os valores do select do front
		String[] codigosCategoria = request.getParameterValues("categoria");
		// envia as roupas do catalogo para o front
		request.setAttribute("roupas", catalogoBean.getRoupasFiltradas(codigosCategoria));
		request.setAttribute("categorias", CategoriaEnum.values());

		// quando clicou em adicionar
		if (request.getParameter("adicionar") != null) {
			HttpSession session = request.getSession();
// Verifica se existe um cart e cria um, caso contrario
			if (session.getAttribute("cart") == null) {
// Caso não exista uma lista de compras, cria uma
				List<RoupaBean> cart = new ArrayList<>();
				session.setAttribute("cart", cart);

			}
			// Recupera a lista de compras
			List<RoupaBean> cart = (List<RoupaBean>)session.getAttribute("cart");
			
			// Identifica qual roupa o usuário clicou pelo código da roupa
			String codigoString = request.getParameter("adicionar");
	Integer codigo = Integer.parseInt(codigoString);
	//Percorre todas as roupas e procura aquela com o código igual, adicionando ao carrinho
	List<RoupaBean> todasAsRoupas = catalogoBean.getRoupas();
	for (RoupaBean roupa : todasAsRoupas) {
		if (roupa.getCodigo().equals(codigo)) {
			cart.add(roupa);
		}
	}
	
	
		}

//envia o atributo titulo para a pagina JSP
		String titulo = "Confira nossas ofertas!";
		request.setAttribute("titulo", titulo);
//envia a pagina jsp na requisição
		request.getRequestDispatcher("/catalogo.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
