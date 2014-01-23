package br.com.juridicoOnline.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.juridicoOnline.entity.ConsultaJuridica;
import br.com.juridicoOnline.entity.Usuario;
import br.com.juridicoOnline.util.HibernateUtil;


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
	
	public void alterar(ConsultaJuridica consulta){
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.update(consulta);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}	
	
	public void excluir(ConsultaJuridica consultaJuridica){
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transacao = session.beginTransaction();
			String status = "EXCLUIDA";
			consultaJuridica.setStatus(status);
			session.update(consultaJuridica);
			transacao.commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();		
			}
		}
	}
	public List<ConsultaJuridica> listar() {
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

	public List<ConsultaJuridica> listaParcial(String statusDistribuicao,String advogadoBase) {
		List<ConsultaJuridica> listaParcial = new ArrayList<ConsultaJuridica>();
		System.out.println("advogado base:" + advogadoBase);
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transacao = session.beginTransaction();
			listaParcial = (List<ConsultaJuridica>) session.createCriteria(ConsultaJuridica.class)
					.add(Restrictions.eq("status", statusDistribuicao)).add(Restrictions.eq("fknMatriculaAdvogado.matricula",advogadoBase)).list();
			transacao.commit();			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();		
			}
		}
		return listaParcial;
	}

	public List<ConsultaJuridica> listaPorAdvogado(String advogado,String status) {
		List<ConsultaJuridica> listaPorAdvogado = new ArrayList<ConsultaJuridica>();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transacao = session.beginTransaction();
			listaPorAdvogado = (List<ConsultaJuridica>) session.createCriteria(ConsultaJuridica.class)
					.add(Restrictions.eq("fknMatriculaAdvogado.matricula", advogado)).add(Restrictions.eq("status", status)).list();
			transacao.commit();			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();		
			}
		}
		return listaPorAdvogado;
	}

	public List<ConsultaJuridica> listaPendentePorCliente(String usuario, String statusCliente) {
		List<ConsultaJuridica> listaPendentePorCliente = new ArrayList<ConsultaJuridica>();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transacao = session.beginTransaction();
			listaPendentePorCliente = (List<ConsultaJuridica>) session.createCriteria(ConsultaJuridica.class)
					.add(Restrictions.eq("fknMatriculaCliente.matricula", usuario)).add(Restrictions.ne("status", statusCliente)).list();
			transacao.commit();			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();		
			}
		}
		return listaPendentePorCliente;
	}

	public List<ConsultaJuridica> listaAtendidaPorCliente(String usuario, String statusCliente) {
		List<ConsultaJuridica> listaAtendidaPorCliente = new ArrayList<ConsultaJuridica>();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transacao = session.beginTransaction();
			listaAtendidaPorCliente = (List<ConsultaJuridica>) session.createCriteria(ConsultaJuridica.class)
					.add(Restrictions.eq("fknMatriculaCliente.matricula", usuario)).add(Restrictions.eq("status", statusCliente)).list();
			transacao.commit();			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();		
			}
		}
		return listaAtendidaPorCliente;
	}

	public List<ConsultaJuridica> listaAdvogado(String advogado) {
		List<ConsultaJuridica> listaAdvogado = new ArrayList<ConsultaJuridica>();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transacao = session.beginTransaction();
			listaAdvogado = (List<ConsultaJuridica>) session.createCriteria(ConsultaJuridica.class)
					.add(Restrictions.eq("fknMatriculaAdvogado.matricula", advogado)).list();
			transacao.commit();			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();		
			}
		}
		return listaAdvogado;
	}
	
}
