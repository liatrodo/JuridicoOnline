package br.com.juridicoOnline.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.juridicoOnline.entity.AreaJuridica;
import br.com.juridicoOnline.entity.ConsultaJuridica;
import br.com.juridicoOnline.util.HibernateUtil;

public class AreaJuridicaDAO extends HibernateUtil {
	private Session session;

	public AreaJuridicaDAO() {

	}

	public void incluir(AreaJuridica aj) {
		try {
			session = (Session) HibernateUtil.getSessionFactory();
			session.beginTransaction();
			session.save(aj);
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

	public void alterar(AreaJuridica aj) {
		try {
			session = (Session) HibernateUtil.getSessionFactory();
			session.beginTransaction();
			session.update(aj);
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

	public void excluir(AreaJuridica[] aj) {
		try {
			session = (Session) HibernateUtil.getSessionFactory();
			session.beginTransaction();

			for (AreaJuridica deletar : aj) {
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

	public void excluir(AreaJuridica aj) {
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

	public AreaJuridica consultar(int codigo) {
		AreaJuridica retorno = new AreaJuridica();
		try {
			session = (Session) HibernateUtil.getSessionFactory();
			session.beginTransaction();
			retorno = (AreaJuridica) session.load(AreaJuridica.class, codigo);
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
	public List<AreaJuridica> listar() {
		System.out.println("estou na area juridica DAO");	
		List<AreaJuridica> lista = new ArrayList<AreaJuridica>();
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			lista = (List<AreaJuridica>) session.createCriteria(AreaJuridica.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("nao abriu");
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				System.out.println("abriu");
				session.close();		
			}
		}
		return lista;
	}
}
