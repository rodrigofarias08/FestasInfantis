package br.senai.sc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tema implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ElementCollection
	@CollectionTable(name="ITENS")
	private List<String> itens = new ArrayList<>();
	
	private String cor_toalha;
	private Double preco;
	
	@OneToMany(mappedBy="tema")
	private List<Festa> festas = new ArrayList<Festa>();

	public Tema() {
		super();
	}

	public Tema(Integer id, List<String> itens, String cor_toalha, Double preco) {
		super();
		this.id = id;
		this.itens = itens;
		this.cor_toalha = cor_toalha;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getItens() {
		return itens;
	}

	public void setItens(List<String> itens) {
		this.itens = itens;
	}

	public String getCor_toalha() {
		return cor_toalha;
	}

	public void setCor_toalha(String cor_toalha) {
		this.cor_toalha = cor_toalha;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Festa> getFestas() {
		return festas;
	}

	public void setFestas(List<Festa> festas) {
		this.festas = festas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tema other = (Tema) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
