package br.com.juridicoOnline.bean;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.juridicoOnline.dao.ConsultaJuridicaDAO;
import br.com.juridicoOnline.entity.ConsultaJuridica;

@ManagedBean(name = "consultaBean")
@ViewScoped
public class consultaBean implements Serializable {

	private static final long serialVersionUID = -3293076730745408449L;
	private ConsultaJuridica consulta = new ConsultaJuridica();
	private ConsultaJuridicaDAO consultaDAO = new ConsultaJuridicaDAO();	
	private List<ConsultaJuridica> lista;
	
	public consultaBean() {
		String statusDistribuicao = "NOVA";
		lista = consultaDAO.listaParcial(statusDistribuicao);
	}
	
	public ConsultaJuridica getConsulta() {
		return consulta;
	}
	public void setConsulta(ConsultaJuridica consulta) {
		this.consulta = consulta;
	}
	public List<ConsultaJuridica> getLista() {
		if (this.lista == null) {
			ConsultaJuridicaDAO consultaDAO = new ConsultaJuridicaDAO();
			this.lista = consultaDAO.listar();
		}
		return lista;
	}
	public void setLista(List<ConsultaJuridica> lista) {
		this.lista = lista;
	}
	
	public void distribuir(){
		System.out.println("estou no distribuir");
		new ConsultaJuridicaDAO().alterar(consulta);
		String status = "NOVA";
		lista = new ConsultaJuridicaDAO().listaParcial(status);
		consulta = new ConsultaJuridica();
	}
	
	
	public String excluir() {
		System.out.println("Estou no excluir");		
		consultaDAO.excluir(this.consulta);
		return "ListaConsultaJuridica";

	}

	
}
