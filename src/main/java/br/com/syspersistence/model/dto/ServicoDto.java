package br.com.syspersistence.model.dto;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.syspersistence.interfaces.DtoConverter;
import br.com.syspersistence.model.Servico;

@Component
public class ServicoDto implements Serializable, DtoConverter<Servico>{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;
	
	private String descricao;
	
	@Autowired
	private EmpresaDto empresa;
	
	public ServicoDto() {
		
	}
	
	public ServicoDto(Servico servico){
		converter(servico); 
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public EmpresaDto getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDto empresa) {
		this.empresa = empresa;
	}

	@Override
	public void converter(Servico servico) {
		this.id = servico.getId();
		this.nome = servico.getNome();
		this.descricao = servico.getDescricao();
		this.empresa.converter(servico.getEmpresa());
	}

	
}
