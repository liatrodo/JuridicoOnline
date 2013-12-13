package br.com.juridicoOnline.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class UsuarioHibernate {
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getFuncao() {
		return funcao;
	}
	public void setFuncao(Integer funcao) {
		this.funcao = funcao;
	}
	public Integer getUnidadeBase() {
		return fknUnidadeBase;
	}
	public void setUnidadeBase(Integer unidadeBase) {
		this.fknUnidadeBase = unidadeBase;
	}
	private String matricula;
	private String nome;
	private String senha;
	private Integer funcao;
	private Integer fknUnidadeBase;
}
