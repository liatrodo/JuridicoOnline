package br.com.juridicoOnline.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.com.juridicoOnline.dao.NivelDAO;
import br.com.juridicoOnline.entity.Nivel;

@ManagedBean(name = "nivelBean")
@ViewScoped
public class NivelBean implements Serializable {

	private static final long serialVersionUID = -6562967861863978866L;
	private Nivel nivel = new Nivel();
	private NivelDAO nivelDAO = new NivelDAO();
	private List<SelectItem> niveis;
		
	public NivelBean() {
	}
	
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public List<SelectItem> getNiveis() {
		System.out.println("estou no getNiveis");
		List<Nivel> nis = nivelDAO.listar();
		System.out.println("tamanho:" + nis.size());

		List<SelectItem> itens = new ArrayList<SelectItem>(nis.size());

		for (Nivel ni : nis) {
			System.out.println("estou aqui no Nivel???");
			itens.add(new SelectItem(ni.getIdNivel(), ni.getDescricao()));
		}
		return itens;
	}

	public void setNiveis(List<SelectItem> niveis) {
		niveis = niveis;
	}	
		
}
