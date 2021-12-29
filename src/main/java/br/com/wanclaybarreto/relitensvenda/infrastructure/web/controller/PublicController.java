package br.com.wanclaybarreto.relitensvenda.infrastructure.web.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.wanclaybarreto.relitensvenda.application.service.ItensVendaService;
import br.com.wanclaybarreto.relitensvenda.domain.cliente.Cliente;
import br.com.wanclaybarreto.relitensvenda.domain.cliente.ClienteRepository;
import br.com.wanclaybarreto.relitensvenda.domain.itensvenda.ItensVenda;

@Controller
public class PublicController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ItensVendaService itensVendaService;
	
	@GetMapping(path = {"/", "/public/relatorio"})
	public String relatorio(Model model) {
		
		ControllerHelper.setResultMode(model, false);
		ControllerHelper.addClientesToRequest(model, clienteRepository);
		
		return "relatorio";
		
	}
	
	@GetMapping("/public/relatorio/create")
	public String createRelatorio(Model model, @RequestParam("id-cliente") Integer idCliente, @RequestParam("data-in") String dataIn, @RequestParam("data-fin") String dataFin) {
		
		if (dataIn.trim().isEmpty()) dataIn = "0001-01-01";
		if (dataFin.trim().isEmpty()) dataFin = "9999-12-31";
		
		LocalDate ldDataIn  = LocalDate.parse(dataIn, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate ldDataFin = LocalDate.parse(dataFin, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		String[] dataInSplit  = dataIn.split("-");
		String[] dataFinSplit = dataFin.split("-");
		
		Map<String, Object> params = new HashMap<>();
		
		params.put("PERIODO_DATA_IN", dataInSplit[2] + "/" + dataInSplit[1] + "/" + dataInSplit[0]);
		params.put("PERIODO_DATA_FIN", dataFinSplit[2] + "/" + dataFinSplit[1] + "/" + dataFinSplit[0]);
		
		Cliente cliente = null;
		
		if (idCliente > 0) cliente = clienteRepository.findById(idCliente).orElseThrow();
		
		List<ItensVenda> listItensVenda;
		
		if (cliente != null) {
			listItensVenda = itensVendaService.getItensVendaByClienteAndPeriodo(cliente, ldDataIn, ldDataFin);
			params.put("CLIENTE", cliente.getId() + " - " + cliente.getNome());
		} else {
			listItensVenda = itensVendaService.getItensVendaByPeriodo(ldDataIn, ldDataFin);
			params.put("CLIENTE", "Todos");
		}
		
		itensVendaService.generateReport(params, listItensVenda);
		
		ControllerHelper.setResultMode(model, true);
		ControllerHelper.addClientesToRequest(model, clienteRepository);
		return "relatorio";
		
	}
	
}
