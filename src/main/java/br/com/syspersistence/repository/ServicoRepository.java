package br.com.syspersistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.syspersistence.model.Servico;

public interface ServicoRepository extends CrudRepository<Servico, Long> {
	
	@Query("select s from Servico s")
	List<Servico> listAll();
	
	@Query("select s from Servico s where id = :id")
	Servico findServico(@Param("id") Long id);

}
