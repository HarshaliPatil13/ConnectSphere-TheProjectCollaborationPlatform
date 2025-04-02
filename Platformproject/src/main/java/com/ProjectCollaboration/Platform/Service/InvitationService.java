package com.ProjectCollaboration.Platform.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvitationService {

    @Autowired
    private EmailService emailService;

    public void sendInvitationEmail(String email, String subject, String body) {
        try {
            emailService.sendEmail(email, subject, body);
        } catch (Exception e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
    }
}
