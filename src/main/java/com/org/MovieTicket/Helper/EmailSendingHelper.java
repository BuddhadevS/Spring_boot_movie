package com.org.MovieTicket.Helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy.Content;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

import com.org.MovieTicket.Dto.Booking;
import com.org.MovieTicket.Dto.Customer;
import com.org.MovieTicket.Dto.Theatre;

import ch.qos.logback.core.Context;
import jakarta.mail.internet.MimeMessage;
import jakarta.validation.Valid;

@Component
public class EmailSendingHelper {
	
	@Autowired
	JavaMailSender mailSender;

	@Autowired
	TemplateEngine templateEngine;

	public void sendMailToCustomer(Customer customer) {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setFrom("buddhadev0509@gmail.com", "Movie-Ticket-Site");
			helper.setTo(customer.getEmail());
			helper.setSubject("Email Verification OTP");
			org.thymeleaf.context.Context context = new org.thymeleaf.context.Context();
			context.setVariable("customer", customer);
			String body = templateEngine.process("my-email-template.html", context);
			helper.setText(body, true);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendMailToTheatre(@Valid Theatre theatre) {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setFrom("buddhadev0509@gmail.com", "Movie-Ticket-Site");
			helper.setTo(theatre.getEmail());
			helper.setSubject("Email Verification OTP");
			org.thymeleaf.context.Context context = new org.thymeleaf.context.Context();
			context.setVariable("customer", theatre);
			String body = templateEngine.process("my-email-template.html", context);
			helper.setText(body, true);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendBookingConfirmation(Customer customer, Booking booking) {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setFrom("buddhadev0509@gmail.com", "Movie-Ticket-Site");
			helper.setTo(customer.getEmail());
			helper.setSubject("Booking Confirmation");
			org.thymeleaf.context.Context context = new org.thymeleaf.context.Context();
			context.setVariable("customer", customer);
			context.setVariable("booking", booking);
			String body = templateEngine.process("booking-confirmation-template.html", context);
			helper.setText(body, true);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

