package br.com.syspersistence.model;

import java.io.Serializable;

import javax.money.MonetaryAmount;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import br.com.syspersistence.converter.ValorConverter;

// <td th:text="${new java.text.DecimalFormat('$#,##0.00;$-#,##0.00').format(value)}" />

@Entity
public class Preco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TipoValor tipo;

	private MonetaryAmount valor;

	@OneToOne
	private Servico servico;

	@Transient
	private ValorConverter converter;

	public Preco() {
		this(new ValorConverter());
	}

	public Preco(ValorConverter converter) {
		this.converter = converter;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoValor getTipo() {
		return tipo;
	}

	public void setTipo(TipoValor tipo) {
		this.tipo = tipo;
	}

	public MonetaryAmount getValor() {
		return valor;
	}

	public void setValor(MonetaryAmount valor) {
		this.valor = valor;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public String getValorFormatado() {
		return converter.toString(valor);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Preco other = (Preco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
