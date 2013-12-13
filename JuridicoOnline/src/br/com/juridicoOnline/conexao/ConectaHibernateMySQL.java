package br.com.juridicoOnline.conexao;
import org.hibernate.Session;

import br.com.juridicoOnline.util.HibernateUtil;

public class ConectaHibernateMySQL {
	public static void main(String[] args) {
		Session sessao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			System.out.println("Connectou");
		} finally {
			sessao.close();
		}
	}
}
