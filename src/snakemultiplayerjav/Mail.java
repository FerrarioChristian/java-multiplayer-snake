package snakemultiplayerjav;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

	public static boolean mail(String _mail, String _utente) {
                
            String mail = _mail;
            final String username = "hardshop6@gmail.com";
            final String password = "progettoinfo";
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props,
              new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                    }
              });
            try {

                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("gianfranco@hotmail.com"));
                    message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(mail));
                    message.setSubject("Avviso registrazione");
                    message.setText("Ciao "+_utente+"! \nGrazie per esserti registrato a Snake2D. \nIl tuo account è stato attivato, ora puoi giocare al nostro videogioco sia in single player che in multyplayer. \n\nSe non sei stato tu a registrarti è possbile che qualcuno abbia utilizzato la tua mail per sbaglio. \nPer assistenza o chiarimenti chiama  +39 366 7077493 oppure +39 388 8171608. \n\nNon rispondere a questa mail. \nIdeato, realizzato e finanziato da Andrea Lozza e Christian Ferrario, buon divertimento.");

                    Transport.send(message); 
            }
            catch (MessagingException e) {
                    return false;
            }
            return true;    
        }
                 
}
