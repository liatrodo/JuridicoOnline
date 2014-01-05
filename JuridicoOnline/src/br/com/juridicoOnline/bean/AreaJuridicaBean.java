package br.com.juridicoOnline.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.com.juridicoOnline.dao.AreaJuridicaDAO;
import br.com.juridicoOnline.entity.AreaJuridica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "areaJuridicaBean")
@ViewScoped
public class AreaJuridicaBean implements Serializable{

	private static final long serialVersionUID = -879278216536998495L;
	private AreaJuridicaDAO areaJuridicaDAO;
	private AreaJuridica areaJuridica;
	private int idArea;
	private String nome;
		
	public AreaJuridicaBean() {
		areaJuridicaDAO = new AreaJuridicaDAO();
		areaJuridica = new AreaJuridica();
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<SelectItem> getAreasJuridicas() {
		System.out.println("estou no getAreasJuridicas");
		List<AreaJuridica> ajs = areaJuridicaDAO.listar();
		System.out.println("tamanho:" + ajs.size());

		List<SelectItem> itens = new ArrayList<SelectItem>(ajs.size());

		for (AreaJuridica aj : ajs) {
			System.out.println("estou aqui???" + aj.getIdArea() + "-" + aj.getNome());
			itens.add(new SelectItem(aj.getIdArea(), aj.getNome()));
		}
		return itens;
	}

}
