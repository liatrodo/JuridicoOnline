package br.com.juridicoOnline.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.com.juridicoOnline.dao.AreaJuridicaDAO;
import br.com.juridicoOnline.dao.AssuntoDAO;
import br.com.juridicoOnline.entity.AreaJuridica;
import br.com.juridicoOnline.entity.Assunto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "assuntoBean")
@ViewScoped
public class AssuntoBean implements Serializable {

	private static final long serialVersionUID = 8676586410313896352L;
	private AssuntoDAO assuntoDAO;
	private Assunto assunto;
	private int idAssunto;
	private String descricao;
	private List<SelectItem> assuntos;
	
	public AssuntoBean() {
		assuntoDAO = new AssuntoDAO();
		assunto = new Assunto();
	}

	public int getIdAssunto() {
		return idAssunto;
	}

	public void setIdAssunto(int idAssunto) {
		this.idAssunto = idAssunto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<SelectItem> getAssuntos() {
		System.out.println("estou no getAssuntos");
		List<Assunto> ass = assuntoDAO.listar();
		System.out.println("tamanho:" + ass.size());

		List<SelectItem> itens = new ArrayList<SelectItem>(ass.size());

		for (Assunto as : ass) {
			System.out.println("estou aqui no assunto???");
			itens.add(new SelectItem(as.getIdAssunto(), as.getDescricao()));
		}
		return itens;
	}

	public void setAssuntos(List<SelectItem> assuntos) {
		assuntos = assuntos;
	}
}
