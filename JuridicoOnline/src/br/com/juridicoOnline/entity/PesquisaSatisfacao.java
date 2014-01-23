package br.com.juridicoOnline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pesquisaSatisfacao")
public class PesquisaSatisfacao implements java.io.Serializable {

	private static final long serialVersionUID = 6278649565336099882L;

	@Id
	@GeneratedValue
	@Column(name="idPesquisa", unique = true, nullable = false)
	
	private Integer idPesquisa;
	
	@OneToOne
	@JoinColumn(name="fknConsultaJuridica")		
	private ConsultaJuridica fknConsultaJuridica;
	
	@Column(name="indiceSatisfacao", nullable = false)
	private Integer indiceSatisfacao;
	
	@Column(name="rapidezAtendimento", nullable = false)
	private Integer rapidezAtendimento;
	
	@Column(name="observacao", length = 1000)
	private String observacao;
	
	public Integer getIdPesquisa() {
		return idPesquisa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((fknConsultaJuridica == null) ? 0 : fknConsultaJuridica
						.hashCode());
		result = prime * result
				+ ((idPesquisa == null) ? 0 : idPesquisa.hashCode());
		result = prime
				* result
				+ ((indiceSatisfacao == null) ? 0 : indiceSatisfacao.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime
				* result
				+ ((rapidezAtendimento == null) ? 0 : rapidezAtendimento
						.hashCode());
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
		PesquisaSatisfacao other = (PesquisaSatisfacao) obj;
		if (fknConsultaJuridica == null) {
			if (other.fknConsultaJuridica != null)
				return false;
		} else if (!fknConsultaJuridica.equals(other.fknConsultaJuridica))
			return false;
		if (idPesquisa == null) {
			if (other.idPesquisa != null)
				return false;
		} else if (!idPesquisa.equals(other.idPesquisa))
			return false;
		if (indiceSatisfacao == null) {
			if (other.indiceSatisfacao != null)
				return false;
		} else if (!indiceSatisfacao.equals(other.indiceSatisfacao))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (rapidezAtendimento == null) {
			if (other.rapidezAtendimento != null)
				return false;
		} else if (!rapidezAtendimento.equals(other.rapidezAtendimento))
			return false;
		return true;
	}

	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}


	public ConsultaJuridica getFknConsultaJuridica() {
		return fknConsultaJuridica;
	}


	public void setFknConsultaJuridica(ConsultaJuridica fknConsultaJuridica) {
		this.fknConsultaJuridica = fknConsultaJuridica;
	}


	public Integer getIndiceSatisfacao() {
		return indiceSatisfacao;
	}


	public void setIndiceSatisfacao(Integer indiceSatisfacao) {
		this.indiceSatisfacao = indiceSatisfacao;
	}


	public Integer getRapidezAtendimento() {
		return rapidezAtendimento;
	}


	public void setRapidezAtendimento(Integer rapidezAtendimento) {
		this.rapidezAtendimento = rapidezAtendimento;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public PesquisaSatisfacao() {
	}
	
	
	
}

