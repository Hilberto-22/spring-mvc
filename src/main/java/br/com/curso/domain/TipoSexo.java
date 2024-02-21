package br.com.curso.domain;

public enum TipoSexo {

	MASCULINO('M'),FEMININO('F');
	
	private char descricao;

	TipoSexo(char descricao) {
		this.descricao = descricao;
	}

	public char getDescricao() {
		return descricao;
	}
	
	public void setDescricao(char descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
