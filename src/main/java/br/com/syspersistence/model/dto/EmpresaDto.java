package br.com.syspersistence.model.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import br.com.syspersistence.interfaces.DtoConverter;
import br.com.syspersistence.model.Empresa;

@Component
public class EmpresaDto implements Serializable, DtoConverter<Empresa>{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cnpj;
	private String nome;
	private String ie;
	private String telefone;
		
	
	public EmpresaDto() {
		
	}

	public EmpresaDto(Empresa empresa) {
		converter(empresa);		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public void converter(Empresa empresa) {
		id = empresa.getId();
		cnpj = empresa.getCnpj();
		nome = empresa.getNome();
		ie = empresa.getIe();
		telefone = empresa.getTelefone();	
	}
	
	

}
