package br.com.juridicoOnline.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.juridicoOnline.dao.PesquisaSatisfacaoDAO;
import br.com.juridicoOnline.entity.AreaJuridica;
import br.com.juridicoOnline.entity.Assunto;
import br.com.juridicoOnline.entity.Complexidade;
import br.com.juridicoOnline.entity.ConsultaJuridica;
import br.com.juridicoOnline.entity.PesquisaSatisfacao;
import br.com.juridicoOnline.entity.UnidadeJuridica;
import br.com.juridicoOnline.entity.Usuario;

@ManagedBean(name = "pesquisaSatisfacaoBean")
@ViewScoped
public class PesquisaSatisfacaoBean implements Serializable {

	private static final long serialVersionUID = 915235447010696133L;
	private PesquisaSatisfacao pesquisa = new PesquisaSatisfacao();
	private PesquisaSatisfacaoDAO pesquisaDAO = new PesquisaSatisfacaoDAO();	
	private List<PesquisaSatisfacao> lista;
		
	public PesquisaSatisfacaoBean() {
	}

	public PesquisaSatisfacao getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(PesquisaSatisfacao pesquisa) {
		this.pesquisa = pesquisa;
	}

	public PesquisaSatisfacaoDAO getPesquisaDAO() {
		return pesquisaDAO;
	}

	public void setPesquisaDAO(PesquisaSatisfacaoDAO pesquisaDAO) {
		this.pesquisaDAO = pesquisaDAO;
	}

	public List<PesquisaSatisfacao> getLista() {
		return lista;
	}

	public void setLista(List<PesquisaSatisfacao> lista) {
		this.lista = lista;
	}
	
	public String salvar(ConsultaJuridica consulta) {
		System.out.println("estou no pesquisa satisfacao salvar" + consulta.idConsulta);
		pesquisa.setFknConsultaJuridica(consulta);
		pesquisaDAO.salvar(pesquisa);
		pesquisa = new PesquisaSatisfacao();
		return "ListaConsultaAtendidaCliente";

	}
	
}
