package br.com.juridicoOnline.entity;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consultaJuridica")
public class ConsultaJuridica implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="idConsulta", unique = true, nullable = false)
	private Integer idConsulta;
	private Integer fknUnidadeJuridica;
	private Integer fknAreaJuridica;
	private Integer fknAssunto;
	private Integer fknComplexidade;
	private String fknMatriculaCliente;
	private String pergunta;
	private String resposta;
	private String data;
	private String horaInicial;
	private String horaFinal;
	private String fknMatriculaAdvogado;
	
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
	
	@ManyToOne
	@JoinColumn(name="fknUnidadeJuridica")	
	public Integer getFknUnidadeJuridica() {
		return this.fknUnidadeJuridica;
	}
	public void setFknUnidadeJuridica(Integer fknUnidadeJuridica) {
		this.fknUnidadeJuridica = fknUnidadeJuridica;
	}
	
	@ManyToOne
	@JoinColumn(name="fknAreaJuridica")	
	public Integer getFknAreaJuridica() {
		return this.fknAreaJuridica;
	}
	public void setFknAreaJuridica(Integer fknAreaJuridica) {
		this.fknAreaJuridica = fknAreaJuridica;
	}
	
	@ManyToOne
	@JoinColumn(name="fknAssunto")
	public Integer getFknAssunto() {
		return this.fknAssunto;
	}
	public void setFknAssunto(Integer fknAssunto) {
		this.fknAssunto = fknAssunto;
	}
	
	@ManyToOne
	@JoinColumn(name="fknComplexidade")
	public Integer getFknComplexidade() {
		return fknComplexidade;
	}
	public void setFknComplexidade(Integer fknComplexidade) {
		this.fknComplexidade = fknComplexidade;
	}
	
	@ManyToOne
	@JoinColumn(name="fknMatriculaCliente")
	public String getFknMatriculaCliente() {
		return fknMatriculaCliente;
	}
	public void setFknMatriculaCliente(String fknMatriculaCliente) {
		this.fknMatriculaCliente = fknMatriculaCliente;
	}
	
	@Column(name="pergunta", length = 200)	
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	
	@Column(name="resposta", length = 200)	
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	@Column(name="data", length = 10)	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	@Column(name="horaInicial", length = 8)
	public String getHoraInicial() {
		return horaInicial;
	}
	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}
	
	@Column(name="horaFinal", length = 8)	
	public String getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
	
	@ManyToOne
	@JoinColumn(name="fknMatriculaAdvogado")	
	public String getFknMatriculaAdvogado() {
		return fknMatriculaAdvogado;
	}
	public void setFknMatriculaAdvogado(String fknMatriculaAdvogado) {
		this.fknMatriculaAdvogado = fknMatriculaAdvogado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
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
				+ ((horaFinal == null) ? 0 : horaFinal.hashCode());
		result = prime * result
				+ ((horaInicial == null) ? 0 : horaInicial.hashCode());
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
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
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
		if (horaFinal == null) {
			if (other.horaFinal != null)
				return false;
		} else if (!horaFinal.equals(other.horaFinal))
			return false;
		if (horaInicial == null) {
			if (other.horaInicial != null)
				return false;
		} else if (!horaInicial.equals(other.horaInicial))
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
