package br.com.syspersistence.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.syspersistence.model.dto.ServicoDto;
import br.com.syspersistence.repository.ServicoRepository;

@RestController
@RequestMapping("rs/")
public class ServicoRest {

	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private ServicoDto servicoDto;

	@GetMapping("servico/{id}/adicionar/valor")
	public ServicoDto adicionarValor(@PathVariable("id") long id) {

		servicoDto.converter(servicoRepository.findServico(id));
		return servicoDto;
	}

}
