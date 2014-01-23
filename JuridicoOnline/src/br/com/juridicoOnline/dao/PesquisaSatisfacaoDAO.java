package br.com.juridicoOnline.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.juridicoOnline.entity.ConsultaJuridica;
import br.com.juridicoOnline.entity.PesquisaSatisfacao;
import br.com.juridicoOnline.entity.Usuario;
import br.com.juridicoOnline.util.HibernateUtil;


public class PesquisaSatisfacaoDAO extends HibernateUtil{
	
	private Session session;
	private Transaction transacao;
	
	public void setSession(Session session) {
		session = session;
	}
	
	public void salvar(PesquisaSatisfacao pesquisa){
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.saveOrUpdate(pesquisa);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
		
}

