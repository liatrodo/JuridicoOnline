package br.com.juridicoOnline.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.juridicoOnline.entity.Assunto;
import br.com.juridicoOnline.entity.Nivel;
import br.com.juridicoOnline.util.HibernateUtil;

public class NivelDAO extends HibernateUtil {

	private Session session;
	private Transaction transacao;

	public NivelDAO() {

	}

	public Nivel consultar(int codigo) {
		Nivel retorno = new Nivel();
		try {
			session = (Session) HibernateUtil.getSessionFactory();
			session.beginTransaction();
			retorno = (Nivel) session.load(Nivel.class, codigo);
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
	public List<Nivel> listar() {
		System.out.println("estou no nivel DAO");	
		List<Nivel> lista = new ArrayList<Nivel>();
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			lista = (List<Nivel>) session.createCriteria(Nivel.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("nao abriu nivel");
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				System.out.println("abriu nivel");
				session.close();		
			}
		}
		return lista;
	}
}
