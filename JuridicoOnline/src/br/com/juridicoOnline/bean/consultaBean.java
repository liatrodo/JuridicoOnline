package br.com.juridicoOnline.bean;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.juridicoOnline.dao.ConsultaJuridicaDAO;
import br.com.juridicoOnline.entity.ConsultaJuridica;

@ManagedBean(name = "consultaBean")
@ViewScoped
public class consultaBean implements Serializable {

	private static final long serialVersionUID = -3293076730745408449L;
	private ConsultaJuridica consulta = new ConsultaJuridica();
	private ConsultaJuridicaDAO consultaDAO = new ConsultaJuridicaDAO();	
	private List<ConsultaJuridica> lista;
	private List<ConsultaJuridica> listaPorAdvogado;
	private String status;
	private String advogadoBase = "c999999";
	
	public consultaBean() {
		String statusDistribuicao = "NOVA";
		String statusConsultaAdvogado = "DISTRIBUIDA";
		HttpSession httpSession = (HttpSession) FacesContext
				.getCurrentInstance().getExternalContext().getSession(false);
		String advogado = (String) httpSession.getAttribute("matricula");
		lista = consultaDAO.listaParcial(statusDistribuicao,advogadoBase);
		setListaPorAdvogado(consultaDAO.listaPorAdvogado(advogado,statusConsultaAdvogado));		
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
		status = "DISTRIBUIDA";
		consulta.setStatus(status);		
		new ConsultaJuridicaDAO().alterar(consulta);
		status = "NOVA";
		lista = new ConsultaJuridicaDAO().listaParcial(status,advogadoBase);
		consulta = new ConsultaJuridica();
	}
	
	public void atender(){
		System.out.println("estou no atender");
		Date dataAtual = new Date();
		consulta.setDataFinal(dataAtual);	
		status = "ATENDIDA";
		consulta.setStatus(status);
		new ConsultaJuridicaDAO().alterar(consulta);
		status = "DISTRIBUIDA";
		HttpSession httpSession = (HttpSession) FacesContext
				.getCurrentInstance().getExternalContext().getSession(false);
		String advogado = (String) httpSession.getAttribute("matricula");
		setListaPorAdvogado(consultaDAO.listaPorAdvogado(advogado,status));	
		consulta = new ConsultaJuridica();
	}	
	
	public String excluir() {
		System.out.println("Estou no excluir");		
		consultaDAO.excluir(this.consulta);
		return "ListaConsultaJuridica";

	}

	public List<ConsultaJuridica> getListaPorAdvogado() {
		if (this.listaPorAdvogado == null) {
			ConsultaJuridicaDAO consultaDAO = new ConsultaJuridicaDAO();
			this.listaPorAdvogado = consultaDAO.listar();
		}
		return listaPorAdvogado;
	}

	public void setListaPorAdvogado(List<ConsultaJuridica> listaPorAdvogado) {
		this.listaPorAdvogado = listaPorAdvogado;
	}

	
}
