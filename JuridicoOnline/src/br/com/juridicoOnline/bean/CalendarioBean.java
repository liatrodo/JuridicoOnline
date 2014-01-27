package br.com.juridicoOnline.bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "calendarioBean")
@ViewScoped
public class CalendarioBean implements Serializable {

	private static final long serialVersionUID = -7825460649856706817L;
	private Date dataInicial;  
    private Date dataFinal;
    Date dataAtual = new Date();
    
    public CalendarioBean() {
    	this.dataInicial = dataAtual;
		this.dataFinal = dataAtual;
	}

	public Date getDataFinal() {
		if (this.dataFinal == null) {
			this.dataFinal = dataAtual;
		}
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getDataInicial() {
		if (this.dataInicial == null) {
			this.dataInicial = dataAtual;
		}
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}  
      
   
}
