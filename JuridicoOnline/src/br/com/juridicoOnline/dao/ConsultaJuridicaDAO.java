package br.com.juridicoOnline.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import br.com.juridicoOnline.entity.ConsultaJuridica;
import br.com.juridicoOnline.entity.Usuario;
import br.com.juridicoOnline.util.HibernateUtil;

import org.hibernate.Session;


public class ConsultaJuridicaDAO extends HibernateUtil{
	
	private Session session;
	private Transaction transacao;
	
	public void setSession(Session session) {
		session = session;
	}
	
	public void salvar(ConsultaJuridica consultaJuridica){
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(consultaJuridica);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	public void atualizar(ConsultaJuridica consultaJuridica){
		session.update(consultaJuridica);
	}
	public void alterar(ConsultaJuridica consultaJuridica){
		
	}
	public void excluir(ConsultaJuridica consultaJuridica){
		session.delete(consultaJuridica);
	}
	public List<ConsultaJuridica> listar() {
		System.out.println("estou no consulta juridica DAO");
		List<ConsultaJuridica> lista = new ArrayList<ConsultaJuridica>();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transacao = session.beginTransaction();
			lista = (List<ConsultaJuridica>) session.createCriteria(ConsultaJuridica.class).list();
			transacao.commit();			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();		
			}
		}
		return lista;
	}
	public ConsultaJuridica carregar(Integer codigo){
		return (ConsultaJuridica) session.get(ConsultaJuridica.class, codigo);
	}
	public ConsultaJuridica buscar(Integer idConsulta){
		String hql = "select c from codigoDemanda c where c.idConsulta = :idConsulta";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("idConsulta", idConsulta);
		return (ConsultaJuridica) consulta.uniqueResult();
	}
	
	
}
