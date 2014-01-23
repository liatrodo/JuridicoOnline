package br.com.juridicoOnline.entity;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "consultaJuridica")
public class ConsultaJuridica implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="idConsulta", unique = true, nullable = false)
	public Integer idConsulta;
	
	@ManyToOne
	@JoinColumn(name="fknUnidadeJuridica")		
	private UnidadeJuridica fknUnidadeJuridica;
	
	@ManyToOne
	@JoinColumn(name="fknAreaJuridica")		
	private AreaJuridica fknAreaJuridica;
	
	@ManyToOne
	@JoinColumn(name="fknAssunto")	
	private Assunto fknAssunto;
	
	@ManyToOne
	@JoinColumn(name="fknComplexidade")	
	private Complexidade fknComplexidade;
	
	@ManyToOne
	@JoinColumn(name="fknMatriculaCliente")	
	private Usuario fknMatriculaCliente;
	
	@Column(name="pergunta", length = 200)		
	private String pergunta;
	
	@Column(name="resposta", length = 200)		
	private String resposta;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dataInicial")	
	private Date dataInicial;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dataFinal")	
	private Date dataFinal;
	
	@ManyToOne
	@JoinColumn(name="fknMatriculaAdvogado")		
	private Usuario fknMatriculaAdvogado;
	
	@Column(name="status", length = 30)		
	private String status;
	
	public ConsultaJuridica() {
	}


	public ConsultaJuridica(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Integer getIdConsulta() {
		return this.idConsulta;
	}
	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}
	
	public UnidadeJuridica getFknUnidadeJuridica() {
		return this.fknUnidadeJuridica;
	}
	public void setFknUnidadeJuridica(UnidadeJuridica fknUnidadeJuridica) {
		this.fknUnidadeJuridica = fknUnidadeJuridica;
	}
	
	public AreaJuridica getFknAreaJuridica() {
		return this.fknAreaJuridica;
	}
	public void setFknAreaJuridica(AreaJuridica fknAreaJuridica) {
		this.fknAreaJuridica = fknAreaJuridica;
	}
	
	public Assunto getFknAssunto() {
		return this.fknAssunto;
	}
	public void setFknAssunto(Assunto fknAssunto) {
		this.fknAssunto = fknAssunto;
	}
	
	public Complexidade getFknComplexidade() {
		return fknComplexidade;
	}
	public void setFknComplexidade(Complexidade fknComplexidade) {
		this.fknComplexidade = fknComplexidade;
	}
	
	public Usuario getFknMatriculaCliente() {
		return fknMatriculaCliente;
	}
	public void setFknMatriculaCliente(Usuario fknMatriculaCliente) {
		this.fknMatriculaCliente = fknMatriculaCliente;
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
	
	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataAtual) {
		this.dataInicial = dataAtual;
	}
	
	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}	
	
	public Usuario getFknMatriculaAdvogado() {
		return fknMatriculaAdvogado;
	}
	public void setFknMatriculaAdvogado(Usuario fknMatriculaAdvogado) {
		this.fknMatriculaAdvogado = fknMatriculaAdvogado;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataInicial == null) ? 0 : dataInicial.hashCode());
		result = prime * result + ((dataFinal == null) ? 0 : dataFinal.hashCode());
		result = prime * result
				+ ((fknAreaJuridica == null) ? 0 : fknAreaJuridica.hashCode());
		result = prime * result
				+ ((fknAssunto == null) ? 0 : fknAssunto.hashCode());
		result = prime * result
				+ ((fknComplexidade == null) ? 0 : fknComplexidade.hashCode());
		result = prime
				* result
				+ ((fknMatriculaAdvogado == null) ? 0 : fknMatriculaAdvogado
						.hashCode());
		result = prime
				* result
				+ ((fknMatriculaCliente == null) ? 0 : fknMatriculaCliente
						.hashCode());
		result = prime
				* result
				+ ((fknUnidadeJuridica == null) ? 0 : fknUnidadeJuridica
						.hashCode());
		result = prime * result
				+ ((idConsulta == null) ? 0 : idConsulta.hashCode());
		result = prime * result
				+ ((pergunta == null) ? 0 : pergunta.hashCode());
		result = prime * result
				+ ((resposta == null) ? 0 : resposta.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaJuridica other = (ConsultaJuridica) obj;
		if (dataInicial == null) {
			if (other.dataInicial != null)
				return false;
		} else if (!dataInicial.equals(other.dataInicial))
			return false;
		if (dataFinal == null) {
			if (other.dataFinal != null)
				return false;
		} else if (!dataFinal.equals(other.dataFinal))
			return false;		
		if (fknAreaJuridica == null) {
			if (other.fknAreaJuridica != null)
				return false;
		} else if (!fknAreaJuridica.equals(other.fknAreaJuridica))
			return false;
		if (fknAssunto == null) {
			if (other.fknAssunto != null)
				return false;
		} else if (!fknAssunto.equals(other.fknAssunto))
			return false;
		if (fknComplexidade == null) {
			if (other.fknComplexidade != null)
				return false;
		} else if (!fknComplexidade.equals(other.fknComplexidade))
			return false;
		if (fknMatriculaAdvogado == null) {
			if (other.fknMatriculaAdvogado != null)
				return false;
		} else if (!fknMatriculaAdvogado.equals(other.fknMatriculaAdvogado))
			return false;
		if (fknMatriculaCliente == null) {
			if (other.fknMatriculaCliente != null)
				return false;
		} else if (!fknMatriculaCliente.equals(other.fknMatriculaCliente))
			return false;
		if (fknUnidadeJuridica == null) {
			if (other.fknUnidadeJuridica != null)
				return false;
		} else if (!fknUnidadeJuridica.equals(other.fknUnidadeJuridica))
			return false;
		if (idConsulta == null) {
			if (other.idConsulta != null)
				return false;
		} else if (!idConsulta.equals(other.idConsulta))
			return false;
		if (pergunta == null) {
			if (other.pergunta != null)
				return false;
		} else if (!pergunta.equals(other.pergunta))
			return false;
		if (resposta == null) {
			if (other.resposta != null)
				return false;
		} else if (!resposta.equals(other.resposta))
			return false;
		return true;
	}

}
