package br.com.syspersistence.converter;

import javax.money.MonetaryAmount;
import javax.money.format.MonetaryAmountFormat;

import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class ValorSpringConverter implements Converter<String, MonetaryAmount> {

	@Autowired
	private MonetaryAmountFormat formatter;
	
	@Override
	public MonetaryAmount convert(String valor) {
		return Money.parse(valor, formatter);
	}

	

}
