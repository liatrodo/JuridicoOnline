package br.com.juridicoOnline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unidadeJuridica")
public class UnidadeJuridica implements java.io.Serializable {

	private static final long serialVersionUID = -504779646715652675L;

	@Id
	@Column(name="idUnidadeJuridica", unique = true, nullable = false)
	
	private Integer idUnidadeJuridica;
	
	@Column(name="nome", length = 100)	
	private String nome;
	
	@Column(name="unidadeBase")
	private Integer unidadeBase;	

	public UnidadeJuridica() {
	}
	
	public UnidadeJuridica(int idUnidadeJuridica) {
		this.idUnidadeJuridica = idUnidadeJuridica;
	}	
	
	public int getIdUnidadeJuridica() {
		return this.idUnidadeJuridica;
	}
	public void setIdUnidadeJuridica(int idUnidadeJuridica) {
		this.idUnidadeJuridica = idUnidadeJuridica;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getUnidadeBase() {
		return this.unidadeBase;
	}
	public void setUnidadeBase(int unidadeBase) {
		this.unidadeBase = unidadeBase;
	}	
	
}

