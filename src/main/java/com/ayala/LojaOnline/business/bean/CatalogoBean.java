package com.ayala.LojaOnline.business.bean;

import java.util.ArrayList;
import java.util.List;

import com.ayala.LojaOnline.business.enums.CategoriaEnum;

public class CatalogoBean {

	private List<RoupaBean> roupas;

	public CatalogoBean() {
		roupas = new ArrayList<>();

// Inicia a lista de roupas com algumas roupas
		roupas.add(novaRoupa("Camisa", CategoriaEnum.ROUPA_MASCULINA, 49.90f, "Camisa.jpg"));
		roupas.add(novaRoupa("Calça", CategoriaEnum.ROUPA_MASCULINA, 99.90f, "Calça.jpg"));
		roupas.add(novaRoupa("Paletó", CategoriaEnum.ROUPA_MASCULINA, 299.90f, "Paleto.jpg"));
		roupas.add(novaRoupa("Short", CategoriaEnum.ROUPA_FEMININA, 39.90f, "Short.jpg"));
		roupas.add(novaRoupa("Vestido curto", CategoriaEnum.ROUPA_FEMININA, 199.90f, "VCurto.jpg"));
		roupas.add(novaRoupa("Vestido longo", CategoriaEnum.ROUPA_FEMININA, 89.90f, "VLongo.jpg"));
		roupas.add(novaRoupa("Camiseta", CategoriaEnum.ROUPA_INFANTIL, 59.90f, "Camiseta.jpg"));

	}

// função auxiliar para criar novas roupas
	private RoupaBean novaRoupa(String nome, CategoriaEnum categoriaEnum, float preco, String nomeImagem) {

		// calcula o tamanho pela quantidade de itens da lista
		Integer codigo = roupas.size();
		RoupaBean roupaBean = new RoupaBean();
		roupaBean.setCodigo(codigo);
		roupaBean.setNome(nome);
		roupaBean.setCodigoCategoria(categoriaEnum.getCodigo());
		roupaBean.setCategoria(categoriaEnum.getNome());
		roupaBean.setPreco(preco);
		roupaBean.setNomeImagem(nomeImagem);

		return roupaBean;
	}

	public List<RoupaBean> getRoupas() {
		return roupas;
	}

	public void setRoupas(List<RoupaBean> roupas) {
		this.roupas = roupas;
	}

//retorna roupas filtradas de acordo com um código (informado pelo navegador)
	public List<RoupaBean> getRoupasFiltradas(String[] codigosCategoria) {

		// Pessoa não selecionou categorias = retorno geral
		if (codigosCategoria == null) {
			return roupas;
		}

		List<RoupaBean> roupasFiltradas = new ArrayList<>();

		// criando uma lista de inteiros
		List<Integer> codigos = new ArrayList<>();
//Percorre aos codigos informados, converte para inteiro e adiciona a lista de codigos
		for (String codigoCategoria : codigosCategoria) {
			codigos.add(Integer.parseInt(codigoCategoria));
		}

//compara o codigo da roupa com o da solicitação
		for (RoupaBean roupa : roupas) {
			if (codigos.contains(roupa.getCodigoCategoria())) {
				roupasFiltradas.add(roupa);
			}
		}
		return roupasFiltradas;
	}
}
