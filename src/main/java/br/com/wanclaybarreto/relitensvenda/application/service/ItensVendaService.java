package br.com.wanclaybarreto.relitensvenda.application.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.wanclaybarreto.relitensvenda.domain.cliente.Cliente;
import br.com.wanclaybarreto.relitensvenda.domain.itensvenda.ItensVenda;
import br.com.wanclaybarreto.relitensvenda.domain.itensvenda.ItensVendaRepository;
import br.com.wanclaybarreto.relitensvenda.util.ReportsUtils;

@Service
public class ItensVendaService {
	
	@Autowired
	private ItensVendaRepository itensVendaRepository;
	
	@Value("${relitensvenda.files.itensvenda.relatorios}")
	private String dirRelatorios;
	
	@Value("${relitensvenda.files.itensvenda.relatorios.modelo}")
	private String dirJasperFile;
	
	public List<ItensVenda> getItensVendaByPeriodo(LocalDate dataIn, LocalDate dataFin) {
		
		List<ItensVenda> ivs = itensVendaRepository.findAllByPeriodo(dataIn, dataFin);
		
		List<BigDecimal> ivsSumQuant  = itensVendaRepository.findSumQuantByPeriodo(dataIn, dataFin);
		List<BigDecimal> ivsSumVlrTot = itensVendaRepository.findSumValorTotalByPeriodo(dataIn, dataFin);
		List<BigDecimal> ivsSumAcres  = itensVendaRepository.findSumAcrescimoByPeriodo(dataIn, dataFin);
		List<BigDecimal> ivsSumDesc   = itensVendaRepository.findSumDescontoByPeriodo(dataIn, dataFin);
		
		for (int i = 0; i < ivs.size(); i++) {
			ivs.get(i).setQuantidade(ivsSumQuant.get(i));
			ivs.get(i).setValorTotal(ivsSumVlrTot.get(i));
			ivs.get(i).setAcrescimo(ivsSumAcres.get(i));
			ivs.get(i).setDesconto(ivsSumDesc.get(i));
		}
		
		return ivs;
		
	}
	
	public List<ItensVenda> getItensVendaByClienteAndPeriodo(Cliente cliente, LocalDate dataIn, LocalDate dataFin) {
		
		List<ItensVenda> ivs = itensVendaRepository.findAllByClienteAndPeriodo(cliente, dataIn, dataFin);
		
		List<BigDecimal> ivsSumQuant  = itensVendaRepository.findSumQuantByClienteAndPeriodo(cliente, dataIn, dataFin);
		List<BigDecimal> ivsSumVlrTot = itensVendaRepository.findSumValorTotalByClienteAndPeriodo(cliente, dataIn, dataFin);
		List<BigDecimal> ivsSumAcres  = itensVendaRepository.findSumAcrescimoByClienteAndPeriodo(cliente, dataIn, dataFin);
		List<BigDecimal> ivsSumDesc   = itensVendaRepository.findSumDescontoByClienteAndPeriodo(cliente, dataIn, dataFin);
		
		for (int i = 0; i < ivs.size(); i++) {
			ivs.get(i).setQuantidade(ivsSumQuant.get(i));
			ivs.get(i).setValorTotal(ivsSumVlrTot.get(i));
			ivs.get(i).setAcrescimo(ivsSumAcres.get(i));
			ivs.get(i).setDesconto(ivsSumDesc.get(i));
		}
		
		return ivs;
		
	}
	
	public void generateReport(Map<String, Object> params, List<ItensVenda> listItensVenda) {
		ReportsUtils.generateReportPDF(dirJasperFile, params, listItensVenda, dirRelatorios+"/historico-de-compras.pdf");
	}
	
}
