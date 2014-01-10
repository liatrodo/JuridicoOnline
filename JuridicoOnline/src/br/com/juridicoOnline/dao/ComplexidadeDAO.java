package br.com.juridicoOnline.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.juridicoOnline.entity.Complexidade;
import br.com.juridicoOnline.util.HibernateUtil;

public class ComplexidadeDAO extends HibernateUtil {

	private Session session;
	private Transaction transacao;

	public ComplexidadeDAO() {

	}

	public void incluir(Complexidade co) {
		try {
			session = (Session) HibernateUtil.getSessionFactory();
			session.beginTransaction();
			session.save(co);
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

	public void alterar(Complexidade co) {
		try {
			session = (Session) HibernateUtil.getSessionFactory();
			session.beginTransaction();
			session.update(co);
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

	public void excluir(Complexidade[] co) {
		try {
			session = (Session) HibernateUtil.getSessionFactory();
			session.beginTransaction();

			for (Complexidade deletar : co) {
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

	public void excluir(Complexidade co) {
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

	public Complexidade consultar(int codigo) {
		Complexidade retorno = new Complexidade();
		try {
			session = (Session) HibernateUtil.getSessionFactory();
			session.beginTransaction();
			retorno = (Complexidade) session.load(Complexidade.class, codigo);
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
	public List<Complexidade> listar() {
		System.out.println("estou na Complexidade DAO");	
		List<Complexidade> lista = new ArrayList<Complexidade>();
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			lista = (List<Complexidade>) session.createCriteria(Complexidade.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("nao abriu Complexidade");
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				System.out.println("abriu Complexidade");
				session.close();		
			}
		}
		return lista;
	}
}
