package br.com.wanclaybarreto.relitensvenda.infrastructure.web.controller;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;

import br.com.wanclaybarreto.relitensvenda.domain.cliente.Cliente;
import br.com.wanclaybarreto.relitensvenda.domain.cliente.ClienteRepository;

public class ControllerHelper {
	
	public static void setResultMode(Model model, boolean haveResult) {
		model.addAttribute("resultMode", haveResult);
	}
	
	public static void addClientesToRequest(Model model, ClienteRepository clienteRepository) {
		List<Cliente> clientes = clienteRepository.findAll(Sort.by("nome"));
		model.addAttribute("clientes", clientes);
	}
	
}
