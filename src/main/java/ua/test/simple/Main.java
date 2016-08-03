package main.java.ua.test.simple;

import javax.mail.*;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Properties;

public class Main {


    static final private String MYEMAIL = "mail@ukr.net";
    static final private String MYPASS = "yourPass";

    private static Properties props;

    public static void main(String[] args) {
        try {
            send();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void send() throws FileNotFoundException {

        createProps();

        send("Hello", reader(), "mail@gmail.com", MYEMAIL);
    }

    private static void createProps() {
        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
    }

    public static String reader() throws FileNotFoundException {

        File result = new File("/home/james/workspace/tryAgain/tryAgain/src/main/java/information/info.txt");

        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(result.getAbsoluteFile()));
            try {
                String s;
                while ((s = reader.readLine()) != null) {
                    stringBuilder.append(s);
                    stringBuilder.append("\n");
                }

            } finally {
                reader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    public static void send(String subject, String text, String fromEmail, String toEmail) {
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, MYPASS);
            }
        });

        try {
            Message message = new MimeMessage(session);
            //від кого
            message.setFrom(new InternetAddress(fromEmail));
            //кому
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            //тема
            message.setSubject(subject);
            //текст
            message.setText(text);
            //відправка
            Transport.send(message);
            System.out.println("Well done");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
