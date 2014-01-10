package br.com.juridicoOnline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "complexidade")
public class Complexidade implements java.io.Serializable {

	private static final long serialVersionUID = -2983443055596696790L;
	@Id
	@Column(name="idComplexidade", unique = true, nullable = false)
	
	private Integer idComplexidade;
	private String descricao;

	public Complexidade() {
	}
	
	public Complexidade(int idComplexidade) {
		this.idComplexidade = idComplexidade;
	}	
	
	public int getIdComplexidade() {
		return this.idComplexidade;
	}
	public void setIdComplexidade(int idComplexidade) {
		this.idComplexidade = idComplexidade;
	}
	
	@Column(name="descricao", length = 100)
	public String getDescricao() {
		return this.descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
