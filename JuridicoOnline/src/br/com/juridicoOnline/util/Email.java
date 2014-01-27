package br.com.juridicoOnline.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Email {
	@SuppressWarnings("deprecation")
	public void sendEmail(String destinatario, String nomeDestinatario, String origem, String assunto,
			String conteudoMensagem) throws EmailException {
		   SimpleEmail email = new SimpleEmail();
		   //Utilize o hostname do seu provedor de email
		   System.out.println("alterando hostname...");
		   email.setHostName("smtp.gmail.com");
		   //Quando a porta utilizada n�o � a padr�o (gmail = 465)
		   email.setSmtpPort(465);
		   //Adicione os destinat�rios
		   email.addTo(destinatario, nomeDestinatario);
		   //Configure o seu email do qual enviar�
		   email.setFrom(origem, "Consulta Online");
		   //Adicione um assunto
		   email.setSubject(assunto);
		   //Adicione a mensagem do email
		   email.setMsg(conteudoMensagem);
		   //Para autenticar no servidor � necess�rio chamar os dois m�todos abaixo
		   System.out.println("autenticando...");
		   email.setSSL(true);
		   email.setAuthentication("liatrodo@gmail.com", "Cota6060");
		   System.out.println("enviando...");
		   email.send();
		   System.out.println("Email enviado!");
		}
}
