package br.com.juridicoOnline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nivel")
public class Nivel implements java.io.Serializable {

	private static final long serialVersionUID = -1023406620397351969L;
	@Id
	@Column(name="idNivel", unique = true, nullable = false)
	
	private Integer idNivel;
	private String descricao;

	public Nivel() {
	}
	
	public Nivel(int idNivel) {
		this.idNivel = idNivel;
	}	
	
	public int getIdNivel() {
		return this.idNivel;
	}
	public void setIdNivel(int idNivel) {
		this.idNivel = idNivel;
	}
	
	@Column(name="descricao", length = 100)
	public String getDescricao() {
		return this.descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
