package br.com.syspersistence.model.dto;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.syspersistence.interfaces.DtoConverter;
import br.com.syspersistence.model.Endereco;

public class EnderecoDto implements Serializable, DtoConverter<Endereco>{

	private static final long serialVersionUID = 1L;
	private String cep;
	private Long id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidadeUf;
	
	@Autowired
	private EmpresaDto empresa;

	public EnderecoDto(){
		
	}
	
	public EnderecoDto(Endereco endereco){
		converter(endereco);
	}
	
	
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidadeUf() {
		return cidadeUf;
	}

	public void setCidadeUf(String cidadeUf) {
		this.cidadeUf = cidadeUf;
	}

	public EmpresaDto getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDto empresa) {
		this.empresa = empresa;
	}

	@Override
	public void converter(Endereco endereco) {
		id = endereco.getId();
		cep = endereco.getCep();
		logradouro = endereco.getLogradouro();
		numero = endereco.getNumero();
		complemento = endereco.getComplemento();
		bairro = endereco.getBairro();
		cidadeUf = endereco.getCidadeUf();
		empresa.converter(endereco.getEmpresa());
	}

}
