package br.com.wanclaybarreto.relitensvenda.domain.itensvenda;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.wanclaybarreto.relitensvenda.domain.cliente.Cliente;

public interface ItensVendaRepository extends JpaRepository<ItensVenda, Integer> {
	
	@Query("select "
			+ "iv, sum(iv.quantidade) as quant " +
		   "from "
		    + "ItensVenda iv " +
		   "where "
		    + "iv.dataVenda between ?1 and ?2 " +
		   "group by "
		    + "iv.produto " +
		   "order by "
		    + "quant desc, iv.produto")
	public List<ItensVenda> findAllByPeriodo(LocalDate dataIn, LocalDate dataFin);
	
	@Query("select "
			+ "sum(iv.quantidade) as quant " +
		   "from "
		    + "ItensVenda iv " +
		   "where "
		    + "iv.dataVenda between ?1 and ?2 " +
		   "group by "
		    + "iv.produto " +
		   "order by "
		    + "quant desc, iv.produto")
	public List<BigDecimal> findSumQuantByPeriodo(LocalDate dataIn, LocalDate dataFin);
	
	@Query("select "
			+ "sum(iv.valorTotal) as valorTotal " +
		   "from "
		    + "ItensVenda iv " +
		   "where "
		    + "iv.dataVenda between ?1 and ?2 " +
		   "group by "
		    + "iv.produto " +
		   "order by "
		    + "sum(iv.quantidade) desc, iv.produto")
	public List<BigDecimal> findSumValorTotalByPeriodo(LocalDate dataIn, LocalDate dataFin);
	
	@Query("select "
			+ "sum(iv.acrescimo) as acrescimo " +
		   "from "
		    + "ItensVenda iv " +
		   "where "
		    + "iv.dataVenda between ?1 and ?2 " +
		   "group by "
		    + "iv.produto " +
		   "order by "
		    + "sum(iv.quantidade) desc, iv.produto")
	public List<BigDecimal> findSumAcrescimoByPeriodo(LocalDate dataIn, LocalDate dataFin);
	
	@Query("select "
			+ "sum(iv.desconto) as desconto " +
		   "from "
		    + "ItensVenda iv " +
		   "where "
		    + "iv.dataVenda between ?1 and ?2 " +
		   "group by "
		    + "iv.produto " +
		   "order by "
		    + "sum(iv.quantidade) desc, iv.produto")
	public List<BigDecimal> findSumDescontoByPeriodo(LocalDate dataIn, LocalDate dataFin);
	
	@Query("select "
			+ "iv, sum(iv.quantidade) as quant " +
		   "from "
		    + "ItensVenda iv inner join iv.venda cv " +
		   "where "
		    + "cv.cliente = ?1 and iv.dataVenda between ?2 and ?3 " +
		   "group by "
		    + "iv.produto " +
		   "order by "
		    + "quant desc, iv.produto")
	public List<ItensVenda> findAllByClienteAndPeriodo(Cliente cliente, LocalDate dataIn, LocalDate dataFin);
	
	@Query("select "
			+ "sum(iv.quantidade) as quant " +
		   "from "
		    + "ItensVenda iv inner join iv.venda cv " +
		   "where "
		    + "cv.cliente = ?1 and iv.dataVenda between ?2 and ?3 " +
		   "group by "
		    + "iv.produto " +
		   "order by "
		    + "quant desc, iv.produto")
	public List<BigDecimal> findSumQuantByClienteAndPeriodo(Cliente cliente, LocalDate dataIn, LocalDate dataFin);
	
	@Query("select "
			+ "sum(iv.valorTotal) as valorTotal " +
		   "from "
		    + "ItensVenda iv inner join iv.venda cv " +
		   "where "
		    + "cv.cliente = ?1 and iv.dataVenda between ?2 and ?3 " +
		   "group by "
		    + "iv.produto " +
		   "order by "
		    + "sum(iv.quantidade) desc, iv.produto")
	public List<BigDecimal> findSumValorTotalByClienteAndPeriodo(Cliente cliente, LocalDate dataIn, LocalDate dataFin);
	
	@Query("select "
			+ "sum(iv.acrescimo) as acrescimo " +
		   "from "
		    + "ItensVenda iv inner join iv.venda cv " +
		   "where "
		    + "cv.cliente = ?1 and iv.dataVenda between ?2 and ?3 " +
		   "group by "
		    + "iv.produto " +
		   "order by "
		    + "sum(iv.quantidade) desc, iv.produto")
	public List<BigDecimal> findSumAcrescimoByClienteAndPeriodo(Cliente cliente, LocalDate dataIn, LocalDate dataFin);
	
	@Query("select "
			+ "sum(iv.desconto) as desconto " +
		   "from "
		    + "ItensVenda iv inner join iv.venda cv " +
		   "where "
		    + "cv.cliente = ?1 and iv.dataVenda between ?2 and ?3 " +
		   "group by "
		    + "iv.produto " +
		   "order by "
		    + "sum(iv.quantidade) desc, iv.produto")
	public List<BigDecimal> findSumDescontoByClienteAndPeriodo(Cliente cliente, LocalDate dataIn, LocalDate dataFin);
	
}
