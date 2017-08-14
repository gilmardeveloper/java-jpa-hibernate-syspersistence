package br.com.syspersistence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.syspersistence.model.Empresa;
import br.com.syspersistence.model.Endereco;
import br.com.syspersistence.repository.EmpresaRepository;
import br.com.syspersistence.repository.EnderecoRepository;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@GetMapping
	public String empresa(Model model) {
		List<Empresa> empresas = empresaRepository.listAll();

		if (!empresas.isEmpty()) {
			model.addAttribute("empresa", empresas.get(0));
			model.addAttribute("endereco", empresas.get(0).getEndereco());
		}
		return "empresa";
	}

	@PostMapping("/salvar")
	public String salvar(Empresa empresa) {

		empresaRepository.save(empresa);
		return "redirect:/empresa";
	}

	@PostMapping("endereco/salvar")
	public String enderecoSalvar(Endereco endereco) {
		
		enderecoRepository.save(endereco);
		return "redirect:/empresa";
	}

}
