package br.com.juridicoOnline.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.event.RowEditEvent;

import br.com.juridicoOnline.entity.AreaJuridica;
import br.com.juridicoOnline.entity.Usuario;
import br.com.juridicoOnline.dao.UsuarioDAO;

@ViewScoped
@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

	
	private static final long serialVersionUID = -4786663279197427709L;
	private Usuario usuario;
	private String matricula;
	private String nome;
	private String senha;
	private UsuarioDAO usuarioDAO;
	private Integer funcao;
	private Integer fknUnidadeBase;

	public UsuarioBean() {
		usuario = new Usuario();
		usuarioDAO = new UsuarioDAO();
	}
	
	public String salvarDAO() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario salvaUsuario = new Usuario();
		salvaUsuario.setMatricula(matricula);
		salvaUsuario.setSenha(senha);
		salvaUsuario.setNome(nome);
		salvaUsuario.setFuncao(funcao);
		salvaUsuario.setfknUnidadeBase(fknUnidadeBase);
		usuarioDAO.incluir(salvaUsuario);
		
		return "usuario";
	}

	public String efetuarLogin() {
		System.out.println("usuario: " + usuario.toString());
		System.out.println("matricula: " + this.matricula);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Integer funcao;
		Integer advogadoResponsavel = 123;
		Integer advogado = 12;		
		
		Usuario result = usuarioDAO.consultar(this.matricula,
				this.senha);
		System.out.println("resultado:" + result.getMatricula());

		if (result == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Login ou Senha inválidos!"));
			return "index";
		}

		HttpSession httpSession = (HttpSession) FacesContext
				.getCurrentInstance().getExternalContext().getSession(false);
		httpSession.setAttribute("matricula", result.getMatricula());
		httpSession.setAttribute("nome", result.getNome());
		httpSession.setAttribute("fknUnidadeBase", result.getfknUnidadeBase());
		
		funcao = result.getFuncao();
		System.out.println("funcao:" + funcao);
		
		if ( result.isAdvogadoResponsavel()) {
			return "MenuAdvogadoResponsavel";
		} else if ( result.isAdvogado()) {
			return "MenuAdvogado";
		} else {
			return "MenuUsuario";
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
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

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public Integer getFuncao() {
		return funcao;
	}

	public void setFuncao(Integer funcao) {
		this.funcao = funcao;
	}

	public Integer getFknUnidadeBase() {
		return fknUnidadeBase;
	}

	public void setFknUnidadeBase(Integer fknUnidadeBase) {
		this.fknUnidadeBase = fknUnidadeBase;
	}

	public List<SelectItem> getAdvogados() {
		System.out.println("estou no getAdvogados");
		int funcao = 12;
		List<Usuario> us = usuarioDAO.listar(funcao);
		System.out.println("tamanho:" + us.size());

		List<SelectItem> itens = new ArrayList<SelectItem>(us.size());

		for (Usuario u : us) {
			System.out.println("estou aqui???" + u.getMatricula() + "-" + u.getNome());
			itens.add(new SelectItem(u.getMatricula(), u.getNome()));
		}
		return itens;
	}
}