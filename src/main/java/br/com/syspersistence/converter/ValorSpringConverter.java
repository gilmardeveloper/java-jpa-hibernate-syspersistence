package br.com.syspersistence.converter;

import javax.money.MonetaryAmount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class ValorSpringConverter implements Converter<String, MonetaryAmount> {

	@Autowired
	private ValorConverter converter;
	
	@Override
	public MonetaryAmount convert(String valor) {
		return converter.toMoney(valor);
	}


}
