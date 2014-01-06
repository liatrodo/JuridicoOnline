package br.com.juridicoOnline.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.primefaces.event.RowEditEvent;

import br.com.juridicoOnline.dao.ConsultaJuridicaDAO;
import br.com.juridicoOnline.entity.AreaJuridica;
import br.com.juridicoOnline.entity.ConsultaJuridica;

@ManagedBean(name = "consultaJuridicaBean")
@ViewScoped
public class ConsultaJuridicaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idConsulta;
	private Integer fknUnidadeJuridica;
	private Integer fknAreaJuridica;
	private Integer fknAssunto;
	private Integer fknComplexidade;
	private String fknMatriculaCliente;
	private String pergunta;
	private String resposta;
	private Date dataInicial;
	private Date dataFinal;
	private String fknMatriculaAdvogado;
	private ConsultaJuridicaDAO consultaJuridicaDAO;
	private List<ConsultaJuridica> listarConsultaJuridica;
	private ConsultaJuridica[] consultasJuridicasSelecionados;
	private ConsultaJuridica consultaJuridicaSelecionada;

	public ConsultaJuridicaBean() {
		consultaJuridicaDAO = new ConsultaJuridicaDAO();
		listarConsultaJuridica = consultaJuridicaDAO.listar();
	}

	public String salvar() {
		Date dataAtual = new Date();
		HttpSession httpSession = (HttpSession) FacesContext
				.getCurrentInstance().getExternalContext().getSession(false);
		fknMatriculaCliente = (String) httpSession.getAttribute("matricula");
		fknUnidadeJuridica = (Integer) httpSession.getAttribute("fknUnidadeBase");
		ConsultaJuridica consulta = new ConsultaJuridica();
		consulta.setFknAreaJuridica(fknAreaJuridica);
		consulta.setFknMatriculaCliente(fknMatriculaCliente);		
		consulta.setFknUnidadeJuridica(fknUnidadeJuridica);
		consulta.setFknAssunto(fknAssunto);
		consulta.setPergunta(this.pergunta);
		consulta.setDataInicial(dataAtual);
		consultaJuridicaDAO.salvar(consulta);
		return "CadastraConsultaJuridica";

	}

	public String remover() {
		consultaJuridicaDAO.excluir(this.consultaJuridicaSelecionada);
		return "cadastraConsultaJuridica";

	}

	public List<ConsultaJuridica> getListarConsultaJuridica() {
		return listarConsultaJuridica;
	}

	public List<SelectItem> listarConsultaJuridica(Integer idConsulta) {
		return null;

	}

	public void setListarConsultaJuridica(List<ConsultaJuridica> listarConsultaJuridica) {
		this.listarConsultaJuridica = listarConsultaJuridica;
	}

	public ConsultaJuridica getConsultaJuricaSelecionada() {
		return consultaJuridicaSelecionada;
	}

	public void setConsultaJuridicaSelecionada(ConsultaJuridica consultaJuridicaSelecionada) {
		this.consultaJuridicaSelecionada = consultaJuridicaSelecionada;
	}

	public void rowEditListener(RowEditEvent ree) {
		ConsultaJuridica cs = (ConsultaJuridica) ree.getObject();
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,
				"rowEdit", ""));
		consultaJuridicaDAO.alterar(cs);
	}

	public void rowEditCancelListener(RowEditEvent ree) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,
				"rowEditCancel", ""));
	}

	public Integer getFknAreaJuridica() {
		return fknAreaJuridica;
	}

	public void setFknAreaJuridica(Integer fknAreaJuridica) {
		this.fknAreaJuridica = fknAreaJuridica;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public String getFknMatriculaAdvogado() {
		return fknMatriculaAdvogado;
	}

	public void setFknMatriculaAdvogado(String fknMatriculaAdvogado) {
		this.fknMatriculaAdvogado = fknMatriculaAdvogado;
	}

	public Integer getFknAssunto() {
		return fknAssunto;
	}

	public void setFknAssunto(Integer fknAssunto) {
		this.fknAssunto = fknAssunto;
	}

	public Integer getFknComplexidade() {
		return fknComplexidade;
	}

	public void setFknComplexidade(Integer fknComplexidade) {
		this.fknComplexidade = fknComplexidade;
	}

	public String getFknMatriculaCliente() {
		return fknMatriculaCliente;
	}

	public void setFknMatriculaCliente(String fknMatriculaCliente) {
		this.fknMatriculaCliente = fknMatriculaCliente;
	}

	public ConsultaJuridica[] getConsultasJuridicasSelecionados() {
		return consultasJuridicasSelecionados;
	}

	public void setConsultasJuridicasSelecionados(
			ConsultaJuridica[] consultasJuridicasSelecionados) {
		this.consultasJuridicasSelecionados = consultasJuridicasSelecionados;
	}

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
}
