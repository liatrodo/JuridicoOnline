package br.com.juridicoOnline.entity;

import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
