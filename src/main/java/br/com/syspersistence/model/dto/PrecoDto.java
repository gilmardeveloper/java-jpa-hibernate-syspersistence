package br.com.syspersistence.model.dto;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.syspersistence.interfaces.DtoConverter;
import br.com.syspersistence.model.Preco;
import br.com.syspersistence.model.TipoValor;

@Component
public class PrecoDto implements Serializable, DtoConverter<Preco>{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String valor;
	private TipoValor tipo;
	
	@Autowired
	private ServicoDto servico;
	
	public PrecoDto(){
		
	}
	
	public PrecoDto(Preco preco) {
		servico = new ServicoDto();
		converter(preco);
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public TipoValor getTipo() {
		return tipo;
	}

	public void setTipo(TipoValor tipo) {
		this.tipo = tipo;
	}
	

	public ServicoDto getServico() {
		return servico;
	}

	public void setServico(ServicoDto servico) {
		this.servico = servico;
	}

	@Override
	public void converter(Preco preco) {
		this.id = preco.getId();
		this.valor = preco.getValorFormatado();
		this.tipo = preco.getTipo();
		this.servico.converter(preco.getServico());
	}
	
	
	
}
