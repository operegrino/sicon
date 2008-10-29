/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Jonathan
 */
public class EnviarEmail {
    
    public EnviarEmail(){}

    /**
     * Envia o email para o fornecedor anexando o arquivo gerado na tela de pedido
     * @param CaminhoArquivo
     * @throws javax.mail.internet.AddressException
     * @throws javax.mail.MessagingException
     */
    public void EnviarEmailFornecedor(String CaminhoArquivo, Vector enviarPara) throws AddressException, MessagingException, FileNotFoundException, Exception{
        //java.security.Security.addProvider(new Provider());  
        InternetAddress[] endEle = new InternetAddress[enviarPara.size()];
        for (int i = 0; i < enviarPara.size(); i++) {
            String email = ((Vector)enviarPara.get(i)).get(0).toString();       
            endEle[i] = new InternetAddress(email);            
        }    
         Properties mailProps = new Properties();  
         mailProps.put("mail.transport.protocol", "smtp"); // diz que utilizarei um protocolo de seguran�a     
         mailProps.put("mail.smtp.starttls.enable", "true"); // diz que utilizarei o protocolo de seguran�a TLS     
         mailProps.put("mail.smtp.host", "smtp.gmail.com"); // diz que o servidor que estou mandando � o gmail     
         mailProps.put("mail.smtp.auth", "true"); // diz que � necess�rio uma autentica��o     
         mailProps.put("mail.smtp.user", "user@gmail.com");  
         mailProps.put("mail.debug", "true");  
         mailProps.put("mail.smtp.port", "465");  
         mailProps.put("mail.smtp.debug", "true");  
         mailProps.put("mail.mime.charset", "ISO-8859-1");  
         mailProps.put("mail.smtp.socketFactory.port", "465");  
         mailProps.put("mail.smtp.socketFactory.fallback", "false");  
         mailProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
         javax.mail.Authenticator auth = new Autenticacao();
         Session session = Session.getDefaultInstance(mailProps, auth);  
         
         
         Multipart mp = new MimeMultipart();    
         //Anexando o arquivo
         MimeBodyPart CorpoMensagem = new MimeBodyPart();
         CorpoMensagem.setText(ConfiguracoesStatic.getTextoMensagem());
         MimeBodyPart AnexoMensagem = new MimeBodyPart();         
         File arquivo = new File(CaminhoArquivo);
         if (!arquivo.exists()) {
             throw new FileNotFoundException();
         }
         AnexoMensagem.attachFile(arquivo);
         //mbp.setFileName("C:/Planilha.xls");         
         //mbp.setDisposition(Part.ATTACHMENT);  
         FileDataSource fds = new FileDataSource(CaminhoArquivo);
         AnexoMensagem.setDataHandler(new DataHandler(fds));  
         AnexoMensagem.setFileName(fds.getName());   
         mp.addBodyPart(CorpoMensagem);
         mp.addBodyPart(AnexoMensagem);          
   
         Message message = new MimeMessage(session);  
         message.setContent(mp);   
         message.setFrom(new InternetAddress("Jonathan"));
         message.setHeader("Disposition-Notification-To",ConfiguracoesStatic.getRemetente());           
         message.setRecipients(Message.RecipientType.TO, endEle);
         message.setSubject(ConfiguracoesStatic.getTituloMensagem());  
         //message.setContent(ConfiguracoesStatic.getTextoMensagem(), "text/html");  
         Transport.send(message);         

     } 
 
     private class Autenticacao extends javax.mail.Authenticator {  
   
        @Override
         public javax.mail.PasswordAuthentication getPasswordAuthentication() {  
             String user = ConfiguracoesStatic.getRemetente();  
             String pwd = ConfiguracoesStatic.getSenha();  
             return new javax.mail.PasswordAuthentication(user, pwd);  
         }  
     }             
}
