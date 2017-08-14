package br.com.syspersistence;

import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SyspersisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyspersisterApplication.class, args);
	}
	
	@Bean
	public CurrencyUnit currencyUnit() {
		CurrencyUnit unit = Monetary.getCurrency("BRL");
		return unit;
	}
	
	@Bean
	public MonetaryAmountFormat monetaryFormatter() {
		return MonetaryFormats.getAmountFormat(new Locale("pt","BR"));
	}
	
}
