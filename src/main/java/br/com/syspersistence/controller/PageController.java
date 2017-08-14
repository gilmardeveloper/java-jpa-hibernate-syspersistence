package br.com.syspersistence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.syspersistence.model.Servico;
import br.com.syspersistence.repository.ServicoRepository;

@Controller
@RequestMapping("/")
public class PageController {

	@Autowired
	private ServicoRepository servicoRepository;

	@GetMapping
	public String index(Model model) {

		List<Servico> servicos = servicoRepository.listAll();

		if (!servicos.isEmpty())
			model.addAttribute("servicos", servicos);

		return "index";
	}

}
