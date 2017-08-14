package br.com.syspersistence.interfaces;

public interface DtoConverter<T> {

	void converter(T entityClass);
	
}
