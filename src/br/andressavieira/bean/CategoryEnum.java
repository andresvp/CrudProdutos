package br.andressavieira.bean;

public enum CategoryEnum {
	
	ELETRONICOS("Eletr�nicos"),LIVROS("Livros"), MUSICA("M�sica"), 
	ACESSORIOS("Acess�rios"), CELULARES("Celulares"), OUTROS("Outros");
	
	private String descricao;

	private CategoryEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getValue() {
		return descricao;
	}

}
