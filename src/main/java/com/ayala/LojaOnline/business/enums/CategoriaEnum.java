package com.ayala.LojaOnline.business.enums;

public enum CategoriaEnum {

	// Criando objetos de forma privada
	ROUPA_MASCULINA("Roupa Masculina", 0), ROUPA_FEMININA("Roupa Feminina", 1), ROUPA_INFANTIL("Roupa Infantil", 2);

	private String nome;
	private Integer codigo;

	// Construtor Enum
	private CategoriaEnum(String nome, Integer codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public Integer getCodigo() {
		return codigo;
	}
}
