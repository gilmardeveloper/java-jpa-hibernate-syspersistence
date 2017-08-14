package br.com.syspersistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.syspersistence.model.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Long>{

	Empresa findById(Long id);
	
	Empresa findByCnpj(String cnpj);
	
	@Query("select e from Empresa e")
	List<Empresa> listAll();
	
}
