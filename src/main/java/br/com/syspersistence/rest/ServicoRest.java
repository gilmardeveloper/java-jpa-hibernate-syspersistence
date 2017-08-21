package br.com.syspersistence.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.syspersistence.model.dto.PrecoDto;
import br.com.syspersistence.model.dto.ServicoDto;
import br.com.syspersistence.repository.PrecoRepository;
import br.com.syspersistence.repository.ServicoRepository;

@RestController
@RequestMapping("rs/")
public class ServicoRest {

	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private ServicoDto servicoDto;
	
	@Autowired
	private PrecoRepository precoRepository;
	
	@Autowired
	private PrecoDto precoDto;
	
	@GetMapping("servico/{id}/adicionar/valor")
	public ServicoDto adicionarValor(@PathVariable("id") long id) {

		servicoDto.converter(servicoRepository.findServico(id));
		return servicoDto;
	}
	
	@GetMapping("servico/{id}/alterar")
	public ServicoDto alterarServico(@PathVariable("id") long id) {
		
		servicoDto.converter(servicoRepository.findServico(id));
		return servicoDto;
	}
	
	@GetMapping("servico/valor/{id}")
	public PrecoDto buscarValor(@PathVariable("id") long id) {
		
		precoDto.converter(precoRepository.findOne(id));
		return precoDto;
	}

}
