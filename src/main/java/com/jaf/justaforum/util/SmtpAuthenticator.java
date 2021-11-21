package com.jaf.justaforum.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SmtpAuthenticator extends Authenticator {
    public SmtpAuthenticator() {
        super();
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        String username = "justaforummail@gmail.com";
        String password = "zaq1@WSXX";

        return new PasswordAuthentication(username, password);

    }
}
