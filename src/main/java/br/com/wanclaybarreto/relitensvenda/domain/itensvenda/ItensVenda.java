package br.com.wanclaybarreto.relitensvenda.domain.itensvenda;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.wanclaybarreto.relitensvenda.domain.produto.Produto;
import br.com.wanclaybarreto.relitensvenda.domain.venda.Venda;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "itensvenda")
public class ItensVenda implements Serializable {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id; 
	
	@Column(name = "quantidade")
	private BigDecimal quantidade;
	
	@Column(name = "valortotal")
	private BigDecimal valorTotal;
	
	@Column(name = "acrescimo")
	private BigDecimal acrescimo;
	
	@Column(name = "desconto")
	private BigDecimal desconto;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "datavenda")
	private LocalDate dataVenda;
	
	@ManyToOne
	@JoinColumn(name = "id_item")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "id_venda")
	private Venda venda;
	
}
