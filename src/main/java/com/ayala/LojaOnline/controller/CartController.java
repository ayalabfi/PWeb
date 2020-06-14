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

import com.ayala.LojaOnline.business.bean.RoupaBean;

@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// Recupera o httpSession
		HttpSession session = request.getSession();
// Verifica se existe um cart e cria um, caso contrario
		if (session.getAttribute("cart") == null) {
// Caso não exista uma lista de compras, cria uma
			List<RoupaBean> cart = new ArrayList<>();
			session.setAttribute("cart", cart);

		}
		// Recupera a lista de compras
		List<RoupaBean> cart = (List<RoupaBean>) session.getAttribute("cart");
		
		//envia o cart para o front
		request.setAttribute("cart", cart);
		
		// Soma os valores e envia para o jsp
		Float total = 0f;
		for (RoupaBean roupa : cart) {
			total += roupa.getPreco();
		}
		request.setAttribute("total", total);

		// envia a pagina jsp na requisição
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Usuário clicou em remover
		String indexString = request.getParameter("remover");
		int index = Integer.parseInt(indexString) -1;
		//Recuperar o cart
		HttpSession session = request.getSession();
		List<RoupaBean> cart = (List<RoupaBean>) session.getAttribute("cart");
		
		cart.remove(index);
		
		
		doGet(request, response);
	}

}
