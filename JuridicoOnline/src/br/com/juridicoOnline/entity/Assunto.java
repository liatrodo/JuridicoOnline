package br.com.juridicoOnline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assunto")
public class Assunto implements java.io.Serializable {

	private static final long serialVersionUID = 1198886857858016614L;
	@Id
	@Column(name="idAssunto", unique = true, nullable = false)
	
	private Integer idAssunto;
	private String descricao;

	public Assunto() {
	}
	
	public Assunto(int idAssuntoa) {
		this.idAssunto = idAssunto;
	}	
	
	public int getIdAssunto() {
		return this.idAssunto;
	}
	public void setIdAssunto(int idAssunto) {
		this.idAssunto = idAssunto;
	}
	
	@Column(name="descricao", length = 100)
	public String getDescricao() {
		return this.descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
