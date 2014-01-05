package br.com.juridicoOnline.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@Entity
@Table(name = "areaJuridica")
public class AreaJuridica implements java.io.Serializable {

	private static final long serialVersionUID = -3855613918839154406L;

	@Id
	@Column(name="idArea", unique = true, nullable = false)
	
	private int idArea;
	private String nome;

	public AreaJuridica() {
	}
	
	public AreaJuridica(int idArea) {
		this.idArea = idArea;
	}

	public int getIdArea() {
		System.out.println("estou no getIdArea");
		return this.idArea;
	}
	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}
	
	@Column(name="nome", length = 100)
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
