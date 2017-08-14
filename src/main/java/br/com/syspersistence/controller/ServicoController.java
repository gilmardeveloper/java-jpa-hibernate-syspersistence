package br.com.syspersistence.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.syspersistence.model.Empresa;
import br.com.syspersistence.model.Preco;
import br.com.syspersistence.model.Servico;
import br.com.syspersistence.model.TipoValor;
import br.com.syspersistence.repository.EmpresaRepository;
import br.com.syspersistence.repository.PrecoRepository;
import br.com.syspersistence.repository.ServicoRepository;

@Controller
@RequestMapping("/servico")
public class ServicoController {

	@Autowired
	private ServicoRepository servicoRepository;

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private PrecoRepository valorRepository;
	

	@GetMapping
	public String servico(Servico servico, Model model) {

		List<Empresa> empresas = empresaRepository.listAll();
		List<Servico> servicos = servicoRepository.listAll();
		model.addAttribute("tipos", Arrays.asList(TipoValor.values()));
		
		if (!empresas.isEmpty()) {
			model.addAttribute("empresa", empresas.get(0));
			if (!servicos.isEmpty()) {
				model.addAttribute("servicos", servicos);
			}
		}
		
		return "servico";
	}
	
	@PostMapping("/salvar")
	public String salvar(Servico servico, Model model) {
		
		servicoRepository.save(servico);
		return "redirect:/servico";
	}
	
	@PostMapping("valor/salvar")
	public String valorSalvar(Preco preco) {
				
		valorRepository.save(preco);
		return "redirect:/servico";
	}
	
}
