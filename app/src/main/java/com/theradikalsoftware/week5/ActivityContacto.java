package com.theradikalsoftware.week5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class ActivityContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Button sendEmailButton = findViewById(R.id.frag_contacto_button_enviar);
        sendEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendMail();
            }
        });
    }

    private void SendMail(){
        Properties props = new Properties();
        props.put("mail.smtp.host", "my-mail-server");
        Session session = Session.getInstance(props, null);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom("me@example.com");
            msg.setRecipients(Message.RecipientType.TO,
                    "you@example.com");
            msg.setSubject("JavaMail hello world example");
            msg.setSentDate(new Date());
            msg.setText(GetMessage());
            Transport.send(msg, "me@example.com", "my-password");
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
        }

    }


    private String GetSenderEmail() {
        TextView emailTXV = findViewById(R.id.frag_contacto_edittext_correo);
        return (String) emailTXV.getText();
    }

    private String GetMessage() {
        TextView messageTXV = findViewById(R.id.frag_contacto_edittext_mensaje);
        return (String) messageTXV.getText();
    }
}