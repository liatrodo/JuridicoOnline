package br.com.juridicoOnline.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.com.juridicoOnline.dao.ComplexidadeDAO;
import br.com.juridicoOnline.entity.Complexidade;
import br.com.juridicoOnline.entity.Usuario;

@ManagedBean(name = "complexidadeBean")
@ViewScoped
public class ComplexidadeBean implements Serializable {

	private static final long serialVersionUID = -5268138937727296893L;
	private ComplexidadeDAO complexidadeDAO;
	private Complexidade complexidade;
	private int idComplexidade;
	private String descricao;
	private List<SelectItem> complexidades;
	
	public ComplexidadeBean() {
		complexidadeDAO = new ComplexidadeDAO();
		complexidade = new Complexidade();
	}

	public int getIdComplexidade() {
		return idComplexidade;
	}

	public void setIdComplexidade(int idComplexidade) {
		this.idComplexidade = idComplexidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<SelectItem> getComplexidades() {
		System.out.println("estou no getComplexidades");
		List<Complexidade> cos = complexidadeDAO.listar();
		System.out.println("tamanho:" + cos.size());

		List<SelectItem> itens = new ArrayList<SelectItem>(cos.size());

		for (Complexidade co : cos) {
			System.out.println("estou aqui na Complexidade???" + co.getIdComplexidade() + "," +  co.getDescricao());
			itens.add(new SelectItem(co.getIdComplexidade(), co.getDescricao()));
		}
		return itens;
	}

	public void setComplexidades(List<SelectItem> complexidades) {
		complexidades = complexidades;
	}
	
}
