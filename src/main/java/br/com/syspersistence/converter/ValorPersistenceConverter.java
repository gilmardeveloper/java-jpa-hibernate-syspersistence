package br.com.syspersistence.converter;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;

@Converter(autoApply = true)
public class ValorPersistenceConverter implements AttributeConverter<MonetaryAmount, Double> {
	
	@Autowired
	private CurrencyUnit unit;
	
	@Override
	public Double convertToDatabaseColumn(MonetaryAmount preco) {
		return preco.getNumber().doubleValueExact();
	}
	

	@Override
	public MonetaryAmount convertToEntityAttribute(Double preco) {
		MonetaryAmount monetary = Money.of(BigDecimal.valueOf(preco), unit);
		return monetary;
	}
	
}
