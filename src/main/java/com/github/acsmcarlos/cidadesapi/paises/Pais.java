package com.github.acsmcarlos.cidadesapi.paises;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {
	
	@Id
	private Long id;

	private String nome;

	private String nome_pt;

	private String sigla;

	private Integer bacen;
	  
	public Pais() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public String getNome_pt() {
		return nome_pt;
	}

	public void setNome_pt(String nome_pt) {
		this.nome_pt = nome_pt;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Integer getBacen() {
		return bacen;
	}

	public void setBacen(Integer bacen) {
		this.bacen = bacen;
	}

}
