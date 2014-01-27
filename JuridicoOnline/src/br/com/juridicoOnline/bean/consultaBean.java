package br.com.juridicoOnline.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;

import br.com.juridicoOnline.dao.ConsultaJuridicaDAO;
import br.com.juridicoOnline.entity.ConsultaJuridica;
import br.com.juridicoOnline.util.Email;

@ManagedBean(name = "consultaBean")
@ViewScoped
public class consultaBean implements Serializable {

	private static final long serialVersionUID = -3293076730745408449L;
	private ConsultaJuridica consulta = new ConsultaJuridica();
	private ConsultaJuridicaDAO consultaDAO = new ConsultaJuridicaDAO();	
	private List<ConsultaJuridica> lista;
	private List<ConsultaJuridica> listaPorAdvogado;
	private List<ConsultaJuridica> listaAdvogado;	
	private List<ConsultaJuridica> listaArea;
	private List<ConsultaJuridica> listaPeriodo;	
	private List<ConsultaJuridica> listaPendentePorCliente;
	private List<ConsultaJuridica> listaAtendidaPorCliente;
	private String status;
	private String advogadoBase = "c999999";
	HttpSession httpSession = (HttpSession) FacesContext
			.getCurrentInstance().getExternalContext().getSession(false);
	String usuario = (String) httpSession.getAttribute("matricula");
	String statusCliente = "ATENDIDA";
	String statusConsultaAdvogado = "DISTRIBUIDA";
	
	public consultaBean() {
		String statusDistribuicao = "NOVA";
		lista = consultaDAO.listaParcial(statusDistribuicao,advogadoBase);
		setListaPorAdvogado(consultaDAO.listaPorAdvogado(usuario,statusConsultaAdvogado));
		Integer AreaInicial = 0;
		setListaArea(consultaDAO.listaArea(AreaInicial));
		setListaAdvogado(consultaDAO.listaAdvogado(usuario));		
		setListaPendentePorCliente(consultaDAO.listaPendentePorCliente(usuario,statusCliente));
		setListaAtendidaPorCliente(consultaDAO.listaAtendidaPorCliente(usuario,statusCliente));
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
	
	public void atender() throws EmailException{
		System.out.println("estou no atender");
		Date dataAtual = new Date();
		consulta.setDataFinal(dataAtual);	
		status = "ATENDIDA";
		consulta.setStatus(status);
		new ConsultaJuridicaDAO().alterar(consulta);
		status = "DISTRIBUIDA";
		setListaPorAdvogado(consultaDAO.listaPorAdvogado(usuario,status));	
		String emailDestino = consulta.fknMatriculaCliente.getEmail();
		String nomeDestino = consulta.fknMatriculaCliente.getNome();
		consulta = new ConsultaJuridica();
		Email email = new Email();
		String destinatario = emailDestino;
		String nomeDestinatario = nomeDestino;
		String origem = "liatrodo@gmail.com";
		String assunto = "Atendimento Consulta Online";
		String conteudoMensagem = "Informamos que sua consulta juridica foi atendida. Favor verificar sua resposta no site da CONSULTA ONLINE!";
		email.sendEmail(destinatario,nomeDestinatario,origem,assunto,conteudoMensagem);
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

	public List<ConsultaJuridica> getListaPendentePorCliente() {
		if (this.listaPendentePorCliente == null) {
			ConsultaJuridicaDAO consultaDAO = new ConsultaJuridicaDAO();
			this.listaPendentePorCliente = consultaDAO.listar();
		}
		return listaPendentePorCliente;
	}

	public void setListaPendentePorCliente(List<ConsultaJuridica> listaPendentePorCliente) {
		this.listaPendentePorCliente = listaPendentePorCliente;
	}

	public List<ConsultaJuridica> getListaAtendidaPorCliente() {
		if (this.listaAtendidaPorCliente == null) {
			ConsultaJuridicaDAO consultaDAO = new ConsultaJuridicaDAO();
			this.listaAtendidaPorCliente = consultaDAO.listar();
		}
		return listaAtendidaPorCliente;
	}

	public void setListaAtendidaPorCliente(List<ConsultaJuridica> listaAtendidaPorCliente) {
		this.listaAtendidaPorCliente = listaAtendidaPorCliente;
	}

	public List<ConsultaJuridica> getListaAdvogado() {
		if (this.listaAdvogado == null) {
			ConsultaJuridicaDAO consultaDAO = new ConsultaJuridicaDAO();
			this.listaAdvogado = consultaDAO.listar();
		}
		return listaAdvogado;
	}

	public void setListaAdvogado(List<ConsultaJuridica> listaAdvogado) {
		this.listaAdvogado = listaAdvogado;
	}
	

	public void updateListaAdvogado(String usuario) {
		System.out.println("estou no updatelistaadvogado" + usuario);
		setListaAdvogado(consultaDAO.listaAdvogado(usuario));;
	}	
	
	public List<ConsultaJuridica> getListaArea() {
		if (this.listaArea == null) {
			ConsultaJuridicaDAO consultaDAO = new ConsultaJuridicaDAO();
			this.listaArea = consultaDAO.listar();
		}
		return listaArea;
	}

	public void setListaArea(List<ConsultaJuridica> listaArea) {
		this.listaArea = listaArea;
	}
	

	public void updateListaArea(Integer area) {
		System.out.println("estou no updatelistaarea" + area);
		setListaArea(consultaDAO.listaArea(area));;
	}	
	
	public List<ConsultaJuridica> getListaPeriodo() {
		if (this.listaPeriodo == null) {
			ConsultaJuridicaDAO consultaDAO = new ConsultaJuridicaDAO();
			this.listaPeriodo = consultaDAO.listar();
		}
		return listaArea;
	}
	
	public void setListaPeriodo(List<ConsultaJuridica> listaPeriodo) {
		this.listaPeriodo = listaPeriodo;
	}
	

	public void updateListaPeriodo(Date dataInicial,Date dataFinal) throws EmailException {
		Date testeData = new Date(dataInicial.getTime() + TimeUnit.DAYS.toMillis(1));
		System.out.println("estou no updatelistaperiodo" + dataInicial + dataFinal + testeData);
		setListaPeriodo(consultaDAO.listaPeriodo(testeData,testeData));;
	}		
	
}
