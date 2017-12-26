package br.andressavieira.bean;

public enum CategoryEnum {
	
	ELETRONICOS("Eletrônicos"),LIVROS("Livros"), MUSICA("Música"), 
	ACESSORIOS("Acessórios"), CELULARES("Celulares"), OUTROS("Outros");
	
	private String descricao;

	private CategoryEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getValue() {
		return descricao;
	}

}
