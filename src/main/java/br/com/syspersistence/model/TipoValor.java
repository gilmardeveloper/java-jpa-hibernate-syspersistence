package br.com.syspersistence.model;

public enum TipoValor {
	
	CUSTO			(new String("PREÇO DE CUSTO")),
	COMERCIAL		(new String("PREÇO COMERCIAL")),
	PROMOCIONAL		(new String("PREÇO PROMOCIONAL")),
	COM_DESCONTO	(new String("PREÇO COM DESCONTO"));
	
	private String valor;

	private TipoValor(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}

}
