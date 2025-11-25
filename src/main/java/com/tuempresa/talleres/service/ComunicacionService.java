package com.tuempresa.talleres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ComunicacionService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmail(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            message.setFrom("talleres@empresa.com");
            
            mailSender.send(message);
            System.out.println("Email enviado a: " + to);
        } catch (Exception e) {
            System.err.println("Error enviando email: " + e.getMessage());
        }
    }

    public void enviarConfirmacionInscripcion(String email, String eventoNombre, String fecha) {
        String subject = "Confirmación de Inscripción - " + eventoNombre;
        String text = "Su inscripción al evento '" + eventoNombre + "' programado para " + fecha + " ha sido confirmada.\n\nGracias por participar.";
        
        enviarEmail(email, subject, text);
    }

    public void enviarRecordatorioEvento(String email, String eventoNombre, String fecha, String lugar) {
        String subject = "Recordatorio - Evento " + eventoNombre;
        String text = "Le recordamos que el evento '" + eventoNombre + "' se realizará el " + fecha + " en " + lugar + ".\n\n¡Esperamos verle allí!";
        
        enviarEmail(email, subject, text);
    }

    public void enviarCertificado(String email, String eventoNombre, String codigoCertificado) {
        String subject = "Certificado de Participación - " + eventoNombre;
        String text = "Felicitaciones por completar el evento '" + eventoNombre + "'.\n\nSu código de certificado es: " + codigoCertificado + "\n\nPuede descargarlo desde nuestro portal.";
        
        enviarEmail(email, subject, text);
    }
}