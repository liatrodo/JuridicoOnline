package br.com.juridicoOnline.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import br.com.juridicoOnline.entity.AreaJuridica;
import br.com.juridicoOnline.entity.ConsultaJuridica;
import br.com.juridicoOnline.entity.Usuario;
import br.com.juridicoOnline.util.HibernateUtil;

public class UsuarioDAO {

	private Session session;
	private Transaction transacao;

	public void incluir(Usuario p) {
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.session.beginTransaction();
			this.session.save(p);
			this.transacao.commit();
			System.out.println("inseriu");
		} catch (HibernateException e) {
			System.out.println("Nao foi possivel inserir usuario. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.session.isOpen()) {
					session.close();		
				}
			} catch (Throwable e) {
				System.out.println("Erro ao fechar. Mensagem: " + e.getMessage());
			}
		}
	}
	
	public Usuario consultar(String matricula, String senha) {
		Usuario retorno = null;
		System.out.println("matricula:" + matricula);
		System.out.println("senha:" + senha);
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.session.beginTransaction();

			retorno = (Usuario) session.createCriteria(Usuario.class)
					.add(Restrictions.eq("matricula", matricula))
					.add(Restrictions.eq("senha", senha)).uniqueResult();			
			this.transacao.commit();
		} catch (Throwable e) {
			if (this.transacao.isActive()) {
				this.transacao.rollback();	
			}
		} finally {
			try {
				if (this.session.isOpen()) {
					session.close();		
				}
			} catch (Throwable e) {
				System.out.println("Erro ao fechar. Mensagem: " + e.getMessage());
			}
			
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listar(int funcao) {
		System.out.println("estou no usuario DAO");	
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			lista = (List<Usuario>) session.createCriteria(Usuario.class)
					.add(Restrictions.eq("funcao", funcao)).list();
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
