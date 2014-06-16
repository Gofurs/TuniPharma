package tunipharma.Controllers;

import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;

import javax.mail.*; //gggg

import javax.mail.internet.*;

import com.sun.mail.smtp.*;


public class SendRecoveryEmail {

    @SuppressWarnings("empty-statement")
    public static void SendRecoveryEmail(String mail, String Content) throws Exception {
        Properties props = System.getProperties();
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.auth","true");
        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("devils.tunipharma@gmail.com"));
        msg.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse(mail, false));//@destinataire
        msg.setSubject("Recovery Password "+System.currentTimeMillis());
        msg.setText("Hey, we heard you lost your password. Say it ain't so!\n" +
"\n" +
"Your password:" +
"\n" + Content +
"\n" +
"\n" +
"Thanks,\n" +
"The TuniPharma Team");
        msg.setHeader("X-Mailer", "By Sicateur");
        msg.setSentDate(new Date());
        SMTPTransport t =(SMTPTransport)session.getTransport("smtps");
        t.connect("smtp.gmail.com", "devils.tunipharma@gmail.com", "password?123");
        t.sendMessage(msg, msg.getAllRecipients());
        System.out.println("Response: " + t.getLastServerResponse());
        System.out.println("message sent successfully....");
        t.close();
    }
}

