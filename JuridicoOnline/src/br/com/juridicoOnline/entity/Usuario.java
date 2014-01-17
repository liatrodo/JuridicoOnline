package br.com.juridicoOnline.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@Entity
@Table(name = "usuario")
@ManagedBean(name = "Usuario")
@SessionScoped
public class Usuario implements java.io.Serializable {

	private static final long serialVersionUID = -6582230628228207885L;

	@Id
	@Column(name="matricula", length = 7)
	
	private String matricula;
	private String nome;
	private String senha;
	private Integer funcao;
	private Integer fknUnidadeBase;

	public Usuario() {
	}		
	
	public Usuario(String matricula) {
		this.matricula = matricula;
	}	
	
	public String getMatricula() {
		return this.matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	@Column(name="nome", length = 100)
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name="senha", length = 45)
	public String getSenha() {
		return this.senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Column(name="funcao", nullable = false)
	public Integer getFuncao() {
		return this.funcao;
	}
	public void setFuncao(Integer funcao) {
		this.funcao = funcao;
	}
	
	@Column(name="fknUnidadeBase", nullable = false)
	public Integer getfknUnidadeBase() {
		return this.fknUnidadeBase;
	}
	public void setfknUnidadeBase(Integer unidadeBase) {
		this.fknUnidadeBase = unidadeBase;
	}
	public boolean isAdvogadoResponsavel() {
		if (this.funcao == 123)
		{
			return true;
		} else {
			return false;
		}
	}
	public boolean isAdvogado() {
		if (this.funcao == 12)
		{
			return true;
		} else {
			return false;
		}
	}	
	
}
