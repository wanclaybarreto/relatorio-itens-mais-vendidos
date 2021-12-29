package br.com.wanclaybarreto.relitensvenda.domain.venda;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.wanclaybarreto.relitensvenda.domain.cliente.Cliente;
import br.com.wanclaybarreto.relitensvenda.domain.itensvenda.ItensVenda;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cabecalhovendas") //TODO REMOVER LINHA
public class Venda implements Serializable {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_venda")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@Column(name = "totalvenda")
	private BigDecimal totalVenda;
	
	@OneToMany(mappedBy = "venda")
	private Set<ItensVenda> itensVenda = new HashSet<>();
	
}
