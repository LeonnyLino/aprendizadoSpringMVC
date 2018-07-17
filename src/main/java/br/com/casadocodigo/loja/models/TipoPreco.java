package br.com.casadocodigo.loja.models;

public enum TipoPreco {
	ebook("ebook"), impresso("impresso"), combo("combo");
	
	private String tipo;
	
	private TipoPreco(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
}
