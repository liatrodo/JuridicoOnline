package br.com.juridicoOnline.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

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

			//Criteria filtro = this.session.createCriteria(Usuario.class);
			//filtro.add(Restrictions.eq("matricula", matricula));
			//retorno = (Usuario) filtro.uniqueResult();
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

	public static void main(String[] args){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Integer funcao = 12345;
		Integer unidade = 7420;
		Usuario beltrano = new Usuario();
		beltrano.setMatricula("c031100");
		beltrano.setNome("silvana");
		beltrano.setSenha("12345");
		beltrano.setFuncao(funcao);
		beltrano.setfknUnidadeBase(unidade);
		usuarioDAO.incluir(beltrano);
		
	}

}
