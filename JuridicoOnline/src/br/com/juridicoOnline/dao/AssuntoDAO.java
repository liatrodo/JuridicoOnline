package br.com.juridicoOnline.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.juridicoOnline.entity.AreaJuridica;
import br.com.juridicoOnline.entity.ConsultaJuridica;
import br.com.juridicoOnline.util.HibernateUtil;
import br.com.juridicoOnline.entity.Assunto;

public class AssuntoDAO extends HibernateUtil {

	private Session session;
	private Transaction transacao;

	public AssuntoDAO() {

	}

	public void incluir(Assunto as) {
		try {
			session = (Session) HibernateUtil.getSessionFactory();
			session.beginTransaction();
			session.save(as);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();		
			}
		}
	}

	public void alterar(Assunto as) {
		try {
			session = (Session) HibernateUtil.getSessionFactory();
			session.beginTransaction();
			session.update(as);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();		
			}
		}
	}

	public void excluir(Assunto[] as) {
		try {
			session = (Session) HibernateUtil.getSessionFactory();
			session.beginTransaction();

			for (Assunto deletar : as) {
				//deletar.setItAtivo(false);
				//session.update(deletar);
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();		
			}
		}
	}

	public void excluir(Assunto as) {
		try {
			session = (Session) HibernateUtil.getSessionFactory();
			session.beginTransaction();

			//aj.setItAtivo(false);
			//session.update(aj);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();		
			}
		}
	}

	public Assunto consultar(int codigo) {
		Assunto retorno = new Assunto();
		try {
			session = (Session) HibernateUtil.getSessionFactory();
			session.beginTransaction();
			retorno = (Assunto) session.load(Assunto.class, codigo);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();		
			}
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	public List<Assunto> listar() {
		System.out.println("estou na assunto DAO");	
		List<Assunto> lista = new ArrayList<Assunto>();
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			lista = (List<Assunto>) session.createCriteria(Assunto.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("nao abriu assunto");
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				System.out.println("abriu assunto");
				session.close();		
			}
		}
		return lista;
	}
}
