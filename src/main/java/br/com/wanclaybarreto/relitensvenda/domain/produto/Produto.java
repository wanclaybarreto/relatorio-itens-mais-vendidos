package br.com.wanclaybarreto.relitensvenda.domain.produto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.wanclaybarreto.relitensvenda.domain.itensvenda.ItensVenda;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "produto")
public class Produto implements Serializable {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "codigointerno")
	private String codigoInterno;
	
	@Column(name = "ean")
	private String ean;
	
	@Column(name = "un")
	private String unidade;
	
	@OneToMany(mappedBy = "produto")
	private Set<ItensVenda> itens = new HashSet<>(0);
	
}
